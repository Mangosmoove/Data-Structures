/**
 * Arinah Karim, ankarim
 * CSCI-C 343 / Fall 2020
 * 10/20/2020
 */
public class Knapsack {
    public boolean recursiveKnapsackSubsetSum(int[] set, int kSum){
        if (kSum == 0){
            return true;
        }
        else{
            for (int i = 0; i < set.length; i++){
                if (kSum - set[i] >= 0){
                    int[] tempSet = remove(set, set[i]);
                    if(recursiveKnapsackSubsetSum(tempSet, kSum - set[i])){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public int[] remove(int[] set, int num){
        int[] removedNum = new int[set.length - 1];
        int newIndex = 0;
        for (int i = 0; i < set.length; i++){
            if (num != set[i]){
                removedNum[newIndex] = set[i];
                newIndex++;
            }
        }
        return removedNum;
    }

    public boolean dynamicKnapsackSubsetSum(int[] set, int kSum){
        boolean[][] subset = new boolean[kSum + 1][set.length + 1];
        for (int i = 0; i <= set.length; i++){
            subset[0][i] = true;
        }
        for (int j = 1; j <= kSum; j++){
            subset[j][0] = false;
        }

        for (int i = 1; i <= kSum; i++){
            for (int j = 1; j <= set.length; j++){
                subset[i][j] = subset[i][j-1];
                if (i >= set[j-1]){
                    subset[i][j] = subset[i][j] || subset[i - set[j-1]][j-1];
                }
            }
        }
        return subset[kSum][set.length];
    }

    public static void main(String[] args){
        Knapsack k = new Knapsack();
        int[] set1 = {36, 42, 42, 39, 41, 12, 1, 21, 5, 22};
        int[] set2 = {39, 23, 8, 3, 25, 12, 34, 42, 36, 46};
        int[] set3 = {24, 1, 30, 5, 32, 34, 12, 6, 16, 1};

        System.out.println("Recursive testing...");
        System.out.println(k.recursiveKnapsackSubsetSum(set1, 141)); //true (36+42+42+21)
        System.out.println(k.recursiveKnapsackSubsetSum(set1, 11)); //false
        System.out.println(k.recursiveKnapsackSubsetSum(set2, 236)); //false
        System.out.println(k.recursiveKnapsackSubsetSum(set2, 74)); // true (39+23+12)
        System.out.println(k.recursiveKnapsackSubsetSum(set3, 39)); //true (34+5)
        System.out.println(k.recursiveKnapsackSubsetSum(set3, 15)); //false

        System.out.println();

        System.out.println("Dynamic testing...");
        System.out.println(k.dynamicKnapsackSubsetSum(set1, 141)); //true (36+42+42+21)
        System.out.println(k.dynamicKnapsackSubsetSum(set1, 11)); //false
        System.out.println(k.dynamicKnapsackSubsetSum(set2, 236)); //false
        System.out.println(k.dynamicKnapsackSubsetSum(set2, 74)); // true (39+23+12)
        System.out.println(k.dynamicKnapsackSubsetSum(set3, 39)); //true (34+5)
        System.out.println(k.dynamicKnapsackSubsetSum(set3, 15)); //false
    }
}