package de.ilovejava.events;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import de.ilovejava.superwars.SuperWars;
import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.npc.NPC;

public class NPCClick implements Listener {
	@EventHandler
	public void Click(PlayerInteractEntityEvent e) {
		if(e.getPlayer() == null) return;
		if(e.getRightClicked() == null) return;
		if(!e.getRightClicked().hasMetadata("NPC")) return;
		NPC npc = CitizensAPI.getNPCRegistry().getNPC(e.getRightClicked());
		if(SuperWars.Team_Point.containsKey(npc)) {
			if(SuperWars.Team_Blue.contains(e.getPlayer()) || SuperWars.Team_Red.contains(e.getPlayer())) {
				e.setCancelled(true); 
				e.getPlayer().sendMessage(SuperWars.getPrefix() + "Du bist bereits in einen Team!");
				return;
			}
			if(npc.getName().equalsIgnoreCase("§cRot")) {
				if(SuperWars.Team_Red.contains(e.getPlayer()) || SuperWars.Team_Blue.contains(e.getPlayer())) {
					e.setCancelled(true); 
					e.getPlayer().sendMessage(SuperWars.getPrefix() + "Du bist bereits in einen Team!");
					return;
				}
				if(SuperWars.Team_Red.size() <= 4) {
					SuperWars.Team_Red.add(e.getPlayer());
					if(SuperWars.Team_Red.size() > SuperWars.Team_Blue.size()) {
						e.getPlayer().sendMessage("§cAchtung, dieses Team ist zu volle bitte geh in ein anderes Team!");
						return;
					}
					e.getPlayer().setDisplayName("§c"+e.getPlayer().getName());
					e.getPlayer().setPlayerListName("§c"+e.getPlayer().getName());
					for(Player p : SuperWars.Team_Red){
						p.sendMessage(SuperWars.getPrefix() + "Der Spieler " + e.getPlayer().getName() + " ist dem Team Rot beigetreten!");
					}
					for(Location loc : SuperWars.Team_Red_NPC) {
						if(!SuperWars.Summom_Location.containsKey(loc)) {
							SuperWars.Summom_Location.put(loc, true);
							SuperWars.Team_Point.put(npc, "RED");
							NPC spawn = SuperWars.npc.createNPC(EntityType.PLAYER, "§c"+e.getPlayer().getName());
							spawn.spawn(SuperWars.NPC_Spawn);
							spawn.getNavigator().setTarget(loc);
							break;
						}else {continue;}
					}
					
				}else {e.setCancelled(true); e.getPlayer().sendMessage(SuperWars.getPrefix() + "§cAchtung, das Team ist leider voll!");}
			}else if(npc.getName().equalsIgnoreCase("§9Blau")){
				if(SuperWars.Team_Blue.contains(e.getPlayer()) || SuperWars.Team_Red.contains(e.getPlayer())) {
					e.setCancelled(true); 
					e.getPlayer().sendMessage(SuperWars.getPrefix() + "Du bist bereits in einen Team!");
					return;
				}
				if(SuperWars.Team_Blue.size() <= 4) {
					if(SuperWars.Team_Blue.size() > SuperWars.Team_Red.size()) {
						e.getPlayer().sendMessage("§cAchtung, dieses Team ist zu volle bitte geh in ein anderes Team!");
						return;
					}
					SuperWars.Team_Blue.add(e.getPlayer());
					e.getPlayer().setDisplayName("§9"+e.getPlayer().getName());
					e.getPlayer().setPlayerListName("§9"+e.getPlayer().getName());
					for(Player p : SuperWars.Team_Blue){
						p.sendMessage(SuperWars.getPrefix() + "Der Spieler " + e.getPlayer().getName() + " ist dem Team Blau beigetreten!");
					}
					
					for(Location loc : SuperWars.Team_Blue_NPC) {
						if(!SuperWars.Summom_Location.containsKey(loc)) {
							SuperWars.Summom_Location.put(loc, true);
							SuperWars.Team_Point.put(npc, "BLUE");
							NPC spawn = SuperWars.npc.createNPC(EntityType.PLAYER, "§9"+e.getPlayer().getName());
							spawn.spawn(SuperWars.NPC_Spawn);
							spawn.getNavigator().setTarget(loc);
							break;
						}else {continue;}
					}
				}else {e.setCancelled(true); e.getPlayer().sendMessage(SuperWars.getPrefix() + "§cAchtung, das Team ist leider voll!");}
			}
		}else if(npc.getName().equalsIgnoreCase("§6Shop")) {
			e.getPlayer().openInventory(getShop());
		}
	}
	
	public Inventory getShop() {
		Inventory inv = Bukkit.createInventory(null, 27, "§6Shop");
		ItemStack i = new ItemStack(Material.DIAMOND_PICKAXE);
		ItemMeta im = (ItemMeta) i.getItemMeta();
		im.setDisplayName("§e§lPickaxe");
		im.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		i.setItemMeta(im);
		inv.setItem(2, i);
		
		i = new ItemStack(Material.DIAMOND_SWORD);
		im = i.getItemMeta();
		im.setDisplayName("§c§lWaffen");
		im.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		i.setItemMeta(im);
		inv.setItem(4, i);
		
		i = new ItemStack(Material.DIAMOND_CHESTPLATE);
		im = i.getItemMeta();
		im.setDisplayName("§6§lRüstungen");
		im.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		i.setItemMeta(im);
		inv.setItem(6, i);
		
		i = new ItemStack(Material.STAINED_CLAY,1,(short)5);
		im = i.getItemMeta();
		im.setDisplayName("§d§lBlöcke");
		im.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		i.setItemMeta(im);
		inv.setItem(9, i);
		
		i = new ItemStack(Material.GOLDEN_APPLE);
		im = i.getItemMeta();
		im.setDisplayName("§3§lEssen");
		im.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		i.setItemMeta(im);
		inv.setItem(17, i);
		
		i = new ItemStack(Material.POTION);
		im = i.getItemMeta();
		im.setDisplayName("§9§lTränke");
		im.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		i.setItemMeta(im);
		//inv.setItem(20, i);
		
		i = new ItemStack(Material.TNT);
		im = i.getItemMeta();
		im.setDisplayName("§5§lC4");
		im.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		i.setItemMeta(im);
		//inv.setItem(22, i);
		
		i = new ItemStack(Material.ENDER_PEARL);
		im = i.getItemMeta();
		im.setDisplayName("§c§lWurfwaffen");
		im.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		i.setItemMeta(im);
		//inv.setItem(24, i);
		return inv;
	}
	
}
