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
        if(BedWarsHard.getGame().getPlayer(e.getPlayer()) != null){
            GameUtil.playerRespawn(BedWarsHard.getGame().getPlayer(e.getPlayer()));
        }
    }

    @EventHandler
    public void onPlayerDeathEvent(PlayerDeathEvent e) {

        Player victim = e.getEntity();
        Player killer = e.getEntity().getKiller();

        if(e.getEntity().getKiller() instanceof Player && BedWarsHard.getGame().getPlayerInfoMap().containsKey(victim.getUniqueId()) && BedWarsHard.getGame().getPlayerInfoMap().containsKey(killer.getUniqueId())){
            PlayerInfo victimInfo = BedWarsHard.getGame().getPlayer(victim);
            PlayerInfo killerInfo = BedWarsHard.getGame().getPlayer(killer);
            e.setDeathMessage(ColorUtil.getMessage("Игрок &" + victimInfo.getTeam().getColor() + victim.getName() +
                    "&f убит игроком &" + killerInfo.getTeam().getColor() + killer.getName()));
        }
        else{
            e.setDeathMessage(null);
        }
        victim.spigot().respawn();

    }
}
