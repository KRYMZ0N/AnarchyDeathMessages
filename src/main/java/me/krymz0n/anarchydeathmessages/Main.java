package me.krymz0n.anarchydeathmessages;

import me.krymz0n.anarchydeathmessages.listener.EndCrystal;
import me.krymz0n.anarchydeathmessages.listener.MobDeath;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        PluginManager pm = getServer().getPluginManager();
        saveDefaultConfig();

        pm.registerEvents(this, this);
        //pm.registerEvents(new EndCrystal(this), this);
        pm.registerEvents(new MobDeath(this), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
