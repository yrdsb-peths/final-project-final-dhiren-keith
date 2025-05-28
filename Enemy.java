import greenfoot.*;

public class Enemy extends Actor {
    private int level; 
    private int maxHealth;
    private int currHealth;
    private String name;
    private int defense;
    private int attack;
    private int speed = 2;

    public Enemy(int level, int maxHealth, String name, int defense, int attack) {
        this.level = level;
        this.maxHealth = maxHealth;
        this.currHealth = maxHealth;
        this.name = name;
        this.defense = defense;
        this.attack = attack;
    }

    public void act() {
        moveTowardsHero();
    }

    private void moveTowardsHero() {
        MyWorld world = (MyWorld) getWorld();
        if (world != null) {
            Hero hero = world.getHero();
            if (hero != null) {
                int heroX = hero.getX();
                int heroY = hero.getY();

                turnTowards(heroX, heroY);
                move(speed);
            }
        }
    }

    public void takeDamage(int damage) {
        int effectiveDamage = damage - defense;
        if (effectiveDamage < 0) {
            effectiveDamage = 0;
        }
    
        currHealth -= effectiveDamage;
    
        if (currHealth <= 0) {
            MyWorld world = (MyWorld) getWorld();
            if (world != null) {
                world.decrementEnemies();
            }
            getWorld().removeObject(this);
        }
    }
}
