import greenfoot.*;
import java.util.HashSet;

/**
 * Bullet - Represents a projectile fired by the player.
 * Moves in a specified direction with optional angle offset (for triple shot).
 * Deals damage to enemies and supports piercing shots that hit multiple enemies.
 * 
 * @author Keith and Dhiren
 * @version June 10, 2025
 */
public class Bullet extends Actor {
    private int speed = 10;               // Movement speed of the bullet
    private int damage;                   // Damage dealt to each enemy hit
    private double dx;                   // Horizontal velocity component
    private double dy;                   // Vertical velocity component

    // Track enemies that have already been hit by this bullet to prevent double damage
    private HashSet<Enemy> enemiesHit = new HashSet<>();

    /**
     * Constructs a Bullet that moves in the specified direction with optional angle offset.
     * The angle offset allows for spread shots such as triple shot.
     * 
     * @param direction   The cardinal direction ("left", "right", "up", "down") the bullet is fired towards
     * @param damage      The amount of damage this bullet deals to enemies
     * @param angleOffset The angle in degrees to offset from the base direction for spread shooting
     */
    public Bullet(String direction, int damage, int angleOffset) {
        this.damage = damage;

        // Determine base angle (in degrees) from direction string
        int baseAngle = switch (direction) {
            case "left" -> 180;
            case "right" -> 0;
            case "up" -> 270;
            case "down" -> 90;
            default -> 0;
        };

        // Apply angle offset for spread shots and set rotation for visual orientation
        int finalAngle = baseAngle + angleOffset;
        setRotation(finalAngle);

        // Calculate velocity components based on final angle and speed
        double radians = Math.toRadians(finalAngle);
        dx = Math.cos(radians) * speed;
        dy = Math.sin(radians) * speed;

        // Load and scale bullet image
        GreenfootImage image = new GreenfootImage("bullet.png");
        image.scale(20, 10);
        setImage(image);
    }

    /**
     * Called on each frame.
     * Moves the bullet according to its velocity,
     * checks for collisions with enemies, and removes bullet if out of bounds.
     */
    public void act() {
        moveInAngle();

        // If collision occurred and bullet should be removed, stop further processing
        if (checkCollision()) return;

        // Remove bullet if it has moved outside the world boundaries
        checkBounds();
    }

    /**
     * Moves the bullet by its calculated velocity components.
     */
    private void moveInAngle() {
        setLocation((int)(getX() + dx), (int)(getY() + dy));
    }

    /**
     * Checks if the bullet has collided with an enemy.
     * If the enemy has not been hit before by this bullet, deals damage.
     * If piercing shots are not unlocked, removes bullet upon hitting an enemy.
     * 
     * @return true if bullet was removed due to collision; false otherwise
     */
    private boolean checkCollision() {
        Enemy enemy = (Enemy)getOneIntersectingObject(Enemy.class);
        if (enemy != null) {
            if (!enemiesHit.contains(enemy)) {
                enemy.takeDamage(damage);
                enemiesHit.add(enemy);

                // Remove bullet on hit unless piercing shot is enabled
                if (!MyWorld.piercingUnlocked) {
                    getWorld().removeObject(this);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Removes the bullet from the world if it has reached the edge of the screen.
     */
    private void checkBounds() {
        if (isAtEdge()) {
            getWorld().removeObject(this);
        }
    }
}
