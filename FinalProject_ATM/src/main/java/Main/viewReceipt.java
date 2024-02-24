/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import settings.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class viewReceipt extends frames {
    
    //Global variables
    static JPanel viewReceiptPnl = new JPanel();
    static sounds sfx = new sounds();
    static JLabel viewReceiptVolume = new JLabel();
    
    // Generate and redesign the view receipt frame
    viewReceipt(){
        super();
        
        viewReceiptPnl.setSize(1244, 700);
        viewReceiptPnl.setBackground(Color.BLACK);
        viewReceiptPnl.setLayout(null);
        this.add(viewReceiptPnl);
        
        JLabel lbl1 = new JLabel();
        lbl1.setText("Check your Receipt");
        lbl1.setFont(new Font("Source Sans Pro", Font.ITALIC + Font.BOLD, 30));
        lbl1.setHorizontalAlignment(JLabel.CENTER);
        lbl1.setForeground(new Color(255, 222, 89));
        lbl1.setBounds(290, 40, 450, 40);
        viewReceiptPnl.add(lbl1);
        
        JLabel lbl2 = new JLabel();
        lbl2.setText("Bank of Inclusive Transactions");
        lbl2.setFont(new Font("Source Sans Pro", Font.BOLD, 24));
        lbl2.setHorizontalAlignment(JLabel.CENTER);
        lbl2.setForeground(Color.BLACK);
        lbl2.setBounds(265, 166, 500, 50);
        viewReceiptPnl.add(lbl2);
        
        // Display username
        JLabel lbl3 = new JLabel();
        lbl3.setText(account.user.getName());
        lbl3.setFont(new Font("Source Sans Pro", Font.BOLD, 32));
        lbl3.setHorizontalAlignment(JLabel.CENTER);
        lbl3.setForeground(Color.BLACK);
        lbl3.setBounds(265, 232, 500, 60);
        viewReceiptPnl.add(lbl3);
      
        // Display censored UID
        JLabel lbl4 = new JLabel();
        lbl4.setText(viewBalance.maskedStr1 + viewBalance.str2);
        lbl4.setFont(new Font("Source Sans Pro", Font.BOLD, 15));
        lbl4.setHorizontalAlignment(JLabel.CENTER);
        lbl4.setForeground(Color.BLACK);
        lbl4.setBounds(416, 284, 200, 40);
        viewReceiptPnl.add(lbl4);
        
     
        JLabel lbl5 = new JLabel();
        lbl5.setText("Date of transaction: ");
        lbl5.setFont(new Font("Source Sans Pro", Font.BOLD, 20));
        lbl5.setHorizontalAlignment(JLabel.LEFT);
        lbl5.setForeground(Color.BLACK);
        lbl5.setBounds(275, 225, 200, 40);
        
        
        
        
        
        JLabel cancelBtn = new JLabel();
        cancelBtn.setIcon(new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\cancelButton.png"));
        cancelBtn.setBounds(15, 35, 55, 55);
        viewReceiptPnl.add(cancelBtn);
        
        addVolumeEffects(viewReceiptPnl);
        
        JLabel viewReceiptBG = new JLabel();
        viewReceiptBG.setIcon(
                new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\viewReceiptBG.png"));
        viewReceiptBG.setBounds(0, -15, 1050, 700);
        viewReceiptPnl.add(viewReceiptBG);
        
        
        /* Button functions start here... */
        
        // For cancel button to return to log in frame
        cancelBtn.addMouseListener(new MouseListener() {
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

                cancelBtn.setIcon(new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\cancelButton.png"));
                int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want to return to log in page?", "Finish Transaction", JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {

                    // Update volume icon
                    if (sounds.isUnmute) {
                        logIn.logInVolume.setIcon(
                                new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\unmute.png"));

                    } else {
                        logIn.logInVolume.setIcon(
                                new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\mute.png"));
                    }

                    dispose();
                    FinalProject_ATM.logInFrame.show();

                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                cancelBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                cancelBtn.setIcon(
                        new ImageIcon(
                                "C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\cancelButton2.png"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                cancelBtn.setCursor(Cursor.getDefaultCursor());
                cancelBtn.setIcon(
                        new ImageIcon(
                                "C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\cancelButton.png"));
            }
        });
    }
    
    
    // Add mute features
    private static void addVolumeEffects(JPanel panel) {
        viewReceiptVolume.setIcon(
                new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\unmute.png"));
        viewReceiptVolume.setBounds(980, 620, 40, 40);
        panel.add(viewReceiptVolume);

        viewReceiptVolume.addMouseListener(new MouseListener() {
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
                if (sounds.isUnmute) {
                    viewReceiptVolume.setIcon(
                            new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\mute.png"));

                    sounds.isUnmute = false;

                } else {
                    viewReceiptVolume.setIcon(
                            new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\unmute.png"));
                    sounds.isUnmute = true;
                    sfx.playWarning();
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                viewReceiptVolume.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                viewReceiptVolume.setCursor(Cursor.getDefaultCursor());
            }
        });
    }
    
    public static void main (String[]args){
        viewReceipt a = new viewReceipt();
        a.show();
    }
}
