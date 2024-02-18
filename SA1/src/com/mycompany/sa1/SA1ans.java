package com.mycompany.sa1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class SA1ans extends JFrame {
    private JCheckBox checkBox1, checkBox2, checkBox3;
    private JRadioButton radioButton1, radioButton2;
    private JPanel panel1, panel2, innerPanel;

    public SA1ans() {
        setTitle("Lianne Deldacan");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 250);
        setLayout(new BorderLayout());

        panel1 = new JPanel(new GridLayout(4, 1));
        JLabel label1 = new JLabel("Choose Panel");
        label1.setOpaque(false);
        panel1.add(label1);

        checkBox1 = new JCheckBox("Panel 1");
        checkBox1.setOpaque(false);
        panel1.add(checkBox1);
        checkBox2 = new JCheckBox("Panel 2");
        checkBox2.setOpaque(false);
        panel1.add(checkBox2);
        checkBox3 = new JCheckBox("Panel 3");
        checkBox3.setOpaque(false);
        panel1.add(checkBox3);

        panel2 = new JPanel(new GridLayout(3, 1));
        JLabel label2 = new JLabel("Choose Color:");
        label2.setOpaque(false);
        panel2.add(label2);

        radioButton1 = new JRadioButton("Red");
        radioButton1.setOpaque(false);
        panel2.add(radioButton1);
        radioButton2 = new JRadioButton("Blue");
        radioButton2.setOpaque(false);
        panel2.add(radioButton2);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(radioButton1);
        buttonGroup.add(radioButton2);

        JPanel panel3 = new JPanel(new GridLayout(1, 1));
        JButton button2 = new JButton("Reset");
        button2.setPreferredSize(new Dimension(460, 30));

        innerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        innerPanel.add(button2);
        panel3.add(innerPanel);

        checkBox1.addActionListener(e -> updatePanelColor(checkBox1, panel1));
        checkBox2.addActionListener(e -> updatePanelColor(checkBox2, panel2));
        checkBox3.addActionListener(e -> updatePanelColor(checkBox3, innerPanel));

        radioButton1.addActionListener(e -> updatePanelColorForAll());
        radioButton2.addActionListener(e -> updatePanelColorForAll());

        button2.addActionListener(e -> {
            panel1.setBackground(null);
            panel2.setBackground(null);
            innerPanel.setBackground(null);

            checkBox1.setSelected(false);
            checkBox2.setSelected(false);
            checkBox3.setSelected(false);
            buttonGroup.clearSelection();
        });

        add(panel1, BorderLayout.NORTH);
        add(panel2, BorderLayout.CENTER);
        add(panel3, BorderLayout.SOUTH);
        setVisible(true);
    }

    private void updatePanelColor(JCheckBox checkBox, JPanel panel) {
        Color color = null;
        if (radioButton1.isSelected()) {
            color = Color.RED;
        } else if (radioButton2.isSelected()) {
            color = Color.BLUE;
        }
        panel.setBackground(checkBox.isSelected() ? color : null);
    }

    private void updatePanelColorForAll() {
        Color color = null;
        if (radioButton1.isSelected()) {
            color = Color.RED;
        } else if (radioButton2.isSelected()) {
            color = Color.BLUE;
        }
        if (checkBox1.isSelected()) {
            panel1.setBackground(color);
        }
        if (checkBox2.isSelected()) {
            panel2.setBackground(color);
        }
        if (checkBox3.isSelected()) {
            innerPanel.setBackground(color);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new SA1ans();
        });
    }
}
