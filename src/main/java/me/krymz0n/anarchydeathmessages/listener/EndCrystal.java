package me.krymz0n.anarchydeathmessages.listener;

import me.krymz0n.anarchydeathmessages.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.util.Objects;

public class EndCrystal implements Listener {
    private final Main plugin;

    public EndCrystal(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent evt) {
        if (Objects.requireNonNull(evt.getEntity().getLastDamageCause()).getCause() == EntityDamageEvent.DamageCause.ENTITY_EXPLOSION) {
            evt.setDeathMessage("");
        }
    }
}
