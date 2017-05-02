package engine.state;

import engine.Game;
import engine.database.DatabaseAdapter;
import engine.database.KeySpecifier;
import engine.world.World;

public class WorldState extends StateManager {

    private World world;

    public WorldState(DatabaseAdapter adapter, String filename) {
        super(adapter, filename);
    }

    public void setWorld(World world) {
        this.world = world;
    }

    public World getWorld() {
        return this.world;
    }

    @Override
    public KeySpecifier getKeySpecifier() {
        return KeySpecifier.WORLD;
    }

    @Override
    public String serialize() {
        return Game.gson.toJson(this);
    }

    public void load() {
        WorldState tmp = super.load(this.getClass());
        this.world = tmp.world;
    }

}
