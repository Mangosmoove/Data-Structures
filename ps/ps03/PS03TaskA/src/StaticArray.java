/**
 * Arinah Karim, ankarim
 * CSCI-C 343 / Fall 2020
 * 9/14/2020
 */
public class StaticArray {
    private Integer[] arr;
    public StaticArray(Integer[] a){
        arr = new Integer[a.length];
        for (int i = 0; i < a.length; i++){
            arr[i] = a[i];
        }
    }

    public Integer removeAt(int index){
        Integer num = arr[index];
        arr[index] = null;
        return num;
    }

    //testing
//    public Integer[] getArr(){
//        return arr;
//    }

    public static void main(String[] args){
        Integer[] a = {1, 2, 3, 4, 5};
        StaticArray s = new StaticArray(a);
        s.removeAt(3);

        //testing
//        for (Integer i : s.getArr()){
//            System.out.println(" " + i);
//        }
    }
}
