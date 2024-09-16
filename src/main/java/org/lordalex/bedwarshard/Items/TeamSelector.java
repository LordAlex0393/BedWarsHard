package org.lordalex.bedwarshard.Items;

import org.bukkit.*;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.lordalex.bedwarshard.BedWarsHard;
import org.lordalex.bedwarshard.Utils.ColorUtil;
import org.lordalex.bedwarshard.Utils.CustomScoreboard;
import org.lordalex.bedwarshard.Utils.GameUtil;
import org.lordalex.bedwarshard.Utils.ResourceUtil;
import org.lordalex.bedwarshard.config.BedTeam;
import org.lordalex.bedwarshard.config.PlayerInfo;

import java.util.*;

public class TeamSelector implements Listener {
    public static void giveTeamSelector(Player player) {
        if (!player.getInventory().contains(Material.NAME_TAG)) {
            ItemStack NameTagStack = new ItemStack(Material.NAME_TAG, 1);
            ItemMeta NameTagMeta = NameTagStack.getItemMeta();
            NameTagMeta.setDisplayName(ColorUtil.getMessage("&f>> &e&lВыбор команды&f <<"));
            NameTagStack.setItemMeta(NameTagMeta);
            player.getInventory().addItem(NameTagStack);
        }
    }

    @EventHandler
    public void onTeamMenuOpen(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        if (e.getItem() == null) return;
        if (!(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK)) return;
        if (!(e.getItem().getType() == Material.NAME_TAG)) return;

        player.openInventory(createSelectorMenu());
        player.updateInventory();
    }

    @EventHandler
    public void onTeamSelect(InventoryClickEvent e) {
        if (e == null) return;

        Player player = (Player) e.getView().getPlayer();
        int teamSize = BedWarsHard.getMapConfig().getTeamPlayers();
        HashMap<String, BedTeam> teamMap = BedWarsHard.getMapConfig().getTeams();

        if (e.getView().getTitle().equals("Выбор команды")) {
            e.setCancelled(true);
            if (e.getCurrentItem() != null && e.getCurrentItem().getItemMeta() != null) {
                for (String key : teamMap.keySet()) {
                    BedTeam team = teamMap.get(key);
                    String[] teamNames = team.getNames().split(",");

                    if (ResourceUtil.isEqualsItem(e, "&" + team.getColor() + teamNames[0] + " команда&f [" + team.getAlivePlayersInfo().size() + "/" + teamSize + "]")) {
                        if (team.getAlivePlayersInfo().size() >= BedWarsHard.getMapConfig().getTeamPlayers()) {
                            return;
                        }

                        for (String k : teamMap.keySet()) {
                            teamMap.get(k).removePlayer(player);
                        }
                        PlayerInfo playerInfo = new PlayerInfo(player, team);
                        BedWarsHard.getGame().addPlayerInfo(playerInfo);

                        for (Player p : Bukkit.getOnlinePlayers()) {
                            if (e.getInventory().getTitle().equals(p.getOpenInventory().getTitle())) {
                                p.openInventory(createSelectorMenu());
                            }
                        }

                        setPlayerTeam(player, team);

                        player.closeInventory();
                        for(Player all : Bukkit.getOnlinePlayers()){
                            CustomScoreboard.updateScoreboard(all);
                        }
                    }
                    else if (ResourceUtil.isEqualsItem(e, "&fВыйти из команды")) {
                        for (String k : teamMap.keySet()) {
                            teamMap.get(k).removePlayer(player);
                        }
                        BedWarsHard.getGame().removePlayer(player);

                        player.setCustomName("§f" + player.getName());
                        player.setPlayerListName(ColorUtil.getMessage("&f" + player.getName()));
                        player.closeInventory();
                        for(Player all : Bukkit.getOnlinePlayers()){
                            CustomScoreboard.updateScoreboard(all);
                        }
                    }
                }
            }
        }
    }

    private static Inventory createSelectorMenu() {
        Inventory inv = Bukkit.createInventory(null, 36, "Выбор команды");
        HashMap<String, BedTeam> teamMap = BedWarsHard.getMapConfig().getTeams();

        int teamsAmount = teamMap.size();
        int[] slots;
        if (teamsAmount == 2) {
            slots = new int[]{11, 15};
        } else if (teamsAmount == 4) {
            slots = new int[]{10, 12, 14, 16};
        } else {
            slots = new int[]{9, 10, 11, 12, 14, 15, 16, 17};
        }

        int i = 0;
        for (String key : teamMap.keySet()) {
            BedTeam team = teamMap.get(key);
            String[] teamNames = team.getNames().split(",");
            int teamSize = BedWarsHard.getMapConfig().getTeamPlayers();


            ItemStack woolStack = new ItemStack(Material.WOOL, 1, (byte) team.getWool());
            ItemMeta woolMeta = woolStack.getItemMeta();
            woolMeta.setDisplayName(ColorUtil.getMessage("&" + team.getColor() + teamNames[0] + " команда&f [" + team.getAlivePlayersInfo().size() + "/" + teamSize + "]"));
            List<String> woolList = new ArrayList<>();
            HashSet<Player> teamPlayerSet = team.getPlayerSet();
            if (teamPlayerSet.size() < teamSize) {
                woolList.add(ColorUtil.getMessage("&e⇒&7 Нажмите для выбора"));
            }
            if (!teamPlayerSet.isEmpty()) {
                woolList.add(" ");
            }
            for (Player player : teamPlayerSet) {
                woolList.add(ColorUtil.getMessage("&7" + player.getName()));
            }
            woolMeta.setLore(woolList);
            woolStack.setItemMeta(woolMeta);
            inv.setItem(slots[i], woolStack);
            i++;
        }

        ItemStack barrierStack = new ItemStack(Material.BARRIER, 1);
        ItemMeta barrierMeta = barrierStack.getItemMeta();
        barrierMeta.setDisplayName(ColorUtil.getMessage("&fВыйти из команды"));
        List<String> barrierList = new ArrayList<>();
        barrierList.add(ColorUtil.getMessage("&7Нажмите для выбора"));
        barrierMeta.setLore(barrierList);
        barrierMeta.addEnchant(Enchantment.KNOCKBACK, 1, false);
        barrierMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        barrierStack.setItemMeta(barrierMeta);
        inv.setItem(31, barrierStack);

        return inv;
    }
    public static void randomizeTeam(Player player){
        BedTeam team = BedWarsHard.getMapConfig().getTeams().get(getByRandomClass(BedWarsHard.getMapConfig().getTeams().keySet()));
        int minSize = team.getAlivePlayersInfo().size();

        for(String key : BedWarsHard.getMapConfig().getTeams().keySet()){
            BedTeam tempTeam = BedWarsHard.getMapConfig().getTeams().get(key);
            int tempMin = tempTeam.getAlivePlayersInfo().size();
            if(tempMin < minSize){
                team = tempTeam;
                minSize = tempMin;
            }
        }
        setPlayerTeam(player, team);
    }

    public static void setPlayerTeam(Player player, BedTeam team){
        BedWarsHard.getGame().addPlayerInfo(new PlayerInfo(player, team));
        player.setCustomName("§" + team.getColor() + player.getName());
        player.setCustomNameVisible(true);
        player.setPlayerListName(ColorUtil.getMessage("&" + team.getColor() + player.getName()));
        player.sendMessage(ColorUtil.getMessage("Вы играете за&" + team.getColor() + team.getNames().split(",")[1] + " команду"));
    }

    private static <T> T getByRandomClass(Set<T> set) {
        if (set == null || set.isEmpty()) {
            throw new IllegalArgumentException("The Set cannot be empty.");
        }
        int randomIndex = new Random().nextInt(set.size());
        int i = 0;
        for (T element : set) {
            if (i == randomIndex) {
                return element;
            }
            i++;
        }
        throw new IllegalStateException("Something went wrong while picking a random element.");
    }
}
