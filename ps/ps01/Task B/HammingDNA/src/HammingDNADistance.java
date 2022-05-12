/**
 * Arinah Karim     ankarim
 * CSCI-C 343 Fall 2020
 * August 30, 2020
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
}
