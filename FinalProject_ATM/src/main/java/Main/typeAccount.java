/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;
import settings.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class typeAccount extends frames {
    
    static sounds sfx = new sounds();
    static typeAmount typeAmountFrame = new typeAmount();
    
    // Generate and redesign the Log In frame
    typeAccount() {
        super();
        JDialog.setDefaultLookAndFeelDecorated(true);

        JPanel pnl1 = new JPanel();
        pnl1.setSize(1244, 700);
        pnl1.setBackground(Color.BLACK);
        pnl1.setLayout(null);
        this.add(pnl1);

        JLabel lbl1 = new JLabel("Choose which account");
        lbl1.setFont(new Font("Source Sans Pro", Font.ITALIC + Font.BOLD, 30));
        lbl1.setHorizontalAlignment(JLabel.CENTER);
        lbl1.setForeground(new Color(255, 222, 89));
        lbl1.setBounds(450, 40, 400, 40);
        pnl1.add(lbl1);
        
        //buttons.addVolumeButton(pnl1);
        
        JLabel cancelBtn = new JLabel();
        cancelBtn.setIcon(new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\cancelButton.png"));
        cancelBtn.setBounds(15, 35, 55, 55);
        pnl1.add(cancelBtn);
        
        JLabel currentBtn = new JLabel();
        currentBtn.setIcon(
                new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\currentButton.png"));
        currentBtn.setBounds(475, 185,365, 70);
        pnl1.add(currentBtn);
        
        JLabel savingsBtn = new JLabel();
        savingsBtn.setIcon(
                new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\savingsButton.png"));
        savingsBtn.setBounds(475, 305,365, 70);
        pnl1.add(savingsBtn);
        
        JLabel backBtn = new JLabel();
        backBtn.setIcon(
                new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\backButton.png"));
        backBtn.setBounds(475, 435,365, 70);
        pnl1.add(backBtn);
        
        JLabel typeAccountBG = new JLabel();
        typeAccountBG.setIcon(
                new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\transactionBG.png"));
        typeAccountBG.setBounds(0, -15, 1050, 700);
        pnl1.add(typeAccountBG);
        
        
        // Buttons Functions
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
                int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want to cancel transaction?", "Exit Confirmation", JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {

                    
                    dispose();
                   
                    logIn.attempt = 3; 
                    FinalProject_ATM.logIn1.show();
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
        
        
        
        currentBtn.addMouseListener(new MouseListener() {
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

                typeAmountFrame.show();
                dispose();
                
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                //Do nothing
            }

            @Override
            public void mouseExited(MouseEvent e) {
               // Do nothing
            }
        });
        
        savingsBtn.addMouseListener(new MouseListener() {
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

                typeAmountFrame.show();
                dispose();
                
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                //Do nothing
            }

            @Override
            public void mouseExited(MouseEvent e) {
               // Do nothing
            }
        });
        
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
                sfx.playClick();

                dispose();
                logIn.transact1.show();
                
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                //Do nothing
            }

            @Override
            public void mouseExited(MouseEvent e) {
               // Do nothing
            }
        });
        
        
    }
    
    public static void main(String[]args){
        typeAccount a = new typeAccount();
        a.show();
    }
}
