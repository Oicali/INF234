/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package settings;

import javax.swing.*;
import java.awt.*;

public class roundPasswordField extends JPasswordField {
    
    // Global variables
    private int arcWidth = 15;
    private int arcHeight = 15;

    
    public roundPasswordField(int columns) {
        super(columns);
        setOpaque(false);
        setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10)); // Optional: Add padding
    }

    
    // Modify password field shape
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int width = getWidth();
        int height = getHeight();

        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, width, height, arcWidth, arcHeight);

        super.paintComponent(g2);

        g2.dispose();
    }
}