import greenfoot.*;

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
            Greenfoot.setWorld(worldTwo); // triggers act() in WorldOne
            } else {
                int x = getWorld().getWidth() / 2;
                int y = getWorld().getHeight() -30;
                getWorld().showText("World Two is only for level 20! Current level: " + currentLevel, x, y);
                Greenfoot.delay(120);
                getWorld().showText("", x, y);
            }
        }
    }
}
