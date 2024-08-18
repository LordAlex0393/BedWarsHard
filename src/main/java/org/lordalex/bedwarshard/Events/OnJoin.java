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
import org.lordalex.bedwarshard.config.*;

import java.util.Random;


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
        PlayerInfo playerInfo = BedWarsHard.getGame().getPlayer(player);

        if(gameState == GameState.WAITING || gameState == GameState.STARTING){
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

            if (Bukkit.getOnlinePlayers().size() >= playersToStart) {
                GameUtil.start();
            }
        }
        else if(gameState == GameState.GAME){
            GameUtil.clearPlayer(player);
            if (playerInfo != null && playerInfo.getTeam().getBedStatus()){
                player.setCustomName("§" + playerInfo.getTeam().getColor() + player.getName());
                player.setCustomNameVisible(true);
                player.setPlayerListName(ColorUtil.getMessage("&" + playerInfo.getTeam().getColor() + player.getName()));
                e.setJoinMessage(ColorUtil.getMessage("[" + online + "/" + playersToStart + "] &e=> &fИгрок &" + playerInfo.getTeam().getColor() + player.getName() + "&f подключился"));
                BedTeam team = playerInfo.getTeam();
                player.sendMessage("Вы переподключились к игре");

                Random rand = new Random();
                int spawnNumber = rand.nextInt(team.getSpawns().size());
                player.teleport(YmlParser.parseLocation(Bukkit.getWorld("world"), playerInfo.getTeam().getSpawns().get(spawnNumber)));
                GameUtil.giveStartKit(player);
            }
            else{
                player.setGameMode(GameMode.SPECTATOR);
                player.setPlayerListName(null);
                player.teleport(YmlParser.parseLocation(Bukkit.getWorld("world"), BedWarsHard.getMapConfig().getLobby()));
                e.setJoinMessage(null);
            }
        }
        else if(Bukkit.getOnlinePlayers().size() >= playersToStart){
            GameUtil.start();
            return;
        }
        for(Player all : Bukkit.getOnlinePlayers()){
            CustomScoreboard.updateScoreboard(all);
        }
    }
}