import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Arinah Karim, ankarim
 * CSCI-C 343 / Fall 2020
 * 10/13/2020
 */
public class PS07View extends JComponent {
    private int width; //1366
    private int height; //768
    JFrame frame;

    public PS07View(int w, int h){
        width = w;
        height = h;
        frame = new JFrame();
        frame.add(this);
        frame.setSize(width, height);
        frame.setVisible(true);
    }

    public void drawPoint(int x, int y, int r, int g, int b){
        if (r < 0)
            r = 0;
        if (r > 255)
            r = 255;

        if (g < 0)
            g = 0;
        if (g > 255)
            g = 255;

        if (b < 0)
            b = 0;
        if (b > 255)
            b = 255;

        Graphics graphics = this.getGraphics();
        Color c = new Color(r, g, b);
        graphics.setColor(c);
        graphics.drawRect(x, y, 1, 1);
    }

    public void clear(){
        Graphics g = this.getGraphics();
        g.setColor(new Color(127, 127, 127));
        g.drawRect(0,0, width, height);
        g.fillRect(0, 0, width, height);
    }
}