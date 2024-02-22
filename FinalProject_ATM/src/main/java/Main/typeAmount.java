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

    // Global variables 
    static JPanel typeAmountPnl = new JPanel();
    final static roundTextField amountField = new roundTextField(20);
    static sounds sfx = new sounds();
    static JLabel typeAmountVolume = new JLabel();
    static JLabel lbl1 = new JLabel();

    
    // Generate and redesign the input amount frame
    typeAmount() {
        super();

        typeAmountPnl.setSize(1244, 700);
        typeAmountPnl.setBackground(Color.BLACK);
        typeAmountPnl.setLayout(null);
        this.add(typeAmountPnl);

        lbl1.setText("Withdraw from Savings");
        lbl1.setFont(new Font("Source Sans Pro", Font.ITALIC + Font.BOLD, 30));
        lbl1.setHorizontalAlignment(JLabel.CENTER);
        lbl1.setForeground(new Color(255, 222, 89));
        lbl1.setBounds(450, 40, 450, 40);
        typeAmountPnl.add(lbl1);
        
        JLabel lbl2 = new JLabel("Enter amount");
        lbl2.setFont(new Font("Source Sans Pro", Font.ITALIC + Font.BOLD, 21));
        lbl2.setHorizontalAlignment(JLabel.CENTER);
        lbl2.setForeground(new Color(255, 222, 89));
        lbl2.setBounds(515, 160, 400, 40);
        typeAmountPnl.add(lbl2);
        
        // Display the text field to enter amount
        amountField.setBounds(515, 200, 400, 70);
        amountField.setFont(new Font("Source Sans Pro", Font.BOLD, 25));
        amountField.setHorizontalAlignment(JTextField.CENTER);
        amountField.setForeground(Color.BLACK);
        typeAmountPnl.add(amountField);

        JLabel cancelBtn = new JLabel();
        cancelBtn.setIcon(new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\cancelButton.png"));
        cancelBtn.setBounds(15, 35, 55, 55);
        typeAmountPnl.add(cancelBtn);

        addVolumeEffects(typeAmountPnl);

        JLabel amountBG = new JLabel();
        amountBG.setIcon(
                new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\typeAmountBG.png"));
        amountBG.setBounds(0, -15, 1050, 700);
        typeAmountPnl.add(amountBG);

        
        // Listeners start here... 
        
        // For amount field to type amount
        amountField.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent a) {
                
                if (a.getKeyChar() >= '0' && a.getKeyChar() <= '9' || a.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
                    sfx.playClick();
                    amountField.setEditable(true);
                    

                } else {
                    amountField.setEditable(false);
                }
            }
        });

        
        // Buttons Functions
        
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
                int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want to cancel transaction?", "Cancel Transaction", JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {

                    dispose();

                    // Update volume icon
                    if (sounds.isUnmute) {
                        logIn.logInVolume.setIcon(
                                new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\unmute.png"));

                    } else {
                        logIn.logInVolume.setIcon(
                                new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\mute.png"));
                    }

                    FinalProject_ATM.logInFrame.show();
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                cancelBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                cancelBtn.setIcon(new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\cancelButton2.png"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                cancelBtn.setCursor(Cursor.getDefaultCursor());
                cancelBtn.setIcon(new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\cancelButton.png"));
            }
        });
    }

    
    // Add mute features
    private static void addVolumeEffects(JPanel panel) {
        typeAmountVolume.setIcon(
                new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\unmute.png"));
        typeAmountVolume.setBounds(980, 620, 40, 40);
        panel.add(typeAmountVolume);

        typeAmountVolume.addMouseListener(new MouseListener() {
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
                    typeAmountVolume.setIcon(
                            new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\mute.png"));

                    sounds.isUnmute = false;

                } else {
                    typeAmountVolume.setIcon(
                            new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\unmute.png"));
                    sounds.isUnmute = true;
                    sfx.playWarning();
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                typeAmountVolume.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                typeAmountVolume.setCursor(Cursor.getDefaultCursor());
            }
        });

    }

    public static void main(String[] args) {
        typeAmount a = new typeAmount();
        a.show();
    }
}
