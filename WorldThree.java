import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * WorldThree is the third game level with its unique background and setup.
 * 
 * @author Keith & Dhiren
 * @version June 9, 2025
 */
public class WorldThree extends MyWorld {
    public WorldThree() {    
        super(new Hero());
        GreenfootImage image = new GreenfootImage("bg3.jpg");  
        image.scale(600, 400);
        setBackground(image);  
        removeObjects(getObjects(null));
        prepare();
    }
}
