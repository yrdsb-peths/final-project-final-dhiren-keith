import greenfoot.*;

public class SelectWorldFour extends Actor {
    public int persistentLevel;

    public SelectWorldFour() {
        GreenfootImage image = new GreenfootImage("4.png");
        image.scale(75, 75);
        setImage(image);
    }


    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            int currentLevel = Hero.getPersistentLevel();
            if (currentLevel == 60) {
            WorldFour worldFour = new WorldFour();
            Greenfoot.setWorld(worldFour); // triggers act() in WorldOne
            } else {
                int x = getWorld().getWidth() / 2;
                int y = getWorld().getHeight() -30;
                getWorld().showText("World Four is only for level 60! Current level: " + currentLevel, x, y);
                Greenfoot.delay(120);
                getWorld().showText("", x, y);
            }
        }
    }
}
