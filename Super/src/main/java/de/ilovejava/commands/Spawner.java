package de.ilovejava.commands;

import java.io.File;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class Spawner extends AbstarctCommand{

	public Spawner(String commandName, Plugin pl) {
		super(commandName, pl);
	}
	@Override
	public boolean command(CommandSender sender, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(args.length == 0) {
				if(p.hasPermission("Super.spawner")) {
					p.sendMessage("§3/spawner spawner");
				}
			}else if(args.length == 1) {
				if(args[0].equalsIgnoreCase("spawner")) {
					if(p.hasPermission("Super.spawner")) {
						File f = new File("plugins/SuperWars/Spawner",p.getLocation().getBlockX()+p.getLocation().getZ()+".cfg");
						YamlConfiguration cfg = YamlConfiguration.loadConfiguration(f);
						if(!f.exists()) {
							Block b = p.getLocation().getBlock().getRelative(BlockFace.DOWN);
							if(b.getType().equals(Material.NETHER_BRICK)) {
								cfg.set("Config.Location", b.getLocation());
								cfg.set("Config.Material", 0);
								try {cfg.save(f);}catch(Exception e) {}
								p.sendMessage("§aNether Brick spawner wurde gesetzt!");
							}else if(b.getType().equals(Material.LAPIS_BLOCK)) {
								cfg.set("Config.Location", p.getLocation());
								cfg.set("Config.Material", 1);
								try {cfg.save(f);}catch(Exception e) {}
								p.sendMessage("§aLapis spawner wurde gesetzt!");
							}else if(b.getType().equals(Material.PRISMARINE)) {
								cfg.set("Config.Location", p.getLocation());
								cfg.set("Config.Material", 2);
								try {cfg.save(f);}catch(Exception e) {}
								p.sendMessage("§aPrissmarin spawner wurde gesetzt!");
							}else {p.sendMessage("§cEs wurde kein Spawn block gefunden!");}
						}else {p.sendMessage("§cAn dieser Stelle steht bereits ein Spawner!");}
					}
				}
			}
		}
		return true;
	}
	
}
