package engine;

import com.google.gson.Gson;
import engine.state.GameState;
import engine.state.Settings;
import engine.world.World;

public class Game {

    public static final Gson gson = new Gson();
	private Settings settings;
	private World world;
	private GameState state;
	private Game instance;

    public Game() {
        this.settings = new Settings(null, 0, 0, 0, true);
        this.world = new World();
        this.state = new GameState(null, "./astroexplorer.db");
        this.instance = new Game();
    }

	public void init() {
		
	}
	
	public void showMenu() {
		
	}
	
	public void hideMenu() {
		
	}
	
	public void keypress() {
		
	}
	
	public void mouseDown() {
		
	}
	
	public int exit() {
		return 0;
	}
	
	public void displayMessage(String msg) {
		
	}
	
	public Game getInstance() {
		return null;
	}
	
	public void newOperation() {
		
	}

}
