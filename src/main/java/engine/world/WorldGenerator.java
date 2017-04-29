package engine.world;

import engine.tile.TileFactory;

public abstract class WorldGenerator {
	
	private TileFactory factory;
	
	public abstract World generate();

}
