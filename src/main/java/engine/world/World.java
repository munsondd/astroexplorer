package engine.world;

import engine.tile.Tile;

import java.util.ArrayList;
import java.util.List;

public class World {

    // Currently going to use ArrayList, can change to just array if needed
	private List<List<Tile>> tiles;
	private long time;
	
	public void init(WorldGenerator wgen) {
		this.time = 0;
		World w = wgen.generate();
		this.tiles = w.getTiles();
	}
	
	public List<List<Tile>> getTiles()
	{
		return this.tiles;
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
