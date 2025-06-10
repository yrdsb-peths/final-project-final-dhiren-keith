import greenfoot.*;

public class EnemyHealthBar extends Actor {
    private Enemy enemy;
    private int width = 30;
    private int height = 4;

    public EnemyHealthBar(Enemy enemy) {
        this.enemy = enemy;
        updateImage();
    }

    public void act() {
        updateImage();
    }

    private void updateImage() {
        int current = enemy.getHealth();
        int max = enemy.getMaxHealth();
        int barWidth = (int)((double) current / max * width);

        GreenfootImage image = new GreenfootImage(width, height);
        image.setColor(Color.GRAY);
        image.fillRect(0, 0, width, height);
        image.setColor(Color.RED);
        image.fillRect(0, 0, barWidth, height);
        setImage(image);
    }
}
