package de.ilovejava.shop;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import de.ilovejava.superwars.SuperWars;


public class Shop {
	public static void Weaponshop(Player p,ItemStack i) {
		if(i.getType().equals(Material.STICK)) {
			int ammount = getAmoutNether(p);
			if(ammount >= 5) {
				 ItemStack remove = new ItemStack(Material.NETHER_BRICK_ITEM);
				 remove.setAmount(5);
				 ItemStack item = new ItemStack(Material.STICK);
				 ItemMeta im = item.getItemMeta();
				 im.addEnchant(Enchantment.KNOCKBACK, 4, true);
				 item.setItemMeta(im);
				 p.getInventory().removeItem(remove);
				 p.getInventory().addItem(item);
				 p.updateInventory();
			}else {p.sendMessage(SuperWars.getPrefix() + "Du hast nicht genug Brongze dabei!");}		
		}else if(i.getType().equals(Material.WOOD_SWORD)) {
			if(i.getItemMeta().hasEnchants()) {
				  if(i.getItemMeta().hasEnchant(Enchantment.DAMAGE_ALL)) {
					  if(i.getItemMeta().hasEnchant(Enchantment.KNOCKBACK)) {
						  int amount = getAmoutNether(p);
						  if(amount >= 64) {
							 ItemStack remove = new ItemStack(Material.NETHER_BRICK_ITEM);
							 remove.setAmount(64);
							 ItemStack item = new ItemStack(Material.WOOD_SWORD);
							 ItemMeta im = item.getItemMeta();
							 im.addEnchant(Enchantment.DAMAGE_ALL, 2, true);
							 im.addEnchant(Enchantment.KNOCKBACK, 2, true);
							 item.setItemMeta(im);
							 p.getInventory().removeItem(remove);
							 p.getInventory().addItem(item);
							 p.updateInventory();
							 
						  }else {p.sendMessage(SuperWars.getPrefix() + "Du hast nicht genug Brongze dabei!");}
					  }else {
						  int amount = getAmoutNether(p);
						  if(amount >= 30) {
							     ItemStack remove = new ItemStack(Material.NETHER_BRICK_ITEM);
								 remove.setAmount(30);
								 ItemStack item = new ItemStack(Material.WOOD_SWORD);
								 ItemMeta im = item.getItemMeta();
								 im.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
								 item.setItemMeta(im);
								 p.getInventory().removeItem(remove);
								 p.getInventory().addItem(item);
								 p.updateInventory();
						  }
					  }
				  }
			  }else {
				  int amount = getAmoutNether(p);
				  if(amount >= 5) {
					     ItemStack remove = new ItemStack(Material.NETHER_BRICK_ITEM);
						 remove.setAmount(5);
						 ItemStack item = new ItemStack(Material.WOOD_SWORD);
						 p.getInventory().removeItem(remove);
						 p.getInventory().addItem(item);
						 p.updateInventory();
				  }else {p.sendMessage(SuperWars.getPrefix() + "Du hast nicht genug Brongze dabei!");}
			  }
		}else if(i.getType() == Material.GOLD_AXE) {
			int amount = getAmoutDye(p);
			if(amount >= 10) {
				     ItemStack remove = new ItemStack(Material.INK_SACK,10,(short)4);
					 ItemStack item = new ItemStack(Material.GOLD_AXE);
					 ItemMeta im = i.getItemMeta();
					 im.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
					 im.addEnchant(Enchantment.FIRE_ASPECT, 2, true);
					 im.addEnchant(Enchantment.KNOCKBACK, 1, true);
					 item.setItemMeta(im);
					 p.getInventory().removeItem(remove);
					 p.getInventory().addItem(item);
					 p.updateInventory();
			}else {p.sendMessage(SuperWars.getPrefix() + "Du hast nicht genug Lapis dabei!");}
		}else if(i.getType() == Material.GOLD_SWORD) {
			int amount = getAmoutDye(p);
			if(amount >= 30) {
				 ItemStack remove = new ItemStack(Material.INK_SACK,30,(short)4);
				 ItemStack item = new ItemStack(Material.GOLD_SWORD);
				 ItemMeta im = i.getItemMeta();
				 im.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
				 item.setItemMeta(im);
				 p.getInventory().removeItem(remove);
				 p.getInventory().addItem(item);
				 p.updateInventory();
			}else {p.sendMessage(SuperWars.getPrefix() + "Du hast nicht genug Lapis dabei!");}
		}else if(i.getType() == Material.IRON_SWORD) {
			if(i.getItemMeta().hasEnchants()) {
				if(i.getItemMeta().hasEnchant(Enchantment.FIRE_ASPECT)) {
					int amount = getAmoutPris(p);
					if(amount >= 10) {
						 ItemStack remove = new ItemStack(Material.PRISMARINE_SHARD,10);
						 ItemStack item = new ItemStack(Material.IRON_SWORD);
						 ItemMeta im = i.getItemMeta();
						 im.addEnchant(Enchantment.DAMAGE_ALL, 3, true);
						 im.addEnchant(Enchantment.KNOCKBACK, 2, true);
						 im.addEnchant(Enchantment.FIRE_ASPECT, 1, true);
						 item.setItemMeta(im);
						 p.getInventory().removeItem(remove);
						 p.getInventory().addItem(item);
						 p.updateInventory();
					}else {p.sendMessage(SuperWars.getPrefix() + "Du hast nicht genug Prismarin dabei!");}
				}else {
					int amount = getAmoutPris(p);
					if(amount >= 5) {
						 ItemStack remove = new ItemStack(Material.PRISMARINE_SHARD,5);
						 ItemStack item = new ItemStack(Material.IRON_SWORD);
						 ItemMeta im = i.getItemMeta();
						 im.addEnchant(Enchantment.DAMAGE_ALL, 2, true);
						 im.addEnchant(Enchantment.KNOCKBACK, 2, true);
						 item.setItemMeta(im);
						 p.getInventory().removeItem(remove);
						 p.getInventory().addItem(item);
						 p.updateInventory();
					}else {p.sendMessage(SuperWars.getPrefix() + "Du hast nicht genug Prismarin dabei!");}
				}
			}
		}else if(i.getType() == Material.DIAMOND_SWORD) {
			int amount = getAmoutPris(p);
			if(amount >= 20) {
				ItemStack remove = new ItemStack(Material.PRISMARINE_SHARD,20);
				 ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
				 ItemMeta im = i.getItemMeta();
				 im.addEnchant(Enchantment.DAMAGE_ALL, 2, true);
				 item.setItemMeta(im);
				 p.getInventory().removeItem(remove);
				 p.getInventory().addItem(item);
				 p.updateInventory();
			}else {p.sendMessage(SuperWars.getPrefix() + "Du hast nicht genug Prismarin dabei!");}
		}else if(i.getType() == Material.DIAMOND_AXE) {
			int amount = getAmoutPris(p);
			if(amount >= 32) {
				ItemStack remove = new ItemStack(Material.PRISMARINE_SHARD,32);
				 ItemStack item = new ItemStack(Material.DIAMOND_AXE);
				 ItemMeta im = i.getItemMeta();
				 im.addEnchant(Enchantment.FIRE_ASPECT, 3, true);
				 im.addEnchant(Enchantment.KNOCKBACK, 3, true);
				 item.setItemMeta(im);
				 p.getInventory().removeItem(remove);
				 p.getInventory().addItem(item);
				 p.updateInventory();
			}else {p.sendMessage(SuperWars.getPrefix() + "Du hast nicht genug Prismarin dabei!");}
		}else if(i.getType() == Material.STAINED_CLAY) {
			int amount = getAmoutNether(p);
			if(amount >= 10) {
				if(SuperWars.Team_Blue.contains(p)) {
					ItemStack remove = new ItemStack(Material.NETHER_BRICK_ITEM,10);
					ItemStack item = new ItemStack(Material.STAINED_CLAY,15,(short)11);
					p.getInventory().removeItem(remove);
					p.getInventory().addItem(item);
					p.updateInventory();
				}else if(SuperWars.Team_Red.contains(p)) {
					ItemStack remove = new ItemStack(Material.NETHER_BRICK_ITEM,10);
					ItemStack item = new ItemStack(Material.STAINED_CLAY,15,(short)14);
					p.getInventory().removeItem(remove);
					p.getInventory().addItem(item);
					p.updateInventory();
				}
			}else {p.sendMessage(SuperWars.getPrefix() + "Du hast nicht genug Brongze dabei!");}
		}else if(i.getType() == Material.BRICK) {
			int amount = getAmoutNether(p);
			if(amount >= 20) {
					ItemStack remove = new ItemStack(Material.NETHER_BRICK_ITEM,20);
					ItemStack item = new ItemStack(Material.BRICK,15);
					p.getInventory().removeItem(remove);
					p.getInventory().addItem(item);
					p.updateInventory();
				}else{p.sendMessage(SuperWars.getPrefix() + "Du hast nicht genug Brongze dabei!");}	
		}else if(i.getType() == Material.SOUL_SAND) {
			int amount = getAmoutNether(p);
			if(amount >= 34) {
					ItemStack remove = new ItemStack(Material.NETHER_BRICK_ITEM,34);
					ItemStack item = new ItemStack(Material.SOUL_SAND,4);
					p.getInventory().removeItem(remove);
					p.getInventory().addItem(item);
					p.updateInventory();
				}else{p.sendMessage(SuperWars.getPrefix() + "Du hast nicht genug Brongze dabei!");}	
		}else if(i.getType() == Material.GLOWSTONE) {
			int amount = getAmoutDye(p);
			if(amount >= 6) {
					ItemStack remove = new ItemStack(Material.INK_SACK,6,(short)4);
					ItemStack item = new ItemStack(Material.GLOWSTONE,4);
					p.getInventory().removeItem(remove);
					p.getInventory().addItem(item);
					p.updateInventory();
				}else{p.sendMessage(SuperWars.getPrefix() + "Du hast nicht genug Lapis dabei!");}	
		}else if(i.getType() == Material.WEB) {
			int amount = getAmoutDye(p);
			if(amount >= 26) {
					ItemStack remove = new ItemStack(Material.INK_SACK,26,(short)4);
					ItemStack item = new ItemStack(Material.WEB,1);
					p.getInventory().removeItem(remove);
					p.getInventory().addItem(item);
					p.updateInventory();
				}else{p.sendMessage(SuperWars.getPrefix() + "Du hast nicht genug Lapis dabei!");}	
		}else if(i.getType() == Material.DIAMOND_BLOCK) {
			int amount = getAmoutDye(p);
			if(amount >= 34) {
					ItemStack remove = new ItemStack(Material.INK_SACK,34,(short)4);
					ItemStack item = new ItemStack(Material.DIAMOND_BLOCK,4);
					p.getInventory().removeItem(remove);
					p.getInventory().addItem(item);
					p.updateInventory();
				}else{p.sendMessage(SuperWars.getPrefix() + "Du hast nicht genug Lapis dabei!");}
		}else if(i.getType() == Material.EMERALD_BLOCK) {
			int amount = getAmoutPris(p);
			if(amount >= 1) {
					ItemStack remove = new ItemStack(Material.PRISMARINE_SHARD,1);
					ItemStack item = new ItemStack(Material.EMERALD_BLOCK);
					p.getInventory().removeItem(remove);
					p.getInventory().addItem(item);
					p.updateInventory();
				}else{p.sendMessage(SuperWars.getPrefix() + "Du hast nicht genug Prismarin dabei!");}
		}else if(i.getType() == Material.GOLD_BLOCK) {
			int amount = getAmoutPris(p);
			if(amount >= 10) {
					ItemStack remove = new ItemStack(Material.PRISMARINE_SHARD,10);
					ItemStack item = new ItemStack(Material.GOLD_BLOCK);
					p.getInventory().removeItem(remove);
					p.getInventory().addItem(item);
					p.updateInventory();
				}else{p.sendMessage(SuperWars.getPrefix() + "Du hast nicht genug Prismarin dabei!");}
		}else if(i.getType() == Material.OBSIDIAN) {
			int amount = getAmoutPris(p);
			if(amount >= 30) {
					ItemStack remove = new ItemStack(Material.PRISMARINE_SHARD,30);
					ItemStack item = new ItemStack(Material.OBSIDIAN);
					p.getInventory().removeItem(remove);
					p.getInventory().addItem(item);
					p.updateInventory();
				}else{p.sendMessage(SuperWars.getPrefix() + "Du hast nicht genug Prismarin dabei!");}
		}else if(i.getType() == Material.WOOD_PICKAXE) {
			int amount = getAmoutNether(p);
			if(amount >= 10) {
					ItemStack remove = new ItemStack(Material.NETHER_BRICK_ITEM,10);
					ItemStack item = new ItemStack(Material.WOOD_PICKAXE);
					ItemMeta im = item.getItemMeta();
					im.addEnchant(Enchantment.DIG_SPEED, 1, true);
					item.setItemMeta(im);
					p.getInventory().removeItem(remove);
					p.getInventory().addItem(item);
					p.updateInventory();
				}else{p.sendMessage(SuperWars.getPrefix() + "Du hast nicht genug Brongze dabei!");}
		}else if(i.getType() == Material.STONE_PICKAXE) {
			int amount = getAmoutNether(p);
			if(amount >= 30) {
					ItemStack remove = new ItemStack(Material.NETHER_BRICK_ITEM,30);
					ItemStack item = new ItemStack(Material.STONE_PICKAXE);
					ItemMeta im = item.getItemMeta();
					im.addEnchant(Enchantment.DIG_SPEED, 2, true);
					item.setItemMeta(im);
					p.getInventory().removeItem(remove);
					p.getInventory().addItem(item);
					p.updateInventory();
				}else{p.sendMessage(SuperWars.getPrefix() + "Du hast nicht genug Brongze dabei!");}
		}else if(i.getType() == Material.IRON_PICKAXE) {
			int amount = getAmoutDye(p);
			if(amount >= 10) {
					ItemStack remove = new ItemStack(Material.INK_SACK,10,(short)4);
					ItemStack item = new ItemStack(Material.IRON_PICKAXE);
					ItemMeta im = item.getItemMeta();
					im.addEnchant(Enchantment.DIG_SPEED, 3, true);
					item.setItemMeta(im);
					p.getInventory().removeItem(remove);
					p.getInventory().addItem(item);
					p.updateInventory();
				}else{p.sendMessage(SuperWars.getPrefix() + "Du hast nicht genug Lapis dabei!");}
		}else if(i.getType() == Material.GOLD_PICKAXE) {
			int amount = getAmoutDye(p);
			if(amount >= 30) {
					ItemStack remove = new ItemStack(Material.INK_SACK,30,(short)4);
					ItemStack item = new ItemStack(Material.GOLD_PICKAXE);
					ItemMeta im = item.getItemMeta();
					im.addEnchant(Enchantment.DIG_SPEED, 4, true);
					item.setItemMeta(im);
					p.getInventory().removeItem(remove);
					p.getInventory().addItem(item);
					p.updateInventory();
				}else{p.sendMessage(SuperWars.getPrefix() + "Du hast nicht genug Lapis dabei!");}
		}else if(i.getType() == Material.DIAMOND_PICKAXE) {
			int amount = getAmoutPris(p);
			if(amount >= 16) {
					ItemStack remove = new ItemStack(Material.PRISMARINE_SHARD,16);
					ItemStack item = new ItemStack(Material.DIAMOND_PICKAXE);
					ItemMeta im = item.getItemMeta();
					im.addEnchant(Enchantment.DIG_SPEED, 5, true);
					item.setItemMeta(im);
					p.getInventory().removeItem(remove);
					p.getInventory().addItem(item);
					p.updateInventory();
				}else{p.sendMessage(SuperWars.getPrefix() + "Du hast nicht genug Prismarin dabei!");}
		}else if(i.getType() == Material.LEATHER_BOOTS) {
			int amount = getAmoutNether(p);
			if(amount >= 2) {
				ItemStack remove = new ItemStack(Material.NETHER_BRICK_ITEM,2);
				ItemStack item = new ItemStack(Material.LEATHER_BOOTS);
				ItemMeta im = item.getItemMeta();
				item.setItemMeta(im);
				p.getInventory().removeItem(remove);
				p.getInventory().addItem(item);
				p.updateInventory();
			}else{p.sendMessage(SuperWars.getPrefix() + "Du hast nicht genug Brongze dabei!");}
		}else if(i.getType() == Material.LEATHER_LEGGINGS) {
			int amount = getAmoutNether(p);
			if(amount >= 2) {
				ItemStack remove = new ItemStack(Material.NETHER_BRICK_ITEM,2);
				ItemStack item = new ItemStack(Material.LEATHER_LEGGINGS);
				ItemMeta im = item.getItemMeta();
				item.setItemMeta(im);
				p.getInventory().removeItem(remove);
				p.getInventory().addItem(item);
				p.updateInventory();
			}else{p.sendMessage(SuperWars.getPrefix() + "Du hast nicht genug Brongze dabei!");}
		}else if(i.getType() == Material.LEATHER_CHESTPLATE) {
			int amount = getAmoutNether(p);
			if(amount >= 2) {
				ItemStack remove = new ItemStack(Material.NETHER_BRICK_ITEM,2);
				ItemStack item = new ItemStack(Material.LEATHER_CHESTPLATE);
				ItemMeta im = item.getItemMeta();
				item.setItemMeta(im);
				p.getInventory().removeItem(remove);
				p.getInventory().addItem(item);
				p.updateInventory();
			}else{p.sendMessage(SuperWars.getPrefix() + "Du hast nicht genug Brongze dabei!");}
		}else if(i.getType() == Material.LEATHER_HELMET) {
			int amount = getAmoutNether(p);
			if(amount >= 2) {
				ItemStack remove = new ItemStack(Material.NETHER_BRICK_ITEM,2);
				ItemStack item = new ItemStack(Material.LEATHER_HELMET);
				ItemMeta im = item.getItemMeta();
				item.setItemMeta(im);
				p.getInventory().removeItem(remove);
				p.getInventory().addItem(item);
				p.updateInventory();
			}else{p.sendMessage(SuperWars.getPrefix() + "Du hast nicht genug Brongze dabei!");}
		}else if(i.getType() == Material.CHAINMAIL_CHESTPLATE) {
			
			if(i.getItemMeta().hasEnchant(Enchantment.PROTECTION_FIRE)) {
				int amount = getAmoutDye(p);
				if(amount >= 20) {
					ItemStack remove = new ItemStack(Material.INK_SACK,20,(short)4);
					ItemStack item = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
					ItemMeta im = item.getItemMeta();
					im.addEnchant(Enchantment.PROTECTION_PROJECTILE, 1, true);
					im.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 1, true);
					im.addEnchant(Enchantment.PROTECTION_FIRE, 2, true);
					im.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
					item.setItemMeta(im);
					p.getInventory().removeItem(remove);
					p.getInventory().addItem(item);
					p.updateInventory();
			 }else{p.sendMessage(SuperWars.getPrefix() + "Du hast nicht genug Lapis dabei!");}
			}else {
				int amount = getAmoutDye(p);
				if(amount >= 10) {
					ItemStack remove = new ItemStack(Material.INK_SACK,10,(short)4);
					ItemStack item = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
					ItemMeta im = item.getItemMeta();
					im.addEnchant(Enchantment.PROTECTION_PROJECTILE, 1, true);
					im.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 1, true);
					item.setItemMeta(im);
					p.getInventory().removeItem(remove);
					p.getInventory().addItem(item);
					p.updateInventory();
				}else{p.sendMessage(SuperWars.getPrefix() + "Du hast nicht genug Lapis dabei!");}
			}
		}else  if(i.getType() == Material.IRON_CHESTPLATE) {
			if(i.getItemMeta().hasEnchant(Enchantment.PROTECTION_FIRE)) {
				int amount = getAmoutPris(p);
				if(amount >= 10) {
					ItemStack remove = new ItemStack(Material.PRISMARINE,5);
					ItemStack item = new ItemStack(Material.IRON_CHESTPLATE);
					ItemMeta im = item.getItemMeta();
					im.addEnchant(Enchantment.PROTECTION_PROJECTILE, 3, true);
					im.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, true);
					im.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 3, true);
					im.addEnchant(Enchantment.PROTECTION_FIRE, 3, true);
					item.setItemMeta(im);
					p.getInventory().removeItem(remove);
					p.getInventory().addItem(item);
					p.updateInventory();
				}else{p.sendMessage(SuperWars.getPrefix() + "Du hast nicht genug Prismarin dabei!");}
			}else {
				int amount = getAmoutPris(p);
				if(amount >= 5) {
					ItemStack remove = new ItemStack(Material.PRISMARINE,10);
					ItemStack item = new ItemStack(Material.IRON_CHESTPLATE);
					ItemMeta im = item.getItemMeta();
					im.addEnchant(Enchantment.PROTECTION_PROJECTILE, 3, true);
					im.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 3, true);
					item.setItemMeta(im);
					p.getInventory().removeItem(remove);
					p.getInventory().addItem(item);
					p.updateInventory();
				}else{p.sendMessage(SuperWars.getPrefix() + "Du hast nicht genug Prismarin dabei!");}
			}
		}else if(i.getType() == Material.DIAMOND_CHESTPLATE) {
			int amount = getAmoutPris(p);
			if(amount >= 26) {
				ItemStack remove = new ItemStack(Material.PRISMARINE,26);
				ItemStack item = new ItemStack(Material.DIAMOND_CHESTPLATE);
				ItemMeta im = item.getItemMeta();
				im.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 3, true);
				im.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 3, true);
				im.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, true);
				item.setItemMeta(im);
				p.getInventory().removeItem(remove);
				p.getInventory().addItem(item);
				p.updateInventory();
			}else{p.sendMessage(SuperWars.getPrefix() + "Du hast nicht genug Prismarin dabei!");}
		}else if(i.getType() == Material.APPLE) {
			int amount = getAmoutNether(p);
			if(amount >= 1) {
				ItemStack remove = new ItemStack(Material.NETHER_BRICK_ITEM,1);
				ItemStack item = new ItemStack(Material.APPLE);
				p.getInventory().removeItem(remove);
				p.getInventory().addItem(item);
				p.updateInventory();
			}else{p.sendMessage(SuperWars.getPrefix() + "Du hast nicht genug Brongze dabei!");}
		}else if(i.getType() == Material.COOKED_BEEF) {
			int amount = getAmoutNether(p);
			if(amount >= 6) {
				ItemStack remove = new ItemStack(Material.NETHER_BRICK_ITEM,6);
				ItemStack item = new ItemStack(Material.COOKED_BEEF);
				p.getInventory().removeItem(remove);
				p.getInventory().addItem(item);
				p.updateInventory();
			}else{p.sendMessage(SuperWars.getPrefix() + "Du hast nicht genug Brongze dabei!");}
		}else if(i.getType() == Material.CAKE) {
			int amount = getAmoutDye(p);
			if(amount >= 8) {
				ItemStack remove = new ItemStack(Material.INK_SACK,8,(short)4);
				ItemStack item = new ItemStack(Material.CAKE);
				p.getInventory().removeItem(remove);
				p.getInventory().addItem(item);
				p.updateInventory();
			}else{p.sendMessage(SuperWars.getPrefix() + "Du hast nicht genug Lapis dabei!");}
		}else if(i.getType() == Material.MUSHROOM_SOUP) {
			int amount = getAmoutDye(p);
			if(amount >= 12) {
				ItemStack remove = new ItemStack(Material.INK_SACK,12,(short)4);
				ItemStack item = new ItemStack(Material.MUSHROOM_SOUP);
				p.getInventory().removeItem(remove);
				p.getInventory().addItem(item);
				p.updateInventory();
			}else{p.sendMessage(SuperWars.getPrefix() + "Du hast nicht genug Lapis dabei!");}
		}else if(i.getType() == Material.GOLDEN_APPLE) {
			int amount = getAmoutPris(p);
			if(amount >= 5) {
				ItemStack remove = new ItemStack(Material.PRISMARINE_SHARD);
				ItemStack item = new ItemStack(Material.GOLDEN_APPLE);
				p.getInventory().removeItem(remove);
				p.getInventory().addItem(item);
				p.updateInventory();
			}else{p.sendMessage(SuperWars.getPrefix() + "Du hast nicht genug Lapis dabei!");}
		}
	}
	
	public static Integer getAmoutNether(Player p) {
		Integer amount = 0;
		  for(ItemStack it : p.getInventory().getContents()) {
			  if(it == null) {continue;}
			  if(it.getType() == Material.NETHER_BRICK_ITEM) {
				  amount += it.getAmount();
			  }
		  }
		  return amount;
	}
	
	public static Integer getAmoutDye(Player p) {
		Integer amount = 0;
		  for(ItemStack it : p.getInventory().getContents()) {
			  if(it == null) {continue;}
			  if(it.getType() == Material.INK_SACK) {
				  amount += it.getAmount();
			  }
		  }
		  return amount;
	}
	
	public static Integer getAmoutPris(Player p) {
		Integer amount = 0;
		  for(ItemStack it : p.getInventory().getContents()) {
			  if(it == null) {continue;}
			  if(it.getType() == Material.PRISMARINE_SHARD) {
				  amount += it.getAmount();
			  }
		  }
		  return amount;
	}
}
