package en.trudan.ConstructionSites;


import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.getspout.spout.inventory.CustomInventory;

import en.trudan.ConstructionSites.Data.ConstructionSite;
import en.trudan.ConstructionSites.Data.FileHandler;

public class PlayerCommands {

	public static ConstructionSites main = ConstructionSites.main;
	public static FileHandler fh = main.getFH();

	public static void proccess(CommandSender sender, Command command, String commandLabel, String[] args) {

		String commandName = command.getName();
		if(commandName.equalsIgnoreCase("construct")) {
			if(args.length >= 1) {
				String subcommandName = args[0];
				if(subcommandName.equalsIgnoreCase("trade")) {
					if(args.length == 2) {
						if(fh.getConstructionSite(args[1]) != null) {

							ConstructionSite site = fh.getConstructionSite(args[1]);

							// Trade items into the construction site
							Player player = (Player) sender;
							String siteName = "Construction Site Traiding";

							CustomInventory inv = new CustomInventory(54,siteName);
							fh.addInventory(player, inv);

							ItemStack[] stacks = site.getMaterialStorage().getChest();

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
						if(fh.getConstructionSite(args[1]) == null) {
							if(fh.addConstructionSite(args[1])) {
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
				else if(subcommandName.equalsIgnoreCase("stop")) {
					if(args.length == 2) {
						if(fh.getConstructionSite(args[1]) != null) {
							Player player = (Player) sender;
							ItemStack[] stacks = fh.getInventory(player).getContents();
							for(ItemStack stack : stacks) {
								if(stack != null) {
									player.sendMessage("You traded with the ConstructionSite!");
									ConstructionSite site = fh.getConstructionSite(args[1]);
									site.getMaterialStorage().addMaterial(stack);
								}
							}
						}
					}

				}
				
				else if(subcommandName.equalsIgnoreCase("add")) {
					fh.getConstructionSite("Site").getMaterialStorage().addMaterial(1, 50);
					sender.sendMessage("stone");

				}
			}
		}
	}
}
