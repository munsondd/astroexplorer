import java.util.Scanner;

/**
 * Created by david on 4/30/17.
 */
public class AstroExplorerText {
    public static void main(String args[]) {

        boolean inGame = true;
        boolean alive = true;
        Scanner reader = new Scanner(System.in);
        String input;


        //the main game loop
        while(inGame && alive){
            System.out.println("Welcome brave astroexplorer. Your ship has broken down in the middle of an asteroid field." +
                    "You must gather surrounding resources to fix it. but be careful you only have a limited supply of fuel and" +
                    "oxygen. You will need to return to the ship to resupply.");
            input = reader.next();
            inGame = false;


        }
    }

}
