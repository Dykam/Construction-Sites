package en.trudan.ConstructionSites.Listeners;

import org.getspout.spoutapi.event.inventory.InventoryListener;

import en.trudan.ConstructionSites.ConstructionSites;
import en.trudan.ConstructionSites.Data.FileHandler;

public class CSInventoryListener extends InventoryListener {
	public static ConstructionSites main = ConstructionSites.main;
	public static FileHandler fh = main.getFH();
	/*public void onInventoryClose(InventoryCloseEvent event) {
		System.out.println("An inventory was closed by: " + event.getPlayer().getDisplayName()+ "|" + event.getInventory().getName());
		//if (fh.hasConstructionSite(event.getInventory().getName())){
			ItemStack[] stacks = event.getInventory().getContents();
			event.getPlayer().sendMessage(event.getInventory().getName());
			
			for(ItemStack stack : stacks) {
				if(stack != null) {
					event.getPlayer().sendMessage("You traded with the ConstructionSite!");
					ConstructionSite site = fh.getConstructionSite(event.getInventory().getName());
					site.getMaterialStorage().addMaterial(stack);
				}
			}
			
		//}
		
	}*/
	
}
