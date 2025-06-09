import greenfoot.*;

public class GameOver extends World {

    public GameOver() {
        super(600, 400, 1);
        drawScreen();
    }

    private void drawScreen() {
        GreenfootImage bg = getBackground();
        bg.setColor(Color.BLACK);
        bg.fill();

        bg.setColor(Color.RED);
        bg.setFont(new Font("Arial", true, false, 50));
        bg.drawString("GAME OVER", 150, 150);

        bg.setColor(Color.WHITE);
        bg.setFont(new Font("Arial", false, false, 24));
        bg.drawString("Press 'R' to Restart", 180, 240);
        bg.drawString("Press 'Q' to Quit", 200, 280);
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
