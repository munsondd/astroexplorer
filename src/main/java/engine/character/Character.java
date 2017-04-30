package engine.character;

import engine.entity.MovableEntity;
import engine.inventory.Inventory;

public class Character extends MovableEntity {

    private String name;
    private int playTime;
    private Inventory backpack;
    private Statistics stats;

    public Character(int sprite, int height, int width, boolean solid, double direction) {
        super(sprite, height, width, solid, direction);
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
