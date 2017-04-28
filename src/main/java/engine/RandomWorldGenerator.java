import java.util.Random;
/*
 * Created by Michael 4/25/17
 */
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
		//Generate a random seed between 0 and 999 for each random world
		Random randomGenerator = new Random();
		this.seed = randomGenerator.nextInt(1000);
		//Do we want to attach a seed to each random world? How would we do it?
		super.generate();
	}
}
