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

    // Global variables 
    static JPanel transactionPnl = new JPanel();
    static sounds sfx = new sounds();
    static typeAccount typeAccountFrame = new typeAccount();
    static viewHistory viewHistoryFrame = new viewHistory();
    static transactBank transactBankFrame = new transactBank();
    static transactBills transactBillsFrame = new transactBills();
    static JLabel transactionVolume = new JLabel();
    public static String transactionType = "null";

    // Generate and redesign the transaction frame
    transaction() {
        super();

        transactionPnl.setSize(1244, 700);
        transactionPnl.setBackground(Color.BLACK);
        transactionPnl.setLayout(null);
        this.add(transactionPnl);

        JLabel lbl1 = new JLabel("Select Transaction");
        lbl1.setFont(new Font("Source Sans Pro", Font.ITALIC + Font.BOLD, 30));
        lbl1.setHorizontalAlignment(JLabel.CENTER);
        lbl1.setForeground(new Color(255, 222, 89));
        lbl1.setBounds(470, 40, 400, 40);
        transactionPnl.add(lbl1);

        JLabel cancelBtn = new JLabel();
        cancelBtn.setIcon(new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\cancelButton.png"));
        cancelBtn.setBounds(15, 35, 55, 55);
        transactionPnl.add(cancelBtn);

        addVolumeEffects(transactionPnl);

        JLabel withdrawBtn = new JLabel();
        withdrawBtn.setIcon(
                new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\withdrawButton.png"));
        withdrawBtn.setBounds(690, 170, 365, 70);
        transactionPnl.add(withdrawBtn);

        JLabel depositBtn = new JLabel();
        depositBtn.setIcon(
                new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\depositButton.png"));
        depositBtn.setBounds(350, 170, 365, 70);
        transactionPnl.add(depositBtn);

        JLabel balanceBtn = new JLabel();
        balanceBtn.setIcon(
                new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\balanceButton.png"));
        balanceBtn.setBounds(350, 470, 365, 70);
        transactionPnl.add(balanceBtn);

        JLabel historyBtn = new JLabel();
        historyBtn.setIcon(
                new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\historyButton.png"));
        historyBtn.setBounds(690, 470, 365, 70);
        transactionPnl.add(historyBtn);

        JLabel bankTransferBtn = new JLabel();
        bankTransferBtn.setIcon(
                new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\bankTransferButton.png"));
        bankTransferBtn.setBounds(350, 320, 365, 70);
        transactionPnl.add(bankTransferBtn);

        JLabel payBillsBtn = new JLabel();
        payBillsBtn.setIcon(
                new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\paybillsButton.png"));
        payBillsBtn.setBounds(690, 320, 365, 70);
        transactionPnl.add(payBillsBtn);

        JLabel transactionBG = new JLabel();
        transactionBG.setIcon(
                new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\transactionBG.png"));
        transactionBG.setBounds(0, -15, 1050, 700);
        transactionPnl.add(transactionBG);

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
                    if (sounds.isUnmute) {
                        logIn.logInVolume.setIcon(
                                new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\unmute.png"));

                    } else {
                        logIn.logInVolume.setIcon(
                                new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\mute.png"));
                    }

                    transactionType = "";
                    logIn.transactionFrame.dispose();
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

        // For withdraw button and go to typeAccount frame
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

                // Set transaction
                transactionType = "Withdraw";

                // Update volume icon
                if (sounds.isUnmute) {
                    typeAccount.typeAccountVolume.setIcon(
                            new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\unmute.png"));

                } else {
                    typeAccount.typeAccountVolume.setIcon(
                            new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\mute.png"));
                }

                dispose();
                typeAccountFrame.show();

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                withdrawBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                withdrawBtn.setCursor(Cursor.getDefaultCursor());
            }
        });

        // For deposit button and go to typeAccount frame
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

                // Set transaction
                transactionType = "Deposit";

                // Update volume icon
                if (sounds.isUnmute) {
                    typeAccount.typeAccountVolume.setIcon(
                            new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\unmute.png"));

                } else {
                    typeAccount.typeAccountVolume.setIcon(
                            new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\mute.png"));
                }

                dispose();
                typeAccountFrame.show();

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                depositBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                depositBtn.setCursor(Cursor.getDefaultCursor());
            }
        });

        // For balance button and go to typeAccount frame
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

                // Set transaction
                transactionType = "Balance";

                // Update volume icon
                if (sounds.isUnmute) {
                    typeAccount.typeAccountVolume.setIcon(
                            new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\unmute.png"));

                } else {
                    typeAccount.typeAccountVolume.setIcon(
                            new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\mute.png"));
                }

                dispose();
                typeAccountFrame.show();

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                balanceBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                balanceBtn.setCursor(Cursor.getDefaultCursor());
            }
        });

        // For history button and go to transactional history frame
        historyBtn.addMouseListener(new MouseListener() {
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
                if (sounds.isUnmute) {
                    viewHistory.viewHistoryVolume.setIcon(
                            new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\unmute.png"));

                } else {
                    viewHistory.viewHistoryVolume.setIcon(
                            new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\mute.png"));
                }

                dispose();
                viewHistoryFrame.show();

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                historyBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                historyBtn.setCursor(Cursor.getDefaultCursor());
            }
        });

        // For bankTransfer button and go to transactBank frame
        bankTransferBtn.addMouseListener(new MouseListener() {
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
                transactionType = "Bank Transfer";

                // Update volume icon
                if (sounds.isUnmute) {
                    transactBank.transactBankVolume.setIcon(
                            new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\unmute.png"));

                } else {
                    transactBank.transactBankVolume.setIcon(
                            new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\mute.png"));
                }

                dispose();
                transactBankFrame.show();

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                bankTransferBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                bankTransferBtn.setCursor(Cursor.getDefaultCursor());
            }
        });

        // For bankTransfer button and go to transactBank frame
        payBillsBtn.addMouseListener(new MouseListener() {
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
                transactionType = "Pay Bills";

                // Update volume icon
                if (sounds.isUnmute) {
                    transactBills.transactBillsVolume.setIcon(
                            new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\unmute.png"));

                } else {
                    transactBills.transactBillsVolume.setIcon(
                            new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\mute.png"));
                }

                dispose();
                transactBillsFrame.show();

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                payBillsBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                payBillsBtn.setCursor(Cursor.getDefaultCursor());
            }
        });

    }

    // Add mute features
    private static void addVolumeEffects(JPanel panel) {
        transactionVolume.setIcon(
                new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\unmute.png"));
        transactionVolume.setBounds(980, 620, 40, 40);
        panel.add(transactionVolume);

        transactionVolume.addMouseListener(new MouseListener() {
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
                    transactionVolume.setIcon(
                            new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\mute.png"));

                    sounds.isUnmute = false;
                } else {
                    transactionVolume.setIcon(
                            new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\unmute.png"));
                    sounds.isUnmute = true;
                    sfx.playWarning();
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                transactionVolume.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                transactionVolume.setCursor(Cursor.getDefaultCursor());
            }
        });
    }

    public static void main(String[] args) {
        transaction a = new transaction();
        a.show();
    }

}
