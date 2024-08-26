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

        ItemStack stonePickaxeStack = new ItemStack(Material.STONE_PICKAXE, 1);
        ItemMeta stonePickaxeMeta = stonePickaxeStack.getItemMeta();
        stonePickaxeMeta.setDisplayName(ColorUtil.getMessage("&bКаменная кирка"));
        List<String> stonePickaxeList = new ArrayList<>();
        stonePickaxeList.add(ColorUtil.getMessage("&dЦена: &64 бронзы"));
        stonePickaxeMeta.addEnchant(Enchantment.DIG_SPEED, 1, true);
        stonePickaxeMeta.setLore(stonePickaxeList);
        stonePickaxeStack.setItemMeta(stonePickaxeMeta);

        ItemStack ironPickaxeStack = new ItemStack(Material.IRON_PICKAXE, 1);
        ItemMeta ironPickaxeMeta = ironPickaxeStack.getItemMeta();
        ironPickaxeMeta.setDisplayName(ColorUtil.getMessage("&bЖелезная кирка"));
        List<String> ironPickaxeList = new ArrayList<>();
        ironPickaxeList.add(ColorUtil.getMessage("&dЦена: &f2 железа"));
        ironPickaxeMeta.addEnchant(Enchantment.DIG_SPEED, 1, true);
        ironPickaxeMeta.setLore(ironPickaxeList);
        ironPickaxeStack.setItemMeta(ironPickaxeMeta);

        ItemStack diamond1PickaxeStack = new ItemStack(Material.DIAMOND_PICKAXE, 1);
        ItemMeta diamond1PickaxeMeta = diamond1PickaxeStack.getItemMeta();
        diamond1PickaxeMeta.setDisplayName(ColorUtil.getMessage("&bАлмазная кирка"));
        List<String> diamond1PickaxeList = new ArrayList<>();
        diamond1PickaxeList.add(ColorUtil.getMessage("&dЦена: &e2 золота"));
        diamond1PickaxeMeta.addEnchant(Enchantment.DIG_SPEED, 1, true);
        diamond1PickaxeMeta.setLore(diamond1PickaxeList);
        diamond1PickaxeStack.setItemMeta(diamond1PickaxeMeta);

        ItemStack diamond2PickaxeStack = new ItemStack(Material.DIAMOND_PICKAXE, 1);
        ItemMeta diamond2PickaxeMeta = diamond2PickaxeStack.getItemMeta();
        diamond2PickaxeMeta.setDisplayName(ColorUtil.getMessage("&bАлмазная кирка"));
        List<String> diamond2PickaxeList = new ArrayList<>();
        diamond2PickaxeList.add(ColorUtil.getMessage("&dЦена: &e8 золота"));
        diamond2PickaxeMeta.addEnchant(Enchantment.DIG_SPEED, 3, true);
        diamond2PickaxeMeta.setLore(diamond2PickaxeList);
        diamond2PickaxeStack.setItemMeta(diamond2PickaxeMeta);

        ItemStack bedStack = new ItemStack(Material.BED, 1);
        ItemMeta bedMeta = bedStack.getItemMeta();
        bedMeta.setDisplayName(ColorUtil.getMessage("&f← &eНазад"));
        bedStack.setItemMeta(bedMeta);

        inv.setItem(0, stonePickaxeStack);
        inv.setItem(1, ironPickaxeStack);
        inv.setItem(2, diamond1PickaxeStack);
        inv.setItem(3, diamond2PickaxeStack);
        inv.setItem(13, bedStack);

        p.openInventory(inv);
    }
    public static void openSwordMenu(Player p){
        Inventory inv = Bukkit.createInventory(null, 18, "Мечи");

        ItemStack ironSwordStack = new ItemStack(Material.IRON_SWORD, 1);
        ItemMeta ironSwordMeta = ironSwordStack.getItemMeta();
        ironSwordMeta.setDisplayName(ColorUtil.getMessage("&bЖелезный меч"));
        List<String> ironSwordList = new ArrayList<>();
        ironSwordList.add(ColorUtil.getMessage("&dЦена: &63 бронзы"));
        ironSwordMeta.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
        ironSwordMeta.addEnchant(Enchantment.DURABILITY, 1, true);
        ironSwordMeta.setLore(ironSwordList);
        ironSwordStack.setItemMeta(ironSwordMeta);

        ItemStack diamondSwordStack = new ItemStack(Material.DIAMOND_SWORD, 1);
        ItemMeta diamondSwordMeta = diamondSwordStack.getItemMeta();
        diamondSwordMeta.setDisplayName(ColorUtil.getMessage("&aАлмеч"));
        List<String> diamondSwordList = new ArrayList<>();
        diamondSwordList.add(ColorUtil.getMessage("&dЦена: &f1 железо"));
        diamondSwordMeta.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
        diamondSwordMeta.addEnchant(Enchantment.DURABILITY, 1, true);
        diamondSwordMeta.setLore(diamondSwordList);
        diamondSwordStack.setItemMeta(diamondSwordMeta);

        ItemStack excaliburSwordStack = new ItemStack(Material.DIAMOND_SWORD, 1);
        ItemMeta excaliburSwordMeta = excaliburSwordStack.getItemMeta();
        excaliburSwordMeta.setDisplayName(ColorUtil.getMessage("&bЭкскалибур"));
        List<String> excaliburSwordList = new ArrayList<>();
        excaliburSwordList.add(ColorUtil.getMessage("&dЦена: &f5 железа"));
        excaliburSwordMeta.addEnchant(Enchantment.DAMAGE_ALL, 2, true);
        excaliburSwordMeta.addEnchant(Enchantment.DURABILITY, 1, true);
        excaliburSwordMeta.addEnchant(Enchantment.KNOCKBACK, 1, true);
        excaliburSwordMeta.setLore(excaliburSwordList);
        excaliburSwordStack.setItemMeta(excaliburSwordMeta);

        ItemStack deathBringerSwordStack = new ItemStack(Material.DIAMOND_SWORD, 1);
        ItemMeta deathBringerSwordMeta = deathBringerSwordStack.getItemMeta();
        deathBringerSwordMeta.setDisplayName(ColorUtil.getMessage("&6Смертоносец"));
        List<String> deathBringerSwordList = new ArrayList<>();
        deathBringerSwordList.add(ColorUtil.getMessage("&dЦена: &e6 золота"));
        deathBringerSwordMeta.addEnchant(Enchantment.DAMAGE_ALL, 3, true);
        deathBringerSwordMeta.addEnchant(Enchantment.DURABILITY, 1, true);
        deathBringerSwordMeta.addEnchant(Enchantment.KNOCKBACK, 1, true);
        deathBringerSwordMeta.setLore(deathBringerSwordList);
        deathBringerSwordStack.setItemMeta(deathBringerSwordMeta);

        ItemStack killmagedonSwordStack = new ItemStack(Material.DIAMOND_SWORD, 1);
        ItemMeta killmagedonSwordMeta = killmagedonSwordStack.getItemMeta();
        killmagedonSwordMeta.setDisplayName(ColorUtil.getMessage("&cКиллмагедон"));
        List<String> killmagedonSwordList = new ArrayList<>();
        killmagedonSwordList.add(ColorUtil.getMessage("&dЦена: &e30 золота"));
        killmagedonSwordMeta.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
        killmagedonSwordMeta.addEnchant(Enchantment.DURABILITY, 1, true);
        killmagedonSwordMeta.addEnchant(Enchantment.KNOCKBACK, 2, true);
        killmagedonSwordMeta.addEnchant(Enchantment.FIRE_ASPECT, 1, true);
        killmagedonSwordMeta.setLore(killmagedonSwordList);
        killmagedonSwordStack.setItemMeta(killmagedonSwordMeta);

        ItemStack bedStack = new ItemStack(Material.BED, 1);
        ItemMeta bedMeta = bedStack.getItemMeta();
        bedMeta.setDisplayName(ColorUtil.getMessage("&f← &eНазад"));
        bedStack.setItemMeta(bedMeta);

        inv.setItem(0, ironSwordStack);
        inv.setItem(1, diamondSwordStack);
        inv.setItem(2, excaliburSwordStack);
        inv.setItem(3, deathBringerSwordStack);
        inv.setItem(4, killmagedonSwordStack);
        inv.setItem(13, bedStack);

        p.openInventory(inv);
    }
    public static void openFoodMenu(Player p){
        Inventory inv = Bukkit.createInventory(null, 18, "Еда");

        ItemStack appleStack = new ItemStack(Material.APPLE, 1);
        ItemMeta appleMeta = appleStack.getItemMeta();
        appleMeta.setDisplayName(ColorUtil.getMessage("&fЕда чемпионов"));
        List<String> appleList = new ArrayList<>();
        appleList.add(ColorUtil.getMessage("&dЦена: &61 бронза"));
        appleMeta.setLore(appleList);
        appleStack.setItemMeta(appleMeta);

        ItemStack porkStack = new ItemStack(Material.GRILLED_PORK, 1);
        ItemMeta porkMeta = porkStack.getItemMeta();
        porkMeta.setDisplayName(ColorUtil.getMessage("&fЖареная свинина"));
        List<String> porkList = new ArrayList<>();
        porkList.add(ColorUtil.getMessage("&dЦена: &62 бронзы"));
        porkMeta.setLore(porkList);
        porkStack.setItemMeta(porkMeta);


        ItemStack bedStack = new ItemStack(Material.BED, 1);
        ItemMeta bedMeta = bedStack.getItemMeta();
        bedMeta.setDisplayName(ColorUtil.getMessage("&f← &eНазад"));
        bedStack.setItemMeta(bedMeta);

        inv.setItem(0, appleStack);
        inv.setItem(1, porkStack);
        inv.setItem(13, bedStack);

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
