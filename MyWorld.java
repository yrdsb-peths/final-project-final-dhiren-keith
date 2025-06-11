import greenfoot.*;

/**
 * MyWorld - The base world class that manages the main game environment,
 * including the world selection screen, enemy wave spawning, level tracking,
 * and player health bar display.
 * 
 * Handles game progression through waves, unlocking player abilities,
 * and transitioning between worlds and win screens.
 * 
 * @authors Keith and Dhiren  
 * @version June 9, 2025
 */
public class MyWorld extends World {
    protected Hero hero;                  // Reference to the player character
    private int waveNumber = 1;           // Current wave number
    private int enemiesRemaining = 0;     // Enemies left alive in current wave
    private int waveDelayTimer = 0;       // Timer to delay wave starts or inputs
    private final int maxWaves = 5;       // Maximum waves per world
    public static boolean piercingUnlocked = false; // Whether piercing shot unlocked
    public static boolean tripleUnlocked = false;   // Whether triple shot unlocked
    private Label levelDisplay;            // UI label displaying current level

    /**
     * Constructs the world with a given hero.
     * Sets background, stores hero reference, and initializes world selection screen.
     * 
     * @param hero The player character instance to be used in this world
     */
    public MyWorld(Hero hero) {
        super(600, 400, 1);
        setBackground("space.jpg");
        this.hero = hero;
        setWorlds();
    }

    /**
     * Constructs the world with no hero provided.
     * Resets the persistent player level and initializes the world selection screen.
     */
    public MyWorld() {
        super(600, 400, 1);
        setBackground("space.jpg");
        Hero.resetPersistentLevel();
        setWorlds();
    }

    /**
     * Main game loop called each frame.
     * Handles input for level up at menu, displays level,
     * transitions to win screen, starts new waves, and manages wave delays.
     */
    public void act() {
        // Allow level up via 'l' key on menu screen with cooldown
        if (Greenfoot.isKeyDown("l") && waveDelayTimer == 0) {
            Hero.levelUpPersistent(5);
            waveDelayTimer = 20; // Prevent rapid level ups
            levelDisplay.setValue("Current Level: " + Hero.getPersistentLevel());
        } else if (waveDelayTimer > 0) {
            waveDelayTimer--;
        }

        // Prevent act logic from running on base MyWorld menu screen
        if (getClass() == MyWorld.class) return;

        showText("Level: " + hero.getLevel(), 75, 30);

        // If on final world and all waves complete, transition to WinScreen
        if (getClass() == WorldFive.class && enemiesRemaining == 0 && waveNumber >= maxWaves) {
            Greenfoot.setWorld(new WinScreen());
            return;
        }

        // If no enemies left, manage wave progression and delays
        if (enemiesRemaining == 0) {
            if (waveNumber >= maxWaves) {
                Greenfoot.setWorld(new MyWorld(hero)); // Restart world
            } else {
                if (waveDelayTimer == 0) {
                    waveDelayTimer = 120; // Delay before next wave
                } else {
                    waveDelayTimer--;
                    if (waveDelayTimer == 0) {
                        waveNumber++;
                        if (hero != null) {
                            hero.levelUp();
                        }
                        startWave();
                    }
                }
            }
        }
    }

    /**
     * Prepares the world by adding the hero and a health bar.
     * Called when initializing or restarting a level.
     */
    public void prepare() {
        if (hero == null) {
            hero = new Hero();
        }
        addObject(hero, getWidth() / 2, getHeight() / 2);

        HealthBar healthBar = new HealthBar(hero);
        addObject(healthBar, hero.getX(), hero.getY() - 20);
    }

    /**
     * Starts a wave of enemies.
     * Spawns enemies around the edges of the world based on the current wave number.
     * Enemy difficulty scales with the hero's level.
     */
    public void startWave() {
        int numberOfEnemies = waveNumber * 3;
        int heroLevel = hero.getLevel();

        for (int i = 0; i < numberOfEnemies; i++) {
            int x = 0, y = 0;
            int side = Greenfoot.getRandomNumber(4);
            // Spawn enemy just outside one edge of the screen randomly
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

            Enemy goon = new Enemy(heroLevel / 2);
            addObject(goon, x, y);
        }

        enemiesRemaining = numberOfEnemies;
    }

    /**
     * Called to reduce the count of remaining enemies when one is defeated.
     */
    public void decrementEnemies() {
        enemiesRemaining--;
    }

    /**
     * Sets up the world selection screen with selectable worlds and displays current player level.
     * Adds labels and buttons for each world unlock tier.
     */
    private void setWorlds() {
        int currentLevel = Hero.getPersistentLevel();

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

        levelDisplay = new Label("Current Level: " + currentLevel, "Arial", 24);
        addObject(levelDisplay, 100, 370);
    }

    /**
     * Returns the hero instance associated with this world.
     * 
     * @return the current Hero object
     */
    public Hero getHero() {
        return hero;
    }
}
