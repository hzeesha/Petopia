import java.awt.*;
import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * This class is the childLimitations class and it provides a GUI for managing the parental controls in the Petopia game.
 * Some features include adjusting child playtime preferences and reviving pets in saved game slots.
 *
 * <p>This class is part of the Petopia project.</p>
 * 
 * @author group 34
 * @version 1.0
 * @since 2024-12-03
 */
public class childLimitations {

    /**
     * This displays the Parental Controls Menu, which allows users to manage child playtime preferences,
     * revive pets, and navigate back to the main parental controls menu.
     */
    public static void showWindow() {
        // this creates a new JFrame
        JFrame frame = new JFrame("Parental Controls Menu");
        frame.setSize(500, 400); // This sets the width to 500px and the height to 400px
        frame.setLocationRelativeTo(null); // this centers the frame on the screen
        frame.setLayout(null);

        // this adds a title to the frame
        JLabel pageTitle = new JLabel("Parental Change Options");
        pageTitle.setBounds(130, 25, 225, 30); // these numbers represent: x, y, width, height respectivley
        pageTitle.setFont(new Font("Arial", Font.PLAIN, 20));
        frame.add(pageTitle);

        // this adds the child playtime preference label
        JLabel text1 = new JLabel("Child Play Time Preferences");
        text1.setBounds(25, 75, 275, 30); // these numbers represent: x, y, width, height respectivley
        text1.setFont(new Font("Arial", Font.PLAIN, 16));
        frame.add(text1);

        // this adds a revive pet label
        JLabel text2 = new JLabel("Revive Pet");
        text2.setBounds(330, 75, 275, 30); //these numbers represent: x, y, width, height respectivley
        text2.setFont(new Font("Arial", Font.PLAIN, 16));
        frame.add(text2);

        // this adds buttons to revive pets in specific save slots
        JButton saveSlot1 = new JButton("<html><div align='center'>REVIVE<br>Save Slot 1 Pet</div></html>");
        saveSlot1.setBounds(305, 105, 120, 50); //these numbers represent: x, y, width, height respectivley
        frame.add(saveSlot1);
        saveSlot1.addActionListener(e -> {
            mainMenu.playSound("sounds/button_click.wav");
            try {
                revivePet("1");
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });

        JButton saveSlot2 = new JButton("<html><div align='center'>REVIVE<br>Save Slot 2 Pet</div></html>");
        saveSlot2.setBounds(305, 160, 120, 50); //these numbers represent: x, y, width, height respectivley
        frame.add(saveSlot2);
        saveSlot2.addActionListener(e -> {
            mainMenu.playSound("sounds/button_click.wav");
            try {
                revivePet("2");
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });

        JButton saveSlot3 = new JButton("<html><div align='center'>REVIVE<br>Save Slot 3 Pet</div></html>");
        saveSlot3.setBounds(305, 215, 120, 50); //these numbers represent: x, y, width, height respectivley
        frame.add(saveSlot3);
        saveSlot3.addActionListener(e -> {
            mainMenu.playSound("sounds/button_click.wav");
            try {
                revivePet("3");
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });

        // this adds a button that returns you to the parental controls menu
        JButton parentalChanges = new JButton("<html><div align='center'>Back to<br>Parental Controls</div></html>");
        parentalChanges.setBounds(155, 300, 180, 45); //these numbers represent: x, y, width, height respectivley
        frame.add(parentalChanges);

        // this is an action listener for returning to the parental controls menu
        parentalChanges.addActionListener(e -> {
            mainMenu.playSound("sounds/button_click.wav");
            frame.dispose(); // this closes the current window
            parentalControlsMenu.showWindow(); // this opens the parental controls menu
        });

        // this handles the 'close' operation of the window
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                frame.dispose();
                parentalControlsMenu.showWindow();
            }
        });

        frame.setVisible(true); // this displays the frame
        
    }

    /**
     * This revives the pet in the specified save slot by resetting its attributes 
     * to the default values and updating the save file.
     *
     * @param saveSlot the save slot number to revive the pet from (e.g., "1", "2", "3")
     * @throws Exception if an error occurs during file operations
     */
    public static void revivePet(String saveSlot) throws Exception {
        String path = "saveSlot" + saveSlot + ".csv";
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            BufferedWriter writer = new BufferedWriter(new FileWriter("saveSlot" + saveSlot + ".csv"));
            String petReset = getPetStats.getPetType() + ','
                    + getPetStats.getPetName() + ","
                    + "100," // health
                    + "100," // happiness
                    + "100," // fullness
                    + "100," // sleep
                    + "5," // balls
                    + "5," // fish
                    + "5," // bears
                    + "5," // milk
                    + "5," // blocks
                    + "5," // treats
                    + "5," // spinners
                    + "5," // chicken
                    + getPetStats.getScore(); // this gives you the score
            writer.write(petReset);
            writer.close();
            JOptionPane.showMessageDialog(null, "Save Slot " + saveSlot + " has had the pet revived", "Revived", JOptionPane.INFORMATION_MESSAGE);
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Save File not found. Please try again or start a new game.", "Error Finding Game", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error occurred while handling the save file. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    /**
     * This is the main method that serves as the 'entry point' for the application.
     * It launches the Parental Controls Menu.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        showWindow();
    }
}
