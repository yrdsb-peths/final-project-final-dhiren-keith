import greenfoot.*;

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
            Greenfoot.setWorld(worldThree); // triggers act() in WorldOne
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
