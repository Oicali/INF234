/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Main;
import settings.*;
import javax.swing.*;

public class FinalProject_ATM extends frames {
    
    // Global Variables
    static sounds sfx = new sounds();
    static logIn logInFrame = new logIn();
    
    // Generate and redesign the opening frame
    FinalProject_ATM(){
        super();

        JLabel intro = new JLabel();
        intro.setIcon(
                new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\Opening.gif"));
        intro.setBounds(-95, -15, 1244, 700);
        this.add(intro);

        // Set up a timer to close the frame after the GIF duration (in milliseconds)
        int gifDuration = 4300; 
        Timer timer = new Timer(gifDuration, e -> {
            this.dispose();

        });

        
        // Start the timer
        timer.setRepeats(false); // Set to false to execute only once
        timer.start();
    }

    
    // Open and go to next frame
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FinalProject_ATM openingFrame = new FinalProject_ATM();
            openingFrame.show();
            sfx.playOpening();
            
 
            openingFrame.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                    
                    logInFrame.show();
                    
                }
            });
        });
    }
    
}
