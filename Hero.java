
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Hero class represents the player character.
 * Write a description of class Hero here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Hero extends Actor{
    private int level; 
    private int maxHealth;
    private int currHealth;
    private int defense;
    private int attack;
    private int speed;
    
    private int shootDelay = 15; 
    private int shootTimer = 0;

    public Hero() {
        this.level = 1;
        this.maxHealth = 100;
        this.currHealth = maxHealth; 
        this.defense = 0;
        this.attack = 1;
        this.speed = 3;
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
        Bullet bullet = new Bullet(direction);
        getWorld().addObject(bullet, getX(), getY());
    }

    public void takeDamage(int damage) {
        if(isTouching(Boss.class))
        {
            int actualDamage = Math.max(0, damage - defense);
            currHealth -= actualDamage;

            if (currHealth <= 0) {
                currHealth = 0;
                Greenfoot.setWorld(new GameOver());
            }
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
    
    public int getLevel(){
        return level;
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
        this.attack = attack;
    }

    public void levelUp() {
        level+=5;
        maxHealth += 10;
        currHealth = maxHealth;
        attack++;
        defense++;
        speed++;
    }
    
    public void onWaveCleared()
    {
        levelUp();
    }
}


