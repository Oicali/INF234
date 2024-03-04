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

public class typeAmount extends frames {

    // Global variables 
    static JPanel typeAmountPnl = new JPanel();
    final static roundTextField amountField = new roundTextField(20, 0.7f);
    static JPasswordField pinField = new JPasswordField();
    static sounds sfx = new sounds();
    static JLabel typeAmountVolume = new JLabel();
    static JLabel lbl1 = new JLabel();
    static double amountToTransact = 0;
    static double generalBalance = 0;
    static splashScreen process = new splashScreen();
    static String dateOfTransaction = "";
    static String refNo = "";
    static viewReceipt viewReceiptFrame = new viewReceipt();

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
        lbl1.setBounds(485, 40, 450, 40);
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
        amountField.setBounds(480, 200, 475, 60);
        amountField.setFont(new Font("Source Sans Pro", Font.BOLD, 30));
        amountField.setHorizontalAlignment(JTextField.CENTER);
        typeAmountPnl.add(amountField);

        JLabel lbl3 = new JLabel("Enter amount from ₱100 up to ₱50,000");
        lbl3.setFont(new Font("Source Sans Pro", Font.ITALIC, 17));
        lbl3.setHorizontalAlignment(JLabel.CENTER);
        lbl3.setForeground(new Color(255, 222, 89));
        lbl3.setBounds(475, 255, 475, 60);
        typeAmountPnl.add(lbl3);

        final JButton fiveHBtn = new roundButton("₱500", new Color(5, 38, 59), new Color(5, 38, 59));
        fiveHBtn.setBounds(508, 325, 125, 50);
        fiveHBtn.setFont(new Font("Source Sans Pro", Font.BOLD, 20));
        fiveHBtn.setForeground(Color.WHITE);
        fiveHBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        typeAmountPnl.add(fiveHBtn);

        final JButton oneKBtn = new roundButton("₱1,000", new Color(5, 38, 59), new Color(5, 38, 59));
        oneKBtn.setBounds(658, 325, 125, 50);
        oneKBtn.setFont(new Font("Source Sans Pro", Font.BOLD, 20));
        oneKBtn.setForeground(Color.WHITE);
        oneKBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        typeAmountPnl.add(oneKBtn);

        final JButton twoKBtn = new roundButton("₱2,000", new Color(5, 38, 59), new Color(5, 38, 59));
        twoKBtn.setBounds(808, 325, 125, 50);
        twoKBtn.setFont(new Font("Source Sans Pro", Font.BOLD, 20));
        twoKBtn.setForeground(Color.WHITE);
        twoKBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        typeAmountPnl.add(twoKBtn);

        final JButton fiveKBtn = new roundButton("₱5,000", new Color(5, 38, 59), new Color(5, 38, 59));
        fiveKBtn.setBounds(508, 410, 125, 50);
        fiveKBtn.setFont(new Font("Source Sans Pro", Font.BOLD, 20));
        fiveKBtn.setForeground(Color.WHITE);
        fiveKBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        typeAmountPnl.add(fiveKBtn);

        final JButton eightKBtn = new roundButton("₱8,000", new Color(5, 38, 59), new Color(5, 38, 59));
        eightKBtn.setBounds(658, 410, 125, 50);
        eightKBtn.setFont(new Font("Source Sans Pro", Font.BOLD, 20));
        eightKBtn.setForeground(Color.WHITE);
        eightKBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        typeAmountPnl.add(eightKBtn);

        final JButton tenKBtn = new roundButton("₱10,000", new Color(5, 38, 59), new Color(5, 38, 59));
        tenKBtn.setBounds(808, 410, 125, 50);
        tenKBtn.setFont(new Font("Source Sans Pro", Font.BOLD, 20));
        tenKBtn.setForeground(Color.WHITE);
        tenKBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        typeAmountPnl.add(tenKBtn);

        final JButton enterBtn = new roundButton("Enter", new Color(73, 223, 12), new Color(51, 168, 22));
        enterBtn.setBounds(658, 490, 125, 50);
        enterBtn.setFont(new Font("Source Sans Pro", Font.ITALIC + Font.BOLD, 25));
        enterBtn.setForeground(Color.WHITE);
        enterBtn.setEnabled(false);
        enterBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        typeAmountPnl.add(enterBtn);

        final JButton clearBtn = new roundButton("Clear", new Color(255, 217, 61), new Color(244, 124, 51));
        clearBtn.setBounds(508, 490, 125, 50);
        clearBtn.setFont(new Font("Source Sans Pro", Font.ITALIC + Font.BOLD, 25));
        clearBtn.setForeground(Color.WHITE);
        clearBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        typeAmountPnl.add(clearBtn);

        JLabel cancelBtn = new JLabel();
        cancelBtn.setIcon(new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\cancelButton.png"));
        cancelBtn.setBounds(15, 35, 55, 55);
        typeAmountPnl.add(cancelBtn);

        //JLabel backBtn = new JLabel();
        //backBtn.setIcon(new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\backBtn.png"));
        final JButton backBtn = new roundButton("Back",  new Color(53,51,205),  new Color(5, 38, 59));
        backBtn.setBounds(808, 488, 125, 50);
        backBtn.setFont(new Font("Source Sans Pro", Font.ITALIC + Font.BOLD, 25));
        backBtn.setForeground(Color.WHITE);
        typeAmountPnl.add(backBtn);

        addVolumeEffects(typeAmountPnl);

        JLabel typeAmountBG = new JLabel();
        typeAmountBG.setIcon(
                new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\typeAmountBG.png"));
        typeAmountBG.setBounds(0, -15, 1050, 700);
        typeAmountPnl.add(typeAmountBG);

        /* Listeners start here... */
        // For amount field to type amount
        amountField.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent a) {
                if (a.getKeyChar() >= '1' && a.getKeyChar() <= '9' || a.getKeyChar() == KeyEvent.VK_BACK_SPACE) {

                    sfx.playClick();
                    amountField.setEditable(true);

                } else {
                    amountField.setEditable(false);
                }

                if (a.getKeyChar() == '0') {
                    if (!amountField.getText().isEmpty()) {
                        sfx.playClick();
                        amountField.setEditable(true);
                    }
                    amountField.setCaretPosition(amountField.getText().length());
                }
            }
        });

        // For text field to enable/disable the enter button
        amountField.getDocument().addDocumentListener(new DocumentListener() {
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
                        String amountText = amountField.getText().trim();
                        try {
                            amountToTransact = Double.parseDouble(amountText);

                            if ((amountToTransact >= 100 && amountToTransact < 50001) && amountToTransact % 100 == 0) {
                                enterBtn.setEnabled(true);
                            } else {
                                enterBtn.setEnabled(false);
                            }

                            if (amountToTransact > 99999) {
                                sfx.playError();
                                JOptionPane.showMessageDialog(null, "5 Digits only!", "Invalid Amount", JOptionPane.ERROR_MESSAGE);
                                amountField.setText("");
                                amountField.requestFocus();
                            } else if (amountToTransact == 0) {
                                amountField.setText("");
                                amountField.requestFocus();
                            }
                        } catch (NumberFormatException ex) {
                            // Not a valid number, disable the button
                            enterBtn.setEnabled(false);
                        }
                    }
                });

            }
        });

        /* Buttons Functions */
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

        // For enter button
        enterBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    amountToTransact = Double.parseDouble(amountField.getText());

                    // Withdraw if sufficient current or savings balance
                    if (transaction.transactionType.equals("Withdraw") && typeAccount.accountType.equals("Current")) {
                        if (amountToTransact <= account.user.getCurrent()) {
                            sfx.playClick();

                            // Computation
                            account.user.setCurrent(account.user.getCurrent() - amountToTransact);

                            // Show Process and ask for recceipt
                            typeAccount.typeAmountFrame.dispose();
                            process.show();
                            process.fill(new Runnable() {
                                public void run() {
                                    process.dispose();
                                    askReceipt();
                                }
                            });
                            
                            

                        } else {
                            sfx.playError();
                            JOptionPane.showMessageDialog(null, "You do not have enough balance!", "Insufficient balance!",
                                    JOptionPane.ERROR_MESSAGE);

                            JOptionPane.showMessageDialog(null, "Current balance: ₱" + format.format(account.user.getCurrent()), "Available balance",
                                    JOptionPane.INFORMATION_MESSAGE);

                            amountField.setText("");
                        }

                    } else if (transaction.transactionType.equals("Withdraw") && typeAccount.accountType.equals("Savings")) {
                        if (amountToTransact <= account.user.getSavings()) {
                            sfx.playClick();
                            
                            // Computation
                            account.user.setSavings(account.user.getSavings() - amountToTransact);

                            // Show Process and ask for recceipt
                            typeAccount.typeAmountFrame.dispose();
                            process.show();
                            process.fill(new Runnable() {
                                public void run() {
                                    process.dispose();
                                    askReceipt();
                                }
                            });

                        } else {
                            sfx.playError();
                            JOptionPane.showMessageDialog(null, "You do not have enough balance!", "Insufficient balance!",
                                    JOptionPane.ERROR_MESSAGE);
                            JOptionPane.showMessageDialog(null, "Savings balance: ₱" + format.format(account.user.getSavings()), "Available balance",
                                    JOptionPane.INFORMATION_MESSAGE);

                            amountField.setText("");
                        }
                    }

                    // Deposit to current or savings balance if less than 99,999,999,999,999.00
                    if (transaction.transactionType.equals("Deposit") && typeAccount.accountType.equals("Current")) {
                        if (amountToTransact + account.user.getCurrent() < 99999999999999.0) {
                            sfx.playClick();

                            
                            // Computation
                            account.user.setCurrent(account.user.getCurrent() + amountToTransact);

                            // Show Process and ask for recceipt
                            typeAccount.typeAmountFrame.dispose();
                            process.show();
                            process.fill(new Runnable() {
                                public void run() {
                                    process.dispose();
                                    askReceipt();
                                }
                            });

                        } else {
                            sfx.playError();
                            JOptionPane.showMessageDialog(null, "Amount exceeds balance limit!", "Error!",
                                    JOptionPane.ERROR_MESSAGE);
                            amountField.setText("");
                        }

                    } else if (transaction.transactionType.equals("Deposit") && typeAccount.accountType.equals("Savings")) {
                        if (amountToTransact + account.user.getSavings() < 99999999999999.0) {
                            sfx.playClick();
                            
                            // Computation
                            account.user.setSavings(account.user.getSavings() + amountToTransact);

                            // Show Process and ask for recceipt
                            typeAccount.typeAmountFrame.dispose();
                            process.show();
                            process.fill(new Runnable() {
                                public void run() {
                                    process.dispose();
                                    askReceipt();
                                }
                            });

                        } else {
                            sfx.playError();
                            JOptionPane.showMessageDialog(null, "Amount exceeds balance limit!", "Error!",
                                    JOptionPane.ERROR_MESSAGE);
                            amountField.setText("");
                        }
                    }

                } catch (NumberFormatException ex) {
                    // Not a valid number, disable the button
                }
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
        
        /* Listeners starts here... */
        
        /*pinField.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent a) {
                String value = pinField.getText();
                int l = value.length();
                
                if (l >= 6 && (a.getKeyChar() != KeyEvent.VK_BACK_SPACE && a.getKeyChar() != KeyEvent.VK_ENTER)) {
                    sfx.playError();
                    pinField.setEditable(false);
                    JOptionPane.showMessageDialog(null, "6 characters only!", "Invalid PIN", JOptionPane.ERROR_MESSAGE);
                    pinField.setText("");
                    pinField.requestFocus();
                }
                if (a.getKeyChar() >= '0' && a.getKeyChar() <= '9' || (a.getKeyChar() == KeyEvent.VK_BACK_SPACE)) {
                    sfx.playClick();
                    pinField.setEditable(true);
                }                 
                else {
                    pinField.setEditable(false);
                }

            }});*/
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

    public static void askReceipt() {
        typeAccount.typeAmountFrame.show();
        sfx.playConfirm();

        LocalDateTime now = LocalDateTime.now();
        dateOfTransaction = dtf.format(now);

        refNo = generateRefNo();

        // Set Jlabels for receipt
        // lbl 8 or account type
        if (typeAccount.accountType.equals("Current")) {
            viewReceipt.lbl8.setText("Current");
        } else if (typeAccount.accountType.equals("Savings")) {
            viewReceipt.lbl8.setText("Savings");
        }

        // lbl 10 or transaction type
        if (transaction.transactionType.equals("Withdraw")) {
            viewReceipt.lbl10.setText("Withdraw");
        } else if (transaction.transactionType.equals("Deposit")) {
            viewReceipt.lbl10.setText("Deposit");
        }

        // lbl 12 or amount to transact  
        if (transaction.transactionType.equals("Withdraw")) {
            viewReceipt.lbl12.setText("- ₱" + format.format(amountToTransact));
        } else if (transaction.transactionType.equals("Deposit")) {
            viewReceipt.lbl12.setText("+ ₱" + format.format(amountToTransact));
        }

        // lbl14 or general balance 
        if (typeAccount.accountType.equals("Current")) {
            viewReceipt.lbl14.setText("₱" + format.format(account.user.getCurrent()));
            generalBalance = account.user.getCurrent();
        } else if (typeAccount.accountType.equals("Savings")) {
            viewReceipt.lbl14.setText("₱" + format.format(account.user.getSavings()));
            generalBalance = account.user.getSavings();
        }

        // lbl15 and lbl 16 to remove recipient
        viewReceipt.lbl15.setText("");
        viewReceipt.lbl16.setText("");

        // lbl 18 or add reference number
        viewReceipt.lbl18.setText(refNo);

        // lbl 19 or add date and time
        viewReceipt.lbl19.setText(dateOfTransaction);

        // Set viewHistoryTransaction
        viewHistory.addTransactionPanel(transaction.transactionType, typeAccount.accountType, refNo, dateOfTransaction, amountToTransact, generalBalance);

        // Update volume icon
        if (sounds.isUnmute) {
            viewReceipt.viewReceiptVolume.setIcon(
                    new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\unmute.png"));

        } else {
            viewReceipt.viewReceiptVolume.setIcon(
                    new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\mute.png"));
        }

        int choice = JOptionPane.showConfirmDialog(null, "Do you want to print receipt?",
                "Transaction Complete!", JOptionPane.YES_NO_OPTION);

        if (choice == JOptionPane.YES_OPTION) {
            typeAccount.typeAmountFrame.dispose();
            viewReceiptFrame.show();

            // Timer
            Timer timer = new Timer(5000, e -> {
                sfx.playWarning();
                int choice2 = JOptionPane.showConfirmDialog(null, "Do you want to get a copy of receipt?",
                        "Print Receipt?", JOptionPane.YES_NO_OPTION);

                if (choice2 == JOptionPane.YES_OPTION) {

                    try {
                        printPDFReceipts.printReceipt(transaction.transactionType, typeAccount.accountType, refNo, dateOfTransaction, amountToTransact, generalBalance);
                    } catch (MalformedURLException ex) {
                        Logger.getLogger(typeAmount.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(typeAmount.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    // Update volume Icon
                    if (sounds.isUnmute) {
                        logIn.logInVolume.setIcon(
                                new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\unmute.png"));

                    } else {
                        logIn.logInVolume.setIcon(
                                new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\mute.png"));
                    }

                    viewReceiptFrame.dispose();
                    FinalProject_ATM.logInFrame.show();
                } else {
                    // Update volume Icon
                    if (sounds.isUnmute) {
                        logIn.logInVolume.setIcon(
                                new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\unmute.png"));

                    } else {
                        logIn.logInVolume.setIcon(
                                new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\mute.png"));
                    }

                    viewReceiptFrame.dispose();
                    FinalProject_ATM.logInFrame.show();
                }

            });

            // Start the timer
            timer.setRepeats(false); // Set to false to execute only once
            timer.start();

        } else {
            // Update volume Icon
            if (sounds.isUnmute) {
                logIn.logInVolume.setIcon(
                        new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\unmute.png"));

            } else {
                logIn.logInVolume.setIcon(
                        new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\mute.png"));
            }

            typeAccount.typeAmountFrame.dispose();
            FinalProject_ATM.logInFrame.show();
        }

    }

    // Method to generate Reference number
    private static String generateRefNo() {
        StringBuilder otpBuilder = new StringBuilder();
        for (int i = 0; i < 12; i++) {
            otpBuilder.append((char) ((int) (Math.random() * 10) + '0'));
        }
        return otpBuilder.toString();
    }
    
    /*private static void checkPIN(){
        int option = JOptionPane.showConfirmDialog(null, pinField, "Enter your new PIN",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (option == JOptionPane.OK_OPTION) {
            if(pinField.getText().equals(account.user.getPIN())){
                
            } else {
                sfx.playError();
                
                 JOptionPane.showMessageDialog(null, "You entered a wrong PIN!", "Invalid PIN!",
                                    JOptionPane.ERROR_MESSAGE);
                pinField.setText("");
                pinField.requestFocus();
                checkPIN();
            }
        } else {
            amountField.setText("");
            amountField.requestFocus();
        }
    }*/

    public static void main(String[] args) {
        typeAmount a = new typeAmount();
        a.show();

    }

}
/* changed updateEnterButton */
 /* changed actionlistener for enterbutton */
