package org.sotap.FirstJoinCommand;

import org.bukkit.event.Listener;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.List;

public class Events implements Listener {
	@SuppressWarnings("unused")
	private FirstJoinCommand plug;

	public Events(FirstJoinCommand plug) {
		this.plug = plug;
	}

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();

		// always reload config before getting it.
		this.plug.reloadConfig();
		FileConfiguration config = this.plug.getConfig();

		if (config.contains("enabled")) {
			if (config.getBoolean("enabled")) {
				ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
				if (!p.hasPlayedBefore()) {
					if (config.contains("commands")) {
						List<String> commands = config.getStringList("commands");
						// this logic performs well even though it is really old now.
						for (int i = 0; i < commands.size(); i++) {
							String k = commands.get(i);
							k = k.replace("%username%", p.getName());
							k = k.replace("%uuid%", p.getUniqueId().toString());
							k = ChatColor.translateAlternateColorCodes('&', k);
							Bukkit.dispatchCommand(console, k);
						}
					}
				}
			} else {
				this.plug.log("&f[&bINFO&f] Skipped player join event of &a" + p.getName() + "&f.");
			}
		} else {
			this.plug.log("&f[&cFAILED&f] Missing required key named `enabled` in config.yml.");
		}
		
	}
}
