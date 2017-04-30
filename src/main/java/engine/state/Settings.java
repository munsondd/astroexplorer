package engine.state;

public class Settings extends StateManager {
	
	private int resolutionX;
	private int resolutionY;
	private int volume;
	private boolean vsync;

	public Settings(String filename) {
		super(filename);
	}

	public void setInt(String key, int i) {
		
	}
	
	public int getInt(String key) {
		return 0;
	}
	
	public void setBool(String key, boolean b) {
		
	}
	
	public boolean getBool(String key) {
		return false;
	}
	
	public void setString(String key, String s) {
		
	}
	
	public String getString(String key) {
		return null;
	}
	
	public String serialize() {
		return null;
	}

}

