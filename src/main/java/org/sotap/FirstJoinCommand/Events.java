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
	private FileConfiguration config;
	
	public Events(FirstJoinCommand plug, FileConfiguration config) {
		this.plug = plug;
		this.config = config;
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
		if (!p.hasPlayedBefore()) {
			if (this.config.contains("commands")) {
				List<String> commands = this.config.getStringList("commands");
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
	}
}
