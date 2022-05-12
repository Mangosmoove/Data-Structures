/**
 * Arinah Karim     ankarim
 * CSCI-C 343 / Fall 2020
 * 9/8/2020
 */
public interface Int2DArrayADT {
    //given column index, prints all column values
    public void getColumn(int colInd);

    //given row index, prints all row values
    public void getRow(int rowInd);

    //given the indices positions and what value is wanted, set the indices to right value
    public void set(int i, int j, int value);

    //return value at position i and j
    public int get(int i, int j);

    //reset array to 0
    public void zeroArray();
}
