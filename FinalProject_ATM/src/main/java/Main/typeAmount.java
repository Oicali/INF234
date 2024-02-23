/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import settings.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class typeAmount extends frames {

    // Global variables 
    static JPanel typeAmountPnl = new JPanel();
    final static roundTextField amountField = new roundTextField(20);
    static sounds sfx = new sounds();
    static JLabel typeAmountVolume = new JLabel();
    static JLabel lbl1 = new JLabel();
    static double amount = 0;

    
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
        lbl1.setBounds(480, 40, 450, 40);
        typeAmountPnl.add(lbl1);
        
        JLabel lbl2 = new JLabel("Please enter or select preferred amount");
        lbl2.setFont(new Font("Source Sans Pro", Font.BOLD, 21));
        lbl2.setHorizontalAlignment(JLabel.CENTER);
        lbl2.setVerticalAlignment(JLabel.CENTER);
        lbl2.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
        lbl2.setForeground(new Color(255, 222, 89));
        lbl2.setBounds(515, 130, 400, 50);
        typeAmountPnl.add(lbl2);
        
        // Display the text field to enter amount
        amountField.setText("0.00");
        amountField.setBounds(480, 200, 475, 60);
        amountField.setFont(new Font("Source Sans Pro", Font.BOLD, 30));
        amountField.setHorizontalAlignment(JTextField.CENTER);
        amountField.setBackground(Color.WHITE);
        amountField.setForeground(Color.BLACK);
        typeAmountPnl.add(amountField);
        
        JLabel lbl3 = new JLabel("Enter amount from ₱100 up to ₱100,000");
        lbl3.setFont(new Font("Source Sans Pro", Font.ITALIC, 17));
        lbl3.setHorizontalAlignment(JLabel.CENTER);
        lbl3.setForeground(new Color(255, 222, 89));
        lbl3.setBounds(475, 255, 475, 60);
        typeAmountPnl.add(lbl3);
        
        final JButton fiveHBtn = new roundButton("₱500", new Color(5,38,59), new Color(5,38,59));
        fiveHBtn.setBounds(508, 325, 125, 50);
        fiveHBtn.setFont(new Font("Source Sans Pro", Font.BOLD, 20));
        fiveHBtn.setForeground(Color.WHITE);
        fiveHBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        typeAmountPnl.add(fiveHBtn);
        
        final JButton oneKBtn = new roundButton("₱1,000", new Color(5,38,59), new Color(5,38,59));
        oneKBtn.setBounds(658, 325, 125, 50);
        oneKBtn.setFont(new Font("Source Sans Pro", Font.BOLD, 20));
        oneKBtn.setForeground(Color.WHITE);
        oneKBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        typeAmountPnl.add(oneKBtn);
        
        final JButton twoKBtn = new roundButton("₱2,000", new Color(5,38,59), new Color(5,38,59));
        twoKBtn.setBounds(808, 325, 125, 50);
        twoKBtn.setFont(new Font("Source Sans Pro", Font.BOLD, 20));
        twoKBtn.setForeground(Color.WHITE);
        twoKBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        typeAmountPnl.add(twoKBtn);
        
        final JButton fiveKBtn = new roundButton("₱5,000", new Color(5,38,59), new Color(5,38,59));
        fiveKBtn.setBounds(508, 410, 125, 50);
        fiveKBtn.setFont(new Font("Source Sans Pro", Font.BOLD, 20));
        fiveKBtn.setForeground(Color.WHITE);
        fiveKBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        typeAmountPnl.add(fiveKBtn);
        
        final JButton eightKBtn = new roundButton("₱8,000", new Color(5,38,59), new Color(5,38,59));
        eightKBtn.setBounds(658, 410, 125, 50);
        eightKBtn.setFont(new Font("Source Sans Pro", Font.BOLD, 20));
        eightKBtn.setForeground(Color.WHITE);
        eightKBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        typeAmountPnl.add(eightKBtn);
        
        final JButton tenKBtn = new roundButton("₱10,000", new Color(5,38,59), new Color(5,38,59));
        tenKBtn.setBounds(808, 410, 125, 50);
        tenKBtn.setFont(new Font("Source Sans Pro", Font.BOLD, 20));
        tenKBtn.setForeground(Color.WHITE);
        tenKBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        typeAmountPnl.add(tenKBtn);
        
        final JButton enterBtn = new roundButton("Enter", new Color(73,223,12), new Color(51,168,22));
        enterBtn.setBounds(658, 490, 125, 50);
        enterBtn.setFont(new Font("Source Sans Pro", Font.ITALIC + Font.BOLD, 25));
        enterBtn.setForeground(Color.WHITE);
        enterBtn.setEnabled(false);
        enterBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        typeAmountPnl.add(enterBtn);
        
        final JButton clearBtn = new roundButton("Clear", new Color(255, 217, 61), new Color(244,124,51));
        clearBtn.setBounds(508, 490, 125, 50);
        clearBtn.setFont(new Font("Source Sans Pro", Font.ITALIC + Font.BOLD, 25));
        clearBtn.setForeground(Color.WHITE);
        clearBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        typeAmountPnl.add(clearBtn);

        JLabel cancelBtn = new JLabel();
        cancelBtn.setIcon(new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\cancelButton.png"));
        cancelBtn.setBounds(15, 35, 55, 55);
        typeAmountPnl.add(cancelBtn);
        
        JLabel backBtn = new JLabel();
        backBtn.setIcon(new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\backBtn.png"));
        backBtn.setBounds(812, 485, 125, 50);
        typeAmountPnl.add(backBtn);

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
        
        // Add a DocumentListener to the text field to enable/disable the enter button
        amountField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateLoginButton();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateLoginButton();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateLoginButton();
            }

            // Method to enable/disable the enter button based on the amount typed
            private void updateLoginButton() {
                String amountText = amountField.getText().trim();
        try {
            amount = Double.parseDouble(amountText);
            enterBtn.setEnabled((amount >= 100 && amount < 100001) && amount%100 == 0);
        } catch (NumberFormatException ex) {
            // Not a valid number, disable the button
            enterBtn.setEnabled(false);
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
                cancelBtn.setIcon(new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\cancelButton2.png"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                cancelBtn.setCursor(Cursor.getDefaultCursor());
                cancelBtn.setIcon(new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\cancelButton.png"));
            }
        });
        
    
        // For clear button to clear amountField
        clearBtn.addMouseListener(new MouseListener() {
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

 
                    amountField.setText("");
                    amountField.requestFocus();
                
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // Do nothing
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // Do nothing
            }
        });
        
        
        // For 500 button to input 500
        fiveHBtn.addMouseListener(new MouseListener() {
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

                amountField.setText("500");
                amount = 500;
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // Do nothing
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // Do nothing
            }
        });
        
        
        // For 1000 button to input 1000
        oneKBtn.addMouseListener(new MouseListener() {
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

                amountField.setText("1000");
                amount = 1000;
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // Do nothing
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // Do nothing
            }
        });
        
        
        // For 2000 button to input 2000
        twoKBtn.addMouseListener(new MouseListener() {
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

                amountField.setText("2000");
                amount = 2000;
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // Do nothing
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // Do nothing
            }
        });
        
        
        // For 500 button to input 500
        fiveKBtn.addMouseListener(new MouseListener() {
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

                amountField.setText("5000");
                amount = 5000;
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // Do nothing
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // Do nothing
            }
        });
        
        
        // For 8000 button to input 8000
        eightKBtn.addMouseListener(new MouseListener() {
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

                amountField.setText("8000");
                amount = 8000;
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // Do nothing
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // Do nothing
            }
        });
        
        
        // For 1000 button to input 1000
        tenKBtn.addMouseListener(new MouseListener() {
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

                amountField.setText("10000");
                amount = 10000;
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // Do nothing
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // Do nothing
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
