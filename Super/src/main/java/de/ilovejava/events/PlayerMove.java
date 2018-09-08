package de.ilovejava.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import de.ilovejava.distance.Check;
import de.ilovejava.gamestate.Gamestate;
import de.ilovejava.superwars.SuperWars;

public class PlayerMove implements Listener {
	private SuperWars main;
	public PlayerMove(SuperWars main) {
		this.main = main;
	}
	@EventHandler
	public void onMove(PlayerMoveEvent e) {
		if(main.getGamestate().equals(Gamestate.Ingame)) {
			if(!Check.isInArea(e.getPlayer())) {
				e.getPlayer().damage(500.0);
			}else if(Check.isToHigh(e.getPlayer())) {
				e.getPlayer().damage(500.0);
			}
		}
	}
}
