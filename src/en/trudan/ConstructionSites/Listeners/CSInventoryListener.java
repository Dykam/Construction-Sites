package en.trudan.ConstructionSites.Listeners;

import org.bukkit.inventory.ItemStack;
import org.getspout.spoutapi.event.inventory.InventoryCloseEvent;
import org.getspout.spoutapi.event.inventory.InventoryListener;

import en.trudan.ConstructionSites.ConstructionSites;
import en.trudan.ConstructionSites.Data.ConstructionSite;
import en.trudan.ConstructionSites.Data.FileHandler;

public class CSInventoryListener extends InventoryListener {
	public static ConstructionSites main = ConstructionSites.main;
	public static FileHandler fh = main.getFH();
	public void onInventoryClose(InventoryCloseEvent event) {
		
		if (fh.hasConstructionSite(event.getInventory().getName())){
			ItemStack[] stacks = event.getInventory().getContents();
			
			for(ItemStack stack : stacks) {
				if(stack != null) {
					ConstructionSite site = fh.getConstructionSite(event.getInventory().getName());
					site.getMaterialStorage().addMaterial(stack);
				}
			}
			
		}
		
	}
	
}
