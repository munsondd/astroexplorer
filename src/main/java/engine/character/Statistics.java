package engine.character;

public class Statistics {
    private double fuel, health, oxygen;
    private int Inventorysize;

    public double getFuel() {
        return this.fuel;
    }
    public void setFuel(double f) {
        this.fuel = f;
    }
    public double getHealth() {
        return this.health;
    }
    public void setHealth(double h) {
        this.health = h;
    }
    public double getOxygen() {
        return this.oxygen;
    }
    public void setOxygen(double o) {
        this.oxygen = o;
    }

    public int getInventorysize() {
        return this.Inventorysize;
    }
    public void setInventorysize(double i) {
        this.fuel = i;
    }
    public void reset() {
        fuel = 100;
        health = 100;
        oxygen = 100;
        Inventorysize = 10;
    }

}