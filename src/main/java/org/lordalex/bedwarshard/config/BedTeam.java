package org.lordalex.bedwarshard.config;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BedTeam {
    private String names;
    private String color;
    private int wool;
    private List<String> spawns;
    private List<String> bed;
    private List<String> villagers;
    private List<String> bronzeSpawns;
    private List<String> ironSpawns;
    private HashSet<PlayerInfo> playerSet = new HashSet<>();

    public HashSet<PlayerInfo> getPlayerSet() {
        return playerSet;
    }
    public void addPlayer(PlayerInfo playerInfo) {
        playerSet.add(playerInfo);
    }
    public void removePlayer(PlayerInfo playerInfo) {
        playerSet.remove(playerInfo);
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getWool() {
        return wool;
    }

    public void setWool(int wool) {
        this.wool = wool;
    }

    public List<String> getSpawns() {
        return spawns;
    }

    public void setSpawns(List<String> spawns) {
        this.spawns = spawns;
    }

    public List<String> getBed() {
        return bed;
    }

    public void setBed(List<String> bed) {
        this.bed = bed;
    }

    public List<String> getVillagers() {
        return villagers;
    }

    public void setVillagers(List<String> villagers) {
        this.villagers = villagers;
    }

    public List<String> getBronzeSpawns() {
        return bronzeSpawns;
    }

    public void setBronzeSpawns(List<String> bronzeSpawns) {
        this.bronzeSpawns = bronzeSpawns;
    }

    public List<String> getIronSpawns() {
        return ironSpawns;
    }

    public void setIronSpawns(List<String> ironSpawns) {
        this.ironSpawns = ironSpawns;
    }
}