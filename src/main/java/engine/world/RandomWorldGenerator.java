package engine.world;

import java.util.Random;

public class RandomWorldGenerator extends WorldGenerator {
	private int seed;
	
	public World generate()
	{
		return super.generate();
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
