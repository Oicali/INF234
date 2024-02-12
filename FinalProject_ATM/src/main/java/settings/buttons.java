/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package settings;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Main.account;

public class buttons extends JButton {

    // Instatiate class to allow this class to call other methods
    static sounds sfx = new sounds();
    static boolean isUnmute = true;

    // Cancel button
    public static void addCancelButton(JPanel panel) {
        JLabel cancel_Button = new JLabel();
        cancel_Button.setIcon(
                new ImageIcon(
                        "C:\\Users\\jairus\\Documents\\GitHub\\ATM\\BIT_ATM\\src\\ATM_resources\\cancelButton.png"));
        cancel_Button.setBounds(18, 619, 156, 37);
        panel.add(cancel_Button);

        cancel_Button.addMouseListener(new MouseListener() {
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

                int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want to cancel transaction?",
                        "Exit Confirmation", JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                cancel_Button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                cancel_Button.setIcon(
                        new ImageIcon(
                                "C:\\Users\\jairus\\Documents\\GitHub\\ATM\\BIT_ATM\\src\\ATM_resources\\cancelButton2.png"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                cancel_Button.setCursor(Cursor.getDefaultCursor());
                cancel_Button.setIcon(
                        new ImageIcon(
                                "C:\\Users\\jairus\\Documents\\GitHub\\ATM\\BIT_ATM\\src\\ATM_resources\\cancelButton.png"));
            }
        });
    }

    
    // Volume Button
    public static void addVolumeButton(JPanel panel) {
        
        JLabel volumeButton = new JLabel();

        if (isUnmute) {
            volumeButton.setIcon(
                    new ImageIcon(
                            "C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\unmute.png"));

        } else {
            volumeButton.setIcon(
                    new ImageIcon(
                            "C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\mute.png"));
        }

        volumeButton.setBounds(975, 619, 40, 37);
        panel.add(volumeButton);
      

        volumeButton.addMouseListener(new MouseListener() {
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
                if (isUnmute) {
                    volumeButton.setIcon(
                            new ImageIcon(
                                    "C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\mute.png"));
                    isUnmute = false;
                    
                } else {
                    volumeButton.setIcon(
                    new ImageIcon(
                            "C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\unmute.png"));

                    isUnmute = true;
                    sfx.playWarning();
                }

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                volumeButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                volumeButton.setCursor(Cursor.getDefaultCursor());
            }
        });
    }
    
    
    

    

}



