import java.awt.*;
import javax.swing.*;

/**
 * This class is the playtimeStatistics class that represents the Playtime Statistics window in Petopia.
 * <p>
 * It displays statistics such as total playtime and average playtime per session. 
 * Users can return to the Parental Controls menu via a button.
 * </p>
 * 
 * @author Team 34
 * @version 1.0
 * @since 2024-12-03
 */
public class playtimeStatistics {

    /**
     * This displays the Playtime Statistics window.
     * <p>
     * This window shows total playtime and average playtime per session.
     * Users can navigate back to the Parental Controls menu by clicking a button.
     * </p>
     */
    public static void showWindow() {
        // this creates a new JFrame for the Playtime Statistics window
        JFrame frame = new JFrame("Playtime Statistics");

        // this sets the size of the frame
        frame.setSize(500, 400); // this sets the Width to 500px and the Height to 400px

        // this centers the frame on the screen
        frame.setLocationRelativeTo(null);

        // this uses a null layout for absolute positioning
        frame.setLayout(null);

        // this adds a page title label
        JLabel pageTitle = new JLabel("Playtime Statistics");
        pageTitle.setBounds(163, 25, 225, 30); // this sets x, y, width, height
        pageTitle.setFont(new Font("Arial", Font.PLAIN, 20));
        pageTitle.setOpaque(false);
        pageTitle.setBorder(null);
        frame.add(pageTitle);

        // this adds a label for total playtime
        JLabel text1 = new JLabel("Total Playtime:");
        text1.setBounds(75, 90, 225, 30); // this sets x, y, width, height
        text1.setFont(new Font("Arial", Font.PLAIN, 15));
        text1.setOpaque(false);
        text1.setBorder(null);
        frame.add(text1);

        // this adds a label for average playtime per session
        JLabel text2 = new JLabel("<html><div align='center'>Average Playtime <br>Per Session:</div></html>");
        text2.setBounds(70, 175, 225, 30); // this sets x, y, width, height
        text2.setFont(new Font("Arial", Font.PLAIN, 15));
        text2.setOpaque(false);
        text2.setBorder(null);
        frame.add(text2);

        // this creates a "Back to Parental Controls" button
        JButton backToParentalControls = new JButton("<html><div align='center'>Back to<br>Parental Controls</div></html>");
        backToParentalControls.setBounds(155, 275, 180, 60); // this sets x, y, width, height
        backToParentalControls.setMargin(new Insets(10, 20, 10, 20)); // this is for the top, left, bottom, right
        backToParentalControls.setHorizontalAlignment(SwingConstants.CENTER);
        frame.add(backToParentalControls);

        // this adds an ActionListener to the "Back to Parental Controls" button
        backToParentalControls.addActionListener(e -> {
            mainMenu.playSound("sounds/button_click.wav");
            frame.dispose(); // this closes the Playtime Statistics window
            parentalControlsMenu.showWindow(); // this opens the Parental Controls menu
        });

        // this sets the default close operation to do nothing
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        // this adds a WindowListener to handle the close button ("X") behavior
        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            /**
             * This handles the event when the user clicks the close button ("X").
             * Closes the Playtime Statistics window and opens the Parental Controls menu.
             * 
             * @param windowEvent the window event triggered by clicking the close button
             */
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                frame.dispose(); // this closes the Playtime Statistics window
                parentalControlsMenu.showWindow(); // this opens the Parental Controls menu
            }
        });

        // this makes the frame visible
        frame.setVisible(true);
    }

    /**
     * This is the main method to launch the Playtime Statistics window for testing purposes.
     * 
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        showWindow();
    }
}
