package engine.inventory;

import engine.entity.Entity;

public class Item{
	private int maxItems = 10;
    private int type, sprite, quantity, price;
    String name;
    private int ID;
    //Item[] itemList = new Item[maxItems];

    public Item(int type, int sprite){
        this.type = type;
        this.sprite = sprite;
    }
    Item[] itemList = new Item[maxItems];

    /*
    public Item(int itemID, String Itemname, int ItemPrice,int Itemquantity) {
        ID = itemID;
        name = Itemname;
        price = ItemPrice;
        quantity = Itemquantity;
    }
    */
    public int GetQuantity(){
    return quantity;
  }

    public void SetQuantity(int sprite,int q) {
        for(int i = 1; i <= 10; i++){
            if(sprite == this.sprite) {
                this.quantity = this.quantity + q;
            }
        }
        this.quantity = q++;
    }
  	
	void FindItem(int id){
      System.out.println(itemList[id].ID + " " + itemList[id].name + " " +
                    itemList[id].price + " " + itemList[id].quantity);
        }
    void displayItemList(){
        /*
        System.out.println("ID " + "Name " + "Price " + "Quantity ");
        for (int i = 0; i < id; i++){
            System.out.println(itemDB[i].id + " " + itemDB[i].name + " " +
                    itemDB[i].price + " " + itemDB[i].quantity);
        }
        */
    }
  }