import greenfoot.*;

public class Hero extends Actor {

    GreenfootImage[] heroRight = new GreenfootImage[10];
    GreenfootImage[] heroLeft = new GreenfootImage[10];
    String facing = "right";
    SimpleTimer animationTimer = new SimpleTimer();
    public static int persistentLevel = 0;
    private int level;
    private int maxHealth;
    private int currHealth;
    private int defense;
    private int attack;
    private int speed;

    private double shootDelay;
    private int shootTimer = 0;

    int imageIndex = 0;

    public Hero() {
        for(int i = 0; i < heroRight.length; i++) {
            heroRight[i] = new GreenfootImage("images/hero/hero" + i + ".png");
            heroRight[i].scale(50,50);
        }

        for(int i = 0; i < heroLeft.length; i++) {
            heroLeft[i] = new GreenfootImage("images/hero/hero" + i + ".png");
            heroLeft[i].scale(50,50);
            heroLeft[i].mirrorHorizontally();
        }

        animationTimer.mark();
        setImage(heroRight[0]);

        this.level = persistentLevel;
        this.maxHealth = 100 + (level / 5) * 10;
        this.currHealth = maxHealth;
        this.defense = 1 + (level / 5);
        this.attack = 1 + (level / 5);
        this.speed = 3 + (level / 10);

        updateShootDelay();
    }

    public void act() {
        checkKeys();
        shootTimer++;
        animateHero();

        // Cheat key: press "l" to level up
        if (Greenfoot.isKeyDown("l")) {
            levelUp();
        }
    }

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
        // Only do triple shot if tripleUnlocked is true
        if (MyWorld.tripleUnlocked) {
            shootSingle(direction, 0);
            shootSingle(direction, 10);
            shootSingle(direction, -10);
        } else {
            shootSingle(direction, 0);
        }
    }

    private void shootSingle(String direction, int angleOffset) {
        int damage = attack * 5;
        Bullet bullet = new Bullet(direction, damage, angleOffset);
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

    private void updateShootDelay() {
        double baseDelay = 20.0;
        double minDelay = 10.0;
        double maxLevel = 80.0;

        double progress = Math.min(level / maxLevel, 1.0);
        shootDelay = baseDelay - (baseDelay - minDelay) * progress;
    }

    public static void levelUpPersistent(int amount) {
        persistentLevel += amount;
        if (persistentLevel > 80) persistentLevel = 80;
    }

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
