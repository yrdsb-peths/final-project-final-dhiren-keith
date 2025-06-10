import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WinScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WinScreen extends World
{

    /**
     * Constructor for objects of class WinScreen.
     * 
     */
    public WinScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        GreenfootImage image = new GreenfootImage("win.jpg");
        image.scale(600, 400);
        setBackground(image);
        
        screenText();

    }
    
    private void screenText() {
        GreenfootImage bg = getBackground();
        bg.setColor(Color.WHITE);
        bg.setFont(new Font("Arial", false, false, 24));

        bg.drawString("Press 'R' to Restart", 180, 340);
        bg.drawString("Press 'Q' to Quit", 200, 380);
        
    }
    public void act() {
        if (Greenfoot.isKeyDown("r")) {
            Greenfoot.setWorld(new StartScreen());
        }
        if (Greenfoot.isKeyDown("q")) {
            Greenfoot.stop();
        }
    }
}
