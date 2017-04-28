package engine.state;

import engine.world.World;

import java.io.File;

public class GameState {

	private char Character;
	private World world;
	
	public String serialize() {
		return null;
	}
	
	public void load(String in) {
		File f = new File(in);
        this.load(f);
	}
	
	public void load(File f) {
		
	}

}
