import engine.character.Character;
import engine.database.DatabaseAdapter;
import engine.entity.MDecorator;
import engine.inventory.Item;
import engine.inventory.Shop;
import engine.state.PlayerState;
import engine.state.WorldState;
import engine.text.Constants;
import engine.tile.Tile;
import engine.world.Location;
import engine.world.RandomWorldGenerator;
import engine.world.World;
import org.apache.commons.lang3.text.WordUtils;
import engine.character.*;
import java.util.Scanner;

public class AstroExplorerText {

    // the game will block on this unless System.exit(); is called
    private boolean running = true;
    private boolean alive = true;
    private boolean load = false;
    private Scanner in = new Scanner(System.in);

    // toggle this to increase verbosity
    private static final boolean debug = false;

    public void showMainMenu() {
        while (true) {
            this.display(Constants.MAIN_MENU);
            String in = this.prompt();
            this.dispatch(in);
            if (in.equals("start")) {
                break;
            }
            if(in.equals("load")){
                load = true;
                break;
            }
        }
    }

    public void drill(Character ch, Tile currentTile) {

        String resource = currentTile.getResource();
        int ammount = currentTile.getRRammount();

        Item newItem = new Item(resource,3, ammount);
        if(ch.getBackpack().getName() == resource){
            ch.getBackpack().addQuantity(ammount);
        }
        else {ch.getBackpack().getItems().add(newItem);}

        this.display("You just found " + Integer.toString(ammount) + " Units of " + resource);
        this.display("Total Ammount of  " + resource + ": " + Integer.toString(ch.getBackpack().getQuantity(newItem)));

        currentTile.setResource();
        currentTile.setRRammount();
        currentTile.setType(2);
    }

    /**
     * Starts the game loop. This will block until the
     * game exits.
     */
    public void start() {
        clear();

        // create a new database adapter
        DatabaseAdapter adpt = new DatabaseAdapter("astroexplorer.sqlite");

        WorldState state = new WorldState(adpt, "astroexplorer.sqlite");
        PlayerState pstate = new PlayerState(adpt, "astroexplorer.sqlite");

        World world = new World();
        String name;
        Character chr;
        if (!load) {
            this.display(Constants.WELCOME);
            this.display(Constants.NAME_PROMPT);

            // record the name of the user
            name = this.prompt();
            chr = new Character(0, 1, 1, true, 0.0, name);
            pstate.setCharacter(chr);
            pstate.save();

            // create an empty world object
            RandomWorldGenerator r = new RandomWorldGenerator(50);
            // initialize the world using a random generation scheme
            world.init(r);
            state.setWorld(world);
            state.save();
        } else {
            state.load();
            world = state.getWorld();

            pstate.load();
            chr = pstate.getCharacter();
            name = chr.getName();
        }
        
        // sets ship parts as broken and victory condition as false
        Shop ship = new Shop(false, false, false, false);

        Location start = new Location(1.0, 2.0, world);
        MDecorator player = new WalkingCharacter(start, 1, 1, chr);

        while (this.running) {
            this.display("----------------------------------------------------------");
            if (!ship.WinCheck()) {
                //draw the map
            	System.out.println(world.display(player));
            	// get player and position
                int positionX = (int) player.getPosition().getX();
                int positionY = (int) player.getPosition().getY();
                Tile currentTile = world.getTiles().get(positionX).get(positionY);
                // change player state based on position
                if (currentTile.getType() == 1) {
                    player = new FlyingCharacter(player.getPosition(), player.getHeight(), player.getWidth(), player.getCmp());
                }
                else if (currentTile.getType() ==4 || currentTile.getType() == 5){
                    Character ch = (Character)player.getCmp();
                    ch.getStatistics().reset();
                }
                else {
                    player = new WalkingCharacter(player.getPosition(), player.getHeight(), player.getWidth(), player.getCmp());
                }
                //display some player info
                System.out.println(player.toString());
                this.display("you are on a " + currentTile.toString() + "\n");

                //get user input
                String in = this.prompt().toLowerCase();
                this.dispatch(in);
                // handle user input

                if (in.equals("repairs")) {
                    this.display(ship.toString());
                }
                if (in.equals("stats")) {
                    Character ch = (Character) player.getCmp();
                    this.display(ch.getStatistics().toString());
                }
                if (in.equals("right")) {
                    player.getCmp().setVelocityY(player.getCmp().getVelocityY() + 1);
                }
                if (in.equals("left")) {
                    player.getCmp().setVelocityY(player.getCmp().getVelocityY() - 1);
                }
                if (in.equals("up")) {
                    player.getCmp().setVelocityX(player.getCmp().getVelocityX() - 1);
                }
                if (in.equals("down")) {
                    player.getCmp().setVelocityX(player.getCmp().getVelocityX() + 1);
                }
                if (in.equals("quit")) {
                    this.running = false;
                }
                if (in.equals("inventory")) {
                    Character ch = (Character) player.getCmp();
                    ch.getBackpack().printBackpack();
                }
                if (in.equals("shop")) {
                    if (currentTile.getType() == 5) {
                        Character ch = (Character) player.getCmp();
                        ship.EnterShop(ship, ch);
                    } else {
                        this.display("You are not in the shop right now");
                    }
                }
                if (in.equals("drill")) {
                    if (currentTile.getType() == 3) {
                        Character ch = (Character) player.getCmp();
                        drill(ch,currentTile);
                    } else {
                        this.display("This tile is not mineable");
                    }

                }
                // move the player to next tile
                player.move();
                // cheack to see if player has left the map
                if (player.getPosition().getX() > world.getX() || player.getPosition().getX() < 0 || player.getPosition().getY() < 0 || player.getPosition().getY() > world.getY()) {
                    this.alive = false;
                    this.display("You floated off into the abyss of space and died");
                    //temporary fix for out of bounds error
                    this.running = false;
                }
            }
            else { running = false;}
        }
        if (ship.WinCheck()) { this.display("CONGRADULATIONS! YOU HAVE REPAIRED YOUR SHIP AND BEATEN THE GAME!\nYOU WIN!"); }
        else {this.display("GAMEOVER");}

    }

    /**
     * Exit the game. This will only run when invoked within
     * the game loop, because the main thread will be blocked.
     */
    public void exit() {
        this.running = false;
    }

    /**
     * Blocks and prompts for a response from the player.
     * @return String the player's response
     */
    public String prompt() {
        return this.in.next().toLowerCase();
    }

    /**
     * Handles a player response.
     * @param input The command to be run
     */
    public void dispatch(String input) {
        switch (input) {
            case "quit":
            case "exit":
                System.exit(0);
            case "help":
                this.display(Constants.HELP_MESSAGE);
                break;
            case "hints":
                this.display(Constants.HINTS_MESSAGE);
                break;
            case "clear":
                clear();
                break;
            default:
                // this.display("Unknown command: please try again.");
        }
    }

    /**
     * Clear the terminal that is being used for this game.
     */
    public static void clear() {
        final String ANSI_CLS = "\u001b[2J";
        final String ANSI_HOME = "\u001b[H";
        System.out.print(ANSI_CLS + ANSI_HOME);
        System.out.flush();
    }

    public static void main(String args[]) {
        AstroExplorerText game = new AstroExplorerText();
        game.showMainMenu();
        game.start();
    }

    public void display(String message) {
        System.out.println(WordUtils.wrap(message, 80));
    }

    public static void debug(String message) {
        if (!AstroExplorerText.debug) return;
        System.out.printf("[DEBUG] %s\n", message);
    }

}
