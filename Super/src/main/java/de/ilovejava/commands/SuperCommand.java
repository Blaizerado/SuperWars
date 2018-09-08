package de.ilovejava.commands;



import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import de.ilovejava.npc.CreateNPC;
import de.ilovejava.superwars.SuperWars;
import net.citizensnpcs.api.npc.NPC;

public class SuperCommand extends AbstarctCommand{


	public SuperCommand(String commandName, Plugin pl) {
		super(commandName, pl);
	}

	@Override
	public boolean command(CommandSender sender, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(args.length == 0) {
				if(p.hasPermission("Super.info")) {
					p.sendMessage("§3/super middle");
					p.sendMessage("§3/super set bed blue-red 1-1");
					p.sendMessage("§3/super set Shop blue-red");
					p.sendMessage("§3/super set npc red [1-4]");
					p.sendMessage("§3/super set npc blue [1-4]");
					p.sendMessage("§3/super set npc-spawn");
					p.sendMessage("§3/super set npc tred|tblue");
					p.sendMessage("§3/super set lobby");
					p.sendMessage("§3/super set spawn red");
					p.sendMessage("§3/super set spawn blue");
				}
			}else if(args.length == 1) {
				if(args[0].equalsIgnoreCase("middle")) {
					if(p.hasPermission("Super.middle")) {
						YamlConfiguration cfg = YamlConfiguration.loadConfiguration(SuperWars.Spawn_File);
						cfg.set("Config.Middle", p.getLocation());
						try {cfg.save(SuperWars.Spawn_File);}catch(Exception e) {}
						p.sendMessage(SuperWars.getPrefix() + "Die Mitte wurde gesetzt!");
					}
				}else {
					if(p.hasPermission("Super.info")) {
						p.sendMessage("§3/super set npc red [1-4]");
						p.sendMessage("§3/super set npc blue [1-4]");
						p.sendMessage("§3/super set lobby");
						p.sendMessage("§3/super set spawn red");
						p.sendMessage("§3/super set spawn blue");
					}
				}
			}else if(args.length == 2) {
				if(args[0].equalsIgnoreCase("set")) {
					if(args[1].equalsIgnoreCase("lobby")) {
						if(p.hasPermission("Super.lobby")) {
							YamlConfiguration cfg = YamlConfiguration.loadConfiguration(SuperWars.Lobby_File);
							cfg.set("Lobby", p.getLocation());
							try {cfg.save(SuperWars.Lobby_File);}catch(Exception e) {}
							p.sendMessage(SuperWars.prefix + "Der Spawn wurde gesetzt!");
						}
					}else if(args[0].equalsIgnoreCase("spawn")) {
						if(p.hasPermission("Super.spawn")) {
							p.sendMessage("§3/super set spawn red");
							p.sendMessage("§3/super set spawn blue");
						}
					}else if(args[1].equalsIgnoreCase("npc-spawn")) {
							if(p.hasPermission("Super.NPC.spawn")) {
								YamlConfiguration cfg = YamlConfiguration.loadConfiguration(SuperWars.NPC_File);
								cfg.set("Config.NPC.Walk.Spawn", p.getLocation());
								try {cfg.save(SuperWars.NPC_File);}catch(Exception e) {}
								p.sendMessage(SuperWars.getPrefix() + "Der NPC Walk Spawn wurde gesetzt!");
						}
					}
				}
			}else if(args.length == 3) {
				if(args[0].equalsIgnoreCase("set")) {
					if(args[1].equalsIgnoreCase("spawn")) {
						if(args[2].equalsIgnoreCase("red")) {
							if(p.hasPermission("Super.team.red")) {
								YamlConfiguration cfg = YamlConfiguration.loadConfiguration(SuperWars.Spawn_File);
								cfg.set("Config.Red", p.getLocation());
								try {cfg.save(SuperWars.Spawn_File);}catch(Exception e) {}
								p.sendMessage(SuperWars.getPrefix() + "Der Spawn für das Team Rot wurde gesetzt!");
							}
						}else if(args[2].equalsIgnoreCase("blue")) {
							if(p.hasPermission("Super.team.blue")) {
								YamlConfiguration cfg = YamlConfiguration.loadConfiguration(SuperWars.Spawn_File);
								cfg.set("Config.Blue", p.getLocation());
								try {cfg.save(SuperWars.Spawn_File);}catch(Exception e) {}
								p.sendMessage(SuperWars.getPrefix() + "Der Spawn für das Team Blau wurde gesetzt!");
							}
						}
					}else if(args[1].equalsIgnoreCase("npc")) {
						if(args[2].equalsIgnoreCase("tred")) {
							if(p.hasPermission("Super.tred")) {
								new CreateNPC("ILoveJava", EntityType.PLAYER, "§cRot", p.getLocation());
								YamlConfiguration cfg = YamlConfiguration.loadConfiguration(SuperWars.NPC_File);
								cfg.set("Team.Red", p.getLocation());
								try {cfg.save(SuperWars.NPC_File);}catch(Exception e) {}
								p.sendMessage(SuperWars.getPrefix() + "Der Npc für das Team Rot wurde gesetzt!");
							}
						}else if(args[2].equalsIgnoreCase("tblue")) {
							if(p.hasPermission("Super.tblue")) {
								new CreateNPC("ILoveJava", EntityType.PLAYER, "§9Blau", p.getLocation());
								YamlConfiguration cfg = YamlConfiguration.loadConfiguration(SuperWars.NPC_File);
								cfg.set("Team.Blue", p.getLocation());
								try {cfg.save(SuperWars.NPC_File);}catch(Exception e) {}
								p.sendMessage(SuperWars.getPrefix() + "Der Npc für das Team Blau wurde gesetzt!");
							}
						}
					}else if(args[1].equalsIgnoreCase("bed")) {
						if(args[2].equalsIgnoreCase("red")) {
							if(p.hasPermission("Super.bed")) {
								Block b = p.getLocation().getBlock().getRelative(BlockFace.DOWN);
								if(b.getType().equals(Material.BED_BLOCK) || b.getType().equals(Material.BED)) {
									YamlConfiguration cfg = YamlConfiguration.loadConfiguration(SuperWars.Spawn_File);
									cfg.set("Config.Bed.Red", b.getLocation());
									try {cfg.save(SuperWars.Spawn_File);}catch(Exception e) {}
									p.sendMessage(SuperWars.getPrefix() + "Du hast das Bett für Team Rot gesetzt!");
								}else {p.sendMessage(SuperWars.getPrefix() + "Achtung, du musst auf einem Bett stehen!");}
							}
						}else if(args[2].equalsIgnoreCase("blue")) {
							if(p.hasPermission("Super.bed")) {
								Block b = p.getLocation().getBlock().getRelative(BlockFace.DOWN);
								if(b.getType().equals(Material.BED_BLOCK) || b.getType().equals(Material.BED)) {
									YamlConfiguration cfg = YamlConfiguration.loadConfiguration(SuperWars.Spawn_File);
									cfg.set("Config.Bed.Blue", b.getLocation());
									try {cfg.save(SuperWars.Spawn_File);}catch(Exception e) {}
									p.sendMessage(SuperWars.getPrefix() + "Du hast das Bett für Team Blau gesetzt!");
								}else {p.sendMessage(SuperWars.getPrefix() + "Achtung, du musst auf einem Bett stehen!");}
							}
						}
					}else if(args[1].equalsIgnoreCase("Shop")) {
						if(args[2].equalsIgnoreCase("blue")) {
							if(p.hasPermission("Super.Sshop")) {
								YamlConfiguration cfg = YamlConfiguration.loadConfiguration(SuperWars.NPC_File);
								cfg.set("Config.Blue.Shop", p.getLocation());
								NPC npc = SuperWars.npc.createNPC(EntityType.PLAYER, "§6Shop");
								npc.spawn(p.getLocation());
								try {cfg.save(SuperWars.NPC_File);}catch(Exception e) {}
								p.sendMessage(SuperWars.getPrefix() + "Du hast den Shop für Team Blue gesetzt!");
							}
						}else if(args[2].equalsIgnoreCase("red")) {
							if(p.hasPermission("Super.Sshop")) {
								YamlConfiguration cfg = YamlConfiguration.loadConfiguration(SuperWars.NPC_File);
								cfg.set("Config.Red.Shop", p.getLocation());
								NPC npc = SuperWars.npc.createNPC(EntityType.PLAYER, "§6Shop");
								npc.spawn(p.getLocation());
								try {cfg.save(SuperWars.NPC_File);}catch(Exception e) {}
								p.sendMessage(SuperWars.getPrefix() + "Du hast den Shop für Team Blue gesetzt!");
							}
						}
					}
				}
			}else if(args.length == 4) {
				if(args[0].equalsIgnoreCase("set")) {
					if(args[1].equalsIgnoreCase("npc")) {
						if(args[2].equalsIgnoreCase("red")) {
							if(p.hasPermission("Super.npc.set")) {
								String s = args[3];
								YamlConfiguration cfg = YamlConfiguration.loadConfiguration(SuperWars.NPC_File);
								switch (s) {
								case "1":
									cfg.set("Config.NPC.red.1", p.getLocation());
									break;
								case "2":
									cfg.set("Config.NPC.red.2", p.getLocation());
									break;
								case "3":
									cfg.set("Config.NPC.red.3", p.getLocation());
									break;
								case "4":
									cfg.set("Config.NPC.red.4", p.getLocation());
									break;
								default:
									break;
								}
								p.sendMessage(SuperWars.getPrefix() + "Der NPC Spawn " + s + " wurde gesetzt!");
								try {cfg.save(SuperWars.NPC_File);}catch(Exception e) {}
							}
						}else if(args[2].equalsIgnoreCase("blue")) {
							if(p.hasPermission("Super.npc.set")) {
								String s = args[3];
								YamlConfiguration cfg = YamlConfiguration.loadConfiguration(SuperWars.NPC_File);
								switch (s) {
								case "1":
									cfg.set("Config.NPC.blue.1", p.getLocation());
									break;
								case "2":
									cfg.set("Config.NPC.blue.2", p.getLocation());
									break;
								case "3":
									cfg.set("Config.NPC.blue.3", p.getLocation());
									break;
								case "4":
									cfg.set("Config.NPC.blue.4", p.getLocation());
									break;
								default:
									break;
								}
								p.sendMessage(SuperWars.getPrefix() + "Der NPC Spawn " + s + " wurde gesetzt!");
								try {cfg.save(SuperWars.NPC_File);}catch(Exception e) {}
							}
						}
					}else if(args[1].equalsIgnoreCase("bed")) {
						if(args[2].equalsIgnoreCase("red")) {
							if(args[3].equalsIgnoreCase("1")) {
								if(p.hasPermission("Super.bed")) {
									Block b = p.getLocation().getBlock().getRelative(BlockFace.DOWN);
									if(b.getType().equals(Material.BED_BLOCK) || b.getType().equals(Material.BED)) {
										YamlConfiguration cfg = YamlConfiguration.loadConfiguration(SuperWars.Spawn_File);
										cfg.set("Config.Bed.Red1", b.getLocation());
										try {cfg.save(SuperWars.Spawn_File);}catch(Exception e) {}
										p.sendMessage(SuperWars.getPrefix() + "Du hast das Bett für Team Rot gesetzt!");
									}else {p.sendMessage(SuperWars.getPrefix() + "Achtung, du musst auf einem Bett stehen!");}
								}
							}
						}else if(args[2].equalsIgnoreCase("blue")) {
							if(args[3].equalsIgnoreCase("1")) {
								if(p.hasPermission("Super.bed")) {
									Block b = p.getLocation().getBlock().getRelative(BlockFace.DOWN);
									if(b.getType().equals(Material.BED_BLOCK) || b.getType().equals(Material.BED)) {
										YamlConfiguration cfg = YamlConfiguration.loadConfiguration(SuperWars.Spawn_File);
										cfg.set("Config.Bed.Blue1", b.getLocation());
										try {cfg.save(SuperWars.Spawn_File);}catch(Exception e) {}
										p.sendMessage(SuperWars.getPrefix() + "Du hast das Bett für Team Blau gesetzt!");
									}else {p.sendMessage(SuperWars.getPrefix() + "Achtung, du musst auf einem Bett stehen!");}
								}
							}
						}
					}
				}
			}
		}
		return true;
	}

}
