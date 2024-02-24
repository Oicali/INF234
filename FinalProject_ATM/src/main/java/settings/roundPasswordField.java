/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package settings;

import javax.swing.*;
import java.awt.*;

public class roundPasswordField extends JPasswordField {

    private int arcWidth = 55;
    private int arcHeight = 55;
    private float opacity;

    public roundPasswordField(int columns, float opacity) {
        super(columns);
        this.opacity = opacity;
        setOpaque(false); // Make the component transparent
        setBackground(new Color(5, 38, 59)); // Set the background color
        setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10)); // Optional: Add padding
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int width = getWidth();
        int height = getHeight();

        // Draw the background with transparency
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacity));
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, width, height, arcWidth, arcHeight);

        // Set the transparency back to opaque for drawing text
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));
        super.paintComponent(g2);

        g2.dispose();
    }

    
    // Set the caret color to white
    @Override
    public Color getCaretColor() {
        return Color.WHITE; 
    }
}
