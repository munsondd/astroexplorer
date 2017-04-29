package engine.tile;

import java.util.HashMap;
import java.util.Map;

public class TileFactory {
	
	private HashMap<Integer, Tile> types;
	
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
