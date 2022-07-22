package pers.zhangyang.easycheatdetection.domain;

import org.bukkit.entity.Player;

public class Gamer {
    private final Player player;
    private boolean verify;

    public Gamer(Player player) {
        this.player = player;
        verify = false;
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
