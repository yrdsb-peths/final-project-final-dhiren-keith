import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * WorldFour is the fourth game level with its unique background and setup.
 * 
 * @author Keith & Dhiren
 * @version June 9, 2025
 */
public class WorldFour extends MyWorld {
    public WorldFour() {    
        super(new Hero());
        GreenfootImage image = new GreenfootImage("bg4.jpg");  
        image.scale(600, 400);
        setBackground(image);  
        removeObjects(getObjects(null)); // Clear all objects before setup
        prepare(); // Initialize objects specific to WorldFour
    }
}
