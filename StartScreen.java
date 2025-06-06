import greenfoot.*;

public class StartScreen extends World {

    public StartScreen() {
        super(600, 400, 1);
        drawScreen();
    }

    private void drawScreen() {
        GreenfootImage bg = getBackground();
        bg.setColor(Color.BLACK);
        bg.fill();

        bg.setColor(Color.WHITE);
        bg.setFont(new Font("Arial", true, false, 40));
        bg.drawString("SHOOTY MCSHOOTFACE",50, 150);

        bg.setFont(new Font("Arial", false, false, 24));
        bg.drawString("Press ENTER to Start", 180, 240);
        bg.drawString("Use W A S D to Move", 190, 280);
        bg.drawString("Use Arrow Keys to Shoot", 160, 310);
    }

    public void act() {
        if (Greenfoot.isKeyDown("enter")) {
            Greenfoot.setWorld(new MyWorld());
        }
    }
}
