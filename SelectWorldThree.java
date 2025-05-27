import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SelectWorldThree here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SelectWorldThree extends Actor
{
    /**
     * Act - do whatever the SelectWorldThree wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public int level;
    public SelectWorldThree() 
    {
        GreenfootImage image = new GreenfootImage("3.png");
        image.scale(120, 120);                
        setImage(image);                    
    }
    
    public int getLevel()
    {
        return level;
    }
    public void act()
    {
        if(Greenfoot.mouseClicked(this))
        {
            if(level == 40)
            {
               Greenfoot.setWorld(new WorldTwo()); 
            }
            else
            {
                Label label = new Label("Level not high enough for this world",30);
                
            }
        }
    }
}
