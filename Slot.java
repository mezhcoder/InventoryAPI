package skyblock.inventory;

import org.bukkit.inventory.ItemStack;

public abstract class Slot {

    private int numberSlot;
    private ItemStack itemStack;

    public Slot(int numberSlot, ItemStack itemStack) {
        this.numberSlot = numberSlot;
        this.itemStack = itemStack;
    }

    public abstract void execute();

    public int getNumberSlot() {
        return numberSlot;
    }

    public ItemStack getItemStack() {
        return itemStack;
    }
}
