package org.lordalex.bedwarshard.Events;

import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.LeavesDecayEvent;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.player.PlayerAchievementAwardedEvent;
import org.lordalex.bedwarshard.BedWarsHard;
import org.lordalex.bedwarshard.config.GameState;

public class ClosedEvents implements Listener {
    @EventHandler
    public void onPlayerAchievementAwardedEvent(PlayerAchievementAwardedEvent e){
        e.setCancelled(true);
    }
    @EventHandler
    public void onCraftItemEvent(CraftItemEvent e){
        e.setCancelled(true);
    }
    @EventHandler
    public void onLeavesDecayEvent(LeavesDecayEvent e){
        e.setCancelled(true);
    }
    @EventHandler
    public void onCreatureSpawnEvent(CreatureSpawnEvent e){
        if(e.getSpawnReason() == CreatureSpawnEvent.SpawnReason.NATURAL){
            e.setCancelled(true);
        }
    }
    @EventHandler
    public void onFoodLevelChangeEvent(FoodLevelChangeEvent e){
        if(BedWarsHard.getGame().getGameState() != GameState.GAME){
            e.setCancelled(true);
        }
    }
}
