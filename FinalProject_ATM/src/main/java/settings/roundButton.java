/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package settings;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class roundButton extends JButton {
    
    // Global variables
    private int arcWidth = 45;
    private int arcHeight = 45;
    public Color c1 = getBackground();
    private float hsbVals[] = Color.RGBtoHSB( c1.getRed(), c1.getGreen(), c1.getBlue(), null );
    public Color highlight = c1.getHSBColor( hsbVals[0], hsbVals[1], 0.5f * ( 1f + hsbVals[2] ));

    
    public roundButton(String text) {
        super(text);
        setContentAreaFilled(false);
        setFocusPainted(false); 
        setBorderPainted(false); 
        setBackground(Color.GREEN);
    }

    
    // Modify button shape
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setColor(getBackground());
        g2d.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), arcWidth, arcHeight));
        super.paintComponent(g2d);
        //g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.dispose();
    }

}