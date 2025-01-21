import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import java.io.BufferedWriter;

/**
 * This class is the saveGame class that provides a GUI for saving game progress into predefined save slots.
 * It includes methods to display the save game interface and save player data to files.
 * 
 * <p>This class uses Swing for GUI design and file I/O for saving game data. It is a part of a larger
 * project, and the methods interact with other classes like {@code getPetStats} and {@code playerInventory}
 * to gather game data.</p>
 * 
 * @author group 34
 * @version 1.0
 * @since 2024-12-04
 * */
public class saveGame {

    /**
     * Displays a window that allows the user to select a save slot for saving game progress.
     * The window includes buttons for three save slots and a back button to return to the previous menu.
     */
    public static void showWindow() {
        // this creates a new JFrame
        JFrame frame = new JFrame("Save Game");
        // this sets the size of the frame
        frame.setSize(500, 400); // this sets the width to 600px and the height to 600px
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);

        JLabel pageTitle = new JLabel("Save Game");
        pageTitle.setBounds(193, 25, 225, 30); // this sets x, y, width, height
        pageTitle.setFont(new Font("Arial", Font.PLAIN, 20));
        pageTitle.setOpaque(false);
        pageTitle.setBorder(null);
        frame.add(pageTitle);

        JLabel prompt = new JLabel("Which Save Slot do you want to save to?");
        prompt.setBounds(97, 57, 300, 30); // this sets x, y, width, height
        prompt.setFont(new Font("Arial", Font.PLAIN, 16));
        prompt.setOpaque(false);
        prompt.setBorder(null);
        frame.add(prompt);

        JButton saveSlot1 = new JButton("Save Slot 1");
        saveSlot1.setBounds(195, 100, 100, 60); // this sets x, y, width, height
        frame.add(saveSlot1);
        saveSlot1.addActionListener(e -> {
            mainMenu.playSound("sounds/button_click.wav");
            try {
                savePlayerData("1");
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }); // this saves the game to 'save slot 1'

        JButton saveSlot2 = new JButton("Save Slot 2");
        saveSlot2.setBounds(195, 175, 100, 60); // this sets x, y, width, height
        frame.add(saveSlot2);
        saveSlot2.addActionListener(e -> {
            mainMenu.playSound("sounds/button_click.wav");
            try {
                savePlayerData("2");
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }); // this saves the game to 'save slot 2'

        JButton saveSlot3 = new JButton("Save Slot 3");
        saveSlot3.setBounds(195, 250, 100, 60); // this sets x, y, width, height
        frame.add(saveSlot3);
        saveSlot3.addActionListener(e -> {
            mainMenu.playSound("sounds/button_click.wav");
            try {
                savePlayerData("3");
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }); // this saves the game to 'save slot 3'

        JButton backToGame = new JButton("<-- Back");
        backToGame.setBounds(30, 305, 100, 30); // this sets x, y, width, height
        frame.add(backToGame);
        backToGame.addActionListener(e -> {
            mainMenu.playSound("sounds/button_click.wav");
            frame.dispose();
        }); // this closes the frame when "Main Menu" is clicked

        // this sets the default close operation (and it exits the application when the window is closed)
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // this sets the frame's visibility
        frame.setVisible(true);

        // this centers the frame on the screen (optionally)
        frame.setLocationRelativeTo(null);
    }

    /**
     * this saves the player's game data to the specified save slot.
     * 
     * @param saveSlot the save slot identifier (e.g., "1", "2", "3").
     * @throws Exception if an error occurs during file writing.
     */
    public static void savePlayerData(String saveSlot) throws Exception {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("saveSlot" + saveSlot + ".csv"));
            
            String petStatData = getPetStats.getPetType() + ","
                    + getPetStats.getPetName() + ","
                    + getPetStats.getHealth() + ","
                    + getPetStats.getHappiness() + ","
                    + getPetStats.getFullness() + ","
                    + getPetStats.getSleep() + ","
                    + playerInventory.getBalls() + ","
                    + playerInventory.getFish() + ","
                    + playerInventory.getBears() + ","
                    + playerInventory.getMilk() + ","
                    + playerInventory.getBlocks() + ","
                    + playerInventory.getTreats() + ","
                    + playerInventory.getSpinners() + ","
                    + playerInventory.getChicken() + "," 
                    + getPetStats.getScore();
            writer.write(petStatData);
            writer.close();
            JFrame frame = new JFrame("Save Game");
            JOptionPane.showMessageDialog(frame, "Game has been saved to Save Slot " + saveSlot, "Saved",
                    JOptionPane.INFORMATION_MESSAGE);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This is the main method to launch the save game GUI.
     * 
     * @param args command-line arguments (not used).
     */
    public static void main(String[] args) {
        showWindow();
    }
}
