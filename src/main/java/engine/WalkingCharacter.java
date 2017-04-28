/**
 * Created by david munson on 4/25/17.
 */
public class WalkingCharacter extends MDecorator {
    

    public WalkingCharacter(int sprite, int height, int width, boolean solid,double direction, double xVelocity, double yVelocity)
    {
        super(sprite, height, width, solid, direction, xVelocity, yVelocity);
    }

    public void move()
    {
        double newXposition = this.getPosition().getX() + this.getxVelocity();
        double newYposition = this.getPosition().getY() + this.getyVelocity();

        this.getPosition().setX(newXposition);
        this.getPosition().setY((newYposition));

        this.setxVelocity(0.0);
        this.setyVelocity(0.0);
    }

    public Location drill()
    {
        return this.getPosition();
    }
}
