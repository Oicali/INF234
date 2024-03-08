/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import settings.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class typeAmount2 extends frames {

    // Global variables
    static JPanel typeAmount2Pnl = new JPanel();
    static JLabel lbl1 = new JLabel();
    final static roundTextField amountField2 = new roundTextField(20, 0.7f);
    final static roundTextField recipientField = new roundTextField(20, 0.7f);
    static JPasswordField pinField = new JPasswordField();
    static sounds sfx = new sounds();
    static JLabel typeAmount2Volume = new JLabel();
    static double amountToTransact = 0;
    static double generalBalance = 0;
    static String dateOfTransaction = "";
    static String refNo = "";
    static boolean isValidAmount = false;
    static boolean isValidRecipient = false;

    // Generate and redesign the typeAmount2 frame for supported banks
    typeAmount2() {
        super();

        typeAmount2Pnl.setSize(1244, 700);
        typeAmount2Pnl.setBackground(Color.BLACK);
        typeAmount2Pnl.setLayout(null);
        this.add(typeAmount2Pnl);

        lbl1.setText("Transfer with your Savings");
        lbl1.setFont(new Font("Source Sans Pro", Font.ITALIC + Font.BOLD, 30));
        lbl1.setHorizontalAlignment(JLabel.CENTER);
        lbl1.setForeground(new Color(255, 222, 89));
        lbl1.setBounds(530, 40, 450, 40);
        typeAmount2Pnl.add(lbl1);

        JLabel lbl2 = new JLabel("Enter Bank Account Number");
        lbl2.setFont(new Font("Source Sans Pro", Font.BOLD, 21));
        lbl2.setHorizontalAlignment(JLabel.CENTER);
        lbl2.setVerticalAlignment(JLabel.CENTER);
        lbl2.setForeground(new Color(255, 222, 89));
        lbl2.setBounds(560, 150, 400, 50);
        typeAmount2Pnl.add(lbl2);

        // Display the text field to enter account
        recipientField.setBounds(560, 210, 400, 60);
        recipientField.setFont(new Font("Source Sans Pro", Font.BOLD, 30));
        recipientField.setHorizontalAlignment(JTextField.CENTER);
        typeAmount2Pnl.add(recipientField);

        JLabel lbl3 = new JLabel("Enter Amount to Transfer");
        lbl3.setFont(new Font("Source Sans Pro", Font.BOLD, 21));
        lbl3.setHorizontalAlignment(JLabel.CENTER);
        lbl3.setVerticalAlignment(JLabel.CENTER);
        lbl3.setForeground(new Color(255, 222, 89));
        lbl3.setBounds(560, 310, 400, 50);
        typeAmount2Pnl.add(lbl3);

        // Display the text field to enter amount
        amountField2.setBounds(560, 370, 400, 60);
        amountField2.setFont(new Font("Source Sans Pro", Font.BOLD, 30));
        amountField2.setHorizontalAlignment(JTextField.CENTER);
        typeAmount2Pnl.add(amountField2);

        final JButton clearBtn = new roundButton("Clear", new Color(255, 217, 61), new Color(244, 124, 51), new Color(255, 217, 61), new Color(244, 124, 51));
        clearBtn.setBounds(555, 480, 115, 50);
        clearBtn.setFont(new Font("Source Sans Pro", Font.ITALIC + Font.BOLD, 25));
        clearBtn.setForeground(Color.WHITE);
        clearBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        typeAmount2Pnl.add(clearBtn);

        final JButton enterBtn = new roundButton("Enter", new Color(73, 223, 12), new Color(51, 168, 22), new Color(73, 223, 12), new Color(51, 168, 22));
        enterBtn.setBounds(705, 480, 115, 50);
        enterBtn.setFont(new Font("Source Sans Pro", Font.ITALIC + Font.BOLD, 25));
        enterBtn.setForeground(Color.WHITE);
        enterBtn.setEnabled(false);
        enterBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        typeAmount2Pnl.add(enterBtn);

        final JButton backBtn = new roundButton("Back", new Color(48, 47, 178), new Color(32, 31, 171), new Color(48, 47, 178), new Color(32, 31, 171));
        backBtn.setBounds(855, 480, 115, 50);
        backBtn.setFont(new Font("Source Sans Pro", Font.ITALIC + Font.BOLD, 25));
        backBtn.setForeground(Color.WHITE);
        typeAmount2Pnl.add(backBtn);

        addVolumeEffects(typeAmount2Pnl);

        JLabel cancelBtn = new JLabel();
        cancelBtn.setIcon(new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\cancelButton.png"));
        cancelBtn.setBounds(15, 35, 55, 55);
        typeAmount2Pnl.add(cancelBtn);

        JLabel typeAmount2BG = new JLabel();
        typeAmount2BG.setIcon(
                new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\typeAmount2BG.png"));
        typeAmount2BG.setBounds(0, -15, 1050, 700);
        typeAmount2Pnl.add(typeAmount2BG);

        /* Listeners starts here... */
        // For recipient field and type 12 numbers only
        recipientField.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent a) {
                String value = recipientField.getText();
                int l = value.length();

                if (l >= 12 && (a.getKeyChar() != KeyEvent.VK_BACK_SPACE && a.getKeyChar() != KeyEvent.VK_ENTER)) {
                    sfx.playError();
                    recipientField.setEditable(false);
                    JOptionPane.showMessageDialog(null, "12 characters only!", "Invalid Account Number", JOptionPane.ERROR_MESSAGE);
                    recipientField.setText("");
                    recipientField.requestFocus();
                }
                if (a.getKeyChar() >= '0' && a.getKeyChar() <= '9' || (a.getKeyChar() == KeyEvent.VK_BACK_SPACE)) {
                    sfx.playClick();
                    recipientField.setEditable(true);
                    recipientField.setForeground(Color.WHITE);
                } else {
                    recipientField.setEditable(false);
                }

            }
        });

        // Only take numbers
        amountField2.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent a) {
                if (a.getKeyChar() >= '1' && a.getKeyChar() <= '9' && (amountField2.getText().indexOf(".") <= 4 && amountField2.getText().length() <= 8)) {

                    sfx.playClick();
                    amountField2.setEditable(true);

                } else {
                    amountField2.setEditable(false);
                }

                // Separated from 1-9 since I want to automatically add decimal if the field is empty 
                if (a.getKeyChar() == '0') {
                    if (amountField2.getText().isEmpty()) {
                        sfx.playClick();
                        amountField2.setText("0.");
                    } else {
                        sfx.playClick();
                        amountField2.setEditable(true);
                    }
                    amountField2.setCaretPosition(amountField2.getText().length());
                }

                // Can automatically add 0 before decimal if the field is empty  
                if (a.getKeyChar() == '.') {
                    if (amountField2.getText().isEmpty()) {
                        sfx.playClick();
                        amountField2.setText("0.");
                    } else if (!amountField2.getText().contains(".")) {
                        sfx.playClick();
                        amountField2.setText(amountField2.getText() + ".");
                    }
                    amountField2.setCaretPosition(amountField2.getText().length());
                }

                
                // Automatically remove all if the field is 0. 
                if (a.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
                    sfx.playClick();
                    if (amountField2.getText().equals("0.")) {
                        amountField2.setText("");
                    } else {
                        amountField2.setEditable(true);
                    }
                    amountField2.setCaretPosition(amountField2.getText().length());
                }

            }
        });

        // For text field to enable/disable the enter button
        amountField2.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateEnterButton();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateEnterButton();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateEnterButton();
            }

            // Method to enable/disable the enter button based on the amount typed
            private void updateEnterButton() {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            amountToTransact = Double.parseDouble(amountField2.getText().trim());
                            isValidAmount = amountToTransact != 0;
                        } catch (NumberFormatException ex) {
                            isValidAmount = false;
                        }
                        enterBtn.setEnabled(isValidAmount && isValidRecipient);
                    }
                });
            }
        });

// For text field to enable/disable the enter button
        recipientField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateEnterButton();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateEnterButton();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateEnterButton();
            }

            // Method to enable/disable the enter button based on the amount typed
            private void updateEnterButton() {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        isValidRecipient = recipientField.getText().length() == 12 && recipientField.getText().matches("\\d+");
                        enterBtn.setEnabled(isValidAmount && isValidRecipient);
                    }
                });
            }
        });


        /* Buttons Functions starts here... */
        // For cancel button to end transaction
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
                int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want to end transaction?",
                        "Exit Confirmation", JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
                    System.exit(0);
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

                amountField2.setText("");
                recipientField.setText("");
                recipientField.requestFocus();

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

        // For back button to return to log in frame
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
                sfx.playWarning();

                int choice = JOptionPane.showConfirmDialog(null, "Do you want to return to log in page?", "Cancel Transaction", JOptionPane.YES_NO_OPTION);
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
                backBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                backBtn.setCursor(Cursor.getDefaultCursor());
            }
        });
    }

    // Add mute features
    private static void addVolumeEffects(JPanel panel) {
        typeAmount2Volume.setIcon(
                new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\unmute.png"));
        typeAmount2Volume.setBounds(980, 620, 40, 40);
        panel.add(typeAmount2Volume);

        typeAmount2Volume.addMouseListener(new MouseListener() {
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
                    typeAmount2Volume.setIcon(
                            new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\mute.png"));

                    sounds.isUnmute = false;

                } else {
                    typeAmount2Volume.setIcon(
                            new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\unmute.png"));
                    sounds.isUnmute = true;
                    sfx.playWarning();
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                typeAmount2Volume.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                typeAmount2Volume.setCursor(Cursor.getDefaultCursor());
            }
        });
    }

    public static void main(String[] args) {
        typeAmount2 a = new typeAmount2();
        a.show();
    }
}
