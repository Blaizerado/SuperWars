package de.ilovejava.events;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityExplodeEvent;

import de.ilovejava.craftapi.CraftTitleApi;
import de.ilovejava.mysql.MySQL_Function;
import de.ilovejava.superwars.SuperWars;

public class BlockBrak implements Listener {
	@EventHandler
	public void onBreak(BlockBreakEvent e) {
		if(SuperWars.Build_Block.contains(e.getBlock().getLocation())) {
			if(SuperWars.play) {
				SuperWars.Build_Block.remove(e.getBlock().getLocation());
			}else {if(!e.getPlayer().hasPermission("Super.Admin")) {e.setCancelled(true);}}
		}else {
			if(e.getBlock().getType().equals(Material.BED_BLOCK) || e.getBlock().getType().equals(Material.BED)) {
				if(isBlueBed(e.getBlock())) {
					if(!SuperWars.Team_Blue.contains(e.getPlayer())) {
						SuperWars.Bed_Blue = false;
						e.getPlayer().sendMessage(SuperWars.getPrefix() + "§6Du hast Das Bett von Team Blau abgebaut!");
						MySQL_Function.giveBeds(e.getPlayer().getUniqueId().toString(), 1);
						for(Player p : SuperWars.Team_Blue) {
							p.playSound(p.getLocation(), Sound.ENDERDRAGON_DEATH, 1, 1);
							CraftTitleApi.sendFullTitle(p, 40, 40, 40, "§e§lSuperWars§8", "§cDein Bett wurde abgebaut!");
						}
						int i = 0;
						for(Player p : SuperWars.Team_Blue) {
							if(p.isDead()) {
								i++;
							}
						}
						
						if(i >= 0) {
							SuperWars.Team_Blue.clear();
						}
					}else {e.setCancelled(true); e.getPlayer().sendMessage(SuperWars.getPrefix() + "Bitte bau nicht dein Bett ab!");}
				}else if(isRedBed(e.getBlock())) {
					if(!SuperWars.Team_Red.contains(e.getPlayer())) {
						SuperWars.Bed_Red = false;
						e.getPlayer().sendMessage(SuperWars.getPrefix() + "§6Du hast Das Bett von Team Rot abgebaut!");
						MySQL_Function.giveBeds(e.getPlayer().getUniqueId().toString(), 1);
						for(Player p : SuperWars.Team_Red) {
							p.playSound(p.getLocation(), Sound.ENDERDRAGON_DEATH, 1, 1);
							CraftTitleApi.sendFullTitle(p, 40, 40, 40, "§e§lSuperWars§8", "§cDein Bett wurde abgebaut!");
						}
						
						int i = 0;
						for(Player p : SuperWars.Team_Red) {
							if(p.isDead()) {
								i++;
							}
						}
						
						if(i >= 0) {
							SuperWars.Team_Red.clear();
						}
					}else {e.setCancelled(true); e.getPlayer().sendMessage(SuperWars.getPrefix() + "Bitte bau nicht dein Bett ab!");}
				}
			}else {if(!e.getPlayer().hasPermission("Super.Admin")) {e.setCancelled(true);}}
		}
	}
	
	@EventHandler
	public void onTNT(EntityExplodeEvent e) {
		if(e.getEntity().getType().equals(EntityType.PRIMED_TNT)) {
			e.blockList().clear();
		}
	}
	
	@EventHandler
	public void onPlace(BlockPlaceEvent e) {
		if(SuperWars.play) {
			SuperWars.Build_Block.add(e.getBlock().getLocation());
		}else {if(!e.getPlayer().hasPermission("Super.Admin")) {e.setCancelled(true);}}
	}
	
	public Boolean isBlueBed(Block b) {
		if(SuperWars.Bed_Blue_Location1.getBlock().getType().equals(Material.BED_BLOCK) || SuperWars.Bed_Blue_Location1.getBlock().getType().equals(Material.BED_BLOCK)) {
			Block target = SuperWars.Bed_Blue_Location1.getBlock();
			Block target1 = SuperWars.Bed_Blue_Location.getBlock();
			
			if(target.getLocation().getBlockX() == b.getLocation().getBlockX() && target.getLocation().getBlockY() == b.getLocation().getBlockY() &&
				target.getLocation().getBlockZ() == b.getLocation().getBlockZ()) {
				return true;
			}else if(target1.getLocation().getBlockX() == b.getLocation().getBlockX() && target1.getLocation().getBlockY() == b.getLocation().getBlockY() &&
					 target1.getLocation().getBlockZ() == b.getLocation().getBlockZ()) {
				return true;
			}
		}
		return false;
	}
	
	public Boolean isRedBed(Block b) {
		if(SuperWars.Bed_Red_Location1.getBlock().getType().equals(Material.BED_BLOCK) || SuperWars.Bed_Red_Location1.getBlock().getType().equals(Material.BED_BLOCK)) {
			Block target = SuperWars.Bed_Red_Location1.getBlock();
			Block target1 = SuperWars.Bed_Red_Location.getBlock();
			
			if(target.getLocation().getBlockX() == b.getLocation().getBlockX() && target.getLocation().getBlockY() == b.getLocation().getBlockY() &&
				target.getLocation().getBlockZ() == b.getLocation().getBlockZ()) {
				return true;
			}else if(target1.getLocation().getBlockX() == b.getLocation().getBlockX() && target1.getLocation().getBlockY() == b.getLocation().getBlockY() &&
					 target1.getLocation().getBlockZ() == b.getLocation().getBlockZ()) {
				return true;
			}
		}
		return false;
	}
}
