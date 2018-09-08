package de.ilovejava.radom;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import de.ilovejava.action.ActionBar;
import de.ilovejava.gamestate.Gamestate;
import de.ilovejava.superwars.SuperWars;

public class RandomEvents {
	static Integer tickSeconds = 60;
	
	public static void startEvents() {
		new BukkitRunnable() {
			
			@Override
			public void run() {
				if(SuperWars.getGamestate().equals(Gamestate.Ingame)) {
					for(Player p : Bukkit.getOnlinePlayers()) {
						if(tickSeconds >= 60) {
							ActionBar.sendActionBarTime(p, "§6 Nächster Event Start in: §c" + TimeUnit.SECONDS.toMinutes(tickSeconds) + " Minuten!", 1);
						}else {
							ActionBar.sendActionBarTime(p, "§6 Nächster Event Start in: §c" + tickSeconds + " Sekunden!", 1);
						}
					}
					if(tickSeconds == 0) {
						selectEvent();
						tickSeconds = 300;
					}
					tickSeconds--;
				}
			}
		}.runTaskTimer(SuperWars.getInstance(), 0, 20*1);
	}
	
	private static void selectEvent() {
		Random rn = new Random();
		System.out.println(rn.nextInt(4));
		switch(rn.nextInt(4)) {
			case 0:
				IceEvent();
				break;
			case 1:
				TNTEvent();
				break;
			case 2:
				BlitzEvent();
				break;
			case 3:
				AnvilEvent();
				break;
		}
	}
	
	private static void IceEvent() {
		System.out.println("Ice");
		for(Location loc : SuperWars.Build_Block) {
			Block b = loc.getBlock();
			b.setType(Material.PACKED_ICE);
		}
	}
	
	private static void BlitzEvent() {
		System.out.println("Blitz");
		for(Player p : Bukkit.getOnlinePlayers()) {
			p.getWorld().strikeLightning(p.getLocation());
		}
	}
	
	private static void TNTEvent() {
		System.out.println("TNT");
		for(Player p : Bukkit.getOnlinePlayers()) {
			p.getWorld().spawnEntity(p.getLocation(), EntityType.PRIMED_TNT);
		}
	}
	
	private static void AnvilEvent() {
		System.out.println("Anvil");
		for(Player p : Bukkit.getOnlinePlayers()) {
			FallingBlock block = p.getWorld().spawnFallingBlock(p.getLocation().clone().add(0, 5, 0), Material.ANVIL, (byte)0);
			block.setHurtEntities(true);
			new BukkitRunnable() {
				
				@Override
				public void run() {
					block.remove();
				}
			}.runTaskTimer(SuperWars.getInstance(), 1, 20*4);
		}
	}
}
