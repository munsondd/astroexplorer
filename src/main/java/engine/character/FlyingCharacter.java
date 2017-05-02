package engine.character;

import engine.entity.MDecorator;
import engine.entity.MovableEntity;
import engine.world.Location;

import java.time.Year;

public class FlyingCharacter extends MDecorator {

    private final int OXDEPLETION = 2;
    private final int FUELDEPLETION = 2;
    private final int HEALTHDEPLETION = 2;

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
        double newXposition = this.getPosition().getX() + this.getVelocityX();
        double newYposition = this.getPosition().getY() + this.getVelocityY();

        this.getPosition().setX(newXposition);
        this.getPosition().setY((newYposition));

        Character ch = (Character)this.getCmp();
        ch.getStatistics().setFuel(ch.getStatistics().getFuel() - FUELDEPLETION);
        if(ch.getStatistics().getOxygen()>0)
            ch.getStatistics().setOxygen(ch.getStatistics().getOxygen() - OXDEPLETION);
        else
            ch.getStatistics().setHealth(ch.getStatistics().getHealth() - HEALTHDEPLETION);


    }

    public void propel() {
        double newVelocityX = this.getVelocityX() + (this.propulsionPower * Math.cos(this.getDirection()));
        double newVelocityY = this.getVelocityY() + (this.propulsionPower * Math.sin(this.getDirection()));
        this.setVelocity(newVelocityX, newVelocityY);
    }
    public String toString() {
        String str = "you are currently flying through space!\n" +
                "Velocity: X = " + this.getVelocityX() + " Y = " + this.getVelocityY() + "\n" +
                "Position: X = "+ this.getPosition().getX() + " Y = " + this.getPosition().getY() + "\n";
        return str;
    }
}
