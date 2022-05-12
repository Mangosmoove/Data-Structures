/**
 * Arinah Karim, ankarim
 * CSCI-C 343 / Fall 2020
 * 10/17/2020
 */

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
        view.clear();
        for (int i = 0; i < model.getWidth(); i++){
            view.drawPoint(i, model.get(i));
        }
    }

    public static void main(String[] args){
        PS05Model model = new PS05Model(1366, 768);
        model.randomize();
        PS05View view = new PS05View(1366, 768);
        PS05Controller controller = new PS05Controller(model, view);
        model.addObserver(controller);
        model.sortArray();
    }
}