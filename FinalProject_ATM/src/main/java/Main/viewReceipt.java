/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import settings.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class viewReceipt extends frames {

    //Global variables
    static JPanel viewReceiptPnl = new JPanel();
    static sounds sfx = new sounds();
    static JLabel viewReceiptVolume = new JLabel();
    static JLabel lbl8 = new JLabel();
    static JLabel lbl10 = new JLabel();
    static JLabel lbl12 = new JLabel();
    static JLabel lbl14 = new JLabel();
    static JLabel lbl15 = new JLabel();
    static JLabel lbl16 = new JLabel();
    static JLabel lbl18 = new JLabel();
    static JLabel lbl19 = new JLabel();

    // Generate and redesign the view receipt frame
    viewReceipt() {
        super();

        viewReceiptPnl.setSize(1244, 700);
        viewReceiptPnl.setBackground(Color.BLACK);
        viewReceiptPnl.setLayout(null);
        this.add(viewReceiptPnl);

        JLabel lbl1 = new JLabel();
        lbl1.setText("Check your Receipt");
        lbl1.setFont(new Font("Source Sans Pro", Font.ITALIC + Font.BOLD, 30));
        lbl1.setHorizontalAlignment(JLabel.CENTER);
        lbl1.setForeground(new Color(255, 222, 89));
        lbl1.setBounds(290, 40, 450, 40);
        viewReceiptPnl.add(lbl1);

        JLabel lbl2 = new JLabel();
        lbl2.setText("Bank of Inclusive Transactions");
        lbl2.setFont(new Font("Source Sans Pro", Font.BOLD, 24));
        lbl2.setHorizontalAlignment(JLabel.CENTER);
        lbl2.setForeground(Color.BLACK);
        lbl2.setBounds(265, 156, 500, 50);
        viewReceiptPnl.add(lbl2);

        JLabel lbl3 = new JLabel();
        lbl3.setText("Username :");
        lbl3.setFont(new Font("Source Sans Pro", Font.BOLD, 18));
        lbl3.setHorizontalAlignment(JLabel.LEFT);
        lbl3.setForeground(Color.BLACK);
        lbl3.setBounds(295, 225, 500, 60);
        viewReceiptPnl.add(lbl3);

        // Display username
        JLabel lbl4 = new JLabel();
        lbl4.setText(account.user.getName());
        lbl4.setFont(new Font("Source Sans Pro", Font.PLAIN, 18));
        lbl4.setHorizontalAlignment(JLabel.RIGHT);
        lbl4.setForeground(Color.BLACK);
        lbl4.setBounds(225, 225, 500, 60);
        viewReceiptPnl.add(lbl4);

        JLabel lbl5 = new JLabel();
        lbl5.setText("Account Number : ");
        lbl5.setFont(new Font("Source Sans Pro", Font.BOLD, 18));
        lbl5.setHorizontalAlignment(JLabel.LEFT);
        lbl5.setForeground(Color.BLACK);
        lbl5.setBounds(295, 270, 200, 40);
        viewReceiptPnl.add(lbl5);

        // Display censored UID
        JLabel lbl6 = new JLabel();
        lbl6.setText(viewBalance.maskedStr1 + viewBalance.str2);
        lbl6.setFont(new Font("Source Sans Pro", Font.PLAIN, 18));
        lbl6.setHorizontalAlignment(JLabel.RIGHT);
        lbl6.setForeground(Color.BLACK);
        lbl6.setBounds(225, 270, 500, 40);
        viewReceiptPnl.add(lbl6);

        JLabel lbl9 = new JLabel();
        lbl9.setText("Transaction type :");
        lbl9.setFont(new Font("Source Sans Pro", Font.BOLD, 18));
        lbl9.setHorizontalAlignment(JLabel.LEFT);
        lbl9.setForeground(Color.BLACK);
        lbl9.setBounds(295, 305, 500, 40);
        viewReceiptPnl.add(lbl9);

        // Display type of transaction
        lbl10.setFont(new Font("Source Sans Pro", Font.PLAIN, 18));
        lbl10.setHorizontalAlignment(JLabel.RIGHT);
        lbl10.setForeground(Color.BLACK);
        lbl10.setBounds(225, 305, 500, 40);
        viewReceiptPnl.add(lbl10);

        JLabel lbl7 = new JLabel();
        lbl7.setText("Account type :");
        lbl7.setFont(new Font("Source Sans Pro", Font.BOLD, 18));
        lbl7.setHorizontalAlignment(JLabel.LEFT);
        lbl7.setForeground(Color.BLACK);
        lbl7.setBounds(295, 340, 200, 40);
        viewReceiptPnl.add(lbl7);

        // Display type of account
        lbl8.setFont(new Font("Source Sans Pro", Font.PLAIN, 18));
        lbl8.setHorizontalAlignment(JLabel.RIGHT);
        lbl8.setForeground(Color.BLACK);
        lbl8.setBounds(225, 340, 500, 40);
        viewReceiptPnl.add(lbl8);

        JLabel lbl11 = new JLabel();
        lbl11.setText("Amount :");
        lbl11.setFont(new Font("Source Sans Pro", Font.BOLD, 18));
        lbl11.setHorizontalAlignment(JLabel.LEFT);
        lbl11.setForeground(Color.BLACK);
        lbl11.setBounds(295, 375, 500, 40);
        viewReceiptPnl.add(lbl11);

        // Display amount
        lbl12.setFont(new Font("Source Sans Pro", Font.PLAIN, 18));
        lbl12.setHorizontalAlignment(JLabel.RIGHT);
        lbl12.setForeground(Color.BLACK);
        lbl12.setBounds(225, 375, 500, 40);
        viewReceiptPnl.add(lbl12);

        JLabel lbl13 = new JLabel();
        lbl13.setText("Account balance :");
        lbl13.setFont(new Font("Source Sans Pro", Font.BOLD, 18));
        lbl13.setHorizontalAlignment(JLabel.LEFT);
        lbl13.setForeground(Color.BLACK);
        lbl13.setBounds(295, 410, 500, 40);
        viewReceiptPnl.add(lbl13);

        // Display remaining account balance
        lbl14.setFont(new Font("Source Sans Pro", Font.PLAIN, 18));
        lbl14.setHorizontalAlignment(JLabel.RIGHT);
        lbl14.setForeground(Color.BLACK);
        lbl14.setBounds(225, 410, 500, 40);
        viewReceiptPnl.add(lbl14);

        lbl15.setText("Sent to :");
        lbl15.setFont(new Font("Source Sans Pro", Font.BOLD, 18));
        lbl15.setHorizontalAlignment(JLabel.LEFT);
        lbl15.setForeground(Color.BLACK);
        lbl15.setBounds(295, 445, 500, 40);
        viewReceiptPnl.add(lbl15);

        // Display Recipient
        lbl16.setFont(new Font("Source Sans Pro", Font.PLAIN, 18));
        lbl16.setHorizontalAlignment(JLabel.RIGHT);
        lbl16.setForeground(Color.BLACK);
        lbl16.setBounds(225, 445, 500, 40);
        viewReceiptPnl.add(lbl16);

        JLabel lbl17 = new JLabel();
        lbl17.setText("Ref No. ");
        lbl17.setFont(new Font("Source Sans Pro", Font.PLAIN, 15));
        lbl17.setHorizontalAlignment(JLabel.LEFT);
        lbl17.setForeground(Color.BLACK);
        lbl17.setBounds(295, 490, 200, 40);
        viewReceiptPnl.add(lbl17);

        // Display Reference Number
        lbl18.setFont(new Font("Source Sans Pro", Font.BOLD, 15));
        lbl18.setHorizontalAlignment(JLabel.LEFT);
        lbl18.setForeground(Color.BLACK);
        lbl18.setBounds(350, 490, 200, 40);
        viewReceiptPnl.add(lbl18);

        // Display Date and time
        lbl19.setFont(new Font("Source Sans Pro", Font.PLAIN, 15));
        lbl19.setHorizontalAlignment(JLabel.RIGHT);
        lbl19.setForeground(Color.BLACK);
        lbl19.setBounds(425, 490, 300, 40);
        viewReceiptPnl.add(lbl19);

        addVolumeEffects(viewReceiptPnl);

        JLabel viewReceiptBG = new JLabel();
        viewReceiptBG.setIcon(
                new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\viewReceiptBG.png"));
        viewReceiptBG.setBounds(0, -15, 1050, 700);
        viewReceiptPnl.add(viewReceiptBG);

    }

    // Add mute features
    private static void addVolumeEffects(JPanel panel) {
        viewReceiptVolume.setIcon(
                new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\unmute.png"));
        viewReceiptVolume.setBounds(980, 620, 40, 40);
        panel.add(viewReceiptVolume);

        viewReceiptVolume.addMouseListener(new MouseListener() {
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
                    viewReceiptVolume.setIcon(
                            new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\mute.png"));

                    sounds.isUnmute = false;

                } else {
                    viewReceiptVolume.setIcon(
                            new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\unmute.png"));
                    sounds.isUnmute = true;
                    sfx.playWarning();
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                viewReceiptVolume.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                viewReceiptVolume.setCursor(Cursor.getDefaultCursor());
            }
        });
    }

}
