package engine.inventory;

import java.util.ArrayList;
import java.util.List;

public class Inventory extends Item{

    private List<Item> items;
    private String name;
    private int type, quantity;

    public Inventory(String name, int type, int quantity) {
        super(name, type, quantity);
        this.items = new ArrayList<>();
    }

    /**
     * Get all the items in this inventory.
     * @return
     */

    public int GetQuantity(Item item) {
        return item.GetQuantity();
    }

    public List<Item> getItems() {
        return this.items;
    }

    public void PrintBack(){
        System.out.println("BACKPACK\n----------------\n");
        if(!items.isEmpty()) {
            for (Item item : items) {
                System.out.println(item.GetName() + "      " + Integer.toString(item.GetQuantity()));
            }
        }
        else {
            System.out.println("Nothing is in your BACKPACK");
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
