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
//        for(int i = 0; i < ShopItem.globalMenuStacks().size()-1; i++){
//            inv.setItem(i, ShopItem.globalMenuStacks().get(i));
//        }
//        inv.setItem(13, ShopItem.globalMenuStacks().get(ShopItem.globalMenuStacks().size()-1));
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
    public static void openSpecialMenu(Player p){
        Inventory inv = Bukkit.createInventory(null, 18, "Специальное");

        ItemStack webStack = new ItemStack(Material.WEB, 1);
        ItemMeta webMeta = webStack.getItemMeta();
        webMeta.setDisplayName(ColorUtil.getMessage("&fПаутинка"));
        List<String> webList = new ArrayList<>();
        webList.add(ColorUtil.getMessage("&dЦена: &624 бронзы"));
        webMeta.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
        webMeta.addEnchant(Enchantment.DURABILITY, 1, true);
        webMeta.setLore(webList);
        webStack.setItemMeta(webMeta);

        ItemStack fishingRodStack = new ItemStack(Material.FISHING_ROD, 1);
        ItemMeta fishingRodMeta = fishingRodStack.getItemMeta();
        fishingRodMeta.setDisplayName(ColorUtil.getMessage("&fУдочка"));
        List<String> fishingRodList = new ArrayList<>();
        fishingRodList.add(ColorUtil.getMessage("&dЦена: &f5 железа"));
        fishingRodMeta.setLore(fishingRodList);
        fishingRodStack.setItemMeta(fishingRodMeta);

        ItemStack teleportStack = new ItemStack(Material.SULPHUR, 1);
        ItemMeta teleportMeta = teleportStack.getItemMeta();
        teleportMeta.setDisplayName(ColorUtil.getMessage("&bТелепорт домой"));
        List<String> teleportList = new ArrayList<>();
        teleportList.add(ColorUtil.getMessage("&dЦена: &f3 железа"));
        teleportMeta.setLore(teleportList);
        teleportStack.setItemMeta(teleportMeta);

        ItemStack gpsStack = new ItemStack(Material.COMPASS, 1);
        ItemMeta gpsMeta = gpsStack.getItemMeta();
        gpsMeta.setDisplayName(ColorUtil.getMessage("&eGPS трекер"));
        List<String> gpsList = new ArrayList<>();
        gpsList.add(ColorUtil.getMessage("&dЦена: &f3 железа"));
        gpsMeta.setLore(gpsList);
        gpsStack.setItemMeta(gpsMeta);

        ItemStack platformStack = new ItemStack(Material.BLAZE_ROD, 1);
        ItemMeta platformMeta = platformStack.getItemMeta();
        platformMeta.setDisplayName(ColorUtil.getMessage("&bСпасательная платформа"));
        List<String> platformList = new ArrayList<>();
        platformList.add(ColorUtil.getMessage("&7 Спаси себя от падения!"));
        platformList.add(ColorUtil.getMessage("&7В течение &f10 секунд &7вы будете"));
        platformList.add(ColorUtil.getMessage("&7стоять на стеклянной платформе."));
        platformList.add(ColorUtil.getMessage("&7стоять на стеклянной платформе."));
        platformList.add(ColorUtil.getMessage("&dЦена: &f14 железа"));
        platformMeta.setLore(platformList);
        platformStack.setItemMeta(platformMeta);

        ItemStack bedStack = new ItemStack(Material.BED, 1);
        ItemMeta bedMeta = bedStack.getItemMeta();
        bedMeta.setDisplayName(ColorUtil.getMessage("&f← &eНазад"));
        bedStack.setItemMeta(bedMeta);

        inv.setItem(0, webStack);
        inv.setItem(1, fishingRodStack);
        inv.setItem(2, teleportStack);
        inv.setItem(3, platformStack);
        inv.setItem(4, gpsStack);
        inv.setItem(13, bedStack);

        p.openInventory(inv);
    }

    public static void spawn(Location location){
        Villager vil = (Villager) location.getWorld().spawnEntity(location, EntityType.VILLAGER);
        vil.setCustomName(ChatColor.YELLOW + "Торговец");
        vil.setCustomNameVisible(true);
        vil.setAdult();
        vil.setNoDamageTicks(216000);
    }
}
