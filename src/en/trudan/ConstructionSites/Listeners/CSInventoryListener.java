package en.trudan.ConstructionSites.Listeners;

import org.bukkit.inventory.ItemStack;
import org.getspout.spoutapi.event.inventory.InventoryCloseEvent;
import org.getspout.spoutapi.event.inventory.InventoryListener;

import en.trudan.ConstructionSites.ConstructionSites;

public class CSInventoryListener extends InventoryListener {
	
	public void onInventoryClose(InventoryCloseEvent event) {
		System.out.println("An inventory was closed by: " + event.getPlayer().getDisplayName()+ "|" + event.getInventory().getName());
		//if (ConstructionSites.getFH().hasConstructionSite(event.getInventory().getName())){
			ItemStack[] stacks = event.getInventory().getContents();
			event.getPlayer().sendMessage(event.getInventory().getName());
			for(ItemStack stack : stacks) {
				if(stack != null) {
					ConstructionSites.getFH().getConstructionSite(event.getInventory().getName()).getMaterialStorage().addMaterial(stack);
					System.out.println(stack.getTypeId());
				}
			}
			System.out.println(ConstructionSites.getFH().getConstructionSite(event.getInventory().getName()).getMaterialStorage().getAmought(17));
			
		//}
		
	}
	
}
