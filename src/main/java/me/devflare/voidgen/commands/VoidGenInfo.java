package me.devflare.voidgen.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;

public class VoidGenInfo implements CommandExecutor {

    private final Plugin plugin;

    /**
     * Creates a new command executor tied to the given plugin.
     *
     * @param plugin the plugin instance whose metadata (name, version, authors) will be used when handling the `/voidgen info` command
     */
    public VoidGenInfo(Plugin plugin) {
        this.plugin = plugin;
    }

    /**
     * Handles the "/voidgen info" subcommand by validating arguments and sending the plugin's
     * name, version, and author(s) to the command sender.
     *
     * @param sender the recipient of the response messages
     * @param command the command that was executed
     * @param label the alias of the command used
     * @param args the command arguments; the first argument must be "info" (case-insensitive) to show plugin information
     * @return `true` to indicate the command was handled
     */
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0 || !args[0].equalsIgnoreCase("info")) {
            sender.sendMessage(ChatColor.RED + "Usage: /voidgen info");
            return true;
        }

        String version = plugin.getDescription().getVersion();
        String author = plugin.getDescription().getAuthors().isEmpty()
                ? "Unknown"
                : String.join(", ", plugin.getDescription().getAuthors());

        sender.sendMessage(ChatColor.GRAY + "--------------------------------");
        sender.sendMessage(ChatColor.AQUA + plugin.getName());
        sender.sendMessage(ChatColor.GRAY + "Version: " + ChatColor.WHITE + version);
        sender.sendMessage(ChatColor.GRAY + "Author: " + ChatColor.WHITE + author);
        sender.sendMessage(ChatColor.GRAY + "--------------------------------");

        return true;
    }
}