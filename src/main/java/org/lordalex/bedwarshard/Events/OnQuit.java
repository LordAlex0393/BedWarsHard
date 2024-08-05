package org.lordalex.bedwarshard.Events;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.lordalex.bedwarshard.BedWarsHard;
import org.lordalex.bedwarshard.Utils.ColorUtil;
import org.lordalex.bedwarshard.Utils.GameUtil;
import org.lordalex.bedwarshard.config.Game;
import org.lordalex.bedwarshard.config.MapConfig;
import org.lordalex.bedwarshard.config.PlayerInfo;

public class OnQuit implements Listener {
    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        Player player = e.getPlayer();
        Game game = BedWarsHard.getGame();
        MapConfig mapConfig = BedWarsHard.getMapConfig();
        int playersToStart = mapConfig.getTeamPlayers() * mapConfig.getTeams().size();
        int online = Bukkit.getOnlinePlayers().size();

        PlayerInfo playerInfo = game.getPlayerInfo(player);

        if (playerInfo != null) {
            e.setQuitMessage(ColorUtil.getMessage("[" + (online - 1) + "/" + playersToStart + "] &e=> &fИгрок &" + playerInfo.getTeam().getColor() + player.getName() + "&f вышел"));
            if (!GameUtil.hasBed(playerInfo.getTeam())) {
                game.removePlayerInfo(playerInfo);
            }
        } else {
            e.setQuitMessage(ColorUtil.getMessage("[" + (online - 1) + "/" + playersToStart + "] &e=> &fИгрок " + player.getName() + " вышел"));
        }
        if (player.getGameMode() == GameMode.SPECTATOR) {
            e.setQuitMessage(null);
            game.removeSpectator(player);
        }
    }
}
