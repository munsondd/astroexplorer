/**
 * Created by david munson on 4/25/17.
 */
public abstract class MovableEntity extends Entity {

    private double xVelocity = 0;
    private double yVelocity = 0;
    private double direction;

    public MovableEntity(int sprite, int height, int width, boolean solid, double direction)
    {
        super(sprite, height, width, solid);
        this.direction = direction;
    }
    public MovableEntity(int sprite, int height, int width, boolean solid, double direction, double xVelocity, double yVelocity)
    {
        super(sprite, height, width, solid);
        this.direction = direction;
        this.xVelocity = xVelocity;
        this.yVelocity = yVelocity;
    }

    public abstract void move();

    public double getxVelocity ()
    {
        return this.xVelocity;
    }

    public void setxVelocity(double xVelocity)
    {
        this.xVelocity = xVelocity;
    }
    public double getyVelocity()
    {
        return this.yVelocity;
    }

    public void setyVelocity(double yVelocity)
    {
        this.yVelocity = yVelocity;
    }

    public void setVelocity(double xVelocity, double yVelocity)
    {
        this.xVelocity = xVelocity;
        this.yVelocity = yVelocity;
    }

    public double getDirection()
    {
        return this.direction;
    }

    public void setDirection(double direction)
    {
        this.direction = direction;
    }



}
