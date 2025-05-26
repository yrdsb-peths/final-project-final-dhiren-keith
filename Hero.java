
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

    public Hero() {
        this.level = 1;
        this.maxHealth = 100;
        this.currHealth = maxHealth; 
        this.defense = 0;
        this.attack = 1;
    }

    public void act() {
        checkKeys();
    }

    private void checkKeys() {
        if (Greenfoot.isKeyDown("a")) {
            move(-5);
        }
        if (Greenfoot.isKeyDown("d")) {
            move(5);
        }
        if (Greenfoot.isKeyDown("w")) {
            setLocation(getX(), getY() - 5);
        }
        if (Greenfoot.isKeyDown("s")) {
            setLocation(getX(), getY() + 5);
        }

        // Shoot in the direction of the arrow keys
        if (Greenfoot.isKeyDown("left")) {
            shoot("left");
        }
        if (Greenfoot.isKeyDown("right")) {
            shoot("right");
        }
        if (Greenfoot.isKeyDown("up")) {
            shoot("up");
        }
        if (Greenfoot.isKeyDown("down")) {
            shoot("down");
        }
    }

    private void shoot(String direction) {
        Bullet bullet = new Bullet(direction);
        getWorld().addObject(bullet, getX(), getY());
    }

    public void takeDamage(int damage) {
        int actualDamage = Math.max(0, damage - defense);
        currHealth -= actualDamage;

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
        level++;
        maxHealth += 10; // Example growth
        currHealth = maxHealth;
        attack++;
        defense++;
<<<<<<< HEAD
=======
    }
    {
        
    }
    public void takeDamage(int damage) {
        currHealth -= damage - defense;
        if (currHealth < 0){
            currHealth = 0;
            GameOver gameWorld = new GameOver();
            Greenfoot.setWorld(gameWorld);
        }
        
>>>>>>> 5050f1322ff902331250e8fce7276cff04be956e
    }
}

