import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

/**
 * This class is the mainMenu class and it provides the primary user interface for the Petopia virtual pet game.
 * It includes options to start a new game, load an existing game, view a tutorial, access parental controls,
 * and exit the application.
 *
 * <p>This class also includes a splash screen implementation to display an introductory animation
 * before the main menu launches.</p>
 * 
 * @author Team 34
 * @version 1.0
 * @since 2024-12-03
 */
public class mainMenu extends JFrame {
    public static long startTime;

    /**
     * This constructs the main menu window with buttons for various actions and developer information.
     * It sets up the layout, buttons, and event listeners.
     */
    public mainMenu() {
        startTime = System.currentTimeMillis();
        // this sets the window title
        setTitle("Petopia - Virtual Pet Game");

        // this sets the default close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // this sets the window size
        setSize(800, 600);

        // this centers the window on the screen
        setLocationRelativeTo(null);

        // this sets the layout for the window
        setLayout(new BorderLayout());

        // this creates a panel for the title image
        JPanel imagePanel = new JPanel(new BorderLayout());
        JLabel imageLabel = new JLabel(new ImageIcon("images/title.png"));
        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        imagePanel.add(imageLabel, BorderLayout.CENTER);

        // this adds an image panel to the top
        add(imagePanel, BorderLayout.NORTH);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                onApplicationClose(getStartTIme());
            }
        });

        // this creates a panel for the menu buttons
        JPanel buttonPanel = new JPanel(new GridLayout(5, 1, 10, 10));

        // this creates buttons for each menu option
        JButton startGameButton = new JButton("Start New Game");
        JButton loadGameButton = new JButton("Load Game");
        JButton tutorialButton = new JButton("Tutorial / Instructions");
        JButton parentalControlsButton = new JButton("Parental Controls");
        JButton exitButton = new JButton("Exit");

        // this adds buttons to the panel
        buttonPanel.add(startGameButton);
        buttonPanel.add(loadGameButton);
        buttonPanel.add(tutorialButton);
        buttonPanel.add(parentalControlsButton);
        buttonPanel.add(exitButton);

        // this adds the button panel to the center
        add(buttonPanel, BorderLayout.CENTER);

        // this creates a panel for developer information
        JPanel infoPanel = new JPanel(new GridLayout(3, 1));
        JLabel teamLabel = new JLabel("Developers: Team 34", JLabel.CENTER);
        JLabel namesLabel = new JLabel("Thevindu, Isabella, Keith, Hassan, Ade", JLabel.CENTER);
        JLabel termLabel = new JLabel("Fall 2024 - CS2212 at Western University", JLabel.CENTER);

        // this adds developer info to the panel
        infoPanel.add(teamLabel);
        infoPanel.add(namesLabel);
        infoPanel.add(termLabel);

        // this adds the info panel to the bottom
        add(infoPanel, BorderLayout.SOUTH);

        // this sets up event listeners for each button
        startGameButton.addActionListener(e -> {
            playSound("sounds/button_click.wav");
            startGame StartGame = new startGame();
            StartGame.showWindow();
        });

        loadGameButton.addActionListener(e -> {
            playSound("sounds/button_click.wav");
            loadGame loadGame = new loadGame();
            loadGame.showWindow();
        });

        tutorialButton.addActionListener(e -> {
            playSound("sounds/button_click.wav");
            Tutorial tutorial = new Tutorial();
            tutorial.showWindow();
        });

        parentalControlsButton.addActionListener(e -> {
            playSound("sounds/button_click.wav");
            parentalControlsLogin parentalControls = new parentalControlsLogin();
            parentalControls.showWindow();
        });

        exitButton.addActionListener(e -> {
        playSound("sounds/button_click.wav");
        System.exit(0);
    }); // Exit the application
    }

    /**
     * This displays the splash screen with an introductory animation and background music.
     * Once the animation completes, the main menu is launched.
     *
     * @param onComplete a Runnable to execute when the splash screen animation is finished
     */
    public static void showSplashScreen(Runnable onComplete) {
        JFrame splashScreen = new JFrame();
        splashScreen.setUndecorated(true);
        splashScreen.setSize(800, 600);
        splashScreen.setLocationRelativeTo(null);

        // this adds an image to the splash screen
        JLabel splashImage = new JLabel(new ImageIcon("images/title.png"));
        splashImage.setHorizontalAlignment(JLabel.CENTER);
        splashScreen.add(splashImage);

        splashScreen.setOpacity(1.0f);
        splashScreen.setVisible(true);

        Timer timer = new Timer(50, new ActionListener() {
            float opacity = 1.0f;

            @Override
            public void actionPerformed(ActionEvent e) {
                opacity -= 0.02f;
                if (opacity <= 0.0f) {
                    splashScreen.dispose();
                    ((Timer) e.getSource()).stop();
                    onComplete.run(); // this launches the main menu
                } else {
                    splashScreen.setOpacity(opacity);
                }
            }
        });

        timer.start();

        backgroundMusic sound = new backgroundMusic();
        sound.playSong();
    }

    public static void playSound(String soundFile)
 {
   try 
   {
    AudioInputStream foundAudio = AudioSystem.getAudioInputStream(new File(soundFile).getAbsoluteFile());
    Clip clip = AudioSystem.getClip();
    clip.open(foundAudio);
    clip.start();
   }
   catch(Exception ex)
   {
     System.out.println("Sound file could not be found");
     ex.printStackTrace( );
   }
 }    

 public static void onApplicationClose(long startTime){
    long endTime = System.currentTimeMillis();
        System.out.print((endTime - startTime) / 1000);
        
 }
 public static long getStartTIme(){
    return startTime;
 }

    /**
     * This is the main method that serves as the 'entry point' for the application.
     * It first displays the splash screen and then launches the main menu.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        showSplashScreen(() -> {
            mainMenu mainMenu = new mainMenu();
            mainMenu.setVisible(true);
        });
    }
}

