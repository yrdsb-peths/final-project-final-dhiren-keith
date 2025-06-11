import greenfoot.*;

/**
 * SelectWorldOne - Allows player to select World One if the Hero is at level 0.
 * Shows a message if the player's level is not 0.
 * Displays a clickable 75x75 image of the number "1".
 * 
 * @author Keith
 * @version June 9, 2025
 */
public class SelectWorldOne extends Actor {
    public int persistentLevel;

    public SelectWorldOne() {
        GreenfootImage image = new GreenfootImage("1.png");
        image.scale(75, 75);
        setImage(image);
    }

    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            int currentLevel = Hero.getPersistentLevel();
            if (currentLevel == 0) {
                WorldOne worldOne = new WorldOne();
                Greenfoot.setWorld(worldOne);
            } else {
                int x = getWorld().getWidth() / 2;
                int y = getWorld().getHeight() / 2;
                getWorld().showText("World One is only for level 0! Current level: " + currentLevel, x, y);
                Greenfoot.delay(120);
                getWorld().showText("", x, y);
            }
        }
    }
}
