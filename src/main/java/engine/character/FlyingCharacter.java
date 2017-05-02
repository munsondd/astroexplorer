package engine.character;

import engine.entity.MDecorator;
import engine.entity.MovableEntity;
import engine.world.Location;

public class FlyingCharacter extends MDecorator {

    private final int OXYGEN_DEPLETION = 2;
    private final int FUEL_DEPLETION = 2;
    private final int HEALTH_DEPLETION = 2;
    private double propulsion = 0;

    public FlyingCharacter(Location position, int height, int width, MovableEntity cmp) {
        super(position, height, width, true, cmp);
    }

    public FlyingCharacter(Location position, int height, int width, MovableEntity cmp, double propulsionPower) {
        super(position, height, width, true, cmp);
        this.propulsion = propulsionPower;
    }

    public FlyingCharacter(int sprite, int height, int width, boolean solid, double direction, double velocityX, double velocityY, double propulsionPower) {
        super(sprite, height, width, solid, direction, velocityX, velocityY);
        this.propulsion = propulsionPower;
    }

    public void setPropulsion(double propulsion) {
        this.propulsion = propulsion;
    }

    public double getPropulsion() {
        return this.propulsion;
    }

    public void move() {
        Location loc = this.getPosition();
        loc.add(this.getVelocityX(), this.getVelocityY());

        Character ch = (Character) this.getCmp();
        Statistics cstats = ch.getStatistics();
        cstats.modifyFuel(-FUEL_DEPLETION);
        if (cstats.getOxygen() > 0) cstats.modifyOxygen(-OXYGEN_DEPLETION);
        else cstats.modifyHealth(-HEALTH_DEPLETION);
    }

    public void propel() {
        double vx =  this.propulsion * Math.cos(this.getDirection());
        double vy  = this.propulsion * Math.sin(this.getDirection());
        this.addVelocity(vx, vy);
    }

    public String toString() {
        String str = "you are currently flying through space!\n" +
                "Velocity: X = " + this.getCmp().getVelocityX() + " Y = " + this.getCmp().getVelocityY() + "\n" +
                "Position: X = "+ this.getPosition().getX() + " Y = " + this.getPosition().getY() + "\n";
        return str;
    }

}
