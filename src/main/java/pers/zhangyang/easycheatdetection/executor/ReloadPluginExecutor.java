package pers.zhangyang.easycheatdetection.executor;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import pers.zhangyang.easycheatdetection.manager.GamerManager;
import pers.zhangyang.easycheatdetection.yaml.MessageYaml;
import pers.zhangyang.easylibrary.base.ExecutorBase;
import pers.zhangyang.easylibrary.util.MessageUtil;

public class ReloadPluginExecutor extends ExecutorBase {


    public ReloadPluginExecutor(@NotNull CommandSender sender, String commandName, @NotNull String[] args) {
        super(sender, commandName, args);
    }

    @Override
    protected void run() {
        if (args.length != 0) {
            return;
        }
        for (Player p : Bukkit.getOnlinePlayers()) {
            GamerManager.INSTANCE.getGamer(p).setVerify(false);
        }

        MessageUtil.sendMessageTo(sender, MessageYaml.INSTANCE.getStringList("message.chat.reloadPlugin"));
    }
}
