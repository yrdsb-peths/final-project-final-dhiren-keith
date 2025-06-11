import greenfoot.*;

/**
 * SelectWorldTwo - Allows player to select World Two if the Hero is at level 20.
 * Shows a message if the player's level is not 20.
 * Displays a clickable 75x75 image of the number "2".
 * 
 * @author Keith
 * @version June 10, 2025
 */
public class SelectWorldTwo extends Actor {
    public int persistentLevel;

    public SelectWorldTwo() {
        GreenfootImage image = new GreenfootImage("2.png");
        image.scale(75, 75);
        setImage(image);
    }

    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            int currentLevel = Hero.getPersistentLevel();
            if (currentLevel == 20) {
                WorldTwo worldTwo = new WorldTwo();
                Greenfoot.setWorld(worldTwo); // triggers act() in WorldTwo
            } else {
                int x = getWorld().getWidth() / 2;
                int y = getWorld().getHeight() / 2;
                getWorld().showText("World Two is only for level 20! Current level: " + currentLevel, x, y);
                Greenfoot.delay(120);
                getWorld().showText("", x, y);
            }
        }
    }
}
