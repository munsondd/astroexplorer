package engine.tile;

public class Tile implements ITile {

	private int type;
	private int sprite;
	private boolean solid;

	public Tile(int type) {
		this.type = type;
	}

	public Tile(int type, int sprite, boolean solid) {
		this.type = type;
		this.sprite = sprite;
		this.solid = solid;
	}
	
	public boolean isSolid() {
		return this.solid;
	}
	
	public int getType()
	{
		return this.type;
	}
	
	public void setType(int type)
	{
		this.type = type;
	}
	
	public int getSprite()
	{
		return this.sprite;
	}
	
	public void setSprite(int sprite)
	{
		this.sprite = sprite;
	}
	
	public void setSolid(boolean solid)
	{
		this.solid = solid;
	}
	
	public void pop(TileContext ctx) {
		ctx.nextTile(this.type);
	}

}
