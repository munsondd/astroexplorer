package engine.state;

import java.util.ArrayList;
import java.util.List;

public class GameMenu {

    private List<String> buttonTexts;
    private boolean clickable;

    public GameMenu() {
        this.buttonTexts = new ArrayList<>();
    }

    public void invoke(String text) {

    }

    public boolean isClickable() {
        return this.clickable;
    }

    public void setClickable(boolean clickable) {
        this.clickable = clickable;
    }

    public boolean addButton(String text) {
        this.buttonTexts.add(text);
        return true;
    }

    public String[] getButtonTexts() {
        return (String[]) this.buttonTexts.toArray();
    }

}
