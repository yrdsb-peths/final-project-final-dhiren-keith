import greenfoot.Actor;
import greenfoot.*;

public class MyWorld extends World {
    private int waveNumber = 1;
    private int enemiesRemaining = 0;
    private int waveDelayTimer = 0;
    private final int maxWaves = 5;

    public MyWorld() {
        super(600, 400, 1);
        setWorlds();
    }

    public void prepare() {
        // Add the player to the center of the world
        Hero hero = new Hero();
        addObject(hero, getWidth()/2, getHeight()/2);

        // Start the first wave
        startWave();

    }
    public void act() {
        if (enemiesRemaining == 0) {
            if(waveNumber >= maxWaves) {
                Greenfoot.setWorld(new MyWorld());
            } else {
                if (waveDelayTimer == 0) {
                    waveDelayTimer = 120; // 2 seconds delay
                } else {
                    waveDelayTimer--;
                    if (waveDelayTimer == 0) {
                        waveNumber++;
                        startWave();
                    
                }
            }
        }
    }
}

    private void startWave() {

        int numberOfEnemies = waveNumber * 3; // increase enemies each wave
        for (int i = 0; i < numberOfEnemies; i++) {
            int x = 0;
            int y = 0;
            int side = Greenfoot.getRandomNumber(4);

            if (side == 0) {
                x = -50;
                y = Greenfoot.getRandomNumber(getHeight());
            } else if (side == 1) {
                x = getWidth() + 50;
                y = Greenfoot.getRandomNumber(getHeight());
            } else if (side == 2) {
                x = Greenfoot.getRandomNumber(getWidth());
                y = -50;
            } else if (side == 3) {
                x = Greenfoot.getRandomNumber(getWidth());
                y = getHeight() + 50;
            }
            
            Enemy goon = new Enemy(waveNumber, 1, "GOOON", 0, 1000);
            addObject(goon, x, y);
        }
        enemiesRemaining = numberOfEnemies;
        
        }
      
    public void decrementEnemies() {
        enemiesRemaining--;
    }
    


    private void setWorlds()
    {
        addObject(new Label("World One: Level 0","Arial", 20),100, 50);
        addObject(new SelectWorldOne(), 100, 100);
        addObject(new Label("World Two: Level 20","Arial", 20),200, 250);
        addObject(new SelectWorldTwo(), 200, 300);
        addObject(new Label("World Three: Level 40","Arial", 20),300, 100);
        addObject(new SelectWorldThree(), 300, 150);
        addObject(new Label("World Four: Level 60","Arial", 20),400, 275);
        addObject(new SelectWorldFour(), 400, 325);
        addObject(new Label("World Five: Level 80","Arial", 20),500, 50);
        addObject(new SelectWorldFive(), 500, 100);  
    }
     public Hero getHero() {
        for (Object obj : getObjects(Hero.class)) {
            return (Hero) obj;
        }
        return null;
    }
}