package org.lordalex.bedwarshard.config;

import org.bukkit.entity.Player;

public class PlayerInfo {
    private final Player player;
    private BedTeam team;
    private int spentGold = 0;
    private int spentIron = 0;
    private int spentBronze = 0;
    private int aliveTime = 0;
    private int kills = 0;
    private int death = 0;
    private int brokenBeds = 0;
    private boolean dead = false;

    public PlayerInfo(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    public BedTeam getTeam() {
        return team;
    }

    public void setTeam(BedTeam team) {
        this.team = team;
    }

    public int getSpentGold() {
        return spentGold;
    }

    public void setSpentGold(int spentGold) {
        this.spentGold = spentGold;
    }

    public int getSpentIron() {
        return spentIron;
    }

    public void setSpentIron(int spentIron) {
        this.spentIron = spentIron;
    }

    public int getSpentBronze() {
        return spentBronze;
    }

    public void setSpentBronze(int spentBronze) {
        this.spentBronze = spentBronze;
    }

    public int getAliveTime() {
        return aliveTime;
    }

    public void setAliveTime(int aliveTime) {
        this.aliveTime = aliveTime;
    }

    public int getKills() {
        return kills;
    }

    public void setKills(int kills) {
        this.kills = kills;
    }

    public int getDeath() {
        return death;
    }

    public void setDeath(int death) {
        this.death = death;
    }

    public int getBrokenBeds() {
        return brokenBeds;
    }

    public void setBrokenBeds(int brokenBeds) {
        this.brokenBeds = brokenBeds;
    }

    public boolean isDead() {
        return dead;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }
}
