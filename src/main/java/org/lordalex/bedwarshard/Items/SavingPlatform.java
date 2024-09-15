package org.lordalex.bedwarshard.Items;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.lordalex.bedwarshard.BedWarsHard;
import org.lordalex.bedwarshard.Utils.ColorUtil;
import org.lordalex.bedwarshard.config.PlayerInfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class SavingPlatform implements Listener {
    private final HashMap<UUID, Long> cooldownsMap;
    private final int COOLDOWN = 20000;

    public SavingPlatform() {
        this.cooldownsMap = new HashMap<UUID, Long>();
    }


    @EventHandler
    public void platformCreating(PlayerInteractEvent e) {

        if(e.getItem() == null) return;
        if (!(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK)) return;
        if (!(e.getItem().getType() == Material.BLAZE_ROD)) return;
        Player p = e.getPlayer();
        if (!cooldownsMap.containsKey(p.getUniqueId()) || System.currentTimeMillis() - cooldownsMap.get(p.getUniqueId()) >= COOLDOWN) {
            Location loc = p.getLocation();
            if(loc.getY() < 0){
                loc.setY(0);
            }
            else if(loc.getY() > 255 || p.getWorld().getBlockAt(loc.clone().add(0,-1,0)).getType()!=Material.AIR){
                return;
            }
            List<Block> placedBlocks = new ArrayList<>();

            List<Location> area = new ArrayList<>();
            area.add(loc.clone().add(0, -1, 0));
            area.add(loc.clone().add(1, -1, 0));
            area.add(loc.clone().add(0, -1, 1));
            area.add(loc.clone().add(1, -1, 1));
            area.add(loc.clone().add(1, -1, -1));
            area.add(loc.clone().add(0, -1, -1));
            area.add(loc.clone().add(-1, -1, 1));
            area.add(loc.clone().add(-1, -1, 0));
            area.add(loc.clone().add(-1, -1, -1));

            area.add(loc.clone().add(2, -1, 1));
            area.add(loc.clone().add(2, -1, -1));
            area.add(loc.clone().add(1, -1, 2));
            area.add(loc.clone().add(1, -1, -2));
            area.add(loc.clone().add(-1, -1, 2));
            area.add(loc.clone().add(-1, -1, -2));
            area.add(loc.clone().add(-2, -1, 1));
            area.add(loc.clone().add(-2, -1, -1));

            for(Location l : area){
                if(p.getWorld().getBlockAt(l).getType().equals(Material.AIR)){
                    if(BedWarsHard.getGame().getPlayer(p)!=null){
                        PlayerInfo playerInfo = BedWarsHard.getGame().getPlayer(p);
                        ItemStack glassStack = new ItemStack(Material.STAINED_GLASS, 1, (byte) playerInfo.getTeam().getWool());
                        p.getWorld().getBlockAt(l).setType(glassStack.getType());
                        p.getWorld().getBlockAt(l).setData(glassStack.getData().getData());
                    }
                    else{
                        p.getWorld().getBlockAt(l).setType(Material.GLASS);
                    }
                    placedBlocks.add(p.getWorld().getBlockAt(l));
                }
            }

            new BukkitRunnable(){
                @Override
                public void run(){
                    for(Block block : placedBlocks){
                        block.setType(Material.AIR);
                    }
                }
            }.runTaskLater(BedWarsHard.getInstance(), 20 * 10);

            loc.setX(centering(loc.getX()));
            loc.setZ(centering(loc.getZ()));
            p.teleport(loc);

            cooldownsMap.put(p.getUniqueId(), System.currentTimeMillis());

            int platformSlot = p.getInventory().getHeldItemSlot();
            ItemStack platformStack = p.getInventory().getItem(platformSlot);
            platformStack.setAmount(platformStack.getAmount()-1);
            p.getInventory().setItem(platformSlot, platformStack);

            p.sendMessage(ColorUtil.getMessage("&aПлатформа активирована"));
        }
        else {
            p.sendMessage(ColorUtil.getMessage("&eПерезарядка: ") + (COOLDOWN - (System.currentTimeMillis() - cooldownsMap.get(p.getUniqueId()))) / 1000 + "с");
        }
    }

    @EventHandler
    public void onFall(EntityDamageEvent e) {
        if (e.getCause() == EntityDamageEvent.DamageCause.FALL) {
            if(cooldownsMap.containsKey(e.getEntity().getUniqueId())
                    && System.currentTimeMillis() - cooldownsMap.get(e.getEntity().getUniqueId()) < 1000){
                e.setCancelled(true);
            }
        }
    }

    private double centering(double coordinate){
        int d = (int) coordinate;
        if(coordinate >= 0){
            return d + 0.5;
        }
        else{
            return d - 0.5;
        }
    }
}
