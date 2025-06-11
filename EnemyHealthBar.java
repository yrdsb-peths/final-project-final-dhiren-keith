import greenfoot.*;

/**
 * EnemyHealthBar - Visual health bar that follows an enemy and displays its current health.
 * Shows the proportion of health remaining with a red bar over a gray background.
 * 
 * @author Keith
 * @version June 9, 2025
 */
public class EnemyHealthBar extends Actor {
    private Enemy enemy;
    private int width = 30;
    private int height = 4;

    public EnemyHealthBar(Enemy enemy) {
        this.enemy = enemy;
        updateImage(); // Draw initial health bar
    }

    public void act() {
        updateImage(); // Update every frame
    }
    
    /**
     *  Updates the visual bar based on current health
     */
    private void updateImage() {
        int current = enemy.getHealth();
        int max = enemy.getMaxHealth();
        int barWidth = (int)((double) current / max * width);

        GreenfootImage image = new GreenfootImage(width, height);
        image.setColor(Color.GRAY); // Background
        image.fillRect(0, 0, width, height);
        image.setColor(Color.RED); // Health amount
        image.fillRect(0, 0, barWidth, height);
        setImage(image);
    }
}
