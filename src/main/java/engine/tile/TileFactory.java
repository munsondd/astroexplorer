package engine.tile;

import java.util.HashMap;
import java.util.Map;

public class TileFactory {
	
	private Map<Integer, Tile> types;
	
	/*
	 * Tile Types
	 * 1 = Empty Space
	 * 2 = Asteroid
	 * 3 = Resource
	 * 4 = Ship
	 * 5 = Shop
	 */
	
    public TileFactory() {
        this.types = new HashMap<>();
    }
	
	public Tile getTile(Integer type) {
		if (this.types.containsKey(type)) {
			return types.get(type);
		} else {
			Tile tile = new Tile(type);
			this.types.put(type, tile);
			return tile;
		}
	}
	
	public int getNumTypes() {
		return types.size();
	}

}
