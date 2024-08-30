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
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.lordalex.bedwarshard.BedWarsHard;
import org.lordalex.bedwarshard.Items.ShopItem;
import org.lordalex.bedwarshard.Items.Trader;
import org.lordalex.bedwarshard.Utils.ColorUtil;
import org.lordalex.bedwarshard.config.PlayerInfo;

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
            e.setCancelled(true);
            if (e.getCurrentItem() != null && e.getCurrentItem().getItemMeta() != null) {
                if (e.getCurrentItem().equals(ShopItem.blocksMenuStack())) {
                    Trader.openBlocksMenu((Player) e.getView().getPlayer());
                } else if (e.getCurrentItem().equals(ShopItem.armorMenuStack())) {
                    Trader.openArmorMenu((Player) e.getView().getPlayer());
                } else if (e.getCurrentItem().equals(ShopItem.pickaxeMenuStack())) {
                    Trader.openPickaxeMenu((Player) e.getView().getPlayer());
                } else if (e.getCurrentItem().equals(ShopItem.swordMenuStack())) {
                    Trader.openSwordMenu((Player) e.getView().getPlayer());
                } else if (e.getCurrentItem().equals(ShopItem.bowMenuStack())) {
                    Trader.openBowMenu((Player) e.getView().getPlayer());
                } else if (e.getCurrentItem().equals(ShopItem.foodMenuStack())) {
                    Trader.openFoodMenu((Player) e.getView().getPlayer());
                } else if (e.getCurrentItem().equals(ShopItem.chestsMenuStack())) {
                    Trader.openChestMenu((Player) e.getView().getPlayer());
                } else if (e.getCurrentItem().equals(ShopItem.potionMenuStack())) {
                    Trader.openPotionMenu((Player) e.getView().getPlayer());
                } else if (e.getCurrentItem().equals(ShopItem.specialMenuStack())) {
                    Trader.openSpecialMenu((Player) e.getView().getPlayer());
                } else if (e.getCurrentItem().equals(ShopItem.exchangerMenuStack())) {
                    Trader.openExchangerMenu((Player) e.getView().getPlayer());
                }
            }
        } else if (e.getView().getTitle().equals("Блоки")) {
            e.setCancelled(true);
            if (e.getCurrentItem() != null && e.getCurrentItem().getItemMeta() != null) {
                if (e.getCurrentItem().equals(ShopItem.sandstone())) {
                    buyItem(e, BRONZE, 1, new ItemStack(Material.SANDSTONE, 1, (byte) 2), 2);
                } else if (e.getCurrentItem().equals(ShopItem.sandstoneStairs())) {
                    buyItem(e, BRONZE, 3, new ItemStack(Material.SANDSTONE_STAIRS), 2);
                } else if (e.getCurrentItem().equals(ShopItem.enderStone())) {
                    buyItem(e, BRONZE, 7, new ItemStack(Material.ENDER_STONE), 1);
                } else if (e.getCurrentItem().equals(ShopItem.ironBlock())) {
                    buyItem(e, IRON, 3, new ItemStack(Material.IRON_BLOCK), 1);
                } else if (e.getCurrentItem().equals(ShopItem.glowStone())) {
                    buyItem(e, BRONZE, 16, new ItemStack(Material.GLOWSTONE), 4);
                } else if (e.getCurrentItem().equals(ShopItem.coloredGlass(p))) {
                    buyItem(e, BRONZE, 4, ShopItem.coloredGlass(p), 1);
                } else if (e.getCurrentItem().equals(ShopItem.slimeBlock())) {
                    buyItem(e, BRONZE, 32, new ItemStack(Material.SLIME_BLOCK), 1);
                } else if (e.getCurrentItem().equals(ShopItem.returnButtonStack())) {
                    Trader.openGlobalMenu((Player) e.getView().getPlayer());
                }
            }
        } else if (e.getView().getTitle().equals("Броня")) {
            e.setCancelled(true);
            if (e.getCurrentItem() != null && e.getCurrentItem().getItemMeta() != null) {
                if (e.getCurrentItem().equals(ShopItem.IronSetMenuStack())) {
                    buyArmor(e, BRONZE, 6, ShopItem.IronSetStack(), 1);
                } else if (e.getCurrentItem().equals(ShopItem.ironChestplate1())) {
                    buyArmor(e, IRON, 1, ShopItem.ironChestplate1(), 1);
                } else if (e.getCurrentItem().equals(ShopItem.ironChestplate2())) {
                    buyArmor(e, IRON, 3, ShopItem.ironChestplate2(), 1);
                } else if (e.getCurrentItem().equals(ShopItem.diamondSetMenuStack())) {
                    buyArmor(e, IRON, 9, ShopItem.diamondSetStack(), 1);
                } else if (e.getCurrentItem().equals(ShopItem.diamondChestplate0())) {
                    buyArmor(e, IRON, 9, ShopItem.diamondChestplate0(), 1);
                } else if (e.getCurrentItem().equals(ShopItem.diamondChestplate1())) {
                    buyArmor(e, IRON, 20, ShopItem.diamondChestplate1(), 1);
                } else if (e.getCurrentItem().equals(ShopItem.diamondChestplate2())) {
                    buyArmor(e, GOLD, 3, ShopItem.diamondChestplate2(), 1);
                } else if (e.getCurrentItem().equals(ShopItem.diamondChestplate3())) {
                    buyArmor(e, GOLD, 8, ShopItem.diamondChestplate3(), 1);
                } else if (e.getCurrentItem().equals(ShopItem.returnButtonStack())) {
                    Trader.openGlobalMenu((Player) e.getView().getPlayer());
                }
            }
        } else if (e.getView().getTitle().equals("Кирки")) {
            e.setCancelled(true);
            if (e.getCurrentItem() != null && e.getCurrentItem().getItemMeta() != null) {
                if (e.getCurrentItem().equals(ShopItem.stonePickaxe())) {
                    buyItem(e, BRONZE, 4, ShopItem.stonePickaxe(), 1);
                } else if (e.getCurrentItem().equals(ShopItem.ironPickaxe())) {
                    buyItem(e, IRON, 2, ShopItem.ironPickaxe(), 1);
                } else if (e.getCurrentItem().equals(ShopItem.diamondPickaxe1())) {
                    buyItem(e, GOLD, 2, ShopItem.diamondPickaxe1(), 1);
                } else if (e.getCurrentItem().equals(ShopItem.diamondPickaxe3())) {
                    buyItem(e, GOLD, 8, ShopItem.diamondPickaxe3(), 1);
                } else if (e.getCurrentItem().equals(ShopItem.returnButtonStack())) {
                    Trader.openGlobalMenu((Player) e.getView().getPlayer());
                }
            }
        } else if (e.getView().getTitle().equals("Мечи")) {
            e.setCancelled(true);
            if (e.getCurrentItem() != null && e.getCurrentItem().getItemMeta() != null) {
                if (e.getCurrentItem().equals(ShopItem.ironSword())) {
                    buySword(e, BRONZE, 3, ShopItem.ironSword(), 1);
                } else if (e.getCurrentItem().equals(ShopItem.diamondSword())) {
                    buySword(e, IRON, 1, ShopItem.diamondSword(), 1);
                } else if (e.getCurrentItem().equals(ShopItem.excalibur())) {
                    buySword(e, IRON, 5, ShopItem.excalibur(), 1);
                } else if (e.getCurrentItem().equals(ShopItem.deathBringer())) {
                    buySword(e, GOLD, 8, ShopItem.deathBringer(), 1);
                } else if (e.getCurrentItem().equals(ShopItem.killmagedon())) {
                    buySword(e, GOLD, 30, ShopItem.killmagedon(), 1);
                } else if (e.getCurrentItem().equals(ShopItem.returnButtonStack())) {
                    Trader.openGlobalMenu((Player) e.getView().getPlayer());
                }
            }
        } else if (e.getView().getTitle().equals("Луки")) {
            e.setCancelled(true);
            if (e.getCurrentItem() != null && e.getCurrentItem().getItemMeta() != null) {
                if (e.getCurrentItem().equals(ShopItem.bow1())) {
                    buyItem(e, IRON, 7, ShopItem.bow1(), 1);
                } else if (e.getCurrentItem().equals(ShopItem.bow2())) {
                    buyItem(e, GOLD, 1, ShopItem.bow2(), 1);
                } else if (e.getCurrentItem().equals(ShopItem.bow3())) {
                    buyItem(e, GOLD, 9, ShopItem.bow3(), 1);
                } else if (e.getCurrentItem().equals(ShopItem.bow4())) {
                    buyItem(e, GOLD, 30, ShopItem.bow4(), 1);
                } else if (e.getCurrentItem().equals(ShopItem.arrow())) {
                    buyItem(e, GOLD, 1, ShopItem.arrow(), 1);
                } else if (e.getCurrentItem().equals(ShopItem.returnButtonStack())) {
                    Trader.openGlobalMenu((Player) e.getView().getPlayer());
                }
            }
        } else if (e.getView().getTitle().equals("Еда")) {
            e.setCancelled(true);
            if (e.getCurrentItem() != null && e.getCurrentItem().getItemMeta() != null) {
                if (e.getCurrentItem().equals(ShopItem.apple())) {
                    buyItem(e, BRONZE, 1, ShopItem.apple(), 1);
                } else if (e.getCurrentItem().equals(ShopItem.pork())) {
                    buyItem(e, BRONZE, 2, ShopItem.pork(), 1);
                } else if (e.getCurrentItem().equals(ShopItem.cake())) {
                    buyItem(e, IRON, 1, ShopItem.cake(), 1);
                } else if (e.getCurrentItem().equals(ShopItem.goldenApple())) {
                    buyItem(e, GOLD, 2, ShopItem.goldenApple(), 1);
                } else if (e.getCurrentItem().equals(ShopItem.returnButtonStack())) {
                    Trader.openGlobalMenu((Player) e.getView().getPlayer());
                }
            }
        } else if (e.getView().getTitle().equals("Сундуки")) {
            e.setCancelled(true);
            if (e.getCurrentItem() != null && e.getCurrentItem().getItemMeta() != null) {
                if (e.getCurrentItem().equals(ShopItem.chest())) {
                    buyItem(e, IRON, 1, new ItemStack(Material.CHEST), 1);
                } else if (e.getCurrentItem().equals(ShopItem.enderChest())) {
                    buyItem(e, GOLD, 1, ShopItem.enderChest(), 1);
                } else if (e.getCurrentItem().equals(ShopItem.returnButtonStack())) {
                    Trader.openGlobalMenu((Player) e.getView().getPlayer());
                }
            }
        } else if (e.getView().getTitle().equals("Зелья")) {
            e.setCancelled(true);
            if (e.getCurrentItem() != null && e.getCurrentItem().getItemMeta() != null) {
                if (e.getCurrentItem().equals(ShopItem.potionHeal1())) {
                    buyItem(e, IRON, 2, ShopItem.potionHeal1(), 1);
                } else if (e.getCurrentItem().equals(ShopItem.potionHeal2())) {
                    buyItem(e, IRON, 5, ShopItem.potionHeal2(), 1);
                } else if (e.getCurrentItem().equals(ShopItem.potionSpeed())) {
                    buyItem(e, IRON, 4, ShopItem.potionSpeed(), 1);
                } else if (e.getCurrentItem().equals(ShopItem.potionRegen())) {
                    buyItem(e, IRON, 7, ShopItem.potionRegen(), 1);
                } else if (e.getCurrentItem().equals(ShopItem.potionStrength())) {
                    buyItem(e, GOLD, 4, ShopItem.potionStrength(), 1);
                } else if (e.getCurrentItem().equals(ShopItem.potionInvisibility())) {
                    buyItem(e, IRON, 50, ShopItem.potionInvisibility(), 1);
                } else if (e.getCurrentItem().equals(ShopItem.returnButtonStack())) {
                    Trader.openGlobalMenu((Player) e.getView().getPlayer());
                }
            }
        } else if (e.getView().getTitle().equals("Специальное")) {
            e.setCancelled(true);
            if (e.getCurrentItem() != null && e.getCurrentItem().getItemMeta() != null) {
                if (e.getCurrentItem().equals(ShopItem.ladder())) {
                    buyItem(e, BRONZE, 1, ShopItem.ladder(), 1);
                } else if (e.getCurrentItem().equals(ShopItem.web())) {
                    buyItem(e, BRONZE, 24, ShopItem.web(), 1);
                } else if (e.getCurrentItem().equals(ShopItem.fishingRod())) {
                    buyItem(e, IRON, 5, ShopItem.fishingRod(), 1);
                } else if (e.getCurrentItem().equals(ShopItem.lighter())) {
                    buyItem(e, IRON, 7, ShopItem.lighter(), 1);
                } else if (e.getCurrentItem().equals(ShopItem.TNT())) {
                    buyItem(e, GOLD, 7, new ItemStack(Material.TNT), 1);
                } else if (e.getCurrentItem().equals(ShopItem.enderPearl())) {
                    buyItem(e, GOLD, 13, ShopItem.enderPearl(), 1);
                } else if (e.getCurrentItem().equals(ShopItem.teleportHome())) {
                    buyItem(e, IRON, 3, ShopItem.teleportHome(), 1);
                } else if (e.getCurrentItem().equals(ShopItem.thorBone())) {
                    buyItem(e, IRON, 5, ShopItem.thorBone(), 1);
                } else if (e.getCurrentItem().equals(ShopItem.trackerGPS())) {
                    buyItem(e, IRON, 10, ShopItem.trackerGPS(), 1);
                } else if (e.getCurrentItem().equals(ShopItem.savingPlatform())) {
                    buyItem(e, IRON, 14, ShopItem.savingPlatform(), 1);
                } else if (e.getCurrentItem().equals(ShopItem.trap())) {
                    buyItem(e, GOLD, 2, ShopItem.trap(), 1);
                } else if (e.getCurrentItem().equals(ShopItem.returnButtonStack())) {
                    Trader.openGlobalMenu((Player) e.getView().getPlayer());
                }
            }
        } else if (e.getView().getTitle().equals("Обмен валют")) {
            e.setCancelled(true);
            if (e.getCurrentItem() != null && e.getCurrentItem().getItemMeta() != null) {
                if (e.getCurrentItem().equals(ShopItem.bronzeToIronStack())) {
                    buyItem(e, BRONZE, 48, IRON, 1);
                } else if (e.getCurrentItem().equals(ShopItem.ironToGoldStack())) {
                    buyItem(e, IRON, 14, GOLD, 1);
                } else if (e.getCurrentItem().equals(ShopItem.ironToBronzeStack())) {
                    buyItem(e, IRON, 1, BRONZE, 32);
                } else if (e.getCurrentItem().equals(ShopItem.goldToIronStack())) {
                    buyItem(e, GOLD, 1, IRON, 7);
                } else if (e.getCurrentItem().equals(ShopItem.returnButtonStack())) {
                    Trader.openGlobalMenu((Player) e.getView().getPlayer());
                }
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
        if (p.getInventory().firstEmpty() != -1) {
            return p.getInventory().containsAtLeast(itemStack, amount);
        } else {
            return false;
        }
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

    private void buyItemShift(Player p, ItemStack resourceItemStack, ItemStack productItemStack, int resourceAmount, int productAmount) {
        int factor = 10;
        for (factor = 10; factor > 0; factor--) {
            buyItemNormal(p, resourceItemStack, productItemStack, resourceAmount, productAmount);
        }
    }

    private void buyItemNormal(Player p, ItemStack resourceItemStack, ItemStack productItemStack, int resourceAmount, int productAmount) {
        if (checkItem(p, resourceItemStack, resourceAmount)) {
            resourceItemStack.setAmount(resourceAmount);
            p.getInventory().removeItem(resourceItemStack);
            productItemStack.setAmount(productAmount);
            ItemMeta productItemMeta = productItemStack.getItemMeta();
            if (productItemMeta.hasLore()) {
                List<String> lore = productItemMeta.getLore();
                lore.removeIf(s -> s.contains("Цена: "));
                productItemMeta.setLore(lore);
                productItemStack.setItemMeta(productItemMeta);
            }
            p.getInventory().addItem(productItemStack);
        }
    }

    private void buyItem(InventoryClickEvent e, ItemStack resourceItemStack, int resourceAmount, ItemStack productItemStack, int productAmount) {
        Player p = (Player) e.getView().getPlayer();
        if (isShiftClick(e)) {
            buyItemShift(p, resourceItemStack, productItemStack, resourceAmount, productAmount);
        } else {
            buyItemNormal(p, resourceItemStack, productItemStack, resourceAmount, productAmount);
        }
        e.setCancelled(true);
    }

    private void buyItem(InventoryClickEvent e, ItemStack resourceItemsStack, int resourceAmount, List<ItemStack> productItemStack, int productAmount) {
        Player p = (Player) e.getView().getPlayer();
        e.setCancelled(true);
        if (checkItem(p, resourceItemsStack, resourceAmount)) {
            resourceItemsStack.setAmount(resourceAmount);
            p.getInventory().removeItem(resourceItemsStack);
            for (ItemStack product : productItemStack) {
                product.setAmount(productAmount);
                p.getInventory().addItem(product);
            }
        }
    }

    private void buyArmor(InventoryClickEvent e, ItemStack resourceItemsStack, int resourceAmount, List<ItemStack> productItemStack, int productAmount) {
        Player p = (Player) e.getView().getPlayer();
        List<Material> bootsMaterials = new ArrayList<>();
        bootsMaterials.add(Material.IRON_BOOTS);
        bootsMaterials.add(Material.DIAMOND_BOOTS);

        List<Material> leggingsMaterials = new ArrayList<>();
        leggingsMaterials.add(Material.IRON_LEGGINGS);
        leggingsMaterials.add(Material.DIAMOND_LEGGINGS);

        List<Material> helmetMaterials = new ArrayList<>();
        helmetMaterials.add(Material.IRON_HELMET);
        helmetMaterials.add(Material.DIAMOND_HELMET);

        resourceItemsStack.setAmount(resourceAmount);
        p.getInventory().removeItem(resourceItemsStack);
        boolean wasChanged = false;
        for (ItemStack product : productItemStack) {
            product.setAmount(productAmount);
            if (bootsMaterials.contains(product.getType()) && (p.getInventory().getBoots() == null || p.getInventory().getBoots().getType() == Material.LEATHER_BOOTS)) {
                p.getInventory().setBoots(product);
                wasChanged = true;
            } else if (leggingsMaterials.contains(product.getType()) && (p.getInventory().getLeggings() == null || p.getInventory().getLeggings().getType() == Material.LEATHER_LEGGINGS)) {
                p.getInventory().setLeggings(product);
                wasChanged = true;
            } else if (helmetMaterials.contains(product.getType()) && (p.getInventory().getHelmet() == null || p.getInventory().getHelmet().getType() == Material.LEATHER_HELMET)) {
                p.getInventory().setHelmet(product);
                wasChanged = true;
            } else {
                p.getInventory().addItem(product);
            }
        }
        if(wasChanged){
            p.sendMessage(ColorUtil.getMessage("&aВаша броня заменена на новую"));
        }
        p.updateInventory();
    }

    private void buyArmor(InventoryClickEvent e, ItemStack resourceItemStack, int resourceAmount, ItemStack productItemStack, int productAmount) {
        Player p = (Player) e.getView().getPlayer();
        if (checkItem(p, resourceItemStack, resourceAmount)) {
            resourceItemStack.setAmount(resourceAmount);
            p.getInventory().removeItem(resourceItemStack);
            productItemStack.setAmount(productAmount);
            ItemMeta productItemMeta = productItemStack.getItemMeta();
            if (productItemMeta.hasLore()) {
                List<String> lore = productItemMeta.getLore();
                lore.removeIf(s -> s.contains("Цена: "));
                productItemMeta.setLore(lore);
                productItemStack.setItemMeta(productItemMeta);
            }
            if (p.getInventory().getChestplate() == null || p.getInventory().getChestplate().getType() == Material.LEATHER_CHESTPLATE) {
                p.getInventory().setChestplate(productItemStack);
                p.sendMessage(ColorUtil.getMessage("&aВаш нагрудник заменен на новый"));
            } else {
                p.getInventory().addItem(productItemStack);
            }
            p.updateInventory();
        }
    }

    private void buySword(InventoryClickEvent e, ItemStack resourceItemStack, int resourceAmount, ItemStack productItemStack, int productAmount) {
        Player p = (Player) e.getView().getPlayer();
        if (checkItem(p, resourceItemStack, resourceAmount)) {
            resourceItemStack.setAmount(resourceAmount);
            p.getInventory().removeItem(resourceItemStack);
            productItemStack.setAmount(productAmount);
            ItemMeta productItemMeta = productItemStack.getItemMeta();
            if (productItemMeta.hasLore()) {
                List<String> lore = productItemMeta.getLore();
                lore.removeIf(s -> s.contains("Цена: "));
                productItemMeta.setLore(lore);
                productItemStack.setItemMeta(productItemMeta);
            }
            if (p.getInventory().contains(Material.STONE_SWORD)) {
                for (ItemStack slotStack : p.getInventory().getContents()) {
                    if (slotStack != null && slotStack.getType() == Material.STONE_SWORD) {
                        slotStack.setType(productItemStack.getType());
                        slotStack.setItemMeta(productItemMeta);
                        p.updateInventory();
                        p.sendMessage(ColorUtil.getMessage("&aВаш меч заменен на новый"));
                    }
                }
            } else {
                p.getInventory().addItem(productItemStack);
            }
        }
    }
}
