import greenfoot.*;
import java.util.HashSet;

/**
 * Bullet - Represents a projectile fired by the player.
 * Moves in a specified direction and deals damage to enemies.
 * Supports piercing shots if enabled in MyWorld.
 * Now also supports angle offsets for triple shot.
 * 
 * @author Keith and Dhiren
 * @version June 10, 2025
 */
public class Bullet extends Actor {
    private int speed = 10;
    private int damage;
    private double dx;
    private double dy;

    // ✅ Track which enemies have been hit
    private HashSet<Enemy> enemiesHit = new HashSet<>();

    public Bullet(String direction, int damage, int angleOffset) {
        this.damage = damage;

        // Determine base angle
        int baseAngle = switch (direction) {
            case "left" -> 180;
            case "right" -> 0;
            case "up" -> 270;
            case "down" -> 90;
            default -> 0;
        };

        int finalAngle = baseAngle + angleOffset;
        setRotation(finalAngle); // For bullet image

        double radians = Math.toRadians(finalAngle);
        dx = Math.cos(radians) * speed;
        dy = Math.sin(radians) * speed;

        GreenfootImage image = new GreenfootImage("bullet.png");
        image.scale(20, 10);
        setImage(image);
    }

    public void act() {
        moveInAngle();
        if (checkCollision()) return;
        checkBounds();
    }

    private void moveInAngle() {
        setLocation((int)(getX() + dx), (int)(getY() + dy));
    }

    private boolean checkCollision() {
        Enemy enemy = (Enemy)getOneIntersectingObject(Enemy.class);
        if (enemy != null) {
           
            if (!enemiesHit.contains(enemy)) {
                enemy.takeDamage(damage);
                enemiesHit.add(enemy);

        
                if (!MyWorld.piercingUnlocked) {
                    getWorld().removeObject(this);
                    return true;
                }
            }
        }
        return false;
    }

    private void checkBounds() {
        if (isAtEdge()) {
            getWorld().removeObject(this);
        }
    }
}
