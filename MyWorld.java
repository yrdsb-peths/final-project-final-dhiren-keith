import greenfoot.*;
import greenfoot.Actor;

public class MyWorld extends World {
    public MyWorld() {
        super(600, 400, 1);
        setWorlds();
    }
    private void setWorlds()
    {
        addObject(new SelectWorldOne(), 100, 100);
        addObject(new SelectWorldTwo(), 200, 300);
        addObject(new SelectWorldThree(), 300, 150);
        addObject(new SelectWorldFour(), 400, 325);
        addObject(new SelectWorldFive(), 500, 75);

        
    }
}
