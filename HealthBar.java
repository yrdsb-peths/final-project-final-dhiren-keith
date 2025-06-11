import greenfoot.*;

/**
 * HealthBar - Displays the Hero's current health visually as a bar.
 * Follows the Hero and updates to reflect changes in health.
 * Shows a red bar over a gray background to indicate remaining health.
 * 
 * @author Keith
 * @version June 9, 2025
 */
public class HealthBar extends Actor {
    private Hero hero;
    private int width = 30;
    private int height = 6;

    public HealthBar(Hero hero) {
        this.hero = hero;
        updateImage(); // Draw initial health bar
    }

    public void act() {
        updateImage(); // Refresh health bar
        followHero(); // Stay above the Hero
    }

    /**
     *  Updates the health bar's visual based on current health
     */
    private void updateImage() {
        int health = hero.getCurrentHealth();
        int maxHealth = hero.getMaxHealth();
        int barWidth = (int)((double)health / maxHealth * width);

        GreenfootImage image = new GreenfootImage(width, height);
        image.setColor(Color.GRAY);
        image.fillRect(0, 0, width, height);
        image.setColor(Color.RED);
        image.fillRect(0, 0, barWidth, height);
        setImage(image);
    }

    /**
     *  Moves the health bar to stay above Hero
     */
    private void followHero() {
        if (getWorld() != null && hero.getWorld() != null) {
            setLocation(hero.getX(), hero.getY() - 20);
        }
    }
}
