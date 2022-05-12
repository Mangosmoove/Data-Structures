/**
 * Arinah Karim     ankarim
 * CSCI-C 343 / Fall 2020
 * 9/8/2020
 */
public class Int2DArray implements Int2DArrayADT {
    private int[][] arr;

    public Int2DArray(int[][]a){
        arr = new int[a.length][a[0].length];
        for (int i = 0; i < a.length; i++){
            for (int j = 0; j < a[0].length; j++){
                arr[i][j] = a[i][j];
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

    public static void main(String[] args){
        int[][] a = {{1, 2, 3, 4},
                    {5, 6, 7, 8},
                    {9, 10, 11, 12}};
        Int2DArray twoDee = new Int2DArray(a);

        System.out.println("Initial array:");
        System.out.print(twoDee.toString() + "\n");

        System.out.println("Number at row index 2, column index 1: "+twoDee.get(2, 1));
        System.out.println("Changing number at row index 2, column index 1 to 13...");
        twoDee.set(2,1,13);
        System.out.print(twoDee.toString() + "\n");
        System.out.println("Current value of number at indices(2, 1): " + twoDee.get(2,1));

        System.out.println("Number at indices (1, 3): "+twoDee.get(1, 3));
        System.out.println("Changing number at indies (1, 3) to 9...");
        twoDee.set(1,3,9);
        System.out.print(twoDee.toString());
        System.out.println("Number at indices (1, 3): " +twoDee.get(1, 3));

        System.out.println("\nRetrieving row data for row index 0...");
        twoDee.getRow(0);
        System.out.println("\nRetrieving row data for row index 1...");
        twoDee.getRow(1);
        System.out.println("\nRetrieving row data for row index 2...");
        twoDee.getRow(2);

        System.out.println("\nRetrieving column data for column index 0...");
        twoDee.getColumn(0);
        System.out.println("\nRetrieving column data for column index 1...");
        twoDee.getColumn(1);
        System.out.println("\nRetrieving column data for column index 2...");
        twoDee.getColumn(2);
        System.out.println("\nRetrieving column data for column index 3...");
        twoDee.getColumn(3);

        System.out.println("\nreinitializing array...");
        twoDee.zeroArray();
        System.out.print(twoDee.toString());

        System.out.println("\nnew data");
        int[][] a2 = {{1, 2},
                      {3, 4}};
        Int2DArray twoDee2 = new Int2DArray(a2);

        System.out.println("Initial array:");
        System.out.print(twoDee2.toString() + "\n");

        System.out.println("Current value at indices (1,1): " + twoDee2.get(1, 1));
        System.out.println("Changing value at indices (1, 1) to 5...");
        twoDee2.set(1,1,5);
        System.out.print(twoDee2.toString());
        System.out.println("Number at indices (1,1): " +twoDee2.get(1, 1));

        System.out.println("\nRetrieving row data for row index 0...");
        twoDee2.getRow(0);
        System.out.println("\nRetrieving row data for row index 1...");
        twoDee2.getRow(1);

        System.out.println("\nRetrieving column data for column index 0...");
        twoDee2.getColumn(0);
        System.out.println("\nRetrieving column data for column index 1...");
        twoDee2.getColumn(1);
    }
}
