package en.trudan.ConstructionSites;


import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.getspout.spout.inventory.CustomInventory;

public class PlayerCommands {

	public static void proccess(CommandSender sender, Command command, String commandLabel, String[] args) {

		String commandName = command.getName();
		if(commandName.equalsIgnoreCase("construct")) {
			if(args.length >= 1) {
				String subcommandName = args[0];
				if(subcommandName.equalsIgnoreCase("trade")) {
					if(args.length == 2) {
						if(ConstructionSites.getFH().getConstructionSite(args[1]) != null) {

							// Trade items into the construction site
							Player player = (Player) sender;
							String siteName = args[1];

							CustomInventory inv = new CustomInventory(54,siteName);

							ItemStack[] stacks = ConstructionSites.getFH().getConstructionSite(args[1]).getMaterialStorage().getChest();

							for(ItemStack stack : stacks) {
								if(stack != null) {
									inv.addItem(stack);
								}
							}

							((org.getspout.spoutapi.player.SpoutPlayer) player).openInventoryWindow((Inventory) inv);
						}
						else {
							sender.sendMessage(ChatColor.RED+"That construction site does not exist!");
						}
					}
					else {
						sender.sendMessage(ChatColor.GRAY+"Correct Usage: "+ChatColor.GREEN+"/construct trade <Site name>");
					}
				}
				else if(subcommandName.equalsIgnoreCase("create")) {
					if(args.length == 2) {
						if(ConstructionSites.getFH().getConstructionSite(args[1]) == null) {
							if(ConstructionSites.getFH().addConstructionSite(args[1])) {
								sender.sendMessage(ChatColor.GREEN+"Construction site '"+args[1]+"' has been created.");
							}
							else {
								sender.sendMessage(ChatColor.RED+"There was an error whilst trying to create this construction site.");
							}
						}
						else {
							sender.sendMessage(ChatColor.RED+"That construction site already exists!");
						}
					}
					else {
						sender.sendMessage(ChatColor.GRAY+"Correct Usage: "+ChatColor.GREEN+"/construct create <Site name>");
					}
				}
				
			}
		}
	}
}
