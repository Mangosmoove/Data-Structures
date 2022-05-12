import java.util.Random;

/**
 * Arinah Karim, ankarim
 * CSCI-C 343 / Fall 2020
 * 10/24/2020
 */
public class HW05CountingSort {
    //given an Array a, sort it through Counting Sort
    public int[] countingSort(int[] a){
        int[] sorted = new int[a.length]; //the final, sorted array to be returned

        int max = a[0]; //assigning the max element in given Array a at index 0
        for (int i = 1; i < a.length; i++){ //looping through entire Array a to make sure max is assigned properly
            if (max < a[i]){ //checks whether or not max is the largest element in the Array a
                max = a[i]; //assigns max to Array a at index i if the condition above is true
            }
        }

        int[] intermediate = new int[max+1]; //creating an intermediate array of length max
        for (int i = 0; i < a.length; i++){ //counting the number of records for each key value
            int index = a[i]; //storing value at Array a at index i into a variable
            intermediate[index] += 1; //increment the count at index array[i] by one
        }

        for (int i = 1; i < intermediate.length; i++){ //turning Array intermediate into a look-up table
            intermediate[i] += intermediate[i-1]; //increment based on previous index value
        }

        for (int i = a.length - 1; i >= 0; i--){ //traverse through Array a using created look-up table to sort Array a
            int aVal = a[i]; //store the value at Array a at index i
            //use aVal to find number in index i in intermediate, then pre-decrement it to the find
            //the index to place aVal
            sorted[--intermediate[aVal]] = a[i];
        }
        return sorted; //return the sorted version of Array a
    }

    public static void main(String[] args){ //driver of HW05CountingSort class
        HW05CountingSort countingSortTester = new HW05CountingSort(); //create instance of HW05CountingSort

        //test case 1
        int[] testArr = new int[100]; //create an Array of 100 ints
        Random rand = new Random(); //create instance of Random class

        for (int i = 0; i < testArr.length; i++){ //loop through testArr and assign it random ints
            //found max integer key value: 537410164
            //int randNum = rand.nextInt(537410164);
            int randNum = rand.nextInt(100); //create a variable to store the randomly generated number btwn 0-100
            testArr[i] = randNum; //store random int generated into index i in testArr
        }
        System.out.println("Unsorted array:"); //printing out unsorted array
        System.out.print("["); //printing out unsorted array
        for (int i = 0; i < testArr.length; i++){ //loop through each int in array
            if (i != testArr.length - 1){ //condition check if the int isn't the last item in the array
                System.out.print(testArr[i] + ", "); //print out the number followed by a comma
            }
            else{ //condition check if the int is the last item in the array
                System.out.print(testArr[i] + "]\n"); //print out the last number followed by closing brace
            }
        }

        testArr = countingSortTester.countingSort(testArr); //use class instance to make method call to countingSort
        System.out.println("Sorted array:"); //printing out sorted array
        System.out.print("["); //printing out sorted array
        for (int i = 0; i < testArr.length; i++){ //loop through each int in array
            if (i != testArr.length - 1){ //condition check if the int isn't the last item in the array
                System.out.print(testArr[i] + ", "); //print out the number followed by a comma
            }
            else{ //condition check if the int is the last item in the array
                System.out.print(testArr[i] + "]\n"); //print out the last number followed by closing brace
                System.out.println("max key: " + testArr[i]); //print out max key
            }
        }
        System.out.println(); //for spacing

        //test case 2
        int[] testArr2 = new int[rand.nextInt(200)]; //create another test array w/ length between 0 - 200
        for (int i = 0; i < testArr2.length; i++){ //loop through testArr2 and assign it random ints
            int randNum = rand.nextInt(200); //create a variable to store the randomly generated number btwn 0-200
            testArr2[i] = randNum; //store random int generated into index i in testArr2
        }
        System.out.println("Unsorted array:");
        System.out.print("["); //printing out unsorted array
        for (int i = 0; i < testArr2.length; i++){ //loop through each int in array
            if (i != testArr2.length - 1){ //condition check if the int isn't the last item in the array
                System.out.print(testArr2[i] + ", "); //print out the number followed by a comma
            }
            else{ //condition check if the int is the last item in the array
                System.out.print(testArr2[i] + "]\n"); //print out the last number followed by closing brace
            }
        }

        testArr2 = countingSortTester.countingSort(testArr2); //use class instance to make method call to countingSort
        System.out.println("Sorted array:"); //printing out sorted array
        System.out.print("["); //printing out sorted array
        for (int i = 0; i < testArr2.length; i++){ //loop through each int in array
            if (i != testArr2.length - 1){ //condition check if the int isn't the last item in the array
                System.out.print(testArr2[i] + ", "); //print out the number followed by a comma
            }
            else{ //condition check if the int is the last item in the array
                System.out.print(testArr2[i] + "]\n"); //print out the last number followed by closing brace
                System.out.println("max key: " + testArr2[i]); //print out max key
            }
        }
        System.out.println(); //for spacing

        //test case 3
        int[] testArr3 = new int[rand.nextInt(400)]; //create another test array w/ length between 0 - 400
        for (int i = 0; i < testArr3.length; i++){ //loop through testArr3 and assign it random ints
            int randNum = rand.nextInt(400); //create a variable to store the randomly generated number btwn 0-400
            testArr3[i] = randNum; //store random int generated into index i in testArr3
        }
        System.out.println("Unsorted array:");
        System.out.print("["); //printing out unsorted array
        for (int i = 0; i < testArr3.length; i++){ //loop through each int in array
            if (i != testArr3.length - 1){ //condition check if the int isn't the last item in the array
                System.out.print(testArr3[i] + ", "); //print out the number followed by a comma
            }
            else{ //condition check if the int is the last item in the array
                System.out.print(testArr3[i] + "]\n"); //print out the last number followed by closing brace
            }
        }

        testArr3 = countingSortTester.countingSort(testArr3); //use class instance to make method call to countingSort
        System.out.println("Sorted array:"); //printing out sorted array
        System.out.print("["); //printing out sorted array
        for (int i = 0; i < testArr3.length; i++){ //loop through each int in array
            if (i != testArr3.length - 1){ //condition check if the int isn't the last item in the array
                System.out.print(testArr3[i] + ", "); //print out the number followed by a comma
            }
            else{ //condition check if the int is the last item in the array
                System.out.print(testArr3[i] + "]\n"); //print out the last number followed by closing brace
                System.out.println("max key: " + testArr3[i]); //print out max key
            }
        }
        System.out.println(); //for spacing

        //test case 4
        int[] testArr4 = new int[rand.nextInt(800)]; //create another test array w/ length between 0 - 800
        for (int i = 0; i < testArr4.length; i++){ //loop through testArr4 and assign it random ints
            int randNum = rand.nextInt(800); //create a variable to store the randomly generated number btwn 0-800
            testArr4[i] = randNum; //store random int generated into index i in testArr4
        }
        System.out.println("Unsorted array:");
        System.out.print("["); //printing out unsorted array
        for (int i = 0; i < testArr4.length; i++){ //loop through each int in array
            if (i != testArr4.length - 1){ //condition check if the int isn't the last item in the array
                System.out.print(testArr4[i] + ", "); //print out the number followed by a comma
            }
            else{ //condition check if the int is the last item in the array
                System.out.print(testArr4[i] + "]\n"); //print out the last number followed by closing brace
            }
        }

        testArr4 = countingSortTester.countingSort(testArr4); //use class instance to make method call to countingSort
        System.out.println("Sorted array:"); //printing out sorted array
        System.out.print("["); //printing out sorted array
        for (int i = 0; i < testArr4.length; i++){ //loop through each int in array
            if (i != testArr4.length - 1){ //condition check if the int isn't the last item in the array
                System.out.print(testArr4[i] + ", "); //print out the number followed by a comma
            }
            else{ //condition check if the int is the last item in the array
                System.out.print(testArr4[i] + "]\n"); //print out the last number followed by closing brace
                System.out.println("max key: " + testArr4[i]); //print out max key
            }
        }
        System.out.println(); //for spacing

        //test case 5
        int[] testArr5 = new int[rand.nextInt(1600)]; //create another test array w/ length between 0 - 1600
        for (int i = 0; i < testArr5.length; i++){ //loop through testArr5 and assign it random ints
            int randNum = rand.nextInt(1600); //create a variable to store randomly generated number btwn 0-1600
            testArr5[i] = randNum; //store random int generated into index i in testArr5
        }
        System.out.println("Unsorted array:"); //printing out unsorted array
        System.out.print("["); //printing out unsorted array
        for (int i = 0; i < testArr5.length; i++){ //loop through each int in array
            if (i != testArr5.length - 1){ //condition check if the int isn't the last item in the array
                System.out.print(testArr5[i] + ", "); //print out the number followed by a comma
            }
            else{ //condition check if the int is the last item in the array
                System.out.print(testArr5[i] + "]\n"); //print out the last number followed by closing brace
            }
        }

        testArr5 = countingSortTester.countingSort(testArr5); //use class instance to make method call to countingSort
        System.out.println("Sorted array:"); //printing out sorted array
        System.out.print("["); //printing out sorted array
        for (int i = 0; i < testArr5.length; i++){ //loop through each int in array
            if (i != testArr5.length - 1){ //condition check if the int isn't the last item in the array
                System.out.print(testArr5[i] + ", "); //print out the number followed by a comma
            }
            else{ //condition check if the int is the last item in the array
                System.out.print(testArr5[i] + "]\n"); //print out the last number followed by closing brace
                System.out.println("max key: " + testArr5[i]); //printing out max key
            }
        }
        System.out.println(); //for spacing

        //case where max key value breaks program
        /*
        int[] breakTest = new int[rand.nextInt(20)]; //creating an array of 20 ints
        for (int i = 0; i < breakTest.length; i++){ //loop through breakTest and assign it random ints
            int randNum = rand.nextInt(537410164); //create a variable to store random num generated between 0-537410164
            breakTest[i] = randNum; //store random int generated into index i in breakTest
        }
        System.out.println("Unsorted array:"); //printing out unsorted array
        System.out.print("["); //printing out unsorted array
        for (int i = 0; i < breakTest.length; i++){ //loop through each int in array
            if (i != breakTest.length - 1){ //condition check if the int isn't the last item in the array
                System.out.print(breakTest[i] + ", "); //print out the number followed by a comma
            }
            else{ //condition check if the int is the last item in the array
                System.out.print(breakTest[i] + "]\n"); //print out the last number followed by closing brace
            }
        }

        breakTest = countingSortTester.countingSort(breakTest); //use class instance to make method call to countingSort
        System.out.println("Sorted array:"); //printing out sorted array
        System.out.print("["); //printing out sorted array
        for (int i = 0; i < breakTest.length; i++){ //loop through each int in array
            if (i != breakTest.length - 1){ //condition check if the int isn't the last item in the array
                System.out.print(breakTest[i] + ", "); //print out the number followed by a comma
            }
            else{ //condition check if the int is the last item in the array
                System.out.print(breakTest[i] + "]\n"); //print out the last number followed by closing brace
                System.out.println("max key: " + breakTest[i]); //print out max key
            }
        } */
    }
}