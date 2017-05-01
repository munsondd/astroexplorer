package engine.entity;

import engine.world.Location;

public abstract class MDecorator extends MovableEntity {

    private MovableEntity cmp;

    public MDecorator(Location position, int height, int width, boolean solid, MovableEntity cmp)
    {
        super(position,height,width,solid);
        this.cmp = cmp;
    }

    public MDecorator(int sprite, int height, int width, boolean solid, double direction, double xVelocity, double yVeleocity)
    {
        super(sprite, height, width, solid, direction, xVelocity, yVeleocity);
    }

    public abstract void move();

    public MovableEntity getCmp()
    {
        return this.cmp;
    }

}
