package org.sotap.FirstJoinCommand;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class FirstJoinCommand extends JavaPlugin {
	private Events events;

	public void log(String log) {
		this.getLogger().info(ChatColor.translateAlternateColorCodes('&', log));
	}

	@Override
	public void onEnable() {
		this.saveDefaultConfig();
		this.events = new Events(this);
		this.getServer().getPluginManager().registerEvents(this.events, this);
		if (this.getConfig().contains("enabled")) {
			if (!this.getConfig().getBoolean("enabled")) {
				this.log("&f[&eWARN&f] This plugin has been disabled in the configuration file, so won't do anything.");
			} else {
				this.log("&f[&aSUCCESS&f] The plugin has been &aenabled&f.");
			}
		} else {
			this.log("&f[&cFAILED&f] Missing required key named `enabled` in config.yml, you need to execute the enable command manually to make the plugin run.");
		}
		Bukkit.getPluginCommand("firstjoincommand").setExecutor(new CommandHandler(this));
	}

	@Override
	public void onDisable() {
		this.log("&f[&aSUCCESS&f] The plugin has been &cdisabled&f.");
	}
}
