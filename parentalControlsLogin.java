import java.awt.Font;
import javax.swing.*;

/**
 * This class is the parentalControlsLogin class that provides a graphical user interface for
 * authenticating access to the parental controls menu using a PIN.
 *
 * <p>This class validates the user's PIN input and redirects to the Parental Controls Menu upon successful login.</p>
 * 
 * @author Team 34
 * @version 1.0
 * @since 2024-12-03
 */
public class parentalControlsLogin {

    /**
     * This displays the Parental Controls Login window, allowing the user to enter a PIN
     * to access the parental controls menu.
     */
    public static void showWindow() {
        String passwordString = "123"; // This is the PIN for authentication

        // This creates a new JFrame
        JFrame frame = new JFrame("Parental Controls Login");
        frame.setSize(500, 400); // This sets the size of the frame
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // This closes the frame only
        frame.setLocationRelativeTo(null); // This centers the frame on the screen
        frame.setLayout(null);

        // This adds a title to the frame
        JLabel pageTitle = new JLabel("Parental Controls Login");
        pageTitle.setBounds(140, 25, 225, 30);
        pageTitle.setFont(new Font("Arial", Font.PLAIN, 20));
        frame.add(pageTitle);

        // This is a label and input field for the PIN entry
        JLabel pinEntry = new JLabel("Enter PIN:");
        pinEntry.setBounds(170, 90, 75, 30);
        frame.add(pinEntry);

        JPasswordField pin = new JPasswordField();
        pin.setBounds(235, 90, 75, 30);
        frame.add(pin);

        // This makes the login button
        JButton loginButton = new JButton("Login");
        loginButton.setBounds(208, 135, 67, 30);
        frame.add(loginButton);

        // This makes the Main Menu button
        JButton mainMenuButton = new JButton("Main Menu");
        mainMenuButton.setBounds(165, 290, 150, 30);
        frame.add(mainMenuButton);

        mainMenuButton.addActionListener(e -> {
            mainMenu.playSound("sounds/button_click.wav");
            frame.dispose();
        }); // this closes the frame when "Main Menu" is clicked

        loginButton.addActionListener(e -> {
            mainMenu.playSound("sounds/button_click.wav");
            char[] enteredPin = pin.getPassword(); // This gets the entered PIN
            String pinString = new String(enteredPin); // this converts the character array to a String

            // This checks if the entered PIN is correct
            if (pinString.equals(passwordString)) {
                frame.dispose(); // This closes the current login window
                parentalControlsMenu.showWindow(); // This opens the parental controls menu
            } else {
                JOptionPane.showMessageDialog(frame, "Incorrect PIN, please try again.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // This sets the frame's visibility
        frame.setVisible(true);
    }

    /**
     * This is the main method that serves as an 'entry point' to launch the Parental Controls Login window.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        showWindow();
    }
}
