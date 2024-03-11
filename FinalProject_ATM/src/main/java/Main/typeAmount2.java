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
import java.util.Collections;
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
    static JPasswordField pinField2 = new JPasswordField();
    static sounds sfx = new sounds();
    static JLabel typeAmount2Volume = new JLabel();
    static double amountToTransact = 0;
    static double generalBalance = 0;
    static String dateOfTransaction = "";
    static String refNo = "";
    static boolean isValidAmount = false;
    static boolean isValidRecipient = false;
    static JLabel lbl2b = new JLabel(" - Please enter 12 digit number - ");
    static JLabel lbl3b = new JLabel(" - Transfer any amount up to ₱50,000 - ");
    public static String rCensoredUID = "";

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
        lbl2.setBounds(560, 145, 400, 50);
        typeAmount2Pnl.add(lbl2);

        // Display message for recipient field
        lbl2b.setFont(new Font("Source Sans Pro", Font.PLAIN, 14));
        lbl2b.setHorizontalAlignment(JLabel.CENTER);
        lbl2b.setVerticalAlignment(JLabel.CENTER);
        lbl2b.setForeground(new Color(255, 222, 89));
        lbl2b.setBounds(560, 170, 400, 50);
        typeAmount2Pnl.add(lbl2b);

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

        // Display message for amount field
        lbl3b.setFont(new Font("Source Sans Pro", Font.PLAIN, 14));
        lbl3b.setHorizontalAlignment(JLabel.CENTER);
        lbl3b.setVerticalAlignment(JLabel.CENTER);
        lbl3b.setForeground(new Color(255, 222, 89));
        lbl3b.setBounds(560, 335, 400, 50);
        typeAmount2Pnl.add(lbl3b);

        // Display the text field to enter amount
        amountField2.setBounds(560, 375, 400, 60);
        amountField2.setFont(new Font("Source Sans Pro", Font.BOLD, 30));
        amountField2.setHorizontalAlignment(JTextField.CENTER);
        typeAmount2Pnl.add(amountField2);

        final JButton clearBtn = new roundButton("Clear", new Color(245, 207, 51), new Color(234, 124, 51), new Color(255, 217, 61), new Color(244, 134, 61));
        clearBtn.setBounds(555, 485, 115, 50);
        clearBtn.setFont(new Font("Source Sans Pro", Font.ITALIC + Font.BOLD, 25));
        clearBtn.setForeground(Color.WHITE);
        clearBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        typeAmount2Pnl.add(clearBtn);

        final JButton enterBtn = new roundButton("Enter", new Color(73, 223, 12), new Color(51, 168, 22), new Color(83, 233, 22), new Color(61, 178, 32));
        enterBtn.setBounds(705, 485, 115, 50);
        enterBtn.setFont(new Font("Source Sans Pro", Font.ITALIC + Font.BOLD, 25));
        enterBtn.setForeground(Color.WHITE);
        enterBtn.setEnabled(false);
        enterBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        typeAmount2Pnl.add(enterBtn);

        final JButton backBtn = new roundButton("Back", new Color(48, 47, 178), new Color(32, 31, 171), new Color(58, 57, 188), new Color(42, 41, 181));
        backBtn.setBounds(855, 485, 115, 50);
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
                if ((a.getKeyChar() >= '0' && a.getKeyChar() <= '9') || (a.getKeyChar() == KeyEvent.VK_BACK_SPACE)) {
                    if (!(a.getKeyChar() == KeyEvent.VK_BACK_SPACE && (recipientField.getText().isEmpty() || recipientField.getCaretPosition() == 0))) {
                        sfx.playClick();
                    }
                    recipientField.setEditable(true);
                    recipientField.setForeground(Color.WHITE);

                } else {
                    recipientField.setEditable(false);
                }

            }
        });

        // Only take numbers
        amountField2.addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyChar() == KeyEvent.VK_BACK_SPACE && !amountField2.getText().isEmpty()) {
                    sfx.playClick();
                    if (amountField2.getText().equals("0.")) {
                        amountField2.setText("");
                    }

                    amountField2.setCaretPosition(amountField2.getText().length());
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // Not needed for this implementation
            }

            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                String textValue = amountField2.getText();
                int dotIndex = textValue.indexOf('.');
                boolean moreThan2Dec = dotIndex != -1 && textValue.substring(dotIndex).length() > 2;

                if (!(Character.isDigit(c) || c == '.')) {
                    e.consume();
                    return;
                } else {
                    amountField2.setCaretPosition(amountField2.getText().length());
                    if (c == '0' && amountField2.getText().isEmpty()) {
                        e.consume();
                        sfx.playClick();
                        amountField2.setText("0.");
                    } else if (Character.isDigit(c)) {
                        if (!(moreThan2Dec)) {
                            sfx.playClick();
                        }
                    }
                }

                if (c == '.' && amountField2.getText().contains(".")) {
                    e.consume();
                    return;
                } else if (c == '.' && amountField2.getText().isEmpty()) {
                    sfx.playClick();
                    amountField2.setCaretPosition(amountField2.getText().length());
                    amountField2.setText("0.");
                    e.consume();
                } else if (c == '.' && !(amountField2.getText().isEmpty())) {
                    sfx.playClick();
                }

                // allow only 2 digits after decimal
                if (moreThan2Dec) {
                    e.consume();
                    return;
                }
            }
        });

        pinField2.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent a) {
                String value = pinField2.getText();
                int l = value.length();

                if (l >= 6 && (a.getKeyChar() != KeyEvent.VK_BACK_SPACE && a.getKeyChar() != KeyEvent.VK_ENTER)) {
                    sfx.playError();
                    pinField2.setEditable(false);
                    JOptionPane.showMessageDialog(null, "6 characters only!", "Invalid PIN", JOptionPane.ERROR_MESSAGE);
                    pinField2.setText("");
                    pinField2.requestFocus();
                }
                if (a.getKeyChar() >= '0' && a.getKeyChar() <= '9' || (a.getKeyChar() == KeyEvent.VK_BACK_SPACE)) {
                    if (!(a.getKeyChar() == KeyEvent.VK_BACK_SPACE && (pinField2.getText().isEmpty() || pinField2.getCaretPosition() == 0 ))) {
                        sfx.playClick();
                    }
                    pinField2.setEditable(true);
                    pinField2.setForeground(Color.BLACK);
                } else {
                    pinField2.setEditable(false);
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

                            if (amountToTransact > 50000) {
                                isValidAmount = false;
                                sfx.playError();
                                JOptionPane.showMessageDialog(null, "Amount exceeds limit!", "Invalid Amount", JOptionPane.ERROR_MESSAGE);
                                amountField2.setText("");
                                amountField2.requestFocus();
                            } else {
                                isValidAmount = true;
                            }

                            if (amountToTransact == 0) {
                                isValidAmount = false;
                            } else {
                                isValidAmount = true;
                            }

                        } catch (NumberFormatException ex) {
                            isValidAmount = false;
                        }

                        // Unshow message if valid amount
                        if (isValidAmount) {
                            lbl3b.setText("");
                            lbl3.setBounds(560, 325, 400, 50);
                        } else {
                            lbl3b.setText(" - Please enter any amount up to ₱50,000 - ");
                            lbl3.setBounds(560, 310, 400, 50);
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

                        // Unshow message if valid recipient
                        if (isValidRecipient) {
                            lbl2b.setText("");
                            lbl2.setBounds(560, 160, 400, 50);
                        } else {
                            lbl2b.setText(" - Please enter 12 digit number - ");
                            lbl2.setBounds(560, 145, 400, 50);
                        }
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

        // For enter button
        enterBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    amountToTransact = Double.parseDouble(amountField2.getText());

                    pinField2.setText("");
                    
                    sfx.playWarning();
                    /*JOptionPane.showMessageDialog(null, "You are trying to transfer ₱" + format.format(amountToTransact) + " using \nyour " + typeAccount.accountType.toLowerCase() + " account for user number \n" + recipientField.getText() + " via " + transactBank.bankName + ". Enter your PIN \nto proceed.",
                            "Transaction Details", JOptionPane.INFORMATION_MESSAGE);*/

                    // Transfer if sufficient current or savings balance
                    if (transaction.transactionType.equals("Bank Transfer") && typeAccount.accountType.equals("Current")) {
                        if (amountToTransact <= account.user.getCurrent()) {

                            checkPIN1();

                        } else {
                            sfx.playError();
                            JOptionPane.showMessageDialog(null, "You do not have enough balance!", "Insufficient balance!",
                                    JOptionPane.ERROR_MESSAGE);

                            JOptionPane.showMessageDialog(null, "Current balance: ₱" + format.format(account.user.getCurrent()), "Available balance",
                                    JOptionPane.INFORMATION_MESSAGE);

                            amountField2.setText("");
                            amountField2.requestFocus();
                        }

                    } else if (transaction.transactionType.equals("Bank Transfer") && typeAccount.accountType.equals("Savings")) {
                        if (amountToTransact <= account.user.getSavings()) {

                            checkPIN2();

                        } else {
                            sfx.playError();
                            JOptionPane.showMessageDialog(null, "You do not have enough balance!", "Insufficient balance!",
                                    JOptionPane.ERROR_MESSAGE);
                            JOptionPane.showMessageDialog(null, "Savings balance: ₱" + format.format(account.user.getSavings()), "Available balance",
                                    JOptionPane.INFORMATION_MESSAGE);

                            amountField2.setText("");
                            amountField2.requestFocus();
                        }
                    }

                } catch (NumberFormatException ex) {
                    // Not a valid number, disable the button
                }
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

    // Bank transfer with current
    private static void checkPIN1() {
        int option = JOptionPane.showConfirmDialog(null, pinField2, "Enter PIN to Proceed",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (option == JOptionPane.OK_OPTION) {
            if (pinField2.getText().equals(account.user.getPIN())) {
                // Computation
                account.user.setCurrent(account.user.getCurrent() - amountToTransact);

                // Show Process and ask for recceipt
                typeAccount.typeAmount2Frame.dispose();
                typeAmount.process.show();
                SwingUtilities.invokeLater(() -> {
                    typeAmount.process.fill(new Runnable() {
                        public void run() {
                            typeAmount.process.dispose();
                            askReceipt();
                        }
                    });
                });

            } else {
                sfx.playError();

                JOptionPane.showMessageDialog(null, "You entered a wrong PIN!", "Invalid PIN!",
                        JOptionPane.ERROR_MESSAGE);
                //pinField.setText("");

                JOptionPane.showMessageDialog(null, "System will return to log in page!", "",
                        JOptionPane.WARNING_MESSAGE);

                // Update volume Icon
                if (sounds.isUnmute) {
                    logIn.logInVolume.setIcon(
                            new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\unmute.png"));

                } else {
                    logIn.logInVolume.setIcon(
                            new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\mute.png"));
                }

                typeAccount.typeAmount2Frame.dispose();
                FinalProject_ATM.logInFrame.show();

            }
        } else {
            amountField2.requestFocus();
        }
    }

    // Bank transfer with savings
    private static void checkPIN2() {
        int option = JOptionPane.showConfirmDialog(null, pinField2, "Enter PIN to Proceed",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (option == JOptionPane.OK_OPTION) {
            if (pinField2.getText().equals(account.user.getPIN())) {
                // Computation
                account.user.setSavings(account.user.getSavings() - amountToTransact);

                // Show Process and ask for recceipt
                typeAccount.typeAmount2Frame.dispose();
                typeAmount.process.show();
                SwingUtilities.invokeLater(() -> {
                    typeAmount.process.fill(new Runnable() {
                        public void run() {
                            typeAmount.process.dispose();
                            askReceipt();
                        }
                    });
                });

            } else {
                sfx.playError();

                JOptionPane.showMessageDialog(null, "You entered a wrong PIN!", "Invalid PIN!",
                        JOptionPane.ERROR_MESSAGE);
                //pinField.setText("");

                JOptionPane.showMessageDialog(null, "System will return to log in page!", "",
                        JOptionPane.WARNING_MESSAGE);

                // Update volume Icon
                if (sounds.isUnmute) {
                    logIn.logInVolume.setIcon(
                            new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\unmute.png"));

                } else {
                    logIn.logInVolume.setIcon(
                            new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\mute.png"));
                }

                typeAccount.typeAmount2Frame.dispose();
                FinalProject_ATM.logInFrame.show();

            }
        } else {
            amountField2.requestFocus();
        }
    }

    private static void askReceipt() {
        typeAccount.typeAmount2Frame.show();
        sfx.playConfirm();

        LocalDateTime now = LocalDateTime.now();
        dateOfTransaction = dtf.format(now);

        refNo = generateRefNo();

        String str1 = recipientField.getText().substring(0, 8);
        String str2 = recipientField.getText().substring(8);
        String maskedStr1 = String.join("", Collections.nCopies(str1.length(), "*"));
        rCensoredUID = maskedStr1 + str2;

        // Set Jlabels for receipt
        // lbl 8 or account type
        if (typeAccount.accountType.equals("Current")) {
            viewReceipt.lbl8.setText("Current");
        } else if (typeAccount.accountType.equals("Savings")) {
            viewReceipt.lbl8.setText("Savings");
        }

        // lbl 10 or transaction type
        viewReceipt.lbl10.setText(transaction.transactionType);

        // lbl 12 or amount to transact  
        viewReceipt.lbl12.setText("- ₱" + format.format(amountToTransact));

        // lbl14 or general balance 
        if (typeAccount.accountType.equals("Current")) {
            viewReceipt.lbl14.setText("₱" + format.format(account.user.getCurrent()));
            generalBalance = account.user.getCurrent();
        } else if (typeAccount.accountType.equals("Savings")) {
            viewReceipt.lbl14.setText("₱" + format.format(account.user.getSavings()));
            generalBalance = account.user.getSavings();
        }

        // lbl15 and lbl 16 to add recipient
        viewReceipt.lbl15.setText("Sent to : ");
        viewReceipt.lbl16.setText(rCensoredUID + " via " + transactBank.bankName);

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
            typeAccount.typeAmount2Frame.dispose();
            typeAmount.viewReceiptFrame.show();

            // Timer
            Timer timer = new Timer(5000, e -> {
                sfx.playWarning();
                int choice2 = JOptionPane.showConfirmDialog(null, "Do you want to get a copy of receipt?",
                        "Print Receipt?", JOptionPane.YES_NO_OPTION);

                if (choice2 == JOptionPane.YES_OPTION) {

                    // Print receipt
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

                    typeAmount.viewReceiptFrame.dispose();
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

                    typeAmount.viewReceiptFrame.dispose();
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

            typeAccount.typeAmount2Frame.dispose();
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

}
