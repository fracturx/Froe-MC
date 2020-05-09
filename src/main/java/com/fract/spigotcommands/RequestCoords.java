package com.fract.spigotcommands;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;


import org.bukkit.command.Command;

import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.bukkit.Bukkit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import java.util.ArrayList;
import java.util.List;

import net.md_5.bungee.api.ChatColor;


public class RequestCoords implements TabExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {

        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (args.length > 0) {
                Player target = Bukkit.getServer().getPlayer(args[0]);
                if (target != null) {


                    TextComponent message = new TextComponent(ChatColor.DARK_PURPLE  + p.getName() + ChatColor.GREEN + " is requesting your coordinates. Would you like to share your coordinates with " + ChatColor.DARK_PURPLE + p.getName() + "?");
                    message.setUnderlined(true);
                    message.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/sharecoords " + p.getName()));
                    message.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT,
                            new ComponentBuilder("Are you sure you want to share your coordinates with this player?").color(ChatColor.DARK_RED).italic(true).create()));

                    target.spigot().sendMessage(message);
                }
            } else {
                p.sendMessage("No player specified to send the data to.");
                p.sendMessage("/requestcoords [playerName]");
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
