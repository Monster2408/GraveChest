package xyz.mlserver.gravechest.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class BukkitDeathEvent implements Listener {

    @EventHandler
    public void on(PlayerDeathEvent e) {
        Player player = e.getEntity();
        if (e.getKeepInventory()) {
            return;
        }

    }

}
