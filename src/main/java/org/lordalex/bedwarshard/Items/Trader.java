package org.lordalex.bedwarshard.Items;

import org.bukkit.*;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.Sandstone;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.lordalex.bedwarshard.BedWarsHard;
import org.lordalex.bedwarshard.Utils.ColorUtil;
import org.lordalex.bedwarshard.config.PlayerInfo;

import java.util.ArrayList;
import java.util.List;

public class Trader {
    public static void openGlobalMenu(Player p){
        Inventory inv = Bukkit.createInventory(null, 27, "Торговец");
        inv.setItem(0, ShopItem.blocksMenuStack());
        inv.setItem(1, ShopItem.armorMenuStack());
        inv.setItem(2, ShopItem.pickaxeMenuStack());
        inv.setItem(3, ShopItem.swordMenuStack());
        inv.setItem(4, ShopItem.bowMenuStack());
        inv.setItem(5, ShopItem.foodMenuStack());
        inv.setItem(6, ShopItem.chestsMenuStack());
        inv.setItem(7, ShopItem.potionMenuStack());
        inv.setItem(8, ShopItem.specialMenuStack());
        inv.setItem(13, ShopItem.exchangerMenuStack());
        p.openInventory(inv);
    }

    public static void openBlocksMenu(Player p){
        Inventory inv = Bukkit.createInventory(null, 18, "Блоки");
        inv.setItem(0, ShopItem.sandstone());
        inv.setItem(1, ShopItem.sandstoneStairs());
        inv.setItem(2, ShopItem.enderStone());
        inv.setItem(3, ShopItem.ironBlock());
        inv.setItem(4, ShopItem.glowStone());
        inv.setItem(5, ShopItem.coloredGlass(p));
        inv.setItem(6, ShopItem.slimeBlock());
        inv.setItem(13, ShopItem.returnButtonStack());
        p.openInventory(inv);
    }
    public static void openArmorMenu(Player p){
        Inventory inv = Bukkit.createInventory(null, 18, "Броня");
        inv.setItem(0, ShopItem.IronSetMenuStack());
        inv.setItem(1, ShopItem.ironChestplate1());
        inv.setItem(2, ShopItem.ironChestplate2());
        inv.setItem(3, ShopItem.diamondSetMenuStack());
        inv.setItem(4, ShopItem.diamondChestplate0());
        inv.setItem(5, ShopItem.diamondChestplate1());
        inv.setItem(6, ShopItem.diamondChestplate2());
        inv.setItem(7, ShopItem.diamondChestplate3());
        inv.setItem(13, ShopItem.returnButtonStack());
        p.openInventory(inv);
    }
    public static void openPickaxeMenu(Player p){
        Inventory inv = Bukkit.createInventory(null, 18, "Кирки");
        inv.setItem(0, ShopItem.stonePickaxe());
        inv.setItem(1, ShopItem.ironPickaxe());
        inv.setItem(2, ShopItem.diamondPickaxe1());
        inv.setItem(3, ShopItem.diamondPickaxe3());
        inv.setItem(13, ShopItem.returnButtonStack());
        p.openInventory(inv);
    }
    public static void openSwordMenu(Player p){
        Inventory inv = Bukkit.createInventory(null, 18, "Мечи");
        inv.setItem(0, ShopItem.ironSword());
        inv.setItem(1, ShopItem.diamondSword());
        inv.setItem(2, ShopItem.excalibur());
        inv.setItem(3, ShopItem.deathBringer());
        inv.setItem(4, ShopItem.killmagedon());
        inv.setItem(13, ShopItem.returnButtonStack());
        p.openInventory(inv);
    }
    public static void openBowMenu(Player p){
        Inventory inv = Bukkit.createInventory(null, 18, "Луки");
        inv.setItem(0, ShopItem.bow1());
        inv.setItem(1, ShopItem.bow2());
        inv.setItem(2, ShopItem.bow3());
        inv.setItem(3, ShopItem.bow4());
        inv.setItem(4, ShopItem.arrow());
        inv.setItem(13, ShopItem.returnButtonStack());
        p.openInventory(inv);
    }
    public static void openFoodMenu(Player p){
        Inventory inv = Bukkit.createInventory(null, 18, "Еда");
        inv.setItem(0, ShopItem.apple());
        inv.setItem(1, ShopItem.pork());
        inv.setItem(2, ShopItem.cake());
        inv.setItem(3, ShopItem.goldenApple());
        inv.setItem(13, ShopItem.returnButtonStack());
        p.openInventory(inv);
    }
    public static void openChestMenu(Player p){
        Inventory inv = Bukkit.createInventory(null, 18, "Сундуки");
        inv.setItem(0, ShopItem.chest());
        inv.setItem(1, ShopItem.enderChest());
        inv.setItem(13, ShopItem.returnButtonStack());
        p.openInventory(inv);
    }
    public static void openPotionMenu(Player p){
        Inventory inv = Bukkit.createInventory(null, 18, "Зелья");
        inv.setItem(0, ShopItem.potionHeal1());
        inv.setItem(1, ShopItem.potionHeal2());
        inv.setItem(2, ShopItem.potionSpeed());
        inv.setItem(3, ShopItem.potionRegen());
        inv.setItem(4, ShopItem.potionStrength());
        inv.setItem(5, ShopItem.potionInvisibility());
        inv.setItem(13, ShopItem.returnButtonStack());
        p.openInventory(inv);
    }
    public static void openSpecialMenu(Player p){
        Inventory inv = Bukkit.createInventory(null, 27, "Специальное");
        inv.setItem(0, ShopItem.ladder());
        inv.setItem(1, ShopItem.web());
        inv.setItem(2, ShopItem.fishingRod());
        inv.setItem(3, ShopItem.lighter());
        inv.setItem(4, ShopItem.TNT());
        inv.setItem(5, ShopItem.enderPearl());
        inv.setItem(9, ShopItem.teleportHome());
        inv.setItem(10, ShopItem.thorBone());
        inv.setItem(11, ShopItem.trackerGPS());
        inv.setItem(12, ShopItem.savingPlatform());
        inv.setItem(13, ShopItem.trap());
        inv.setItem(22, ShopItem.returnButtonStack());
        p.openInventory(inv);
    }
    public static void openExchangerMenu(Player p){
        Inventory inv = Bukkit.createInventory(null, 18, "Обмен валют");
        inv.setItem(0, ShopItem.bronzeToIronStack());
        inv.setItem(1, ShopItem.ironToGoldStack());
        inv.setItem(2, ShopItem.ironToBronzeStack());
        inv.setItem(3, ShopItem.goldToIronStack());
        inv.setItem(13, ShopItem.returnButtonStack());
        p.openInventory(inv);
    }

    public static void spawn(Location location){
        //Bukkit.getWorld("world").spawnEntity(location, EntityType.VILLAGER);
        Villager vil = (Villager) Bukkit.getWorld("world").spawnEntity(location, EntityType.VILLAGER);
        vil.setCustomName(ChatColor.YELLOW + "Торговец");
        vil.setCustomNameVisible(true);
        vil.setAdult();
        vil.setRemoveWhenFarAway(false);
        vil.setNoDamageTicks(20000 * 20);
        System.out.println("Trader spawned on loc: " + location.toString());
        vil.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 20000 * 20, 10, false, false));
    }
}
