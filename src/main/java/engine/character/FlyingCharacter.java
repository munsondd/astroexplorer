package engine.character;

import engine.entity.MDecorator;
import engine.entity.MovableEntity;
import engine.world.Location;

public class FlyingCharacter extends MDecorator {

    private final int OXYGEN_DEPLETION = 2;
    private final int FUEL_DEPLETION = 2;
    private final int HEALTH_DEPLETION = 2;

    private double propulsionPower = 0;

    public FlyingCharacter(Location position, int height, int width, MovableEntity cmp) {
        super(position,height,width, true,cmp);
    }

    public FlyingCharacter(Location position, int height, int width, MovableEntity cmp, double propulsionPower){
        super(position, height, width, true, cmp);
        this.propulsionPower = propulsionPower;
    }

    public FlyingCharacter(int sprite, int height, int width, boolean solid, double direction, double xVelocity, double yVelocity, double propulsionPower) {
        super(sprite, height, width, solid, direction, xVelocity, yVelocity);
        this.propulsionPower = propulsionPower;
    }

    public void setPropulsionPower(double propultionPower) {
        this.propulsionPower = propultionPower;
    }

    public void move() {
        Location loc = this.getPosition();

        double newXposition = loc.getX() + this.getVelocityX();
        double newYposition = loc.getY() + this.getVelocityY();

        loc.setX(newXposition);
        loc.setY((newYposition));

        Character ch = (Character) this.getCmp();
        Statistics cstats = ch.getStatistics();
        cstats.setFuel(cstats.getFuel() - FUEL_DEPLETION);
        if (cstats.getOxygen() > 0)
            cstats.setOxygen(cstats.getOxygen() - OXYGEN_DEPLETION);
        else
            cstats.setHealth(cstats.getHealth() - HEALTH_DEPLETION);
    }

    public void propel() {
        double newVelocityX = this.getVelocityX() + (this.propulsionPower * Math.cos(this.getDirection()));
        double newVelocityY = this.getVelocityY() + (this.propulsionPower * Math.sin(this.getDirection()));
        this.setVelocity(newVelocityX, newVelocityY);
    }

    public String toString() {
        String str = "you are currently flying through space!\n" +
                "Velocity: X = " + this.getCmp().getVelocityX() + " Y = " + this.getCmp().getVelocityY() + "\n" +
                "Position: X = "+ this.getPosition().getX() + " Y = " + this.getPosition().getY() + "\n";
        return str;
    }

}
