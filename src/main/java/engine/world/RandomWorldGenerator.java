package engine.world;

import java.util.List;
import java.util.Random;

import engine.tile.Tile;

public class RandomWorldGenerator extends WorldGenerator {
	
	private int seed;
	private List<List<Tile>> tiles;
	
	public World generate()
	{
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
			tiles.get(0).set(i, super.getFactory().getTile(4));
		}
		
		//Generate Shop within ship
		tiles.get(1).set(0, super.getFactory().getTile(5));
		tiles.get(1).set(1, super.getFactory().getTile(5));
		
		//Generate rest of ship
		for(int i = 2; i < 6; i++)
		{
			tiles.get(1).set(i, super.getFactory().getTile(4));
		}
		
		int randomIndex = generator.nextInt(prob.length);
		
		//Randomly Generate the Rest of Map
		for(int i = 2; i < 50; i++)
		{
			for(int j = 7; j < 50; j++)
			{
				tiles.get(i).set(j, super.getFactory().getTile(prob[randomIndex]));
			}
		}
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
