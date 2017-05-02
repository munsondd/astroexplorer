package engine.state;

import engine.Game;
import engine.character.Character;
import engine.database.DatabaseAdapter;
import engine.database.KeySpecifier;


public class PlayerState extends StateManager {

    private Character chr;

    public PlayerState(DatabaseAdapter adapter, String filename) {
        super(adapter, filename);
    }

    public void setCharacter(Character chr) {
        this.chr = chr;
    }

    public Character getCharacter() {
        return this.chr;
    }

    @Override
    public KeySpecifier getKeySpecifier() {
        return KeySpecifier.CHARACTER;
    }

    @Override
    public String serialize() {
        return Game.gson.toJson(this);
    }

    public void load() {
        PlayerState tmp = super.load(this.getClass());
        this.chr = tmp.chr;
    }

}
