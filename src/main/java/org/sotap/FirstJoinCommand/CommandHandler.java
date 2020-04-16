package org.sotap.FirstJoinCommand;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;

public class CommandHandler implements CommandExecutor {
    private FirstJoinCommand plug;
    private CommandSender sender;

    public CommandHandler(FirstJoinCommand plug) {
        this.plug = plug;
    }

    public void send(String msg) {
        this.sender.sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("firstjoincommand")) {
            String arg = args[0];
            this.sender = sender;

            this.plug.reloadConfig();
            FileConfiguration config = this.plug.getConfig();

            switch (arg) {
                case "enable":
                    if (!config.getBoolean("enabled")) {
                        config.set("enabled", true);
                        this.plug.saveConfig();
                        this.send("&f[&aSUCCESS&f] Successfully &aenabled&f the plugin functions.");
                    } else {
                        this.send("&f[&eWARN&f] The functions are already &aenabled&f.");
                    }
                    break;

                case "disable":
                    if (config.getBoolean("enabled")) {
                        config.set("enabled", false);
                        this.plug.saveConfig();
                        this.send("&f[&aSUCCESS&f] Successfully &cdisabled&f the plugin functions.");
                    } else {
                        this.send("&f[&eWARN&f] The functions are already &cdisabled&f.");
                    }
                    break;

                case "reload":
                    this.plug.reloadConfig();
                    this.send("&f[&aSUCCESS&f] Successfully reloaded the plugin configuration.");
                    break;
            }
            return true;
        } else {      
            return false;
        }
    }
}