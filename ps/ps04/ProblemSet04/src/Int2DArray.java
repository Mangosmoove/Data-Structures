import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Arinah Karim     ankarim
 * CSCI-C 343 / Fall 2020
 * 9/22/2020
 */
public class Int2DArray implements Int2DArrayADT {
    private int[][] arr;
    static final int min = -2147483648;
    static final int max = 2147483647;

    public Int2DArray(int row, int col){
        arr = new int[row][col];
        Random rand = new Random();
        int num = 0;
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                //credit to Brookylyn Gibbs for helping me out with this :D
                num = rand.nextInt();
                if(rand.nextBoolean()){
                    num = -1 * num;
                }
                arr[i][j] = num;
            }
        }
    }

    @Override
    public void getColumn(int colInd) {
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i][colInd] + " ");
        }
        System.out.print("\n");
    }

    @Override
    public void getRow(int rowInd) {
        for(int j = 0; j < arr[0].length; j++){
            System.out.print(arr[rowInd][j] + " ");
        }
        System.out.print("\n");
    }

    @Override
    public void set(int i, int j, int value) {
        arr[i][j] = value;
    }

    @Override
    public int get(int i, int j) {
        return arr[i][j];
    }

    @Override
    public void zeroArray() {
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[0].length; j++){
                arr[i][j] = 0;
            }
        }
    }

    @Override
    public String toString() {
        String result = "[";
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                result = result + "" + arr[i][j];
                if (j != arr[0].length - 1) {
                    result += ",";
                }
            }
            if (i < arr.length - 1) {
                result = result + "\n";
            }
        }
        return result + "]\n";
    }
}
