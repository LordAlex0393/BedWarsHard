package org.lordalex.bedwarshard.Items;

import org.bukkit.Material;
import org.bukkit.SandstoneType;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.material.Sandstone;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.lordalex.bedwarshard.BedWarsHard;
import org.lordalex.bedwarshard.Utils.ColorUtil;
import org.lordalex.bedwarshard.config.PlayerInfo;

import java.util.ArrayList;
import java.util.List;

public class ShopItem {
    public static ItemStack returnButtonStack(){
        ItemStack bedStack = new ItemStack(Material.BED, 1);
        ItemMeta bedMeta = bedStack.getItemMeta();
        bedMeta.setDisplayName(ColorUtil.getMessage("&f← &eНазад"));
        bedStack.setItemMeta(bedMeta);
        return bedStack;
    }

    public static List<ItemStack> globalMenuStacks(){
        List<ItemStack> globalMenuStacks = new ArrayList<>();
        globalMenuStacks.add(blocksMenuStack());
        globalMenuStacks.add(armorMenuStack());
        globalMenuStacks.add(pickaxeMenuStack());
        globalMenuStacks.add(swordMenuStack());
        globalMenuStacks.add(bowMenuStack());
        globalMenuStacks.add(foodMenuStack());
        globalMenuStacks.add(chestsMenuStack());
        globalMenuStacks.add(potionMenuStack());
        globalMenuStacks.add(specialMenuStack());
        globalMenuStacks.add(exchangerMenuStack());
        return globalMenuStacks;
    }


    public static ItemStack blocksMenuStack(){
        ItemStack blocksMenuStack = new ItemStack(Material.SANDSTONE, 1, (byte) 2);
        ItemMeta blocksMenuMeta = blocksMenuStack.getItemMeta();
        blocksMenuStack.setData(new Sandstone(SandstoneType.SMOOTH));
        blocksMenuMeta.setDisplayName(ColorUtil.getMessage("&l&bБлоки"));
        List<String> sandstoneList = new ArrayList<>();
        sandstoneList.add(ColorUtil.getMessage("&e- &7Песчаник"));
        sandstoneList.add(ColorUtil.getMessage("&e- &7Ступеньки из песчаника"));
        sandstoneList.add(ColorUtil.getMessage("&e- &7Эндерняк"));
        sandstoneList.add(ColorUtil.getMessage("&e- &7Железный блок"));
        sandstoneList.add(ColorUtil.getMessage("&e- &7Светокамень"));
        sandstoneList.add(ColorUtil.getMessage("&e- &7Стекло"));
        blocksMenuMeta.setLore(sandstoneList);
        blocksMenuStack.setItemMeta(blocksMenuMeta);
        return blocksMenuStack;
    }
    public static ItemStack armorMenuStack(){
        ItemStack armorMenuStack = new ItemStack(Material.IRON_CHESTPLATE, 1);
        ItemMeta armorMenuMeta = armorMenuStack.getItemMeta();
        armorMenuMeta.setDisplayName(ColorUtil.getMessage("&l&bБроня"));
        List<String> armorList = new ArrayList<>();
        armorList.add(ColorUtil.getMessage("&e- &7Железный сет"));
        armorList.add(ColorUtil.getMessage("&e- &aЖелезка уровень 1"));
        armorList.add(ColorUtil.getMessage("&e- &aЖелезка уровень 2"));
        armorList.add(ColorUtil.getMessage("&e- &7Алмазный сет"));
        armorList.add(ColorUtil.getMessage("&e- &fАлмазка уровень 0"));
        armorList.add(ColorUtil.getMessage("&e- &aАлмазка уровень 1"));
        armorList.add(ColorUtil.getMessage("&e- &bАлмазка уровень 2"));
        armorList.add(ColorUtil.getMessage("&e- &cАлмазка уровень 3"));
        armorMenuMeta.setLore(armorList);
        armorMenuStack.setItemMeta(armorMenuMeta);
        return armorMenuStack;
    }
    public static ItemStack pickaxeMenuStack(){
        ItemStack pickaxeMenuStack = new ItemStack(Material.GOLD_PICKAXE, 1);
        ItemMeta pickaxeMenuMeta = pickaxeMenuStack.getItemMeta();
        pickaxeMenuMeta.setDisplayName(ColorUtil.getMessage("&l&bКирки"));
        List<String> pickaxeList = new ArrayList<>();
        pickaxeList.add(ColorUtil.getMessage("&e-&7 Каменная кирка"));
        pickaxeList.add(ColorUtil.getMessage("&e-&7 Железная кирка"));
        pickaxeList.add(ColorUtil.getMessage("&e-&7 Алмазная кирка"));
        pickaxeMenuMeta.setLore(pickaxeList);
        pickaxeMenuStack.setItemMeta(pickaxeMenuMeta);
        return pickaxeMenuStack;
    }
    public static ItemStack swordMenuStack(){
        ItemStack swordMenuStack = new ItemStack(Material.GOLD_SWORD, 1);
        ItemMeta swordMenuMeta = swordMenuStack.getItemMeta();
        swordMenuMeta.setDisplayName(ColorUtil.getMessage("&l&bМечи"));
        List<String> swordList = new ArrayList<>();
        swordList.add(ColorUtil.getMessage("&e-&7 Железный меч"));
        swordList.add(ColorUtil.getMessage("&e-&a Алмеч"));
        swordList.add(ColorUtil.getMessage("&e-&b Экскалибур"));
        swordList.add(ColorUtil.getMessage("&e-&6 Смертоносец"));
        swordList.add(ColorUtil.getMessage("&e-&c Киллмагедон"));
        swordMenuMeta.setLore(swordList);
        swordMenuStack.setItemMeta(swordMenuMeta);
        return swordMenuStack;
    }
    public static ItemStack bowMenuStack(){
        ItemStack bowMenuStack = new ItemStack(Material.BOW, 1);
        ItemMeta bowMenuMeta = bowMenuStack.getItemMeta();
        bowMenuMeta.setDisplayName(ColorUtil.getMessage("&l&bЛуки"));
        List<String> bowMenuList = new ArrayList<>();
        bowMenuList.add(ColorUtil.getMessage("&e-&a Лук уровень 1"));
        bowMenuList.add(ColorUtil.getMessage("&e-&b Лук уровень 2"));
        bowMenuList.add(ColorUtil.getMessage("&e-&c Лук уровень 3"));
        bowMenuList.add(ColorUtil.getMessage("&e-&c Лукер"));
        bowMenuList.add(ColorUtil.getMessage("&e-&7 Стрела"));
        bowMenuMeta.setLore(bowMenuList);
        bowMenuStack.setItemMeta(bowMenuMeta);
        return bowMenuStack;
    }
    public static ItemStack foodMenuStack(){
        ItemStack foodMenuStack = new ItemStack(Material.APPLE, 1);
        ItemMeta foodMenuMeta = foodMenuStack.getItemMeta();
        foodMenuMeta.setDisplayName(ColorUtil.getMessage("&l&bЕда"));
        List<String> foodMenuList = new ArrayList<>();
        foodMenuList.add(ColorUtil.getMessage("&e-&f Еда чемпионов"));
        foodMenuList.add(ColorUtil.getMessage("&e-&7 Жареная свинина"));
        foodMenuList.add(ColorUtil.getMessage("&e-&7 Торт"));
        foodMenuList.add(ColorUtil.getMessage("&e-&7 Золотое яблоко"));
        foodMenuMeta.setLore(foodMenuList);
        foodMenuStack.setItemMeta(foodMenuMeta);
        return foodMenuStack;
    }
    public static ItemStack chestsMenuStack(){
        ItemStack chestsMenuStack = new ItemStack(Material.CHEST, 1);
        ItemMeta chestsMenuMeta = chestsMenuStack.getItemMeta();
        chestsMenuMeta.setDisplayName(ColorUtil.getMessage("&l&bСундуки"));
        List<String> chestsMenuList = new ArrayList<>();
        chestsMenuList.add(ColorUtil.getMessage("&e-&a Сундук"));
        chestsMenuList.add(ColorUtil.getMessage("&e-&a Командный сундук"));
        chestsMenuMeta.setLore(chestsMenuList);
        chestsMenuStack.setItemMeta(chestsMenuMeta);
        return chestsMenuStack;
    }
    public static ItemStack potionMenuStack(){
        ItemStack potionMenuStack = new ItemStack(Material.POTION, 1);
        ItemMeta potionMenuMeta = potionMenuStack.getItemMeta();
        potionMenuMeta.setDisplayName(ColorUtil.getMessage("&l&bЗелья"));
        List<String> potionMenuList = new ArrayList<>();
        potionMenuList.add(ColorUtil.getMessage("&e- Хилка уровень 1"));
        potionMenuList.add(ColorUtil.getMessage("&e- Хилка уровень 2"));
        potionMenuList.add(ColorUtil.getMessage("&e- Скорость"));
        potionMenuList.add(ColorUtil.getMessage("&e- Зелье регенерации"));
        potionMenuList.add(ColorUtil.getMessage("&e- Сила"));
        potionMenuList.add(ColorUtil.getMessage("&e- Зелье невидимости"));
        potionMenuMeta.setLore(potionMenuList);
        potionMenuStack.setItemMeta(potionMenuMeta);
        return potionMenuStack;
    }
    public static ItemStack specialMenuStack(){
        ItemStack specialMenuStack = new ItemStack(Material.TNT, 1);
        ItemMeta specialMenuMeta = specialMenuStack.getItemMeta();
        specialMenuMeta.setDisplayName(ColorUtil.getMessage("&l&bСпециальное"));
        List<String> specialMenuList = new ArrayList<>();
        specialMenuList.add(ColorUtil.getMessage("&e-&7 Лестница"));
        specialMenuList.add(ColorUtil.getMessage("&e-&7 Паутина"));
        specialMenuList.add(ColorUtil.getMessage("&e-&7 Удочка"));
        specialMenuList.add(ColorUtil.getMessage("&e-&7 Зажигалка"));
        specialMenuList.add(ColorUtil.getMessage("&e-&7 Динамит"));
        specialMenuList.add(ColorUtil.getMessage("&e-&7 Жемчуг края"));
        specialMenuList.add(ColorUtil.getMessage("&e-&b Телепорт домой (&e6 сек.&b)"));
        specialMenuList.add(ColorUtil.getMessage("&e-&b Кость тора"));
        specialMenuList.add(ColorUtil.getMessage("&e- GPS трекер"));
        specialMenuList.add(ColorUtil.getMessage("&e-&b Спасательная платформа"));
        specialMenuList.add(ColorUtil.getMessage("&e-&b Ловушка"));
        specialMenuMeta.setLore(specialMenuList);
        specialMenuStack.setItemMeta(specialMenuMeta);
        return specialMenuStack;
    }
    public static ItemStack exchangerMenuStack(){
        ItemStack exchangerMenuStack = new ItemStack(Material.GOLD_INGOT, 1);
        ItemMeta exchangerMenuMeta = exchangerMenuStack.getItemMeta();
        exchangerMenuMeta.setDisplayName(ColorUtil.getMessage("&l&bОбмен валют"));
        List<String> exchangerMenuList = new ArrayList<>();
        exchangerMenuList.add(ColorUtil.getMessage("&e-&f 1 железо за&6 48 бронзы"));
        exchangerMenuList.add(ColorUtil.getMessage("&e-&e 1 золото&f за 14 железа"));
        exchangerMenuList.add(ColorUtil.getMessage("&e-&6 32 бронзы&f за 1 железо"));
        exchangerMenuList.add(ColorUtil.getMessage("&e-&f 7 железа за&e 1 золото"));
        exchangerMenuMeta.setLore(exchangerMenuList);
        exchangerMenuStack.setItemMeta(exchangerMenuMeta);
        return exchangerMenuStack;
    }


    public static ItemStack sandstone(){
        ItemStack sandstoneStack = new ItemStack(Material.SANDSTONE, 2, (byte) 2);
        ItemMeta sandstoneMeta = sandstoneStack.getItemMeta();
        List<String> sandstoneList = new ArrayList<>();
        sandstoneList.add(ColorUtil.getMessage("&dЦена: &61 бронза"));
        sandstoneMeta.setLore(sandstoneList);
        sandstoneStack.setItemMeta(sandstoneMeta);
        return sandstoneStack;
    }
    public static ItemStack sandstoneStairs(){
        ItemStack sandstoneStairsStack = new ItemStack(Material.SANDSTONE_STAIRS, 2);
        ItemMeta sandstoneStairsMeta = sandstoneStairsStack.getItemMeta();
        List<String> sandstoneStairsList = new ArrayList<>();
        sandstoneStairsList.add(ColorUtil.getMessage("&dЦена: &63 бронзы"));
        sandstoneStairsMeta.setLore(sandstoneStairsList);
        sandstoneStairsStack.setItemMeta(sandstoneStairsMeta);
        return sandstoneStairsStack;
    }
    public static ItemStack enderStone(){
        ItemStack enderstoneStack = new ItemStack(Material.ENDER_STONE, 1);
        ItemMeta enderstoneMeta = enderstoneStack.getItemMeta();
        List<String> enderstoneList = new ArrayList<>();
        enderstoneList.add(ColorUtil.getMessage("&dЦена: &67 бронзы"));
        enderstoneMeta.setLore(enderstoneList);
        enderstoneStack.setItemMeta(enderstoneMeta);
        return enderstoneStack;
    }
    public static ItemStack ironBlock(){
        ItemStack ironblockStack = new ItemStack(Material.IRON_BLOCK, 1);
        ItemMeta ironblockMeta = ironblockStack.getItemMeta();
        List<String> ironblockList = new ArrayList<>();
        ironblockList.add(ColorUtil.getMessage("&dЦена: &f3 железа"));
        ironblockMeta.setLore(ironblockList);
        ironblockStack.setItemMeta(ironblockMeta);
        return ironblockStack;
    }
    public static ItemStack glowStone(){
        ItemStack glowstoneStack = new ItemStack(Material.GLOWSTONE, 4);
        ItemMeta glowstoneMeta = glowstoneStack.getItemMeta();
        List<String> glowstoneList = new ArrayList<>();
        glowstoneList.add(ColorUtil.getMessage("&dЦена: &616 бронзы"));
        glowstoneMeta.setLore(glowstoneList);
        glowstoneStack.setItemMeta(glowstoneMeta);
        return glowstoneStack;
    }
    public static ItemStack coloredGlass(Player p){
        ItemStack glassStack;
        if(BedWarsHard.getGame().getPlayer(p)!=null){
            PlayerInfo playerInfo = BedWarsHard.getGame().getPlayer(p);
            glassStack = new ItemStack(Material.STAINED_GLASS, 1, (byte) playerInfo.getTeam().getWool());
        }
        else{
            glassStack = new ItemStack(Material.GLASS, 1);
        }
        ItemMeta glassMeta = glassStack.getItemMeta();
        List<String> glassList = new ArrayList<>();
        glassList.add(ColorUtil.getMessage("&dЦена: &64 бронзы"));
        glassMeta.setLore(glassList);
        glassStack.setItemMeta(glassMeta);
        return glassStack;
    }
    public static ItemStack slimeBlock(){
        ItemStack slimeBlockStack = new ItemStack(Material.SLIME_BLOCK, 1);
        ItemMeta slimeBlockMeta = slimeBlockStack.getItemMeta();
        List<String> slimeBlockList = new ArrayList<>();
        slimeBlockList.add(ColorUtil.getMessage("&dЦена: &616 бронзы"));
        slimeBlockMeta.setLore(slimeBlockList);
        slimeBlockStack.setItemMeta(slimeBlockMeta);
        return slimeBlockStack;
    }


    public static ItemStack IronSetMenuStack(){
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
        ironLegsMeta.spigot().setUnbreakable(true);
        ironLegsStack.setItemMeta(ironLegsMeta);
        return ironLegsStack;
    }
    public static ItemStack ironChestplate1(){
        ItemStack ironChestplateStack = new ItemStack(Material.IRON_CHESTPLATE, 1);
        ItemMeta ironChestplateMeta = ironChestplateStack.getItemMeta();
        ironChestplateMeta.setDisplayName(ColorUtil.getMessage("&aЖелезка уровень 1"));
        List<String> ironChestplateList = new ArrayList<>();
        ironChestplateList.add(ColorUtil.getMessage("&dЦена: &f1 железо"));
        ironChestplateMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
        ironChestplateMeta.setLore(ironChestplateList);
        ironChestplateMeta.spigot().setUnbreakable(true);
        ironChestplateStack.setItemMeta(ironChestplateMeta);
        return ironChestplateStack;
    }
    public static ItemStack ironChestplate2(){
        ItemStack ironChestplateStack = new ItemStack(Material.IRON_CHESTPLATE, 1);
        ItemMeta ironChestplateMeta = ironChestplateStack.getItemMeta();
        ironChestplateMeta.setDisplayName(ColorUtil.getMessage("&aЖелезка уровень 2"));
        List<String> ironChestplateList = new ArrayList<>();
        ironChestplateList.add(ColorUtil.getMessage("&dЦена: &f3 железо"));
        ironChestplateMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
        ironChestplateMeta.setLore(ironChestplateList);
        ironChestplateMeta.spigot().setUnbreakable(true);
        ironChestplateStack.setItemMeta(ironChestplateMeta);
        return ironChestplateStack;
    }
    public static ItemStack diamondSetMenuStack(){
        ItemStack diamondLegsStack = new ItemStack(Material.DIAMOND_LEGGINGS, 1);
        ItemMeta diamondLegsMeta = diamondLegsStack.getItemMeta();
        diamondLegsMeta.setDisplayName(ColorUtil.getMessage("&fАлмозный сет"));
        List<String> diamondLegsList = new ArrayList<>();
        diamondLegsList.add(ColorUtil.getMessage("&7Алмазный шлем"));
        diamondLegsList.add(ColorUtil.getMessage("&7Алмазные штаны"));
        diamondLegsList.add(ColorUtil.getMessage("&7Алмазные ботинки"));
        diamondLegsList.add(ColorUtil.getMessage("&dЦена: &f9 железа"));
        diamondLegsMeta.setLore(diamondLegsList);
        diamondLegsMeta.spigot().setUnbreakable(true);
        diamondLegsStack.setItemMeta(diamondLegsMeta);
        return diamondLegsStack;
    }
    public static ItemStack diamondChestplate0(){
        int level = 0;
        ItemStack diamondChestplateStack = new ItemStack(Material.DIAMOND_CHESTPLATE, 1);
        ItemMeta diamondChestplateMeta = diamondChestplateStack.getItemMeta();
        diamondChestplateMeta.setDisplayName(ColorUtil.getMessage("&fАлмазка уровень " + level));
        List<String> diamondChestplateList = new ArrayList<>();
        diamondChestplateList.add(ColorUtil.getMessage("&dЦена: &f9 железа"));
        diamondChestplateMeta.setLore(diamondChestplateList);
        diamondChestplateMeta.spigot().setUnbreakable(true);
        diamondChestplateStack.setItemMeta(diamondChestplateMeta);
        return diamondChestplateStack;
    }
    public static ItemStack diamondChestplate1(){
        int level = 1;
        ItemStack diamondChestplateStack = new ItemStack(Material.DIAMOND_CHESTPLATE, 1);
        ItemMeta diamondChestplateMeta = diamondChestplateStack.getItemMeta();
        diamondChestplateMeta.setDisplayName(ColorUtil.getMessage("&aАлмазка уровень " + level));
        List<String> diamondChestplateList = new ArrayList<>();
        diamondChestplateList.add(ColorUtil.getMessage("&dЦена: &f20 железа"));
        diamondChestplateMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, level, true);
        diamondChestplateMeta.setLore(diamondChestplateList);
        diamondChestplateMeta.spigot().setUnbreakable(true);
        diamondChestplateStack.setItemMeta(diamondChestplateMeta);
        return diamondChestplateStack;
    }
    public static ItemStack diamondChestplate2(){
        int level = 2;
        ItemStack diamondChestplateStack = new ItemStack(Material.DIAMOND_CHESTPLATE, 1);
        ItemMeta diamondChestplateMeta = diamondChestplateStack.getItemMeta();
        diamondChestplateMeta.setDisplayName(ColorUtil.getMessage("&bАлмазка уровень " + level));
        List<String> diamondChestplateList = new ArrayList<>();
        diamondChestplateList.add(ColorUtil.getMessage("&dЦена: &e3 золота"));
        diamondChestplateMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, level, true);
        diamondChestplateMeta.setLore(diamondChestplateList);
        diamondChestplateMeta.spigot().setUnbreakable(true);
        diamondChestplateStack.setItemMeta(diamondChestplateMeta);
        return diamondChestplateStack;
    }
    public static ItemStack diamondChestplate3(){
        int level = 3;
        ItemStack diamondChestplateStack = new ItemStack(Material.DIAMOND_CHESTPLATE, 1);
        ItemMeta diamondChestplateMeta = diamondChestplateStack.getItemMeta();
        diamondChestplateMeta.setDisplayName(ColorUtil.getMessage("&cАлмазка уровень " + level));
        List<String> diamondChestplateList = new ArrayList<>();
        diamondChestplateList.add(ColorUtil.getMessage("&dЦена: &e8 золота"));
        diamondChestplateMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, level, true);
        diamondChestplateMeta.setLore(diamondChestplateList);
        diamondChestplateMeta.spigot().setUnbreakable(true);
        diamondChestplateStack.setItemMeta(diamondChestplateMeta);
        return diamondChestplateStack;
    }

    public static List<ItemStack> IronSetStack(){
        ItemStack ironBootsStack = new ItemStack(Material.IRON_BOOTS, 1);
        ItemMeta ironBootsMeta = ironBootsStack.getItemMeta();
        ironBootsMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
        ironBootsMeta.spigot().setUnbreakable(true);
        ironBootsStack.setItemMeta(ironBootsMeta);

        ItemStack ironLegsStack = new ItemStack(Material.IRON_LEGGINGS, 1);
        ItemMeta ironLegsMeta = ironLegsStack.getItemMeta();
        ironLegsMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
        ironLegsMeta.spigot().setUnbreakable(true);
        ironLegsStack.setItemMeta(ironLegsMeta);

        ItemStack ironHelmetStack = new ItemStack(Material.IRON_HELMET, 1);
        ItemMeta ironHelmetMeta = ironHelmetStack.getItemMeta();
        ironHelmetMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
        ironHelmetMeta.spigot().setUnbreakable(true);
        ironHelmetStack.setItemMeta(ironHelmetMeta);

        List<ItemStack> ironArmorList = new ArrayList<>();
        ironArmorList.add(ironBootsStack);
        ironArmorList.add(ironLegsStack);
        ironArmorList.add(ironHelmetStack);
        return ironArmorList;
    }
    public static List<ItemStack> diamondSetStack(){
        ItemStack diamondBootsStack = new ItemStack(Material.DIAMOND_BOOTS, 1);
        ItemMeta diamondBootsMeta = diamondBootsStack.getItemMeta();
        diamondBootsMeta.spigot().setUnbreakable(true);
        diamondBootsStack.setItemMeta(diamondBootsMeta);

        ItemStack diamondLegsStack = new ItemStack(Material.DIAMOND_LEGGINGS, 1);
        ItemMeta diamondLegsMeta = diamondLegsStack.getItemMeta();
        diamondLegsMeta.spigot().setUnbreakable(true);
        diamondLegsStack.setItemMeta(diamondLegsMeta);

        ItemStack diamondHelmetStack = new ItemStack(Material.DIAMOND_HELMET, 1);
        ItemMeta diamondHelmetMeta = diamondHelmetStack.getItemMeta();
        diamondHelmetMeta.spigot().setUnbreakable(true);
        diamondHelmetStack.setItemMeta(diamondHelmetMeta);

        List<ItemStack> diamondArmorList = new ArrayList<>();
        diamondArmorList.add(diamondBootsStack);
        diamondArmorList.add(diamondLegsStack);
        diamondArmorList.add(diamondHelmetStack);
        return diamondArmorList;
    }


    public static ItemStack stonePickaxe(){
        ItemStack stonePickaxeStack = new ItemStack(Material.STONE_PICKAXE, 1);
        ItemMeta stonePickaxeMeta = stonePickaxeStack.getItemMeta();
        stonePickaxeMeta.setDisplayName(ColorUtil.getMessage("&bКаменная кирка"));
        List<String> stonePickaxeList = new ArrayList<>();
        stonePickaxeList.add(ColorUtil.getMessage("&dЦена: &64 бронзы"));
        stonePickaxeMeta.addEnchant(Enchantment.DIG_SPEED, 1, true);
        stonePickaxeMeta.setLore(stonePickaxeList);
        stonePickaxeMeta.spigot().setUnbreakable(true);
        stonePickaxeStack.setItemMeta(stonePickaxeMeta);
        return stonePickaxeStack;
    }
    public static ItemStack ironPickaxe(){
        ItemStack ironPickaxeStack = new ItemStack(Material.IRON_PICKAXE, 1);
        ItemMeta ironPickaxeMeta = ironPickaxeStack.getItemMeta();
        ironPickaxeMeta.setDisplayName(ColorUtil.getMessage("&bЖелезная кирка"));
        List<String> ironPickaxeList = new ArrayList<>();
        ironPickaxeList.add(ColorUtil.getMessage("&dЦена: &f2 железа"));
        ironPickaxeMeta.addEnchant(Enchantment.DIG_SPEED, 1, true);
        ironPickaxeMeta.setLore(ironPickaxeList);
        ironPickaxeMeta.spigot().setUnbreakable(true);
        ironPickaxeStack.setItemMeta(ironPickaxeMeta);
        return ironPickaxeStack;
    }
    public static ItemStack diamondPickaxe1(){
        ItemStack diamond1PickaxeStack = new ItemStack(Material.DIAMOND_PICKAXE, 1);
        ItemMeta diamond1PickaxeMeta = diamond1PickaxeStack.getItemMeta();
        diamond1PickaxeMeta.setDisplayName(ColorUtil.getMessage("&bАлмазная кирка"));
        List<String> diamond1PickaxeList = new ArrayList<>();
        diamond1PickaxeList.add(ColorUtil.getMessage("&dЦена: &e2 золота"));
        diamond1PickaxeMeta.addEnchant(Enchantment.DIG_SPEED, 1, true);
        diamond1PickaxeMeta.setLore(diamond1PickaxeList);
        diamond1PickaxeMeta.spigot().setUnbreakable(true);
        diamond1PickaxeStack.setItemMeta(diamond1PickaxeMeta);
        return diamond1PickaxeStack;
    }
    public static ItemStack diamondPickaxe3(){
        ItemStack diamond2PickaxeStack = new ItemStack(Material.DIAMOND_PICKAXE, 1);
        ItemMeta diamond2PickaxeMeta = diamond2PickaxeStack.getItemMeta();
        diamond2PickaxeMeta.setDisplayName(ColorUtil.getMessage("&bАлмазная кирка"));
        List<String> diamond2PickaxeList = new ArrayList<>();
        diamond2PickaxeList.add(ColorUtil.getMessage("&dЦена: &e8 золота"));
        diamond2PickaxeMeta.addEnchant(Enchantment.DIG_SPEED, 3, true);
        diamond2PickaxeMeta.setLore(diamond2PickaxeList);
        diamond2PickaxeMeta.spigot().setUnbreakable(true);
        diamond2PickaxeStack.setItemMeta(diamond2PickaxeMeta);
        return diamond2PickaxeStack;
    }


    public static ItemStack ironSword(){
        ItemStack ironSwordStack = new ItemStack(Material.IRON_SWORD, 1);
        ItemMeta ironSwordMeta = ironSwordStack.getItemMeta();
        ironSwordMeta.setDisplayName(ColorUtil.getMessage("&bЖелезный меч"));
        List<String> ironSwordList = new ArrayList<>();
        ironSwordList.add(ColorUtil.getMessage("&dЦена: &63 бронзы"));
        ironSwordMeta.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
        ironSwordMeta.addEnchant(Enchantment.DURABILITY, 1, true);
        ironSwordMeta.setLore(ironSwordList);
        ironSwordMeta.spigot().setUnbreakable(true);
        ironSwordStack.setItemMeta(ironSwordMeta);
        return ironSwordStack;
    }
    public static ItemStack diamondSword(){
        ItemStack diamondSwordStack = new ItemStack(Material.DIAMOND_SWORD, 1);
        ItemMeta diamondSwordMeta = diamondSwordStack.getItemMeta();
        diamondSwordMeta.setDisplayName(ColorUtil.getMessage("&aАлмеч"));
        List<String> diamondSwordList = new ArrayList<>();
        diamondSwordList.add(ColorUtil.getMessage("&dЦена: &f1 железо"));
        diamondSwordMeta.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
        diamondSwordMeta.addEnchant(Enchantment.DURABILITY, 1, true);
        diamondSwordMeta.setLore(diamondSwordList);
        diamondSwordMeta.spigot().setUnbreakable(true);
        diamondSwordStack.setItemMeta(diamondSwordMeta);
        return diamondSwordStack;
    }
    public static ItemStack excalibur(){
        ItemStack excaliburSwordStack = new ItemStack(Material.DIAMOND_SWORD, 1);
        ItemMeta excaliburSwordMeta = excaliburSwordStack.getItemMeta();
        excaliburSwordMeta.setDisplayName(ColorUtil.getMessage("&bЭкскалибур"));
        List<String> excaliburSwordList = new ArrayList<>();
        excaliburSwordList.add(ColorUtil.getMessage("&dЦена: &f5 железа"));
        excaliburSwordMeta.addEnchant(Enchantment.DAMAGE_ALL, 2, true);
        excaliburSwordMeta.addEnchant(Enchantment.DURABILITY, 1, true);
        excaliburSwordMeta.addEnchant(Enchantment.KNOCKBACK, 1, true);
        excaliburSwordMeta.setLore(excaliburSwordList);
        excaliburSwordMeta.spigot().setUnbreakable(true);
        excaliburSwordStack.setItemMeta(excaliburSwordMeta);
        return excaliburSwordStack;
    }
    public static ItemStack deathBringer(){
        ItemStack deathBringerSwordStack = new ItemStack(Material.DIAMOND_SWORD, 1);
        ItemMeta deathBringerSwordMeta = deathBringerSwordStack.getItemMeta();
        deathBringerSwordMeta.setDisplayName(ColorUtil.getMessage("&6Смертоносец"));
        List<String> deathBringerSwordList = new ArrayList<>();
        deathBringerSwordList.add(ColorUtil.getMessage("&dЦена: &e6 золота"));
        deathBringerSwordMeta.addEnchant(Enchantment.DAMAGE_ALL, 3, true);
        deathBringerSwordMeta.addEnchant(Enchantment.DURABILITY, 1, true);
        deathBringerSwordMeta.addEnchant(Enchantment.KNOCKBACK, 1, true);
        deathBringerSwordMeta.setLore(deathBringerSwordList);
        deathBringerSwordMeta.spigot().setUnbreakable(true);
        deathBringerSwordStack.setItemMeta(deathBringerSwordMeta);
        return deathBringerSwordStack;
    }
    public static ItemStack killmagedon(){
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
        killmagedonSwordMeta.spigot().setUnbreakable(true);
        killmagedonSwordStack.setItemMeta(killmagedonSwordMeta);
        return killmagedonSwordStack;
    }

    public static ItemStack bow1(){
        ItemStack bowStack = new ItemStack(Material.BOW, 1);
        ItemMeta bowMeta = bowStack.getItemMeta();
        bowMeta.setDisplayName(ColorUtil.getMessage("&aЛук уровень 1"));
        List<String> bowList = new ArrayList<>();
        bowList.add(ColorUtil.getMessage("&dЦена: &f7 железа"));
        bowMeta.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
        bowMeta.setLore(bowList);
        bowMeta.spigot().setUnbreakable(true);
        bowStack.setItemMeta(bowMeta);
        return bowStack;
    }
    public static ItemStack bow2(){
        ItemStack bowStack = new ItemStack(Material.BOW, 1);
        ItemMeta bowMeta = bowStack.getItemMeta();
        bowMeta.setDisplayName(ColorUtil.getMessage("&bЛук уровень 2"));
        List<String> bowList = new ArrayList<>();
        bowList.add(ColorUtil.getMessage("&dЦена: &e1 золото"));
        bowMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
        bowMeta.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
        bowMeta.setLore(bowList);
        bowMeta.spigot().setUnbreakable(true);
        bowStack.setItemMeta(bowMeta);
        return bowStack;
    }
    public static ItemStack bow3(){
        ItemStack bowStack = new ItemStack(Material.BOW, 1);
        ItemMeta bowMeta = bowStack.getItemMeta();
        bowMeta.setDisplayName(ColorUtil.getMessage("&cЛук уровень 3"));
        List<String> bowList = new ArrayList<>();
        bowList.add(ColorUtil.getMessage("&dЦена: &e9 золота"));
        bowMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
        bowMeta.addEnchant(Enchantment.ARROW_KNOCKBACK, 1, true);
        bowMeta.addEnchant(Enchantment.ARROW_FIRE, 1, true);
        bowMeta.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
        bowMeta.setLore(bowList);
        bowMeta.spigot().setUnbreakable(true);
        bowStack.setItemMeta(bowMeta);
        return bowStack;
    }
    public static ItemStack bow4(){
        ItemStack bowStack = new ItemStack(Material.BOW, 1);
        ItemMeta bowMeta = bowStack.getItemMeta();
        bowMeta.setDisplayName(ColorUtil.getMessage("&cЛукер"));
        List<String> bowList = new ArrayList<>();
        bowList.add(ColorUtil.getMessage("&dЦена: &e30 золота"));
        bowMeta.addEnchant(Enchantment.ARROW_DAMAGE, 3, true);
        bowMeta.addEnchant(Enchantment.ARROW_KNOCKBACK, 1, true);
        bowMeta.addEnchant(Enchantment.ARROW_FIRE, 1, true);
        bowMeta.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
        bowMeta.setLore(bowList);
        bowMeta.spigot().setUnbreakable(true);
        bowStack.setItemMeta(bowMeta);
        return bowStack;
    }
    public static ItemStack arrow(){
        ItemStack arrowStack = new ItemStack(Material.ARROW, 1);
        ItemMeta arrowMeta = arrowStack.getItemMeta();
        arrowMeta.setDisplayName(ColorUtil.getMessage("&fСтрела"));
        List<String> arrowList = new ArrayList<>();
        arrowList.add(ColorUtil.getMessage("&dЦена: &e1 золото"));
        arrowMeta.setLore(arrowList);
        arrowStack.setItemMeta(arrowMeta);
        return arrowStack;
    }


    public static ItemStack apple(){
        ItemStack appleStack = new ItemStack(Material.APPLE, 1);
        ItemMeta appleMeta = appleStack.getItemMeta();
        appleMeta.setDisplayName(ColorUtil.getMessage("&fЕда чемпионов"));
        List<String> appleList = new ArrayList<>();
        appleList.add(ColorUtil.getMessage("&dЦена: &61 бронза"));
        appleMeta.setLore(appleList);
        appleStack.setItemMeta(appleMeta);
        return appleStack;
    }
    public static ItemStack pork(){
        ItemStack porkStack = new ItemStack(Material.GRILLED_PORK, 1);
        ItemMeta porkMeta = porkStack.getItemMeta();
        porkMeta.setDisplayName(ColorUtil.getMessage("&fЖареная свинина"));
        List<String> porkList = new ArrayList<>();
        porkList.add(ColorUtil.getMessage("&dЦена: &62 бронзы"));
        porkMeta.setLore(porkList);
        porkStack.setItemMeta(porkMeta);
        return porkStack;
    }
    public static ItemStack cake(){
        ItemStack cakeStack = new ItemStack(Material.CAKE, 1);
        ItemMeta cakeMeta = cakeStack.getItemMeta();
        cakeMeta.setDisplayName(ColorUtil.getMessage("&fТорт"));
        List<String> cakeList = new ArrayList<>();
        cakeList.add(ColorUtil.getMessage("&dЦена: &f1 железо"));
        cakeMeta.setLore(cakeList);
        cakeStack.setItemMeta(cakeMeta);
        return cakeStack;
    }
    public static ItemStack goldenApple(){
        ItemStack goldenAppleStack = new ItemStack(Material.GOLDEN_APPLE, 1);
        ItemMeta goldenAppleMeta = goldenAppleStack.getItemMeta();
        goldenAppleMeta.setDisplayName(ColorUtil.getMessage("&bЗолотое яблоко"));
        List<String> goldenAppleList = new ArrayList<>();
        goldenAppleList.add(ColorUtil.getMessage("&dЦена: &e2 золота"));
        goldenAppleMeta.setLore(goldenAppleList);
        goldenAppleStack.setItemMeta(goldenAppleMeta);
        return goldenAppleStack;
    }


    public static ItemStack chest(){
        ItemStack chestStack = new ItemStack(Material.CHEST, 1);
        ItemMeta chestMeta = chestStack.getItemMeta();
        chestMeta.setDisplayName(ColorUtil.getMessage("&aСундук"));
        List<String> chestList = new ArrayList<>();
        chestList.add(ColorUtil.getMessage("&dЦена: &f1 железо"));
        chestMeta.setLore(chestList);
        chestStack.setItemMeta(chestMeta);
        return chestStack;
    }
    public static ItemStack enderChest(){
        ItemStack enderChestStack = new ItemStack(Material.ENDER_CHEST, 1);
        ItemMeta enderChestMeta = enderChestStack.getItemMeta();
        enderChestMeta.setDisplayName(ColorUtil.getMessage("&aКомандный сундук"));
        List<String> enderChestList = new ArrayList<>();
        enderChestList.add(ColorUtil.getMessage("&dЦена: &e1 золото"));
        enderChestMeta.setLore(enderChestList);
        enderChestStack.setItemMeta(enderChestMeta);
        return enderChestStack;
    }


    public static ItemStack potionHeal1(){
        ItemStack potionMenuStack = new ItemStack(Material.POTION, 1, (short) 8197);
        ItemMeta potionMenuMeta = potionMenuStack.getItemMeta();
        potionMenuMeta.setDisplayName(ColorUtil.getMessage("&eХилка уровень 1"));
        List<String> potionMenuList = new ArrayList<>();
        potionMenuList.add(ColorUtil.getMessage("&dЦена: &f2 железа"));
        potionMenuMeta.setLore(potionMenuList);
        potionMenuStack.setItemMeta(potionMenuMeta);
        return potionMenuStack;
    }
    public static ItemStack potionHeal2(){
        ItemStack potionMenuStack = new ItemStack(Material.POTION, 1, (short) 8229);
        ItemMeta potionMenuMeta = potionMenuStack.getItemMeta();
        potionMenuMeta.setDisplayName(ColorUtil.getMessage("&eХилка уровень 2"));
        List<String> potionMenuList = new ArrayList<>();
        potionMenuList.add(ColorUtil.getMessage("&dЦена: &f5 железа"));
        potionMenuMeta.setLore(potionMenuList);
        potionMenuStack.setItemMeta(potionMenuMeta);
        return potionMenuStack;
    }
    public static ItemStack potionSpeed(){
        ItemStack potionMenuStack = new ItemStack(Material.POTION, 1, (short) 8194);
        ItemMeta potionMenuMeta = potionMenuStack.getItemMeta();
        potionMenuMeta.setDisplayName(ColorUtil.getMessage("&eСкорость"));
        List<String> potionMenuList = new ArrayList<>();
        potionMenuList.add(ColorUtil.getMessage("&dЦена: &f4 железа"));
        potionMenuMeta.setLore(potionMenuList);
        potionMenuStack.setItemMeta(potionMenuMeta);
        return potionMenuStack;
    }
    public static ItemStack potionRegen(){
        ItemStack potionMenuStack = new ItemStack(Material.POTION, 1, (short) 8193);
        ItemMeta potionMenuMeta = potionMenuStack.getItemMeta();
        potionMenuMeta.setDisplayName(ColorUtil.getMessage("&eЗелье регенерации"));
        List<String> potionMenuList = new ArrayList<>();
        potionMenuList.add(ColorUtil.getMessage("&dЦена: &f7 железа"));
        potionMenuMeta.setLore(potionMenuList);
        potionMenuStack.setItemMeta(potionMenuMeta);
        return potionMenuStack;
    }
    public static ItemStack potionStrength(){
        ItemStack potionMenuStack = new ItemStack(Material.POTION, 1, (short) 8201);
        ItemMeta potionMenuMeta = potionMenuStack.getItemMeta();
        potionMenuMeta.setDisplayName(ColorUtil.getMessage("&eСила"));
        List<String> potionMenuList = new ArrayList<>();
        potionMenuList.add(ColorUtil.getMessage("&dЦена: &e4 золота"));
        potionMenuMeta.setLore(potionMenuList);
        potionMenuStack.setItemMeta(potionMenuMeta);
        return potionMenuStack;
    }
    public static ItemStack potionInvisibility(){
        ItemStack potionStack = new ItemStack(Material.POTION, 1, (short) 8206);
        PotionMeta potionMeta = (PotionMeta) potionStack.getItemMeta();
        potionMeta.setDisplayName(ColorUtil.getMessage("&eЗелье невидимости"));
        potionMeta.addCustomEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 15 * 20, 0), true);
        List<String> potionList = new ArrayList<>();
        potionList.add(ColorUtil.getMessage("&dЦена: &f50 железа"));
        potionMeta.setLore(potionList);
        potionStack.setItemMeta(potionMeta);
        return potionStack;
    }


    public static ItemStack ladder(){
        ItemStack ladderStack = new ItemStack(Material.LADDER, 1);
        ItemMeta ladderMeta = ladderStack.getItemMeta();
        ladderMeta.setDisplayName(ColorUtil.getMessage("&fЛестница"));
        List<String> ladderList = new ArrayList<>();
        ladderList.add(ColorUtil.getMessage("&dЦена: &61 бронза"));
        ladderMeta.setLore(ladderList);
        ladderStack.setItemMeta(ladderMeta);
        return ladderStack;
    }
    public static ItemStack web(){
        ItemStack webStack = new ItemStack(Material.WEB, 1);
        ItemMeta webMeta = webStack.getItemMeta();
        webMeta.setDisplayName(ColorUtil.getMessage("&fПаутина"));
        List<String> webList = new ArrayList<>();
        webList.add(ColorUtil.getMessage("&dЦена: &624 бронзы"));
        webMeta.setLore(webList);
        webStack.setItemMeta(webMeta);
        return webStack;
    }
    public static ItemStack fishingRod(){
        ItemStack fishingRodStack = new ItemStack(Material.FISHING_ROD, 1);
        ItemMeta fishingRodMeta = fishingRodStack.getItemMeta();
        fishingRodMeta.setDisplayName(ColorUtil.getMessage("&fУдочка"));
        List<String> fishingRodList = new ArrayList<>();
        fishingRodList.add(ColorUtil.getMessage("&dЦена: &f5 железа"));
        fishingRodMeta.setLore(fishingRodList);
        fishingRodMeta.spigot().setUnbreakable(true);
        fishingRodStack.setItemMeta(fishingRodMeta);
        return fishingRodStack;
    }
    public static ItemStack lighter(){
        ItemStack lighterStack = new ItemStack(Material.FLINT_AND_STEEL, 1);
        ItemMeta lighterMeta = lighterStack.getItemMeta();
        lighterMeta.setDisplayName(ColorUtil.getMessage("&fОгниво"));
        List<String> lighterList = new ArrayList<>();
        lighterList.add(ColorUtil.getMessage("&dЦена: &f7 железа"));
        lighterMeta.setLore(lighterList);
        lighterMeta.spigot().setUnbreakable(true);
        lighterStack.setItemMeta(lighterMeta);
        return lighterStack;
    }
    public static ItemStack TNT(){
        ItemStack TNTStack = new ItemStack(Material.TNT, 1);
        ItemMeta TNTMeta = TNTStack.getItemMeta();
        TNTMeta.setDisplayName(ColorUtil.getMessage("&fДинамит"));
        List<String> TNTList = new ArrayList<>();
        TNTList.add(ColorUtil.getMessage("&dЦена: &e7 золота"));
        TNTMeta.setLore(TNTList);
        TNTStack.setItemMeta(TNTMeta);
        return TNTStack;
    }
    public static ItemStack enderPearl(){
        ItemStack enderPearlStack = new ItemStack(Material.ENDER_PEARL, 1);
        ItemMeta enderPearlMeta = enderPearlStack.getItemMeta();
        enderPearlMeta.setDisplayName(ColorUtil.getMessage("&fЖемчуг Эндера"));
        List<String> enderPearlList = new ArrayList<>();
        enderPearlList.add(ColorUtil.getMessage("&dЦена: &e13 золота"));
        enderPearlMeta.setLore(enderPearlList);
        enderPearlStack.setItemMeta(enderPearlMeta);
        return enderPearlStack;
    }
    public static ItemStack teleportHome(){
        ItemStack teleportHomeStack = new ItemStack(Material.SULPHUR, 1);
        ItemMeta teleportHomeMeta = teleportHomeStack.getItemMeta();
        teleportHomeMeta.setDisplayName(ColorUtil.getMessage("&bТелепорт домой (&e6 сек.&b)"));
        List<String> teleportHomeList = new ArrayList<>();
        teleportHomeList.add(ColorUtil.getMessage("&7 Нажмите правой кнопкой и через"));
        teleportHomeList.add(ColorUtil.getMessage("&f6 секунд&7 Вы телепортируетесь домой."));
        teleportHomeList.add(ColorUtil.getMessage("&cВнимание:&f Перемещение отменяет телепортацию"));
        teleportHomeList.add(ColorUtil.getMessage("&dЦена: &f3 железа"));
        teleportHomeMeta.setLore(teleportHomeList);
        teleportHomeStack.setItemMeta(teleportHomeMeta);
        return teleportHomeStack;
    }
    public static ItemStack thorBone(){
        ItemStack thorBoneStack = new ItemStack(Material.BONE, 1);
        ItemMeta thorBoneMeta = thorBoneStack.getItemMeta();
        thorBoneMeta.setDisplayName(ColorUtil.getMessage("&bКость Тора"));
        List<String> thorBoneList = new ArrayList<>();
        thorBoneList.add(ColorUtil.getMessage("&7Метает молнии"));
        thorBoneList.add(ColorUtil.getMessage("&dЦена: &f5 железа"));
        thorBoneMeta.setLore(thorBoneList);
        thorBoneStack.setItemMeta(thorBoneMeta);
        return thorBoneStack;
    }
    public static ItemStack trackerGPS(){
        ItemStack trackerGPSStack = new ItemStack(Material.COMPASS, 1);
        ItemMeta trackerGPSMeta = trackerGPSStack.getItemMeta();
        trackerGPSMeta.setDisplayName(ColorUtil.getMessage("&eGPS трекер"));
        List<String> trackerGPSList = new ArrayList<>();
        trackerGPSList.add(ColorUtil.getMessage("&7Укажет вам на ближайшего врага"));
        trackerGPSList.add(ColorUtil.getMessage("&dЦена: &f10 железа"));
        trackerGPSMeta.setLore(trackerGPSList);
        trackerGPSStack.setItemMeta(trackerGPSMeta);
        return trackerGPSStack;
    }
    public static ItemStack savingPlatform(){
        ItemStack platformStack = new ItemStack(Material.BLAZE_ROD, 1);
        ItemMeta platformMeta = platformStack.getItemMeta();
        platformMeta.setDisplayName(ColorUtil.getMessage("&bСпасательная платформа"));
        List<String> platformList = new ArrayList<>();
        platformList.add(ColorUtil.getMessage("&7 Спаси себя от падения!"));
        platformList.add(ColorUtil.getMessage("&7В течение &f10 секунд &7вы будете"));
        platformList.add(ColorUtil.getMessage("&7стоять на стеклянной платформе."));
        platformList.add(ColorUtil.getMessage("&7 Время перезарядки -&e 20 секунд"));
        platformList.add(ColorUtil.getMessage("&dЦена: &f14 железа"));
        platformMeta.setLore(platformList);
        platformStack.setItemMeta(platformMeta);
        return platformStack;
    }
    public static ItemStack trap(){
        ItemStack platformStack = new ItemStack(Material.STRING, 1);
        ItemMeta platformMeta = platformStack.getItemMeta();
        platformMeta.setDisplayName(ColorUtil.getMessage("&bЛовушка"));
        List<String> platformList = new ArrayList<>();
        platformList.add(ColorUtil.getMessage("&7 Информирует вас о том, когда"));
        platformList.add(ColorUtil.getMessage("&7противник наступает на ловушку."));
        platformList.add(ColorUtil.getMessage("&7 Также он получает отрицательные"));
        platformList.add(ColorUtil.getMessage("&7эффекты на&f 10 секунд"));
        platformList.add(ColorUtil.getMessage("&dЦена: &e2 золота"));
        platformMeta.setLore(platformList);
        platformStack.setItemMeta(platformMeta);
        return platformStack;
    }


    public static ItemStack bronzeToIronStack(){
        ItemStack changerStack = new ItemStack(Material.IRON_INGOT, 1);
        ItemMeta changerMeta = changerStack.getItemMeta();
        changerMeta.setDisplayName(ColorUtil.getMessage("&f1 железо за&6 48 бронзы"));
        List<String> changerList = new ArrayList<>();
        changerList.add(ColorUtil.getMessage("&dЦена:&6 48 бронзы"));
        changerMeta.setLore(changerList);
        changerStack.setItemMeta(changerMeta);
        return changerStack;
    }
    public static ItemStack ironToGoldStack(){
        ItemStack changerStack = new ItemStack(Material.GOLD_INGOT, 1);
        ItemMeta changerMeta = changerStack.getItemMeta();
        changerMeta.setDisplayName(ColorUtil.getMessage("&e1 золото&f за 14 железа"));
        List<String> changerList = new ArrayList<>();
        changerList.add(ColorUtil.getMessage("&dЦена:&f 14 железа"));
        changerMeta.setLore(changerList);
        changerStack.setItemMeta(changerMeta);
        return changerStack;
    }
    public static ItemStack ironToBronzeStack(){
        ItemStack changerStack = new ItemStack(Material.CLAY_BRICK, 1);
        ItemMeta changerMeta = changerStack.getItemMeta();
        changerMeta.setDisplayName(ColorUtil.getMessage("&632 бронзы&f за 1 железо"));
        List<String> changerList = new ArrayList<>();
        changerList.add(ColorUtil.getMessage("&dЦена:&f 1 железо"));
        changerMeta.setLore(changerList);
        changerStack.setItemMeta(changerMeta);
        return changerStack;
    }
    public static ItemStack goldToIronStack(){
        ItemStack changerStack = new ItemStack(Material.IRON_INGOT, 1);
        ItemMeta changerMeta = changerStack.getItemMeta();
        changerMeta.setDisplayName(ColorUtil.getMessage("&f7 железа за&e 1 золото"));
        List<String> changerList = new ArrayList<>();
        changerList.add(ColorUtil.getMessage("&dЦена:&f 1 золото"));
        changerMeta.setLore(changerList);
        changerStack.setItemMeta(changerMeta);
        return changerStack;
    }

//    public static ItemStack (){
//
//        return ;
//    }

}
