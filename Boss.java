import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Boss here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Boss extends Actor
{
    private int level; 
    private int maxHealth;
    private int currHealth;
    private String name;
    private int defense;
    private int attack;
    private int speed = 2;
    public Boss(int level, int maxHealth, int currHealth, String name, int defense, int attack)
    {
        this.level = level;
        this.maxHealth = maxHealth;
        this.currHealth = maxHealth; 
        this.name = name;
        this.defense = defense;
        this.attack = attack;
    }
    public void act()
    {
        
        
    }
    
    public void takeDamage(int damage) {
        currHealth -= damage - defense;
        if (currHealth < 0){
            currHealth = 0;
            getWorld().removeObject(this);
        }
        
    }
}
