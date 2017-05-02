package engine.state;

import engine.Game;
import engine.database.DatabaseAdapter;
import engine.database.KeySpecifier;

import javax.xml.crypto.Data;

public abstract class StateManager {

    private String filename;
    private DatabaseAdapter adapter;

    public StateManager(DatabaseAdapter adapter) {
        this.filename = "astroexplorer.sqlite";
        this.adapter = adapter;
    }

    public StateManager(DatabaseAdapter adapter, String filename) {
        this.filename = filename;
        this.adapter = adapter;
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

    public <T extends StateManager> T load(Class<T> cls) {
        String json = this.adapter.get(this.getKeySpecifier());
        Object o = Game.gson.fromJson(json, cls);
        return cls.cast(o);
    }

    public boolean save() {
        KeySpecifier spec = this.getKeySpecifier();
        String json = Game.gson.toJson(this);
        return this.adapter.set(spec, json);
    }

}
