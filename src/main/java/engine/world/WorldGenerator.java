package engine.world;

import engine.tile.TileFactory;

public abstract class WorldGenerator {
	
	private TileFactory factory;
	
	public TileFactory getFactory()
	{
		return factory;
	}
	
	public abstract World generate();

}
