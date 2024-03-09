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

public class typeAmount3 extends frames {
    
    // Global variables
    static JPanel typeAmount3Pnl = new JPanel();
    static JLabel lbl1 = new JLabel();
    final static roundTextField amountField3 = new roundTextField(20, 0.7f);
    final static roundTextField customerField = new roundTextField(20, 0.7f);
    static JPasswordField pinField3 = new JPasswordField();
    static sounds sfx = new sounds();
    static JLabel typeAmount3Volume = new JLabel();
    static double amountToTransact = 0;
    static double generalBalance = 0;
    static String dateOfTransaction = "";
    static String refNo = "";
    static boolean isValidAmount = false;
    static boolean isValidCustomer = false;
    static JLabel lbl2b = new JLabel(" - Please enter 10 digit number - ");
    static JLabel lbl3b = new JLabel(" - Paying Maynilad Bills - ");
    public static String rCensoredCustomer = "";
    
    // Generate and redesign the typeAmount3 frame for supported banks
    typeAmount3() {
        super();

        typeAmount3Pnl.setSize(1244, 700);
        typeAmount3Pnl.setBackground(Color.BLACK);
        typeAmount3Pnl.setLayout(null);
        this.add(typeAmount3Pnl);

        lbl1.setText("Pay Bills with your Savings");
        lbl1.setFont(new Font("Source Sans Pro", Font.ITALIC + Font.BOLD, 30));
        lbl1.setHorizontalAlignment(JLabel.CENTER);
        lbl1.setForeground(new Color(255, 222, 89));
        lbl1.setBounds(530, 40, 450, 40);
        typeAmount3Pnl.add(lbl1);

        JLabel lbl2 = new JLabel("Enter Customer Account Number");
        lbl2.setFont(new Font("Source Sans Pro", Font.BOLD, 21));
        lbl2.setHorizontalAlignment(JLabel.CENTER);
        lbl2.setVerticalAlignment(JLabel.CENTER);
        lbl2.setForeground(new Color(255, 222, 89));
        lbl2.setBounds(560, 145, 400, 50);
        typeAmount3Pnl.add(lbl2);
        
        // Display message for customer field
        lbl2b.setFont(new Font("Source Sans Pro", Font.PLAIN, 14));
        lbl2b.setHorizontalAlignment(JLabel.CENTER);
        lbl2b.setVerticalAlignment(JLabel.CENTER);
        lbl2b.setForeground(new Color(255, 222, 89));
        lbl2b.setBounds(560, 170, 400, 50);
        typeAmount3Pnl.add(lbl2b);
        
         // Display the text field to enter account
        customerField.setBounds(560, 210, 400, 60);
        customerField.setFont(new Font("Source Sans Pro", Font.BOLD, 30));
        customerField.setHorizontalAlignment(JTextField.CENTER);
        typeAmount3Pnl.add(customerField);
        
        JLabel lbl3 = new JLabel("Enter Amount to Pay");
        lbl3.setFont(new Font("Source Sans Pro", Font.BOLD, 21));
        lbl3.setHorizontalAlignment(JLabel.CENTER);
        lbl3.setVerticalAlignment(JLabel.CENTER);
        lbl3.setForeground(new Color(255, 222, 89));
        lbl3.setBounds(560, 310, 400, 50);
        typeAmount3Pnl.add(lbl3);
        
        // Display message for amount field
        lbl3b.setFont(new Font("Source Sans Pro", Font.PLAIN, 14));
        lbl3b.setHorizontalAlignment(JLabel.CENTER);
        lbl3b.setVerticalAlignment(JLabel.CENTER);
        lbl3b.setForeground(new Color(255, 222, 89));
        lbl3b.setBounds(560, 335, 400, 50);
        typeAmount3Pnl.add(lbl3b);
        
        // Display the text field to enter amount
        amountField3.setBounds(560, 375, 400, 60);
        amountField3.setFont(new Font("Source Sans Pro", Font.BOLD, 30));
        amountField3.setHorizontalAlignment(JTextField.CENTER);
        typeAmount3Pnl.add(amountField3);
        
        final JButton clearBtn = new roundButton("Clear", new Color(255, 217, 61), new Color(244, 124, 51), new Color(255, 217, 61), new Color(244, 124, 51));
        clearBtn.setBounds(555, 485, 115, 50);
        clearBtn.setFont(new Font("Source Sans Pro", Font.ITALIC + Font.BOLD, 25));
        clearBtn.setForeground(Color.WHITE);
        clearBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        typeAmount3Pnl.add(clearBtn);
        
        final JButton enterBtn = new roundButton("Enter", new Color(73, 223, 12), new Color(51, 168, 22), new Color(73, 223, 12), new Color(51, 168, 22));
        enterBtn.setBounds(705, 485, 115, 50);
        enterBtn.setFont(new Font("Source Sans Pro", Font.ITALIC + Font.BOLD, 25));
        enterBtn.setForeground(Color.WHITE);
        enterBtn.setEnabled(false);
        enterBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        typeAmount3Pnl.add(enterBtn);

        final JButton backBtn = new roundButton("Back", new Color(48, 47, 178), new Color(32, 31, 171), new Color(48, 47, 178), new Color(32, 31, 171));
        backBtn.setBounds(855, 485, 115, 50);
        backBtn.setFont(new Font("Source Sans Pro", Font.ITALIC + Font.BOLD, 25));
        backBtn.setForeground(Color.WHITE);
        typeAmount3Pnl.add(backBtn);
        
        addVolumeEffects(typeAmount3Pnl);

        JLabel cancelBtn = new JLabel();
        cancelBtn.setIcon(new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\cancelButton.png"));
        cancelBtn.setBounds(15, 35, 55, 55);
        typeAmount3Pnl.add(cancelBtn);

        JLabel typeAmount3BG = new JLabel();
        typeAmount3BG.setIcon(
                new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\typeAmount3BG.png"));
        typeAmount3BG.setBounds(0, -15, 1050, 700);
        typeAmount3Pnl.add(typeAmount3BG);
        
        /* Listeners starts here... */
        // For customer field and type 10 numbers only
        customerField.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent a) {
                String value = customerField.getText();
                int l = value.length();

                if (l >= 10 && (a.getKeyChar() != KeyEvent.VK_BACK_SPACE && a.getKeyChar() != KeyEvent.VK_ENTER)) {
                    sfx.playError();
                    customerField.setEditable(false);
                    JOptionPane.showMessageDialog(null, "10 characters only!", "Invalid Account Number", JOptionPane.ERROR_MESSAGE);
                    customerField.setText("");
                    customerField.requestFocus();
                }
                if (a.getKeyChar() >= '0' && a.getKeyChar() <= '9' || (a.getKeyChar() == KeyEvent.VK_BACK_SPACE)) {
                    sfx.playClick();
                    customerField.setEditable(true);
                    customerField.setForeground(Color.WHITE);
                } else {
                    customerField.setEditable(false);
                }

            }
        });
        
        // Only take numbers
        amountField3.addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
                    sfx.playClick();
                    if (amountField3.getText().equals("0.")) {
                        amountField3.setText("");
                    }

                    amountField3.setCaretPosition(amountField3.getText().length());
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // Not needed for this implementation
            }

            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();

                if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE || c == '.')) {
                    e.consume();
                    return;
                } else {
                    sfx.playClick();
                    amountField3.setCaretPosition(amountField3.getText().length());
                    if (c == '0' && amountField3.getText().isEmpty()) {
                        e.consume();
                        amountField3.setText("0.");
                    }
                }

                if (c == '.' && amountField3.getText().contains(".")) {
                    e.consume();
                    return;
                } else if (c == '.' && amountField3.getText().isEmpty()) {
                    sfx.playClick();
                    amountField3.setCaretPosition(amountField3.getText().length());
                    amountField3.setText("0.");
                    e.consume();
                } else {
                    sfx.playClick();
                    amountField3.setCaretPosition(amountField3.getText().length());
                }

                // allow only 2 digits after decimal
                String text = amountField3.getText();
                int dotIndex = text.indexOf('.');
                if (dotIndex != -1 && text.substring(dotIndex).length() > 2) {
                    e.consume();
                    return;
                }
            }
        });
        
        pinField3.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent a) {
                String value = pinField3.getText();
                int l = value.length();

                if (l >= 6 && (a.getKeyChar() != KeyEvent.VK_BACK_SPACE && a.getKeyChar() != KeyEvent.VK_ENTER)) {
                    sfx.playError();
                    pinField3.setEditable(false);
                    JOptionPane.showMessageDialog(null, "6 characters only!", "Invalid PIN", JOptionPane.ERROR_MESSAGE);
                    pinField3.setText("");
                    pinField3.requestFocus();
                }
                if (a.getKeyChar() >= '0' && a.getKeyChar() <= '9' || (a.getKeyChar() == KeyEvent.VK_BACK_SPACE)) {
                    sfx.playClick();
                    pinField3.setEditable(true);
                } else {
                    pinField3.setEditable(false);
                }

            }
        });
        
        // For text field to enable/disable the enter button
        amountField3.getDocument().addDocumentListener(new DocumentListener() {
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
                            amountToTransact = Double.parseDouble(amountField3.getText().trim());

                            if (amountToTransact > 999999999.99) {
                                isValidAmount = false;
                                sfx.playError();
                                JOptionPane.showMessageDialog(null, "Amount exceeds limit!", "Invalid Amount", JOptionPane.ERROR_MESSAGE);
                                amountField3.setText("");
                                amountField3.requestFocus();
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
                        
                        
                        enterBtn.setEnabled(isValidAmount && isValidCustomer);
                    }
                });
            }
        });
        
        // For text field to enable/disable the enter button
        customerField.getDocument().addDocumentListener(new DocumentListener() {
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
                        isValidCustomer = customerField.getText().length() == 10 && customerField.getText().matches("\\d+");
                        
                        // Unshow message if valid recipient
                        if(isValidCustomer){
                            lbl2b.setText("");
                            lbl2.setBounds(560, 160, 400, 50);
                        } else {
                            lbl2b.setText(" - Please enter 10 digit number - ");
                            lbl2.setBounds(560, 145, 400, 50);
                        }
                        enterBtn.setEnabled(isValidAmount && isValidCustomer);
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

                amountField3.setText("");
                customerField.setText("");
                customerField.requestFocus();

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
                    amountToTransact = Double.parseDouble(amountField3.getText());

                    pinField3.setText("");

                    // Pay bills if sufficient current or savings balance
                    if (transaction.transactionType.equals("Pay Bills") && typeAccount.accountType.equals("Current")) {
                        if (amountToTransact <= account.user.getCurrent()) {
                            sfx.playClick();

                            checkPIN1();

                        } else {
                            sfx.playError();
                            JOptionPane.showMessageDialog(null, "You do not have enough balance!", "Insufficient balance!",
                                    JOptionPane.ERROR_MESSAGE);

                            JOptionPane.showMessageDialog(null, "Current balance: ₱" + format.format(account.user.getCurrent()), "Available balance",
                                    JOptionPane.INFORMATION_MESSAGE);

                            amountField3.setText("");
                            amountField3.requestFocus();
                        }

                    } else if (transaction.transactionType.equals("Pay Bills") && typeAccount.accountType.equals("Savings")) {
                        if (amountToTransact <= account.user.getSavings()) {
                            sfx.playClick();

                            
                            checkPIN2();

                        } else {
                            sfx.playError();
                            JOptionPane.showMessageDialog(null, "You do not have enough balance!", "Insufficient balance!",
                                    JOptionPane.ERROR_MESSAGE);
                            JOptionPane.showMessageDialog(null, "Savings balance: ₱" + format.format(account.user.getSavings()), "Available balance",
                                    JOptionPane.INFORMATION_MESSAGE);

                            amountField3.setText("");
                            amountField3.requestFocus();
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
        typeAmount3Volume.setIcon(
                new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\unmute.png"));
        typeAmount3Volume.setBounds(980, 620, 40, 40);
        panel.add(typeAmount3Volume);

        typeAmount3Volume.addMouseListener(new MouseListener() {
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
                    typeAmount3Volume.setIcon(
                            new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\mute.png"));

                    sounds.isUnmute = false;

                } else {
                    typeAmount3Volume.setIcon(
                            new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\unmute.png"));
                    sounds.isUnmute = true;
                    sfx.playWarning();
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                typeAmount3Volume.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                typeAmount3Volume.setCursor(Cursor.getDefaultCursor());
            }
        });
    }
    
    // Pay bills with current
    private static void checkPIN1() {
        int option = JOptionPane.showConfirmDialog(null, pinField3, "Enter PIN to proceed",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (option == JOptionPane.OK_OPTION) {
            if (pinField3.getText().equals(account.user.getPIN())) {
                // Computation
                account.user.setCurrent(account.user.getCurrent() - amountToTransact);

                // Show Process and ask for recceipt
                typeAccount.typeAmount3Frame.dispose();
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

                typeAccount.typeAmount3Frame.dispose();
                FinalProject_ATM.logInFrame.show();

            }
        } else {
            amountField3.requestFocus();
        }
    }
    
    // Pay bills with savings
    private static void checkPIN2() {
        int option = JOptionPane.showConfirmDialog(null, pinField3, "Enter PIN to proceed",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (option == JOptionPane.OK_OPTION) {
            if (pinField3.getText().equals(account.user.getPIN())) {
                // Computation
                account.user.setSavings(account.user.getSavings() - amountToTransact);

                // Show Process and ask for recceipt
                typeAccount.typeAmount3Frame.dispose();
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

                typeAccount.typeAmount3Frame.dispose();
                FinalProject_ATM.logInFrame.show();

            }
        } else {
            amountField3.requestFocus();
        }
    }
    
    private static void askReceipt() {
        typeAccount.typeAmount3Frame.show();
        sfx.playConfirm();

        LocalDateTime now = LocalDateTime.now();
        dateOfTransaction = dtf.format(now);

        refNo = generateRefNo();
        
        String str1 = customerField.getText().substring(0,6);
        String str2 = customerField.getText().substring(6);
        String maskedStr1 = String.join("", Collections.nCopies(str1.length(), "*"));
        rCensoredCustomer = maskedStr1 + str2;
        
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

        // lbl15 and lbl 16 to add payment
        viewReceipt.lbl15.setText("Payment to : ");
        viewReceipt.lbl16.setText(typeAmount3.rCensoredCustomer + " via " + transactBills.serviceName);

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
            typeAccount.typeAmount3Frame.dispose();
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

            typeAccount.typeAmount3Frame.dispose();
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
    
    
    public static void main(String[]args){
    frames a = new typeAmount3();
    a.show();
    }
    
}
