package engine.state;

import engine.Game;
import engine.database.KeySpecifier;

public class Settings extends StateManager {
	
	private int resolutionX;
	private int resolutionY;
	private int volume;
	private boolean vsync;

	public Settings(String filename) {
		super(filename);
	}

    public void setResolution(int x, int y) {
        this.resolutionX = x;
        this.resolutionY = y;
    }

	public void setResolutionX(int x) {
        this.resolutionX = x;
    }

    public int getResolutionX() {
        return this.resolutionX;
    }

    public void setResolutionY(int y) {
        this.resolutionY = y;
    }

    public int getResolutionY() {
        return this.resolutionY;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getVolume() {
        return this.volume;
    }

    public void setVSync(boolean vsync) {
        this.vsync = vsync;
    }

    public boolean getVSync() {
        return this.vsync;
    }

    @Override
    public KeySpecifier getKeySpecifier() {
        return KeySpecifier.SETTINGS;
    }

    @Override
	public String serialize() {
		return Game.gson.toJson(this);
	}

}
