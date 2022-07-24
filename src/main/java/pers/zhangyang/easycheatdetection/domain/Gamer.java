package pers.zhangyang.easycheatdetection.domain;

import org.bukkit.entity.Player;

import java.util.Random;

public class Gamer {
    private final Player player;
    private boolean verify;
    private String code= ".";

    public Gamer(Player player) {
        this.player = player;
        verify = false;
        for (int i = 0; i < 100; i++) {
            code=code+new Random().nextInt(10);
        }
    }

    public String getCode() {
        return code;
    }

    public Player getPlayer() {
        return player;
    }

    public boolean isVerify() {
        return verify;
    }

    public void setVerify(boolean var) {
        this.verify = var;
    }
}
