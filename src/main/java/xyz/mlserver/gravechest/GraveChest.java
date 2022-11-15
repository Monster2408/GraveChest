package xyz.mlserver.gravechest;

import org.bukkit.plugin.java.JavaPlugin;
import xyz.mlserver.gravechest.listeners.BukkitDeathEvent;

public final class GraveChest extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new BukkitDeathEvent(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
