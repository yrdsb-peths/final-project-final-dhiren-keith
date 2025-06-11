import greenfoot.*;

/**
 * The StartScreen class displays the game's main menu.
 * It shows the title and controls, and starts the game when the user presses ENTER.
 * 
 * @author Keith
 * @version June 9, 2025
 */
public class StartScreen extends World {

    public StartScreen() {
        super(600, 400, 1); // Set world size
        drawScreen(); // Draw menu graphics
    }
    /**
     *  Draws the title and instructions on the screen
     */
    private void drawScreen() {
        GreenfootImage bg = getBackground();
        bg.setColor(Color.BLACK);
        bg.fill(); // Fill background black

        bg.setColor(Color.WHITE);
        bg.setFont(new Font("Arial", true, false, 40)); //Bold font for title
        bg.drawString("SHOOTY MCSHOOTFACE", 50, 150);

        bg.setFont(new Font("Arial", false, false, 24)); // Regular font for instructions
        bg.drawString("Press ENTER to Start", 180, 240);
        bg.drawString("Use W A S D to Move", 190, 280);
        bg.drawString("Use Arrow Keys to Shoot", 160, 310);
    }
    /**
     * Start game when enter key is pressed
     */
    public void act() {
        if (Greenfoot.isKeyDown("enter")) {
            Greenfoot.setWorld(new MyWorld());
        }
    }
}
