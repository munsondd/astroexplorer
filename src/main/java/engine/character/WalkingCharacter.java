package engine.character;

import engine.entity.MDecorator;
import engine.entity.MovableEntity;
import engine.world.Location;

public class WalkingCharacter extends MDecorator {

    private final int OXYGEN_DEPLETION = 2;
    private final int FUEL_DEPLETION = 2;
    private final int HEALTH_DEPLETION = 2;

    public WalkingCharacter(Location position, int height, int width, MovableEntity cmp){
        super(position, height, width, true, cmp);
    }

    public WalkingCharacter(int sprite, int height, int width, boolean solid,double direction, double velocityX, double velocityY) {
        super(sprite, height, width, solid, direction, velocityX, velocityY);
    }

    public void move() {
        Location loc = this.getPosition();

        double newPositionX = loc.getX() + this.getVelocityX();
        double newPositionY = loc.getY() + this.getVelocityY();

        loc.setX(newPositionX);
        loc.setY(newPositionY);

        this.getCmp().setVelocityX(0.0);
        this.getCmp().setVelocityY(0.0);

        Character ch = (Character) this.getCmp();
        Statistics cstats = ch.getStatistics();
        cstats.setFuel(cstats.getFuel() - FUEL_DEPLETION);
        if (cstats.getOxygen() > 0)
            cstats.setOxygen(cstats.getOxygen() - OXYGEN_DEPLETION);
        else
            cstats.setHealth(cstats.getHealth() - HEALTH_DEPLETION);
    }

    public Location drill() {
        return this.getPosition();
    }

    public String toString() {
        String str = "you are currently in terrain mode!\n" +
                "Position: X = " + this.getPosition().getX() + " Y = " + this.getPosition().getY() + "\n";
        return str;
    }

}
