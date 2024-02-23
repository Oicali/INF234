/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import settings.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class logIn extends frames {

    // Global variables 
    static JPanel logInPnl = new JPanel();
    static int attempt = 3;
    static JPasswordField passwordField = new JPasswordField();
    static final JPasswordField PINStr = new roundPasswordField(20);
    static sounds sfx = new sounds();
    static transaction transactionFrame = new transaction();
    static JLabel logInVolume = new JLabel();


    // Generate and redesign the Log In frame
    public logIn() {
        super();
        
        logInPnl.setSize(1244, 700);
        logInPnl.setBackground(Color.BLACK);
        logInPnl.setLayout(null);
        this.add(logInPnl);

        JLabel lbl1 = new JLabel("Log in to your Account");
        lbl1.setFont(new Font("Source Sans Pro", Font.ITALIC + Font.BOLD, 30));
        lbl1.setHorizontalAlignment(JLabel.CENTER);
        lbl1.setForeground(new Color(255, 222, 89));
        lbl1.setBounds(555, 40, 400, 40);
        logInPnl.add(lbl1);

        JLabel logo = new JLabel();
        logo.setIcon(
                new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\logo2.png"));
        logo.setBounds(712, 135, 110, 110);
        logInPnl.add(logo);

        JLabel lbl2 = new JLabel("Enter your PIN");
        lbl2.setFont(new Font("Source Sans Pro", Font.ITALIC + Font.BOLD, 21));
        lbl2.setHorizontalAlignment(JLabel.CENTER);
        lbl2.setForeground(new Color(255, 222, 89));
        lbl2.setBounds(560, 250, 400, 40);
        logInPnl.add(lbl2);

        PINStr.setBounds(588, 295, 350, 50);
        PINStr.setFont(new Font("Source Sans Pro", Font.BOLD, 25));
        PINStr.setBorder(null);
        ((JTextField) PINStr).setHorizontalAlignment(JTextField.CENTER);
        logInPnl.add(PINStr);

        final JButton forgotPIN = new JButton("<html><i><u>Forgot PIN?</u></i></html>");
        forgotPIN.setBounds(680, 510, 160, 35);
        forgotPIN.setFont(new Font("Source Sans Pro", Font.PLAIN, 18));
        forgotPIN.setContentAreaFilled(false);
        forgotPIN.setBorderPainted(false);
        forgotPIN.setFocusPainted(false);
        forgotPIN.setOpaque(false);
        forgotPIN.setForeground(new Color(255, 222, 89));
        logInPnl.add(forgotPIN);
        
        final JButton logInBtn = new roundButton("Login", new Color(1,207,22), new Color(1,207,22));
        logInBtn.setBounds(685, 395, 150, 46);
        logInBtn.setFont(new Font("Source Sans Pro", Font.ITALIC + Font.BOLD, 25));
        logInBtn.setForeground(Color.WHITE);
        logInBtn.setEnabled(false);
        logInPnl.add(logInBtn);
        
        
        
        addVolumeEffects(logInPnl);
        
        JLabel cancelBtn = new JLabel();
        cancelBtn.setIcon(
                new ImageIcon(
                        "C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\cancelButton.png"));
        cancelBtn.setBounds(15, 34, 55, 55);
        logInPnl.add(cancelBtn);

        JLabel logInBG = new JLabel();
        logInBG.setIcon(
                new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\logIn_BG.png"));
        logInBG.setBounds(0, -15, 1050, 700);
        logInPnl.add(logInBG);

        
        // Listeners starts here...
        
        // For PIN password field
        PINStr.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent a) {
                String value = PINStr.getText();
                int l = value.length();
                if (l >= 6) {
                    sfx.playError();
                    JOptionPane.showMessageDialog(null, "6 characters only!", "Invalid PIN", JOptionPane.ERROR_MESSAGE);
                    PINStr.setText("");
                    PINStr.requestFocus();
                }
                if (a.getKeyChar() >= '0' && a.getKeyChar() <= '9' || (a.getKeyChar() == KeyEvent.VK_BACK_SPACE)) {
                    sfx.playClick();
                    PINStr.setEditable(true);
                    PINStr.setForeground(Color.BLACK);
                } else {
                    PINStr.setEditable(false);

                }

            }});

        // Add a DocumentListener to the PIN JPasswordField to enable/disable the login button
        PINStr.getDocument().addDocumentListener(new DocumentListener() {
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

            // Method to enable/disable the login button based on the PIN length
            private void updateLoginButton() {
                String pinText = PINStr.getText().trim();
                logInBtn.setEnabled(pinText.length() == 6);
            }
        });

        
        // For Log In Button
        logInBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        logInBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!PINStr.getText().equals(account.user.getPIN())) {
                    sfx.playError();

                    JOptionPane.showMessageDialog(null, "You entered a wrong PIN!", "PIN Incorrect", JOptionPane.ERROR_MESSAGE);
                    attempt--;
                    JOptionPane.showMessageDialog(null, "Attempts remaining: " + attempt, "PIN Incorrect",
                            JOptionPane.WARNING_MESSAGE);
                    PINStr.setText("");
                    PINStr.requestFocus();
                    getRootPane().setDefaultButton(logInBtn);
                    if (attempt < 1) {
                        sfx.playWarning();
                        JOptionPane.showMessageDialog(null, "You have reached your maximum attempt!", "System Security",
                                JOptionPane.WARNING_MESSAGE);
                        System.exit(0);
                    }
                } else {
                    sfx.playConfirm();

                    JOptionPane.showMessageDialog(null, "Login Successful!" ,"", JOptionPane.INFORMATION_MESSAGE);
                    attempt = 3;
                    
                    // Update volume icon
                    if(sounds.isUnmute){
                        transaction.transactionVolume.setIcon(
                            new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\unmute.png"));
                    
                    } else {
                        transaction.transactionVolume.setIcon(
                            new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\mute.png"));
                    }
                    
                    FinalProject_ATM.logInFrame.dispose();
                    PINStr.setText("");
                    transactionFrame.show();
                    

                }
            }
        });
  
        
        // For forgot password field
        forgotPIN.addMouseListener(new MouseListener() {
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

                // Generate OTP
                String otp = generateOTP();

                JLabel label = new JLabel("<html><center>You will receive a 5-number OTP. <br> Kindly remember them to change <br> your PIN.");
                label.setHorizontalAlignment(SwingConstants.CENTER);
                
                JOptionPane.showMessageDialog(null, label, "Request to change PIN", JOptionPane.INFORMATION_MESSAGE);
                JOptionPane.showMessageDialog(null, "Your OTP: " + otp, "OTP Verification", JOptionPane.INFORMATION_MESSAGE);

                // Field for inputting OTP
                JTextField otpField = new JTextField();
                otpField.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        char c = e.getKeyChar();
                        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE)) {
                            e.consume(); // Ignore the event
                        } else {
                            sfx.playClick();
                        }
                    }
                });

                Object[] otpPanel = {"Enter the OTP: ", otpField};
                int option = JOptionPane.showConfirmDialog(null, otpPanel, "OTP Verification", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

                if (option == JOptionPane.OK_OPTION) {
                    String enteredOTP = otpField.getText();
                    if (enteredOTP.equals(otp)) {
                        verifyPIN();
                    } else {
                        sfx.playError();
                        JOptionPane.showMessageDialog(null, "Invalid OTP. PIN change aborted.", "OTP Verification", JOptionPane.ERROR_MESSAGE);
                    }
                }

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                forgotPIN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

            }

            @Override
            public void mouseExited(MouseEvent e) {
                forgotPIN.setCursor(Cursor.getDefaultCursor());

            }
        });

        
        // Field to input new PIN
        passwordField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE)) {
                    e.consume(); // Ignore the event
                } else {
                    sfx.playClick();
                }
            }
        });
    
        
        // For cancel button to exit system
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
    
    }

    
    // Recursion
    public static void verifyPIN() {

        sfx.playWarning();
        int option = JOptionPane.showConfirmDialog(null, passwordField, "Enter your new PIN",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (option == JOptionPane.OK_OPTION) {
            char[] newPasswordChars = passwordField.getPassword();

            // Check if the password length is exactly 6
            if (newPasswordChars.length == 6) {
                // Check if all characters are digits
                boolean isValidPassword = true;
                for (char c : newPasswordChars) {
                    if (!Character.isDigit(c)) {
                        isValidPassword = false;
                        break;
                    }
                }

                if (isValidPassword) {
                    account.user.setPIN(new String(newPasswordChars));
                    sfx.playConfirm();
                    JOptionPane.showMessageDialog(null, "You have successfully changed your PIN!",
                            "Changed PIN", JOptionPane.INFORMATION_MESSAGE);
                    PINStr.setText("");
                    PINStr.requestFocus();
                    attempt = 3;
                    passwordField.setText("");
                }
            } else {
                // Display error message if the password length is not 6
                sfx.playError();
                JOptionPane.showMessageDialog(null, "PIN must be exactly 6 digits long!", "Invalid PIN", JOptionPane.ERROR_MESSAGE);
                passwordField.setText("");
                verifyPIN();
            }
        } else {
            PINStr.requestFocus();
        }

    }

    
    // Method to generate OTP
    private String generateOTP() {
        StringBuilder otpBuilder = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            otpBuilder.append((char) ((int) (Math.random() * 10) + '0'));
        }
        return otpBuilder.toString();
    }
        
    
    // Add mute features
    private static void addVolumeEffects(JPanel panel) {
        logInVolume.setIcon(
                new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\unmute.png"));
        logInVolume.setBounds(980, 620, 40, 40);
        panel.add(logInVolume);

        logInVolume.addMouseListener(new MouseListener() {
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
                    logInVolume.setIcon(
                            new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\mute.png"));

                    sounds.isUnmute = false;



                } else {
                    logInVolume.setIcon(
                            new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\unmute.png"));
                    sounds.isUnmute = true;
                    sfx.playWarning();
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                logInVolume.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

            }

            @Override
            public void mouseExited(MouseEvent e) {
                logInVolume.setCursor(Cursor.getDefaultCursor());

            }
        });

    }
}
