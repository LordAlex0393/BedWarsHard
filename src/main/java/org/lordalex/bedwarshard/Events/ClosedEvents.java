package org.lordalex.bedwarshard.Events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerAchievementAwardedEvent;

public class ClosedEvents implements Listener {
    @EventHandler
    public void onPlayerAchievementAwardedEvent(PlayerAchievementAwardedEvent e){
        e.setCancelled(true);
    }
}
