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
import org.lordalex.bedwarshard.config.GameState;
import org.lordalex.bedwarshard.config.PlayerInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class onDamage implements Listener {

    @EventHandler
    public void onEntityDamageByEntityEvent(EntityDamageByEntityEvent e) {
        if (BedWarsHard.getGame().getGameState() == GameState.GAME) {
            Player victim = (Player) e.getEntity();
            PlayerInfo victimInfo = BedWarsHard.getGame().getPlayer(victim);
            if ((e.getDamager() instanceof Player) && (e.getEntity() instanceof Player)) {
                Player damager = (Player) e.getDamager();
                PlayerInfo damagerInfo = BedWarsHard.getGame().getPlayer(damager);
                if (damagerInfo.getTeam().equals(victimInfo.getTeam())) {
                    e.setCancelled(true);
                }
            }
            if (e.getDamager() instanceof Arrow) {
                Arrow arrow = (Arrow) e.getDamager();
                if (arrow.getShooter() instanceof Player) {
                    Player shooter = (Player) arrow.getShooter();
                    PlayerInfo shooterInfo = BedWarsHard.getGame().getPlayer(shooter);
                    if (shooterInfo.getTeam().equals(victimInfo.getTeam())) {
                        e.setCancelled(true);
                    }
                }
            }
        }
    }

    @EventHandler
    public void onPlayerDeathEvent(PlayerDeathEvent e) {
        if (e.getEntity() == null) return;
        if (e.getEntity().getPlayer() == null) return;

        Player victim = e.getEntity().getPlayer();
        victim.getInventory().clear();
        if (BedWarsHard.getGame().getGameState() == GameState.GAME) {
            PlayerInfo victimInfo = BedWarsHard.getGame().getPlayer(victim);
//            if(e.getEntity().getLastDamageCause().getCause() != EntityDamageEvent.DamageCause.CONTACT){
//                e.setDeathMessage(null);
//                victimInfo.setDeaths(victimInfo.getDeaths() + 1);
//                CustomScoreboard.updateScoreboard(victim);
//            }
            if (e.getEntity().getKiller() instanceof Player && BedWarsHard.getGame().getPlayer(e.getEntity().getKiller()) != null) {
                Player killer = e.getEntity().getKiller();
                PlayerInfo killerInfo = BedWarsHard.getGame().getPlayer(killer);

                killerInfo.setKills(killerInfo.getKills() + 1);
                killer.setLevel(killer.getLevel() + 1);
                CustomScoreboard.updateScoreboard(killer);

                if (!(victim.equals(killer))) {
                    e.setDeathMessage(ColorUtil.getMessage("Игрок &" + victimInfo.getTeam().getColor() + victim.getName() + "&f убит игроком &" + killerInfo.getTeam().getColor() + killer.getName()));
                }
            } else {
                e.setDeathMessage(null);
            }
        }
        victim.spigot().respawn();
    }

    @EventHandler
    public void onEntityDamage(EntityDamageEvent e) {
        if (BedWarsHard.getGame().getGameState() != GameState.GAME) {
            e.setCancelled(true);
        } else if (e.getCause() == EntityDamageEvent.DamageCause.VOID) {
            e.setDamage(20000);
        }
    }

    @EventHandler
    public void onPlayerRespawnEvent(PlayerRespawnEvent e) {
        //GameUtil.playerRespawn(e.getPlayer());
        Player player = e.getPlayer();
        PlayerInfo playerInfo = BedWarsHard.getGame().getPlayer(player);



        Random rand = new Random();
        int spawnNumber = rand.nextInt(playerInfo.getTeam().getSpawns().size());

        Location loc = YmlParser.parseLocation(Bukkit.getWorld("world"), playerInfo.getTeam().getSpawns().get(spawnNumber));
        loc.setPitch(0);

        playerInfo.getPlayer().teleport(loc);

        playerInfo.getPlayer().setBedSpawnLocation(loc, true);

        e.setRespawnLocation(loc);
    }
}
