import greenfoot.Actor;
import greenfoot.*;

public class MyWorld extends World {
    private int waveNumber = 1;
    private int enemiesRemaining = 0;
<<<<<<< HEAD
    public static boolean inWorld = false; 
=======
>>>>>>> 5050f1322ff902331250e8fce7276cff04be956e

    public MyWorld() {
        super(600, 400, 1);

        prepare();
      
    }

    private void prepare() {
        // Add the player to the center of the world
        Hero hero = new Hero();
        addObject(hero, getWidth()/2, getHeight()/2);

        // Start the first wave
        startWave();
    }

    private void startWave() {
        int numberOfEnemies = waveNumber * 3; // increase enemies each wave
        for (int i = 0; i < numberOfEnemies; i++) {
            int x = Greenfoot.getRandomNumber(getWidth());
            int y = Greenfoot.getRandomNumber(getHeight());
            addObject(new Goon_One(), x, y);
        }
        enemiesRemaining = numberOfEnemies;
        setWorlds();
        if(inWorld){
            prepare();
        }
    }

    private void prepare() {
        // Add the player to the center of the world
        Hero hero = new Hero();
        addObject(hero, getWidth()/2, getHeight()/2);

        // Start the first wave
        startWave();
    }

    private void startWave() {
        int numberOfEnemies = waveNumber * 3; // increase enemies each wave
        for (int i = 0; i < numberOfEnemies; i++) {
            int x = Greenfoot.getRandomNumber(getWidth());
            int y = Greenfoot.getRandomNumber(getHeight());
            addObject(new Goon_One(), x, y);
        }
        enemiesRemaining = numberOfEnemies;
    }

    private void setWorlds()
    {
        addObject(new SelectWorldOne(), 100, 100);
        addObject(new SelectWorldTwo(), 200, 300);
        addObject(new SelectWorldThree(), 300, 150);
        addObject(new SelectWorldFour(), 400, 325);
<<<<<<< HEAD
        addObject(new SelectWorldFive(), 500, 75);  
=======
        addObject(new SelectWorldFive(), 500, 75);


>>>>>>> 5050f1322ff902331250e8fce7276cff04be956e
    }
}