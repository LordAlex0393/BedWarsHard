package org.lordalex.bedwarshard.Events;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.lordalex.bedwarshard.BedWarsHard;
import org.lordalex.bedwarshard.config.GameState;
import org.lordalex.bedwarshard.config.PlayerInfo;

public class onPlayerInteract implements Listener {
    @EventHandler
    public void onTeamChestInteract(PlayerInteractEvent e) {
        if(BedWarsHard.getGame().getGameState() == GameState.GAME) {
            if (e.getAction() == Action.RIGHT_CLICK_BLOCK && e.getClickedBlock().getType() == Material.ENDER_CHEST) {
                e.setCancelled(true);
                Player player = e.getPlayer();
                PlayerInfo playerInfo = BedWarsHard.getGame().getPlayer(player);
                if (playerInfo != null) {
                    player.openInventory(playerInfo.getTeam().getTeamChestInventory());
                }
            }
        }
    }
    @EventHandler
    public void onFireTNT(PlayerInteractEvent e) {
        if(BedWarsHard.getGame().getGameState() == GameState.GAME) {
            if(e.getMaterial() == Material.FLINT_AND_STEEL){
                if(e.getClickedBlock().getType() != Material.TNT){
                    e.setCancelled(true);
                }
            }
        }
    }
}
