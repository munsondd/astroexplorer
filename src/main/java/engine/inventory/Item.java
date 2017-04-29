package engine.inventory;

public class Item extends Inventory implements Cloneable{
	//private int maxItems = 10;
    private int type, sprite, quantity;

    public Item(int t, int s){
        this.type = t;
        this.sprite = s;
    }
    public Item clone()throws CloneNotSupportedException{
        return (Item)super.clone();
    }
    public int GetQuantity(){
        return this.quantity;
    }
    public void SetQuantity(int q) {
        this.quantity = q;
    }

    }