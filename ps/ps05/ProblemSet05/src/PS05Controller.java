/**
 * Arinah Karim, ankarim
 * CSCI-C 343 / Fall 2020
 * 11/14/2020
 */

import javax.swing.*;
import java.awt.image.ImageObserver;
import java.util.Observable;
import java.util.Observer;

public class PS05Controller implements Observer {
    private PS05Model model;
    private PS05View view;

    public PS05Controller(PS05Model m, PS05View v){
        model = m;
        view = v;
    }

    public void update(Observable o, Object arg){
        for (int i = 0; i < model.getWidth(); i++){
            for (int j = 0; j < model.getHeight(); j++){
                view.drawPoint(i, j, model.get(i, j));
            }
        }
    }

    public PS05Model getModel(){
        return model;
    }

    public static void main(String[] args){
        //instantiating objects of PS05Model & PS05VIEW
        PS05Model model = new PS05Model(1500, 1500);
        model.randomize();
        PS05View view = new PS05View(1500, 1500);
        PS05Controller controller = new PS05Controller(model, view);
        model.addObserver(controller);
        controller.getModel().sortArray1();
    }
}