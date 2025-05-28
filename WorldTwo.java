import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WorldTwo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WorldTwo extends World
{

    /**
     * Constructor for objects of class WorldTwo.
     * 
     */
    public WorldTwo()
    {    
        
        super(600, 400, 1); 
        GreenfootImage image = new GreenfootImage("bg2.jpg");  
        image.scale(600, 400);
        setBackground(image);  

    }
    
}
