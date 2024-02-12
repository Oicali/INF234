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
    static final JPasswordField PIN = new JPasswordField();
    static sounds sfx = new sounds();
    
    
    // Generate and redesign the opening frame
    logIn(){
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
        lbl1.setBounds(550, 40, 400, 40);
        pnl1.add(lbl1);

        JLabel lbl2 = new JLabel("Enter your PIN");
        lbl2.setFont(new Font("Source Sans Pro", Font.ITALIC + Font.BOLD, 25));
        lbl2.setHorizontalAlignment(JLabel.CENTER);
        lbl2.setForeground(new Color(255, 222, 89));
        lbl2.setBounds(555, 200, 400, 40);
        pnl1.add(lbl2);

        
        PIN.setBounds(583, 255, 350, 50);
        PIN.setFont(new Font("Source Sans Pro", Font.BOLD, 25));
        PIN.setBorder(null);
        ((JTextField) PIN).setHorizontalAlignment(JTextField.CENTER);
        pnl1.add(PIN);

        final JButton loginBtn = new JButton("Enter");
        loginBtn.setBounds(677, 340, 160, 46);
        loginBtn.setFont(new Font("Source Sans Pro", Font.ITALIC + Font.BOLD, 25));
        loginBtn.setContentAreaFilled(true);
        //loginBtn.setBorderPainted(false);
        loginBtn.setFocusPainted(false);
        loginBtn.setOpaque(false);
        loginBtn.setForeground(new Color(0, 0, 0));
        pnl1.add(loginBtn);

        //frameSettings.addCancelButton(pnl1);

        final JButton changePass = new JButton("<html><i><u>Change Password</u></i></html>");
        changePass.setBounds(680, 440, 160, 35);
        changePass.setFont(new Font("Source Sans Pro", Font.PLAIN, 18));
        changePass.setContentAreaFilled(false);
        changePass.setBorderPainted(false);
        changePass.setFocusPainted(false);
        changePass.setOpaque(false);
        changePass.setForeground(new Color(255, 222, 89));
        pnl1.add(changePass);

        JLabel logInBG = new JLabel();
        logInBG.setIcon(
                new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\logIn_BG.png"));
        logInBG.setBounds(0, -15, 1050, 700);
        pnl1.add(logInBG);

        this.show();


        // Buttons Functions starts here...
        PIN.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' || ke.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                    PIN.setEditable(true);
                } else {
                    PIN.setEditable(false);
                }
            }
        });

        loginBtn.addActionListener(new ActionListener() {

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
                    getRootPane().setDefaultButton(loginBtn);
                    if (attempt < 1) {
                        JOptionPane.showMessageDialog(null, "You have reached maximum attempt!", "",
                                JOptionPane.WARNING_MESSAGE);
                        System.exit(0);
                    }
                } else {
                    sfx.playConfirm();
                    
                    JOptionPane.showMessageDialog(null, "Login Successful!");
                    dispose();
                }
            }
        });

        changePass.addActionListener(new ActionListener() {
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
                        PIN.requestFocus();
            } else {
                sfx.playError();
                JOptionPane.showMessageDialog(null, "Password cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
                verifyPassword();
            }
        }

        else PIN.requestFocus();
    }
    
    
}
