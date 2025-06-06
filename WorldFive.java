import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WorldFive here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WorldFive extends MyWorld
{

    /**
     * Constructor for objects of class WorldFive.
     * 
     */
    public WorldFive()
    {    
        super();
        GreenfootImage image = new GreenfootImage("bg5.jpg");  
        image.scale(600, 400);
        setBackground(image);  
        removeObjects(getObjects(null));
        prepare();
    }
}
