import greenfoot.*;

 /**
  * WorldOne is the first game level with its unique background and setup.
  * Handles wave spawning when the game starts.
  * 
  * @author Keith & Dhiren
  * @version June 9, 2025
  */
public class WorldOne extends MyWorld {
    private boolean gameStarted = false;

    public WorldOne() {
        super(new Hero());
        GreenfootImage image = new GreenfootImage("bg1.jpg");
        image.scale(600, 400);
        setBackground(image);
        removeObjects(getObjects(null)); // Clear any existing objects
    }

    public void act() {
        if (!gameStarted) {
            prepare(); // Setup initial objects
            startWave(); // Begin enemy waves
            gameStarted = true;
        }
        super.act(); // handle wave system
    }
}
