package me.krymz0n.anarchydeathmessages.listener;

import me.krymz0n.anarchydeathmessages.Main;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Mob;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.util.Objects;

public class MobDeath implements Listener {
    private final Main plugin;

    public MobDeath(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent evt) {
        Player p = evt.getEntity();

        switch (Objects.requireNonNull(p.getKiller()).getType()) {
            case ZOMBIE:
                evt.setDeathMessage(p.getName() + " was killed by a zombie");
                break;
            case SKELETON:
                evt.setDeathMessage(p.getName() + " was killed by a skeleton");
        }
    }
}
