import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Hero class represents the player character.
 */
public class Hero extends Actor {
    private static int persistentLevel = 0;
    private int level; 
    private int maxHealth;
    private int currHealth;
    private int defense;
    private int attack;
    private int speed;
    
    private double shootDelay;
    private int shootTimer = 0;

    public Hero() {
        this.level = persistentLevel;
        this.maxHealth = 100 + (level / 5) * 10;
        this.currHealth = maxHealth; 
        this.defense = 1 + (level / 5);
        this.attack = 1 + (level / 5);
        this.speed = 3 + (level / 10);

        updateShootDelay(); // Set shoot delay based on level
    }

    public void act() {
        checkKeys();
        shootTimer++;
    }

    private void checkKeys() {
        if (Greenfoot.isKeyDown("a")) {
            move(-speed);
        }
        if (Greenfoot.isKeyDown("d")) {
            move(speed);
        }
        if (Greenfoot.isKeyDown("w")) {
            setLocation(getX(), getY() - speed);
        }
        if (Greenfoot.isKeyDown("s")) {
            setLocation(getX(), getY() + speed);
        }

        // Shoot in the direction of the arrow keys
        if (shootTimer >= shootDelay) {
            if (Greenfoot.isKeyDown("left")) {
                shoot("left");
                shootTimer = 0; 
            } else if (Greenfoot.isKeyDown("right")) {
                shoot("right");
                shootTimer = 0;
            } else if (Greenfoot.isKeyDown("up")) {
                shoot("up");
                shootTimer = 0;
            } else if (Greenfoot.isKeyDown("down")) {
                shoot("down");
                shootTimer = 0;
            }
        }
    }

    private void shoot(String direction) {
        Bullet bullet = new Bullet(direction, attack * 10);
        getWorld().addObject(bullet, getX(), getY());
    }

    public void takeDamage(int damage) {
        currHealth -= damage;
        if (currHealth <= 0) {
            currHealth = 0;
            Greenfoot.setWorld(new GameOver());
        }
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getCurrentHealth() {
        return currHealth;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getLevel() {
        return level;
    }

    public static int getPersistentLevel() {
        return persistentLevel;
    }

    public static void resetPersistentLevel() {
        persistentLevel = 0;
    }

    public void heal(int amount) {
        currHealth += amount;
        if (currHealth > maxHealth) {
            currHealth = maxHealth;
        }
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public void levelUp() {
        level += 5;
        maxHealth += 10;
        currHealth = maxHealth;
        attack++;
        defense++;
        speed++;
        heal(maxHealth);
        persistentLevel = level;
        updateShootDelay(); // Recalculate shoot delay

        if (level >= 20 && !MyWorld.piercingUnlocked) {
            MyWorld.piercingUnlocked = true;
            Label unlockLabel = new Label("Piercing Shot Unlocked!", "Arial", 36);
            unlockLabel.setFillColor(Color.YELLOW);
            unlockLabel.setLineColor(Color.BLACK);
            getWorld().addObject(unlockLabel, getWorld().getWidth() / 2, getWorld().getHeight() / 4);
        }
    }

    private void updateShootDelay() {
        double baseDelay = 20.0;
        double minDelay = 10.0;
        double maxLevel = 80.0;

        double progress = Math.min(level / maxLevel, 1.0);
        shootDelay = baseDelay - (baseDelay - minDelay) * progress;
    }
}
