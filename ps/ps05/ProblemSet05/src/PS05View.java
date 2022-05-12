import javax.swing.*;

/**
 * Arinah Karim, ankarim
 * CSCI-C 343, Fall 2020
 * 11/14/2020
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
    private int height;
    private int width;

    public PS05View(int h, int w){
        height = h;
        width = w;
        JFrame aJFrame = new JFrame();
        aJFrame.add(this);
        aJFrame.setSize(height, width);
        aJFrame.setVisible( true );
    }

    public void drawPoint(int x, int y, int value){
        Graphics g = this.getGraphics();
        Color c = new Color(0, 0, 0);

        if (value == -255){
            c = new Color(255, 0, 0);
        }
        else if (value <= -1){
            int abs = Math.abs(value);
            c = new Color(abs, 0, 0);
        }
        else if (value >= 0 && value <= 255){
            c = new Color(0, value, 0); //only way to make green show up for some reason
        }

        g.setColor(c);
        g.drawRect(x, y, 1, 1);
    }

    //makes entire thing black
    public void clear(){
        for (int i = 0; i < width; i++){
            for (int j = 0; j < height; j++){
                drawPoint(i, j, 0);
            }
        }
    }
}