package settings;
 
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.RoundRectangle2D;
 
public class roundButton extends JButton {
 
    // Global variables
    private int arcWidth = 45;
    private int arcHeight = 45;
    private double border = 1;
    private double border2 = (border*2);
    private Color mainColor1;
    private Color mainColor2;
    private Color subColor1= (Color.WHITE);
    private Color subColor2= (Color.WHITE);
    private Color temp1;
    private Color temp2;
    public Color fColor1 = (Color.WHITE);
    public Color fColor2 = (Color.WHITE);
    public roundButton(String text,Color color1a,Color color2a,Color color1b, Color color2b) {
        super(text);
        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorderPainted(false);
        setForeground(fColor1);
        this.mainColor1 = color1a;
        this.mainColor2 = color2a;
        this.subColor1 = color1b;
        this.subColor2 = color2b;
        temp1 = mainColor1;    
        temp2 = mainColor2; 
    this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }
 
            @Override
            public void mousePressed(MouseEvent e) {
            setForeground(fColor1);
            }
 
            @Override
            public void mouseReleased(MouseEvent e) {
            setForeground(fColor2);    
            }
            @Override
            public void mouseEntered(MouseEvent e) {
            temp1 = subColor1;    
            temp2 = subColor2;
            setForeground(fColor2);
            }
 
            @Override
            public void mouseExited(MouseEvent e) {
            temp1 = mainColor1;    
            temp2 = mainColor2;
            setForeground(fColor1);
            }
       });    
    }
    // Modify button shape and fill with gradient
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        int width = getWidth();
        int height = getHeight();
 
        // Create a gradient paint
        GradientPaint gradient = new GradientPaint(0, 0, temp1, width, height, temp2);        
        //outline
        g2d.setPaint(Color.LIGHT_GRAY);
        g2d.fill(new RoundRectangle2D.Double(0, 0, width, height, arcWidth, arcHeight));
        //fill
        g2d.setPaint(gradient);
        g2d.fill(new RoundRectangle2D.Double(border, border, (width-border2), (height-border2), arcWidth, arcHeight));
 
        // Dispose of the graphics context
        g2d.dispose();
 
        super.paintComponent(g);
    }
 
}