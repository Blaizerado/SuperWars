package de.ilovejava.events;


import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerLoginEvent.Result;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.Scoreboard;
import de.ilovejava.mysql.MySQL_Function;
import de.ilovejava.score.Score;
import de.ilovejava.superwars.SuperWars;
import net.citizensnpcs.api.npc.NPC;


public class AscLoginEvent implements Listener {

	@EventHandler
	public void Login(PlayerLoginEvent e) {
		if(!MySQL_Function.playerExist(e.getPlayer().getUniqueId().toString())) {
			MySQL_Function.createPlayer(e.getPlayer().getUniqueId().toString());
		}
		if(Bukkit.getOnlinePlayers().size() >= 8) {
			if(e.getPlayer().hasPermission("Super.ignore")) {
			}else {e.disallow(Result.KICK_FULL, "§cDer Server ist voll!");}
		}else {
			
		}
	}
	
	@EventHandler
	public void Join(PlayerJoinEvent e) {
		e.setJoinMessage(null);
		NPC n = SuperWars.npc.createNPC(EntityType.PLAYER, e.getPlayer().getName());
		n.spawn(new Location(Bukkit.getWorld("World"), 100, 100, 100));
		
		new Score(e.getPlayer());
		
		if(Bukkit.getOnlinePlayers().size() <= 8) {
			e.getPlayer().getInventory().clear();
			for(Player p : Bukkit.getOnlinePlayers()) {
				p.sendMessage(SuperWars.getPrefix() + e.getPlayer().getName() + " hat den Server betreten!");
			}
		}
		
		
		if(SuperWars.lobby != null) {
			new BukkitRunnable() {
				@Override
				public void run() {
					e.getPlayer().teleport(SuperWars.lobby);
				}
			}.runTaskLater(SuperWars.getInstance(), 2l);
		}
		n.destroy();
	}
	
	@EventHandler
	public void onQuit(PlayerQuitEvent e) {
		e.setQuitMessage(null);
		for(Scoreboard b : Score.boards.keySet()) {
			if(Score.boards.get(b) == e.getPlayer()) {
				Score.boards.remove(b);
			}
		}
		if(SuperWars.Team_Blue.contains(e.getPlayer())) {
			SuperWars.Team_Blue.remove(e.getPlayer());
		}else if(SuperWars.Team_Red.contains(e.getPlayer())) {
			SuperWars.Team_Red.remove(e.getPlayer());
		}
	}
}
