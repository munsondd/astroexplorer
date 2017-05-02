package engine.world;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import engine.tile.Tile;

public class RandomWorldGenerator extends WorldGenerator {
	
	private int seed;
	private final int worldSizeX = 45;
	private final int worldSizeY = 25;
	private ArrayList<ArrayList<Tile>> tiles = new ArrayList<ArrayList<Tile>>(this.worldSizeX);
	
	public World generate()
	{
		for(int i = 0; i < this.worldSizeX; i++)
		{
			tiles.add(new ArrayList<Tile>(this.worldSizeY));
		}
		int prob[] = new int[100];
		
		for(int p = 0; p < 100; p++)
		{
			if(p < 65)
				prob[p] = 1;
			else if(p >= 65 && p <=85)
				prob[p] = 2;
			else
				prob[p] = 3;
		}
		
		Random generator = new Random();
		
		//Place ship and shop on bottom left corner
		for(int i = 0; i < 6; i++)
		{
			tiles.get(0).add(super.getFactory().getTile(4));
		}
		
		//Generate Shop within ship
		tiles.get(1).add(super.getFactory().getTile(5));
		tiles.get(1).add(super.getFactory().getTile(5));
		
		
		//Generate rest of ship
		for(int i = 2; i < 6; i++)
		{
			tiles.get(1).add(super.getFactory().getTile(4));
		}
		
		int randomIndex = generator.nextInt(prob.length);
		
		for(int i = 0; i < (this.worldSizeY)-6; i++)
		{
			randomIndex = generator.nextInt(prob.length);
			tiles.get(0).add(super.getFactory().getTile(prob[randomIndex]));
			tiles.get(1).add(super.getFactory().getTile(prob[randomIndex]));
			
		}
		//Randomly Generate the Rest of Map
		
		for(int i = 2; i <this.worldSizeX ; i++)
		{
			for(int j = 0; j < this.worldSizeY; j++)
			{
				randomIndex = generator.nextInt(prob.length);
				tiles.get(i).add(super.getFactory().getTile(prob[randomIndex]));
			}
		}
		
		World w = new World(tiles);
		return w;

	}
	
	public int getSeed()
	{
		return this.seed;
	}
	
	public void setSeed(int seed)
	{
		this.seed = seed;
	}
	
	public RandomWorldGenerator(int seed)
	{
		this.seed = seed;
	}
}
