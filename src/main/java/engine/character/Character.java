package engine.character;


import engine.entity.MovableEntity;
import engine.inventory.Inventory;

public class Character extends MovableEntity {

    private String name;
    private int playTime;
    private Inventory backpack;
    private Statistics stats;

    public Character(int sprite, int height, int width, boolean solid, double direction, String name) {
        super(sprite, height, width, solid, direction);
        this.name = name;
         this.playTime = 0;
         this.backpack = new Inventory();
         this.stats = new Statistics();


    }
    public Character(int sprite, int height, int width, boolean solid, double direction, String name, int playTime, Inventory backpack, Statistics stats) {
        super(sprite, height, width, solid, direction);
        this.name = name;
        this.playTime = playTime;
        this.stats = stats;

    }

    public void move() {

    }

    public String getName() {
        return this.name;
    }

    public int getPlayTime() {
        return this.playTime;
    }

    public Inventory getBackpack() {
        return this.backpack;
    }

    public Statistics getStatistics() {
        return this.stats;
    }

}
