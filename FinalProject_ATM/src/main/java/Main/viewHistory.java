/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import settings.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import javax.swing.border.Border;

public class viewHistory extends frames {

    // Global variables
    static JPanel transactionPanelContainer = new JPanel();
    static ArrayList<JPanel> transactionPanels = new ArrayList<>();
    static int maxTransactionPanels = 10;
    static sounds sfx = new sounds();
    static JLabel viewHistoryVolume = new JLabel();

    // Generate and redesign the transaction frame
    viewHistory() {
        super();

        JPanel viewHistoryPnl = new JPanel();
        viewHistoryPnl.setSize(1244, 700);
        viewHistoryPnl.setBackground(Color.BLACK);
        viewHistoryPnl.setLayout(null);
        this.add(viewHistoryPnl);

        JLabel lbl1 = new JLabel();
        lbl1.setText("Transaction History");
        lbl1.setFont(new Font("Source Sans Pro", Font.ITALIC + Font.BOLD, 30));
        lbl1.setHorizontalAlignment(JLabel.CENTER);
        lbl1.setForeground(new Color(255, 222, 89));
        lbl1.setBounds(290, 40, 450, 40);
        viewHistoryPnl.add(lbl1);

        transactionPanelContainer.setLayout(new BoxLayout(transactionPanelContainer, BoxLayout.Y_AXIS));
        transactionPanelContainer.setBackground(Color.WHITE);

        JScrollPane scrollPane = new JScrollPane(transactionPanelContainer);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBounds(138, 95, 762, 522);
        viewHistoryPnl.add(scrollPane, BorderLayout.CENTER); // Add scroll pane to center of frame

        // Add some dummy transactions for testing
        /*for (int i = 1; i <= 4; i++) {
            addTransactionPanel("Deposit", "Savings", "019485285028", "12/12/2024 22:22");
        }*/
        addVolumeEffects(viewHistoryPnl);

        JLabel cancelBtn = new JLabel();
        cancelBtn.setIcon(new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\cancelButton.png"));
        cancelBtn.setBounds(15, 35, 55, 55);
        viewHistoryPnl.add(cancelBtn);

        JLabel viewHistoryBG = new JLabel();
        viewHistoryBG.setIcon(new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\viewTransactionHistoryBG.png"));
        viewHistoryBG.setBounds(0, -15, 1050, 700);
        viewHistoryPnl.add(viewHistoryBG);

        /* Button functions starts here.. */
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
                int choice = JOptionPane.showConfirmDialog(null, "Do you want to return to transaction page?", "Return to Transaction", JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {

                    // Update volume icon
                    if (sounds.isUnmute) {
                        transaction.transactionVolume.setIcon(new ImageIcon(
                                "C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\unmute.png"));

                    } else {
                        transaction.transactionVolume.setIcon(new ImageIcon(
                                "C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\mute.png"));
                    }

                    transaction.viewHistoryFrame.dispose();
                    logIn.transactionFrame.show();

                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                cancelBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                cancelBtn.setIcon(new ImageIcon(
                        "C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\cancelButton2.png"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                cancelBtn.setCursor(Cursor.getDefaultCursor());
                cancelBtn.setIcon(new ImageIcon(
                        "C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\cancelButton.png"));
            }
        });

    }

    // Method to add a new transaction panel
    public static void addTransactionPanel(String type, String account, String refNo, String date, double amount, double balance) {
        JPanel transactionPanel = new JPanel();
        transactionPanel.setLayout(null);
        transactionPanel.setPreferredSize(new Dimension(759, 105));
        transactionPanel.setMaximumSize(new Dimension(759, 105));
        transactionPanel.setMinimumSize(new Dimension(759, 105));
        transactionPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));

        JLabel lbl1 = new JLabel();
        lbl1.setFont(new Font("Source Sans Pro", Font.BOLD, 22));
        lbl1.setHorizontalAlignment(JLabel.LEFT);
        lbl1.setForeground(Color.BLACK);
        lbl1.setBounds(20, 20, 400, 130);
        lbl1.setVerticalAlignment(SwingConstants.TOP);
        if (type.equals("Withdraw") && account.equals("Current")) {
            lbl1.setText("Withdraw from Current");
        } else if (type.equals("Withdraw") && account.equals("Savings")) {
            lbl1.setText("Withdraw from Savings");
        } else if (type.equals("Deposit") && account.equals("Current")) {
            lbl1.setText("Deposit to Current");
        } else if (type.equals("Deposit") && account.equals("Savings")) {
            lbl1.setText("Deposit to Savings");
        }
        transactionPanel.add(lbl1);

        JLabel lbl2 = new JLabel("Ref No.");
        lbl2.setFont(new Font("Source Sans Pro", Font.PLAIN, 15));
        lbl2.setHorizontalAlignment(JLabel.LEFT);
        lbl2.setForeground(Color.BLACK);
        lbl2.setBounds(20, 60, 400, 130);
        lbl2.setVerticalAlignment(SwingConstants.TOP);
        transactionPanel.add(lbl2);

        // Display Reference number
        JLabel lbl3 = new JLabel(refNo);
        lbl3.setFont(new Font("Source Sans Pro", Font.BOLD, 15));
        lbl3.setHorizontalAlignment(JLabel.LEFT);
        lbl3.setForeground(Color.BLACK);
        lbl3.setBounds(75, 60, 400, 130);
        lbl3.setVerticalAlignment(SwingConstants.TOP);
        transactionPanel.add(lbl3);

        // Display date of transaction
        JLabel lbl4 = new JLabel("|    " + date);
        lbl4.setFont(new Font("Source Sans Pro", Font.PLAIN, 15));
        lbl4.setHorizontalAlignment(JLabel.LEFT);
        lbl4.setForeground(Color.BLACK);
        lbl4.setBounds(200, 60, 400, 130);
        lbl4.setVerticalAlignment(SwingConstants.TOP);
        transactionPanel.add(lbl4);

        // Display transaction amount
        JLabel lbl5 = new JLabel();
        lbl5.setFont(new Font("Source Sans Pro", Font.BOLD, 22));
        lbl5.setHorizontalAlignment(JLabel.RIGHT);
        lbl5.setForeground(Color.BLACK);
        lbl5.setBounds(330, 20, 400, 130);
        lbl5.setVerticalAlignment(SwingConstants.TOP);
        if (type.equals("Withdraw")) {
            lbl5.setText("- ₱" + format.format(amount));
        } else if (type.equals("Deposit")) {
            lbl5.setText("+ ₱" + format.format(amount));
        }
        transactionPanel.add(lbl5);

        // Display balance
        JLabel lbl6 = new JLabel();
        lbl6.setFont(new Font("Source Sans Pro", Font.PLAIN, 15));
        lbl6.setHorizontalAlignment(JLabel.RIGHT);
        lbl6.setForeground(Color.BLACK);
        lbl6.setBounds(430, 60, 300, 130);
        lbl6.setVerticalAlignment(SwingConstants.TOP);
        lbl6.setText("₱" + format.format(balance));
        transactionPanel.add(lbl6);

        // Add the new panel to the container
        transactionPanelContainer.add(transactionPanel, 0);

        // Add the new panel to the transaction panels array
        transactionPanels.add(0, transactionPanel);

        // Remove the oldest transaction panel if the array exceeds the maximum size
        if (transactionPanels.size() > maxTransactionPanels) {
            JPanel removedPanel = transactionPanels.remove(transactionPanels.size() - 1); // Remove the last panel
            transactionPanelContainer.remove(removedPanel);
        }

        // Update the UI
        transactionPanelContainer.revalidate();
        transactionPanelContainer.repaint();

    }

    // Add mute features
    private static void addVolumeEffects(JPanel panel) {
        viewHistoryVolume.setIcon(
                new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\unmute.png"));
        viewHistoryVolume.setBounds(980, 620, 40, 40);
        panel.add(viewHistoryVolume);

        viewHistoryVolume.addMouseListener(new MouseListener() {
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
                    viewHistoryVolume.setIcon(new ImageIcon(
                            "C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\mute.png"));

                    sounds.isUnmute = false;
                } else {
                    viewHistoryVolume.setIcon(new ImageIcon(
                            "C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\unmute.png"));
                    sounds.isUnmute = true;
                    sfx.playWarning();
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                viewHistoryVolume.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                viewHistoryVolume.setCursor(Cursor.getDefaultCursor());
            }
        });
    }

    public static void main(String[] args) {
        viewHistory a = new viewHistory();
        a.show();

        // Add some dummy transactions for testing
        for (int i = 1; i <= 2; i++) {
            a.addTransactionPanel("Withdraw", "Savings", "019485285028", "12/12/2024 22:22", 100000, 5000);
        }

        // Add some dummy transactions for testing
        for (int i = 1; i <= 2; i++) {
            a.addTransactionPanel("Deposit", "Current", "019485285028", "12/12/2024 22:22", 15000, 50000);
        }

    }
}
