package de.ilovejava.shop;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Inventorys {
	public static void WeaponInv(Player p, Inventory inv) {
		inv.clear();
		ItemStack i = new ItemStack(Material.STICK);
		ItemMeta im = i.getItemMeta();
		im.addEnchant(Enchantment.KNOCKBACK, 4, true);
		i.setItemMeta(im);
		inv.setItem(9, i);
		
		i = new ItemStack(Material.WOOD_SWORD);
		im = i.getItemMeta();
		im.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
		i.setItemMeta(im);
		inv.setItem(10, i);
		
		im.addEnchant(Enchantment.DAMAGE_ALL, 2, true);
		im.addEnchant(Enchantment.KNOCKBACK, 2, true);
		i.setItemMeta(im);
		inv.setItem(11, i);
		
		i = new ItemStack(Material.NETHER_BRICK_ITEM,5);
		im = i.getItemMeta();
		im.setDisplayName("§a5-Brongze");
		i.setItemMeta(im);
		inv.setItem(18, i);
		
		i = new ItemStack(Material.NETHER_BRICK_ITEM,30);
		im = i.getItemMeta();
		im.setDisplayName("§e30-Brongze");
		i.setItemMeta(im);
		inv.setItem(19, i);
		
		i = new ItemStack(Material.NETHER_BRICK_ITEM, 64);
		im = i.getItemMeta();
		im.setDisplayName("§c64-Brongze");
		i.setItemMeta(im);
		inv.setItem(20, i);
		
		i = new ItemStack(Material.GOLD_SWORD);
		im = i.getItemMeta();
		im.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
		i.setItemMeta(im);
		inv.setItem(13, i);
		
		i = new ItemStack(Material.GOLD_AXE);
		im.addEnchant(Enchantment.KNOCKBACK, 1, true);
		im.addEnchant(Enchantment.FIRE_ASPECT, 2, true);
		i.setItemMeta(im);
		inv.setItem(12, i);
		
		i = new ItemStack(Material.INK_SACK,10,(short)4);
		im = i.getItemMeta();
		im.setDisplayName("§e10-Lapis");
		i.setItemMeta(im);
		inv.setItem(21, i);
		
		i = new ItemStack(Material.INK_SACK,30,(short)4);
		im = i.getItemMeta();
		im.setDisplayName("§c30-Lapis");
		i.setItemMeta(im);
		inv.setItem(22, i);
		
		i = new ItemStack(Material.IRON_SWORD);
		im = i.getItemMeta();
		im.addEnchant(Enchantment.DAMAGE_ALL, 2, true);
		im.addEnchant(Enchantment.KNOCKBACK, 2, true);
		i.setItemMeta(im);
		inv.setItem(14, i);
		
		im.addEnchant(Enchantment.DAMAGE_ALL, 3, true);
		im.addEnchant(Enchantment.KNOCKBACK, 2, true);
		im.addEnchant(Enchantment.FIRE_ASPECT, 1, true);
		i.setItemMeta(im);
		inv.setItem(15, i);
		
		i = new ItemStack(Material.PRISMARINE_SHARD,5);
		im =i.getItemMeta();
		im.setDisplayName("§a5-Prismarine");
		i.setItemMeta(im);
		inv.setItem(23, i);
		
		i = new ItemStack(Material.PRISMARINE_SHARD, 10);
		im = i.getItemMeta();
		im.setDisplayName("§e10-Prismarine");
		i.setItemMeta(im);
		inv.setItem(24, i);
		
		i = new ItemStack(Material.PRISMARINE_SHARD, 20);
		im = i.getItemMeta();
		im.setDisplayName("§e20-Prismarine");
		i.setItemMeta(im);
		inv.setItem(25, i);
		
		i = new ItemStack(Material.PRISMARINE_SHARD, 32);
		im = i.getItemMeta();
		im.setDisplayName("§c32-Prismarine");
		i.setItemMeta(im);
		inv.setItem(26, i);
		
		
		i = new ItemStack(Material.DIAMOND_SWORD);
		im = i.getItemMeta();
		im.addEnchant(Enchantment.DAMAGE_ALL, 2, true);
		i.setItemMeta(im);
		inv.setItem(16, i);
		
		i = new ItemStack(Material.DIAMOND_AXE);
		im = i.getItemMeta();
		im.addEnchant(Enchantment.KNOCKBACK, 3, true);
		im.addEnchant(Enchantment.FIRE_ASPECT, 3, true);
		i.setItemMeta(im);
		inv.setItem(17, i);
		
		p.updateInventory();
	}
	
	public static void FoodInv(Player p, Inventory inv) {
		inv.clear();
		
		ItemStack i = new ItemStack(Material.APPLE);
		inv.setItem(9, i);
		
		i = new ItemStack(Material.COOKED_BEEF);
		inv.setItem(11, i);
		
		i = new ItemStack(Material.CAKE);
		inv.setItem(13, i);
		
		i = new ItemStack(Material.MUSHROOM_SOUP);
		inv.setItem(15, i);
		
		i = new ItemStack(Material.GOLDEN_APPLE);
		inv.setItem(17, i);
		
		i = new ItemStack(Material.NETHER_BRICK_ITEM);
		ItemMeta im = i.getItemMeta();
		im.setDisplayName("§a1-Brongze");
		i.setItemMeta(im);
		inv.setItem(18, i);
		
		i.setAmount(6);
		im.setDisplayName("§e6-Brongze");
		i.setItemMeta(im);
		inv.setItem(20, i);
		
		i = new ItemStack(Material.INK_SACK,8,(short)4);
		im = i.getItemMeta();
		im.setDisplayName("§a8-Lapis");
		i.setItemMeta(im);
		inv.setItem(22, i);
		
		i.setAmount(12);
		im.setDisplayName("§e12-Brongze");
		i.setItemMeta(im);
		inv.setItem(24, i);
		
		i = new ItemStack(Material.PRISMARINE_SHARD,5);
		im = i.getItemMeta();
		im.setDisplayName("§a5-Prismarin");
		i.setItemMeta(im);
		inv.setItem(26, i);
		
		
		p.updateInventory();
	}
	
	public static void PickAxeInv(Player p, Inventory inv) {
		inv.clear();
		ItemStack i = new ItemStack(Material.WOOD_PICKAXE);
		ItemMeta im = i.getItemMeta();
		im.addEnchant(Enchantment.DIG_SPEED, 1, true);
		i.setItemMeta(im);
		inv.setItem(9, i);
		
		i = new ItemStack(Material.STONE_PICKAXE);
		im = i.getItemMeta();
		im.addEnchant(Enchantment.DIG_SPEED, 2, true);
		i.setItemMeta(im);
		inv.setItem(11, i);
		
		i = new ItemStack(Material.IRON_PICKAXE);
		im = i.getItemMeta();
		im.addEnchant(Enchantment.DIG_SPEED, 3, true);
		i.setItemMeta(im);
		inv.setItem(13, i);
		
		i = new ItemStack(Material.GOLD_PICKAXE);
		im = i.getItemMeta();
		im.addEnchant(Enchantment.DIG_SPEED, 4, true);
		i.setItemMeta(im);
		inv.setItem(15, i);
		
		i = new ItemStack(Material.DIAMOND_PICKAXE);
		im = i.getItemMeta();
		im.addEnchant(Enchantment.DIG_SPEED, 5, true);
		i.setItemMeta(im);
		inv.setItem(17, i);
		
		i = new ItemStack(Material.NETHER_BRICK_ITEM);
		im = i.getItemMeta();
		im.setDisplayName("§a10-Brongze");
		i.setAmount(10);
		i.setItemMeta(im);
		inv.setItem(18, i);
		
		im.setDisplayName("§e30-Brongze");
		i.setAmount(30);
		i.setItemMeta(im);
		inv.setItem(20, i);
		
		i = new ItemStack(Material.INK_SACK,10,(short)4);
		im = i.getItemMeta();
		im.setDisplayName("§a10-Lapis");
		i.setItemMeta(im);
		inv.setItem(22, i);
		
		im.setDisplayName("§e30-Lapis");
		i.setAmount(30);
		i.setItemMeta(im);
		inv.setItem(24, i);
		
		i = new ItemStack(Material.PRISMARINE_SHARD,16);
		im = i.getItemMeta();
		im.setDisplayName("§c16-Prismarin");
		i.setItemMeta(im);
		inv.setItem(26, i);
		
		p.updateInventory();
	}
	
	public static void ArmorInv(Player p, Inventory inv) {
		inv.clear();
		
		ItemStack i = new ItemStack(Material.LEATHER_BOOTS);
		inv.setItem(9, i);
		i = new ItemStack(Material.LEATHER_LEGGINGS);
		inv.setItem(10,i);
		i = new ItemStack(Material.LEATHER_CHESTPLATE);
		inv.setItem(11,i);
		i = new ItemStack(Material.LEATHER_HELMET);
		inv.setItem(12,i);
		
		i = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
		ItemMeta im = i.getItemMeta();
		im.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 1, true);
		im.addEnchant(Enchantment.PROTECTION_PROJECTILE, 1, true);
		i.setItemMeta(im);
		inv.setItem(13, i);
		
		im.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
		im.addEnchant(Enchantment.PROTECTION_FIRE, 2, true);
		i.setItemMeta(im);
		inv.setItem(14, i);
		
		i = new ItemStack(Material.IRON_CHESTPLATE);
		im = i.getItemMeta();
		im.addEnchant(Enchantment.PROTECTION_PROJECTILE, 3, true);
		im.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, true);
		i.setItemMeta(im);
		inv.setItem(15, i);
		
		im.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, true);
		im.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 3, true);
		im.addEnchant(Enchantment.PROTECTION_FIRE, 3, true);
		i.setItemMeta(im);
		inv.setItem(16, i);
		
		i = new ItemStack(Material.DIAMOND_CHESTPLATE);
		im = i.getItemMeta();
		im.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, true);
		im.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 3, true);
		im.addEnchant(Enchantment.PROTECTION_FIRE, 3, true);
		i.setItemMeta(im);
		inv.setItem(17, i);
		
		i = new ItemStack(Material.NETHER_BRICK_ITEM,2);
		im = i.getItemMeta();
		im.setDisplayName("§a2-Brongze");
		i.setItemMeta(im);
		inv.setItem(18, i);
		inv.setItem(19, i);
		inv.setItem(20, i);
		inv.setItem(21, i);
		
		i = new ItemStack(Material.INK_SACK,10,(short)4);
		im = i.getItemMeta();
		im.setDisplayName("§a10-Lapis");
		i.setItemMeta(im);
		inv.setItem(22, i);
		
		im.setDisplayName("§c20-Lapis");
		i.setAmount(20);
		i.setItemMeta(im);
		inv.setItem(23, i);
		
		i = new ItemStack(Material.PRISMARINE_SHARD,5);
		im = i.getItemMeta();
		im.setDisplayName("§a5-Prismarin");
		i.setItemMeta(im);
		inv.setItem(24, i);
		
		im.setDisplayName("§e10-Prismarin");
		i.setAmount(10);
		i.setItemMeta(im);
		inv.setItem(25, i);
		
		im.setDisplayName("§c26-Prismarin");
		i.setAmount(26);
		i.setItemMeta(im);
		inv.setItem(26, i);
		
		p.updateInventory();
	}
	
	public static void BlockInv(Player p, Inventory inv) {
		
		inv.clear();
		
		ItemStack i = new ItemStack(Material.STAINED_CLAY,15);
		ItemMeta im = i.getItemMeta();
		inv.setItem(9, i);
		i = new ItemStack(Material.BRICK,15);
		inv.setItem(10, i);
		i = new ItemStack(Material.SOUL_SAND,4);
		inv.setItem(11, i);
		i = new ItemStack(Material.GLOWSTONE,4);
		inv.setItem(12, i);
		i = new ItemStack(Material.WEB);
		inv.setItem(13, i);
		i = new ItemStack(Material.DIAMOND_BLOCK,4);
		inv.setItem(14, i);
		i = new ItemStack(Material.EMERALD_BLOCK);
		inv.setItem(15, i);
		i = new ItemStack(Material.GOLD_BLOCK);
		inv.setItem(16, i);
		i = new ItemStack(Material.OBSIDIAN);
		inv.setItem(17, i);
		
		i = new ItemStack(Material.NETHER_BRICK_ITEM);
		im = i.getItemMeta();
		im.setDisplayName("§a10-Brongze");
		i.setAmount(10);
		i.setItemMeta(im);
		inv.setItem(18, i);
		
		im.setDisplayName("§e20-Brongze");
		i.setAmount(20);
		i.setItemMeta(im);
		inv.setItem(19, i);
		
		im.setDisplayName("§c34-Brongze");
		i.setAmount(34);
		i.setItemMeta(im);
		inv.setItem(20, i);
		
		i = new ItemStack(Material.INK_SACK,6,(short)4);
		im = i.getItemMeta();
		im.setDisplayName("§a6-Lapis");
		i.setItemMeta(im);
		inv.setItem(21, i);
		
		im.setDisplayName("§e26-Lapis");
		i.setAmount(26);
		i.setItemMeta(im);
		inv.setItem(22, i);
		
		im.setDisplayName("§c34-Lapis");
		i.setAmount(34);
		i.setItemMeta(im);
		inv.setItem(23, i);
		
		i = new ItemStack(Material.PRISMARINE_SHARD);
		im = i.getItemMeta();
		im.setDisplayName("§a1-Prismarin");
		i.setItemMeta(im);
		inv.setItem(24, i);
		
		im.setDisplayName("§a10-Prismarin");
		i.setAmount(10);
		i.setItemMeta(im);
		inv.setItem(25, i);
		
		im.setDisplayName("§a30-Prismarin");
		i.setAmount(30);
		i.setItemMeta(im);
		inv.setItem(26, i);
		
		p.updateInventory();
	}
}
