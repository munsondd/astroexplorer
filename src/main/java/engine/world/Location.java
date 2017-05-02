package engine.world;

public class Location {

    private double x;
    private double y;
    private World world;

    public Location(double x, double y, World world) {
        this.x = x;
        this.y = y;
        this.world = world;
    }

    public double distance(Location l) {
        double xSquared = Math.pow(l.getX() - this.x, 2);
        double ySquared = Math.pow(l.getY() - this.y, 2);
        return Math.sqrt(xSquared + ySquared);
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void addX(double x) {
        this.x += x;
    }

    public void addY(double y) {
        this.y += y;
    }

    public void add(double x, double y) {
        this.x += x;
        this.y += y;
    }

    public void add(double n) {
        this.x += n;
        this.y += n;
    }

    public void setWorld(World world) {
        this.world = world;
    }

    public World getWorld() {
        return this.world;
    }

    public Location clone() {
        return new Location(this.x, this.y, this.world);
    }

}
