import java.util.Observable;
import java.util.Random;

/**
 * Arinah Karim, ankarim
 * CSCI-C 343 / Fall 2020
 * 10/17/2020
 */

//store 2D array of integers, size = width x height
public class PS05Model extends Observable {
    private int width; //column
    private int height; //row
    private int[] values;

    //object is created with width x height in pixels
    public PS05Model(int w, int h){
        width = w;
        height = h;
        values = new int[width];
    }

    //returns 1D array
    public int[] getArray(){
        return values;
    }

    //randomizes the content of the 1D array between max and min
    public void randomize(){
        Random rand = new Random();
        int gen;

        for (int i = 0; i < width; i++){
            gen = rand.nextInt(height) ;
            values[i] = gen;
        }
    }

    private void sortRows(){
        for (int i = 0; i < values.length - 1; i++){
            for (int j = 0; j < values.length - i - 1; j++){
                if (values[j] > values[j+1]){
                    int temp = values[j];
                    values[j] = values[j+1];
                    values[j+1] = temp;
                }
                setChanged();
                this.notifyObservers(this);
            }
        }
    }

    public int get(int i){
        return values[i];
    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }

    public void sortArray(){
        sortRows();
    }

/*public static void main(String[] args) {
        PS05Model model = new PS05Model(1366, 768);
        model.randomize();
*//*        for (int i : model.getArray()){
            System.out.println(i);
        }*//*
        System.out.println("sorted");
        model.sortRows();
        int count= 0;
        for (int i : model.getArray()){
            System.out.println(i);
            count++;
        }
        System.out.println(count);
    }*/
}