package engine.entity;

public abstract class MDecorator extends MovableEntity {

    private MovableEntity cmp;

    public MDecorator(int sprite, int height, int width, boolean solid, double direction, double xVelocity, double yVeleocity)
    {
        super(sprite, height, width, solid, direction, xVelocity, yVeleocity);
    }

    public abstract void move();

}
