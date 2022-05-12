/**
 * Arinah Karim, ankarim
 * CSCI-C 343 / Fall 2020
 * 9/14/2020
 */
public class DynamicArray {
    private Integer[] arr;
    public DynamicArray(Integer[] a){
        arr = new Integer[a.length];
        for (int i = 0; i < a.length; i++){
            arr[i] = a[i];
        }
    }

    public Integer removeAt(int index){
        Integer num = arr[index];
        Integer[] newArr = new Integer[arr.length - 1];
        int newIndex = 0;
        for (int i = 0; i < arr.length; i++){
            if (index != i){
                newArr[newIndex] = arr[i];
                newIndex++;
            }
        }
        arr = newArr;
        return num;
    }

    //testing
//    public Integer[] getArr(){
//        return arr;
//    }

    public static void main(String[] args){
        Integer arr[] = {1, 2, 3, 4, 5};
        DynamicArray d = new DynamicArray(arr);
        d.removeAt(2);

        //testing
//        for (Integer i : d.getArr()){
//            System.out.println("" + i);
//        }
    }
}
