/**
 * Created by david on 4/25/17.
 */
public abstract class MDecorator extends MovableEntity {

    private MovableEntity cmp;

    public MDecorator(int sprite, int height, int width, boolean solid,double direction, double velocity)
    {
        super(sprite, height, width, solid, direction, velocity);
    }

    public abstract void move();

}
