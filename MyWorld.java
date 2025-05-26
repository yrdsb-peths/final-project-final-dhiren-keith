import greenfoot.*;
import greenfoot.Actor;

public class MyWorld extends World {
    public MyWorld() {
        super(600, 400, 1);
        setWorlds();
    }
    private void setWorlds()
    {
        addObject(new SelectWorldOne(), 100, 200);
        addObject(new SelectWorldTwo(), 500, 200);
        addObject(new SelectWorldThree(), 400, 200);
        addObject(new SelectWorldFour(), 300, 200);
        addObject(new SelectWorldFive(), 200, 200);

        
    }
}
