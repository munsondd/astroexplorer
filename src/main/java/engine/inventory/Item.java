package engine.inventory;

public class Item implements Cloneable{
	//private int maxItems = 10;
    private int type, quantity;

    public Item(int t, int q){
        this.type = t;
        this.quantity = q;
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

    public int GetType(){
        return this.type;
    }
    public void SetType(int t) {
        this.type = t;
    }

    }