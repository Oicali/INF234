/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import settings.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class logIn extends frames {

    // Global variables 
    static JPanel logInPnl = new JPanel();
    static int attempt = 3;
    static JPasswordField passwordField = new JPasswordField();
    static final JPasswordField PIN = new roundPasswordField(20);
    public static JLabel logInVolume = new JLabel();
    static sounds sfx = new sounds();
    static transaction transactionFrame = new transaction();
<<<<<<< Updated upstream

=======
<<<<<<< Updated upstream
    public static boolean isUnmute = true;
=======
    

>>>>>>> Stashed changes
>>>>>>> Stashed changes

    // Generate and redesign the Log In frame
    public logIn() {
        super();
        JDialog.setDefaultLookAndFeelDecorated(true);

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

        PIN.setBounds(588, 295, 350, 50);
        PIN.setFont(new Font("Source Sans Pro", Font.BOLD, 25));
        PIN.setBorder(null);
        ((JTextField) PIN).setHorizontalAlignment(JTextField.CENTER);
        logInPnl.add(PIN);

        final JButton logInBtn = new roundButton("Login");
        logInBtn.setBounds(682, 395, 160, 46);
        logInBtn.setFont(new Font("Source Sans Pro", Font.ITALIC + Font.BOLD, 25));
        logInBtn.setForeground(Color.WHITE);
        logInBtn.setEnabled(false);
        logInPnl.add(logInBtn);
        
<<<<<<< Updated upstream
=======
<<<<<<< Updated upstream
=======
        addVolumeEffects(logInPnl);
        
>>>>>>> Stashed changes
        JLabel cancelButton = new JLabel();
        cancelButton.setIcon(
                new ImageIcon(
                        "C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\cancelButton.png"));
        cancelButton.setBounds(15, 35, 55, 55);
        logInPnl.add(cancelButton);
<<<<<<< Updated upstream
=======
>>>>>>> Stashed changes
>>>>>>> Stashed changes
        
        final JButton forgotPass = new JButton("<html><i><u>Forgot Password?</u></i></html>");
        forgotPass.setBounds(685, 510, 160, 35);
        forgotPass.setFont(new Font("Source Sans Pro", Font.PLAIN, 18));
        forgotPass.setContentAreaFilled(false);
        forgotPass.setBorderPainted(false);
        forgotPass.setFocusPainted(false);
        forgotPass.setOpaque(false);
        forgotPass.setForeground(new Color(255, 222, 89));
        logInPnl.add(forgotPass);

        JLabel logInBG = new JLabel();
        logInBG.setIcon(
                new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\logIn_BG.png"));
        logInBG.setBounds(0, -15, 1050, 700);
        logInPnl.add(logInBG);

        
        // Listeners starts here...
        
        // For PIN password field
        PIN.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent a) {
                String value = PIN.getText();
                int l = value.length();
                if (l >= 6) {
                    sfx.playError();
                    JOptionPane.showMessageDialog(null, "6 characters only!", "Invalid password", JOptionPane.ERROR_MESSAGE);
                    PIN.setText("");
                    PIN.requestFocus();
                }
                if (a.getKeyChar() >= '0' && a.getKeyChar() <= '9' || (a.getKeyChar() == KeyEvent.VK_BACK_SPACE)) {
                    sfx.playClick();
                    PIN.setEditable(true);
                    PIN.setForeground(Color.BLACK);
                } else {
                    PIN.setEditable(false);

                }

            }});

        // Add a DocumentListener to the PIN JPasswordField to enable/disable the login button
        PIN.getDocument().addDocumentListener(new DocumentListener() {
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
                String pinText = PIN.getText().trim();
                logInBtn.setEnabled(pinText.length() == 6);
            }
        });

        // Add DocumentListener to enable/disable login button
        PIN.getDocument().addDocumentListener(new DocumentListener() {
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
                String pinText = PIN.getText().trim();
                logInBtn.setEnabled(pinText.length() == 6);
            }
        });

       
        // For Log In Button
        // Change cursor to hand cursor when hovering over the login button
        logInBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        // Change cursor to hand cursor when hovering over the login button
        logInBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        logInBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!PIN.getText().equals(account.getPassword())) {
                    sfx.playError();

                    JOptionPane.showMessageDialog(null, "Wrong password!", "PIN Incorrect", JOptionPane.ERROR_MESSAGE);
                    attempt--;
                    JOptionPane.showMessageDialog(null, "Attempts remaining: " + attempt, "PIN Incorrect",
                            JOptionPane.WARNING_MESSAGE);
                    PIN.setText("");
                    PIN.requestFocus();
                    getRootPane().setDefaultButton(logInBtn);
                    if (attempt < 1) {
                        sfx.playWarning();
                        JOptionPane.showMessageDialog(null, "You have reached maximum attempt!", "System Security",
                                JOptionPane.WARNING_MESSAGE);
                        System.exit(0);
                    }
                } else {
                    sfx.playConfirm();

                    JOptionPane.showMessageDialog(null, "Login Successful!" ,"", JOptionPane.INFORMATION_MESSAGE);
                    FinalProject_ATM.logInFrame.dispose();
                    PIN.setText("");

                    // update volume button image
                    if(sounds.isUnmute){
                        transaction.transactionVolume.setIcon(
                            new ImageIcon(
                                    "C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\unmute.png"));
                    } else {
                        transaction.transactionVolume.setIcon(
                            new ImageIcon(
                                    "C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\mute.png"));
                    }
                    
                    transactionFrame.show();

                }
            }
        });
  
        
        // For forgot password field
        forgotPass.addMouseListener(new MouseListener() {
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

                JLabel label = new JLabel("<html><center>You will receive a 5-number OTP. <br> Kindly remember them to change <br> your password.");
                label.setHorizontalAlignment(SwingConstants.CENTER);
                
                JOptionPane.showMessageDialog(null, label, "Request to change password", JOptionPane.INFORMATION_MESSAGE);
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
                        verifyPassword();
                    } else {
                        sfx.playError();
                        JOptionPane.showMessageDialog(null, "Invalid OTP. Password change aborted.", "OTP Verification", JOptionPane.ERROR_MESSAGE);
                    }
                }

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                forgotPass.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

            }

            @Override
            public void mouseExited(MouseEvent e) {
                forgotPass.setCursor(Cursor.getDefaultCursor());

            }
        });

        
        // Field to input new password
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
        cancelButton.addMouseListener(new MouseListener() {
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

                cancelButton.setIcon(new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\cancelButton.png"));
                int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want to cancel transaction?",
                        "Exit Confirmation", JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                cancelButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                cancelButton.setIcon(
                        new ImageIcon(
                                "C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\cancelButton2.png"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                cancelButton.setCursor(Cursor.getDefaultCursor());
                cancelButton.setIcon(
                        new ImageIcon(
                                "C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\cancelButton.png"));
            }
        });
    
    }

    
    // Recursion
    public static void verifyPassword() {

        sfx.playWarning();
        int option = JOptionPane.showConfirmDialog(null, passwordField, "Enter your new password",
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
                    account.user.setPassword(new String(newPasswordChars));
                    sfx.playConfirm();
                    JOptionPane.showMessageDialog(null, "You have successfully changed your password!",
                            "Changed Password", JOptionPane.INFORMATION_MESSAGE);
                    PIN.setText("");
                    PIN.requestFocus();
                    attempt = 3;
                    passwordField.setText("");
                }
            } else {
                // Display error message if the password length is not 6
                sfx.playError();
                JOptionPane.showMessageDialog(null, "Password must be exactly 6 digits long!", "Invalid Password", JOptionPane.ERROR_MESSAGE);
                passwordField.setText("");
                verifyPassword();
            }
        } else {
            PIN.requestFocus();
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
<<<<<<< Updated upstream
        
=======
<<<<<<< Updated upstream
=======
        
    
    
    // add volume settings
    private static void addVolumeEffects(JPanel panel) {

        

        logInVolume.setIcon(
                new ImageIcon(
                        "C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\unmute.png"));

        logInVolume.setBounds(975, 620, 40, 37);
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
                            new ImageIcon(
                                    "C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\mute.png"));
                    
                    sounds.isUnmute = false;

                } else {
                    logInVolume.setIcon(
                            new ImageIcon(
                                    "C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\unmute.png"));
                    
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
>>>>>>> Stashed changes
>>>>>>> Stashed changes
}
