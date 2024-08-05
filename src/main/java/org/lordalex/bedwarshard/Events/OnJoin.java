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
import org.lordalex.bedwarshard.Utils.GameUtil;
import org.lordalex.bedwarshard.Utils.YmlParser;
import org.lordalex.bedwarshard.config.Game;
import org.lordalex.bedwarshard.config.GameState;
import org.lordalex.bedwarshard.config.MapConfig;
import org.lordalex.bedwarshard.config.PlayerInfo;


public class OnJoin  implements Listener {
    @EventHandler
    public void onLogin(PlayerLoginEvent e) {
        Game game = BedWarsHard.getGame();
        GameState gameState = game.getGameState();
        MapConfig mapConfig = BedWarsHard.getMapConfig();
        int playersToStart = mapConfig.getTeamPlayers() * mapConfig.getTeams().size();
        int currentMapOnline = game.getPlayerInfoSet().size() + game.getSpectatorSet().size();

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
        int currentMapOnline = game.getPlayerInfoSet().size() + game.getSpectatorSet().size();

        if(gameState == GameState.WAITING || ((gameState == GameState.STARTING) && (currentMapOnline < playersToStart))){
            if (game.getPlayerInfo(player) == null){
                player.teleport(YmlParser.parseLocation(Bukkit.getWorld("world"), BedWarsHard.getMapConfig().getLobby()));
                game.addSpectatorSet(player);
            }

            GameUtil.clearPlayer(player);
            GameUtil.giveWaitingItems(player);
            e.setJoinMessage(ColorUtil.getMessage("[" + (currentMapOnline+1) + "/" + playersToStart + "] &e=> &fИгрок " + player.getName() + " подключился"));
        }
        else if(gameState == GameState.GAME){
            PlayerInfo playerInfo = game.getPlayerInfo(player);
            if (playerInfo != null && GameUtil.hasBed(playerInfo.getTeam())){
                GameUtil.clearPlayer(player);
                GameUtil.playerRespawn(playerInfo);
            }
            else{
                player.setGameMode(GameMode.SPECTATOR);
                player.teleport(YmlParser.parseLocation(Bukkit.getWorld("world"), BedWarsHard.getMapConfig().getLobby()));
                e.setJoinMessage(null);
                e.setJoinMessage(ColorUtil.getMessage("[" + (currentMapOnline+1) + "/" + playersToStart + "] &e=> &fИгрок " + player.getName() + " подключился"));
            }
        }
    }
}