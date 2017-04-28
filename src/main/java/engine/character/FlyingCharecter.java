package engine.character;

import engine.entity.MDecorator;

public class FlyingCharecter extends MDecorator {


    private double propulsionPower;

    public FlyingCharecter(int sprite, int height, int width, boolean solid,double direction, double xVelocity, double yVelocity, double propulsionPower)
    {
        super(sprite, height, width, solid, direction, xVelocity, yVelocity);
        this.propulsionPower = propulsionPower;
    }

    public void setPropultionPower(double propultionPower)
    {
        this.propulsionPower = propultionPower;
    }
    public void move()
    {
        double newXposition = this.getPosition().getX() + this.getxVelocity();
        double newYposition = this.getPosition().getY() + this.getyVelocity();

        this.getPosition().setX(newXposition);
        this.getPosition().setY((newYposition));

    }
    public void propel()
    {
        double newXvelocity = this.getxVelocity() + (this.propulsionPower * Math.cos(this.getDirection()));
        double newYvelocity = this.getyVelocity() + (this.propulsionPower * Math.sin(this.getDirection()));
        this.setVelocity(newXvelocity, newYvelocity);
    }
}
