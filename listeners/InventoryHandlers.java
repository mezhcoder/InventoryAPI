package skyblock.inventory.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import skyblock.inventory.CustomInventory;
import skyblock.inventory.InventoryManager;
import skyblock.inventory.Slot;

public class InventoryHandlers implements Listener {

    private InventoryManager inventoryManager;

    public InventoryHandlers(InventoryManager inventoryManager) {
        this.inventoryManager = inventoryManager;
    }

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        Inventory inventory = e.getInventory();
        Player player = (Player) e.getWhoClicked();

        if (haveCustomInventory( player, inventory )) return;

        CustomInventory customInventory = inventoryManager.getCustomInventory(player);
        int clickedSlot = e.getSlot();

        if (customInventory.haveSlot(clickedSlot)) {
            Slot slot = customInventory.getSlot(clickedSlot);
            slot.execute();
        }
        e.setCancelled(true);

    }

    @EventHandler
    public void onClose(InventoryCloseEvent e) {
        Inventory inventory = e.getInventory();
        Player player = (Player) e.getPlayer();

        if (haveCustomInventory( player, inventory )) return;

        inventoryManager.removeCustomInventory(player);
    }

    private boolean haveCustomInventory(Player player, Inventory inventory) {
        if (!inventoryManager.hasCustomInventory(player)) return true;
        CustomInventory customInventory = inventoryManager.getCustomInventory(player);
        return !customInventory.getTitle().contains( inventory.getTitle() );
    }



}
