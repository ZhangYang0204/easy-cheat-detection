package pers.zhangyang.easycheatdetection.yaml;

import org.jetbrains.annotations.NotNull;
import pers.zhangyang.easylibrary.base.YamlBase;

public class SettingYaml extends YamlBase {

    public static final SettingYaml INSTANCE = new SettingYaml();

    private SettingYaml() {
        super("setting.yml");
    }


    @NotNull
    public String getDisplay() {
        String display = getStringDefault("setting.display");
        if (!display.equalsIgnoreCase("default")
                && !display.equalsIgnoreCase("english")) {
            display = backUpConfiguration.getString("setting.display");
        }
        assert display != null;
        return display;
    }

}
