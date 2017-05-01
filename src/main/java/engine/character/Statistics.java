package engine.character;

public class Statistics {

    private double fuel, health, oxygen;
    private int inventorySize;

    public double getFuel() {
        return this.fuel;
    }

    public void setFuel(double fuel) {
        this.fuel = fuel;
    }

    public double getHealth() {
        return this.health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public double getOxygen() {
        return this.oxygen;
    }

    public void setOxygen(double oxygen) {
        this.oxygen = oxygen;
    }

    public int getInventorySize() {
        return this.inventorySize;
    }

    public void setInventorySize(int inventorySize) {
        this.inventorySize = inventorySize;
    }

    public boolean GetStats() {
        if(getFuel() == 0 || getHealth() == 0 || getOxygen() == 0) {
            return false;
        }
        else {
            System.out.println("STATS");
            System.out.println("----------------");
            System.out.println("Fuel:" + getFuel());
            System.out.println("Health:" + getHealth());
            System.out.println("Oxygen:" + getOxygen());
            return true;
        }
    }

    public void reset() {
        this.fuel = 100;
        this.health = 100;
        this.oxygen = 100;
        this.inventorySize = 10;
    }

}
