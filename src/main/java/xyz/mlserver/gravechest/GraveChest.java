package xyz.mlserver.gravechest;

import org.bukkit.plugin.java.JavaPlugin;
import xyz.mlserver.gravechest.listeners.BukkitDeathEvent;

public final class GraveChest extends JavaPlugin {

    public static JavaPlugin plugin;

    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;

        getServer().getPluginManager().registerEvents(new BukkitDeathEvent(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
