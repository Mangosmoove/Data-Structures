import java.awt.image.ImageObserver;
import java.util.Observable;
import java.util.Random;

/**
 * Arinah Karim, ankarim
 * CSCI-C 343 / Fall 2020
 * 11/14/2020
 */

//store 2D array of integers, size = width x height
public class PS05Model extends Observable {
    private int width; //column
    private int height; //row
    private int[][] values;
    private static int min = -255;
    private static int max = 255;

    //object is created with width x height in pixels
    public PS05Model(int w, int h){
        width = w;
        height = h;
        values = new int[height][width];
    }

    //returns 2D array
    public int[][] getArray(){
        return values;
    }

    //randomizes the content of the 2D array between max and min
    public void randomize(){
        Random rand = new Random();
        int gen;

        for (int i = 0; i < height; i++){
            for (int j = 0; j < width; j++){
                gen = rand.nextInt(520) - 255;
                values[i][j] = gen;
            }
        }
    }

    private void sortColumns(){
        //to store a single column
        int[] newArr;

        for (int i = 0; i < width; i++){ //go through columns
            newArr = new int[height];
            for (int j = 0; j < height; j++){ //at certain column, check it's row elements
                newArr[j] = values[j][i];
            }

            //bubble sort 1D array so everything will be in the right order
            for (int k = 0; k < newArr.length - 1; k++){
                for (int m = 0; m < newArr.length - k - 1; m++){
                    if(newArr[m] > newArr[m+1]){
                        int swap = newArr[m];
                        newArr[m] = newArr[m+1];
                        newArr[m+1] = swap;
                    }
                }
            }

            //now have the order of numbers in newArr be the right column order of values
            for (int z = 0; z < newArr.length; z++) {
                values[z][i] = newArr[z];
            }
        }
        setChanged();
        this.notifyObservers(this);
    }

    private void sortRows(){
        //to store a single row
        int[] newArr;

        for (int i = 0; i < height; i++){ //go through rows
            newArr = new int[width];
            for (int j = 0; j < width; j++){ //at certain row, check it's column elements
                newArr[j] = values[i][j];
            }

            //bubble sort 1D array so everything will be in the right order
            for (int k = 0; k < newArr.length - 1; k++){
                for (int m = 0; m < newArr.length - k - 1; m++){
                    if(newArr[m] > newArr[m+1]){
                        int swap = newArr[m];
                        newArr[m] = newArr[m+1];
                        newArr[m+1] = swap;
                    }
                }
            }

            //now have the order of numbers in newArr be the right column order of values
            for (int z = 0; z < newArr.length; z++) {
                values[i][z] = newArr[z];
            }
        }
        setChanged();
        this.notifyObservers(this);
    }

    public void sortArray1(){
        sortColumns();
        sortRows();
    }

    public void sortArray2(){
        sortRows();
        sortColumns();
    }

    public int get(int i, int j){
        return values[i][j];
    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }

 /* //client code
    public static void main(String[] args) {
        PS05Model model = new PS05Model(2000, 2800);
        model.randomize();
        long lTimeBefore = System.nanoTime();
        model.sortArray1();
        long lTimeAfter = System.nanoTime();
        long lElapsedNanoSeconds = (lTimeAfter - lTimeBefore);
        System.out.println(lElapsedNanoSeconds); //30174566200
        *//*long lTimeBefore = System.nanoTime();
        model.sortArray2();
        long lTimeAfter = System.nanoTime();
        long lElapsedNanoSeconds = (lTimeAfter - lTimeBefore);
        System.out.println(lElapsedNanoSeconds); //30116332700 *//*
    } */
}