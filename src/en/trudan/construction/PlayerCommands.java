package en.trudan.ConstructionSites;

import java.util.HashMap;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.getspout.spout.inventory.CustomInventory;

public class PlayerCommands {

	public HashMap<String, ItemStack[]> inventories = new HashMap<String, ItemStack[]>();
	public HashMap<String, Inventory> openedInventories = new HashMap<String, Inventory>();
	
	public static void proccess(CommandSender sender, Command command, String commandLabel, String[] args) {
		
		String commandName = command.getName();
		if(commandName.equalsIgnoreCase("construct")) {
			if(args.length >= 1) {
				String subcommandName = args[0];
				if(subcommandName.equalsIgnoreCase("trade")) {
					// /construct trade
					// Trade items into the construction site
					Player player = (Player) sender;
					String siteName = "Construction Site Materials";
					
					CustomInventory inv = new CustomInventory(54,siteName);
					//openedInventoriesOthers.put(player.getName(), siteName);
					//inv.setContents(inventories.get(siteName));
					((org.getspout.spoutapi.player.SpoutPlayer) player).openInventoryWindow((Inventory) inv);
				}
			}
		}
	}
}
