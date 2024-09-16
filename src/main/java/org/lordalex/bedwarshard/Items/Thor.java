package org.lordalex.bedwarshard.Items;

import com.google.common.collect.Sets;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import java.util.HashSet;

public class Thor implements Listener {
    private static final HashSet<Byte> TRANSPARENT_BLOCKS;
    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        if ((event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) && event.hasItem() && event.getItem().getType() == Material.BONE) {
            event.getPlayer().getWorld().strikeLightning(event.getPlayer().getTargetBlock(TRANSPARENT_BLOCKS, 150).getLocation());
            PlayerInventory inv = event.getPlayer().getInventory();
            ItemStack used = inv.getItemInHand();
            used.setAmount(used.getAmount() - 1);
            inv.setItem(inv.getHeldItemSlot(), used.getAmount() == 0 ? null : used);
        }
    }
    static {
        TRANSPARENT_BLOCKS = Sets.newHashSet(new Byte[]{0, 6, 8, 9, 20, 27, 28, 30, 31, 37, 38, 40, 44, 50, 51, 64, 65, 66, 69, 70, 71, 72, 78, 85, 101, 102, 106, 111, 113, 126, -113, -99, -85, 67});
    }
}
