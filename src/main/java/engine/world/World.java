package engine.world;

import engine.tile.Tile;

import java.util.ArrayList;
import java.util.List;

public class World {

    // Currently going to use ArrayList, can change to just array if needed
	private List<List<Tile>> tiles;
	private long time;
	
	public void init(WorldGenerator wgen) {
		
	}
	
	public long getTime() {
		return this.time;
	}
	
	public void setTime(long time) {
		this.time = time;
	}
	
	public void addTime(long dur) {
		this.time += dur;
	}
}
