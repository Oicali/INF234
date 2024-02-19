/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import settings.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;

public class viewBalance extends frames {

    // Global variables 
    static JPanel viewBalancePnl = new JPanel();
    static sounds sfx = new sounds();
    public static JLabel viewBalanceVolume = new JLabel();
    public static JLabel lbl2 = new JLabel();
    public static JLabel lbl7 = new JLabel();
    public static double balance = 0;
    static String str1 = account.user.getUID().substring(0, 8);
    static String str2 = account.user.getUID().substring(8);
        // Replace each character with "*"
        static String maskedStr1 = String.join("", Collections.nCopies(str1.length(), "*"));
        
    static String str3 = maskedStr1 + str2; 

    // Generate and redesign the balance frame
    viewBalance() {
        super();
        JDialog.setDefaultLookAndFeelDecorated(true);

        viewBalancePnl.setSize(1244, 700);
        viewBalancePnl.setBackground(Color.BLACK);
        viewBalancePnl.setLayout(null);
        this.add(viewBalancePnl);

        JLabel lbl1 = new JLabel("Check your balance");
        lbl1.setFont(new Font("Source Sans Pro", Font.ITALIC + Font.BOLD, 30));
        lbl1.setHorizontalAlignment(JLabel.CENTER);
        lbl1.setForeground(new Color(255, 222, 89));
        lbl1.setBounds(515, 40, 400, 40);
        viewBalancePnl.add(lbl1);

        lbl2.setFont(new Font("Source Sans Pro", Font.BOLD, 25));
        lbl2.setHorizontalAlignment(JLabel.CENTER);
        lbl2.setForeground(new Color(255, 222, 89));
        lbl2.setBounds(598, 148, 115, 40);
        viewBalancePnl.add(lbl2);

        JLabel lbl3 = new JLabel("Account");
        lbl3.setFont(new Font("Source Sans Pro", Font.PLAIN, 25));
        lbl3.setHorizontalAlignment(JLabel.CENTER);
        lbl3.setForeground(Color.WHITE);
        lbl3.setBounds(733, 148, 115, 40);
        viewBalancePnl.add(lbl3);

        JLabel lbl4 = new JLabel(account.user.getName());
        lbl4.setFont(new Font("Source Sans Pro", Font.PLAIN, 25));
        lbl4.setHorizontalAlignment(JLabel.LEFT);
        lbl4.setForeground(Color.BLACK);
        lbl4.setBounds(580, 263, 340, 40);
        viewBalancePnl.add(lbl4);

        JLabel lbl5 = new JLabel(str3);
        lbl5.setFont(new Font("Source Sans Pro", Font.PLAIN, 15));
        lbl5.setHorizontalAlignment(JLabel.LEFT);
        lbl5.setForeground(Color.BLACK);
        lbl5.setBounds(580, 294, 340, 40);
        viewBalancePnl.add(lbl5);
        
        JLabel lbl6 = new JLabel("Available Balance");
        lbl6.setFont(new Font("Source Sans Pro", Font.PLAIN, 23));
        lbl6.setHorizontalAlignment(JLabel.RIGHT);
        lbl6.setForeground(Color.BLACK);
        lbl6.setBounds(585, 345, 340, 40);
        viewBalancePnl.add(lbl6);
        
        lbl7.setFont(new Font("Source Sans Pro", Font.BOLD, 35));
        lbl7.setHorizontalAlignment(JLabel.RIGHT);
        lbl7.setForeground(Color.BLACK);
        lbl7.setBounds(585, 385, 340, 40);
        viewBalancePnl.add(lbl7);
        
        JLabel lbl8 = new JLabel("PHP");
        lbl8.setFont(new Font("Source Sans Pro", Font.BOLD, 15));
        lbl8.setHorizontalAlignment(JLabel.LEFT);
        lbl8.setForeground(Color.BLACK);
        lbl8.setBounds(520, 380, 40, 40);
        viewBalancePnl.add(lbl8);

        JLabel cancelBtn = new JLabel();
        cancelBtn.setIcon(new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\cancelButton.png"));
        cancelBtn.setBounds(15, 35, 55, 55);
        viewBalancePnl.add(cancelBtn);

        addVolumeEffects(viewBalancePnl);
        
        JLabel backBtn = new JLabel();
        backBtn.setIcon(
                new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\backButton.png"));
        backBtn.setBounds(540, 500,365, 70);
        viewBalancePnl.add(backBtn);

        JLabel viewBalanceBG = new JLabel();
        viewBalanceBG.setIcon(
                new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\viewBalanceBG.png"));
        viewBalanceBG.setBounds(0, -15, 1050, 700);
        viewBalancePnl.add(viewBalanceBG);

        // Buttons Functions
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
                int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want to cancel transaction?", "Exit Confirmation", JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {

                    dispose();

                    logIn.attempt = 3;

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
        
        backBtn.addMouseListener(new MouseListener() {
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
                sfx.playClick();

                dispose();
                
                // Update volume icon
                    if(sounds.isUnmute){
                        typeAccount.typeAccountVolume.setIcon(
                            new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\unmute.png"));
                    
                    } else {
                        typeAccount.typeAccountVolume.setIcon(
                            new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\mute.png"));
                    }
                
                transaction.typeAccountFrame.show();
                
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                //Do nothing
            }

            @Override
            public void mouseExited(MouseEvent e) {
               // Do nothing
            }
        });
    }

    // Add mute features
    private static void addVolumeEffects(JPanel panel) {
        viewBalanceVolume.setIcon(
                new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\unmute.png"));
        viewBalanceVolume.setBounds(980, 620, 40, 40);
        panel.add(viewBalanceVolume);

        viewBalanceVolume.addMouseListener(new MouseListener() {
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
                    viewBalanceVolume.setIcon(
                            new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\mute.png"));

                    sounds.isUnmute = false;

                } else {
                    viewBalanceVolume.setIcon(
                            new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\unmute.png"));
                    sounds.isUnmute = true;
                    sfx.playWarning();
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                viewBalanceVolume.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

            }

            @Override
            public void mouseExited(MouseEvent e) {
                viewBalanceVolume.setCursor(Cursor.getDefaultCursor());

            }
        });

    }

    public static void main(String[] args) {
        viewBalance a = new viewBalance();
        a.show();
    }
}
