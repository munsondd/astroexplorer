package engine.Storage

class Item extends Object{
	private int maxItems = 10;
        Item[] itemList = new Item[maxItems];

	int id;
	String name;
	int price;
	int quantity;

  public Item(int ID, String name, int price,int quantity) {
    id = ID
    name = name;
    price = price;
    this.quantity = quantity;
  }
	Item(){
    	id = 0;
  	}
  GetQuantity(){
    return 
  }
  	
	void FindItem(int id){
      System.out.println(itemList[id].id + " " + itemList[id].name + " " +
                    itemList[id].price + " " + itemList[id].quantity);
        }
    void displayItemList(){
        System.out.println("ID " + "Name " + "Price " + "Quantity ");
        for (int i = 0; i < id; i++){
            System.out.println(itemDB[i].id + " " + itemDB[i].name + " " +
                    itemDB[i].price + " " + itemDB[i].quantity);
        }
    }
  }