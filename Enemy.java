import greenfoot.*;

public class Enemy extends Actor {
    private int level; 
    private int maxHealth;
    private int currHealth;
    private String name;
    private int defense;
    private int attack;
    private int speed;
    private int attackCooldown = 30;
    private int cooldownTimer = 0;
    

    public Enemy(int waveNumber) {
        this.level = waveNumber / 2;
        this.maxHealth = 40 + (level * 5);
        this.currHealth = maxHealth;
        this.name = "GOON";
        this.defense = 0;
        this.attack = 25 + (level / 2);
        this.speed = 2 + (level / 3);
    }


    public void act() {
        moveTowardsHero();
    
        if (cooldownTimer > 0) {
            cooldownTimer--;
        } else {
            dealDamage(attack);
            cooldownTimer = attackCooldown;
        }
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
        int actualDamage = Math.max(0, damage - defense);
        currHealth -= actualDamage;
        if (currHealth <= 0) {
            MyWorld world = (MyWorld) getWorld();
            if (world != null) {
                world.decrementEnemies();
            }
            getWorld().removeObject(this);
        }
    }
    public void dealDamage(int attack) {
        MyWorld world = (MyWorld) getWorld();
        if (world != null) {
            Hero hero = world.getHero();
            if (hero != null && this.intersects(hero)) {
                hero.takeDamage(attack);
            }
        }
    }
    public int getAttack(){
        return attack;
    }
}

