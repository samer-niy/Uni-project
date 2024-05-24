import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class NonogramGame extends JFrame{
    private final int gridSize = 5;  // Grid size for a 5x5 nonogram
    private JPanel[][] panels;
    private Color GrayColor = new Color(240, 240, 240);  // Light gray for unknown

    // Constructor for the NonogramGame class 
    public NonogramGame() {
        this.setTitle("NonogramGame");
        this.setSize(500, 500); 
        this.setLayout(new GridLayout(gridSize, gridSize)); // Grid layout for 5x5
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exits program when window is closed
        this.initializeGrid(); // It initialises the grid
        this.setVisible(true); // Makes the JFrame visible
    }

    private void initializeGrid() { // It initialises the grid
        panels = new JPanel[gridSize][gridSize]; // 5x5 grid

        for (int i = 0; i < gridSize; i++) { // Nested for loop for 5x5 grid
            for (int j = 0; j < gridSize; j++) { // Nested for loop for 5x5 grid
                JPanel panel = new JPanel(); // Creates a new panel
                panel.setBorder(BorderFactory.createLineBorder(Color.gray)); // Adds a gray line border to the panel
                panel.setBackground(GrayColor);  // Initialise as gray

                // Add mouse listener to cycle through colors: gray -> white -> black -> gray
                panel.addMouseListener(new MouseAdapter() { 
                    @Override // Override the mouseClicked method
                    public void mouseClicked(MouseEvent e) { 
                        cyclePanelColor(panel); // Method call to change panel background color on click
                    }
                });

                panels[i][j] = panel; // Add the panel to the 5x5 grid
                add(panel);
            }
        }
    }

    private void cyclePanelColor(JPanel panel) { // Method to change the color of a panel
        Color currentColor = panel.getBackground(); // Gets the current background color of the panel
        if (currentColor.equals(GrayColor)) { // Checks if the current color is gray
            panel.setBackground(Color.white);  // Change from gray to white
        } else if (currentColor.equals(Color.white)) {
            panel.setBackground(Color.black);  // Change from white to black
        } else {
            panel.setBackground(GrayColor);  // Change from black to gray
        }
    }

    public static void main(String[] args) { // Main method that runs the application
            NonogramGame frame = new NonogramGame(); // Creates an instance of NonogramGame
        };
    }
