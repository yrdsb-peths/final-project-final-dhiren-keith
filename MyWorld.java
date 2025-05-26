import greenfoot.*;

public class MyWorld extends World {
    private int waveNumber = 1;
    private int enemiesRemaining = 0;

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
    }
}