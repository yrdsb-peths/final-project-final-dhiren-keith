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
                getWorld().showText("World One is only for level 0! Current level: " + currentLevel, 
                getWorld().getWidth()/2, getWorld().getHeight()/2);
                Greenfoot.delay(120);
                getWorld().showText("", getWorld().getWidth()/2, getWorld().getHeight()/2);
            }
        }
    }
}
