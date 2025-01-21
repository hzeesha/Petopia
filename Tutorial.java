import java.awt.Font;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class is the Tutorial class and it provides a graphical user interface window
 * that displays the game instructions for Petopia. It includes a title,
 * detailed instructions, an image, and a button to return to the main menu.
 *
 * <p>This code is part of the Petopia project.</p>
 * 
 * @author group 34
 * @version 1.0
 * @since 2024-12-03
 */
public class Tutorial extends JFrame {

    /**
     * This displays the Tutorial window with game instructions for Petopia.
     * This includes a title, instructions in a text area that you can scroll, 
     * and a button to return to the main menu.
     */
    public static void showWindow() {
        // This creates the frame for the tutorial window
        JFrame frame = new JFrame("Game Instructions");
        frame.setTitle("Game Instructions");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // This will dispose the frame on close
        frame.setLocationRelativeTo(null); // This centers the frame
        frame.setLayout(null); // Uses absolute layout

        // This is the title label for the tutorial window
        JLabel title = new JLabel("Welcome to Petopia!");
        title.setBounds(200, 20, 400, 40); // this sets the position and size
        title.setFont(new Font("Comic Sans MS", Font.BOLD, 36)); // this sets the font style and size
        title.setHorizontalAlignment(SwingConstants.CENTER); // this center aligns the text
        frame.add(title);

        // This displays an image of a trainer
        ImageIcon trainerImage = new ImageIcon("icons/trainer.jpg");
        JLabel trainerLabel = new JLabel(trainerImage);
        trainerLabel.setBounds(50, 100, trainerImage.getIconWidth(), trainerImage.getIconHeight());
        frame.add(trainerLabel); // this adds the image to the frame

        // These are the instructions text area for the game
        JTextArea instructions = new JTextArea();
        instructions.setText("""
        🐾 Hi there, Petopia Trainer! 🐾

        - 🎮 **Getting Started**:
          Start a new game, load an old one, or check out the parental controls from the main menu!

        - 🐶 **Choose Your Pet**:
          Pick your favorite pet: Cat, Dog, or Sheep! Don't forget to name them!

        - 🍗 **Caring for Your Pet**:
          - Feed your pet to keep their belly full.
          - Put them to sleep to help them rest.
          - Play with them to boost their happiness.
          - Take them to the vet if they're feeling sick.

        - 🛒 **Check Your Inventory**:
          Manage your items wisely! Different foods, toys, and treats have unique effects on your pet's stats. Choose carefully to keep your pet happy and healthy!

        - 🌟 **Stay Alert**:
          Watch your pet's stats (Health, Happiness, Fullness, and Sleep). If they reach zero, your pet might get sad!

        - 💾 **Save and Load**:
          Save your progress and continue your journey anytime!

        🐾 Enjoy your time in Petopia! 🐾
        """);
        instructions.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        instructions.setLineWrap(true); // This enables line wrapping
        instructions.setWrapStyleWord(true); // This wraps at word boundaries
        instructions.setEditable(false); // This makes the text area 'read-only'
        instructions.setOpaque(false); // this sets the transparent background

        // this wraps the text area in such a way that you can scroll for for better navigation
        JScrollPane scrollPane = new JScrollPane(instructions);
        scrollPane.setBounds(50, 100, 700, 350); // this sets the position and size of the scroll pane
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        frame.add(scrollPane);

        // this is a button that returns you to the main menu
        JButton mainMenuButton = new JButton("Main Menu");
        mainMenuButton.setBounds(50, 500, 150, 40); // this sets the position and size
        mainMenuButton.setFont(new Font("Comic Sans MS", Font.BOLD, 16)); // this sets the font style and size
        frame.add(mainMenuButton);

        // this adds an action listener to the Main Menu button
        mainMenuButton.addActionListener(new ActionListener() {
            /**
             * this closes the Tutorial window when the Main Menu button is clicked.
             *
             * @param e the ActionEvent is triggered by clicking the button
             */
            @Override
            public void actionPerformed(ActionEvent e) {
              mainMenu.playSound("sounds/button_click.wav");
                frame.dispose(); // this closes the tutorial window
                // Optionally, this navigates you back to the main menu
                // mainMenu.showWindow();
            }
        });

        // this sets the frame's visibility to true
        frame.setVisible(true);
    }

    /**
     * The main method serves as the 'entry point' for the application.
     * It launches the Tutorial window with game instructions.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        showWindow();
    }
}
