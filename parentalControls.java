import javax.swing.*;

/**
 * This class is the parentalControls class and it provides a simple graphical user interface for 
 * accessing parental control options in Petopia.
 *
 * <p>This is a placeholder implementation that displays a basic window with a title and label. 
 * Future enhancements can add functionality for managing parental controls.</p>
 * 
 * @author Team 34
 * @version 1.0
 * @since 2024-12-03
 */
public class parentalControls {

    /**
     * This displays the Parental Controls window with a placeholder label.
     * This serves as a basic framework for implementing parental control features.
     */
    public static void showWindow() {
        // This creates a new JFrame
        JFrame frame = new JFrame("Parental Controls");

        // This adds a label with the title "Parental Controls"
        JLabel label = new JLabel("Parental Controls");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        frame.add(label);

        // This sets the size of the frame
        frame.setSize(600, 600); // this sets the Width: 600px and the Height: 600px

        // This sets the default close operation (exit the application when the window is closed)
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // This centers the frame on the screen
        frame.setLocationRelativeTo(null);

        // This sets the frame's visibility
        frame.setVisible(true);
    }

    /**
     * This is the main method that serves as an 'entry point' to launch the Parental Controls window.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        showWindow();
    }
}
