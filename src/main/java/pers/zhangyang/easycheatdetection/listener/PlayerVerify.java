package pers.zhangyang.easycheatdetection.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.scheduler.BukkitRunnable;
import pers.zhangyang.easycheatdetection.EasyCheatDetection;
import pers.zhangyang.easycheatdetection.domain.Gamer;
import pers.zhangyang.easycheatdetection.manager.GamerManager;
import pers.zhangyang.easycheatdetection.yaml.MessageYaml;
import pers.zhangyang.easylibrary.annotation.EventListener;
import pers.zhangyang.easylibrary.util.MessageUtil;

@EventListener
public class PlayerVerify implements Listener {
    @EventHandler(priority = EventPriority.HIGHEST)
    public void on(AsyncPlayerChatEvent event) {

        Gamer gamer=GamerManager.INSTANCE.getGamer(event.getPlayer());
        String message = event.getMessage();
        if (!message.equalsIgnoreCase(gamer.getCode())) {
            return;
        }
        event.setCancelled(true);
        new BukkitRunnable() {
            @Override
            public void run() {
                gamer.setVerify(true);
                MessageUtil.sendMessageTo(gamer.getPlayer(), MessageYaml.INSTANCE.getStringList("message.chat.verify"));

            }
        }.runTask(EasyCheatDetection.instance);
    }

}