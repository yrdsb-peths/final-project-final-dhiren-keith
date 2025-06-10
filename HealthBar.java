import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HealthBar extends Actor {
    private Hero hero;
    private int width = 30;
    private int height = 6;

    public HealthBar(Hero hero) {
        this.hero = hero;
        updateImage();
    }

    public void act() {
        updateImage();
        followHero();
    }

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

    private void followHero() {
        if (getWorld() != null && hero.getWorld() != null) {
            setLocation(hero.getX(), hero.getY() - 20);
        }
    }
}
