import greenfoot.*;

/**
 * SelectWorldThree - Allows player to select World Three if the Hero is at level 40.
 * Shows a message if the player's level is not 40.
 * Displays a clickable 75x75 image of the number "3".
 * 
 * @author Keith
 * @version June 9, 2025
 */
public class SelectWorldThree extends Actor {
    public int persistentLevel;

    public SelectWorldThree() {
        GreenfootImage image = new GreenfootImage("3.png");
        image.scale(75, 75);
        setImage(image);
    }

    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            int currentLevel = Hero.getPersistentLevel();
            if (currentLevel == 40) {
                WorldThree worldThree = new WorldThree();
                Greenfoot.setWorld(worldThree);
            } else {
                int x = getWorld().getWidth() / 2;
                int y = getWorld().getHeight() / 2;
                getWorld().showText("World Three is only for level 40! Current level: " + currentLevel, x, y);
                Greenfoot.delay(120);
                getWorld().showText("", x, y);
            }
        }
    }
}
