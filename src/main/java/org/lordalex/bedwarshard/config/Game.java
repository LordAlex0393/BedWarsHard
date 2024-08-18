package org.lordalex.bedwarshard.config;


import org.bukkit.entity.Player;
import org.lordalex.bedwarshard.BedWarsHard;

import java.util.*;

public class Game {
    private HashMap<UUID, PlayerInfo> playerInfoMap;
    private Set<Player> playerSet;
    private Set<Player> spectatorSet;
    private GameState gameState = GameState.WAITING;
    private boolean kickOnLose = false;
    private boolean protectedWorld = true;
    private float goldRate = 2.5f;
    private float ironRate = 2.5f;
    private float bronzeRate = 2.5f;
    private int finalDM = 0;
    private boolean editShop = false;
    private boolean limitPlayers = true;
    private int gameLength = 60;
    private int startingDelay = 10;

    public Game() {
        playerInfoMap = new HashMap<>();
        playerSet = new HashSet<>();
        spectatorSet = new HashSet<>();
    }

    public PlayerInfo getPlayer(Player player){
        return this.playerInfoMap.get(player.getUniqueId());
    }
    public void removePlayer(Player player){
        this.playerSet.remove(player);
        this.playerInfoMap.remove(player.getUniqueId());
        for (String k : BedWarsHard.getMapConfig().getTeams().keySet()) {
            BedWarsHard.getMapConfig().getTeams().get(k).removePlayer(player);
        }
    }
    public Set<Player> getPlayerSet() {
        return playerSet;
    }

    public void addPlayerInfo(PlayerInfo playerInfo) {
        this.playerSet.add(playerInfo.getPlayer());
        this.playerInfoMap.put(playerInfo.getPlayer().getUniqueId(), playerInfo);
    }

    public Set<Player> getSpectatorSet() {
        return spectatorSet;
    }

    public void addSpectator(Player player) {
        this.spectatorSet.add(player);
    }

    public void removeSpectator(Player player) {
        this.spectatorSet.remove(player);
    }


    public HashMap<UUID, PlayerInfo> getPlayerInfoMap() {
        return playerInfoMap;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public boolean isKickOnLose() {
        return kickOnLose;
    }

    public void setKickOnLose(boolean kickOnLose) {
        this.kickOnLose = kickOnLose;
    }

    public boolean isProtectedWorld() {
        return protectedWorld;
    }

    public void setProtectedWorld(boolean protectedWorld) {
        this.protectedWorld = protectedWorld;
    }

    public float getGoldRate() {
        return goldRate;
    }

    public void setGoldRate(float goldRate) {
        this.goldRate = goldRate;
    }

    public float getIronRate() {
        return ironRate;
    }

    public void setIronRate(float ironRate) {
        this.ironRate = ironRate;
    }

    public float getBronzeRate() {
        return bronzeRate;
    }

    public void setBronzeRate(float bronzeRate) {
        this.bronzeRate = bronzeRate;
    }

    public int getFinalDM() {
        return finalDM;
    }

    public void setFinalDM(int finalDM) {
        this.finalDM = finalDM;
    }

    public boolean isEditShop() {
        return editShop;
    }

    public void setEditShop(boolean editShop) {
        this.editShop = editShop;
    }

    public boolean isLimitPlayers() {
        return limitPlayers;
    }

    public void setLimitPlayers(boolean limitPlayers) {
        this.limitPlayers = limitPlayers;
    }

    public int getGameLength() {
        return gameLength;
    }

    public void setGameLength(int gameLength) {
        this.gameLength = gameLength;
    }

    public int getStartingDelay() {
        return startingDelay;
    }

    public void setStartingDelay(int startingDelay) {
        this.startingDelay = startingDelay;
    }
}
