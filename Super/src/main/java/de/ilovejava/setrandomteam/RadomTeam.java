package de.ilovejava.setrandomteam;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import de.ilovejava.superwars.SuperWars;

public class RadomTeam {
	public RadomTeam() {
		System.out.println("Radom");
		for(Player p : Bukkit.getOnlinePlayers()) {
			if(!SuperWars.Team_Blue.contains(p) && !SuperWars.Team_Red.contains(p)) {
				if(SuperWars.Team_Blue.size() > SuperWars.Team_Red.size() || SuperWars.Team_Blue.size() == SuperWars.Team_Red.size()) {
					SuperWars.Team_Red.add(p);
					p.setPlayerListName("§c"+p.getName());
					p.setPlayerListName("§c"+p.getName());
					}else {
						SuperWars.Team_Blue.add(p);
						p.setPlayerListName("§9"+p.getName());
						p.setPlayerListName("§9"+p.getName());
				}
			}
		}
	}
}
