package engine.inventory;

public class Item implements Cloneable {

    private String name;
    private int type, quantity;

    public Item(String name, int type, int quantity) {
        this.name = name;
        this.type = type;
        this.quantity = quantity;
    }

    public int getQuantity(){
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void addQuantity(int add) {
        this.quantity += add;
    }

    public int getType(){
        return this.type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Item clone() {
        return new Item(this.name, this.type, this.quantity);
    }

}