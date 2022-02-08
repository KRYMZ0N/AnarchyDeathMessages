package me.krymz0n.anarchydeathmessages.listener;

import me.krymz0n.anarchydeathmessages.Main;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.util.Objects;

public class Sword implements Listener {
    private final Main plugin;

    public Sword(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent evt) {
        if (Objects.requireNonNull(evt.getEntity().getLastDamageCause()).getCause() == EntityDamageEvent.DamageCause.ENTITY_ATTACK) {
            evt.setDeathMessage(ChatColor.DARK_RED + evt.getEntity().getName() + ChatColor.DARK_GRAY + " has been blown up by " + ChatColor.DARK_RED + Objects.requireNonNull(evt.getEntity().getKiller()).getName());
        }
    }
}
