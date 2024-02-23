/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package settings;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.text.DecimalFormat;

public class frames extends JFrame {
    
    // Global variables
    public static DecimalFormat format = new DecimalFormat("##,###,###,###,###.00");
    ImageIcon image = new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\Logo.png");

    
    // Default frame settings
    public frames() {
        //this.setSize(1050, 700);
        //this.setTitle("Bank of Inclusive Transactions");
        this.setUndecorated(true);
        this.setSize(1037, 662);
        this.setVisible(false);
        this.setLayout(null);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setIconImage(image.getImage());
        this.getContentPane().setBackground(new Color(255, 255, 255));
        this.setLocationRelativeTo(null);
        
        JDialog.setDefaultLookAndFeelDecorated(true);
   
        // Create a rounded frame
        Shape roundedRectangle = new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 20, 20);
        setShape(roundedRectangle);

    }
}
