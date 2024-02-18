/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.deldacan.ex2;

/**
 *
 * @author Lianne Deldacan
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ex2 extends JFrame {
    private JLabel imageLabel;
    private ImageIcon[] images = {new ImageIcon("dog.jpg"), new ImageIcon("cat.jpg")};
    private int ImageIndex = 0;
    private int distance = 50; // Default distance
    private JTextField inputField;
    private Point CPosition = new Point(350, 170); // Default position

    public ex2() {
        setTitle("Image Movement");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(Color.black);

        imageLabel = new JLabel(images[ImageIndex]);
        imageLabel.setBounds(CPosition.x, CPosition.y, images[ImageIndex].getIconWidth(), images[ImageIndex].getIconHeight());
        add(imageLabel);

        inputField = new JTextField();
        inputField.setBounds(400, 560, 150, 30); // Set position and size for movement input field
        inputField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = inputField.getText().toLowerCase();
                moveImageByInput(input);
                inputField.setText(""); // Clear input field after processing
                requestFocus(); // Return focus to the JFrame after entering text
            }
        });
        add(inputField);

        setSize(950, 650); // Sets the frame size
        setLocationRelativeTo(null);
        setVisible(true);
        DistancePrompt();

        // Add KeyListener to the JFrame to change the image when space key is pressed
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    toggleImage();
                }
            }
        });
        setFocusable(true);
    }

    private void DistancePrompt() {
        String input = JOptionPane.showInputDialog("Enter the distance for movement (default is 50):");
        if (input != null && !input.isEmpty()) {
            try {
                distance = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Invalid input. Using default distance (50).");
            }
        }
    }

    private void moveImageByInput(String input) {
        switch (input) {
            case "up":
                moveImage(0, -distance);
                break;
            case "down":
                moveImage(0, distance);
                break;
            case "left":
                moveImage(-distance, 0);
                break;
            case "right":
                moveImage(distance, 0);
                break;
            default:
                JOptionPane.showMessageDialog(this, "Invalid input. Use 'up', 'down', 'left', or 'right'.");
        }
    }

    private void toggleImage() {
        CPosition = imageLabel.getLocation();
        ImageIndex = (ImageIndex + 1) % images.length;
        imageLabel.setIcon(images[ImageIndex]);
        imageLabel.setBounds(CPosition.x, CPosition.y, images[ImageIndex].getIconWidth(), images[ImageIndex].getIconHeight());
    }

    public void moveImage(int dx, int dy) {
        Point currentPos = imageLabel.getLocation();
        imageLabel.setLocation(currentPos.x + dx, currentPos.y + dy);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ex2());
    }
}