package me.krymz0n.anarchydeathmessages.listener;

import me.krymz0n.anarchydeathmessages.Main;
import me.krymz0n.anarchydeathmessages.util.Util;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Mob;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
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
    public void onPlayerDeath(EntityDamageByEntityEvent evt) {
        if (evt.getEntity() instanceof Player) {
            Player p = (Player) evt.getEntity();
            if (evt.getDamage() > p.getHealth()) {
                p.sendMessage("called event");
                switch (evt.getDamager().getType()) {
                    case ZOMBIE: {
                        p.sendMessage("zom");
                        Bukkit.broadcastMessage(u.chat(plugin.getConfig().getString("PrimaryColor") + p.getName() + plugin.getConfig().getString("SecondaryColor") + " was killed by a Zombie"));
                        break;
                    }
                    case SKELETON: {
                        p.sendMessage("skel");
                        Bukkit.broadcastMessage(u.chat(plugin.getConfig().getString("PrimaryColor") + p.getName() + plugin.getConfig().getString("SecondaryColor") + " was killed by a skeleton"));
                        break;
                    }

                    case PLAYER: {
                        Player killer = (Player) evt.getEntity().getLastDamageCause().getEntity();
                        p.sendMessage("player?");
                        Bukkit.broadcastMessage((u.chat(plugin.getConfig().getString("PrimaryColor") + p.getName() + plugin.getConfig().getString("SecondaryColor") + " was killed by " + plugin.getConfig().getString("PrimaryColor") + killer.getName() + plugin.getConfig().getString("SecondaryColor") + " using " + plugin.getConfig().getString("PrimaryColor") + killer.getActiveItem().getType().name().toLowerCase(Locale.ROOT))));
                        break;
                    }

                    case ARROW:
                        evt.getEntity().getLau

                    default: {
                        p.sendMessage("should default");
                        Bukkit.broadcastMessage(u.chat(plugin.getConfig().getString("PrimaryColor") + p.getName() + plugin.getConfig().getString("SecondaryColor") + "Died from unknown causes!"));
                        break;
                    }
                }
            }
        }
    }

    @EventHandler
    public void onDeath(PlayerDeathEvent evt) {
        evt.setDeathMessage("");
    }
}
