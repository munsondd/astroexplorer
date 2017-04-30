package engine.entity;

public abstract class MovableEntity extends Entity {

    private double velocityX = 0;
    private double velocityY = 0;
    private double direction;

    public MovableEntity(int sprite, int height, int width, boolean solid, double direction) {
        super(sprite, height, width, solid);
        this.direction = direction;
    }

    public MovableEntity(int sprite, int height, int width, boolean solid, double direction, double velocityX, double velocityY) {
        super(sprite, height, width, solid);
        this.direction = direction;
        this.velocityX = velocityX;
        this.velocityY = velocityY;
    }

    public abstract void move();

    public double getVelocityX() {
        return this.velocityX;
    }

    public void setVelocityX(double xVelocity) {
        this.velocityX = xVelocity;
    }

    public double getVelocityY() {
        return this.velocityY;
    }

    public void setVelocityY(double velocityY) {
        this.velocityY = velocityY;
    }

    public void setVelocity(double velocityX, double velocityY) {
        this.velocityX = velocityX;
        this.velocityY = velocityY;
    }

    public double getDirection() {
        return this.direction;
    }

    public void setDirection(double direction) {
        this.direction = direction;
    }

}
