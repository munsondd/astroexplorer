/**
 * Created by david on munson 4/25/17.
 */
public class Entity {
    private Location position;
    private int sprite;
    private int height;
    private int width;
    private boolean solid;

    public Entity(int sprite, int height, int width, boolean solid)
    {
        this.sprite = sprite;
        this.height = height;
        this.width = width;
        this.solid = solid;
    }
    public boolean isSolid()
    {
        return this.solid;
    }

    public Location getPosition()
    {
        return this.position;
    }

    public void setPosition(Location position)
    {
        this.position = position;
    }

    public int getSprite()
    {
        return this.sprite;
    }

    public int getHeight()
    {
        return this.height;
    }
    public int getWidth()
    {
        return this.width;
    }
    public int getArea()
    {
        return this.height * this.width;
    }


}
