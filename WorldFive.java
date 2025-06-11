import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * WorldFive represents the fifth game level with a specific background.
 * 
 * @author Keith & Dhiren
 * @version June 9, 2025
 */
public class WorldFive extends MyWorld {

    /**
     * Constructor for objects of class WorldFive.
     */
    public WorldFive() {    
        super(new Hero());
        GreenfootImage image = new GreenfootImage("bg5.jpg");  
        image.scale(600, 400);
        setBackground(image);  
        removeObjects(getObjects(null));
        prepare();
    }
}