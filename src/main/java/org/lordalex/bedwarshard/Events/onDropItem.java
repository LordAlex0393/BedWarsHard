package org.lordalex.bedwarshard.Events;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.lordalex.bedwarshard.BedWarsHard;
import org.lordalex.bedwarshard.Utils.ColorUtil;

import java.util.ArrayList;

public class onDropItem implements Listener {
    @EventHandler
    public void onPlayerDropItem(PlayerDropItemEvent e){
        ArrayList<Material> autoRemovedMaterials = new ArrayList<>();
        autoRemovedMaterials.add(Material.LEATHER_BOOTS);
        autoRemovedMaterials.add(Material.LEATHER_LEGGINGS);
        autoRemovedMaterials.add(Material.LEATHER_CHESTPLATE);
        autoRemovedMaterials.add(Material.LEATHER_HELMET);
        autoRemovedMaterials.add(Material.STONE_SWORD);

        if(e.getItemDrop().getItemStack().getType() == Material.NAME_TAG) {
            if(e.getPlayer().getGameMode() != GameMode.CREATIVE){
                e.setCancelled(true);
            }
        }
        else if(autoRemovedMaterials.contains(e.getItemDrop().getItemStack().getType())) {
            e.getItemDrop().remove();
        }
    }
}
