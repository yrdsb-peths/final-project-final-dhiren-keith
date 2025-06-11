import greenfoot.*;

/**
 * Represents an enemy character that moves toward the hero, attacks, and displays a health bar.
 * Enemy stats scale based on the current wave level.
 * 
 * @author Keith and Dhiren
 * @version June 9, 2025
 */
public class Enemy extends Actor {
    GreenfootImage[] enemyRight = new GreenfootImage[17];
    GreenfootImage[] enemyLeft = new GreenfootImage[17];
    String facing = "right";
    SimpleTimer animationTimer = new SimpleTimer();
    private int level; 
    private int maxHealth;
    private int currHealth;
    private String name;
    private int defense;
    private int attack;
    private int speed;
    private int attackCooldown = 30;
    private int cooldownTimer = 0;
    private EnemyHealthBar healthBar;

    int imageIndex = 0;

    public void animateEnemy() {
        if(animationTimer.millisElapsed() < 100) {
            return;
        }
        animationTimer.mark();
        if(facing.equals("right")) {
            setImage(enemyRight[imageIndex]);
            imageIndex = (imageIndex + 1) % enemyRight.length;
        } else {
            setImage(enemyLeft[imageIndex]);
            imageIndex = (imageIndex + 1) % enemyLeft.length;
        }
    }
    
    public Enemy(int waveNumber) {
        for(int i = 0; i < enemyRight.length; i++) {
            enemyRight[i] = new GreenfootImage("images/enemy/enemy" + i + ".png");
            enemyRight[i].scale(50,50);
        }
    
        for(int i = 0; i < enemyLeft.length; i++) {
            enemyLeft[i] = new GreenfootImage("images/enemy/enemy" + i + ".png");
            enemyLeft[i].scale(50,50);
            enemyLeft[i].mirrorHorizontally();
            enemyLeft[i].mirrorVertically();
        }
    
        animationTimer.mark();
        setImage(enemyRight[0]);
    
        this.level = waveNumber / 2;
    
        // Base stats
        this.maxHealth = 15 + (level * 15);
        this.defense = Math.max(1, level * 2);
        this.attack = 25 + (level / 2);
        this.speed = 2 + (level / 3);
    
        // BIGGER BOOST for level 20 and above
        if (level >= 20) {
            this.maxHealth *= 10;      // Big jump in health (10x)
            this.defense *= 5;         // Still 5x defense
            this.attack *= 2;          // Double attack
            this.speed += 3;           // Speed bonus
        }
    
        this.currHealth = maxHealth;
        this.name = "GOON";
    
        this.healthBar = new EnemyHealthBar(this);
    }




    public void addedToWorld(World world) {
        world.addObject(healthBar, getX(), getY() - 20);
    }

    public void act() {
        Hero hero = ((MyWorld) getWorld()).getHero();
        if (hero != null) {
            facing = (hero.getX() > getX()) ? "right" : "left";
        }
        
        moveTowardsHero();

        if (cooldownTimer > 0) {
            cooldownTimer--;
        } else {
            dealDamage(attack);
            cooldownTimer = attackCooldown;
        }

        if (healthBar != null && getWorld() != null) {
            healthBar.setLocation(getX(), getY() - 20);
        }
        
        animateEnemy();
    }

    private void moveTowardsHero() {
        World w = getWorld();
        if (w instanceof MyWorld) {
            Hero hero = ((MyWorld) w).getHero();
            if (hero != null) {
                turnTowards(hero.getX(), hero.getY());
                move(speed);
            }
        }
    }

    public void takeDamage(int damage) {
        int actualDamage = damage - defense;
        if (actualDamage <= 0) {
            actualDamage = 1;  // always do at least 1 damage
        }
        currHealth -= actualDamage;

        if (currHealth <= 0) {
            World w = getWorld();
            if (w instanceof MyWorld) {
                ((MyWorld) w).decrementEnemies();
            }
            if (w != null && healthBar != null) {
                w.removeObject(healthBar);
            }
            if (w != null) {
                w.removeObject(this);
            }
        }
    }

    public void dealDamage(int attack) {
        World w = getWorld();
        if (w instanceof MyWorld) {
            Hero hero = ((MyWorld) w).getHero();
            if (hero != null && this.intersects(hero)) {
                hero.takeDamage(attack);
            }
        }
    }

    public int getAttack() {
        return attack;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getHealth() {
        return currHealth;
    }
}
