package engine.inventory;

import java.util.ArrayList;
import java.util.Objects;

public class Inventory extends Object{
    //HashMap<String,ArrayList<Item>> items = new HashMap<String,ArrayList<Item>>();
    private int MAX_INVENTORY_SIZE = 10;
    private Item[] items = new Item[MAX_INVENTORY_SIZE];
    int ID;
    String name;
    int price;
    int quantity;

    Inventory() {
        ID = 0;
    }

    public Inventory(String ItemName, int Itemprice, int Itemquantity, int itemID) {
        // this.
    }

    private int findFreeSlot() {
        for (int i = 0; i < items.length; i++) {
            if (items[i] == null) {
                return i;
            }
        }
        return -1;
    }

    public void AddItem(Item item) {
        int slot = findFreeSlot();
        if (slot >= 0) {
            items[slot] = item;
        } else System.out.println("No more Free Space");
    }

    public void removeItem(String name) {
      /*
  }
    for (int i=0;i<items.length;i++) {
      if (items[i].equals(item)) {
        Item temp = items[i];
        items[i] = null;
        return temp;
      }
    }
    return null
    */
    }

    //public int getItems() {
    //}
}