package org.lordalex.bedwarshard.Utils;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.lordalex.bedwarshard.Items.TeamSelector;
import org.lordalex.bedwarshard.config.BedTeam;
import org.lordalex.bedwarshard.config.PlayerInfo;

import java.util.Random;

public class GameUtil {
    public static void clearPlayer(Player player){
        player.getInventory().clear();
        player.getInventory().setArmorContents(null);
        player.setHealth(20);
        player.setFoodLevel(20);
        player.setGameMode(GameMode.ADVENTURE);
        player.setCustomName("§f" + player.getName());
        player.setCustomNameVisible(true);
    }
    public static void giveWaitingItems(Player player){
        TeamSelector.giveTeamSelector(player);
    }
    public static void giveSpectatorItems(Player player){

    }
    public static void giveStartKit(Player player){

    }
    public static boolean hasBed(BedTeam team){
        for(String bedLoc : team.getBed()){
            Location loc = YmlParser.parseLocation(Bukkit.getWorld("world"), bedLoc);
            if(loc.getBlock().getType() != Material.BED_BLOCK) {
                return false;
            }
        }
        return true;
    }

    public static void playerRespawn(PlayerInfo playerInfo){
        BedTeam team = playerInfo.getTeam();
        Random rand = new Random();
        int spawnNumber = rand.nextInt(team.getSpawns().size());
        playerInfo.getPlayer().teleport(YmlParser.parseLocation(Bukkit.getWorld("world"), playerInfo.getTeam().getSpawns().get(spawnNumber)));
    }


    public static boolean isEqualsItem(InventoryClickEvent e, String itemDisplayName){
        if(e.getCurrentItem().getItemMeta().getDisplayName() != null) {
            return e.getCurrentItem().getItemMeta().getDisplayName().equals(ColorUtil.getMessage(itemDisplayName));
        }
        else{
            return false;
        }
    }
}
