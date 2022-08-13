package pers.zhangyang.easycheatdetection.listener;

import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import pers.zhangyang.easycheatdetection.domain.Gamer;
import pers.zhangyang.easycheatdetection.manager.GamerManager;
import pers.zhangyang.easycheatdetection.yaml.MessageYaml;
import pers.zhangyang.easylibrary.annotation.EventListener;

@EventListener
public class PlayerMove implements Listener {
    @EventHandler
    public void on(PlayerMoveEvent event) {
        Gamer gamer = GamerManager.INSTANCE.getGamer(event.getPlayer());
        if (gamer.isVerify()) {
            return;
        }
        event.setCancelled(true);
        BaseComponent verify = new TextComponent(ChatColor.translateAlternateColorCodes('&',
                MessageYaml.INSTANCE.getNonemptyStringDefault("message.component.notifyCheatDetection")));
        verify.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, gamer.getCode()));
        gamer.getPlayer().spigot().sendMessage(verify);
    }
}