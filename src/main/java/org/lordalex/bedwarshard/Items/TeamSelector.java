package org.lordalex.bedwarshard.Items;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.lordalex.bedwarshard.BedWarsHard;
import org.lordalex.bedwarshard.Utils.ColorUtil;
import org.lordalex.bedwarshard.config.BedTeam;

import java.util.HashMap;

public class TeamSelector implements Listener {
    public static void giveTeamSelector(Player player){
        if(!player.getInventory().contains(Material.NAME_TAG))
        {
            ItemStack NameTagStack = new ItemStack(Material.NAME_TAG, 1);
            ItemMeta NameTagMeta = NameTagStack.getItemMeta();
            NameTagMeta.setDisplayName(ColorUtil.getMessage("&eВыбор команды"));
            NameTagStack.setItemMeta(NameTagMeta);
            player.getInventory().addItem(NameTagStack);
        }
    }


    @EventHandler
    public void onTeamMenuClick(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        if(e.getItem() == null) return;
        if (!(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK)) return;
        if (!(e.getItem().getType() == Material.NAME_TAG)) return;

        Inventory inv = Bukkit.createInventory(null, 27, "Выбор команды");
        HashMap<String, BedTeam> teamMap = BedWarsHard.getMapConfig().getTeams();

        int teamsAmount = teamMap.size();
        int[] slots;
        if(teamsAmount == 2){
            slots = new int[]{11, 15};
        }
        else if(teamsAmount == 4){
            slots = new int[]{10, 12, 14, 16};
        }
        else{
            slots = new int[]{9, 10, 11, 12, 14, 15, 16, 17};
        }

        int i = 0;
        for(String key : BedWarsHard.getMapConfig().getTeams().keySet()){
            BedTeam team = BedWarsHard.getMapConfig().getTeams().get(key);
            String fullStr = team.getNames();
            String teamName = fullStr.substring(0, fullStr.indexOf(','));


            ItemStack woolStack = new ItemStack( Material.WOOL, 1, (byte)team.getWool());
            ItemMeta woolMeta = woolStack.getItemMeta();
            woolMeta.setDisplayName(ColorUtil.getMessage("&" + team.getColor() + teamName + " команда"));
            woolStack.setItemMeta(woolMeta);
            inv.setItem(slots[i], woolStack);
            i++;
        }
        player.openInventory(inv);
    }
}
