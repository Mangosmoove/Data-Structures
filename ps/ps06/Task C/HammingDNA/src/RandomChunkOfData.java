/**
 * Arinah Karim, ankarim
 * CSCI-C 343 / Fall 2020
 * 10/6/2020, 8:28pm
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Random;

import static java.lang.System.out;

public class RandomChunkOfData {

    //generate a random DNA sequence of length n:
    public String nextDNA(int n){
        String lDNA = "";
        Random lRandomizer = new Random();

        for (int i = 0; i < n; i++){
            int j = lRandomizer.nextInt(4);
            if (j == 0) {
                lDNA += "A";
            }
            else if (j == 1){
                lDNA += "T";
            }
            else if (j == 2){
                lDNA += "C";
            }
            else if (j == 3){
                lDNA += "G";
            }
        }
        return lDNA;
    }

    //some client code for testing
    public static void main(String[] args) throws FileNotFoundException{
        RandomChunkOfData rndDNAGenerator = new RandomChunkOfData();
        HammingDNADistance ham = new HammingDNADistance();
        /*String dna;
        String dna2;
        //string length requirement
        int n = 0;
        long lTimeBefore;
        long lTimeAfter;
        long lElapsedNanoSeconds;
        //runs out of memeory at n = 32768
        for (n = 4; n <= 32768; n *= 2){
            out.println("length: " + n);
            lTimeBefore = System.nanoTime();
            dna = rndDNAGenerator.nextDNA(n);
            lTimeAfter = System.nanoTime();
            lElapsedNanoSeconds = (lTimeAfter - lTimeBefore);
            System.out.println("Time elapsed to generate DNA sequence1 in nanoseconds: " + lElapsedNanoSeconds);
            lTimeBefore = lTimeAfter = lElapsedNanoSeconds = 0;

            lTimeBefore = System.nanoTime();
            dna2 = rndDNAGenerator.nextDNA(n);
            lTimeAfter = System.nanoTime();
            lElapsedNanoSeconds = (lTimeAfter - lTimeBefore);
            System.out.println("Time elapsed to generate DNA sequence2 in nanoseconds: " + lElapsedNanoSeconds);
            lTimeBefore = lTimeAfter = lElapsedNanoSeconds = 0;

            //out.println("Sequence 1: " + dna + "\nSequence 2: " + dna2);

            lTimeBefore = System.nanoTime();
            out.println("Hamming distance for sequences: " + ham.hammingDistance(dna, dna2));
            lTimeAfter = System.nanoTime();
            lElapsedNanoSeconds = (lTimeAfter - lTimeBefore);
            System.out.println("Time elapsed for calculating hamming distance in nanoseconds: " + lElapsedNanoSeconds);
            lTimeBefore = lTimeAfter = lElapsedNanoSeconds = 0;

            lTimeBefore = System.nanoTime();
            out.println("Levenshtein distance for sequences: " + ham.levenshteinDistance(dna, dna2) + "\n");
            lTimeAfter = System.nanoTime();
            lElapsedNanoSeconds = (lTimeAfter - lTimeBefore);
            System.out.println("Time elapsed for calculating levenshtein distance in nanoseconds: " + lElapsedNanoSeconds);
            lTimeBefore = lTimeAfter = lElapsedNanoSeconds = 0;
        }*/
        String seq1 = "";
        File f1 = new File("flatland.txt");
        Scanner sc1 = new Scanner(f1);

        while(sc1.hasNextLine()){
            seq1 += sc1.nextLine();
            seq1 += " ";
        }
        sc1.close();

        String seq2 = "";
        File f2 = new File("flatlandASCII.txt");
        Scanner sc2 = new Scanner(f2);

        while(sc2.hasNextLine()){
            seq2 += sc2.nextLine();
            seq2 += " ";
        }
        sc2.close();

        out.println("Hamming distance for sequences: " + ham.hammingDistance(seq1, seq2) + "\n");
        out.println("Levenshtein distance for sequences: " + ham.levenshteinDistance(seq1, seq2) + "\n");
    }
}//end of class RandomChunkOfDNA