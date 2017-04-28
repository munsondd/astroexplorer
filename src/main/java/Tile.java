/*
 * Created by Michael on 4/25/2017
 */
public class Tile implements ITile {
	private int type;
	private int sprite;
	private boolean solid;

	public Tile(int type)
	{
		this.type = type;
	}
	public Tile(int type, int sprite, boolean solid)
	{
		this.type =type;
		this.sprite = sprite;
		this.solid = solid;
	}
	
	public boolean isSolid()
	{
		return this.solid;
	}
	
	public void pop(TileContext ctx)
	{
		
	}
}
