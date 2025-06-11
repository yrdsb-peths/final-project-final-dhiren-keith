import greenfoot.*;

/**
 * Represents the player character controlled by the user.
 * Handles movement, shooting (including triple and piercing shots),
 * leveling up, health management, and animation.
 * 
 * Player stats such as health, attack, defense, and speed scale with level.
 * Special shooting abilities unlock at certain levels.
 * 
 * @author Keith
 * @version June 10, 2025
 */
public class Hero extends Actor {

    // Animation frames for right-facing hero
    private GreenfootImage[] heroRight = new GreenfootImage[10];
    // Animation frames for left-facing hero (mirrored)
    private GreenfootImage[] heroLeft = new GreenfootImage[10];
    
    // Current facing direction ("right" or "left")
    private String facing = "right";
    
    // Timer used to control animation frame rate
    private SimpleTimer animationTimer = new SimpleTimer();
    
    // Persistent player level saved across sessions
    public static int persistentLevel = 0;
    
    // Player stats
    private int level;
    private int maxHealth;
    private int currHealth;
    private int defense;
    private int attack;
    private int speed;

    // Shooting delay variables
    private double shootDelay;   // How long to wait between shots
    private int shootTimer = 0;  // Counts frames since last shot

    // Index of current animation frame
    private int imageIndex = 0;

    /**
     * Constructs a Hero object.
     * Initializes images, scales them, and sets stats based on persistent level.
     * Sets initial shooting delay.
     */
    public Hero() {
        // Load right-facing images and scale them
        for(int i = 0; i < heroRight.length; i++) {
            heroRight[i] = new GreenfootImage("images/hero/hero" + i + ".png");
            heroRight[i].scale(50, 50);
        }

        // Load left-facing images by mirroring the right images
        for(int i = 0; i < heroLeft.length; i++) {
            heroLeft[i] = new GreenfootImage("images/hero/hero" + i + ".png");
            heroLeft[i].scale(50, 50);
            heroLeft[i].mirrorHorizontally();
        }

        animationTimer.mark();  // Start animation timer
        setImage(heroRight[0]); // Set initial image

        // Initialize stats scaled by persistent level
        this.level = persistentLevel;
        this.maxHealth = 100 + (level / 5) * 10;
        this.currHealth = maxHealth;
        this.defense = 1 + (level / 5);
        this.attack = 1 + (level / 5);
        this.speed = 3 + (level / 10);

        updateShootDelay();  // Calculate initial shoot delay based on level
    }

    /**
     * Act method called every frame.
     * Handles player input, shooting cooldown, animation,
     * and cheat key for leveling up.
     */
    public void act() {
        checkKeys();     // Handle movement and shooting input
        shootTimer++;    // Increment shoot cooldown timer
        animateHero();   // Update animation frames

        // Cheat key: press "l" to instantly level up by 5
        if (Greenfoot.isKeyDown("l")) {
            levelUp();
        }
    }

    /**
     * Checks for keyboard inputs to move the hero and shoot bullets.
     * Moves hero based on WASD keys and shoots based on arrow keys if cooldown permits.
     */
    private void checkKeys() {
        if (Greenfoot.isKeyDown("a")) {
            move(-speed);
            facing = "left";
        }
        if (Greenfoot.isKeyDown("d")) {
            move(speed);
            facing = "right";
        }
        if (Greenfoot.isKeyDown("w")) {
            setLocation(getX(), getY() - speed);
        }
        if (Greenfoot.isKeyDown("s")) {
            setLocation(getX(), getY() + speed);
        }

        // Shoot if cooldown has passed and shooting keys are pressed
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

    /**
     * Shoots bullets in a given direction.
     * Fires triple bullets if triple shot is unlocked, otherwise fires a single bullet.
     * 
     * @param direction The direction to shoot ("up", "down", "left", "right")
     */
    private void shoot(String direction) {
        if (MyWorld.tripleUnlocked) {
            shootSingle(direction, 0);
            shootSingle(direction, 10);
            shootSingle(direction, -10);
        } else {
            shootSingle(direction, 0);
        }
    }

    /**
     * Creates and adds a single bullet to the world with a direction and angle offset.
     * 
     * @param direction Direction bullet travels
     * @param angleOffset Angle offset for bullet trajectory in degrees
     */
    private void shootSingle(String direction, int angleOffset) {
        int damage = attack * 5;
        Bullet bullet = new Bullet(direction, damage, angleOffset);
        getWorld().addObject(bullet, getX(), getY());
    }

    /**
     * Reduces the hero's current health by the specified damage amount.
     * Switches to GameOver world if health falls to zero or below.
     * 
     * @param damage Amount of damage to apply
     */
    public void takeDamage(int damage) {
        currHealth -= damage;
        if (currHealth <= 0) {
            currHealth = 0;
            Greenfoot.setWorld(new GameOver());
        }
    }

    /**
     * Returns the hero's current attack stat.
     * 
     * @return attack stat
     */
    public int getAttack() {
        return attack;
    }

    /**
     * Returns the hero's current defense stat.
     * 
     * @return defense stat
     */
    public int getDefense() {
        return defense;
    }

    /**
     * Returns the hero's current health.
     * 
     * @return current health
     */
    public int getCurrentHealth() {
        return currHealth;
    }

    /**
     * Returns the hero's maximum health.
     * 
     * @return max health
     */
    public int getMaxHealth() {
        return maxHealth;
    }

    /**
     * Returns the hero's current level.
     * 
     * @return player level
     */
    public int getLevel() {
        return level;
    }

    /**
     * Returns the persistent level saved across sessions.
     * 
     * @return persistent player level
     */
    public static int getPersistentLevel() {
        return persistentLevel;
    }

    /**
     * Resets the persistent level to zero.
     */
    public static void resetPersistentLevel() {
        persistentLevel = 0;
    }

    /**
     * Heals the hero by a specified amount without exceeding max health.
     * 
     * @param amount Amount to heal
     */
    public void heal(int amount) {
        currHealth += amount;
        if (currHealth > maxHealth) {
            currHealth = maxHealth;
        }
    }

    /**
     * Sets the hero's attack stat.
     * 
     * @param attack New attack value
     */
    public void setAttack(int attack) {
        this.attack = attack;
    }

    /**
     * Sets the hero's defense stat.
     * 
     * @param defense New defense value
     */
    public void setDefense(int defense) {
        this.defense = defense;
    }

    /**
     * Increases the hero's level by 5, updates stats,
     * unlocks special abilities at specific levels,
     * and displays unlock notifications.
     */
    public void levelUp() {
        level += 5;

        // Unlock piercing shot at level 20
        if (level >= 20 && !MyWorld.piercingUnlocked) {
            MyWorld.piercingUnlocked = true;
            Label unlockLabel = new Label("Piercing Shot Unlocked!", "Arial", 36);
            unlockLabel.setFillColor(Color.YELLOW);
            unlockLabel.setLineColor(Color.BLACK);
            getWorld().addObject(unlockLabel, getWorld().getWidth() / 2, getWorld().getHeight() / 4);
        }

        // Unlock triple shot at level 40
        if (level >= 40 && !MyWorld.tripleUnlocked) {
            MyWorld.tripleUnlocked = true;
            Label tripleLabel = new Label("Triple Shot Unlocked!", "Arial", 36);
            tripleLabel.setFillColor(Color.ORANGE);
            tripleLabel.setLineColor(Color.BLACK);
            getWorld().addObject(tripleLabel, getWorld().getWidth() / 2, getWorld().getHeight() / 4 + 40);
        }

        maxHealth += 10;
        currHealth = maxHealth;
        attack += 3;
        defense++;
        speed++;
        heal(maxHealth);
        persistentLevel = level;

        updateShootDelay();
    }

    /**
     * Updates the shooting delay based on the current level.
     * Delay decreases linearly from 20 to 10 as level approaches 80.
     */
    private void updateShootDelay() {
        final double baseDelay = 20.0;
        final double minDelay = 10.0;
        final double maxLevel = 80.0;

        double progress = Math.min(level / maxLevel, 1.0);
        shootDelay = baseDelay - (baseDelay - minDelay) * progress;
    }

    /**
     * Increases the persistent level by a specified amount,
     * capping at 80.
     * 
     * @param amount Number of levels to add
     */
    public static void levelUpPersistent(int amount) {
        persistentLevel += amount;
        if (persistentLevel > 80) persistentLevel = 80;
    }

    /**
     * Animates the hero sprite by cycling through the image array
     * based on the facing direction.
     * Updates frame every 100 milliseconds.
     */
    public void animateHero() {
        if (animationTimer.millisElapsed() < 100) {
            return;
        }
        animationTimer.mark();

        if (facing.equals("right")) {
            setImage(heroRight[imageIndex]);
        } else {
            setImage(heroLeft[imageIndex]);
        }

        imageIndex = (imageIndex + 1) % heroRight.length;
    }
}
