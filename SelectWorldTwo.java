import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SelectWorldTwo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SelectWorldTwo extends Actor
{
    /**
     * Act - do whatever the SelectWorldTwo wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public int level;
    public SelectWorldTwo() 
    {
        GreenfootImage image = getImage();
        image.scale(75, 75);                
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
            if(level == 20)
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
