package me.devflare.voidgen.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;

public class VoidGenInfo implements CommandExecutor {

    private final Plugin plugin;

    public VoidGenInfo(Plugin plugin) {
        this.plugin = plugin;
    }

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
