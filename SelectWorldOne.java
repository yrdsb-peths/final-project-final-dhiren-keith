import greenfoot.*;

public class SelectWorldOne extends Actor {
    public int persistentLevel;

    public SelectWorldOne() {
        GreenfootImage image = new GreenfootImage("1.png");
        image.scale(75, 75);
        setImage(image);
    }

    public int getLevel() {
        return persistentLevel;
    }

    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            if (persistentLevel == 0) {
                WorldOne worldOne = new WorldOne();
                Greenfoot.setWorld(worldOne); // triggers act() in WorldOne
            } else {
                Label label = new Label("Level not high enough for this world", "Arial", 30);
                getWorld().addObject(label, getX(), getY() - 50);
            }
        }
    }
}
