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
import org.lordalex.bedwarshard.Utils.ColorUtil;

import java.util.ArrayList;
import java.util.List;

public class Trader {
    public static void openGlobalMenu(Player p){
        Inventory inv = Bukkit.createInventory(null, 27, "Торговец");

        ItemStack sandstoneStack = new ItemStack(Material.SANDSTONE, 1, (byte) 2);
        ItemMeta sandstoneMeta = sandstoneStack.getItemMeta();
        sandstoneStack.setData(new Sandstone(SandstoneType.SMOOTH));
        sandstoneMeta.setDisplayName(ColorUtil.getMessage("&l&bБлоки"));
        List<String> sandstoneList = new ArrayList<>();
        sandstoneList.add(ColorUtil.getMessage("&e- &7Песчаник"));
        sandstoneList.add(ColorUtil.getMessage("&e- &7Ступеньки из песчаника"));
        sandstoneList.add(ColorUtil.getMessage("&e- &7Эндерняк"));
        sandstoneList.add(ColorUtil.getMessage("&e- &7Железный блок"));
        sandstoneList.add(ColorUtil.getMessage("&e- &7Светокамень"));
        sandstoneList.add(ColorUtil.getMessage("&e- &7Стекло"));
        sandstoneMeta.setLore(sandstoneList);
        sandstoneStack.setItemMeta(sandstoneMeta);

        ItemStack armorStack = new ItemStack(Material.IRON_CHESTPLATE, 1);
        ItemMeta armorMeta = armorStack.getItemMeta();
        armorMeta.setDisplayName(ColorUtil.getMessage("&l&bБроня"));
        List<String> armorList = new ArrayList<>();
        armorList.add(ColorUtil.getMessage("&e- &7Железный сет"));
        armorList.add(ColorUtil.getMessage("&e- &aЖелезка уровень 1"));
        armorList.add(ColorUtil.getMessage("&e- &aЖелезка уровень 2"));
        armorList.add(ColorUtil.getMessage("&e- &7Алмазный сет"));
        armorList.add(ColorUtil.getMessage("&e- &fАлмазка уровень 0"));
        armorList.add(ColorUtil.getMessage("&e- &aАлмазка уровень 1"));
        armorList.add(ColorUtil.getMessage("&e- &bАлмазка уровень 2"));
        armorList.add(ColorUtil.getMessage("&e- &cАлмазка уровень 3"));
        armorMeta.setLore(armorList);
        armorStack.setItemMeta(armorMeta);

        ItemStack pickaxeStack = new ItemStack(Material.GOLD_PICKAXE, 1);
        ItemMeta pickaxeMeta = pickaxeStack.getItemMeta();
        pickaxeMeta.setDisplayName(ColorUtil.getMessage("&l&bКирки"));
        List<String> pickaxeList = new ArrayList<>();
        pickaxeList.add(ColorUtil.getMessage("&e-&7 Каменная кирка"));
        pickaxeList.add(ColorUtil.getMessage("&e-&7 Железная кирка"));
        pickaxeList.add(ColorUtil.getMessage("&e-&7 Алмазная кирка"));
        pickaxeMeta.setLore(pickaxeList);
        pickaxeStack.setItemMeta(pickaxeMeta);

        ItemStack swordStack = new ItemStack(Material.GOLD_SWORD, 1);
        ItemMeta swordMeta = swordStack.getItemMeta();
        swordMeta.setDisplayName(ColorUtil.getMessage("&l&bМечи"));
        List<String> swordList = new ArrayList<>();
        swordList.add(ColorUtil.getMessage("&e-&7 Железный меч"));
        swordList.add(ColorUtil.getMessage("&e-&a Алмеч"));
        swordList.add(ColorUtil.getMessage("&e-&b Экскалибур"));
        swordList.add(ColorUtil.getMessage("&e-&6 Смертоносец"));
        swordList.add(ColorUtil.getMessage("&e-&c Киллмагедон"));
        swordMeta.setLore(swordList);
        swordStack.setItemMeta(swordMeta);

        ItemStack bowStack = new ItemStack(Material.BOW, 1);
        ItemMeta bowMeta = bowStack.getItemMeta();
        bowMeta.setDisplayName(ColorUtil.getMessage("&l&bЛуки"));
        List<String> bowList = new ArrayList<>();
        bowList.add(ColorUtil.getMessage("&e-&a Лук уровень 1"));
        bowList.add(ColorUtil.getMessage("&e-&b Лук уровень 2"));
        bowList.add(ColorUtil.getMessage("&e-&c Лук уровень 3"));
        bowList.add(ColorUtil.getMessage("&e-&c Лукер"));
        bowList.add(ColorUtil.getMessage("&e-&7 Стрела"));
        bowMeta.setLore(bowList);
        bowStack.setItemMeta(bowMeta);

        ItemStack foodStack = new ItemStack(Material.APPLE, 1);
        ItemMeta foodMeta = foodStack.getItemMeta();
        foodMeta.setDisplayName(ColorUtil.getMessage("&l&bЕда"));
        List<String> foodList = new ArrayList<>();
        foodList.add(ColorUtil.getMessage("&e-&f Еда чемпионов"));
        foodList.add(ColorUtil.getMessage("&e-&7 Жареная свинина"));
        foodList.add(ColorUtil.getMessage("&e-&7 Торт"));
        foodList.add(ColorUtil.getMessage("&e-&7 Золотое яблоко"));
        foodMeta.setLore(foodList);
        foodStack.setItemMeta(foodMeta);

        ItemStack chestStack = new ItemStack(Material.CHEST, 1);
        ItemMeta chestMeta = chestStack.getItemMeta();
        chestMeta.setDisplayName(ColorUtil.getMessage("&l&bСундуки"));
        List<String> chestList = new ArrayList<>();
        chestList.add(ColorUtil.getMessage("&e-&a Сундук"));
        chestList.add(ColorUtil.getMessage("&e-&a Командный сундук"));
        chestMeta.setLore(chestList);
        chestStack.setItemMeta(chestMeta);

        ItemStack potionStack = new ItemStack(Material.POTION, 1);
        ItemMeta potionMeta = potionStack.getItemMeta();
        potionMeta.setDisplayName(ColorUtil.getMessage("&l&bЗелья"));
        List<String> potionList = new ArrayList<>();
        potionList.add(ColorUtil.getMessage("&e- Хилка уровень 1"));
        potionList.add(ColorUtil.getMessage("&e- Хилка уровень 2"));
        potionList.add(ColorUtil.getMessage("&e- Скорость"));
        potionList.add(ColorUtil.getMessage("&e- Зелье регенерации"));
        potionList.add(ColorUtil.getMessage("&e- Сила"));
        potionList.add(ColorUtil.getMessage("&e- Зелье невидимости"));
        potionMeta.setLore(potionList);
        potionStack.setItemMeta(potionMeta);

        ItemStack specialStack = new ItemStack(Material.TNT, 1);
        ItemMeta specialMeta = specialStack.getItemMeta();
        specialMeta.setDisplayName(ColorUtil.getMessage("&l&bСпециальное"));
        List<String> specialList = new ArrayList<>();
        specialList.add(ColorUtil.getMessage("&e-&7 Лестница"));
        specialList.add(ColorUtil.getMessage("&e-&7 Паутина"));
        specialList.add(ColorUtil.getMessage("&e-&7 Удочка"));
        specialList.add(ColorUtil.getMessage("&e-&7 Зажигалка"));
        specialList.add(ColorUtil.getMessage("&e-&7 Динамит"));
        specialList.add(ColorUtil.getMessage("&e-&7 Жемчуг края"));
        specialList.add(ColorUtil.getMessage("&e-&b Телепорт домой (&e6 сек.&b)"));
        specialList.add(ColorUtil.getMessage("&e-&b Кость тора"));
        specialList.add(ColorUtil.getMessage("&e- GPS трекер"));
        specialList.add(ColorUtil.getMessage("&e-&b Спасательная платформа"));
        specialList.add(ColorUtil.getMessage("&e-&b Ловушка"));
        specialMeta.setLore(specialList);
        specialStack.setItemMeta(specialMeta);

        ItemStack changingStack = new ItemStack(Material.GOLD_INGOT, 1);
        ItemMeta changingMeta = changingStack.getItemMeta();
        changingMeta.setDisplayName(ColorUtil.getMessage("&l&bОбмен валют"));
        List<String> changingList = new ArrayList<>();
        changingList.add(ColorUtil.getMessage("&e-&f 1 железо за&6 48 бронзы"));
        changingList.add(ColorUtil.getMessage("&e-&e 1 золото&f за 14 железа"));
        changingList.add(ColorUtil.getMessage("&e-&6 32 бронзы&f за 1 железо"));
        changingList.add(ColorUtil.getMessage("&e-&f 7 железа за&e 1 золото"));
        changingMeta.setLore(changingList);
        changingStack.setItemMeta(changingMeta);

        inv.setItem(0, sandstoneStack);
        inv.setItem(1, armorStack);
        inv.setItem(2, pickaxeStack);
        inv.setItem(3, swordStack);
        inv.setItem(4, bowStack);
        inv.setItem(5, foodStack);
        inv.setItem(6, chestStack);
        inv.setItem(7, potionStack);
        inv.setItem(8, specialStack);
        inv.setItem(13, changingStack);
        p.openInventory(inv);
    }

    public static void openBlocksMenu(Player p){
        Inventory inv = Bukkit.createInventory(null, 18, "Блоки");

        ItemStack sandstoneStack = new ItemStack(Material.SANDSTONE, 2, (byte) 2);
        ItemMeta sandstoneMeta = sandstoneStack.getItemMeta();
        sandstoneMeta.setDisplayName(ColorUtil.getMessage("&fГладкий песчаник"));
        List<String> sandstoneList = new ArrayList<>();
        sandstoneList.add(ColorUtil.getMessage("&dЦена: &61 бронза"));
        sandstoneMeta.setLore(sandstoneList);
        sandstoneStack.setItemMeta(sandstoneMeta);

        ItemStack sandstoneStairsStack = new ItemStack(Material.SANDSTONE_STAIRS, 2);
        ItemMeta sandstoneStairsMeta = sandstoneStairsStack.getItemMeta();
        sandstoneStairsMeta.setDisplayName(ColorUtil.getMessage("&fСтупеньки из песчаника"));
        List<String> sandstoneStairsList = new ArrayList<>();
        sandstoneStairsList.add(ColorUtil.getMessage("&dЦена: &63 бронзы"));
        sandstoneStairsMeta.setLore(sandstoneStairsList);
        sandstoneStairsStack.setItemMeta(sandstoneStairsMeta);

        ItemStack enderstoneStairsStack = new ItemStack(Material.ENDER_STONE, 1);
        ItemMeta enderstoneStairsMeta = enderstoneStairsStack.getItemMeta();
        enderstoneStairsMeta.setDisplayName(ColorUtil.getMessage("&fЭндерняк"));
        List<String> enderstoneStairsList = new ArrayList<>();
        enderstoneStairsList.add(ColorUtil.getMessage("&dЦена: &67 бронзы"));
        enderstoneStairsMeta.setLore(enderstoneStairsList);
        enderstoneStairsStack.setItemMeta(enderstoneStairsMeta);

        ItemStack ironblockStairsStack = new ItemStack(Material.IRON_BLOCK, 1);
        ItemMeta ironblockStairsMeta = ironblockStairsStack.getItemMeta();
        ironblockStairsMeta.setDisplayName(ColorUtil.getMessage("&fЖелезный блок"));
        List<String> ironblockStairsList = new ArrayList<>();
        ironblockStairsList.add(ColorUtil.getMessage("&dЦена: &f3 железа"));
        ironblockStairsMeta.setLore(ironblockStairsList);
        ironblockStairsStack.setItemMeta(ironblockStairsMeta);

        ItemStack glowstoneStairsStack = new ItemStack(Material.GLOWSTONE, 4);
        ItemMeta glowstoneStairsMeta = glowstoneStairsStack.getItemMeta();
        glowstoneStairsMeta.setDisplayName(ColorUtil.getMessage("&fСветящийся камень"));
        List<String> glowstoneStairsList = new ArrayList<>();
        glowstoneStairsList.add(ColorUtil.getMessage("&dЦена: &616 бронзы"));
        glowstoneStairsMeta.setLore(glowstoneStairsList);
        glowstoneStairsStack.setItemMeta(glowstoneStairsMeta);

        ItemStack glassStairsStack = new ItemStack(Material.GLASS, 1);
        ItemMeta glassStairsMeta = glassStairsStack.getItemMeta();
        glassStairsMeta.setDisplayName(ColorUtil.getMessage("&fСтекло"));
        List<String> glassStairsList = new ArrayList<>();
        glassStairsList.add(ColorUtil.getMessage("&dЦена: &64 бронзы"));
        glassStairsMeta.setLore(glassStairsList);
        glassStairsStack.setItemMeta(glassStairsMeta);

        ItemStack bedStack = new ItemStack(Material.BED, 1);
        ItemMeta bedMeta = bedStack.getItemMeta();
        bedMeta.setDisplayName(ColorUtil.getMessage("&f← &eНазад"));
        bedStack.setItemMeta(bedMeta);

        inv.setItem(0, sandstoneStack);
        inv.setItem(1, sandstoneStairsStack);
        inv.setItem(2, enderstoneStairsStack);
        inv.setItem(3, ironblockStairsStack);
        inv.setItem(4, glowstoneStairsStack);
        inv.setItem(5, glassStairsStack);
        inv.setItem(13, bedStack);

        p.openInventory(inv);
    }
    public static void openArmorMenu(Player p){
        Inventory inv = Bukkit.createInventory(null, 18, "Броня");

        ItemStack ironLegsStack = new ItemStack(Material.IRON_LEGGINGS, 1);
        ItemMeta ironLegsMeta = ironLegsStack.getItemMeta();
        ironLegsMeta.setDisplayName(ColorUtil.getMessage("&fЖелезный сет"));
        List<String> ironLegsList = new ArrayList<>();
        ironLegsList.add(ColorUtil.getMessage("&7Железный шлем"));
        ironLegsList.add(ColorUtil.getMessage("&7Железные штаны"));
        ironLegsList.add(ColorUtil.getMessage("&7Железные ботинки"));
        ironLegsList.add(ColorUtil.getMessage("&dЦена: &66 бронзы"));
        ironLegsMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
        ironLegsMeta.setLore(ironLegsList);
        ironLegsStack.setItemMeta(ironLegsMeta);

        ItemStack ironChestplateStack = new ItemStack(Material.IRON_CHESTPLATE, 1);
        ItemMeta ironChestplateMeta = ironChestplateStack.getItemMeta();
        ironChestplateMeta.setDisplayName(ColorUtil.getMessage("&aЖелезка уровень 1"));
        List<String> ironChestplateList = new ArrayList<>();
        ironChestplateList.add(ColorUtil.getMessage("&dЦена: &f1 железо"));
        ironChestplateMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
        ironChestplateMeta.setLore(ironChestplateList);
        ironChestplateStack.setItemMeta(ironChestplateMeta);

        ItemStack bedStack = new ItemStack(Material.BED, 1);
        ItemMeta bedMeta = bedStack.getItemMeta();
        bedMeta.setDisplayName(ColorUtil.getMessage("&f← &eНазад"));
        bedStack.setItemMeta(bedMeta);

        inv.setItem(0, ironLegsStack);
        inv.setItem(1, ironChestplateStack);
        inv.setItem(13, bedStack);

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
