/*
 * Created by Michael on 4/25/2017
 */
public class Tile implements ITile {
	private int type;
	private int sprite;
	private boolean solid;
	
	public boolean isSolid()
	{
		return this.solid;
	}
	
	public void pop(TileContext ctx)
	{
		
	}
}
