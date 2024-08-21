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
    public void onPlayerRespawnEvent(PlayerRespawnEvent e) {
        GameUtil.giveKit(e.getPlayer());
    }

    @EventHandler
    public void onPlayerDeathEvent(PlayerDeathEvent e) {
        e.getDrops().clear();
        Player victim = e.getEntity();
        Player killer = e.getEntity().getKiller();

        if(e.getEntity().getKiller() instanceof Player && BedWarsHard.getGame().getPlayerInfoMap().containsKey(victim.getUniqueId()) && BedWarsHard.getGame().getPlayerInfoMap().containsKey(killer.getUniqueId())){
            PlayerInfo victimInfo = BedWarsHard.getGame().getPlayer(victim);
            PlayerInfo killerInfo = BedWarsHard.getGame().getPlayer(killer);
            e.setDeathMessage(ColorUtil.getMessage("Игрок &" + victimInfo.getTeam().getColor() + victim.getName() +
                    "&f убит игроком &" + killerInfo.getTeam().getColor() + killer.getName()));

            victimInfo.setDeaths(victimInfo.getDeaths()+1);
            killerInfo.setKills(killerInfo.getKills()+1);
            CustomScoreboard.updateScoreboard(victim);
            CustomScoreboard.updateScoreboard(killer);
        }
        else{
            e.setDeathMessage(null);
        }
        Bukkit.getScheduler().scheduleSyncDelayedTask(BedWarsHard.getInstance(), new Runnable() {
            @Override
            public void run() {
                victim.spigot().respawn();
            }
        }, 20);
    }
}
