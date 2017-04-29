package engine.inventory;

import java.util.ArrayList;

public class Inventory {
    //private int MAX_INVENTORY_SIZE = 10;
    ArrayList<Item> items = new ArrayList<Item>();

    public Inventory() {
    }
    public ArrayList<Item> getItems() {
        return items;
    }
    public void addItem(Item item) { items.add(item);}
    public void RemoveItem(Item item) { items.remove(item);}
    public int clear() {
        items.clear();
        return 1;
    }

}