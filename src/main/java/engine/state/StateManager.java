package engine.state;

import engine.database.DatabaseAdapter;

public class StateManager {

    private String filename;
    private DatabaseAdapter adapter;

    public StateManager(String filename) {
        this.filename = filename;
        this.adapter = new DatabaseAdapter(filename);
    }

    public String getFilename() {
        return this.filename;
    }

    public void save() {

    }

    public void load() {

    }

}
