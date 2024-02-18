/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Deldacan;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Lianne Deldacan
 */
public class MenuDisplay extends JFrame {
    private JLabel messageLabel;
    private JMenuBar menuBar;
    private JMenu lettersMenu, numbersMenu, oddSubmenu, evenSubmenu;
    private JMenuItem consonantsItem, vowelsItem, even1Item, even10Item, odd1Item, odd10Item;
    private ActionListener lettersActionListener, numbersActionListener;
    
    public MenuDisplay() {
        setLayout(new BorderLayout());
        messageLabel = new JLabel("");
        messageLabel.setHorizontalAlignment(JLabel.CENTER);
        messageLabel.setVerticalAlignment(JLabel.CENTER);
        add(messageLabel, BorderLayout.CENTER);
        
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        lettersMenu = new JMenu("Letters");
        numbersMenu = new JMenu("Numbers");
        menuBar.add(lettersMenu);
        menuBar.add(numbersMenu);
        
        consonantsItem = new JMenuItem("Consonants");
        vowelsItem = new JMenuItem("Vowels");
        evenSubmenu = new JMenu("Even");
        oddSubmenu = new JMenu("Odd");
        
        even1Item = new JMenuItem("1-10");
        even10Item = new JMenuItem("10-20");
        odd1Item = new JMenuItem("1-10");
        odd10Item = new JMenuItem("10-20");
        
        evenSubmenu.add(even1Item);
        evenSubmenu.add(even10Item);
        oddSubmenu.add(odd1Item);
        oddSubmenu.add(odd10Item);
        
        lettersMenu.add(consonantsItem);
        lettersMenu.add(vowelsItem);
        numbersMenu.add(evenSubmenu);
        numbersMenu.add(oddSubmenu);
        
        lettersActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lettersActionPerformed(e);
            }
        };
        
        numbersActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numbersActionPerformed(e);
            }
        };
        
        consonantsItem.addActionListener(lettersActionListener);
        vowelsItem.addActionListener(lettersActionListener);
        even1Item.addActionListener(numbersActionListener);
        even10Item.addActionListener(numbersActionListener);
        odd1Item.addActionListener(numbersActionListener);
        odd10Item.addActionListener(numbersActionListener);
    }
    
    private void lettersActionPerformed (ActionEvent e) {
        Object source = e.getSource();
        String message;
        if (source == consonantsItem) {
            message = "bcdfghjklmnpqrstvwxyz";
        }
        else if (source == vowelsItem) {
            message = "aeiou";
        }
        else {
            message = "Uknown letter input";
        }
        messageLabel.setText(message);
    }
    
    private void numbersActionPerformed (ActionEvent e) {
        Object source = e.getSource();
        String message;
        if (source == even1Item) {
            message = "2, 4, 6, 8, 10";
        }
        else if (source == even10Item) {
            message = "12, 14, 16, 18, 20";
        }
        else if (source == odd1Item) {
            message = "1, 3, 5, 7, 9";
        }
        else if (source == odd10Item) {
            message = "11, 13, 15, 17, 19";
        }
        else {
            message = "Uknown number input";
        }
        messageLabel.setText(message);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MenuDisplay menuDisplay = new MenuDisplay();
            menuDisplay.setTitle("Menu Display");            
            menuDisplay.setSize(400, 250);
            menuDisplay.setLocationRelativeTo(null);
            menuDisplay.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            menuDisplay.setVisible(true);
            
        });
    }
}
