import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SelectWorldOne here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SelectWorldOne extends Actor
{
    /**
     * Act - do whatever the SelectWorldOne wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public int persistentLevel;
    public SelectWorldOne() 
    {
        GreenfootImage image = new GreenfootImage("1.png");
        image.scale(75, 75);                
        setImage(image);                    
    }
    
    public int getLevel()
    {
        return persistentLevel;
    }
    public void act()
    {
        if(Greenfoot.mouseClicked(this))
        {
            if(persistentLevel == 0)
            {
                WorldOne worldOne = new WorldOne();
                Greenfoot.setWorld(worldOne);
            }
            else
            {
                Label label = new Label("Level not high enough for this world",30);
                
            }
        }
    }
}
