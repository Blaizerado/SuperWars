package de.ilovejava.npc;

import org.bukkit.Location;
import org.bukkit.entity.EntityType;

import de.ilovejava.superwars.SuperWars;
import net.citizensnpcs.api.npc.NPC;

public class CreateNPC {
	public CreateNPC(String name, EntityType en, String team, Location loc) {
		NPC npc = SuperWars.npc.createNPC(en, name);
		npc.setName(team);
		SuperWars.Team_Point.put(npc, team);
		npc.spawn(loc);
	}
}
