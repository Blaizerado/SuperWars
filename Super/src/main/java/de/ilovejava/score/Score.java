package de.ilovejava.score;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import de.ilovejava.gamestate.Gamestate;
import de.ilovejava.mysql.MySQL_Function;
import de.ilovejava.superwars.SuperWars;
import de.ilovejava.timer.TimerTask;
import net.md_5.bungee.api.ChatColor;

public class Score {
	public static HashMap<Scoreboard, Player>boards = new HashMap<>();
	
	public Score(Player p) {
		Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();
		Objective obj = board.registerNewObjective("aaa", "bbb");
		obj.setDisplaySlot(DisplaySlot.SIDEBAR);
		obj.setDisplayName("§e§lSuperWars");
		
		obj.getScore("  ").setScore(21);
		obj.getScore("§9§lServer").setScore(20);
		obj.getScore("§fSuperWars-1").setScore(19);
		obj.getScore("    ").setScore(18);
		obj.getScore("§9§lMap").setScore(17);
		obj.getScore("§fSuperMine").setScore(15);
		obj.getScore("       ").setScore(14);
		obj.getScore("§9§lSpiel").setScore(13);
		obj.getScore("§f1").setScore(12);
		obj.getScore("          ").setScore(11);
		
		boards.put(board, p);
		
		p.setScoreboard(board);
	}
	
	public static void setNewScore(Player p) {
		Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();
		Objective obj = board.registerNewObjective("fff", "ccc");
		obj.setDisplaySlot(DisplaySlot.SIDEBAR);
		obj.setDisplayName("§e§lSuperWars");
		
		Team red = board.registerNewTeam("Red");
		red.setPrefix("§cRot: ");
		red.setSuffix(getColor("RED"));
		red.addEntry(ChatColor.RED.toString());
		
		Team blue = board.registerNewTeam("Blue");
		blue.setPrefix("§9Blau: ");
		blue.setSuffix(getColor("BLUE"));
		blue.addEntry(ChatColor.BLUE.toString());
		
		Team Kills = board.registerNewTeam("kills");
		Kills.setPrefix("§9Kills: §f");
		Kills.setSuffix("§f"+MySQL_Function.getKills(p.getUniqueId().toString()));
		Kills.addEntry(ChatColor.DARK_BLUE.toString());
		
		Team Deaths = board.registerNewTeam("deaths");
		Deaths.setPrefix("§9Tode: §f");
		Deaths.setSuffix("§f"+MySQL_Function.getDeaths(p.getUniqueId().toString()));
		Deaths.addEntry(ChatColor.DARK_GRAY.toString());
		
		Team Beds = board.registerNewTeam("beds");
		Beds.setPrefix("§9BedBreakes: §f");
		Beds.setSuffix("§f"+MySQL_Function.getBedBreaks(p.getUniqueId().toString()));
		Beds.addEntry(ChatColor.BOLD.toString());
		
		obj.getScore(" ").setScore(20);
		obj.getScore(ChatColor.RED.toString()).setScore(19);;
		obj.getScore(ChatColor.BLUE.toString()).setScore(18);;
		obj.getScore("   ").setScore(17);
		obj.getScore("§9Server:").setScore(16);
		obj.getScore("§fSuperWars-1").setScore(15);
		obj.getScore("     ").setScore(14);
		obj.getScore(ChatColor.DARK_BLUE.toString()).setScore(13);
		obj.getScore("       ").setScore(11);
		obj.getScore(ChatColor.DARK_GRAY.toString()).setScore(10);
		obj.getScore("            ").setScore(9);
		obj.getScore(ChatColor.BOLD.toString()).setScore(7);
		obj.getScore("               ").setScore(6);
		
		boards.put(board, p);
		p.setScoreboard(board);
	}
	
	
	public static void stockUpdate() {
		new BukkitRunnable() {
			
			@Override
			public void run() {
				for(Scoreboard b : boards.keySet()) {
					Player p = boards.get(b);
					p.getScoreboard().getTeam("Red").setSuffix(getColor("RED"));
					p.getScoreboard().getTeam("Blue").setSuffix(getColor("BLUE"));
					p.getScoreboard().getTeam("kills").setSuffix("§f"+MySQL_Function.getKills(p.getUniqueId().toString()));
					p.getScoreboard().getTeam("deaths").setSuffix("§f"+MySQL_Function.getDeaths(p.getUniqueId().toString()));
					p.getScoreboard().getTeam("beds").setSuffix("§f"+MySQL_Function.getBedBreaks(p.getUniqueId().toString()));
				}
			}
		}.runTaskTimer(SuperWars.getInstance(), 0, 60*1);
	}
	
	public static String getColor(String Team) {
		String re = null;
		switch(Team) {
			case "RED":
				if(SuperWars.Bed_Red) {re = "§a✔";}else {re="§c✖";}
			break;
			case "BLUE":
				if(SuperWars.Bed_Blue) {re = "§a✔";}else {re="§c✖";}
				break;
		}
		
		return re;
	}
	
	public static void update() {
		new BukkitRunnable() {
			
			@Override
			public void run() {
				if(SuperWars.getGamestate().equals(Gamestate.Lobby)) {
					for(Scoreboard b : boards.keySet()) {
						Player p = boards.get(b);
						p.getScoreboard().getTeam("Time").setPrefix("§f"+TimerTask.getCoundDown());
					}
				}else if(SuperWars.getGamestate().equals(Gamestate.Ingame)) {
					boards.clear();
					for(Player p : Bukkit.getOnlinePlayers()) {
						setNewScore(p);
					}
					stockUpdate();
					this.cancel();
				}
			}
		}.runTaskTimer(SuperWars.getInstance(), 0, 20*1);
	}
}
