/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import settings.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class transaction extends frames {

    static JPanel transactionPnl = new JPanel();
    static sounds sfx = new sounds();
    static typeAccount typeAccountFrame = new typeAccount();

    // Generate and redesign the transaction frame
    transaction() {
        super();
        JDialog.setDefaultLookAndFeelDecorated(true);

        transactionPnl.setSize(1244, 700);
        transactionPnl.setBackground(Color.BLACK);
        transactionPnl.setLayout(null);
        this.add(transactionPnl);

        JLabel lbl1 = new JLabel("Select Transaction");
        lbl1.setFont(new Font("Source Sans Pro", Font.ITALIC + Font.BOLD, 30));
        lbl1.setHorizontalAlignment(JLabel.CENTER);
        lbl1.setForeground(new Color(255, 222, 89));
        lbl1.setBounds(450, 40, 400, 40);
        transactionPnl.add(lbl1);

        JLabel cancel_Button2 = new JLabel();
        cancel_Button2.setIcon(new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\cancelButton.png"));
        cancel_Button2.setBounds(15, 35, 55, 55);
        transactionPnl.add(cancel_Button2);
        
        
        
        
        
        JLabel withdrawBtn = new JLabel();
        withdrawBtn.setIcon(
                new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\withdrawButton.png"));
        withdrawBtn.setBounds(475, 185,365, 70);
        transactionPnl.add(withdrawBtn);
        
        JLabel depositBtn = new JLabel();
        depositBtn.setIcon(
                new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\depositButton.png"));
        depositBtn.setBounds(475, 305,365, 70);
        transactionPnl.add(depositBtn);
        
        JLabel balanceBtn = new JLabel();
        balanceBtn.setIcon(
                new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\balanceButton.png"));
        balanceBtn.setBounds(475, 435,365, 70);
        transactionPnl.add(balanceBtn);
        

        JLabel transactionBG = new JLabel();
        transactionBG.setIcon(
                new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\transactionBG.png"));
        transactionBG.setBounds(0, -15, 1050, 700);
        transactionPnl.add(transactionBG);

        //this.show();
        
        
        // Buttons Functions
        cancel_Button2.addMouseListener(new MouseListener() {
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

                cancel_Button2.setIcon(new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\cancelButton.png"));
                int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want to cancel transaction?", "Exit Confirmation", JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {

                    
                    logIn.transactionFrame.dispose();
                   
                    logIn.attempt = 3; 
                    FinalProject_ATM.logInFrame.show();
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                cancel_Button2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                cancel_Button2.setIcon(new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\cancelButton2.png"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                cancel_Button2.setCursor(Cursor.getDefaultCursor());
                cancel_Button2.setIcon(new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\cancelButton.png"));
            }
        });
        
        
        
        
        withdrawBtn.addMouseListener(new MouseListener() {
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

                typeAccountFrame.show();
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
        
        depositBtn.addMouseListener(new MouseListener() {
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

                typeAccountFrame.show();
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
        
        
        
        balanceBtn.addMouseListener(new MouseListener() {
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

                typeAccountFrame.show();
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
    }

    public static void main(String[]args){
        transaction a = new transaction();
        a.show();
    }
    
    

}
