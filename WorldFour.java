import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WorldFour here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WorldFour extends MyWorld
{

    /**
     * Constructor for objects of class WorldFour.
     * 
     */
    public WorldFour()
    {    
        super();
        GreenfootImage image = new GreenfootImage("bg4.jpg");  
        image.scale(600, 400);
        setBackground(image);  
        removeObjects(getObjects(SelectWorldOne.class));
        removeObjects(getObjects(SelectWorldTwo.class));
        removeObjects(getObjects(SelectWorldThree.class));
        removeObjects(getObjects(SelectWorldFour.class));
        removeObjects(getObjects(SelectWorldFive.class));
        prepare();
    }
}
