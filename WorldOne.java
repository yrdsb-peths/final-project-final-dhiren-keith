import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WorldOne here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WorldOne extends MyWorld
{

    /**
     * Constructor for objects of class WorldOne.
     * 
     */
    public WorldOne()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super();
        GreenfootImage image = new GreenfootImage("bg1.jpg");  
        image.scale(600, 400);
        setBackground(image);  
        removeObjects(getObjects(null));
        prepare();
    }
}
