package com.fract.jdalisteners;

import com.fract.Main;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.List;
import java.awt.*;
import java.util.ArrayList;


public class DiscordMessage extends ListenerAdapter {


    private static JDA jda;
    private static Main plugin;


    public DiscordMessage(Main plugin, JDA jda)
    {
        DiscordMessage.plugin = plugin;
        DiscordMessage.jda = jda;

    }

    public void message(String author, String msg) {
        Bukkit.getServer().broadcastMessage(ChatColor.GOLD + author + ChatColor.AQUA + msg);
    }

    public void onGuildMessageReceived(GuildMessageReceivedEvent e) {
        if (e.getAuthor().isBot()) return;
        System.out.println("Message Received");

        if (e.getChannel().getName().equals("minecraft")) {
            if (e.getMessage().getContentRaw().equalsIgnoreCase("list")) {
                int numPlayers = Bukkit.getServer().getOnlinePlayers().size();
                List<String> playerList = new ArrayList<>();
                System.out.println('W');

                if (numPlayers == 0) {
                    e.getChannel().sendMessage("No players currently online.");
                    return;
                }

                for (Player p : Bukkit.getServer().getOnlinePlayers()) {
                    playerList.add(p.getName());
                }

                String descriptionList = String.join("\n", playerList);


                EmbedBuilder embedInfo = new EmbedBuilder()
                        .setTitle("Player Info")
                        .addField("Number of Online Players: ", Integer.toString(numPlayers), true)
                        .setDescription(descriptionList);

                e.getChannel().sendMessage(embedInfo.build()).queue();
                return;


            }


            String author= e.getAuthor().getName() + "#" + e.getAuthor().getDiscriminator() + ": ";
            message(author, e.getMessage().getContentRaw());

        }
    }

    public void chatMessage(String author, String message) {
        TextChannel mcChannel = jda.getTextChannelById("705600723089621073");
        assert mcChannel != null;
        EmbedBuilder embed = new EmbedBuilder();
        embed.setTitle(author);
        embed.setColor(new Color(0x03FCCF));
        embed.setDescription(message);
        mcChannel.sendMessage(embed.build()).queue();

    }


}
