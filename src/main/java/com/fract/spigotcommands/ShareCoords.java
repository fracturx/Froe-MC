package com.fract.spigotcommands;

import org.bukkit.ChatColor;

import org.bukkit.command.Command;

import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.bukkit.Bukkit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import java.util.ArrayList;
import java.util.List;

public class ShareCoords implements TabExecutor {



    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {

        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (args.length > 0) {
                Player target = Bukkit.getServer().getPlayer(args[0]);
                if (target != null) {
                    String pLoc = p.getLocation().getBlockX() + ", " + p.getLocation().getBlockY() + ", " + p.getLocation().getBlockZ();

                    target.sendMessage(ChatColor.RED + p.getName() + ChatColor.RESET + "'s location is: " + ChatColor.GREEN + pLoc);
                    p.sendMessage(ChatColor.GOLD + "Successfully sent coordinates to player " + target.getName());
                }
            } else {
                p.sendMessage("No player specified to send the data to.");
                p.sendMessage("/sharecoords [playerName]");
            }
        }


        return true;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {

        if (args.length == 1) {
            List<String> playerNames = new ArrayList<>();
            Player[] players = new Player[Bukkit.getServer().getOnlinePlayers().size()];
            Bukkit.getServer().getOnlinePlayers().toArray(players);
            for (Player player : players) {
                playerNames.add(player.getName());
            }

            return playerNames;
        }

        return null;

    }
}

