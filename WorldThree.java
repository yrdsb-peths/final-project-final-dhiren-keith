import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WorldThree here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WorldThree extends MyWorld
{

    /**
     * Constructor for objects of class WorldThree.
     * 
     */
    public WorldThree()
    {    
        super(new Hero());
        GreenfootImage image = new GreenfootImage("bg3.jpg");  
        image.scale(600, 400);
        setBackground(image);  
        removeObjects(getObjects(null));
        prepare();
    }
}
