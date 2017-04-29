package engine.inventory;

public class Item extends Inventory implements Cloneable{
	//private int maxItems = 10;
    private int type, sprite, quantity;

    public Item(int type, int sprite){
        this.type = type;
        this.sprite = sprite;
    }
    public Item clone()throws CloneNotSupportedException{
        return (Item)super.clone();
    }
    public int GetQuantity(){
    return quantity;
  }

    public void SetQuantity(int q) {
        this.quantity = q;
    }


    }