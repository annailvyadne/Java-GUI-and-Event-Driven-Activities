package ex1;

/*
Student name: Lianne Francheska S. Deldacan
Section: BSIT-2-AM2
Course: CSS124L
Title: Layout Managers
*/

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Panel;
import javax.swing.BorderFactory;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SpaceXStarlinkProject extends JFrame {
    // Declaration of elements
    /*
    label 1 - Satellite ID
    label 2 - Satellite Name
    label 3 = Longitude 
    label 4 = Latitude
    label 5 - Elevation
    Label 6 - Health Status
    */
    JLabel label1, label2, label3, label4, label5, label6;
    
    /*
    tf1 - Satellite ID
    tf2 - Satellite name
    tf3 - longitude
    tf4 - latitude
    tf5 - elevation
    tf6 - health status
    */
    
    JTextField tf1, tf2, tf3, tf4, tf5, tf6;
    
    JTextArea ta;

    JPanel jp1, jp2, jp3, jp_t1, jp_t2, jp_t3, jp_t4, jp_b1;
    /*
    jp1 - top
    jp2 - center
    jp3 - bottom
    jp_t1 - for id and find button
    jp_t2 - for name
    jp_t3 - for long and latitude
    jp_t4 - for elevate and status
    jp_b1 - for save, update, delete
    */
          
    JButton b1, b2, b3, b4, b5;
    /*
    b1 - FInd Satellite
    b2 - Save
    b3 - Update
    b4 - Delete
    b5 - Clear All
    */
    
    JComboBox cStatus;        
            
    public SpaceXStarlinkProject() {
        
        //Panels
        jp1 = new JPanel(); //top
        jp2 = new JPanel(); //center
        jp3 = new JPanel(); //bottom
        jp_t1 = new JPanel(); //id and find button
        jp_t2 = new JPanel(); //satellite name
        jp_t3 = new JPanel(); //longitude and latitude
        jp_t4 = new JPanel(); //elevate and status
        jp_b1 = new JPanel(); //save, update, delete buttons
        
        //Buttons
        //Find Satellite button
        b1 = new JButton("Find Satellite");
        int buttonHeight = b1.getPreferredSize().height;
        int cButtonWidth = 200;
        b1.setPreferredSize(new Dimension(315, buttonHeight));
        b1.setBackground(Color.LIGHT_GRAY);
         
        //Save button
        b2 = new JButton("Save");
        b2.setPreferredSize(new Dimension(cButtonWidth, buttonHeight)); //cButtonWidth = 200
        b2.setBackground(Color.LIGHT_GRAY);
        
        //Update button
        b3 = new JButton("Update");
        b3.setPreferredSize(new Dimension(cButtonWidth, buttonHeight)); //cButtonWidth = 200
        b3.setBackground(Color.LIGHT_GRAY);
        
        //Delete button
        b4 = new JButton("Delete");
        b4.setPreferredSize(new Dimension(cButtonWidth, buttonHeight)); //cButtonWidth = 200
        b4.setBackground(Color.LIGHT_GRAY);
        
        //Clear All Button
        b5 = new JButton("Clear All");
        b5.setPreferredSize(new Dimension(cButtonWidth, buttonHeight)); //cButtonWidth = 200
        b5.setBackground(Color.LIGHT_GRAY);
        
        
        //Labels
        //Satellite ID
        label1 = new JLabel("Satellite ID");
        label1.setForeground(Color.BLUE);
        //text field for Satellite ID
        tf1 = new JTextField(20);

        //Satellite Name
        label2 = new JLabel("Satellite Name");
        label2.setForeground(Color.BLUE);
        //text field for Satellite Name
        tf2 = new JTextField(47);
        
        //Longitude
        label3 = new JLabel("Longitude");
        label3.setForeground(Color.BLUE);
        //text field for Longitude
        tf3 = new JTextField(20);

        //Latitude
        label4 = new JLabel("Latitude");
        label4.setForeground(Color.BLUE);
       
        // Set margins for the label4 (top, left, bottom, right)
        label4.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 23));
        
        //text field for Latitude
        tf4 = new JTextField(22);

        
        //Elevation
        label5 = new JLabel("Elevation");
        label5.setForeground(Color.BLUE);
        //text field for Elevation
        tf5 = new JTextField(20);
        
        //Health Status
        label6 = new JLabel("Health Status");
        label6.setForeground(Color.BLUE);

        //Health Status combo box
        cStatus = new JComboBox();
        cStatus.setPreferredSize(new Dimension(240, 20));
        
        
        //Text Area
        ta = new JTextArea(10, 50);
        ta.setBackground(Color.GRAY);
        ta.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
        
        JScrollPane scrollPane = new JScrollPane(ta);

        
        //set margins 
        int PanelMargin = 10;
        //jp_top is jp1
        jp1.setLayout(new GridLayout(4,1));
        jp1.add(jp_t1);jp1.add(jp_t2);jp1.add(jp_t3);jp1.add(jp_t4);
        
        //satellite ID and Find Satellite button
        jp_t1.setLayout(new FlowLayout(PanelMargin));
        //
        jp_t1.add(label1); jp_t1.add(tf1); jp_t1.add(b1);
     
        //Satellite Name
        jp_t2.setLayout(new FlowLayout(PanelMargin));
        jp_t2.add(label2); jp_t2.add(tf2);
        
        //Longitude and Latitude
        jp_t3.setLayout(new FlowLayout(PanelMargin));
        jp_t3.add(label3); jp_t3.add(tf3);jp_t3.add(label4); jp_t3.add(tf4);
        
        //Elevation and Health Status
        jp_t4.setLayout(new FlowLayout(PanelMargin));
        jp_t4.add(label5); jp_t4.add(tf5); jp_t4.add(label6); jp_t4.add(cStatus);
        
        jp_b1.setLayout(new FlowLayout());
        jp_b1.add(b2); jp_b1.add(b3); jp_b1.add(b4);
        jp_b1.setBorder(BorderFactory.createEmptyBorder(0, 0, 15, 0));
        
        
        
        //CENTER
        jp2.setLayout(new BorderLayout());
        jp2.add(jp_b1, BorderLayout.NORTH);
        jp2.add(scrollPane, BorderLayout.CENTER);
        
        //SOUTH
        jp3.setLayout(new FlowLayout());
        jp3.add(b5);
        
        add(jp1, BorderLayout.NORTH);
        add(jp2, BorderLayout.CENTER);
        add(jp3, BorderLayout.SOUTH);
        
        // Frame Properties
        setTitle("Starlink Project");
        setSize(650, 455);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
       
    }

    public static void main(String[] args) {
        SpaceXStarlinkProject obj = new SpaceXStarlinkProject();

    }
}
