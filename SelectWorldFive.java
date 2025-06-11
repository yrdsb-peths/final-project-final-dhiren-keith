import greenfoot.*;

/**
 * SelectWorldFive - Allows player to select World Five if the Hero is at level 80.
 * Shows a message if the player's level is not 80.
 * Displays a clickable 75x75 image of the number "5".
 * 
 * @author Keith
 * @version June 9, 2025
 */
public class SelectWorldFive extends Actor {
    public int persistentLevel;
    
    /**
     *  Constructor sets and scales the image for the world selector
     */
    public SelectWorldFive() {
        GreenfootImage image = new GreenfootImage("5.png");
        image.scale(75, 75);
        setImage(image);
    }

    /**
     *  Detects clicks on selector, if level is 80 world five is unlocked
     */
    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            int currentLevel = Hero.getPersistentLevel();
            if (currentLevel == 80) {
                WorldFive worldFive = new WorldFive();
                Greenfoot.setWorld(worldFive); // Load level five
            } else {
                int x = getWorld().getWidth() / 2;
                int y = getWorld().getHeight() / 2;
                getWorld().showText("World Five is only for level 80! Current level: " + currentLevel, x, y);
                Greenfoot.delay(120);
                getWorld().showText("", x, y); // Clear the message
            }
        }
    }
}
