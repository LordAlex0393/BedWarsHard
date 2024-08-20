package org.lordalex.bedwarshard.Events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerAchievementAwardedEvent;
import org.lordalex.bedwarshard.BedWarsHard;
import org.lordalex.bedwarshard.config.GameState;

public class ClosedEvents implements Listener {
    @EventHandler
    public void onPlayerAchievementAwardedEvent(PlayerAchievementAwardedEvent e){
        e.setCancelled(true);
    }

    @EventHandler
    public void onFoodLevelChangeEvent(FoodLevelChangeEvent e){
        if(BedWarsHard.getGame().getGameState() != GameState.GAME){
            e.setCancelled(true);
        }
    }
}
