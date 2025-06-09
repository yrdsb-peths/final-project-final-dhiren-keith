import greenfoot.*;

public class SelectWorldFive extends Actor {
    public int persistentLevel;

    public SelectWorldFive() {
        GreenfootImage image = new GreenfootImage("5.png");
        image.scale(75, 75);
        setImage(image);
    }


    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            int currentLevel = Hero.getPersistentLevel();
            if (currentLevel == 20) {
            WorldFive worldFive = new WorldFive();
            Greenfoot.setWorld(worldFive); // triggers act() in WorldOne
            } else {
                getWorld().showText("World Five is only for level 80! Current level: " + currentLevel, 
                getWorld().getWidth()/2, getWorld().getHeight()/2);
                Greenfoot.delay(120);
                getWorld().showText("", getWorld().getWidth()/2, getWorld().getHeight()/2);
            }
        }
    }
}
