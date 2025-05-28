import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WorldFour here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WorldFour extends World
{

    /**
     * Constructor for objects of class WorldFour.
     * 
     */
    public WorldFour()
    {    
        super(600, 400, 1); 
        GreenfootImage image = new GreenfootImage("bg4.jpg");  
        image.scale(600, 400);
        setBackground(image);  

    }
}
