package pers.zhangyang.easycheatdetection.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.scheduler.BukkitRunnable;
import pers.zhangyang.easycheatdetection.EasyCheatDetection;
import pers.zhangyang.easycheatdetection.manager.GamerManager;
import pers.zhangyang.easycheatdetection.yaml.MessageYaml;
import pers.zhangyang.easylibrary.annotation.EventListener;
import pers.zhangyang.easylibrary.util.MessageUtil;

@EventListener
public class PlayerVerify implements Listener {
    @EventHandler
    public void on(AsyncPlayerChatEvent event) {

        Player player = event.getPlayer();
        String message = event.getMessage();
        if (!message.equalsIgnoreCase(".verify")) {
            return;
        }
        event.setCancelled(true);
        new BukkitRunnable() {
            @Override
            public void run() {
                GamerManager.INSTANCE.getGamer(player).setVerify(true);
                MessageUtil.sendMessageTo(player, MessageYaml.INSTANCE.getStringList("message.chat.verify"));

            }
        }.runTask(EasyCheatDetection.instance);
    }

}