package engine.tile;

import engine.world.WorldGenerator;

public class TileContext {
	
	private WorldGenerator w;
	private Tile tile;
	
	public TileContext(Tile t)
	{
		this.tile = t;
	}
	
	public Tile nextTile(int type) {
		return null;
	}

}
