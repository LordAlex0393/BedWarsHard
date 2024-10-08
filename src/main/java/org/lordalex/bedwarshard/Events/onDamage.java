package org.lordalex.bedwarshard.Events;

import org.bukkit.*;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.lordalex.bedwarshard.BedWarsHard;
import org.lordalex.bedwarshard.Utils.ColorUtil;
import org.lordalex.bedwarshard.Utils.CustomScoreboard;
import org.lordalex.bedwarshard.Utils.GameUtil;
import org.lordalex.bedwarshard.Utils.YmlParser;
import org.lordalex.bedwarshard.config.BedTeam;
import org.lordalex.bedwarshard.config.GameState;
import org.lordalex.bedwarshard.config.PlayerInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class onDamage implements Listener {


    @EventHandler
    public void onEntityDamageByEntityEvent(EntityDamageByEntityEvent e) {
        if (!(e.getEntity() instanceof Player)) {
            e.setCancelled(true);
        } else if (BedWarsHard.getGame().getGameState() == GameState.GAME) {
            Player victim = (Player) e.getEntity();
            PlayerInfo victimInfo = BedWarsHard.getGame().getPlayer(victim);
            if ((e.getDamager() instanceof Player) && (e.getEntity() instanceof Player)) {
                Player damager = (Player) e.getDamager();
                PlayerInfo damagerInfo = BedWarsHard.getGame().getPlayer(damager);
                if (damagerInfo != null && damagerInfo.getTeam().equals(victimInfo.getTeam())) {
                    e.setCancelled(true);
                }
            }
            if (e.getDamager() instanceof Arrow) {
                Arrow arrow = (Arrow) e.getDamager();
                if (arrow.getShooter() instanceof Player) {
                    Player shooter = (Player) arrow.getShooter();
                    PlayerInfo shooterInfo = BedWarsHard.getGame().getPlayer(shooter);
                    if (shooterInfo != null && shooterInfo.getTeam().equals(victimInfo.getTeam())) {
                        e.setCancelled(true);
                    }
                }
            }
        }
    }

    @EventHandler
    public void onEntityDamage(EntityDamageEvent e) {
        if (BedWarsHard.getGame().getGameState() != GameState.GAME) {
            e.setCancelled(true);
        }
        if (e.getCause() == EntityDamageEvent.DamageCause.VOID) {
            e.setDamage(99999);
            Player player = (Player) e.getEntity();
            if (BedWarsHard.getGame().getPlayer(player) == null) {
                player.teleport(YmlParser.parseLocation(player.getWorld(), BedWarsHard.getMapConfig().getLobby()));
            }
        }
        System.out.println(e.getCause());
    }

    @EventHandler
    public void onPlayerRespawnEvent(PlayerRespawnEvent e) {
        PlayerInfo playerInfo = BedWarsHard.getGame().getPlayer(e.getPlayer());
        if (playerInfo != null) {
            if (playerInfo.getTeam().getBedStatus()) {
                GameUtil.playerRespawn(playerInfo);
            } else {
                e.getPlayer().setGameMode(GameMode.SPECTATOR);
            }
        }
    }

    @EventHandler
    public void onPlayerDeathEvent(PlayerDeathEvent e) {
        if (BedWarsHard.getGame().isPlayerDrop()) {
            e.getDrops().removeIf(drop -> drop.getType() != Material.CLAY_BRICK && drop.getType() != Material.IRON_INGOT && drop.getType() != Material.GOLD_INGOT);
        } else {
            e.getDrops().clear();
        }
        Player victim = e.getEntity();
        Player killer = e.getEntity().getKiller();


        if (BedWarsHard.getGame().getPlayerInfoMap().containsKey(victim.getUniqueId())) {
            PlayerInfo victimInfo = BedWarsHard.getGame().getPlayer(victim);
            if (e.getEntity().getKiller() instanceof Player && BedWarsHard.getGame().getPlayerInfoMap().containsKey(killer.getUniqueId())) {
                PlayerInfo killerInfo = BedWarsHard.getGame().getPlayer(killer);
                e.setDeathMessage(ColorUtil.getMessage("Игрок &" + victimInfo.getTeam().getColor() + victim.getName() + "&f убит игроком &" + killerInfo.getTeam().getColor() + killer.getName()));

                victimInfo.setDeaths(victimInfo.getDeaths() + 1);
                killerInfo.setKills(killerInfo.getKills() + 1);
                CustomScoreboard.updateScoreboard(victim);
                CustomScoreboard.updateScoreboard(killer);
            } else {
                e.setDeathMessage(null);
            }

            if (!victimInfo.getTeam().getBedStatus()) {
                victimInfo.setAlive(false);
                victimInfo.setAliveTime((int) ((System.currentTimeMillis() / 1000) - BedWarsHard.getGame().getStartTime()));
                for (Player all : Bukkit.getOnlinePlayers()) {
                    CustomScoreboard.updateScoreboard(all);
                }
            }
            Bukkit.getScheduler().scheduleSyncDelayedTask(BedWarsHard.getInstance(), new Runnable() {
                @Override
                public void run() {
                    if (victimInfo.getTeam().getBedStatus()) {
                        victimInfo.setAlive(false);
                    }
                    victim.spigot().respawn();
                }
            }, 20);
        }
    }
}
