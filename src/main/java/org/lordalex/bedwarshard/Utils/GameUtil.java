package org.lordalex.bedwarshard.Utils;

import org.bukkit.*;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.scheduler.BukkitRunnable;
import org.lordalex.bedwarshard.BedWarsHard;
import org.lordalex.bedwarshard.Items.TeamSelector;
import org.lordalex.bedwarshard.config.BedTeam;
import org.lordalex.bedwarshard.config.GameState;
import org.lordalex.bedwarshard.config.PlayerInfo;

import java.util.HashMap;
import java.util.Random;

public class GameUtil {
    private static int delay = 10;

    public static void start() {
        HashMap<Integer, String> timerStrings = new HashMap<>();
        timerStrings.put(10, "");
        timerStrings.put(5, "");
        timerStrings.put(4, "ы");
        timerStrings.put(3, "ы");
        timerStrings.put(2, "ы");
        timerStrings.put(1, "у");

        BedWarsHard.getGame().setGameState(GameState.STARTING);
        new BukkitRunnable() {
            @Override
            public void run() {
                if (timerStrings.containsKey(delay)) {
                    for (Player all : Bukkit.getOnlinePlayers()) {
                        all.sendMessage(ColorUtil.getMessage("&fИгра начнется через &e" + delay + "&f секунд" + timerStrings.get(delay)));
                    }
                }
                for (Player all : Bukkit.getOnlinePlayers()) {
                    CustomScoreboard.updateScoreboard(all);
                }
                if (delay <= 0) {
                    delay = BedWarsHard.getGame().getStartingDelay();
                    game();
                    cancel();
                }
                delay--;
            }
        }.runTaskTimer(BedWarsHard.getInstance(), 0, 20);
    }

    public static void game() {
        BedWarsHard.getGame().setGameState(GameState.GAME);
        for (Player all : Bukkit.getOnlinePlayers()) {
            CustomScoreboard.updateScoreboard(all);
            clearPlayer(all);

            if (BedWarsHard.getGame().getPlayer(all) != null) {
                all.teleport(YmlParser.parseLocation(Bukkit.getWorld("world"), BedWarsHard.getGame().getPlayer(all).getTeam().getSpawns().get(0)));
                giveStartKit(all);
            }
        }
        new BukkitRunnable() {
            @Override
            public void run() {
                spawnBronzeResource();
            }
        }.runTaskTimer(BedWarsHard.getInstance(), 0, BedWarsHard.getMapConfig().getBronzeFrequency());
        new BukkitRunnable() {
            @Override
            public void run() {
                spawnIronResource();
            }
        }.runTaskTimer(BedWarsHard.getInstance(), 0, BedWarsHard.getMapConfig().getIronFrequency());
        new BukkitRunnable() {
            @Override
            public void run() {
                spawnGoldResource();
            }
        }.runTaskTimer(BedWarsHard.getInstance(), 0, BedWarsHard.getMapConfig().getGoldFrequency());
    }

    public static void clearPlayer(Player player) {
        for(PotionEffect potionEffect : player.getActivePotionEffects()){
            player.removePotionEffect(potionEffect.getType());
        }
        player.getInventory().clear();
        player.getInventory().setArmorContents(null);
        player.setHealth(20);
        player.setFoodLevel(20);
        player.setGameMode(GameMode.ADVENTURE);
        player.setCustomName("§f" + player.getName());
        player.setCustomNameVisible(true);
    }

    public static void giveWaitingItems(Player player) {
        TeamSelector.giveTeamSelector(player);
    }

    public static void giveStartKit(Player player) {
        ItemStack swordStack = new ItemStack(Material.STONE_SWORD, 1);
        swordStack.setDurability((short) -1);
        player.getInventory().setItem(0, swordStack);

        ItemStack bootsStack = new ItemStack(Material.LEATHER_BOOTS, 1, (byte) BedWarsHard.getGame().getPlayer(player).getTeam().getWool());
        LeatherArmorMeta bootsMeta = (LeatherArmorMeta) bootsStack.getItemMeta();
        bootsMeta.setColor(ColorUtil.translateChatColorToColor(BedWarsHard.getGame().getPlayer(player).getTeam().getNames().split(",")[3]));
        bootsStack.setItemMeta(bootsMeta);
        bootsStack.setDurability((short) -1);
        player.getInventory().setBoots(bootsStack);

        ItemStack leggingsStack = new ItemStack(Material.LEATHER_LEGGINGS, 1, (byte) BedWarsHard.getGame().getPlayer(player).getTeam().getWool());
        LeatherArmorMeta leggingsMeta = (LeatherArmorMeta) leggingsStack.getItemMeta();
        leggingsMeta.setColor(ColorUtil.translateChatColorToColor(BedWarsHard.getGame().getPlayer(player).getTeam().getNames().split(",")[3]));
        leggingsStack.setItemMeta(leggingsMeta);
        leggingsStack.setDurability((short) -1);
        player.getInventory().setLeggings(leggingsStack);

        ItemStack chestplateStack = new ItemStack(Material.LEATHER_CHESTPLATE, 1, (byte) BedWarsHard.getGame().getPlayer(player).getTeam().getWool());
        LeatherArmorMeta chestplateMeta = (LeatherArmorMeta) chestplateStack.getItemMeta();
        chestplateMeta.setColor(ColorUtil.translateChatColorToColor(BedWarsHard.getGame().getPlayer(player).getTeam().getNames().split(",")[3]));
        chestplateStack.setItemMeta(chestplateMeta);
        chestplateStack.setDurability((short) -1);
        player.getInventory().setChestplate(chestplateStack);
    }

    private static void spawnBronzeResource() {
        for (String key : BedWarsHard.getMapConfig().getTeams().keySet()) {
            BedTeam team = BedWarsHard.getMapConfig().getTeams().get(key);
            if (team.getBedStatus()) {
                for (String position : team.getBronzeSpawns()) {
                    Location location = YmlParser.parseLocation(Bukkit.getWorld("world"), position);

                    ItemStack bronzeStack = new ItemStack(Material.CLAY_BRICK, 1);
                    ItemMeta bronzeMeta = bronzeStack.getItemMeta();
                    bronzeMeta.setDisplayName(ChatColor.GOLD + "Бронза");
                    bronzeStack.setItemMeta(bronzeMeta);

                    Item dropitem = Bukkit.getWorld("world").dropItem(location, bronzeStack);
                    dropitem.setVelocity(dropitem.getVelocity().zero());
                }
            }
        }
    }

    private static void spawnIronResource() {
        for (String key : BedWarsHard.getMapConfig().getTeams().keySet()) {
            BedTeam team = BedWarsHard.getMapConfig().getTeams().get(key);
            if (team.getBedStatus()) {
                for (String position : team.getIronSpawns()) {
                    Location location = YmlParser.parseLocation(Bukkit.getWorld("world"), position);

                    ItemStack ironStack = new ItemStack(Material.IRON_INGOT, 1);
                    ItemMeta ironMeta = ironStack.getItemMeta();
                    ironMeta.setDisplayName(ChatColor.WHITE + "Железо");
                    ironStack.setItemMeta(ironMeta);

                    Item dropitem = Bukkit.getWorld("world").dropItem(location, ironStack);
                    dropitem.setVelocity(dropitem.getVelocity().zero());
                }
            }
        }
    }

    private static void spawnGoldResource() {
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

    public static void playerRespawn(PlayerInfo playerInfo) {
        BedTeam team = playerInfo.getTeam();
        Random rand = new Random();
        int spawnNumber = rand.nextInt(team.getSpawns().size());
        playerInfo.getPlayer().teleport(YmlParser.parseLocation(Bukkit.getWorld("world"), playerInfo.getTeam().getSpawns().get(spawnNumber)));
    }


    public static boolean isEqualsItem(InventoryClickEvent e, String itemDisplayName) {
        if (e.getCurrentItem().getItemMeta().getDisplayName() != null) {
            return e.getCurrentItem().getItemMeta().getDisplayName().equals(ColorUtil.getMessage(itemDisplayName));
        } else {
            return false;
        }
    }

    public static int getDelay() {
        return delay;
    }

    public static void setDelay(int delay) {
        GameUtil.delay = delay;
    }
}
