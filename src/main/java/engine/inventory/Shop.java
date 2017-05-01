package engine.inventory;

import java.util.ArrayList;
import engine.character.Statistics;
import engine.entity.Entity;


public class Shop extends Entity {

    private Inventory items;
    private Inventory upgrades;
    private int timesOpened;


    public Shop(int sprite, int height, int width, boolean solid) {
        super(sprite, height, width, solid);
        //this.upgrades = new upgrades();
    }

    public boolean buyItem(Item i) {
        return this.items.removeItem(i);
    }

    public boolean sellItem(Item i) {
        return this.items.addItem(i);
    }

    /*public void upgrade(int type, int level) {
        if(type == 1) {
            Statistics setHealth(upgrades[type][level]);
            System.out.println("your max health is now " + upgrades[type][level]);
        }
        else if(type == 2) {
            Statistics setFuel(upgrades[type][level]);
            System.out.println("your max fuel is now " + upgrades[type][level]);
        }
        else if(type == 3) {
            Statistics setOxygen(upgrades[type][level]);
            System.out.println("your max oxygen is now " + upgrades[type][level]);
        }
    }*/

    public int getAccessCount() {
        return this.timesOpened;
    }

}
