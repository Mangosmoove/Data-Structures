import javax.swing.*;

/**
 * Arinah Karim, ankarim
 * CSCI-C 343, Fall 2020
 * 10/17/2020
 */

// explicit import of every Java class we use from the AWT package:
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Shape;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

// explicit import of every Java class we use from the Swing package:
import javax.swing.JComponent;
import javax.swing.JFrame;

//   extend JComponent to draw into a Graphics object, and
//   implement ActionListener to periodically repaint the Graphics object.
public class PS05View extends JComponent {
    JFrame frame;
    private int width;
    private int height;

    public PS05View(int w, int h){
        width = w;
        height = h;
        frame = new JFrame();
        frame.add(this);
        frame.setSize(width, height);
        frame.setVisible(true);
    }

    public void drawPoint(int x, int value){
        Graphics g = this.getGraphics();
        Color c = new Color(22, 0, 255);
        g.setColor(c);
        g.drawRect(x, height - value, 1, value);
        g.fillRect(x, height - value, 1, value);
    }


    //makes entire thing black
    public void clear(){
        Graphics g = this.getGraphics();
        g.setColor(new Color(0, 0, 0));
        g.drawRect(0,0, width, height);
        g.fillRect(0, 0, width, height);
    }
}