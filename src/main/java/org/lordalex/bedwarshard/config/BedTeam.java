package org.lordalex.bedwarshard.config;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.lordalex.bedwarshard.BedWarsHard;

import java.util.HashSet;
import java.util.List;

public class BedTeam {
    private String names;
    private String color;
    private int wool;
    private List<String> spawns;
    private List<String> bed;
    private List<String> villagers;
    private List<String> bronzeSpawns;
    private List<String> ironSpawns;
    private HashSet<Player> playerSet = new HashSet<>();
    private boolean BedStatus = true;
    private Inventory teamChestInventory = Bukkit.createInventory(null, 27, "Командный сундук");

    public Inventory getTeamChestInventory() {
        return teamChestInventory;
    }

    public void setTeamChestInventory(Inventory teamChestInventory) {
        this.teamChestInventory = teamChestInventory;
    }

    public HashSet<Player> getPlayerSet() {
        return playerSet;
    }

    public void addPlayer(Player player) {
        playerSet.add(player);
    }

    public void removePlayer(Player player) {
        playerSet.remove(player);
    }

    public boolean getBedStatus() {
        return BedStatus;
    }

    public void setBedStatus(boolean bedStatus) {
        BedStatus = bedStatus;
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

    public HashSet<PlayerInfo> getAlivePlayersInfo() {
        HashSet<PlayerInfo> playerInfoHashSet = new HashSet<>();
        for (Player player : playerSet) {
            PlayerInfo playerInfo = BedWarsHard.getGame().getPlayer(player);
            if (playerInfo.isAlive()) {
                playerInfoHashSet.add(playerInfo);
            }
        }
        return playerInfoHashSet;
    }
}