package engine.inventory;
import java.util.ArrayList;

public class Shop extends Inventory {
    private int timesOpened;
    private Inventory items;

    public void SetTimesOpened() {
        this.timesOpened++;
    }
    public int GetAccessCount() {
        return this.timesOpened;
    }
    /*
    public boolean BuyItem(items i) {
        if (items.contains()
    } // No idea about this and sell
    */

}