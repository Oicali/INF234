/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import settings.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class typeAmount extends frames {
    
    static JPanel pnl1 = new JPanel();
    static sounds sfx = new sounds();
    
    // Generate and redesign the transaction frame
    typeAmount() {
        super();
        JDialog.setDefaultLookAndFeelDecorated(true);

        pnl1.setSize(1244, 700);
        pnl1.setBackground(Color.BLACK);
        pnl1.setLayout(null);
        this.add(pnl1);

        JLabel lbl1 = new JLabel("Enter Amount");
        lbl1.setFont(new Font("Source Sans Pro", Font.ITALIC + Font.BOLD, 30));
        lbl1.setHorizontalAlignment(JLabel.CENTER);
        lbl1.setForeground(new Color(255, 222, 89));
        lbl1.setBounds(450, 40, 400, 40);
        pnl1.add(lbl1);

        JLabel cancelBtn2 = new JLabel();
        cancelBtn2.setIcon(new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\cancelButton.png"));
        cancelBtn2.setBounds(15, 35, 55, 55);
        pnl1.add(cancelBtn2);
        
        //buttons.addVolumeButton(pnl1);
        
        JLabel amountBG = new JLabel();
        amountBG.setIcon(
                new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\typeAmountBG.png"));
        amountBG.setBounds(0, -15, 1050, 700);
        pnl1.add(amountBG);
        
        
        // Buttons Functions
        cancelBtn2.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // No action needed for mouseClicked
            }

            @Override
            public void mousePressed(MouseEvent e) {
                // No action needed for mousePressed
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                sfx.playWarning();

                cancelBtn2.setIcon(new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\cancelButton.png"));
                int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want to cancel transaction?", "Exit Confirmation", JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {

                    
                    dispose();
                   
                    logIn.attempt = 3; 
                    FinalProject_ATM.logInFrame.show();
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                cancelBtn2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                cancelBtn2.setIcon(new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\cancelButton2.png"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                cancelBtn2.setCursor(Cursor.getDefaultCursor());
                cancelBtn2.setIcon(new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\cancelButton.png"));
            }
        });
    }
}
