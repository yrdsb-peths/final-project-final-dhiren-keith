import greenfoot.*;

/**
 * SelectWorldFour - Allows player to select World Four if the Hero is at level 60.
 * Shows a message if the player's level is not 60.
 * Displays a clickable 75x75 image of the number "4".
 * 
 * @author Keith
 * @version June 9, 2025
 */
public class SelectWorldFour extends Actor {
    public int persistentLevel;
    
    /**
     *  Constructor sets and scales the image for the world selector
     */
    public SelectWorldFour() {
        GreenfootImage image = new GreenfootImage("4.png");
        image.scale(75, 75);
        setImage(image);
    }
    
    /**
     *  Detects clicks on this selector, if level is 60 world is unlocked
     */
    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            int currentLevel = Hero.getPersistentLevel();
            if (currentLevel == 60) {
                WorldFour worldFour = new WorldFour(); 
                Greenfoot.setWorld(worldFour); // Load world four
            } else {
                int x = getWorld().getWidth() / 2;
                int y = getWorld().getHeight() / 2;
                getWorld().showText("World Four is only for level 60! Current level: " + currentLevel, x, y);
                Greenfoot.delay(120);
                getWorld().showText("", x, y); // Clear the message
            }
        }
    }
}
