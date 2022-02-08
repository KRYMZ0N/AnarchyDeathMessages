package me.krymz0n.anarchydeathmessages.listener;

import me.krymz0n.anarchydeathmessages.Main;
import me.krymz0n.anarchydeathmessages.util.Util;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Mob;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.util.Locale;
import java.util.Objects;

public class MobDeath implements Listener {
    private final Main plugin;
    Util u = new Util();

    public MobDeath(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent evt) {
        Player p = evt.getEntity();
        p.sendMessage("called event");
        switch (p.getLastDamageCause().getEntity().getType()) {
            case ZOMBIE: {
                p.sendMessage("zom");
                evt.setDeathMessage(u.chat(plugin.getConfig().getString("PrimaryColor") + p.getName() + plugin.getConfig().getString("SecondaryColor") + " was killed by a Zombie"));
                break;
            }
            case SKELETON: {
                p.sendMessage("skel");
                evt.setDeathMessage(u.chat(plugin.getConfig().getString("PrimaryColor") + p.getName() + plugin.getConfig().getString("SecondaryColor") + " was killed by a skeleton"));
                break;
            }

            case PLAYER: {
                Player killer = evt.getEntity().getKiller();
                p.sendMessage("player?");
                evt.setDeathMessage((u.chat(plugin.getConfig().getString("PrimaryColor") + p.getName() + plugin.getConfig().getString("SecondaryColor") + " was killed by " + plugin.getConfig().getString("PrimaryColor") + killer.getName() + plugin.getConfig().getString("SecondaryColor") + " using " + plugin.getConfig().getString("PrimaryColor") + killer.getActiveItem().getType().name().toLowerCase(Locale.ROOT))));
                break;
            }

            default: {
                p.sendMessage("should default");
                evt.setDeathMessage(u.chat(plugin.getConfig().getString("PrimaryColor") + p.getName() + plugin.getConfig().getString("SecondaryColor") + "Died from unknown causes!"));
                break;
            }
        }
    }
}
