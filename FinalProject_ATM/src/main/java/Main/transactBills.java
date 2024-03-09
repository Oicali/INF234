/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import settings.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class transactBills extends frames {
    
    // Global variables 
    static JPanel transactBillsPnl = new JPanel();
    static sounds sfx = new sounds();
    static JLabel transactBillsVolume = new JLabel();
    public static String serviceName = "null";
    
    // Generate and redesign the transact bills frame for supported services
    transactBills(){
        super();
        
        transactBillsPnl.setSize(1244, 700);
        transactBillsPnl.setBackground(Color.BLACK);
        transactBillsPnl.setLayout(null);
        this.add(transactBillsPnl);
        
        JLabel lbl1 = new JLabel("Select Supported Services");
        lbl1.setFont(new Font("Source Sans Pro", Font.ITALIC + Font.BOLD, 30));
        lbl1.setHorizontalAlignment(JLabel.CENTER);
        lbl1.setForeground(new Color(255, 222, 89));
        lbl1.setBounds(530, 40, 400, 40);
        transactBillsPnl.add(lbl1);
        
        JLabel MeralcoBtn = new JLabel();
        MeralcoBtn .setIcon(
                new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\MeralcoButton.png"));
        MeralcoBtn .setBounds(550, 185,365, 70);
        transactBillsPnl.add(MeralcoBtn);
        
        JLabel MayniladBtn = new JLabel();
        MayniladBtn.setIcon(
                new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\mayniladButton.png"));
        MayniladBtn.setBounds(550, 330,365, 70);
        transactBillsPnl.add(MayniladBtn);
        
        addVolumeEffects(transactBillsPnl);
        
        JLabel cancelBtn = new JLabel();
        cancelBtn.setIcon(new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\cancelButton.png"));
        cancelBtn.setBounds(15, 35, 55, 55);
        transactBillsPnl.add(cancelBtn);
        
        final JButton backBtn = new roundButton("Back", new Color(48,47,178), new Color(32,31,171),  new Color(48,47,178), new Color(32,31,171));
        backBtn.setBounds(680, 475, 125, 50);
        backBtn.setFont(new Font("Source Sans Pro", Font.ITALIC + Font.BOLD, 25));
        backBtn.setForeground(Color.WHITE);
        transactBillsPnl.add(backBtn);
        
        JLabel transactBillsBG = new JLabel();
        transactBillsBG.setIcon(
                new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\payBillsBG.png"));
        transactBillsBG.setBounds(0, -15, 1050, 700);
        transactBillsPnl.add(transactBillsBG);
        
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

                    // Update volume icon
                    if(sounds.isUnmute){
                        logIn.logInVolume.setIcon(
                            new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\unmute.png"));
                    
                    } else {
                        logIn.logInVolume.setIcon(
                            new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\mute.png"));
                    }
                    
                    serviceName = "";
                    transaction.transactBillsFrame.dispose();
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
        
        // For back button to return to transaction frame
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
        
        // For Meralco button and go to typeAccount frame
        MeralcoBtn.addMouseListener(new MouseListener() {
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
                
                // Set transaction
                serviceName = "Meralco";
                
                // Update volume icon
                    if(sounds.isUnmute){
                        typeAccount.typeAccountVolume.setIcon(
                            new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\unmute.png"));
                    
                    } else {
                        typeAccount.typeAccountVolume.setIcon(
                            new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\mute.png"));
                    }

                dispose();
                transaction.typeAccountFrame.show();
                   
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                MeralcoBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
               MeralcoBtn.setCursor(Cursor.getDefaultCursor());
            }
        });
        
         // For Maynilad button and go to typeAccount frame
        MayniladBtn.addMouseListener(new MouseListener() {
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
                
                // Set transaction
                serviceName = "Maynilad";
                
                // Update volume icon
                    if(sounds.isUnmute){
                        typeAccount.typeAccountVolume.setIcon(
                            new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\unmute.png"));
                    
                    } else {
                        typeAccount.typeAccountVolume.setIcon(
                            new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\mute.png"));
                    }

                dispose();
                transaction.typeAccountFrame.show();
                   
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                MayniladBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
               MayniladBtn.setCursor(Cursor.getDefaultCursor());
            }
        });
        
        
    }
    
    // Add mute features
    private static void addVolumeEffects(JPanel panel) {
        transactBillsVolume.setIcon(
                new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\unmute.png"));
        transactBillsVolume.setBounds(980, 620, 40, 40);
        panel.add(transactBillsVolume);

        transactBillsVolume.addMouseListener(new MouseListener() {
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
                    transactBillsVolume.setIcon(
                            new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\mute.png"));

                    sounds.isUnmute = false;
                } else {
                    transactBillsVolume.setIcon(
                            new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\unmute.png"));
                    sounds.isUnmute = true;
                    sfx.playWarning();
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                transactBillsVolume.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                transactBillsVolume.setCursor(Cursor.getDefaultCursor());
            }
        });
    }
    
    
    
    public static void main (String[]args){
        frames a = new transactBills();
        a.show();
    }
    
}
