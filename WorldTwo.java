import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * WorldTwo is the second game level with its unique background and setup.
 * 
 * @author Keith & Dhiren
 * @version June 9, 2025
 */
public class WorldTwo extends MyWorld {
    public WorldTwo() {    
        super(new Hero());
        GreenfootImage image = new GreenfootImage("bg2.jpg");  
        image.scale(600, 400);
        setBackground(image);  
        removeObjects(getObjects(null)); // Clear existing objects
        prepare(); // Setup initial objects for WorldTwo
    }
}
