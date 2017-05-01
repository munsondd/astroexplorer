package engine.inventory;
import engine.character.Statistics;
import engine.character.Character;

public class Upgrades extends Statistics{

    private double[][] upgrades;

    public Upgrades() {
        this.upgrades = new double[4][3];
        for (int i = 0; i < 3; i++) {
            double base = 100;
            for (int j = 0; j < 4; j++) {
                upgrades[j][i] = base;
                base = base + 100;
            }
        }
    }

    public double GetUpgrades(int type, int level) { return this.upgrades[type][level];}

}
