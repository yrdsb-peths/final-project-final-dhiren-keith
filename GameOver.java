import greenfoot.*;

/**
 * GameOver displays the end screen when the player loses the game.
 * It shows a black background with a red "GAME OVER" message.
 * 
 * @author Keith & Dhiren
 * @version June 9, 2025
 */
public class GameOver extends World {
    GreenfootSound gameOverSound = new GreenfootSound("gameOver.mp3");
    public GameOver() {
        super(600, 400, 1);
        gameOverSound.play(); // Play game over sound
        drawScreen(); // Draw background and text
    }

    /**
     * Draws black background and red Game Over text
     */
    private void drawScreen() {
        GreenfootImage bg = getBackground();
        bg.setColor(Color.BLACK);
        bg.fill();

        bg.setColor(Color.RED);
        bg.setFont(new Font("Arial", true, false, 50));
        bg.drawString("GAME OVER", 150, 150);
    }
}
