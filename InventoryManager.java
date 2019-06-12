package skyblock.inventory;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import skyblock.inventory.listeners.InventoryHandlers;

import java.util.HashMap;

public class InventoryManager {

    /*
        Single inventory.
        This API. Which can create own inventory. One inventory on each player.
     */

    private Plugin plugin;
    public InventoryManager(Plugin plugin) {
        this.plugin = plugin;
    }

    private HashMap<Player, CustomInventory> inventories = new HashMap<>();

    public CustomInventory createCustomInventory(Player player, CustomInventory customInventory) {
        inventories.put(player, customInventory);
        return customInventory;
    }

    public void removeCustomInventory(Player player) {
        inventories.remove(player);
    }

    public CustomInventory getCustomInventory(Player player) {
        return inventories.get(player);
    }

    public boolean hasCustomInventory(Player player) {
        return inventories.containsKey(player);
    }

    public void registerHandlers() {
        Bukkit.getPluginManager().registerEvents(new InventoryHandlers(this), plugin);
    }

}
