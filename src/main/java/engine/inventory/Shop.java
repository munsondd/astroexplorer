package engine.inventory;

import java.util.ArrayList;
import java.util.Scanner;

import engine.character.Character;
import engine.character.Statistics;
import engine.entity.Entity;
import engine.text.Constants;


public class Shop {

    private Inventory items;
    private Inventory upgrades;
    private int timesOpened;
    boolean Engine; //booleans tells when repairs are finished
    boolean Hull;
    boolean LifeSupport;
    boolean Win;
    private Scanner in = new Scanner(System.in);


    public Shop(boolean e, boolean h, boolean ls, boolean w) {
        this.Engine = e;
        this.Hull = h;
        this.LifeSupport = ls;
        this.Win = w;
    }

    public String prompt() {
        return this.in.next();
    }

    public void EnterShop(Shop ship, Character ch) {
        boolean inShop = true;
        while(inShop) {
            System.out.println(Constants.ShopMain);
            String in = prompt().toLowerCase();
            if(in.equals("heal")){
                ship.RefilHealth(ch);
            }
            if(in.equals("fuel")){
                ship.RefilFuel(ch);
            }
            if(in.equals("repair")){
                System.out.println(Constants.Repairs);
                String input = prompt().toLowerCase();
                if(input.equals("engines")){
                    ship.SetEngineRepair();
                }
                if(input.equals("hull")){
                    ship.SetHullRepair();
                }
                if(input.equals("lifesupport")){
                    ship.SetLSRepair();
                }
            }
            if(in.equals("exit")){
                inShop = false;
            }
        }
    }


    public boolean BuildEngine(Character player) {
        System.out.println("Your Need 1 Unit of Iron to fix engines. You have" + Double.toString(player.getStatistics().getFuel()));
        return true;
    }

    public void RefilFuel(Character player) {
        System.out.println("You have " + Double.toString(player.getStatistics().getFuel()) +" fuel left.");
        player.getStatistics().setFuel(100);
        System.out.println("Fuel Restored");
    }

    public void RefilHealth(Character player) {
        System.out.println("You have " + Double.toString(player.getStatistics().getHealth()) +" Health left.");
        player.getStatistics().setHealth(100);
        System.out.println("Health Restored");
    }

    public boolean buyItem(Item i) {
        return this.items.removeItem(i);
    }

    public boolean sellItem(Item i) {
        return this.items.addItem(i);
    }

    /*
    public boolean GetEngineRepair() {return this.Engine;}
    public boolean GetHullRepair() {return this.Hull;}
    public boolean GetLSRepair() {return this.LifeSupport;}
    */

    public void SetEngineRepair() {
        this.Engine = true;
        System.out.println("The Engines have been repaired!");
    }

    public void SetHullRepair() {
        this.Hull = true;
        System.out.println("The Hull has been repaired!");
    }

    public void SetLSRepair() {
        this.LifeSupport = true;
        System.out.println("The LifeSupport has been repaired!");
    }

    public String FixCheck(boolean part) {
        if(part) { return "fixed";}
        else { return "broken";}
    }

    public boolean WinCheck() {
        if(Engine) {
            if(Hull) {
                if(LifeSupport) {
                    return true;
                }
            }
        }
        return false;
    }

    public String toString(){
        return "SHIP REPAIR STATUS\n" +
                "-----------------------------\n" +
                "Engine Status: " + FixCheck(Engine) +
                "\nHull Status: " + FixCheck(Hull) +
                "\nLifeSupport Status: " + FixCheck(LifeSupport);
    }

    /*public void upgrade(int type, int level) {
        if(type == 1) {
            Statistics setHealth(upgrades[type][level]);
            System.out.println("your max health is now " + upgrades[type][level]);
        }
        else if(type == 2) {
            Statistics setFuel(upgrades[type][level]);
            System.out.println("your max fuel is now " + upgrades[type][level]);
        }
        else if(type == 3) {
            Statistics setOxygen(upgrades[type][level]);
            System.out.println("your max oxygen is now " + upgrades[type][level]);
        }
    }*/

    public int getAccessCount() {
        return this.timesOpened;
    }

}
