/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package settings;

import Main.*;
import java.awt.*;
import javax.swing.*;

public class splashScreen extends JFrame {
    public static JProgressBar bar = new JProgressBar();
    JPanel Pnl = new JPanel();
    ImageIcon image = new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\Logo.png");
    
    public splashScreen(){
        
        this.setResizable(false);
        this.setSize(700, 400);
        this.setUndecorated(true);
        this.setLayout(null);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(false);
        this.setIconImage(image.getImage());
        
        Pnl.setSize(700, 400);
        Pnl.setBackground(Color.BLACK);
        Pnl.setLayout(null);
        this.add(Pnl);
        
        bar.setValue(0);
        bar.setBounds(170, 225, 350, 7);
        bar.setStringPainted(false);
        bar.setBackground(Color.GRAY);
        bar.setForeground(Color.WHITE);
        Pnl.add(bar);
        
        JLabel lbl1 = new JLabel ("Processing");
        lbl1.setFont(new Font("Source Sans Pro", Font.BOLD, 18));
        lbl1.setHorizontalAlignment(JLabel.CENTER);
        lbl1.setBounds(170, 250, 350, 25);
        lbl1.setForeground(Color.GRAY);
        Pnl.add(lbl1);
        
        JLabel BG = new JLabel();
        BG.setIcon(
                new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\splashScreen.gif"));
        BG.setBounds(0, 0, 700, 400);
        Pnl.add(BG);
        
    }
    
    public static void fill(Runnable onFillComplete) {
        Thread thread = new Thread(new Runnable() {
            public void run() {
                int counter = 0;
                while (counter <= 100) {
                    bar.setValue(counter);
                    try {
                        Thread.sleep(75);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    counter += 1;
                }

                // After filling is complete, execute the callback
                onFillComplete.run();
            }
        });
        thread.start();
    }

}

    
    /*public static void main (String[]args){
        splashScreen a = new splashScreen();
        a.show();
        a.fill();
        a.dispose();
        
       
    }*/
