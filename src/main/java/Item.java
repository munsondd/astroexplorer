class Item {
	private int maxItems = 10;
        Item[] itemList = new Item[maxItems];

	private int id;
	String name;
	int price;
	int quantity;

	Item(){
    	id = 0;
  	}
  	private Item(String name,int price,int quantity) {
	    this.name = name;
	    this.price = price;
	    this.quantity = quantity;
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