package org.lordalex.bedwarshard.Events;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.lordalex.bedwarshard.BedWarsHard;
import org.lordalex.bedwarshard.Utils.ColorUtil;
import org.lordalex.bedwarshard.Utils.CustomScoreboard;
import org.lordalex.bedwarshard.Utils.YmlParser;
import org.lordalex.bedwarshard.config.BedTeam;
import org.lordalex.bedwarshard.config.GameState;
import org.lordalex.bedwarshard.config.PlayerInfo;

public class onBlockInteraction implements Listener {
    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {
        Player player = e.getPlayer();
        if (BedWarsHard.getGame().getBlocksLocationsSet().contains(e.getBlock().getLocation())) {
            BedWarsHard.getGame().removeBlockLocation(e.getBlock().getLocation());
        }
        else if(e.getBlock().getType() == Material.BED_BLOCK){
            for (String key : BedWarsHard.getMapConfig().getTeams().keySet()) {
                BedTeam team = BedWarsHard.getMapConfig().getTeams().get(key);
                for (String loc : team.getBed()) {
                    Location bedLocation = YmlParser.parseLocation(Bukkit.getWorld("world"), loc);

                    if (bedLocation.getBlockX() == e.getBlock().getLocation().getBlockX()
                            && bedLocation.getBlockY() == e.getBlock().getLocation().getBlockY()
                            && bedLocation.getBlockZ() == e.getBlock().getLocation().getBlockZ()) {

                        PlayerInfo playerInfo = BedWarsHard.getGame().getPlayer(player);
                        String colorCode = "";
                        if (playerInfo != null) colorCode += ("&" + playerInfo.getTeam().getColor());

                        if ((playerInfo != null && team != playerInfo.getTeam()) || player.getGameMode() == GameMode.CREATIVE) {
                            if(!BedWarsHard.getGame().isBedDrop()){
                                for (String locTemp : team.getBed()) {
                                    Location bedLocationTemp = YmlParser.parseLocation(Bukkit.getWorld("world"), locTemp);
                                    bedLocationTemp.getBlock().setType(Material.AIR);
                                }
                            }
                            team.setBedStatus(false);
                            for (Player all : e.getBlock().getWorld().getPlayers()) {
                                all.sendMessage(ColorUtil.getMessage("Игрок " + colorCode + player.getName() + "&f сломал&" + team.getColor() + team.getNames().split(",")[1]) + " кровать");
                                CustomScoreboard.updateScoreboard(all);
                            }
                            return;
                        }
                    }
                }
            }
            player.sendMessage(ColorUtil.getMessage("&cСовсем хардкорщик?! Нельзя ломать свою кровать!"));
            e.setCancelled(true);
        }
        else if (player.getGameMode() != GameMode.CREATIVE) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onBlockPlaceEvent(BlockPlaceEvent e) {
        Player player = e.getPlayer();
        if (BedWarsHard.getGame().getGameState() == GameState.WAITING || BedWarsHard.getGame().getGameState() == GameState.STARTING && player.getGameMode() != GameMode.CREATIVE) {
            e.setCancelled(true);
        }
        else if(e.getBlock().getType() == Material.BED_BLOCK) {
            for (String key : BedWarsHard.getMapConfig().getTeams().keySet()) {
                BedTeam team = BedWarsHard.getMapConfig().getTeams().get(key);
                for (String loc : team.getBed()) {
                    Location bedLocation = YmlParser.parseLocation(Bukkit.getWorld("world"), loc);
                    if (bedLocation.getBlockX() == e.getBlock().getLocation().getBlockX()
                            && bedLocation.getBlockY() == e.getBlock().getLocation().getBlockY()
                            && bedLocation.getBlockZ() == e.getBlock().getLocation().getBlockZ()) {
                        PlayerInfo playerInfo = BedWarsHard.getGame().getPlayer(player);
                        String colorCode = "";
                        if (playerInfo != null) colorCode += ("&" + playerInfo.getTeam().getColor());

                        team.setBedStatus(true);
                        for(Player teamPlayer : team.getPlayerSet()){
                            if(teamPlayer.getGameMode() == GameMode.SPECTATOR){
                                teamPlayer.spigot().respawn();
                            }
                        }
                        for (Player all : e.getBlock().getWorld().getPlayers()) {
                            all.sendMessage(ColorUtil.getMessage("Игрок " + colorCode + player.getName() + "&f восстановил&" + team.getColor() + team.getNames().split(",")[1]) + " кровать");
                            CustomScoreboard.updateScoreboard(all);
                        }
                        return;
                    }
                }
            }
            player.sendMessage(ColorUtil.getMessage("&cКого пытаешься обмануть?! Кровать нельзя ставить в другое место!"));
            e.setCancelled(true);
        }
        else {
            BedWarsHard.getGame().addBlock(e.getBlock().getLocation());
        }

    }
}