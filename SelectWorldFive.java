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
            if (currentLevel == 80) {
            WorldFive worldFive = new WorldFive();
            Greenfoot.setWorld(worldFive); // triggers act() in WorldOne
            } else {
                int x = getWorld().getWidth() / 2;
                int y = getWorld().getHeight() -30;
                getWorld().showText("World Five is only for level 80! Current level: " + currentLevel, x, y);
                Greenfoot.delay(120);
                getWorld().showText("", x, y);
            }
        }
    }
}
