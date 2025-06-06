import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WorldTwo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WorldTwo extends MyWorld
{

    /**
     * Constructor for objects of class WorldTwo.
     * 
     */
    public WorldTwo()
    {    
        super();
        GreenfootImage image = new GreenfootImage("bg2.jpg");  
        image.scale(600, 400);
        setBackground(image);  
        removeObjects(getObjects(null));
        prepare();
    }
}
