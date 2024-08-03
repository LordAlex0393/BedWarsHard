package org.lordalex.bedwarshard.config;

import java.util.HashMap;
import java.util.List;

public class BedMap {
    private String name;
    private String world;
    private String lobby;
    private int teamPlayers;
    private int bronzeFrequency;
    private int ironFrequency;
    private int goldFrequency;
    private List<String> goldSpawns;
    private HashMap<String, BedTeam> teams;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWorld() {
        return world;
    }

    public void setWorld(String world) {
        this.world = world;
    }

    public String getLobby() {
        return lobby;
    }

    public void setLobby(String lobby) {
        this.lobby = lobby;
    }

    public int getTeamPlayers() {
        return teamPlayers;
    }

    public void setTeamPlayers(int teamPlayers) {
        this.teamPlayers = teamPlayers;
    }

    public int getBronzeFrequency() {
        return bronzeFrequency;
    }

    public void setBronzeFrequency(int bronzeFrequency) {
        this.bronzeFrequency = bronzeFrequency;
    }

    public int getIronFrequency() {
        return ironFrequency;
    }

    public void setIronFrequency(int ironFrequency) {
        this.ironFrequency = ironFrequency;
    }

    public int getGoldFrequency() {
        return goldFrequency;
    }

    public void setGoldFrequency(int goldFrequency) {
        this.goldFrequency = goldFrequency;
    }

    public List<String> getGoldSpawns() {
        return goldSpawns;
    }

    public void setGoldSpawns(List<String> goldSpawns) {
        this.goldSpawns = goldSpawns;
    }

    public HashMap<String, BedTeam> getTeams() {
        return teams;
    }

    public void setTeams(HashMap<String, BedTeam> teams) {
        this.teams = teams;
    }
}