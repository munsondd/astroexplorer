package engine.character;

import engine.entity.MDecorator;
import engine.entity.MovableEntity;
import engine.world.Location;

public class WalkingCharacter extends MDecorator {

    private final int OXDEPLETION = 2;
    private final int FUELDEPLETION = 2;
    private final int HEALTHDEPLETION = 2;

    public WalkingCharacter(Location position, int height, int width, MovableEntity cmp){
        super(position, height, width, true, cmp);
    }

    public WalkingCharacter(int sprite, int height, int width, boolean solid,double direction, double xVelocity, double yVelocity) {
        super(sprite, height, width, solid, direction, xVelocity, yVelocity);
    }

    public void move() {

        
        double newPositionX = this.getPosition().getX() + this.getVelocityX();
        double newPositionY = this.getPosition().getY() + this.getVelocityY();

        this.getPosition().setX(newPositionX);
        this.getPosition().setY(newPositionY);

        this.setVelocityX(0.0);
        this.setVelocityY(0.0);

        Character ch = (Character)this.getCmp();
        ch.getStatistics().setFuel(ch.getStatistics().getFuel() - FUELDEPLETION);
        if(ch.getStatistics().getOxygen()>0)
            ch.getStatistics().setOxygen(ch.getStatistics().getOxygen()-OXDEPLETION);
        else
            ch.getStatistics().setHealth(ch.getStatistics().getHealth() - HEALTHDEPLETION);
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
