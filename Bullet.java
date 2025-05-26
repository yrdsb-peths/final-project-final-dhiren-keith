import greenfoot.*;

/**
 * The Bullet class represents a projectile fired by the Hero.
 */
public class Bullet extends Actor {
    private int speed = 10;
    private String direction;

    public Bullet(String direction) {
        this.direction = direction;

        GreenfootImage image = new GreenfootImage(10, 4);
        image.setColor(Color.YELLOW);
        image.fill();
        setImage(image);
    }

    public void act() {
        moveInDirection();
        //add colisions
        checkBounds();
    }

    private void moveInDirection() {
        switch (direction) {
            case "left":
                setLocation(getX() - speed, getY());
                break;
            case "right":
                setLocation(getX() + speed, getY());
                break;
            case "up":
                setLocation(getX(), getY() - speed);
                break;
            case "down":
                setLocation(getX(), getY() + speed);
                break;
        }
    }


    private void checkBounds() {
        if (isAtEdge()) {
            getWorld().removeObject(this);
        }
    }
}
