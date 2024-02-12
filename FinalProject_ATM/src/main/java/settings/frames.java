/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package settings;

import javax.swing.*;
import java.awt.*;


public class frames extends JFrame {
    
    // Default frame settings
    ImageIcon image = new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\Logo.png");
    
    public frames(){
        this.setSize(1050, 700);
        this.setVisible(false);
        this.setLayout(null);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setTitle("Bank of Inclusive Transactions");
        this.setResizable(false);
        this.setIconImage(image.getImage());
        this.getContentPane().setBackground(new Color(255, 255, 255));
        this.setLocationRelativeTo(null);
    }
 
}
