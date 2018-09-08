package de.ilovejava.timer;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import de.ilovejava.action.ActionBar;
import de.ilovejava.craftapi.CraftTitleApi;
import de.ilovejava.gamestate.Gamestate;
import de.ilovejava.setrandomteam.RadomTeam;
import de.ilovejava.superwars.SuperWars;
import net.citizensnpcs.api.npc.NPC;

public class TimerTask {
	public static Integer CountDown = 60;
	Integer tick;
	static Integer lapistimer = 0;
	static Integer prismarinTimer = 0;
	public TimerTask(SuperWars sp) {
		
		tick = Bukkit.getScheduler().scheduleAsyncRepeatingTask(sp, new Runnable() {
			
			@Override
			public void run() {
				switch (sp.getGamestate()) {
				case Waiting:
					if(Bukkit.getOnlinePlayers().size() >= 2) {
							CountDown--;
							setStats();
							if(CountDown == 30) {
								Bukkit.broadcastMessage(SuperWars.getPrefix() + "Das Spiel startet in 30 Sekunden!");
							}
							if(CountDown == 20) {
								Bukkit.broadcastMessage(SuperWars.getPrefix() + "Das Spiel startet in 20 Sekunden!");
							}
							if(CountDown == 10) {
								Bukkit.broadcastMessage(SuperWars.getPrefix() + "Das Spiel startet in 10 Sekunden!");
								new RadomTeam();
							}
							if(CountDown == 5) {
								Bukkit.broadcastMessage(SuperWars.getPrefix() + "Das Spiel startet in 5 Sekunden!");
							}
							if(CountDown == 4) {
								Bukkit.broadcastMessage(SuperWars.getPrefix() + "Das Spiel startet in 4 Sekunden!");
							}
							if(CountDown == 3) {
								Bukkit.broadcastMessage(SuperWars.getPrefix() + "Das Spiel startet in 3 Sekunden!");
							}
							if(CountDown == 2) {
								Bukkit.broadcastMessage(SuperWars.getPrefix() + "Das Spiel startet in 2 Sekunden!");
							}
							if(CountDown == 1) {
								Bukkit.broadcastMessage(SuperWars.getPrefix() + "Das Spiel startet in 1 Sekunden!");
								CountDown = 60*60*40*20;
								sp.setGamestate(Gamestate.Ingame);
								setSpawnForTeam();
								SuperWars.play = true;
							}
					}else {CountDown = 60;}
					break;
				case Lobby :
					break;
				case Ingame:
					if(Bukkit.getOnlinePlayers().size() >= 1) {
						for(Player p : Bukkit.getOnlinePlayers()) {
							if(SuperWars.Team_Blue.size() == 0) {
								p.sendMessage("§c-----------------------------");
								p.sendMessage(" ");
								p.sendMessage("§eTeam §cRot §e konnte das Spiel für sich gewinnen!");
								p.sendMessage(" ");
								p.sendMessage("§c-----------------------------");
								
								CraftTitleApi.sendFullTitle(p, 40, 40, 40, "§e§lSuperWars§8", "§e§lTeam §c§lRot§e hat gewonnen!");
								
								sp.setGamestate(Gamestate.Reset);
								CountDown = 30;
							}else if(SuperWars.Team_Red.size() == 0) {
								p.sendMessage("§9-----------------------------");
								p.sendMessage(" ");
								p.sendMessage("§eTeam §9Blau §e konnte das Spiel für sich gewinnen!");
								p.sendMessage(" ");
								p.sendMessage("§9-----------------------------");
								CraftTitleApi.sendFullTitle(p, 40, 40, 40, "§e§lSuperWars§8", "§e§lTeam §9§lBlau§e hat gewonnen!");
								sp.setGamestate(Gamestate.Reset);
								CountDown = 30;
							}
						}
					}else {Bukkit.shutdown();}
					break;
				case Reset:
					CountDown --;
					for(Player p : Bukkit.getOnlinePlayers()) {
						p.setLevel(CountDown);
						if(Bukkit.getOnlinePlayers().size() <= 0) {
							Bukkit.shutdown();
						}
						if(CountDown == 10) {
							p.sendMessage(SuperWars.getPrefix() + "Der Server restartet in 10 Sekunden!");
						}
						if(CountDown == 5) {
							p.sendMessage(SuperWars.getPrefix() + "Der Server restartet in 5 Sekunden!");
						}
						if(CountDown == 4) {
							p.sendMessage(SuperWars.getPrefix() + "Der Server restartet in 4 Sekunden!");
						}
						if(CountDown == 3) {
							p.sendMessage(SuperWars.getPrefix() + "Der Server restartet in 3 Sekunden!");
						}
						if(CountDown == 2) {
							p.sendMessage(SuperWars.getPrefix() + "Der Server restartet in 2 Sekunden!");
						}
						if(CountDown == 1) {
							p.sendMessage(SuperWars.getPrefix() + "Der Server restartet in 1 Sekunden!");
							Bukkit.shutdown();
						}
					}
					break;
				default:
					Bukkit.getScheduler().cancelTask(tick);
					break;
				}
			}
			
			private void setSpawnForTeam() {
				for(Player blue : SuperWars.Team_Blue) {
					blue.teleport(SuperWars.tblue);
				}
				for(Player red : SuperWars.Team_Red) {
					red.teleport(SuperWars.tred);
				}
			}
		}, 0, 20*1);
	}
	
	public static void spawnItems() {
		new BukkitRunnable() {
			
			@Override
			public void run() {
				if(SuperWars.getGamestate().equals(Gamestate.Ingame)) {
					lapistimer ++;
					prismarinTimer++;
					for(Location loc : SuperWars.SpawenSpawner.keySet()) {
						if(SuperWars.SpawenSpawner.get(loc) == 0) {
							loc.getWorld().dropItemNaturally(loc, new ItemStack(Material.NETHER_BRICK_ITEM));
						}else if(SuperWars.SpawenSpawner.get(loc) == 1) {
							if(lapistimer == 10) {
								loc.getWorld().dropItemNaturally(loc, new ItemStack(Material.INK_SACK,1,(short)4));
							}
						}else if(SuperWars.SpawenSpawner.get(loc) == 2) {
							if(prismarinTimer == 20) {
								loc.getWorld().dropItemNaturally(loc, new ItemStack(Material.PRISMARINE_SHARD));
							}
						}
					}
					if(lapistimer >= 10) {
						lapistimer = 0;
					}
					if(prismarinTimer >= 20) {
						prismarinTimer = 0;
					}
				}
			}
		}.runTaskTimer(SuperWars.getInstance(), 0, 20*1);
	}
	
	public void destryNPC() {
		for(NPC npc : SuperWars.Team_Point.keySet()) {
			npc.destroy();
		}
	}
	
	public void setStats() {
		for(Player p : Bukkit.getOnlinePlayers()) {
			if(CountDown > 30) {ActionBar.sendActionBarTime(p, "§6Start in §a" +CountDown + "§6 Sekunden §c✗✗✗✗", 1);}
			if(CountDown <= 30 && CountDown >= 20) {
				ActionBar.sendActionBarTime(p, "§6Start in §a" +CountDown + "§6 Sekunden §a✔§c✗✗✗", 1);
				if(CountDown == 30) {p.playSound(p.getLocation(), Sound.CHEST_OPEN, 1, 1);}
			}
			if(CountDown <= 20 && CountDown >= 10) {
				if(CountDown == 20) {p.playSound(p.getLocation(), Sound.CHEST_CLOSE, 1, 1);}
				ActionBar.sendActionBarTime(p, "§6Start in §a" +CountDown + "§6 Sekunden §a✔✔§c✗✗", 1);
			}
			if(CountDown <= 10 && CountDown >= 5) {
				if(CountDown == 10) {p.playSound(p.getLocation(), Sound.EXPLODE, 1, 1);}
				ActionBar.sendActionBarTime(p, "§6Start in §a" +CountDown + "§6 Sekunden §a✔✔✔§c✗", 1);
			}
			if(CountDown < 5 && CountDown >0) {
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);
				ActionBar.sendActionBarTime(p, "§6Start in §a" +CountDown + "§6 Sekunden §a✔✔✔✔", 1);
			}
		}
	}
	
	public static Integer getCoundDown() {
		return CountDown;
	}
	
	public static void setCountDown(Integer i) {
		CountDown = i;
	}
	
}
