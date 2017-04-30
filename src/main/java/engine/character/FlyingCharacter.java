package engine.character;

import engine.entity.MDecorator;

public class FlyingCharacter extends MDecorator {

    private double propulsionPower;

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

    }

    public void propel() {
        double newVelocityX = this.getVelocityX() + (this.propulsionPower * Math.cos(this.getDirection()));
        double newVelocityY = this.getVelocityY() + (this.propulsionPower * Math.sin(this.getDirection()));
        this.setVelocity(newVelocityX, newVelocityY);
    }
}
