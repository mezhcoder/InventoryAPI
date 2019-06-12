package skyblock.inventory;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public class CustomInventory {

    private HashMap<Integer, Slot> slots = new HashMap<>();

    private String title;
    private Player owner;

    public CustomInventory(String title, Player owner) {
        this.title = title;
        this.owner = owner;
    }


    public void setSlot(Slot slot) {
        slots.put(slot.getNumberSlot(), slot);
    }


    public void removeSlot(int numberSlot) {
        slots.remove(numberSlot);
    }

    public boolean haveSlot(int numberSlot) {
        return slots.containsKey(numberSlot);
    }

    public String getTitle() {
        return title;
    }

    public Player getOwner() {
        return owner;
    }

    public Slot getSlot(int numberSlot) {
        return slots.get(numberSlot);
    }


    public Inventory createInventory() {
        Inventory inventory = Bukkit.createInventory(owner, InventoryType.CHEST, title);;
        for (Slot slot : slots.values()) {
            ItemStack itemStack = slot.getItemStack();
            if (itemStack == null) {
                continue;
            }
            int numberSlot = slot.getNumberSlot();
            inventory.setItem(numberSlot, itemStack);
        }
        return inventory;
    }

}
