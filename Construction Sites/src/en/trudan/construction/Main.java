package en.trudan.construction;

import java.util.logging.Logger;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Plugin {

	Logger log = Logger.getLogger("Minecraft");
	
	
	@Override
	public void onDisable() {
		
		log.info("[Construction Sites] Plugin has been disabled");
		
	}

	@Override
	public void onEnable() {
		
		log.info("[Construction Sites] Plugin has been enabled");
		
	}

}
