package engine.state;

import engine.database.DatabaseAdapter;
import engine.database.KeySpecifier;

public abstract class StateManager {

    private String filename;
    private DatabaseAdapter adapter;

    public StateManager() {
        this.filename = "astroexplorer.sqlite";
        this.adapter = new DatabaseAdapter(filename);
    }

    public StateManager(String filename) {
        this.filename = filename;
        this.adapter = new DatabaseAdapter(filename);
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

}
