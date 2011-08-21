package en.trudan.construction;

import java.util.logging.Logger;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Plugin {

	Logger log = Logger.getLogger("Minecraft");
	Runnable runnable = new ConstructionThread();
	Thread thread = new Thread(runnable);
	
	
	@Override
	public void onDisable() {
		
		log.info("[Construction Sites] Plugin has been disabled");
		
	}

	@Override
	public void onEnable() {
		log.info("[Construction Sites] Plugin is starting up");
		log.info("[Construction Sites] Starting new thread to reduce lag");
		thread.start();
		log.info("[Construction Sites] Plugin has been enabled");
		
	}

}
