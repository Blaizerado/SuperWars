package de.ilovejava.distance;

import org.bukkit.entity.Player;

import de.ilovejava.superwars.SuperWars;

public class Check {
	public static Boolean isInArea(Player p) {
		if(p.getLocation().distance(SuperWars.Middle) > 200) {
			return false;
		}
		return true;
	}
	
	public static Boolean isToHigh(Player p) {
		if(p.getLocation().getY() >= 80) {
			return false;
		}
		return false;
	}
}
