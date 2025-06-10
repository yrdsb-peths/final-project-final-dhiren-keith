import greenfoot.*;

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
            Greenfoot.setWorld(worldOne); // triggers act() in WorldOne
            } else {
                int x = getWorld().getWidth() / 2;
                int y = getWorld().getHeight() -30;
                getWorld().showText("World One is only for level 0! Current level: " + currentLevel, x, y);
                Greenfoot.delay(120);
                getWorld().showText("", x, y);
            }
        }
    }
}
