import javax.swing.*;
import java.awt.*;
import javax.swing.border.LineBorder;
import java.awt.event.*;

/**
 * The class is the startGame class that provides a GUI interface for the user to choose their pet 
 * and enter a name for it. This class includes functionality for confirming the pet's name 
 * and selecting one of three pets, each represented by a button.
 * 
 * <p>This class demonstrates the use of Swing for creating an interactive GUI application.</p>
 * 
 * @author group 34
 * @version 1.0
 * @since 2024-12-04
 */   
 
public class startGame extends JFrame {

    /**
     * This displays the main window for selecting a pet and entering the pet's name.
     * The window includes text fields, buttons, and image icons for interaction.
     */
    public static void showWindow() {
        JFrame frame = new JFrame("Choose Your Pet");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);

        // this is the title label
        JLabel pageTitle = new JLabel("Select Your Pet");
        pageTitle.setBounds(275, 45, 225, 30); // this sets x, y, width, height
        pageTitle.setFont(new Font("Arial", Font.BOLD, 30));
        pageTitle.setOpaque(false);
        pageTitle.setBorder(null);
        frame.add(pageTitle);

        // this is the label for entering pet name
        JLabel nameLabel = new JLabel("Enter your pet's name:");
        nameLabel.setBounds(275, 100, 250, 30); // this sets the x, y, width, height
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        frame.add(nameLabel);

        // this is the text field for pet's name
        JTextField petNameField = new JTextField();
        petNameField.setBounds(275, 130, 250, 30); // this sets the x, y, width, height
        frame.add(petNameField);

        // this gets the button to confirm pet name
        JButton confirmButton = new JButton("Confirm Name");
        confirmButton.setBounds(275, 170, 250, 30); // this sets the x, y, width, height
        frame.add(confirmButton);

        // this disables the pet selection buttons initially
        JButton pet1Button = createPetButton("cat_normal.png", 95, 175);
        JButton pet2Button = createPetButton("dog_normal.png", 285, 175);
        JButton pet3Button = createPetButton("sheep_normal.png", 475, 175);

        pet1Button.setEnabled(false);
        pet2Button.setEnabled(false);
        pet3Button.setEnabled(false);

        frame.add(pet1Button);
        frame.add(pet2Button);
        frame.add(pet3Button);

        // this is to confirm the button is clicked, and enable pet selection buttons
        confirmButton.addActionListener(e -> {
            mainMenu.playSound("sounds/button_click.wav");
            playerInventory.setBalls(5);
            playerInventory.setFish(5);
            playerInventory.setBears(5);
            playerInventory.setMilk(5);
            playerInventory.setBlocks(5);
            playerInventory.setTreats(5);
            playerInventory.setSpinners(5);
            playerInventory.setChicken(5);

            String petName = petNameField.getText().trim();
            if (!petName.isEmpty()) {
                // this enables the pet selection buttons
                pet1Button.setEnabled(true);
                pet2Button.setEnabled(true);
                pet3Button.setEnabled(true);

                // this optionally shows a confirmation message
                JOptionPane.showMessageDialog(frame, "Your pet's name is: " + petName);
            } else {
                // this is for when no name is entered, and it shows an error message
                JOptionPane.showMessageDialog(frame, "Please enter a valid pet name.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // this sets the action listeners for the pet buttons
        pet1Button.addActionListener(e -> {
            mainMenu.playSound("sounds/button_click.wav");
            String petName = petNameField.getText().trim();
            pet petWindow = new pet("cat", petName, 100, 100, 100, 100, 5); // Pass name to pet window
            petWindow.setVisible(true);
            frame.dispose(); // this closes the pet selection window
        });

        pet2Button.addActionListener(e -> {
            mainMenu.playSound("sounds/button_click.wav");
            String petName = petNameField.getText().trim();
            pet petWindow = new pet("dog", petName, 100, 100, 100, 100, 5); // this passes name to pet window
            petWindow.setVisible(true);
            frame.dispose(); // this closes the pet selection window
        });

        pet3Button.addActionListener(e -> {
            mainMenu.playSound("sounds/button_click.wav");
            String petName = petNameField.getText().trim();
            pet petWindow = new pet("sheep", petName, 100, 100, 100, 100, 5); // this passes the name to pet window
            petWindow.setVisible(true);
            frame.dispose(); // this closes the pet selection window
        });

        frame.setVisible(true);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                mainMenu.onApplicationClose(mainMenu.getStartTIme());
            }
        });
    }

    /**
     * this creates a button for selecting a pet. The button displays an image of the pet
     * and changes its border and icon on hover.
     * 
     * @param petImagePath the relative path to the pet's image.
     * @param x            the x-coordinate of the button's position.
     * @param y            the y-coordinate of the button's position.
     * @return a {@code JButton} configured with the pet's image and hover effects.
     */
    private static JButton createPetButton(String petImagePath, int x, int y) {
        ImageIcon petIcon = new ImageIcon("sprites/" + petImagePath);
        Image scaledPet = petIcon.getImage().getScaledInstance(225, 225, Image.SCALE_SMOOTH);
        ImageIcon scaledPetIcon = new ImageIcon(scaledPet);

        JButton petButton = new JButton(scaledPetIcon);
        petButton.setBorderPainted(false);
        petButton.setFocusPainted(false);
        petButton.setContentAreaFilled(false);
        petButton.setBounds(x, y, 200, 200);

        petButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                petButton.setBorder(new LineBorder(Color.BLUE, 2));
                Image scaledImage = petIcon.getImage().getScaledInstance(
                        (int) (250 * 1.1), (int) (250 * 1.1), Image.SCALE_SMOOTH);
                petButton.setIcon(new ImageIcon(scaledImage));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                petButton.setBorder(null);
                petButton.setIcon(petIcon);
            }
        });

        return petButton;
    }

    /**
     * This is the main method that launches the pet selection window.
     * 
     * @param args command-line arguments (not used).
     */
    public static void main(String[] args) {
        showWindow();
    }
}
