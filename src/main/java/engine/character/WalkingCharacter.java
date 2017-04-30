package engine.character;

import engine.entity.MDecorator;
import engine.world.Location;

public class WalkingCharacter extends MDecorator {

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
    }

    public Location drill() {
        return this.getPosition();
    }

}
