package engine.state;

import java.util.ArrayList;

/**
 * Created by david on 4/29/17.
 */
public class GameMenu {
    private ArrayList<String> buttonTexts;
    private boolean clickable;

    public void invoke(String text)
    {

    }
    public boolean isClickable()
    {
        return this.clickable;
    }
    public void setClickable(boolean clickable)
    {
        this.clickable = clickable;
    }
    public boolean addButton(String text)
    {
        buttonTexts.add(text);
        return true;
    }

}
