package engine.state;

import engine.Game;
import engine.database.DatabaseAdapter;
import engine.database.KeySpecifier;

public abstract class StateManager {

    private transient String filename;
    private transient DatabaseAdapter adapter;

    public StateManager(DatabaseAdapter adapter, String filename) {
        this.adapter = adapter;
        this.filename = filename;
    }

    public StateManager(DatabaseAdapter adapter) {
        this(adapter, "astroexplorer.sqlite");
    }

    public String getFilename() {
        return this.filename;
    }

    /**
     * The database stores K,V pairs in which K is represented by
     * a KeySpecifier. This method is to be overridden for a state
     * class to specify their own row to be stored in.
     *
     * @return KeySpecifier the associated row this state is to be stored in
     */
    public abstract KeySpecifier getKeySpecifier();

    /**
     * All stores must be serializable to JSON, and classes must
     * handle serialization and deserialization on their own.
     *
     * @return String the serialized JSON string
     */
    public abstract String serialize();

    /**
     * Load and instantiate the given class by deserializing its
     * associated row in the database adapter.
     *
     * @param cls the class to be loaded
     * @param <T> the instance of state manager
     * @return the loaded class
     */
    public <T extends StateManager> T load(Class<T> cls) {
        String json = this.adapter.get(this.getKeySpecifier());
        Object o = Game.gson.fromJson(json, cls);
        return cls.cast(o);
    }

    /**
     * Flush an in-memory state manager into its associated
     * row in the database medium.
     *
     * @return whether or not the operation succeeded
     */
    public boolean save() {
        KeySpecifier spec = this.getKeySpecifier();
        String json = Game.gson.toJson(this);
        return this.adapter.set(spec, json);
    }

}
