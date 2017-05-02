package engine.world;

import engine.entity.MovableEntity;
import engine.tile.Tile;

import java.util.ArrayList;
import java.util.List;

public class World {

	private ArrayList<ArrayList<Tile>> tiles = new ArrayList<ArrayList<Tile>>(50);
	private long time;
	private final int worldX = 45;
	private final int worldY = 25;

    public World() {
        this.tiles = new ArrayList<>();
        this.time = 0L;
    }
    
    public World(ArrayList<ArrayList<Tile>> tiles)
    {
    	this.tiles = tiles;
    }
    
    public String display(MovableEntity player) {
		//World String
		String w = "";
		int positionX = (int)player.getPosition().getX();
		int positionY = (int)player.getPosition().getY();
		for(int i = 0; i < this.worldX; i++)
		{
			for(int l = 0; l<this.worldY;l++) w+="+---";
			w+="+\n";
			String row = "";
			for(int j = 0; j < this.worldY; j++)
			{
				int type = this.tiles.get(i).get(j).getType();

				if(i == positionX && j == positionY){
					row += "| @ ";
				}
				else {
					if (type == 1)
						row += "|   ";
					else if (type == 2)
						row += "| A ";
					else if (type == 3)
						row += "| R ";
					else if (type == 4)
						row += "| S ";
					else if (type == 5)
						row += "| W ";
				}
			}
			w += row;
			w += "|\n";
		}
		for(int i = 0; i < this.worldY; i++)
		{
			w +="+---";
		}
		w+="+";
		return w;
    }

	public void init(WorldGenerator wgen) {
		this.time = 0;
		World w = wgen.generate();
		this.tiles = w.getTiles();
	}

	public int getY() {
    	return this.worldY;
	}

	public int getX() {
    	return this.worldX;
	}

	public ArrayList<ArrayList<Tile>> getTiles()
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
