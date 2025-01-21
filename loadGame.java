import java.awt.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.*;

/**
 * This class is the loadGame class which provides functionality for loading saved game data
 * from predefined save slots and displaying the game's progress in the game.
 *
 * <p>This class allows users to load game states stored in CSV files and initializes the 
 * Petopia gameplay window with the loaded data.</p>
 * 
 * @author group 34
 * @version 1.0
 * @since 2024-12-03
 */
public class loadGame {

    /**
     * This displays the Load Game menu, which allows users to select a save slot or return to the main menu.
     * Each save slot corresponds to a file from which game data can be loaded.
     */
    public static void showWindow() {
        // this creates a new JFrame
        JFrame frame = new JFrame("Load Game");
        frame.setSize(500, 400); // This sets the width to 500px and the Height to 400px
        frame.setLocationRelativeTo(null); // this centers the frame on the screen
        frame.setLayout(null);

        // this adds a page title
        JLabel pageTitle = new JLabel("Load Game");
        pageTitle.setBounds(193, 25, 225, 30);
        pageTitle.setFont(new Font("Arial", Font.PLAIN, 20));
        frame.add(pageTitle);

        // this adds buttons for each save slot
        JButton saveSlot1 = new JButton("Save Slot 1");
        saveSlot1.setBounds(195, 75, 100, 60);
        frame.add(saveSlot1);
        saveSlot1.addActionListener(e -> {
            mainMenu.playSound("sounds/button_click.wav");
            frame.dispose();
            try {
                loadPlayerData("1");
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });

        JButton saveSlot2 = new JButton("Save Slot 2");
        saveSlot2.setBounds(195, 150, 100, 60);
        frame.add(saveSlot2);
        saveSlot2.addActionListener(e -> {
            mainMenu.playSound("sounds/button_click.wav");
            frame.dispose();
            try {
                loadPlayerData("2");
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });

        JButton saveSlot3 = new JButton("Save Slot 3");
        saveSlot3.setBounds(195, 225, 100, 60);
        frame.add(saveSlot3);
        saveSlot3.addActionListener(e -> {
            mainMenu.playSound("sounds/button_click.wav");
            frame.dispose();
            try {
                loadPlayerData("3");
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });

        // this adds a Main Menu button
        JButton mainMenuButton = new JButton("Main Menu");
        mainMenuButton.setBounds(170, 305, 150, 30);
        frame.add(mainMenuButton);
        mainMenuButton.addActionListener(e -> {
            mainMenu.playSound("sounds/button_click.wav");
            frame.dispose();
        }); // this returns you to the main menu by closing the frame

        // this sets the default close operation
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // this closes the window without exiting the application
        frame.setVisible(true); // after, this displays the frame
    }

    /**
     * This loads player data from the specified save slot file and initializes the game window
     * with the loaded data.
     * 
     * @param saveSlot the save slot number (e.g., "1", "2", or "3") to load game data from
     * @throws Exception if an error occurs during file reading
     */
    public static void loadPlayerData(String saveSlot) throws Exception {
        String path = "saveSlot" + saveSlot + ".csv";
        String line = "";

        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String[] values = {""};

            // this reads and parses the save file
            while ((line = br.readLine()) != null) {
                values = line.split(",");
            }

            // this extracts the pet stats from the parsed data
            String petType = values[0];
            String petName = values[1];
            int health = Integer.parseInt(values[2]);
            int happiness = Integer.parseInt(values[3]);
            int fullness = Integer.parseInt(values[4]);
            int sleep = Integer.parseInt(values[5]);
            int balls = Integer.parseInt(values[6]);
            int fish = Integer.parseInt(values[7]);
            int bears = Integer.parseInt(values[8]);
            int milk = Integer.parseInt(values[9]);
            int blocks = Integer.parseInt(values[10]);
            int treats = Integer.parseInt(values[11]);
            int spinners = Integer.parseInt(values[12]);
            int chicken = Integer.parseInt(values[13]);
            int score = Integer.parseInt(values[14]);

            //sets the player inventory
            playerInventory.setBalls(balls);
            playerInventory.setFish(fish);
            playerInventory.setBears(bears);
            playerInventory.setMilk(milk);
            playerInventory.setBlocks(blocks);
            playerInventory.setTreats(treats);
            playerInventory.setSpinners(spinners);
            playerInventory.setChicken(chicken);

            // this initializes the pet window with the loaded stats
            pet petWindow = new pet(petType, petName, health, happiness, fullness, sleep, score);
            petWindow.setVisible(true);

        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Save File not found. Please try again or start a new game.", "Error Loading Game", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "An error occurred while loading the save file. Please try again.", "Error Loading Game", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    /**
     * This is the main method and it serves as the 'entry point' for the Load Game menu.
     * It displays the Load Game window where users can select a save slot or return to the main menu.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        showWindow();
    }
}
