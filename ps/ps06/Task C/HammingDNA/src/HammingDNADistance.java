/**
 * Arinah Karim     ankarim
 * CSCI-C 343 Fall 2020
 * 10/6/2020, 8:51pm
 */

/**
 * have a method that takes two Strings (two DNA sequences) as the inputs, as generated
 * by the above RandomChunkOfDNA.java code.
 * compute the Hamming distance between the strings,
 * and return the Hamming distance between the strings.
 */
public class HammingDNADistance {
    public int hammingDistance(String sequence1, String sequence2) {
        int dist = 0;
        for (int i = 0; i < sequence1.length(); i++) {
            //use compare method in Character class to check each character in both sequences
            if (Character.compare(sequence1.charAt(i), sequence2.charAt(i)) != 0) {
                dist++;
            }
        }
        return dist;
    }

    public int levenshteinDistance(String sequence1, String sequence2){
        int[][] d = new int[sequence1.length() + 1][sequence2.length() + 1];
        int c = 0;

        for (int i = 0; i <= sequence1.length(); i++){
            d[i][0] = i;
        }
        for (int j = 0; j <= sequence2.length(); j++){
            d[0][j] = j;
        }

        for (int m = 1; m <= sequence1.length(); m++){
            for (int n = 1; n <= sequence2.length(); n++){
                if(sequence1.charAt(m-1) == sequence2.charAt(n-1)){
                    c = 0;
                }
                else{
                    c = 1;
                }
                d[m][n] = min(d[m-1][n] + 1, d[m][n-1] + 1, d[m-1][n-1] + c);
            }
        }
        return d[sequence1.length() - 1][sequence2.length() - 1];
    }

    private int min(int a, int b, int c){
        int min = a;
        if (min > b){
            min = b;
        }
        if (min > c){
            min = c;
        }
        return min;
    }
}
