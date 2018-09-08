package de.ilovejava.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import de.ilovejava.shop.Inventorys;
import de.ilovejava.shop.Shop;

public class Klick implements Listener {
	@EventHandler
	public void onKlick(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		if(e.getInventory() == null)return;
		if(e.getInventory().getName() == null)return;
		if(e.getCurrentItem() == null)return;
		
		if(e.getInventory().getName().equalsIgnoreCase("§6Shop")) {
			e.setCancelled(true);
			if(e.getCurrentItem().getItemMeta().hasDisplayName()) {
				switch(e.getCurrentItem().getItemMeta().getDisplayName()) {
				case "§e§lPickaxe":
					Inventorys.PickAxeInv(p, e.getInventory());
					break;
				case "§c§lWaffen":
					Inventorys.WeaponInv(p, e.getInventory());
					break;
				case "§6§lRüstungen":
					Inventorys.ArmorInv(p, e.getInventory());
					break;
				case "§d§lBlöcke":
					Inventorys.BlockInv(p, e.getInventory());
					break;
				case "§3§lEssen":
					Inventorys.FoodInv(p, e.getInventory());
					break;
				case "§5§lC4":
					
					break;
				case "§c§lWurfwaffen":
					
					break;
			  }
			}else {
				Shop.Weaponshop(p, e.getCurrentItem());
			}
		}
	}
	
}
