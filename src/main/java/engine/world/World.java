package engine.world;

import engine.tile.Tile;

import java.util.ArrayList;
import java.util.List;

public class World {

	private List<List<Tile>> tiles;
	private long time;

    public World() {
        this.tiles = new ArrayList<>();
        this.time = 0L;
    }
    
    public World(List<List<Tile>> tiles)
    {
    	this.tiles = tiles;
    }
	
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
