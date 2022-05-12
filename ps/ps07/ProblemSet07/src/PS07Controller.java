import java.io.File;
import java.io.FileNotFoundException;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

/**
 * Arinah Karim, ankarim
 * CSCI-C 343 / Fall 2020
 * 10/13/2020
 */
public class PS07Controller implements Observer {
    private PS07Model model;
    private PS07View view;
    private int count;
    public PS07Controller(PS07Model m, PS07View v){
        model = m;
        view = v;
        count = 0;
    }
    public void update(Observable o, Object arg){
        String s1 = model.aString();
        String s2 = model.bString();

        //top row
        for (int i = 0; i < s1.length(); i++){
            if (s1.charAt(i) == 'a' || s1.charAt(i) == 'e' || s1.charAt(i) == 'i' || s1.charAt(i) == 'o' || s1.charAt(i) == 'u'){
                view.drawPoint(i, 0, 0, 255, 255);
            }
            else if (s1.charAt(i) == '.' || s1.charAt(i) == ' ' || s1.charAt(i) == ',' || s1.charAt(i) == '-' || s1.charAt(i) == '"' || s1.charAt(i) == ';'){
                view.drawPoint(i, 0, 255, 255, 255);
            }
            else{ //has to be consonant
                view.drawPoint(i, 0, 255, 0, 255);
            }
        }

        //left line
        for (int j = 0; j < s2.length(); j++){
            if (s2.charAt(j) == 'a' || s2.charAt(j) == 'e' || s2.charAt(j) == 'i' || s2.charAt(j) == 'o' || s2.charAt(j) == 'u'){
                view.drawPoint(0, j, 0, 255, 255);
            }
            else if (s2.charAt(j) == '.' || s2.charAt(j) == ' ' || s2.charAt(j) == ',' || s2.charAt(j) == '-' || s2.charAt(j) == '"' || s2.charAt(j) == ';'){
                view.drawPoint(0, j, 255, 255, 255);
            }
            else{ //has to be consonant
                view.drawPoint(0, j, 255, 0, 255);
            }
        }

        //go through each char in eLine and assign color
        char[] c = model.eLine(count);
        for(int i = 0; i < c.length; i++){
            if (c[i] == ' '){
                view.drawPoint(i, count, 0, 255, 0);
            }
            else if (c[i] == 'S'){
                view.drawPoint(i, count, 255, 255, 0);
            }
            else if (c[i] == 'D'){
                view.drawPoint(i, count, 255, 0, 0);
            }
            else if (c[i] == 'I'){
                view.drawPoint(i, count, 0, 0, 255);
            }
            //System.out.println("gets here");
            //color minimum int with black
            if (i == c.length - 1){
                int[] dL = model.dLine(count);
                int min = dL[0];
                int index = 0;

                for (int num = 1; num < dL.length; num++){
                    if (min > dL[num]){
                        min = dL[num];
                        index = num;
                    }
                }
                view.drawPoint(index, count, 0, 0, 0);
            }
        }
        count++;
    }

    public static void main(String[] args) throws FileNotFoundException {
        String seq1 = "";
        File f1 = new File("C:\\Users\\ankar\\Desktop\\C343\\ps\\ps07\\ProblemSet07\\src\\flatland.txt");
        Scanner sc1 = new Scanner(f1);
        System.out.println(seq1);

        while(sc1.hasNextLine()){
            seq1 += sc1.nextLine();
        }
        sc1.close();

        String seq2 = "";
        File f2 = new File("C:\\Users\\ankar\\Desktop\\C343\\ps\\ps07\\ProblemSet07\\src\\flatlandASCII.txt");
        Scanner sc2 = new Scanner(f2);

        while(sc2.hasNextLine()){
            seq2 += sc2.nextLine();
        }
        sc2.close();

        PS07Model model = new PS07Model(1366, 768);
        PS07View view = new PS07View(1400, 768);
        PS07Controller controller = new PS07Controller(model, view);
        model.addObserver(controller);
        model.dist(seq1, seq2);
    }
}