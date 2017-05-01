import engine.character.Character;
import engine.entity.MovableEntity;
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
    private Scanner in = new Scanner(System.in);

    // toggle this to increase verbosity
    private static final boolean debug = true;

    /**
     * Starts the game loop. This will block until the
     * game exits.
     */
    public void start() {
        this.display(Constants.WELCOME);
        // System.out.println(Constants.MAINMENU);
        //load character into world
        this.display(Constants.NAMEPROPMT);
        String name = this.prompt();
        this.dispatch(name);

        //need to load world.
        World world = new World();
        RandomWorldGenerator r = new RandomWorldGenerator(50);
        
        world.init(r);
        this.display(world.display());
        
        Location startingPosition = new Location(1.0,2.0,world);

        Character chr = new Character(0,1,1,true,0.0, "player");
        WalkingCharacter player = new WalkingCharacter(startingPosition, 1,1,chr);

        while (this.running) {
            int positionX = (int)player.getPosition().getX();
            int positionY = (int)player.getPosition().getY();

            Tile currentTile = world.getTiles().get(positionX).get(positionY);

            this.display("you are on a " +currentTile.toString() + "\n");

            String in = this.prompt().toLowerCase();
            this.dispatch(in);
            if(in.equals("help")){
                this.display(Constants.HELPMESSAGE);
            }
            if(in.equals("stats")){
                Character ch = (Character) player.getCmp();
                this.display(ch.getStatistics().toString());
            }
            if(in.equals("up")){
                player.setVelocityY(player.getVelocityY()+1);
            }
            if(in.equals("down")){
                player.setVelocityY(player.getVelocityY()-1);
            }
            if (in.equals("left")){
                player.setVelocityX(player.getVelocityX()-1);
            };
            if(in.equals("right")){
                player.setVelocityX(player.getVelocityX()+1);
            }
            if(in.equals("quit")){
                this.running = false;
            }
            if(in.equals("inventory")){
                Character ch = (Character) player.getCmp();
                this.display(ch.getBackpack().toString());
            }
            if(in.equals("drill")){

                
            }
            player.move();

            if(player.getPosition().getX()>50 || player.getPosition().getX() < 0 || player.getPosition().getY()< 0 || player.getPosition().getY() > 50)
                this.alive = false;
            this.display(player.toString());
        }
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
        return this.in.next();
    }

    /**
     * Handles a player response.
     * @param input The command to be run
     */
    public void dispatch(String input) {
        debug("dispatch: " + input);
    }

    public static void main(String args[]) {
        AstroExplorerText game = new AstroExplorerText();
        game.start();

        /*
        boolean inGame = true;
        boolean alive = true;
        Scanner reader = new Scanner(System.in);
        String input;

        while(inGame && alive){
            System.out.println("Welcome brave astroexplorer. Your ship has broken down in the middle of an asteroid field." +
                    "You must gather surrounding resources to fix it. but be careful you only have a limited supply of fuel and" +
                    "oxygen. You will need to return to the ship to resupply.");
            input = reader.next();
            inGame = false;


        }
        */
    }

    public String worldMap(MovableEntity player, World world){
        //World String
        String w = "";
        int positionX = (int)player.getPosition().getX();
        int positionY = (int)player.getPosition().getY();
        for(int i = 0; i < 50; i++ )
        {
            for(int l = 0; l<50;l++) w+="+----";
            for(int l = 0; l<50;l++) w+="   ";
            w+="\n";
            String row = "";
            for(int j = 0; j < 50; j++)
            {
                int type = world.getTiles().get(j).get(i).getType();

                if(i == positionX && j == positionY){
                    row += "| @  ";
                }
                else {
                    if (type == 1)
                        row += "|    ";
                    else if (type == 2)
                        row += "| A  ";
                    else if (type == 3)
                        row += "| R  ";
                    else if (type == 4)
                        row += "| S  ";
                    else if (type == 5)
                        row += "| W  ";
                }
            }
            //row += "\n";
            w += row;
            for(int l = 0; l<50;l++) w+="   ";
            w+= "\n";
        }
        for(int i = 0; i < 50; i++)
        {
            w +="+----";
        }
        return w;
    }

    public void display(String message) {
        System.out.println(WordUtils.wrap(message, 80));
    }

    public static void debug(String message) {
        if (!AstroExplorerText.debug) return;
        System.out.printf("[DEBUG] %s\n", message);
    }

}
