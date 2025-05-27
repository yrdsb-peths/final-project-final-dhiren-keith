import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WorldThree here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WorldThree extends World
{

    /**
     * Constructor for objects of class WorldThree.
     * 
     */
    public WorldThree()
    {    
        super(600, 400, 1); 
        GreenfootImage image = new GreenfootImage("bg3.png");  
        image.scale(600, 400);
        setBackground(image);  
 
    }
}
