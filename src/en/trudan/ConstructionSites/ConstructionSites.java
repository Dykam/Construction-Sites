package en.trudan.ConstructionSites;

import java.util.logging.Logger;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import en.trudan.ConstructionSites.Data.FileHandler;


public class ConstructionSites extends JavaPlugin {

	Logger log = Logger.getLogger("Minecraft");
	//Thread thread = new Thread(runnable);
	private static FileHandler FH = null;
	public static ConstructionSites main;
	
	
	public void onDisable() {
		
		log.info("[Construction Sites] Plugin has been disabled");
		
	}

	public void onEnable() {
		log.info("[Construction Sites] Plugin is starting up");
		ConstructionSites.main = this;
		log.info("[Construction Sites] Loading data");
		FH = new FileHandler();
		//new DataBackupTimer();
		log.info("[Construction Sites] Plugin has been enabled");
		
	}
	
	public boolean onCommand(CommandSender sender, Command command, String commandLabel, String[] args) {
		
		if(sender instanceof Player) {
			PlayerCommands.proccess(sender, command, commandLabel, args);
		}
		else {
			//ConsoleCommands.proccess();
		}
		
		return true;
	}
	
	public FileHandler getFH(){
		return FH;
	}

}
