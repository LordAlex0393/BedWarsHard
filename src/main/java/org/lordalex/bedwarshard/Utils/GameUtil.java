package org.lordalex.bedwarshard.Utils;

import org.bukkit.*;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
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

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class GameUtil {
    private static int delay = BedWarsHard.getGame().getStartingDelay();

    public static void start() {
        HashMap<Integer, String> timerStrings = new HashMap<>();
        timerStrings.put(100, "");
        timerStrings.put(60, "");
        timerStrings.put(30, "");
        timerStrings.put(10, "");
        timerStrings.put(5, "");
        timerStrings.put(4, "ы");
        timerStrings.put(3, "ы");
        timerStrings.put(2, "ы");
        timerStrings.put(1, "у");

        BedWarsHard.getGame().setGameState(GameState.STARTING);
        GameUtil.clearAllEntities();
            new BukkitRunnable() {
                @Override
                public void run() {
                    if(BedWarsHard.getGame().getGameState() == GameState.STARTING){
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

                            for(Player all : Bukkit.getOnlinePlayers()){
                                int playersToStart = BedWarsHard.getMapConfig().getTeamPlayers() * BedWarsHard.getMapConfig().getTeams().size();
                                if(BedWarsHard.getGame().getPlayer(all) == null && BedWarsHard.getGame().getPlayerInfoMap().size() < playersToStart){
                                    TeamSelector.randomizeTeam(all);
                                }
                            }

                            game();
                            cancel();
                        }
                        delay--;
                    }
                    else{
                        cancel();
                    }
                }
            }.runTaskTimer(BedWarsHard.getInstance(), 0, 20);
    }

    public static void interrupt(){
        BedWarsHard.getGame().setGameState(GameState.WAITING);
        delay = BedWarsHard.getGame().getStartingDelay();
        for (Player all : Bukkit.getOnlinePlayers()) {
            CustomScoreboard.updateScoreboard(all);
        }
    }

    public static void game() {
        BedWarsHard.getGame().setGameState(GameState.GAME);
        for (Player all : Bukkit.getOnlinePlayers()) {
            CustomScoreboard.updateScoreboard(all);
            clearPlayer(all);

            if (BedWarsHard.getGame().getPlayer(all) != null) {
                playerRespawn(BedWarsHard.getGame().getPlayer(all));
                all.setGameMode(GameMode.SURVIVAL);
            }
        }
        GameUtil.clearAllEntities();
        new BukkitRunnable() {
            @Override
            public void run() {
                if(BedWarsHard.getGame().getGameState() == GameState.GAME){
                    spawnBronzeResource();
                }
                else{
                    cancel();
                }
            }
        }.runTaskTimer(BedWarsHard.getInstance(), 0, BedWarsHard.getMapConfig().getBronzeFrequency());
        new BukkitRunnable() {
            @Override
            public void run() {
                if (BedWarsHard.getGame().getGameState() == GameState.GAME){
                    spawnIronResource();
                }
                else{
                    cancel();
                }
            }
        }.runTaskTimer(BedWarsHard.getInstance(), 0, BedWarsHard.getMapConfig().getIronFrequency());
        new BukkitRunnable() {
            @Override
            public void run() {
                if (BedWarsHard.getGame().getGameState() == GameState.GAME){
                    spawnGoldResource();
                }
                else{
                    cancel();
                }
            }
        }.runTaskTimer(BedWarsHard.getInstance(), 0, BedWarsHard.getMapConfig().getGoldFrequency());
    }
    public static void stop(){
        BedWarsHard.getGame().setGameState(GameState.ENDING);
    }

    public static void clearPlayer(Player player) {
        for (PotionEffect potionEffect : player.getActivePotionEffects()) {
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
        ItemStack stoneSwordStack = new ItemStack(Material.STONE_SWORD, 1);
        ItemMeta stoneSwordMeta = stoneSwordStack.getItemMeta();
        List<String> stoneSwordList = new ArrayList<>();
        stoneSwordList.add(ChatColor.GOLD + "Начальный предмет");
        stoneSwordMeta.setLore(stoneSwordList);
        stoneSwordMeta.spigot().setUnbreakable(true);
        stoneSwordStack.setItemMeta(stoneSwordMeta);
        player.getInventory().setItem(0, stoneSwordStack);

        ItemStack bootsStack = new ItemStack(Material.LEATHER_BOOTS, 1, (byte) BedWarsHard.getGame().getPlayer(player).getTeam().getWool());
        LeatherArmorMeta bootsMeta = (LeatherArmorMeta) bootsStack.getItemMeta();
        bootsMeta.setColor(ColorUtil.translateChatColorToColor(BedWarsHard.getGame().getPlayer(player).getTeam().getNames().split(",")[3]));
        List<String> bootsList = new ArrayList<>();
        bootsList.add(ChatColor.GOLD + "Начальный предмет");
        bootsMeta.setLore(bootsList);
        bootsMeta.spigot().setUnbreakable(true);
        bootsStack.setItemMeta(bootsMeta);
        bootsStack.setDurability((short) -1);
        player.getInventory().setBoots(bootsStack);

        ItemStack leggingsStack = new ItemStack(Material.LEATHER_LEGGINGS, 1, (byte) BedWarsHard.getGame().getPlayer(player).getTeam().getWool());
        LeatherArmorMeta leggingsMeta = (LeatherArmorMeta) leggingsStack.getItemMeta();
        leggingsMeta.setColor(ColorUtil.translateChatColorToColor(BedWarsHard.getGame().getPlayer(player).getTeam().getNames().split(",")[3]));
        List<String> leggingsList = new ArrayList<>();
        leggingsList.add(ChatColor.GOLD + "Начальный предмет");
        leggingsMeta.setLore(leggingsList);
        leggingsMeta.spigot().setUnbreakable(true);
        leggingsStack.setItemMeta(leggingsMeta);
        leggingsStack.setDurability((short) -1);
        player.getInventory().setLeggings(leggingsStack);

        ItemStack chestplateStack = new ItemStack(Material.LEATHER_CHESTPLATE, 1, (byte) BedWarsHard.getGame().getPlayer(player).getTeam().getWool());
        LeatherArmorMeta chestplateMeta = (LeatherArmorMeta) chestplateStack.getItemMeta();
        chestplateMeta.setColor(ColorUtil.translateChatColorToColor(BedWarsHard.getGame().getPlayer(player).getTeam().getNames().split(",")[3]));
        List<String> chestplateList = new ArrayList<>();
        chestplateList.add(ChatColor.GOLD + "Начальный предмет");
        chestplateMeta.setLore(chestplateList);
        chestplateMeta.spigot().setUnbreakable(true);
        chestplateStack.setItemMeta(chestplateMeta);
        chestplateStack.setDurability((short) -1);
        player.getInventory().setChestplate(chestplateStack);

        ItemStack helmetStack = new ItemStack(Material.LEATHER_HELMET, 1, (byte) BedWarsHard.getGame().getPlayer(player).getTeam().getWool());
        LeatherArmorMeta helmetMeta = (LeatherArmorMeta) helmetStack.getItemMeta();
        helmetMeta.setColor(ColorUtil.translateChatColorToColor(BedWarsHard.getGame().getPlayer(player).getTeam().getNames().split(",")[3]));
        List<String> helmetList = new ArrayList<>();
        helmetList.add(ChatColor.GOLD + "Начальный предмет");
        helmetMeta.setLore(helmetList);
        helmetMeta.spigot().setUnbreakable(true);
        helmetStack.setItemMeta(helmetMeta);
        helmetStack.setDurability((short) -1);
        player.getInventory().setHelmet(helmetStack);
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
        giveStartKit(playerInfo.getPlayer());
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

    public static int getDelay() {
        return delay;
    }
}
