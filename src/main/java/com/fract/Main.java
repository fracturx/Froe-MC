package com.fract;

import com.fract.spigotcommands.RequestCoords;
import com.fract.spigotcommands.ShareCoords;
import org.bukkit.plugin.java.JavaPlugin;

import javax.security.auth.login.LoginException;


public class Main extends JavaPlugin {






    public void onEnable() {
        getLogger().info("Command is up and running.");
        this.getCommand("sharecoords").setExecutor(new ShareCoords());
        this.getCommand("requestcoords").setExecutor(new RequestCoords());


        new jdamessage(this);
        try {
            jdamessage.startBot();
        } catch (LoginException e) {
            e.printStackTrace();
        }


    }

    public void onDisable() {

    }
}


