package org.lordalex.bedwarshard.Events;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.lordalex.bedwarshard.BedWarsHard;

public class onConsume implements Listener {
    @EventHandler
    public void onPlayerItemConsumeEvent(PlayerItemConsumeEvent e) {
        Player player = e.getPlayer();
        if (e.getItem().getType() == Material.POTION) {
            Bukkit.getServer().getScheduler().runTaskLaterAsynchronously(BedWarsHard.getInstance(), () -> {
                if (player.getInventory().getItemInHand().getType() == Material.GLASS_BOTTLE) {
                    player.getInventory().setItemInHand(null);
                }
                player.updateInventory();
            }, 1L);
        }
    }
}
