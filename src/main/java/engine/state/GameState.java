package engine.state;

import engine.database.KeySpecifier;
import engine.world.World;

import java.io.File;

public class GameState extends StateManager {

	private char Character;
	private World world;

    public GameState(String filename) {
        super(filename);
    }
	
	public void load(String in) {
		File f = new File(in);
        this.load(f);
	}
	
	public void load(File f) {
		
	}

    @Override
    public KeySpecifier getKeySpecifier() {
        return null;
    }

    @Override
    public String serialize() {
        return null;
    }

}
