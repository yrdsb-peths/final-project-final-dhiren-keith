import greenfoot.*;

public class Bullet extends Actor {
    private int speed = 10;
    private String direction;

    public Bullet(String direction) {
        this.direction = direction;

        // Load and scale the bullet image
        GreenfootImage image = new GreenfootImage("bullet.png");
        image.scale(20, 10); // adjust the size to what looks good
        setImage(image);

        // Rotate the image to face the shooting direction
        switch (direction) {
            case "left":
                setRotation(180);
                break;
            case "right":
                setRotation(0);
                break;
            case "up":
                setRotation(270);
                break;
            case "down":
                setRotation(90);
                break;
        }
    }

    public void act() {
        moveInDirection();
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
