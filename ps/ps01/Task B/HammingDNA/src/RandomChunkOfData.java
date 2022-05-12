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
    public static void main(String[] argv){
        RandomChunkOfData rndDNAGenerator = new RandomChunkOfData();
        HammingDNADistance ham = new HammingDNADistance();
        String dna;
        String dna2;
        //string length requirement
        int n = 100;
	
	//3 different comparisons
        for (int comparisons = 1; comparisons < 4; comparisons++){
            out.println("");
            dna = rndDNAGenerator.nextDNA(n);
            dna2 = rndDNAGenerator.nextDNA(n);
            out.println("Sequence 1: " + dna + "\nSequence 2: " + dna2);
            out.println("Hamming distance for sequences: " + ham.hammingDistance(dna, dna2) + "\n");
        }
    }
}//end of class RandomChunkOfDNA