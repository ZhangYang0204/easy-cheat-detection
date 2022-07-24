package pers.zhangyang.easycheatdetection;

import org.bstats.bukkit.Metrics;
import pers.zhangyang.easylibrary.EasyPlugin;

public class EasyCheatDetection extends EasyPlugin {
    @Override
    public void onOpen() {

        // bStats统计信息
        new Metrics(EasyCheatDetection.instance, 15901);

    }

    @Override
    public void onClose() {
    }


}
