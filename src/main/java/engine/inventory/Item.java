package engine.inventory;

class Item extends Object{
	private int maxItems = 10;
    Item[] itemList = new Item[maxItems];

	int ID;
	String name;
	int price;
	int quantity;

    public Item(int itemID, String Itemname, int Itemprice,int Itemquantity) {
        ID = itemID;
        name = Itemname;
        price = Itemprice;
        quantity = Itemquantity;
    }
    public int GetQuantity(){
    return quantity;
  }

    public void SetQuantity(int q) {
        //is this adding to quantity or subtracting?
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