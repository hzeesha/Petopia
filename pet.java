import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * This class is the pet class that represents a virtual pet in Petopia. 
 * It provides features to interact with the pet, update its stats, and render its status on the screen.
 *
 * <p>Features include feeding, playing, sleeping, exercising, and taking the pet to the vet.
 * It tracks stats like health, happiness, fullness, and sleep, and updates these values over time or through player actions.</p>
 * 
 * @author Team 34
 * @version 1.0
 * @since 2024-12-03
 */
public class pet extends JFrame {
    private static String petType;
    private static String petName;
    private BufferedImage petImage;
    private BufferedImage backgroundImage;
    private int petPosition = 1;
    private long gameStartTime;
    private Timer clockTimer;
    private String elapsedTime = "00:00"; //this is the initial clock display

    private static int health = 100;
    private static int happiness = 100;
    private static int fullness = 100;
    private static int sleep = 100;
    public static int score = 0;

    private Timer timer; // this is a timer to decrease stats over time
    private Timer timerUpdateInventory; // this is a timer to decrease stats over time

    public static long startTime = System.nanoTime();

    //this states the pet's mood 
    private boolean isAlive;
    private boolean isAwake;
    private boolean isFull;
    private boolean isHappy;

    // this declares the buttons
    private JButton feedButton;
    private JButton sleepButton;
    private JButton playButton;
    private JButton vetButton;
    private JButton gameOverButton;
    private JButton saveGameButton;
    private JButton mainMenuButton;
    private JButton inventoryButton;
    private JButton exerciseButton;

    /**
     * this constructs a new pet with the given attributes and initializes the game window.
     *
     * @param petType   the type of the pet (e.g., "cat", "dog", "sheep")
     * @param petName   the name of the pet
     * @param health    the pet's initial health
     * @param happiness the pet's initial happiness
     * @param fullness  the pet's initial fullness
     * @param sleep     the pet's initial sleep level
     * @param score     the player's initial score
     */
    public pet(String petType, String petName, int health, int happiness, int fullness, int sleep, int score) {
        this.petType = petType;
        this.petName = petName;
        this.health = health;
        this.happiness = happiness;
        this.fullness = fullness;
        this.sleep = sleep;
        this.score = score;

        pet.petType = petType;
        pet.petName = petName;
        isAlive = true;
        isAwake = true;
        isFull = true;
        isHappy = true;

        // this sets up window properties
        setTitle("Your Pet in Petopia");
        JFrame frame = new JFrame("Your Pet in Petopia");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                mainMenu.onApplicationClose(mainMenu.getStartTIme());
            }
        });

        // this loads images
        loadImages();

        // this creates and adds buttons
        if (isAlive) {
            saveGameButton = new JButton("Save Game");
            saveGameButton.setBounds(640, 200, 120, 40);
            saveGameButton.addActionListener(e -> {
                mainMenu.playSound("sounds/button_click.wav");
                saveGame.showWindow();
            });
            add(saveGameButton);


            inventoryButton = new JButton("Inventory"); //create inventory button
            inventoryButton.setBounds(640, 140, 120, 40);  // Set position and size    
            inventoryButton.addActionListener(e ->{
                mainMenu.playSound("sounds/button_click.wav");
            playerInventory.showWindow();
        });
            System.out.println(inventoryButton); //this logs the button details to the console for debugging purposes
            add(inventoryButton); // this adds the inventory button to the UI

            mainMenuButton = new JButton("Main Menu");
            mainMenuButton.setBounds(640, 80, 120, 40);
            mainMenuButton.addActionListener(e -> {
                mainMenu.playSound("sounds/button_click.wav");
                dispose();
                mainMenu backHome = new mainMenu();
                backHome.setVisible(true);
            });
            add(mainMenuButton);

            if (isAwake) {
                if (isHappy) {
                    feedButton = new JButton("Feed Pet");
                    feedButton.setBounds(490, 20, 120, 40);
                    feedButton.addActionListener(e -> {
                        mainMenu.playSound("sounds/button_click.wav");
                    feedPet();
                });
                    add(feedButton);

                    sleepButton = new JButton("Put pet to sleep");
                    sleepButton.setBounds(10, 20, 150, 40);
                    sleepButton.addActionListener(e -> {
                        mainMenu.playSound("sounds/button_click.wav");
                        putToSleep();
                    });
                    add(sleepButton);

                    vetButton = new JButton("Bring pet to vet");
                    vetButton.setBounds(330, 20, 150, 40);
                    vetButton.addActionListener(e -> {
                        mainMenu.playSound("sounds/button_click.wav");
                        bringToVet();
                    });
                    add(vetButton);

                    exerciseButton = new JButton("Exercise pet");
                    exerciseButton.setBounds(630, 20, 150, 40);
                    exerciseButton.addActionListener(e -> {
                        mainMenu.playSound("sounds/button_click.wav");
                        exercisePet();
                    });
                    add(exerciseButton);
                }

                playButton = new JButton("Play with Pet");
                playButton.setBounds(170, 20, 150, 40);
                playButton.addActionListener(e -> {
                    mainMenu.playSound("sounds/button_click.wav");
                    playWithPet();
                });
                add(playButton);
            }
        }

        // this creates a timer to decrease stats over time
        timerUpdateInventory = new Timer(40000, e -> updateInventory());

        timer = new Timer(5000, e -> updateStats());
        timerUpdateInventory.start();
        timer.start();
    }

    /**
     * this loads the images for the background and pet based on its type
     */
    private void loadImages() {
        try {
            backgroundImage = ImageIO.read(new File("images/background.png"));
            petImage = ImageIO.read(new File("sprites/" + petType + "_normal.png"));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error loading images.");
        }
    }

private void updateInventory(){
int currBalls = playerInventory.getBalls();
playerInventory.setBalls(currBalls + 1);

int currFish = playerInventory.getFish();
playerInventory.setFish(currFish + 1);

int currMilk = playerInventory.getMilk();
playerInventory.setMilk(currMilk + 1);

int currBears = playerInventory.getBears();
playerInventory.setBears(currBears + 1);

int currTreats = playerInventory.getTreats();
playerInventory.setTreats(currTreats + 1);

int currBlocks = playerInventory.getBlocks();
playerInventory.setBlocks(currBlocks + 1);

int currChicken = playerInventory.getChicken();
playerInventory.setChicken(currChicken + 1);

int currSpinners = playerInventory.getSpinners();
playerInventory.setSpinners(currSpinners + 1);
}

/**
 * This updates the pet's stats over time and adjusts the pet's state (e.g., alive, awake, happy) accordingly.
 * This method decreases health, happiness, fullness, and sleep stats at regular intervals
 * and applies penalties if certain conditions are not met.
 * 
 */
private void updateStats() {
    // this decreases stats over time
    if (health > 0) {
        isAlive = true;
    }
    if (happiness > 0) {
        isHappy = true;
        happiness -= 2; // the pet's happiness decreases naturally over time
    }
  
    if (fullness > 0) {
        isFull = true;
        fullness -= 3; // the pet's Fullness decreases naturally over time
    }
    if (sleep > 0 && isAwake) {
        isAwake = true;
        sleep -= 2; // the pet's sleep decreases if the pet is awake
    }

    if (!isFull) { // this applies a health and happiness penalty for starving pet
        health -= 5;
        happiness -= 3;
    }

    // this sets the pet's states to false when stats reach zero
    if (health <= 0) {
        health = 0;
        isAlive = false;
    }
    if (happiness <= 0) {
        happiness = 0;
        isHappy = false;
    }
    if (fullness <= 0) {
        fullness = 0;
        isFull = false;
    }
    if (sleep <= 0 || !isAwake) {
        isAwake = false;
        putToSleep(); // this automatically puts the pet to sleep when exhausted
    }

    // this triggers a repaint to update the pet stats on the UI
    repaint();
}

/**
 * this feeds the pet a specific item (e.g., fish), increasing fullness.
 * Ensures that fullness does not exceed the maximum limit of 100.
 */
private static void feedFish() {
    fullness = Math.min(fullness + 10, 100); // this increases fullness by 10, capped at 100
}

/**
 * this feeds the pet, increasing its fullness stat and refreshing the UI to show the updated state.
 * This method also increases the player's score by 1.
 */
private void feedPet() {
    score += 1; // this increments the score for feeding the pet
    fullness = Math.min(fullness + 20, 100); // this increases fullness by 20, capped at 100
    try {
        // this loads the background and pet eating image
        backgroundImage = ImageIO.read(new File("images/background.png"));
        petImage = ImageIO.read(new File("sprites/" + petType + "_eating.png"));
    } catch (Exception e) {
        e.printStackTrace();
        System.out.println("Error loading image.");
    }
    // this updates the UI after feeding
    repaint();
}

/**
 * this puts the pet to sleep, replenishing its sleep stat.
 * Applies penalties to health and happiness if the pet's sleep stat is too low.
 */
private void putToSleep() {
    if (sleep <= 0) { // these are penalties for exhaustion
        health -= 25;
        happiness -= 25;
    }
    try {
        // this loads the background and sleeping pet image
        backgroundImage = ImageIO.read(new File("images/background.png"));
        petImage = ImageIO.read(new File("sprites/" + petType + "_sleeping.png"));
        sleep = Math.min(sleep + 25, 100); // this replenishishes sleep, capped at 100
        if (sleep == 100) {
            isAwake = true; // this wakes up the pet when fully rested
        }
    } catch (Exception e) {
        e.printStackTrace();
        System.out.println("Error loading image.");
    }
    repaint();
}

/**
 * this plays with the pet, increasing its happiness stat and refreshing the UI.
 * This method also increases the player's score by 2.
 */
private void playWithPet() {
    score += 2; // this increments the score for playing with the pet
    happiness = Math.min(happiness + 10, 100); // this increase happiness by 10, capped at 100
    try {
        // this loads the background and playing pet image
        backgroundImage = ImageIO.read(new File("images/background.png"));
        petImage = ImageIO.read(new File("sprites/" + petType + "_playing.png"));
    } catch (Exception e) {
        e.printStackTrace();
        System.out.println("Error loading image.");
    }
    repaint();
}

/**
 * this brings the pet to the vet, increasing its health stat and refreshing the UI.
 * This method decreases the player's score by 1 as a penalty for vet care.
 */
private void bringToVet() {
    score = Math.max(score - 1, 0); // this decreases the score by 1, minimum is 0
    health = Math.min(health + 20, 100); // this increases the health by 20, capped at 100
    try {
        // this loads the background and sad pet image
        backgroundImage = ImageIO.read(new File("images/background.png"));
        petImage = ImageIO.read(new File("sprites/" + petType + "_sad.png"));
    } catch (Exception e) {
        e.printStackTrace();
        System.out.println("Error loading image.");
    }
    repaint();
}

/**
 * this exercises the pet, increasing its health stat and refreshing the UI.
 * This method also increases the player's score by 1 as a reward for keeping the pet active.
 */
private void exercisePet() {
    score = Math.max(score + 1, 0); // this increments the score by 1
    health = Math.min(health + 10, 100); // this increases health by 10, capped at 100
    try {
        // this loads the background and gym pet image
        backgroundImage = ImageIO.read(new File("images/background.png"));
        petImage = ImageIO.read(new File("sprites/" + petType + "_gym.png"));
    } catch (Exception e) {
        e.printStackTrace();
        System.out.println("Error loading image.");
    }
    repaint();
}


/**
 * This overrides the paint method to render the pet, background, and stats on the screen.
 * This method ensures that UI elements are updated whenever the window is refreshed.
 *
 * @param g the Graphics object used for rendering the UI elements
 */
@Override
public void paint(Graphics g) {
    // this calls the parent class's paint method to ensure proper behavior
    super.paint(g);

    // this ensures we don't clear the whole screen on repaint
    if (backgroundImage != null) {
        // this creates a Graphics2D object for drawing
        Graphics2D g2d = (Graphics2D) g;

        // this creates a semi-transparent background image with 50% opacity
        BufferedImage semiTransparentBackground = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D bgGraphics = semiTransparentBackground.createGraphics();

        // this sets the alpha transparency for the background (50% opacity)
        bgGraphics.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f));

        // this draws the background image into the semi-transparent image
        bgGraphics.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), null);
        bgGraphics.dispose();

        // this draws the semi-transparent background image to the panel
        g2d.drawImage(semiTransparentBackground, 0, 0, null);
    }

    if (petImage != null) {
        int x = (getWidth() - petImage.getWidth()) / 2;
        int y = (getHeight() - petImage.getHeight() + (petPosition * 100) - 100) / 2;
        g.drawImage(petImage, x, y, null);
    }
    if (petPosition <= 1){
        petPosition ++;
    }
    else {
        petPosition = 1;
    }

    // this draws the pet's stats AFTER images to ensure they appear on top
    g.setColor(Color.BLACK);
    g.setFont(new Font("Arial", Font.PLAIN, 20));
    int yPos = getHeight() - 40; // this is the start position for the statistics text (a bit above the bottom)

    // this displays the stats if the pet is alive
    if (!isAlive) {
        g.setColor(Color.RED);
        g.setFont(new Font("Arial", Font.PLAIN, 40));
        g.drawString("PET IS DEAD. GAME OVER", 130, 200);
        gameOverButton = new JButton("Main Menu");
        gameOverButton.setBounds(320, 100, 150, 40); // this positions the button
        gameOverButton.addActionListener(e -> {
            mainMenu.playSound("sounds/button_click.wav");
            this.dispose();
            mainMenu mainMenu = new mainMenu();
        });
        add(gameOverButton);
    } else {
        g.drawString("Health: " + health, 20, yPos);
        g.drawString("Happiness: " + happiness, 220, yPos);
        g.drawString("Fullness: " + fullness, 420, yPos);
        g.drawString("Sleep: " + sleep, 620, yPos);
        g.drawString("Score: " + score, 40, yPos - 420);
    }
    if (health <= 25){ // warning message when pet is low health
        g.setColor(Color.RED);
        g.setFont(new Font("Arial", Font.PLAIN, 20));
        g.drawString("PET IS INJURED", 20, yPos - 50);
    }
    if (happiness <= 25){ // warning message when pet is low happiness
        g.setColor(Color.RED);
        g.setFont(new Font("Arial", Font.PLAIN, 20));
        g.drawString("PET IS SAD", 220, yPos - 50);
    }
    if (fullness <= 25){ // warning message when pet is low fullness
        g.setColor(Color.RED);
        g.setFont(new Font("Arial", Font.PLAIN, 20));
        g.drawString("PET IS HUNGRY", 420, yPos - 50);
    }
    if (sleep <= 25){ // warning message when pet is low sleep
        g.setColor(Color.RED);
        g.setFont(new Font("Arial", Font.PLAIN, 20));
        g.drawString("PET IS TIRED", 620, yPos - 50);
    } 
}
/**
 * This gets the pet's type
 *
 * @return the type of the pet (e.g., "cat", "dog")
 */
public static String getPetType() {
    return petType;
}

/**
 * this gets the pet's name
 *
 * @return the name of the pet
 */
public static String getPetName() {
    return petName;
}

/**
 * this gets the pet's health stat
 *
 * @return the health stat as a string
 */
public static String getHealth() {
    return Integer.toString(health);
}

/**
 * this gets the pet's happiness stat
 *
 * @return the happiness stat as a string
 */
public static String getHappiness() {
    return Integer.toString(happiness);
}

/**
 * this gets the pet's fullness stat
 *
 * @return the fullness stat as a string
 */
public static String getFullness() {
    return Integer.toString(fullness);
}

/**
 * this gets the pet's sleep stat
 *
 * @return the sleep stat as a string
 */
public static String getSleep() {
    return Integer.toString(sleep);
}

/**
 * this gets the player's score
 *
 * @return the score as a string
 */
public static String getScore() {
    return Integer.toString(score);
}
/**
 * this sets the happiness value of the pet, ensuring it does not exceed the maximum limit of 100.
 *
 * @param newHappiness the new happiness value to set
 */
public static void setHappinessValue(int newHappiness) {
    happiness = Math.min(newHappiness, 100); // this sets the limit to 100
}

/**
 * This gets the current happiness value of the pet.
 *
 * @return the happiness value as an integer
 */
public static int getHappinessValue() {
    return happiness; // this returns the happiness as an integer
}

/**
 * this sets the fullness value of the pet, and ensures it does not exceed the maximum limit of 100.
 *
 * @param newFullness the new fullness value to set
 */
public static void setFullnessValue(int newFullness) {
    fullness = Math.min(newFullness, 100); // Limit to 100
}

/**
 * this gets the current fullness value of the pet.
 *
 * @return the fullness value as an integer
 */
public static int getFullnessValue() {
    return fullness; // this returns the fullness as an integer
}

/**
 * this sets the pet's type
 *
 * @param newPetType the new type of the pet
 */
public void setPetType(String newPetType) {
    petType = newPetType;
}

/**
 * this sets the pet's name
 *
 * @param newPetName the new name of the pet
 */
public void setPetName(String newPetName) {
    petName = newPetName;
}

/**
 * this sets the pet's health stat
 *
 * @param newHealth the new health value
 */
public void setHealth(int newHealth) {
    health = newHealth;
}

/**
 * this sets the pet's happiness stat
 *
 * @param newHappiness the new happiness value
 */
public void setHappiness(int newHappiness) {
    happiness = newHappiness;
}

/**
 * this sets the pet's fullness stat
 *
 * @param newFullness the new fullness value
 */
public void setFullness(int newFullness) {
    fullness = newFullness;
}

/**
 * this sets the pet's sleep stat
 *
 * @param newSleep the new sleep value
 */
public void setSleep(int newSleep) {
    sleep = newSleep;
}

/**
 * this sets the player's score.
 *
 * @param newScore the new score value
 */
public void setScore(int newScore) {
    score = newScore;
}

    /**
     * This is the main method that launches the game with a sample pet.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        pet pet = new pet("cat", "Fluffy", 100, 100, 100, 100, 0);
        pet.setVisible(true);
    }

    public Object isAlive() {
        return isAlive;
    }
}
