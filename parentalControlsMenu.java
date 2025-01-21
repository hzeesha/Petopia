import java.awt.*;
import javax.swing.*;                                                                                          

/**
 * This class is the parentalControlsMenu class and it provides a graphical user interface
 * for accessing and managing parental control features in Petopia.
 *
 * <p>This menu allows users to view child-related statistics, apply parental limitations and changes,
 * or return to the main menu.</p>
 * 
 * @author Team 34
 * @version 1.0
 * @since 2024-12-03
 */
public class parentalControlsMenu {

    /**
     * This displays the Parental Controls Menu window, providing options to:
     * <ul>
     *   <li>View child's statistics</li>
     *   <li>Apply parental limitations and changes</li>
     *   <li>Return to the main menu</li>
     * </ul>
     */
    public static void showWindow() {
        // This creates a new JFrame
        JFrame frame = new JFrame("Parental Controls Menu");
        frame.setSize(500, 400); // This sets the size of the frame
        frame.setLocationRelativeTo(null); // This centers the frame on the screen
        frame.setLayout(null); // 

        // This adds a title label
        JLabel pageTitle = new JLabel("Parental Controls Menu");
        pageTitle.setBounds(140, 25, 225, 30); // This sets the position and size
        pageTitle.setFont(new Font("Arial", Font.PLAIN, 20)); // This sets the font
        frame.add(pageTitle);

        // This adds a button to view the child's statistics
        JButton childStats = new JButton("View Child's Statistics");
        childStats.setBounds(155, 85, 180, 60);
        frame.add(childStats);

        // This adds a button for parental limitations and changes
        JButton parentalChanges = new JButton("<html><div align='center'>Parental Limitations &<br>Changes</div></html>");
        parentalChanges.setBounds(155, 165, 180, 60);
        parentalChanges.setMargin(new Insets(10, 20, 10, 20)); // This adjusts the button padding
        parentalChanges.setHorizontalAlignment(SwingConstants.CENTER); // this centers the text
        frame.add(parentalChanges);

        // This adds a button that returns you to the main menu
        JButton mainMenu = new JButton("Main Menu");
        mainMenu.setBounds(170, 290, 150, 30);
        frame.add(mainMenu);

        mainMenu.addActionListener(e -> frame.dispose()); // This closes the frame when clicked

        childStats.addActionListener(e -> {
            frame.dispose(); // this closes the current window
            playtimeStatistics.showWindow(); // This opens the playtime statistics window
        });

        parentalChanges.addActionListener(e -> {
            frame.dispose(); // this closes the current window
            childLimitations.showWindow(); // this opens the child limitations window
        });

        // this sets the default close operation
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // this closes only the window

        // this makes the frame visible
        frame.setVisible(true);
    }

    /**
     * This is the main method that serves as the 'entry point' to launch the Parental Controls Menu.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        showWindow();
    }
}
