package engine.state;

import engine.database.DatabaseAdapter;
import engine.database.KeySpecifier;

public abstract class StateManager {

    private String filename;
    private DatabaseAdapter adapter;

    public StateManager(String filename) {
        this.filename = filename;
        this.adapter = new DatabaseAdapter(filename);
    }

    public String getFilename() {
        return this.filename;
    }

    public abstract KeySpecifier getKeySpecifier();

    public abstract String serialize();

}
