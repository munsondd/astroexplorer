/**
 * Created by david on 4/25/17.
 */
public abstract class MovableEntity extends Entity {

    private double direction;
    private double velocity;

    public MovableEntity(int sprite, int height, int width, boolean solid,double direction, double velocity)
    {
        super(sprite, height, width, solid);
        this.direction = direction;
        this.velocity = velocity;
    }

    public abstract void move();

    public double getDirection()
    {
        return this.direction;
    }

    public double getVelocity()
    {
        return this.velocity;
    }

    public void setDireciton(double direciton)
    {
        this.direction = direction;
    }

    public void setVelocity(double velocity)
    {
        this.velocity = velocity;
    }


}
