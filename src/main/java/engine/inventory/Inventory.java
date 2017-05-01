package engine.inventory;

import java.util.ArrayList;
import java.util.List;

public class Inventory extends Item{

    private List<Item> items;

    public Inventory(String name, int type, int quantity) {
        super(name, type, quantity);
        this.items = new ArrayList<>();
    }

    /**
     * Get all the items in this inventory.
     * @return
     */
    public List<Item> getItems() {
        return this.items;
    }

    public String toString(){
        if(!items.isEmpty()) {
            return "BACKPACK\n" +
                    "----------------\n" +
                    getItems();
        }
        else {
            return "Nothing is in your BACKPACK";
        }
    }

    /**
     * Add an item to this inventory.
     * @param item the item to be added
     */
    public boolean addItem(Item item) {
        return this.items.add(item);
    }

    /**
     * Remove an item from this inventory.
     * @param item the item to be removed
     */
    public boolean removeItem(Item item) {
        return this.items.remove(item);
    }

    /**
     * Clears this inventory.
     * @return int the number of items deleted
     */
    public int clear() {
        int l = this.items.size();
        items.clear();
        return l;
    }

}
