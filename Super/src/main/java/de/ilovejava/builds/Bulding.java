package de.ilovejava.builds;


import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.Dye;

public class Bulding {
	public static ItemStack[] getSpawnItems() {
		Dye d = new Dye();
		d.setColor(DyeColor.BLUE);
		ItemStack[] builds = {new ItemStack(Material.PRISMARINE_CRYSTALS),d.toItemStack(),new ItemStack(Material.NETHER_BRICK)};
		return   builds;
	}
}
