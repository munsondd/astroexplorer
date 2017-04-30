package engine.inventory;

import engine.entity.Entity;

public class Shop extends Entity {

    private Inventory items;
    private int timesOpened;

    public Shop(int sprite, int height, int width, boolean solid) {
        super(sprite, height, width, solid);
    }

    public boolean buyItem(Item i) {
        return this.items.removeItem(i);
    }

    public boolean sellItem(Item i) {
        return this.items.addItem(i);
    }

    public int getAccessCount() {
        return this.timesOpened;
    }

}
