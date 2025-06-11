import greenfoot.*;

/**
 * GameOver displays the end screen when the player loses the game.
 * It shows a black background with a red "GAME OVER" message.
 * 
 * @author Keith & Dhiren
 * @version June 9, 2025
 */
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
    }
}
