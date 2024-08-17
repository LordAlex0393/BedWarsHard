package org.lordalex.bedwarshard.Events;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.material.Bed;
import org.lordalex.bedwarshard.BedWarsHard;
import org.lordalex.bedwarshard.Utils.ColorUtil;
import org.lordalex.bedwarshard.Utils.CustomScoreboard;
import org.lordalex.bedwarshard.Utils.GameUtil;
import org.lordalex.bedwarshard.config.*;

public class OnQuit implements Listener {
    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        Player player = e.getPlayer();
        Game game = BedWarsHard.getGame();
        MapConfig mapConfig = BedWarsHard.getMapConfig();
        int playersToStart = mapConfig.getTeamPlayers() * mapConfig.getTeams().size();
        int online = Bukkit.getOnlinePlayers().size();

        PlayerInfo playerInfo = game.getPlayer(player);

        if (playerInfo != null) {
            e.setQuitMessage(ColorUtil.getMessage("[" + (online - 1) + "/" + playersToStart + "] &e=> &fИгрок &" + playerInfo.getTeam().getColor() + player.getName() + "&f вышел"));
            if (!playerInfo.getTeam().getBedStatus() || BedWarsHard.getGame().getGameState() == GameState.WAITING || BedWarsHard.getGame().getGameState() == GameState.STARTING) {
                game.removePlayer(player);
                game.addSpectator(player);
            }
        } else {
            e.setQuitMessage(ColorUtil.getMessage("[" + (online - 1) + "/" + playersToStart + "] &e=> &fИгрок " + player.getName() + " вышел"));
        }
        if (player.getGameMode() == GameMode.SPECTATOR) {
            e.setQuitMessage(null);
            game.removeSpectator(player);
        }
        for(Player all : Bukkit.getOnlinePlayers()){
            CustomScoreboard.updateScoreboard(all);
        }
    }
}
