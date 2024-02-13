/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import settings.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class logIn extends frames {

    // Global variables 
    static int attempt = 3;
    static JPasswordField passwordField = new JPasswordField();
    static final JPasswordField PIN = new roundPasswordField(20);
    static sounds sfx = new sounds();
    static transaction transact1 = new transaction();

    // Generate and redesign the Log In frame
    public logIn() {
        super();
        JDialog.setDefaultLookAndFeelDecorated(true);

        JPanel pnl1 = new JPanel();
        pnl1.setSize(1244, 700);
        pnl1.setBackground(Color.BLACK);
        pnl1.setLayout(null);
        this.add(pnl1);

        JLabel lbl1 = new JLabel("Log in to your Account");
        lbl1.setFont(new Font("Source Sans Pro", Font.ITALIC + Font.BOLD, 30));
        lbl1.setHorizontalAlignment(JLabel.CENTER);
        lbl1.setForeground(new Color(255, 222, 89));
        lbl1.setBounds(555, 40, 400, 40);
        pnl1.add(lbl1);

        JLabel logo = new JLabel();
        logo.setIcon(
                new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\logo2.png"));
        logo.setBounds(707, 135, 110, 110);
        pnl1.add(logo);

        JLabel lbl2 = new JLabel("Enter your PIN");
        lbl2.setFont(new Font("Source Sans Pro", Font.ITALIC + Font.BOLD, 25));
        lbl2.setHorizontalAlignment(JLabel.CENTER);
        lbl2.setForeground(new Color(255, 222, 89));
        lbl2.setBounds(555, 255, 400, 40);
        pnl1.add(lbl2);

        PIN.setBounds(583, 299, 350, 50);
        PIN.setFont(new Font("Source Sans Pro", Font.BOLD, 25));
        PIN.setBorder(null);
        ((JTextField) PIN).setHorizontalAlignment(JTextField.CENTER);
        pnl1.add(PIN);

        final JButton logInBtn = new roundButton("Login");
        logInBtn.setBounds(677, 390, 160, 46);
        logInBtn.setFont(new Font("Source Sans Pro", Font.ITALIC + Font.BOLD, 25));
        logInBtn.setForeground(Color.WHITE);
        pnl1.add(logInBtn);

        buttons.addCancelButton(pnl1);
        //buttons.addVolumeButton(pnl1);

        final JButton forgotPass = new JButton("<html><i><u>Forgot Password?</u></i></html>");
        forgotPass.setBounds(680, 490, 160, 35);
        forgotPass.setFont(new Font("Source Sans Pro", Font.PLAIN, 18));
        forgotPass.setContentAreaFilled(false);
        forgotPass.setBorderPainted(false);
        forgotPass.setFocusPainted(false);
        forgotPass.setOpaque(false);
        forgotPass.setForeground(new Color(255, 222, 89));
        pnl1.add(forgotPass);

        JLabel logInBG = new JLabel();
        logInBG.setIcon(
                new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\logIn_BG.png"));
        logInBG.setBounds(0, -15, 1050, 700);
        pnl1.add(logInBG);

        //this.show();

        // Buttons Functions starts here...
        PIN.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' || ke.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                    PIN.setEditable(true);
                    sfx.playClick();

                } else {
                    PIN.setEditable(false);
                }
            }
        });

        logInBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!PIN.getText().equals(account.getPassword())) {
                    sfx.playError();

                    JOptionPane.showMessageDialog(null, "PIN incorrect", "", JOptionPane.ERROR_MESSAGE);
                    attempt--;
                    JOptionPane.showMessageDialog(null, "Attempts remaining: " + attempt, "",
                            JOptionPane.WARNING_MESSAGE);
                    PIN.setText("");
                    PIN.requestFocus();
                    getRootPane().setDefaultButton(logInBtn);
                    if (attempt < 1) {
                        JOptionPane.showMessageDialog(null, "You have reached maximum attempt!", "",
                                JOptionPane.WARNING_MESSAGE);
                        System.exit(0);
                    }
                } else {
                    sfx.playConfirm();

                    JOptionPane.showMessageDialog(null, "Login Successful!");
                    FinalProject_ATM.logIn1.dispose();
                    PIN.setText("");
                    
                    transact1.show();
                    
                }
            }
        });

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

                JOptionPane.showMessageDialog(null, "You will receive a 5-number OTP \n      to change your password.", "Request to change password", JOptionPane.INFORMATION_MESSAGE);
                JOptionPane.showMessageDialog(null, "Your OTP: " + otp, "OTP Verification", JOptionPane.INFORMATION_MESSAGE);

                JTextField otpField = new JTextField();
                otpField.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        char c = e.getKeyChar();
                        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE)) {
                            e.consume(); // Ignore the event
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

        passwordField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE)) {
                    e.consume(); // Ignore the event
                }
            }
        });
    }

    // Recursion
    public static void verifyPassword() {

        int option = JOptionPane.showConfirmDialog(null, passwordField, "Enter your new password",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (option == JOptionPane.OK_OPTION) {
            if (passwordField.getPassword().length > 0) {
                char[] newPasswordChars = passwordField.getPassword();
                account.user.setPassword(new String(newPasswordChars));

                JOptionPane.showMessageDialog(null, "You have successfully changed your password!",
                        "Change Password", JOptionPane.INFORMATION_MESSAGE);
                PIN.setText("");
                PIN.requestFocus();
                passwordField.setText("");
            } else {
                sfx.playError();
                JOptionPane.showMessageDialog(null, "New password cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
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

    /*changePass.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sfx.playWarning();

                int choice2 = JOptionPane.showConfirmDialog(null, "Are you sure you want to change your password?",
                        "Change Password", JOptionPane.YES_NO_OPTION);
                if (choice2 == JOptionPane.YES_OPTION) {
                    
                    // Add KeyListener to the password field
                    passwordField.addKeyListener(new KeyAdapter() {
                        @Override
                        public void keyTyped(KeyEvent e) {
                            char c = e.getKeyChar();
                            if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE)) {
                                e.consume(); // Ignore the event
                            }
                        }
                    });

                    verifyPassword();
                }

                else PIN.requestFocus();
            }
        });*/
}
