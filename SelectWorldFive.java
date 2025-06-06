import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SelectWorldFive here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SelectWorldFive extends Actor
{
    /**
     * Act - do whatever the SelectWorldFive wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public int level;
    public SelectWorldFive() 
    {
        GreenfootImage image = new GreenfootImage("5.png");
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
            if(level == 80)
            {
               Greenfoot.setWorld(new WorldTwo()); 
               
            }
            else
            {
                Label label = new Label("Level not high enough for this world","Arial",30);
                
            }
        }
    }
}
