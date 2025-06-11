import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The WinScreen class is displayed when the player wins the game.
 * It shows a background image and gives options to restart or quit.
 * 
 * @author Keith
 * @version June 9, 2025
 */
public class WinScreen extends World {
    GreenfootSound winSound = new GreenfootSound("winSound.mp3");
    public WinScreen() {    
        super(600, 400, 1);
        winSound.play();
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
