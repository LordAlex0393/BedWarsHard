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
import org.lordalex.bedwarshard.Items.Trader;
import org.lordalex.bedwarshard.config.BedTeam;
import org.lordalex.bedwarshard.config.GameState;
import org.lordalex.bedwarshard.config.PlayerInfo;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class GameUtil {
    private static int delay = BedWarsHard.getGame().getStartingDelay();

    public static void start() {
        HashMap<Integer, String> timerStrings = new HashMap<>();
        timerStrings.put(300, "");
        timerStrings.put(250, "");
        timerStrings.put(200, "");
        timerStrings.put(150, "");
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
        delay = BedWarsHard.getGame().getStartingDelay();
        ResourceUtil.clearAllEntities();
        new BukkitRunnable() {
            @Override
            public void run() {
                if (BedWarsHard.getGame().getGameState() == GameState.STARTING) {
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

                        for (Player all : Bukkit.getOnlinePlayers()) {
                            int playersToStart = BedWarsHard.getMapConfig().getTeamPlayers() * BedWarsHard.getMapConfig().getTeams().size();
                            if (BedWarsHard.getGame().getPlayer(all) == null && BedWarsHard.getGame().getPlayerInfoMap().size() < playersToStart) {
                                TeamSelector.randomizeTeam(all);
                            }
                        }

                        game();
                        cancel();
                    }
                    delay--;
                } else {
                    cancel();
                }
            }
        }.runTaskTimer(BedWarsHard.getInstance(), 0, 20);
    }

    public static void interrupt() {
        BedWarsHard.getGame().setGameState(GameState.WAITING);
        delay = BedWarsHard.getGame().getStartingDelay();
        for (Player all : Bukkit.getOnlinePlayers()) {
            CustomScoreboard.updateScoreboard(all);
        }
    }

    public static void game() {
        BedWarsHard.getGame().setGameState(GameState.GAME);
        BedWarsHard.getGame().setStartTime(System.currentTimeMillis() / 1000L);
        for (Player all : Bukkit.getOnlinePlayers()) {
            CustomScoreboard.updateScoreboard(all);
            clearPlayer(all);

            if (BedWarsHard.getGame().getPlayer(all) != null) {
                playerRespawn(BedWarsHard.getGame().getPlayer(all));
            }
        }
        ResourceUtil.clearAllEntities();
        Bukkit.getScheduler().scheduleSyncDelayedTask(BedWarsHard.getInstance(), new Runnable() {
            @Override
            public void run() {
                ResourceUtil.activateBronzeSpawners();
                ResourceUtil.activateIronSpawners();
                ResourceUtil.activateGoldSpawners();
                spawnTraders();
            }
        }, 20);

        new BukkitRunnable(){
            @Override
            public void run(){
                finish(null);
            }
        }.runTaskLater(BedWarsHard.getInstance(), 20 * 60 * BedWarsHard.getGame().getGameLength());


    }

    public static void stop() {
        BedWarsHard.getGame().setGameState(GameState.ENDING);
    }

    public static void finish(BedTeam winner) {
        if(BedWarsHard.getGame().getGameState()!=GameState.ENDING){
            BedWarsHard.getGame().setGameState(GameState.ENDING);
            for(Player p : Bukkit.getOnlinePlayers()) {
                p.playSound(p.getLocation(), Sound.LEVEL_UP, 3.0F, 1F);
            }
            for (String str : getWinnerStrings(winner)) {
                for(Player p : Bukkit.getOnlinePlayers()) {
                    p.sendMessage(str);
                }
            }

            new BukkitRunnable(){
                @Override
                public void run(){
                    for(Player p : Bukkit.getOnlinePlayers()){
                        if(BedWarsHard.getGame().getPlayer(p)==null){
                            return;
                        }
                        PlayerInfo pi = BedWarsHard.getGame().getPlayer(p);
                        p.sendMessage(ColorUtil.getMessage("&a&l-------------------------"));
                        p.sendMessage(ColorUtil.getMessage("&e&l   Ваша статистика:"));
                        p.sendMessage(ColorUtil.getMessage(" "));
                        p.sendMessage(ColorUtil.getMessage("&e Убийств&f: " + pi.getKills()));
                        p.sendMessage(ColorUtil.getMessage("&e Смертей&f: " + pi.getDeaths()));
                        p.sendMessage(ColorUtil.getMessage("&e Кроватей&f: " + pi.getBrokenBeds()));
                        p.sendMessage(ColorUtil.getMessage(" "));
                        p.sendMessage(ColorUtil.getMessage("&e Золота&f: " + pi.getSpentGold()));
                        p.sendMessage(ColorUtil.getMessage("&f Железа&f: " + pi.getSpentIron()));
                        p.sendMessage(ColorUtil.getMessage("&6 Бронзы&f: " + pi.getSpentBronze()));
                        p.sendMessage(ColorUtil.getMessage("&a&l-------------------------"));
                        p.playSound(p.getLocation(), Sound.ORB_PICKUP, 3.0F, 1F);
                    }
                }
            }.runTaskLater(BedWarsHard.getInstance(), 20 * 3);
        }
    }

    private static List<String> getWinnerStrings(BedTeam winner) {
        ArrayList<String> finishStrings = new ArrayList<>();
        String line = "&7###################################";
        if (winner != null) {

            finishStrings.add(ColorUtil.getMessage(line));
            finishStrings.add(ColorUtil.getMessage("&7&l#&f&l Победила &" + winner.getColor() + "&l" + winner.getNames().split(", ")[0] + " команда&f&l!"));

            finishStrings.add(ColorUtil.getMessage("&7# "));
            for (Player winnerPlayer : winner.getPlayerSet()) {
                finishStrings.add(ColorUtil.getMessage("&7#   &" + winner.getColor() + winnerPlayer.getName()));
            }
            finishStrings.add(ColorUtil.getMessage("&7# "));

            finishStrings.add(ColorUtil.getMessage(line));
        } else {
            finishStrings.add(ColorUtil.getMessage(line));
            finishStrings.add(ColorUtil.getMessage(" &f&l НИЧЬЯ"));
            finishStrings.add(ColorUtil.getMessage(line));
        }
        return finishStrings;
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
        player.setCustomNameVisible(true);
    }

    public static void giveWaitingItems(Player player) {
        TeamSelector.giveTeamSelector(player);
    }

    public static void giveKit(Player player) {
        player.getInventory().clear();
        for (PotionEffect pe : player.getActivePotionEffects()) {
            player.removePotionEffect(pe.getType());
        }

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

    public static void playerRespawn(PlayerInfo playerInfo) {
        Player player = playerInfo.getPlayer();
        player.getInventory().clear();
        player.setGameMode(GameMode.SURVIVAL);

        giveKit(playerInfo.getPlayer());
        Location loc = getRandomSpawnLocation(playerInfo);
        playerInfo.getPlayer().teleport(loc);
        playerInfo.getPlayer().setBedSpawnLocation(loc, true);
    }

    public static void spawnTraders() {
        for (String key : BedWarsHard.getMapConfig().getTeams().keySet()) {
            BedTeam team = BedWarsHard.getMapConfig().getTeams().get(key);
            for (String position : team.getVillagers()) {
                Location traderSpawnLocation = YmlParser.parseLocation(Bukkit.getWorld("world"), position);
                Trader.spawn(traderSpawnLocation);
            }
        }
    }

    public static Location getRandomSpawnLocation(PlayerInfo playerInfo) {
        Random rand = new Random();
        int spawnNumber = rand.nextInt(playerInfo.getTeam().getSpawns().size());
        return YmlParser.parseLocation(Bukkit.getWorld("world"), playerInfo.getTeam().getSpawns().get(spawnNumber));
    }

    public static int getDelay() {
        return delay;
    }
}
