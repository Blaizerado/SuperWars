package de.ilovejava.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.PlayerDeathEvent;

import de.ilovejava.gamestate.Gamestate;
import de.ilovejava.mysql.MySQL_Function;
import de.ilovejava.superwars.SuperWars;

public class Death implements Listener {

	private SuperWars main;

	public Death(SuperWars superWars) {
		this.main = superWars;
	}

	@EventHandler
	public void onDeath(PlayerDeathEvent e) {
		if(main.getGamestate().equals(Gamestate.Ingame)) {
			if(e.getEntity() instanceof Player) {
				Player p = e.getEntity();
				MySQL_Function.giveDeaths(p.getUniqueId().toString(), 1);
				if(e.getEntity().getLastDamageCause().getCause().equals(DamageCause.ENTITY_ATTACK)) {
					if(p.getKiller() instanceof Player) {
						MySQL_Function.giveKills(p.getKiller().getUniqueId().toString(), 1);
						e.setDeathMessage(SuperWars.getPrefix() + "§eSpieler §6" + p.getDisplayName() + "§e wurde von §6" + p.getKiller().getDisplayName() + "§e getötet!");
					}
				}else if(e.getEntity().getLastDamageCause().getCause().equals(DamageCause.FALL)) {
					e.setDeathMessage(SuperWars.getPrefix() + "§eDer Spieler §6" + p.getDisplayName() + "§e wollte fliegen!");
				}else if(e.getEntity().getLastDamageCause().getCause().equals(DamageCause.BLOCK_EXPLOSION)) {
					e.setDeathMessage(SuperWars.getPrefix() + "§eDer Spieler §6" + p.getDisplayName() + "§e spielte mit TNT!");
				}else if(e.getEntity().getLastDamageCause().getCause().equals(DamageCause.DROWNING)) {
					e.setDeathMessage(SuperWars.getPrefix() + "§eDer Spieler §6" + p.getDisplayName() + "§e konnte nicht schwimmen!");
				}else if(e.getEntity().getLastDamageCause().getCause().equals(DamageCause.FIRE)) {
					e.setDeathMessage(SuperWars.getPrefix() + "§eDer Spieler §6" + p.getDisplayName() + "§e hat keinen Feuerlöscher gefunden!");
				}else if(e.getEntity().getLastDamageCause().getCause().equals(DamageCause.LIGHTNING)) {
					e.setDeathMessage(SuperWars.getPrefix() + "§eDer Spieler §6" + p.getDisplayName() + "§e dachte es wäre gut bein einen Unwetter raus zu gehen!");
				}else {
					e.setDeathMessage(SuperWars.getPrefix() + "§eDer Spieler §6" + p.getDisplayName() + "§e will nicht sagen wie er gestorben ist immer diese Toten!");
				}
				if(SuperWars.Team_Blue.contains(p)) {
					if(!SuperWars.Bed_Blue) {
						SuperWars.Team_Blue.remove(p);
					}
				}else if(SuperWars.Team_Red.contains(p)) {
					if(!SuperWars.Bed_Red) {
						SuperWars.Team_Red.remove(p);
					}
				}
			}
		}
	}
}
