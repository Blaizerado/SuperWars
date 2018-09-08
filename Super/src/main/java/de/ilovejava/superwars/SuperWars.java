package de.ilovejava.superwars;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import de.ilovejava.commands.Spawner;
import de.ilovejava.commands.SuperCommand;
import de.ilovejava.craftapi.CraftTitleApi;
import de.ilovejava.events.AscLoginEvent;
import de.ilovejava.events.BlockBrak;
import de.ilovejava.events.Death;
import de.ilovejava.events.Klick;
import de.ilovejava.events.NPCClick;
import de.ilovejava.events.PlayerMove;
import de.ilovejava.events.Respawn;
import de.ilovejava.gamestate.Gamestate;
import de.ilovejava.mysql.MySQL;
import de.ilovejava.npc.CreateNPC;
import de.ilovejava.radom.RandomEvents;
import de.ilovejava.score.Score;
import de.ilovejava.timer.TimerTask;
import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.npc.NPC;
import net.citizensnpcs.api.npc.NPCRegistry;
import net.md_5.bungee.api.ChatColor;


public class SuperWars extends JavaPlugin{
	public static SuperWars instance;
	public static Boolean play = false;
	public static Boolean Bed_Red = true;
	public static Boolean Bed_Blue = true;
	public static Location lobby;
	public static Location tred;
	public static Location tblue;
	public static Location NPC_RED;
	public static Location NPC_BLUE;
	public static Location NPC_Spawn;
	public static Location Middle;
	public static Location Bed_Blue_Location;
	public static Location Bed_Blue_Location1;
	public static Location Bed_Red_Location;
	public static Location Bed_Red_Location1;
	public static Location NPC_Shop_Red;
	public static Location NPC_Shop_Blue;
	public static String prefix;
	public static NPCRegistry npc;
	public static File Lobby_File;
	public static File Spawn_File;
	public static File NPC_File;
	public static Gamestate gamestate;
	public static ArrayList<Player>Team_Blue = new ArrayList<>();
	public static ArrayList<Player>Team_Red = new ArrayList<>();
	public static HashMap<NPC, String>Team_Point = new HashMap<>();
	public static HashMap<Location, Boolean>Summom_Location = new HashMap<>();
	public static HashMap<Location, Integer>SpawenSpawner = new HashMap<>();
	public static ArrayList<Location>Team_Red_NPC = new ArrayList<>();
	public static ArrayList<Location>Team_Blue_NPC = new ArrayList<>();
	public static ArrayList<Location>Build_Block = new ArrayList<>();
	public static MySQL mysql;
	@Override
	public void onEnable() {
		npc = CitizensAPI.getNPCRegistry();
		
		instance = this;
		
		Score.update();
		
		new TimerTask(this);
		new CraftTitleApi(this);
		
		setGamestate(Gamestate.Waiting);
		loadInstance();
		loadNPC();
		loadWalkLocation();
		TimerTask.spawnItems();
		RandomEvents.startEvents();
		this.mysql = new MySQL("185.245.96.48", "Minecraft", "Minecraft", "EqcKhaybHOEbvv5x");
		this.mysql.update("CREATE TABLE IF NOT EXISTS SuperWars_Stats(UUID varchar(70),Kills int,Deaths int,BedBreakes int);");
		System.out.println(" ");
		System.out.println("(̅_̅_̅(̅_̅_̅_̅_̅_̅_̅_̅̅()ڪے");
		System.out.println(" ");
		System.out.println("_______________________________________________");
		System.out.println(" ");
		System.out.println("Super-Wars wurde gestartet!!!!");
		System.out.println("Alle Module wurden Geladen!!!!");
		System.out.println("_______________________________________________");
		
		for(World w : Bukkit.getWorlds()) {
			w.setAutoSave(false);
		}
	}
	
	@Override
	public void onDisable() {
		for(NPC n: Team_Point.keySet()) {
			n.despawn();
			npc.deregisterAll();
		}
		
		for(World w : Bukkit.getWorlds()) {
			w.setAutoSave(false);
		}
		
	}
	
	private void loadInstance() {
		try {
			File f = new File("plugins/SuperWars","Lobby.yml");
			YamlConfiguration cfg = YamlConfiguration.loadConfiguration(f);
			Lobby_File = f;
			if(!f.exists()) {
				cfg.save(f);
				System.out.println("Achtung, es wurde keine Lobby gefunden!");
			}else {
				lobby = (Location) cfg.get("Lobby");
				if(lobby == null) {System.out.println("Achtung, es wurde kein Lobby Spawn gefunden!");}
			}
			f = new File("plugins/SuperWars","Spawns.yml");
			Spawn_File = f;
			cfg = YamlConfiguration.loadConfiguration(f);
			if(!f.exists()) {
				cfg.save(f);
				System.out.println("Achtung, es wurde keine Lobby Location gefunden!");
			}else {
				tred = (Location)cfg.get("Config.Red");
				tblue = (Location)cfg.get("Config.Blue");
				Middle = (Location) cfg.get("Config.Middle");
				Bed_Blue_Location = (Location) cfg.get("Config.Bed.Blue");
				Bed_Red_Location = (Location) cfg.get("Config.Bed.Red");
				Bed_Red_Location1 = (Location) cfg.get("Config.Bed.Red1");
				Bed_Blue_Location1 = (Location) cfg.get("Config.Bed.Blue1");
				if(tred == null) {System.out.println("Achtung, es wurde kein Spawn für Team Rot gefunden!");}
				if(tblue == null) {System.out.println("Achtung, es wurde kein Spawn für Team Blau gefunden!");}
				if(Middle == null) {System.out.println("Achtung, es wurde keine Mitte gefunden!");}
				if(Bed_Blue_Location == null) {System.out.println("Achtung, das Team Blau hat kein Bett!");}
				if(Bed_Red_Location == null) {System.out.println("Achtung, das Team Rot hat kein Bett!");}
				if(Bed_Blue_Location1 == null) {System.out.println("Achtung, das Team Blau hat kein Bett!");}
				if(Bed_Red_Location1 == null) {System.out.println("Achtung, das Team Rot hat kein Bett!");}
				if(Bed_Blue_Location != null) {
					if(Bed_Blue_Location.getBlock().getType().equals(Material.BED_BLOCK)) {
						Bed_Blue_Location.getBlock().setMetadata("Super", new FixedMetadataValue(this, "BLUE"));
					}else {System.out.println("Achtung, das angegben Bett ist nicht mehr in der Map!");}
				}
				if(Bed_Red_Location != null) {
					if(Bed_Red_Location.getBlock().getType().equals(Material.BED_BLOCK)) {
						Bed_Red_Location.getBlock().setMetadata("Super", new FixedMetadataValue(this, "RED"));
					}else {System.out.println("Achtung, das angegben Bett ist nicht mehr in der Map!");}
				}
			}
			f = new File("plugins/SuperWars","NPC.yml");
			NPC_File = f;
			cfg = YamlConfiguration.loadConfiguration(f);
			if(!f.exists()) {
				cfg.save(f);
				System.out.println("Es wurde keine NPC Spawn gefunden!");
			}else {
				NPC_RED = (Location) cfg.get("Team.Red");
				NPC_BLUE = (Location) cfg.get("Team.Blue");
				NPC_Spawn = (Location) cfg.get("Config.NPC.Walk.Spawn");
				NPC_Shop_Blue = (Location) cfg.get("Config.Blue.Shop");
				NPC_Shop_Red = (Location) cfg.get("Config.Red.Shop");
			}
			if(!getConfig().isSet("Config.Prefix")) {
				getConfig().set("Config.Prefix", "&8[&e&lSuperWars&8]&f: &3");
				saveConfig();
				prefix = ChatColor.translateAlternateColorCodes('&', getConfig().getString("Config.Prefix"));
			}
			
			prefix = ChatColor.translateAlternateColorCodes('&', getConfig().getString("Config.Prefix"));
			System.out.println("Prefix" + prefix);
		}catch(Exception e) {e.printStackTrace();}
		
		
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new AscLoginEvent(), this);
		pm.registerEvents(new NPCClick(), this);
		pm.registerEvents(new BlockBrak(), this);
		pm.registerEvents(new PlayerMove(this), this);
		pm.registerEvents(new Respawn(this), this);
		pm.registerEvents(new Death(this), this);
		pm.registerEvents(new Klick(), this);
		
		new SuperCommand("super", this);
		new Spawner("spawner",this);
		
		File f = new File("plugins/SuperWars/Spawner");
		if(!f.exists()) {
			f.mkdir();
		}
		for(File target : f.listFiles()) {
			YamlConfiguration cfg = YamlConfiguration.loadConfiguration(target);
			SpawenSpawner.put((Location)cfg.get("Config.Location"),cfg.getInt("Config.Material"));
			
		}
	}
	
	public void loadWalkLocation() {
		YamlConfiguration cfg = YamlConfiguration.loadConfiguration(NPC_File);
		if(cfg.get("Config.NPC.red.1")!=null) {
			Team_Red_NPC.add((Location)cfg.get("Config.NPC.red.1"));
			Team_Red_NPC.add((Location)cfg.get("Config.NPC.red.2"));
			Team_Red_NPC.add((Location)cfg.get("Config.NPC.red.3"));
			Team_Red_NPC.add((Location)cfg.get("Config.NPC.red.4"));
			Team_Blue_NPC.add((Location)cfg.get("Config.NPC.blue.1"));
			Team_Blue_NPC.add((Location)cfg.get("Config.NPC.blue.2"));
			Team_Blue_NPC.add((Location)cfg.get("Config.NPC.blue.3"));
			Team_Blue_NPC.add((Location)cfg.get("Config.NPC.blue.4"));
		}else {System.out.println("Achtung, es wurde keine tafel Location gefunden!");}
	}
	
	public void loadNPC() {
		if(NPC_BLUE != null && NPC_RED != null) {
			new CreateNPC("ILoveJava", EntityType.PLAYER, "§cRot", NPC_RED);
			new CreateNPC("ILoveJava", EntityType.PLAYER, "§9Blau", NPC_BLUE);
			NPC np = npc.createNPC(EntityType.PLAYER, "§6Shop");
			np.spawn(NPC_Shop_Blue);
			np = npc.createNPC(EntityType.PLAYER, "§6Shop");
			np.spawn(NPC_Shop_Red);
		}
	}
	
	public static Gamestate getGamestate() {
		return gamestate;
	}

	public void setGamestate(Gamestate gamestate) {
		this.gamestate = gamestate;
	}

	public static String getPrefix() {
		return prefix;
	}
	
	
	
	public static Plugin getInstance() {
		return instance;
	}
}
