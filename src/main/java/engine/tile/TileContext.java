package engine.tile;

import engine.world.WorldGenerator;

public class TileContext {
	
	private WorldGenerator w;
	private Tile tile;
	
	public TileContext(Tile t)
	{
		this.tile = t;
	}
	
	public Tile nextTile() {
		return w.getFactory().getTile(this.tile.getType());
	}

}
