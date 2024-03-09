/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;
import settings.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import javax.swing.*;

public class typeAccount extends frames {
    
    // Global variables 
    static sounds sfx = new sounds();
    static typeAmount typeAmountFrame = new typeAmount();
    static viewBalance viewBalanceFrame = new viewBalance();
    static typeAmount2 typeAmount2Frame = new typeAmount2();
    static typeAmount3 typeAmount3Frame = new typeAmount3();
    static JLabel typeAccountVolume = new JLabel();
    static String accountType = "null";
    
    
    // Generate and redesign the account selection frame
    typeAccount() {
        super();

        JPanel typeAccountPnl = new JPanel();
        typeAccountPnl.setSize(1244, 700);
        typeAccountPnl.setBackground(Color.BLACK);
        typeAccountPnl.setLayout(null);
        this.add(typeAccountPnl);

        JLabel lbl1 = new JLabel("Choose which account");
        lbl1.setFont(new Font("Source Sans Pro", Font.ITALIC + Font.BOLD, 30));
        lbl1.setHorizontalAlignment(JLabel.CENTER);
        lbl1.setForeground(new Color(255, 222, 89));
        lbl1.setBounds(535, 40, 400, 40);
        typeAccountPnl.add(lbl1);
        
        addVolumeEffects(typeAccountPnl);
        
        JLabel cancelBtn = new JLabel();
        cancelBtn.setIcon(new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\cancelButton.png"));
        cancelBtn.setBounds(15, 35, 55, 55);
        typeAccountPnl.add(cancelBtn);
        
        JLabel currentBtn = new JLabel();
        currentBtn.setIcon(
                new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\currentButton.png"));
        currentBtn.setBounds(555, 205,365, 70);
        typeAccountPnl.add(currentBtn);
        
        JLabel savingsBtn = new JLabel();
        savingsBtn.setIcon(
                new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\savingsButton.png"));
        savingsBtn.setBounds(555, 345,365, 70);
        typeAccountPnl.add(savingsBtn);
        
        final JButton backBtn = new roundButton("Back", new Color(48,47,178), new Color(32,31,171),  new Color(48,47,178), new Color(32,31,171));
        backBtn.setBounds(680, 485, 125, 50);
        backBtn.setFont(new Font("Source Sans Pro", Font.ITALIC + Font.BOLD, 25));
        backBtn.setForeground(Color.WHITE);
        typeAccountPnl.add(backBtn);
        
        JLabel typeAccountBG = new JLabel();
        typeAccountBG.setIcon(
                new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\typeAccountBG.png"));
        typeAccountBG.setBounds(0, -15, 1050, 700);
        typeAccountPnl.add(typeAccountBG);
        
        
        /* Buttons functions start here... */
        
        // For cancel button to return to log in frame
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
                int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want to cancel transaction?", "Cancel Transaction", JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {

                    // Set account type
                    accountType = "";
                    
                    // Update volume icon
                    if(sounds.isUnmute){
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
                cancelBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                cancelBtn.setIcon(new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\cancelButton2.png"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                cancelBtn.setCursor(Cursor.getDefaultCursor());
                cancelBtn.setIcon(new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\cancelButton.png"));
            }
        });
        
        
        // For current button and go to typeAccount frame or viewBalance frame
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
                
                // Set account type
                accountType = "Current";
                viewBalance.lbl2.setText(accountType);
                viewBalance.lbl7.setText(format.format(account.user.getCurrent()));
                
                // Update volume icon for typeAmount Frame
                    if(sounds.isUnmute){
                        typeAmount.typeAmountVolume.setIcon(
                            new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\unmute.png"));
                    
                    } else {
                        typeAmount.typeAmountVolume.setIcon(
                            new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\mute.png"));
                    }
                    
                // Update volume icon for viewBalance Frame
                    if(sounds.isUnmute){
                        viewBalance.viewBalanceVolume.setIcon(
                            new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\unmute.png"));
                    
                    } else {
                        viewBalance.viewBalanceVolume.setIcon(
                            new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\mute.png"));
                    }
                    
                // Update volume icon for typeAmount2 Frame
                    if(sounds.isUnmute){
                        typeAmount2.typeAmount2Volume.setIcon(
                            new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\unmute.png"));
                    
                    } else {
                        typeAmount2.typeAmount2Volume.setIcon(
                            new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\mute.png"));
                    }
                    
                // Update volume icon for typeAmount3 Frame
                    if(sounds.isUnmute){
                        typeAmount3.typeAmount3Volume.setIcon(
                            new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\unmute.png"));
                    
                    } else {
                        typeAmount3.typeAmount3Volume.setIcon(
                            new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\mute.png"));
                    }

                // Reset Fields before goint to next frame
                typeAmount.amountField.setText("");
                typeAmount2.amountField2.setText("");
                typeAmount2.recipientField.setText("");
                typeAmount3.amountField3.setText("");
                typeAmount3.customerField.setText("");
                dispose(); 
                
                if(transaction.transactionType.equals("Withdraw") && accountType.equals("Current")){ 
                    typeAmount.lbl1.setText(transaction.transactionType + " from your " + accountType);
                    typeAmountFrame.show();
                } else if(transaction.transactionType.equals("Deposit") && accountType.equals("Current")){
                    typeAmount.lbl1.setText(transaction.transactionType + " into your " + accountType);
                    typeAmountFrame.show();
                } else if (transaction.transactionType.equals("Balance") && accountType.equals("Current")){
                    viewBalanceFrame.show();
                } else if (transaction.transactionType.equals("Bank Transfer") && accountType.equals("Current")){
                    typeAmount2.lbl1.setText("Transfer using your " + accountType); 
                    typeAmount2Frame.show();
                } else if (transaction.transactionType.equals("Pay Bills") && accountType.equals("Current")){
                    typeAmount3.lbl1.setText("Pay Bills with your " + accountType); 
                    typeAmount3.lbl3b.setText(" - Paying " + transactBills.serviceName + " Bills - "); 
                    typeAmount3Frame.show();
                }
                                
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                currentBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
               currentBtn.setCursor(Cursor.getDefaultCursor());
            }
        });
        
        
        // For savings button and go to typeAccount frame or viewBalance frame
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
                
                // Set account type
                accountType = "Savings"; 
                viewBalance.lbl2.setText(accountType);
                viewBalance.lbl7.setText(format.format(account.user.getSavings()));
                
                // Update volume icon for typeAmountVolume Frame
                    if(sounds.isUnmute){
                        typeAmount.typeAmountVolume.setIcon(
                            new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\unmute.png"));
                    
                    } else {
                        typeAmount.typeAmountVolume.setIcon(
                            new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\mute.png"));
                    }
                    
                // Update volume icon for viewBalance Frame
                    if(sounds.isUnmute){
                        viewBalance.viewBalanceVolume.setIcon(
                            new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\unmute.png"));
                    
                    } else {
                        viewBalance.viewBalanceVolume.setIcon(
                            new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\mute.png"));
                    }

                // Update volume icon for typeAmount2 Frame
                    if(sounds.isUnmute){
                        typeAmount2.typeAmount2Volume.setIcon(
                            new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\unmute.png"));
                    
                    } else {
                        typeAmount2.typeAmount2Volume.setIcon(
                            new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\mute.png"));
                    }
                    
                // Update volume icon for typeAmount3 Frame
                    if(sounds.isUnmute){
                        typeAmount3.typeAmount3Volume.setIcon(
                            new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\unmute.png"));
                    
                    } else {
                        typeAmount3.typeAmount3Volume.setIcon(
                            new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\mute.png"));
                    }

                // Reset fields before going to next frame
                typeAmount.amountField.setText("");
                typeAmount2.amountField2.setText("");
                typeAmount2.recipientField.setText("");
                typeAmount3.amountField3.setText("");
                typeAmount3.customerField.setText("");
                dispose();
                
                if(transaction.transactionType.equals("Withdraw") && accountType.equals("Savings")){
                    typeAmount.lbl1.setText(transaction.transactionType + " from your " + accountType);                    
                    typeAmountFrame.show();
                } else if(transaction.transactionType.equals("Deposit") && accountType.equals("Savings")){
                    typeAmount.lbl1.setText(transaction.transactionType + " into your " + accountType); 
                    typeAmountFrame.show();
                } else if (transaction.transactionType.equals("Balance") && accountType.equals("Savings")){
                    viewBalanceFrame.show();
                } else if (transaction.transactionType.equals("Bank Transfer") && accountType.equals("Savings")){
                    typeAmount2.lbl1.setText("Transfer using your " + accountType); 
                    typeAmount2Frame.show();
                } else if (transaction.transactionType.equals("Pay Bills") && accountType.equals("Savings")){
                    typeAmount3.lbl1.setText("Pay Bills with your " + accountType); 
                    typeAmount3.lbl3b.setText(" - Paying " + transactBills.serviceName + " Bills - "); 
                    typeAmount3Frame.show();
                }
            
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                savingsBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
               savingsBtn.setCursor(Cursor.getDefaultCursor());
            }
        });
        
        
        // For back button and go to transaction frame
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

                // Update volume icon
                    if(sounds.isUnmute){
                        transaction.transactionVolume.setIcon(
                            new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\unmute.png"));
                    
                    } else {
                        transaction.transactionVolume.setIcon(
                            new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\mute.png"));
                    }
                
                dispose();
                logIn.transactionFrame.show();
                
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
        typeAccountVolume.setIcon(
                new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\unmute.png"));
        typeAccountVolume.setBounds(980, 620, 40, 40);
        panel.add(typeAccountVolume);

        typeAccountVolume.addMouseListener(new MouseListener() {
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
                    typeAccountVolume.setIcon(
                            new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\mute.png"));

                    sounds.isUnmute = false;
                } else {
                    typeAccountVolume.setIcon(
                            new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\unmute.png"));
                    sounds.isUnmute = true;
                    sfx.playWarning();
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                typeAccountVolume.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                typeAccountVolume.setCursor(Cursor.getDefaultCursor());
            }
        });
    }
    
    public static void main(String[]args){
        typeAccount a = new typeAccount();
        a.show();
    }
    
}
