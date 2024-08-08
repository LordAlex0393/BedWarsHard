package org.lordalex.bedwarshard.Events;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.lordalex.bedwarshard.BedWarsHard;
import org.lordalex.bedwarshard.Utils.ColorUtil;
import org.lordalex.bedwarshard.Utils.CustomScoreboard;
import org.lordalex.bedwarshard.Utils.GameUtil;
import org.lordalex.bedwarshard.Utils.YmlParser;
import org.lordalex.bedwarshard.config.Game;
import org.lordalex.bedwarshard.config.GameState;
import org.lordalex.bedwarshard.config.MapConfig;
import org.lordalex.bedwarshard.config.PlayerInfo;


public class OnJoin implements Listener {
    @EventHandler
    public void onLogin(PlayerLoginEvent e) {
        Game game = BedWarsHard.getGame();
        GameState gameState = game.getGameState();
        MapConfig mapConfig = BedWarsHard.getMapConfig();
        int playersToStart = mapConfig.getTeamPlayers() * mapConfig.getTeams().size();
        int currentMapOnline = game.getPlayerSet().size() + game.getSpectatorSet().size();

        if((gameState == GameState.STARTING) && (currentMapOnline >= playersToStart)){
            e.setKickMessage(ColorUtil.getMessage("&c" + e.getHostname()));
            e.disallow(PlayerLoginEvent.Result.KICK_FULL, ColorUtil.getMessage("Идет отсчёт до начала игры"));
        }
        else if(gameState == GameState.ENDING){
            e.setKickMessage(ColorUtil.getMessage("&c" + e.getHostname()));
            e.disallow(PlayerLoginEvent.Result.KICK_FULL, ColorUtil.getMessage("Идет завершение игры"));
        }
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        Game game = BedWarsHard.getGame();
        GameState gameState = game.getGameState();
        MapConfig mapConfig = BedWarsHard.getMapConfig();
        int playersToStart = mapConfig.getTeamPlayers() * mapConfig.getTeams().size();
        int online = Bukkit.getOnlinePlayers().size();
        PlayerInfo playerInfo = game.getPlayer(player);

        if(gameState == GameState.WAITING || ((gameState == GameState.STARTING) && (Bukkit.getOnlinePlayers().size() < playersToStart))){
            if (playerInfo == null){
                player.teleport(YmlParser.parseLocation(Bukkit.getWorld("world"), BedWarsHard.getMapConfig().getLobby()));
                game.addSpectator(player);
                e.setJoinMessage(ColorUtil.getMessage("[" + online + "/" + playersToStart + "] &e=> &fИгрок " + player.getName() + " подключился"));
            }
            else{
                e.setJoinMessage(ColorUtil.getMessage("[" + online + "/" + playersToStart + "] &e=> &fИгрок &" + playerInfo.getTeam().getColor() + player.getName() + "&f подключился"));
            }

            GameUtil.clearPlayer(player);
            GameUtil.giveWaitingItems(player);

        }
        else if(gameState == GameState.GAME){
            if (playerInfo != null && GameUtil.hasBed(playerInfo.getTeam())){
                e.setJoinMessage(ColorUtil.getMessage("[" + online + "/" + playersToStart + "] &e=> &fИгрок &" + playerInfo.getTeam().getColor() + player.getName() + "&f подключился"));
                GameUtil.clearPlayer(player);
                GameUtil.playerRespawn(playerInfo);
            }
            else{
                player.setGameMode(GameMode.SPECTATOR);
                player.teleport(YmlParser.parseLocation(Bukkit.getWorld("world"), BedWarsHard.getMapConfig().getLobby()));
                e.setJoinMessage(null);
            }
        }
        for(Player all : Bukkit.getOnlinePlayers()){
            CustomScoreboard.updateScoreboard(all);
        }
    }
}