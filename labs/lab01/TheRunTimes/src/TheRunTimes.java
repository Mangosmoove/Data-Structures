/**
 * Arinah Karim     ankarim
 * CSCI-C 343 Fall 2020
 * August 30, 2020
 */

public class TheRunTimes {
    public static void main(String[] args){
        CalculateRunTimes runTimes = new CalculateRunTimes();
        int instructionCount1 = runTimes.countInstructions(10);
        int instructionCount2 = runTimes.countInstructions(100);
        int instructionCount3 = runTimes.countInstructions(1000);
        int instructionCount4 = runTimes.countInstructions(10000);

        System.out.println("Example 3:");
        System.out.println("n = " + 10 +"\t\tinstructioncounter = " + instructionCount1 + "\t\t(instructioncounter / n = " + instructionCount1 / 10 + ")");
        System.out.println("n = " + 100 +"\t\tinstructioncounter = " + instructionCount2 + "\t\t(instructioncounter / n = " + instructionCount2 / 100+ ")");
        System.out.println("n = " + 1000 +"\tinstructioncounter = " + instructionCount3 + "\t(instructioncounter / n = " + instructionCount3 / 1000+ ")");
        System.out.println("n = " + 10000 +"\tinstructioncounter = " + instructionCount4 + "\t(instructioncounter / n = " + instructionCount4 / 10000+ ")");

        instructionCount1 = instructionCount2 = instructionCount3 = instructionCount4 = 0;

        instructionCount1 = runTimes.countInstructions7(10);
        instructionCount2 = runTimes.countInstructions7(100);
        instructionCount3 = runTimes.countInstructions7(1000);
        instructionCount4 = runTimes.countInstructions7(10000);

        System.out.println("\nExample 7:");
        System.out.println("n = " + 10 +"\t\tinstructioncounter = " + instructionCount1 + "\t\t(instructioncounter / n = " + instructionCount1 / 10 + ")");
        System.out.println("n = " + 100 +"\t\tinstructioncounter = " + instructionCount2 + "\t\t(instructioncounter / n = " + instructionCount2 / 100+ ")");
        System.out.println("n = " + 1000 +"\tinstructioncounter = " + instructionCount3 + "\t(instructioncounter / n = " + instructionCount3 / 1000+ ")");
        System.out.println("n = " + 10000 +"\tinstructioncounter = " + instructionCount4 + "\t(instructioncounter / n = " + instructionCount4 / 10000+ ")");
    }
}