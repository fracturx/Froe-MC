package com.fract.SpigotListeners;

import com.fract.Main;

import com.fract.jdalisteners.DiscordMessage;
import com.fract.jdamessage;
import net.dv8tion.jda.api.JDA;
import org.bukkit.Bukkit;


import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class AsyncChatListener implements Listener {
    private static Main plugin;
    private static JDA jda;

    public AsyncChatListener(Main plugin, JDA api) {
        AsyncChatListener.plugin = plugin;
        AsyncChatListener.jda = api;
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onAsyncPlayerChatEvent(AsyncPlayerChatEvent e) {
        System.out.println("message sent");
        String message = e.getMessage();
        String author = e.getPlayer().getDisplayName();
        //System.out.println(author.getName() + " has said: " + message);
        new DiscordMessage(plugin, jda).chatMessage(author, message);

    }

}
