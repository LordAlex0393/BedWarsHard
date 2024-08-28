package org.lordalex.bedwarshard.Events;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.lordalex.bedwarshard.BedWarsHard;

public class onEntityExplode implements Listener {
    @EventHandler
    public void onEntityExplodeEvent(EntityExplodeEvent e){
        e.blockList().removeIf(explodedBlock -> explodedBlock.getType() == Material.BED_BLOCK || !BedWarsHard.getGame().getBlocksLocationsSet().contains(explodedBlock.getLocation()));
    }

}
