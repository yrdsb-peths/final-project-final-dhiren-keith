import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SelectWorldFour here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SelectWorldFour extends Actor
{
    /**
     * Act - do whatever the SelectWorldFour wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public int level;
    public SelectWorldFour() 
    {
        GreenfootImage image = new GreenfootImage("4.png");
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
            if(level == 60)
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
