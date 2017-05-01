package engine.world;

import engine.tile.Tile;

import java.util.ArrayList;
import java.util.List;

public class World {

	private ArrayList<ArrayList<Tile>> tiles = new ArrayList<ArrayList<Tile>>(50);
	private long time;

    public World() {
        this.tiles = new ArrayList<>();
        this.time = 0L;
    }
    
    public World(ArrayList<ArrayList<Tile>> tiles)
    {
    	this.tiles = tiles;
    }
    
    public String display()
    {
    	//World String
    	String w = "";
    	for(int i = 0; i < 50; i++ )
    	{
    		for(int l = 0; l<50;l++) w+="+----";
			for(int l = 0; l<50;l++) w+="   ";
    		w+="\n";
    		String row = "";
    		for(int j = 0; j < 50; j++)
    		{
    			int type = this.tiles.get(j).get(i).getType();
    			if(type == 1)
    				row += "|    ";
    			else if(type == 2)
    				row += "| A  ";
    			else if (type == 3)
    				row += "| R  ";
    			else if (type == 4)
    				row += "| S  ";
    			else if (type == 5)
    				row += "| W  ";
    		}
    		//row += "\n";
    		w += row;
			for(int l = 0; l<50;l++) w+="   ";
			w+= "\n";
    	}
    	for(int i = 0; i < 50; i++)
    	{
    		w +="+----";
    	}
    	return w;
    }
    
	
	public void init(WorldGenerator wgen) {
		this.time = 0;
		World w = wgen.generate();
		this.tiles = w.getTiles();
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
