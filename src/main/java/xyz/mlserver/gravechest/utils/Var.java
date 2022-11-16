package xyz.mlserver.gravechest.utils;

import org.bukkit.Location;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class Var {

    public static HashMap<Location, List<ItemStack>> graveItemStack;
    public static HashMap<Location, UUID> gravePlayerUuid;
    public static HashMap<Location, Integer> graveGraveDeleteTime;

}
