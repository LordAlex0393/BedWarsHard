package org.lordalex.bedwarshard.Utils;

import org.bukkit.*;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.Bed;
import org.bukkit.scheduler.BukkitRunnable;
import org.lordalex.bedwarshard.BedWarsHard;
import org.lordalex.bedwarshard.config.BedTeam;
import org.lordalex.bedwarshard.config.GameState;

import java.util.List;

public class ResourceUtil {
    public static void spawnBronzeResource(Location dropLocation) {
        ItemStack bronzeStack = new ItemStack(Material.CLAY_BRICK, 1);
        ItemMeta bronzeMeta = bronzeStack.getItemMeta();
        bronzeMeta.setDisplayName(ChatColor.GOLD + "Бронза");
        bronzeStack.setItemMeta(bronzeMeta);

        Item dropitem = Bukkit.getWorld("world").dropItem(dropLocation, bronzeStack);
        dropitem.setPickupDelay(dropitem.getPickupDelay()/3);
        dropitem.setVelocity(dropitem.getVelocity().zero());
    }

    public static void spawnIronResource(Location dropLocation) {
        ItemStack ironStack = new ItemStack(Material.IRON_INGOT, 1);
        ItemMeta ironMeta = ironStack.getItemMeta();
        ironMeta.setDisplayName(ChatColor.WHITE + "Железо");
        ironStack.setItemMeta(ironMeta);

        Item dropitem = Bukkit.getWorld("world").dropItem(dropLocation, ironStack);
        dropitem.setPickupDelay(dropitem.getPickupDelay()/3);
        dropitem.setVelocity(dropitem.getVelocity().zero());
    }

    public static void spawnGoldResource() {
        for (String position : BedWarsHard.getMapConfig().getGoldSpawns()) {
            Location location = YmlParser.parseLocation(Bukkit.getWorld("world"), position);

            ItemStack goldStack = new ItemStack(Material.GOLD_INGOT, 1);
            ItemMeta goldMeta = goldStack.getItemMeta();
            goldMeta.setDisplayName(ChatColor.YELLOW + "Золото");
            goldStack.setItemMeta(goldMeta);

            Item dropitem = Bukkit.getWorld("world").dropItem(location, goldStack);
            dropitem.setVelocity(dropitem.getVelocity().zero());

        }
    }
    public static void activateBronzeSpawners(){
        for (String key : BedWarsHard.getMapConfig().getTeams().keySet()) {
            BedTeam team = BedWarsHard.getMapConfig().getTeams().get(key);
            if (team.getAlivePlayersInfo().size() > 0) {
                for (int i = 0; i < team.getBronzeSpawns().size(); i++) {
                    String position = team.getBronzeSpawns().get(i);
                    Location dropLocation = YmlParser.parseLocation(Bukkit.getWorld("world"), position);
                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            if (BedWarsHard.getGame().getGameState() == GameState.GAME) {
                                spawnBronzeResource(dropLocation);
                            } else {
                                cancel();
                            }
                        }
                    }.runTaskTimer(BedWarsHard.getInstance(), Math.round((BedWarsHard.getMapConfig().getBronzeFrequency()*i)/BedWarsHard.getGame().getBronzeRate()), Math.round((BedWarsHard.getMapConfig().getBronzeFrequency()*team.getBronzeSpawns().size())/BedWarsHard.getGame().getBronzeRate()));
                }
            }
        }
    }

    public static void activateIronSpawners(){
        for (String key : BedWarsHard.getMapConfig().getTeams().keySet()) {
            BedTeam team = BedWarsHard.getMapConfig().getTeams().get(key);
            if (team.getAlivePlayersInfo().size() > 0) {
                for (int i = 0; i < team.getIronSpawns().size(); i++) {
                    String position = team.getIronSpawns().get(i);
                    Location dropLocation = YmlParser.parseLocation(Bukkit.getWorld("world"), position);
                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            if (BedWarsHard.getGame().getGameState() == GameState.GAME) {
                                spawnIronResource(dropLocation);
                            } else {
                                cancel();
                            }
                        }
                    }.runTaskTimer(BedWarsHard.getInstance(), Math.round((BedWarsHard.getMapConfig().getIronFrequency()*i)/BedWarsHard.getGame().getIronRate()), Math.round((BedWarsHard.getMapConfig().getIronFrequency()*team.getIronSpawns().size())/BedWarsHard.getGame().getIronRate()));

                }
            }
        }
    }
    public static void activateGoldSpawners(){
        new BukkitRunnable() {
            @Override
            public void run() {
                if (BedWarsHard.getGame().getGameState() == GameState.GAME) {
                    spawnGoldResource();
                } else {
                    cancel();
                }
            }
        }.runTaskTimer(BedWarsHard.getInstance(), 0, BedWarsHard.getMapConfig().getGoldFrequency());
    }

    public static boolean isEqualsItem(InventoryClickEvent e, String itemDisplayName) {
        if (e.getCurrentItem().getItemMeta().getDisplayName() != null) {
            return e.getCurrentItem().getItemMeta().getDisplayName().equals(ColorUtil.getMessage(itemDisplayName));
        } else {
            return false;
        }
    }

    public static void clearAllEntities() {
        World world = Bukkit.getWorld("world");
        List<Entity> entList = world.getEntities();
        for (Entity current : entList) {
            if (current.getType() == EntityType.DROPPED_ITEM) {
                current.remove();
            }
        }
    }
}
