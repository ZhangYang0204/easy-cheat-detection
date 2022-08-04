package pers.zhangyang.easycheatdetection.yaml;

import org.jetbrains.annotations.NotNull;
import pers.zhangyang.easylibrary.base.YamlBase;

public class MessageYaml extends YamlBase {

    public static final MessageYaml INSTANCE = new MessageYaml();

    private MessageYaml() {
        super("display/" + SettingYaml.INSTANCE.getDisplay() + "/message.yml");
    }

    @NotNull
    public String getReplaceNotifyCheatDetection() {
        String display = getStringDefault("message.component.notifyCheatDetection");
        if (display.isEmpty()) {
            display = backUpConfiguration.getString("message.component.notifyCheatDetection");
        }
        assert display != null;
        return display;
    }
}
