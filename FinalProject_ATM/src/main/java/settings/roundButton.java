package settings;
 
import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
 
public class roundButton extends JButton {
 
    // Global variables
    private int arcWidth = 45;
    private int arcHeight = 45;
    private Color color1;
    private Color color2;
    
    public roundButton(String text,Color color1a,Color color2a) {
        super(text);
        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorderPainted(false);
        this.color1 = color1a;
        this.color2 = color2a;
    }
 
    // Modify button shape and fill with gradient
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
 
        int width = getWidth();
        int height = getHeight();
 
        // Define the gradient colors
       // Color color1 = new Color(1,207, 22);
       // Color color2 = new Color(1,207, 22);; // You can change this to any color you want
 
        // Create a gradient paint
        GradientPaint gradient = new GradientPaint(0, 0, color1, width, height, color2);
 
        // Set the paint to the graphics context
        g2d.setPaint(gradient);
 
        // Fill the background with the gradient
        g2d.fill(new RoundRectangle2D.Double(0, 0, width, height, arcWidth, arcHeight));
 
        // Dispose of the graphics context
        g2d.dispose();
 
        super.paintComponent(g);
    }
 
}