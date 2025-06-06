import greenfoot.*;

public class StartScreen extends World {

    public StartScreen() {
        super(600, 400, 1); 
        showText("Press SPACE to start", getWidth()/2, getHeight()/2 + 100);
    }

    public void act() {
        if (Greenfoot.isKeyDown("space")) {
            Greenfoot.setWorld(new MyWorld());
        }
    }
}
