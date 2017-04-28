/*
 * Created by Michael 4/25
 */
import java.util.ArrayList;

public class World {
	
	private ArrayList<ArrayList<Tile>> tiles; //Currently going to use ArrayList, can change to just array if needed
	private long time;
	
	public void init(WorldGenerator wgen)
	{
		
	}
	
	public long getTime()
	{
		return this.time;
	}
	
	public void setTime(long time)
	{
		this.time = time;
	}
	
	public void addTime(long dur)
	{
		this.time += dur;
	}
}
