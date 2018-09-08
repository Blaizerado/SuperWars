package de.ilovejava.events;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

import de.ilovejava.gamestate.Gamestate;
import de.ilovejava.superwars.SuperWars;

public class Respawn implements Listener {
	private SuperWars main;
	public Respawn(SuperWars main) {
		this.main = main;
	}
	@EventHandler
	public void onRespawn(PlayerRespawnEvent e) {
		if(main.getGamestate().equals(Gamestate.Ingame)) {
			if(SuperWars.Team_Blue.contains(e.getPlayer())) {
				if(SuperWars.Bed_Blue) {
					e.setRespawnLocation(SuperWars.tblue);
				}else {e.getPlayer().setGameMode(GameMode.SPECTATOR); SuperWars.Team_Blue.remove(e.getPlayer());}
			}else if(SuperWars.Team_Red.contains(e.getPlayer())) {
				if(SuperWars.Bed_Red) {
					e.setRespawnLocation(SuperWars.tred);
				}else {e.getPlayer().setGameMode(GameMode.SPECTATOR); SuperWars.Team_Red.remove(e.getPlayer());}
			}
		}else {
			e.setRespawnLocation(SuperWars.lobby);
		}
	}
	
	@EventHandler
	public void EntitySpawn(CreatureSpawnEvent e) {
		if(e.getSpawnReason().equals(SpawnReason.NATURAL)) {
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void onPVP(EntityDamageEvent e) {
		if(!SuperWars.getGamestate().equals(Gamestate.Ingame)) {
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void onPVPByEntity(EntityDamageByEntityEvent e) {
		if(e.getDamager() instanceof Player || e.getEntity() instanceof Player) {
			Player p = (Player) e.getEntity();
			Player t = (Player) e.getDamager();
			if(SuperWars.Team_Blue.contains(t)) {
				if(SuperWars.Team_Blue.contains(p)) {
					e.setCancelled(true);
				}
			}else if(SuperWars.Team_Red.contains(t)) {
				if(SuperWars.Team_Red.contains(p)) {
					e.setCancelled(true);
				}
			}
		}
	}
	
	@EventHandler
	public void foodchange(FoodLevelChangeEvent e) {
		if(!SuperWars.getGamestate().equals(Gamestate.Ingame)) {
			e.setCancelled(true);
		}
	}
}
