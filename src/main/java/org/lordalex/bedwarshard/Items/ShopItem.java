package org.lordalex.bedwarshard.Items;

import org.bukkit.Material;
import org.bukkit.SandstoneType;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.Sandstone;
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
    
//    public static ItemStack (){
//
//        return ;
//    }

}
