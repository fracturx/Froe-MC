package com.fract;


import com.fract.SpigotListeners.AsyncChatListener;
import com.fract.jdalisteners.DiscordMessage;
import net.dv8tion.jda.api.AccountType;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.hooks.ListenerAdapter;


import javax.security.auth.login.LoginException;


public class jdamessage extends ListenerAdapter {
    public static JDA jda;

    private static Main plugin;

    public jdamessage(Main a)
    {
        plugin = a;
    }

    public static void startBot() throws LoginException {
        System.out.println("works.");

        jda = new JDABuilder(AccountType.BOT)
                .setToken("NzA1NjQ5NDc4NjczMTA0OTc2.Xq8NLA.cYuMlZtM3xwuyfslt-wyuL1596A")
                .build();
        jda.addEventListener(new DiscordMessage(plugin, jda));
        new AsyncChatListener(plugin, jda);

    }



}
