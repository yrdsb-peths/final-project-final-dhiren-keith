import greenfoot.Actor;
import greenfoot.*;

public class MyWorld extends World {
    private Hero hero;
    private int waveNumber = 1;
    private int enemiesRemaining = 0;
    private int waveDelayTimer = 0;
    private final int maxWaves = 5;

    public MyWorld(Hero hero) {
        super(600, 400, 1);
        this.hero = hero;
        setWorlds();
        
          
    }
    
    public MyWorld() {
        super(600, 400, 1);
        setWorlds();
    }

    public void prepare() {
        // Add the player to the center of the world
        if(hero == null) {
            hero = new Hero();
        }
        addObject(hero, getWidth()/2, getHeight()/2);

        // Start the first wave
        startWave();

    }
    public void act() {
        if (enemiesRemaining == 0) {
            if(waveNumber >= maxWaves) {
                Greenfoot.setWorld(new MyWorld(hero));
            } else {
                if (waveDelayTimer == 0) {
                    waveDelayTimer = 120; // 2 seconds delay
                } else {
                    waveDelayTimer--;
                    if (waveDelayTimer == 0) {
                        waveNumber++;
                        Hero hero = getHero();
                        if (hero != null)
                        {
                            hero.onWaveCleared();
                            showText("Level: " + hero.getLevel(), 100, 30); 
                        }
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
            
            Enemy goon = new Enemy(waveNumber, 1, "GOOON", 0, 10);
            addObject(goon, x, y);
        }
        enemiesRemaining = numberOfEnemies;
        
        }
      
    public void decrementEnemies() {
        enemiesRemaining--;
    }


    private void setWorlds()
    {
        addObject(new SelectWorldOne(), 100, 100);
        addObject(new SelectWorldTwo(), 200, 300);
        addObject(new SelectWorldThree(), 300, 150);
        addObject(new SelectWorldFour(), 400, 325);
        addObject(new SelectWorldFive(), 500, 75);  
    }
     public Hero getHero() {
        return hero;
    }
}