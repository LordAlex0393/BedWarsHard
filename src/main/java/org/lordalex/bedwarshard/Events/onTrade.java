package org.lordalex.bedwarshard.Events;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.lordalex.bedwarshard.Items.Trader;
import org.lordalex.bedwarshard.Utils.ColorUtil;

import java.util.ArrayList;
import java.util.List;

public class onTrade implements Listener {
    @EventHandler
    public void onTraderInventoryClick(InventoryClickEvent e) {
        if (e == null) return;
        Player p = (Player) e.getView().getPlayer();

        ItemStack BRONZE = new ItemStack(Material.CLAY_BRICK);
        ItemMeta bronzeMeta = BRONZE.getItemMeta();
        bronzeMeta.setDisplayName(ChatColor.GOLD + "Бронза");
        BRONZE.setItemMeta(bronzeMeta);

        ItemStack IRON = new ItemStack(Material.IRON_INGOT);
        ItemMeta ironMeta = IRON.getItemMeta();
        ironMeta.setDisplayName(ChatColor.WHITE + "Железо");
        IRON.setItemMeta(ironMeta);

        ItemStack GOLD = new ItemStack(Material.GOLD_INGOT);
        ItemMeta goldMeta = GOLD.getItemMeta();
        goldMeta.setDisplayName(ChatColor.YELLOW + "Золото");
        GOLD.setItemMeta(goldMeta);

        if (e.getView().getTitle().equals("Торговец")) {
            if (e.getCurrentItem() != null && e.getCurrentItem().getItemMeta() != null) {
                if (isEqualsItem(e, "&l&bБлоки")) {
                    Trader.openBlocksMenu((Player) e.getView().getPlayer());
                } else if (isEqualsItem(e, "&l&bБроня")) {
                    Trader.openArmorMenu((Player) e.getView().getPlayer());
                } else if (isEqualsItem(e, "&l&bКирки")) {
                    Trader.openPickaxeMenu((Player) e.getView().getPlayer());
                } else if (isEqualsItem(e, "&l&bМечи")) {
                    Trader.openSwordMenu((Player) e.getView().getPlayer());
                } else if (isEqualsItem(e, "&l&bЕда")) {
                    Trader.openFoodMenu((Player) e.getView().getPlayer());
                } else if (isEqualsItem(e, "&l&bСпециальное")) {
                    Trader.openSpecialMenu((Player) e.getView().getPlayer());
                }
                e.setCancelled(true);
            }
        } else if (e.getView().getTitle().equals("Блоки")) {
            if (e.getCurrentItem() != null && e.getCurrentItem().getItemMeta() != null) {

                if (isEqualsItem(e, "&fГладкий песчаник")) {
                    ItemStack sandstoneItem = new ItemStack(Material.SANDSTONE, 1, (byte) 2);
                    buyItem(e, BRONZE, 1, sandstoneItem, 2);
                } else if (isEqualsItem(e, "&fСтупеньки из песчаника")) {
                    buyItem(e, BRONZE, 3, new ItemStack(Material.SANDSTONE_STAIRS), 2);
                } else if (isEqualsItem(e, "&fЭндерняк")) {
                    buyItem(e, BRONZE, 7, new ItemStack(Material.ENDER_STONE), 1);
                } else if (isEqualsItem(e, "&fЖелезный блок")) {
                    buyItem(e, IRON, 3, new ItemStack(Material.IRON_BLOCK), 1);
                } else if (isEqualsItem(e, "&fСветящийся камень")) {
                    buyItem(e, BRONZE, 16, new ItemStack(Material.GLOWSTONE), 4);
                } else if (isEqualsItem(e, "&fСтекло")) {
                    buyItem(e, BRONZE, 4, new ItemStack(Material.GLASS), 1);
                } else if (isEqualsItem(e, "&f← &eНазад")) {
                    Trader.openGlobalMenu((Player) e.getView().getPlayer());
                }
                e.setCancelled(true);
            }
        } else if (e.getView().getTitle().equals("Броня")) {
            if (e.getCurrentItem() != null && e.getCurrentItem().getItemMeta() != null) {

                if (isEqualsItem(e, "&fЖелезный сет")) {
                    ItemStack ironLegsStack = new ItemStack(Material.IRON_LEGGINGS, 1);
                    ItemMeta ironLegsMeta = ironLegsStack.getItemMeta();
                    ironLegsMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
                    ironLegsStack.setItemMeta(ironLegsMeta);

                    ItemStack ironBootsStack = new ItemStack(Material.IRON_BOOTS, 1);
                    ItemMeta ironBootsMeta = ironBootsStack.getItemMeta();
                    ironBootsMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
                    ironBootsStack.setItemMeta(ironBootsMeta);

                    ItemStack ironHelmetStack = new ItemStack(Material.IRON_HELMET, 1);
                    ItemMeta ironHelmetMeta = ironHelmetStack.getItemMeta();
                    ironHelmetMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
                    ironHelmetStack.setItemMeta(ironHelmetMeta);

                    List<ItemStack> ironArmorList = new ArrayList<>();
                    ironArmorList.add(ironBootsStack);
                    ironArmorList.add(ironLegsStack);
                    ironArmorList.add(ironHelmetStack);
                    buyArmor(e, BRONZE, 6, ironArmorList, 1);
                } else if (isEqualsItem(e, "&aЖелезка уровень 1")) {
                    ItemStack ironChestplateStack = new ItemStack(Material.IRON_CHESTPLATE, 1);
                    ItemMeta ironChestplateMeta = ironChestplateStack.getItemMeta();
                    ironChestplateMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
                    ironChestplateStack.setItemMeta(ironChestplateMeta);
                    buyArmor(e, IRON, 1, ironChestplateStack, 1);
                } else if (isEqualsItem(e, "&f← &eНазад")) {
                    Trader.openGlobalMenu((Player) e.getView().getPlayer());
                }
                e.setCancelled(true);
            }
        } else if (e.getView().getTitle().equals("Кирки")) {
            if (e.getCurrentItem() != null && e.getCurrentItem().getItemMeta() != null) {
                if (isEqualsItem(e, "&bКаменная кирка")) {
                    ItemStack stonePickaxeStack = new ItemStack(Material.STONE_PICKAXE, 1);
                    ItemMeta stonePickaxeMeta = stonePickaxeStack.getItemMeta();
                    stonePickaxeMeta.addEnchant(Enchantment.DIG_SPEED, 1, true);
                    stonePickaxeStack.setItemMeta(stonePickaxeMeta);
                    buyItem(e, BRONZE, 4, stonePickaxeStack, 1);
                } else if (isEqualsItem(e, "&bЖелезная кирка")) {
                    ItemStack ironPickaxeStack = new ItemStack(Material.IRON_PICKAXE, 1);
                    ItemMeta ironPickaxeMeta = ironPickaxeStack.getItemMeta();
                    ironPickaxeMeta.addEnchant(Enchantment.DIG_SPEED, 1, true);
                    ironPickaxeStack.setItemMeta(ironPickaxeMeta);
                    buyItem(e, IRON, 2, ironPickaxeStack, 1);
                } else if (isEqualsItem(e, "&bАлмазная кирка") && e.getCurrentItem().getItemMeta().getEnchants().get(Enchantment.DIG_SPEED) == 1) {
                    ItemStack diamond1PickaxeStack = new ItemStack(Material.DIAMOND_PICKAXE, 1);
                    ItemMeta diamond1PickaxeMeta = diamond1PickaxeStack.getItemMeta();
                    diamond1PickaxeMeta.addEnchant(Enchantment.DIG_SPEED, 1, true);
                    diamond1PickaxeStack.setItemMeta(diamond1PickaxeMeta);
                    buyItem(e, GOLD, 2, diamond1PickaxeStack, 1);
                } else if (isEqualsItem(e, "&bАлмазная кирка") && e.getCurrentItem().getItemMeta().getEnchants().get(Enchantment.DIG_SPEED) == 3) {
                    ItemStack diamond1PickaxeStack = new ItemStack(Material.DIAMOND_PICKAXE, 1);
                    ItemMeta diamond1PickaxeMeta = diamond1PickaxeStack.getItemMeta();
                    diamond1PickaxeMeta.addEnchant(Enchantment.DIG_SPEED, 3, true);
                    diamond1PickaxeStack.setItemMeta(diamond1PickaxeMeta);
                    buyItem(e, GOLD, 8, diamond1PickaxeStack, 1);
                } else if (isEqualsItem(e, "&f← &eНазад")) {
                    Trader.openGlobalMenu((Player) e.getView().getPlayer());
                }
                e.setCancelled(true);
            }
        } else if (e.getView().getTitle().equals("Мечи")) {
            if (e.getCurrentItem() != null && e.getCurrentItem().getItemMeta() != null) {
                if (isEqualsItem(e, "&bЖелезный меч")) {
                    ItemStack ironSwordStack = new ItemStack(Material.IRON_SWORD, 1);
                    ItemMeta ironSwordMeta = ironSwordStack.getItemMeta();
                    ironSwordMeta.setDisplayName(ColorUtil.getMessage("&bЖелезный меч"));
                    ironSwordMeta.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
                    ironSwordMeta.addEnchant(Enchantment.DURABILITY, 1, true);
                    ironSwordStack.setItemMeta(ironSwordMeta);
                    buyItem(e, BRONZE, 3, ironSwordStack, 1);
                } else if (isEqualsItem(e, "&aАлмеч")) {
                    ItemStack diamondSwordStack = new ItemStack(Material.DIAMOND_SWORD, 1);
                    ItemMeta diamondSwordMeta = diamondSwordStack.getItemMeta();
                    diamondSwordMeta.setDisplayName(ColorUtil.getMessage("&aАлмеч"));
                    diamondSwordMeta.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
                    diamondSwordMeta.addEnchant(Enchantment.DURABILITY, 1, true);
                    diamondSwordStack.setItemMeta(diamondSwordMeta);
                    buyItem(e, IRON, 1, diamondSwordStack, 1);
                } else if (isEqualsItem(e, "&bЭкскалибур")) {
                    ItemStack excaliburSwordStack = new ItemStack(Material.DIAMOND_SWORD, 1);
                    ItemMeta excaliburSwordMeta = excaliburSwordStack.getItemMeta();
                    excaliburSwordMeta.setDisplayName(ColorUtil.getMessage("&bЭкскалибур"));
                    excaliburSwordMeta.addEnchant(Enchantment.DAMAGE_ALL, 2, true);
                    excaliburSwordMeta.addEnchant(Enchantment.DURABILITY, 1, true);
                    excaliburSwordMeta.addEnchant(Enchantment.KNOCKBACK, 1, true);
                    excaliburSwordStack.setItemMeta(excaliburSwordMeta);
                    buyItem(e, IRON, 5, excaliburSwordStack, 1);
                } else if (isEqualsItem(e, "&6Смертоносец")) {
                    ItemStack deathBringerSwordStack = new ItemStack(Material.DIAMOND_SWORD, 1);
                    ItemMeta deathBringerSwordMeta = deathBringerSwordStack.getItemMeta();
                    deathBringerSwordMeta.setDisplayName(ColorUtil.getMessage("&6Смертоносец"));
                    deathBringerSwordMeta.addEnchant(Enchantment.DAMAGE_ALL, 3, true);
                    deathBringerSwordMeta.addEnchant(Enchantment.DURABILITY, 1, true);
                    deathBringerSwordMeta.addEnchant(Enchantment.KNOCKBACK, 1, true);
                    deathBringerSwordStack.setItemMeta(deathBringerSwordMeta);
                    buyItem(e, GOLD, 6, deathBringerSwordStack, 1);
                } else if (isEqualsItem(e, "&cКиллмагедон")) {
                    ItemStack killmagedonSwordStack = new ItemStack(Material.DIAMOND_SWORD, 1);
                    ItemMeta killmagedonSwordMeta = killmagedonSwordStack.getItemMeta();
                    killmagedonSwordMeta.setDisplayName(ColorUtil.getMessage("&cКиллмагедон"));
                    killmagedonSwordMeta.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
                    killmagedonSwordMeta.addEnchant(Enchantment.DURABILITY, 1, true);
                    killmagedonSwordMeta.addEnchant(Enchantment.KNOCKBACK, 2, true);
                    killmagedonSwordMeta.addEnchant(Enchantment.FIRE_ASPECT, 1, true);
                    killmagedonSwordStack.setItemMeta(killmagedonSwordMeta);
                    buyItem(e, GOLD, 30, killmagedonSwordStack, 1);
                } else if (isEqualsItem(e, "&f← &eНазад")) {
                    Trader.openGlobalMenu((Player) e.getView().getPlayer());
                }
                e.setCancelled(true);
            }
        } else if (e.getView().getTitle().equals("Еда")) {
            if (e.getCurrentItem() != null && e.getCurrentItem().getItemMeta() != null) {

                if (isEqualsItem(e, "&fЕда чемпионов")) {
                    buyItem(e, BRONZE, 1, new ItemStack(Material.APPLE), 1);
                } else if (isEqualsItem(e, "&fЖареная свинина")) {
                    buyItem(e, BRONZE, 2, new ItemStack(Material.GRILLED_PORK), 1);
                } else if (isEqualsItem(e, "&f← &eНазад")) {
                    Trader.openGlobalMenu((Player) e.getView().getPlayer());
                }
                e.setCancelled(true);
            }
        } else if (e.getView().getTitle().equals("Специальное")) {
            if (e.getCurrentItem() != null && e.getCurrentItem().getItemMeta() != null) {

                if (isEqualsItem(e, "&fПаутинка")) {
                    buyItem(e, BRONZE, 24, new ItemStack(Material.WEB), 1);
                } else if (isEqualsItem(e, "&fУдочка")) {
                    buyItem(e, IRON, 5, new ItemStack(Material.FISHING_ROD), 1);
                } else if (isEqualsItem(e, "&bТелепорт домой")) {
                    ItemStack teleportStack = new ItemStack(Material.SULPHUR, 1);
                    ItemMeta teleportMeta = teleportStack.getItemMeta();
                    teleportMeta.setDisplayName(ColorUtil.getMessage("&bТелепорт домой"));
                    teleportStack.setItemMeta(teleportMeta);
                    buyItem(e, IRON, 3, teleportStack, 1);
                } else if (isEqualsItem(e, "&eGPS трекер")) {
                    ItemStack gpsStack = new ItemStack(Material.COMPASS, 1);
                    ItemMeta gpsMeta = gpsStack.getItemMeta();
                    gpsMeta.setDisplayName(ColorUtil.getMessage("&eGPS трекер"));
                    gpsStack.setItemMeta(gpsMeta);
                    buyItem(e, IRON, 3, gpsStack, 1);
                } else if (isEqualsItem(e, "&bСпасательная платформа")) {
                    ItemStack platformStack = new ItemStack(Material.BLAZE_ROD, 1);
                    ItemMeta platformMeta = platformStack.getItemMeta();
                    platformMeta.setDisplayName(ColorUtil.getMessage("&bСпасательная платформа"));
                    platformStack.setItemMeta(platformMeta);
                    buyItem(e, IRON, 14, platformStack, 1);
                } else if (isEqualsItem(e, "&f← &eНазад")) {
                    Trader.openGlobalMenu((Player) e.getView().getPlayer());
                }
                e.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onTraderClick(PlayerInteractEntityEvent e) {
        Entity ent = e.getRightClicked();
        if (ent instanceof Villager) {
            e.setCancelled(true);
            Trader.openGlobalMenu(e.getPlayer());
        }
    }
//    @EventHandler
//    public void onVillagerSpawn(PlayerInteractEvent e){
//        if(e.getItem() == null) return;
//        if (!(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK)) return;
//        if (!(e.getItem().getType() == Material.MONSTER_EGG)) return;
//        Player p = e.getPlayer();
//        e.setCancelled(true);
//        Villager vil = (Villager) p.getLocation().getWorld().spawnEntity(p.getLocation(),EntityType.VILLAGER);
//        vil.setCustomName(ChatColor.YELLOW + "Торговец");
//        vil.setCustomNameVisible(true);
//        //vil.setAI(false);
//        vil.setAdult();
//        vil.setNoDamageTicks(200);
//    }

    private boolean checkItem(Player p, ItemStack itemStack, int amount) {
        return p.getInventory().containsAtLeast(itemStack, amount);
    }

    private boolean isShiftClick(InventoryClickEvent e) {
        return (e.getClick() == ClickType.SHIFT_LEFT || e.getClick() == ClickType.SHIFT_RIGHT);
    }

    private boolean isEqualsItem(InventoryClickEvent e, String itemDisplayName) {
        if (e.getCurrentItem().getItemMeta().getDisplayName() != null) {
            return e.getCurrentItem().getItemMeta().getDisplayName().equals(ColorUtil.getMessage(itemDisplayName));
        } else {
            return false;
        }
    }

    private boolean buyItemShift(Player p, ItemStack resourceItemStack, ItemStack productItemStack, int resourceAmount, int productAmount) {
        int factor = 10;
        for (factor = 10; factor > 0; factor--) {
            buyItemNormal(p, resourceItemStack, productItemStack, resourceAmount, productAmount);
        }
        return true;
    }

    private boolean buyItemNormal(Player p, ItemStack resourceItemStack, ItemStack productItemStack, int resourceAmount, int productAmount) {
        if (checkItem(p, resourceItemStack, resourceAmount)) {
            resourceItemStack.setAmount(resourceAmount);
            p.getInventory().removeItem(resourceItemStack);
            productItemStack.setAmount(productAmount);
            p.getInventory().addItem(productItemStack);
            return true;
        } else {
            return false;
        }
    }

    private boolean buyItem(InventoryClickEvent e, ItemStack resourceItemStack, int resourceAmount, ItemStack productItemStack, int productAmount) {
        Player p = (Player) e.getView().getPlayer();
        if (isShiftClick(e)) {
            buyItemShift(p, resourceItemStack, productItemStack, resourceAmount, productAmount);
        } else {
            buyItemNormal(p, resourceItemStack, productItemStack, resourceAmount, productAmount);
        }
        e.setCancelled(true);
        return true;
    }

    private boolean buyItem(InventoryClickEvent e, ItemStack resourceItemsStack, int resourceAmount, List<ItemStack> productItemStack, int productAmount) {
        Player p = (Player) e.getView().getPlayer();
        e.setCancelled(true);
        if (checkItem(p, resourceItemsStack, resourceAmount)) {
            resourceItemsStack.setAmount(resourceAmount);
            p.getInventory().removeItem(resourceItemsStack);
            for (ItemStack product : productItemStack) {
                product.setAmount(productAmount);
                p.getInventory().addItem(product);
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean buyArmor(InventoryClickEvent e, ItemStack resourceItemsStack, int resourceAmount, List<ItemStack> productItemStack, int productAmount) {
        Player p = (Player) e.getView().getPlayer();
        e.setCancelled(true);

        resourceItemsStack.setAmount(resourceAmount);
        p.getInventory().removeItem(resourceItemsStack);
        for (ItemStack product : productItemStack) {
            product.setAmount(productAmount);
            if (product.getType() == Material.IRON_BOOTS || product.getType() == Material.DIAMOND_BOOTS) {
                p.getInventory().setBoots(product);
            } else if (product.getType() == Material.IRON_LEGGINGS || product.getType() == Material.DIAMOND_LEGGINGS) {
                p.getInventory().setLeggings(product);
            } else if (product.getType() == Material.IRON_HELMET || product.getType() == Material.DIAMOND_HELMET) {
                p.getInventory().setHelmet(product);
            } else {
                p.getInventory().addItem(product);
            }
        }
        return true;
    }

    private boolean buyArmor(InventoryClickEvent e, ItemStack resourceItemStack, int resourceAmount, ItemStack productItemStack, int productAmount) {
        Player p = (Player) e.getView().getPlayer();
        if (checkItem(p, resourceItemStack, resourceAmount)) {
            resourceItemStack.setAmount(resourceAmount);
            p.getInventory().removeItem(resourceItemStack);
            productItemStack.setAmount(productAmount);
            if (p.getInventory().getChestplate().getType() == Material.IRON_CHESTPLATE || p.getInventory().getChestplate().getType() == null) {
                p.getInventory().setChestplate(productItemStack);
            } else {
                p.getInventory().addItem(resourceItemStack);
            }
            return true;
        } else {
            return false;
        }
    }

//    private boolean buySword(InventoryClickEvent e, ItemStack resourceItemStack, int resourceAmount, ItemStack productItemStack, int productAmount) {
//        Player p = (Player) e.getView().getPlayer();
//        if (checkItem(p, resourceItemStack, resourceAmount)) {
//            resourceItemStack.setAmount(resourceAmount);
//            p.getInventory().removeItem(resourceItemStack);
//            productItemStack.setAmount(productAmount);
//            if (p.getInventory().contains(Material.STONE_SWORD)) {
//                for (ItemStack slotStack : p.getInventory().getContents()) {
//                    if (slotStack.getType() == Material.STONE_SWORD) {
//                        slotStack.setType(productItemStack.getType());
//                        slotStack.setItemMeta(productItemStack.getItemMeta());
//                        slotStack.setData(productItemStack.getData());
//                        slotStack.setDurability(productItemStack.getDurability());
//                        slotStack.setAmount(productAmount);
//                        p.updateInventory();
//                    }
//                }
//            } else {
//                p.getInventory().addItem(resourceItemStack);
//            }
//            return true;
//        } else {
//            return false;
//        }
//    }
}
