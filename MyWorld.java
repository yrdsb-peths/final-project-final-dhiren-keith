import greenfoot.*;

public class MyWorld extends World {
    protected Hero hero;
    private int waveNumber = 1;
    private int enemiesRemaining = 0;
    private int waveDelayTimer = 0;
    private final int maxWaves = 5;

    public MyWorld(Hero hero) {
        super(600, 400, 1);
        setBackground("space.jpg");
        this.hero = hero;
        setWorlds();
    }

    public MyWorld() {
        super(600, 400, 1);
        setBackground("space.jpg");
        setWorlds();
    }

    public void act() {
        if (getClass() == MyWorld.class) return;
        if (enemiesRemaining == 0) {
            if (waveNumber >= maxWaves) {
                Greenfoot.setWorld(new MyWorld(hero));
            } else {
                if (waveDelayTimer == 0) {
                    waveDelayTimer = 120;
                } else {
                    waveDelayTimer--;
                    if (waveDelayTimer == 0) {
                        waveNumber++;
                        Hero hero = getHero();
                        if (hero != null) {
                            hero.levelUp();
                            showText("Level: " + hero.getLevel(), 100, 30);
                        }
                        startWave();
                    }
                }
            }
        }
    }

    public void prepare() {
        if (hero == null) {
            hero = new Hero();
        }         addObject(hero, getWidth() / 2, getHeight() / 2);
        HealthBar healthBar = new HealthBar(hero);
        addObject(healthBar, hero.getX(), hero.getY() - 20);
    }

    private void startWave() {
        int numberOfEnemies = waveNumber * 3;
        for (int i = 0; i < numberOfEnemies; i++) {
            int x = 0, y = 0;
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
            } else {
                x = Greenfoot.getRandomNumber(getWidth());
                y = getHeight() + 50;
            }

            Enemy goon = new Enemy(waveNumber, 1, "GOON", 0, 20, 2);
            addObject(goon, x, y);
        }
        enemiesRemaining = numberOfEnemies;
    }

    public void decrementEnemies() {
        enemiesRemaining--;
    }

    private void setWorlds() {
        addObject(new Label("World One: Level 0", "Arial", 20), 100, 50);
        addObject(new SelectWorldOne(), 100, 100);
        addObject(new Label("World Two: Level 20", "Arial", 20), 200, 250);
        addObject(new SelectWorldTwo(), 200, 300);
        addObject(new Label("World Three: Level 40", "Arial", 20), 300, 100);
        addObject(new SelectWorldThree(), 300, 150);
        addObject(new Label("World Four: Level 60", "Arial", 20), 400, 275);
        addObject(new SelectWorldFour(), 400, 325);
        addObject(new Label("World Five: Level 80", "Arial", 20), 500, 50);
        addObject(new SelectWorldFive(), 500, 100);
    }

    public Hero getHero() {
        return hero;
    }
}
