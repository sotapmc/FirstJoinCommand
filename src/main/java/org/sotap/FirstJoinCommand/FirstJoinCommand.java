package org.sotap.FirstJoinCommand;

import org.bukkit.plugin.java.JavaPlugin;

public class FirstJoinCommand extends JavaPlugin {
	private Events events;

	@Override
	public void onEnable() {
		saveDefaultConfig();
		this.events = new Events(this, this.getConfig());
		this.getServer().getPluginManager().registerEvents(this.events, this);
		this.getLogger().info("The plugin has been enabled.");
	}
	
	@Override
	public void onDisable(){
		this.getLogger().info("The plugin has been disabled.");
	}
}
