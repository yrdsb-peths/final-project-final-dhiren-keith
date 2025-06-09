import greenfoot.*;

public class WorldOne extends MyWorld {
    private boolean gameStarted = false;

    public WorldOne() {
        super();
        GreenfootImage image = new GreenfootImage("bg1.jpg");
        image.scale(600, 400);
        setBackground(image);
        removeObjects(getObjects(null));
        
    }

    public void act() {
        if (!gameStarted) {
            prepare(); 
            gameStarted = true;
        }
        super.act(); // handle wave system
    }
}
