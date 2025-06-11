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
    }
}
   

