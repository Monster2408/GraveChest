package xyz.mlserver.gravechest.utils.api;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;
import xyz.mlserver.gravechest.GraveChest;
import xyz.mlserver.gravechest.utils.Var;

import java.util.HashMap;
import java.util.List;

public class GraveAPI {

    private static BukkitTask graveTask;

    public static void setGraveChest(Player player, List<ItemStack> drops) {
        if (Var.graveItemStack == null) Var.graveItemStack = new HashMap<>();
        if (Var.gravePlayerUuid == null) Var.gravePlayerUuid = new HashMap<>();
        if (Var.graveGraveDeleteTime == null) Var.graveGraveDeleteTime = new HashMap<>();

        Location graveLoc = player.getLocation().clone();
        if (graveLoc.getY() <= 0) return; // 奈落死なら無視

        for (int n = 3; n > 0; n--) {
            Location tempLoc = graveLoc.clone();
            tempLoc.setY(tempLoc.getY() + 1);
            if (graveLoc.getBlock().getType() != Material.CHEST && tempLoc.getBlock().getType() == Material.AIR) {

            }
        }

        if (graveTask == null || graveTask.isCancelled()) {
            graveTask = new BukkitRunnable() {
                @Override
                public void run() {
                    if (Var.graveGraveDeleteTime.keySet().size() == 0) {
                        this.cancel();
                        return;
                    }
                    for (Location key : Var.graveGraveDeleteTime.keySet()) {
                        if (Var.graveGraveDeleteTime.get(key) <= 0) {
                            key.getBlock().breakNaturally();
                            Var.graveItemStack.remove(key);
                            Var.graveGraveDeleteTime.remove(key);
                            if (Bukkit.getPlayer(Var.gravePlayerUuid.get(key)) == null) {
                                Bukkit.getPlayer(Var.gravePlayerUuid.get(key)).sendMessage(ChatColor.RED + "You lost death item drops.");
                            }
                            Var.gravePlayerUuid.remove(key);
                        } else {
                            int temp = Var.graveGraveDeleteTime.get(key) - 1;
                            Var.graveGraveDeleteTime.put(key, temp);
                        }
                    }
                }
            }.runTaskTimer(GraveChest.plugin, 20L, 0L);
        }
    }

}
