package org.lordalex.bedwarshard.config;


import org.bukkit.entity.Player;

import java.util.*;

public class Game {
    private HashMap<Player, PlayerInfo> playerInfoMap;
    private Set<PlayerInfo> playerInfoSet;
    private Set<Player> spectatorSet;
    private GameState gameState = GameState.WAITING;
    private boolean kickOnLose = false;
    private boolean protectedWorld = true;
    private float goldRate = 1.0f;
    private float ironRate = 1.0f;
    private float bronzeRate = 1.0f;
    private int finalDM = 0;
    private boolean editShop = false;
    private boolean limitPlayers = true;
    private int gameLength = 60;

    public Game() {
        playerInfoMap = new HashMap<>();
        playerInfoSet = new HashSet<>();
        spectatorSet = new HashSet<>();
    }

    public PlayerInfo getPlayerInfo(Player player){
        return this.playerInfoMap.get(player);
    }
    public void removePlayerInfo(PlayerInfo playerInfo){
        this.playerInfoSet.remove(playerInfo);
        this.playerInfoMap.remove(playerInfo);
    }
    public void addPlayerInfo(Player player){
        PlayerInfo playerInfo = new PlayerInfo(player);
        this.playerInfoSet.add(playerInfo);
        this.playerInfoMap.put(player, playerInfo);
        System.out.println(playerInfoSet.toString());
    }

    public Set<PlayerInfo> getPlayerInfoSet() {
        return playerInfoSet;
    }

    public void addPlayerInfoList(PlayerInfo playerInfo) {
        this.playerInfoSet.add(playerInfo);
    }

    public void removePlayerInfoSet(PlayerInfo playerInfo) {
        this.playerInfoSet.remove(playerInfo);
    }

    public Set<Player> getSpectatorSet() {
        return spectatorSet;
    }

    public void addSpectatorSet(Player player) {
        this.spectatorSet.add(player);
        System.out.println(spectatorSet.toString());
    }

    public void removeSpectatorSet(Player player) {
        this.spectatorSet.remove(player);
    }


    public HashMap<Player, PlayerInfo> getPlayerInfoMap() {
        return playerInfoMap;
    }

    public void setPlayerInfoMap(HashMap<Player, PlayerInfo> playerInfoMap) {
        this.playerInfoMap = playerInfoMap;
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
}
