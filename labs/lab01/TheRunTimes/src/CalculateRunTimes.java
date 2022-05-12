import java.util.Random;

/**
 * Arinah Karim     ankarim
 * CSCI-C 343 Fall 2020
 * August 30, 2020
 * Counting instructions
 */
public class CalculateRunTimes {
    
    //takes in size n for each example run
    public int countInstructions(int n){
        int counter3 = 0;
        int sum3 = 0;

        counter3 += 4;          //creating variables and assigning them to 0

        for (int i = 1; i <= n; i++){
            counter3++;         //instantiation for step 1, incrementation for others that follow
            counter3++;         //condition check
            for (int j = 1; j <= i; j++) {
                counter3++;     //instantiation for step 1, incrementation for all other steps
                counter3++;     //condition check

                sum3++;
                counter3++;     //incrementing sum3
            }
            counter3++;         //when j is incremented but doesn't pass condition check
        }
        counter3++;             //if incrementation occurs but doesn't pass condition check

        counter3++;             //return statement
        return counter3;
    }

    public int countInstructions7(int n){
        int counter7 = 0;
        counter7++;             //creating variable
        counter7++;             //assigning variable to 0

        Random rand = new Random();
        counter7++;             //creating instance of Random

        int gen = 0; //2 steps
        int [] a = new int[n+1]; //3 steps: making array variable, adding 1 to n, assigning to array
        int [] b = new int[n+1]; //3
        int[][] d = new int[a.length][b.length]; //4
        int c = 0; //2
        counter7 += 14;

        for (int i = 0; i < a.length; i++){
            counter7++;         //instantiation for step 1, incrementation for others that follow
            counter7++;         //conditional check

            gen = rand.nextInt(100);
            counter7++;         //creating variable
            counter7++;         //getting a random int val
            counter7++;         //assigning int val to variable

            a[i] = gen;
            counter7++;         //access array a at i
            counter7++;         //assigning value to position i in array a
        }
        counter7++;             //if incrementation occurs but doesn't pass condition check

        for (int j = 0; j < b.length; j++){
            counter7++;         //instantiation for step 1, incrementation for others that follow
            counter7++;         //conditional check

            counter7++;         //creating variable
            counter7++;         //getting a random int val
            counter7++;         //assigning int val to variable

            b[j] = gen;
            counter7++;         //access array b at i
            counter7++;         //assigning value to position i in array b
        }
        counter7++;             //if incrementation occurs but doesn't pass condition check

        for (int i = 1; i < a.length; i++) {
            counter7++;         //instantiation for step 1, incrementation for next steps
            counter7++;         //conditional check
            for (int j = 1; j < b.length; j++) {
                counter7++;     //instantiation, then incrementation for subsequent steps
                counter7++;     //conditional check

                //we were told over the discord server that we don't need to worry about counting the if statements
                if (a[i] == b[j]) {
                    c = 0;
                } else {
                    c = 1;
                }

                int min1 = Math.min(d[i - 1][j] + 1, d[i][j - 1] + 1);
                counter7++;     //creating variable
                counter7++;     //doing the Math.min function
                counter7++;     //assigning value

                int min2 = Math.min(min1, d[i - 1][j - 1] + c);
                counter7++;     //creating variable
                counter7++;     //doing the Math.min function
                counter7++;     //assigning value

                d[i][j] = min2;
                counter7++;     //accessing d[i][j]
                counter7++;     //assigning position to min2
            }
            counter7++;         //if incrementation occurs but doesn't pass condition check
        }
        counter7++;             //if incrementation occurs but doesn't pass condition check

        counter7++;             //return statement
        return counter7;
    }
}