import java.util.Observable;

/**
 * Arinah Karim, ankarim
 * CSCI-C 343 / Fall 2020
 * 10/13/2020
 */
public class PS07Model extends Observable {
    private int width;
    private int height;
    private int[][] d;
    private char[][] e;
    String str1;
    String str2;
    public PS07Model(int w, int h){
        width = w;
        height = h;
    }

    public int dist(String s1, String s2){
        str1 = s1;
        str2 = s2;
        d = new int[s1.length() + 1][s2.length() + 1];
        e = new char[s1.length() + 1][s2.length() + 1];
        int c = 0;

        for (int i = 0; i <= s1.length(); i++){
            d[i][0] = i;
        }
        for (int j = 0; j <= s2.length(); j++){
            d[0][j] = j;
        }

        for (int m = 1; m <= s1.length(); m++){
            for (int n = 1; n <= s2.length(); n++){
                if(s1.charAt(m-1) == s2.charAt(n-1)){
                    c = 0;
                }
                else{
                    c = 1;
                }
                //edit distance = d[m][n]
                int insert = d[m-1][n] + 1;
                int del = d[m][n-1] + 1;
                int sub = d[m-1][n-1] + c;
                d[m][n] = min(insert, del, sub);

                //do new stuff here
                if (c == 0){
                    e[m][n] = ' ';
                }
                else {
                    if (d[m][n] == insert){
                        e[m][n] = 'I';
                    }
                    else if (d[m][n] == sub){
                        e[m][n] = 'S';
                    }
                    else if (d[m][n] == del){
                        e[m][n] = 'D';
                    }
                }
            }
            setChanged();
            this.notifyObservers();
        }
        return d[s1.length() - 1][s2.length() - 1];
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
    //given a row index, return that row in d (in dist method)
    public int[] dLine(int i){
        return d[i];
    }

    //given row index, return that row in e (in dist method)
    public char[] eLine(int i){
        //return e[i];
        char[] rowLine = new char[e[0].length];
        for (int j = 0; j < e[0].length; j++){
            rowLine[j] = e[i][j];
        }
        return rowLine;
    }

/*
    public int[][] getD(){
        return d;
    }

    public char[][] getE(){
        return e;
    }
*/
    public String aString(){
        return str1;
    }

    public String bString(){
        return str2;
    }
/*    public static void main(String[] args){
        String s1 = "abc";
        String s2 = "cba";
        PS07Model model = new PS07Model(s1, s2);
        System.out.println("Strings being compared: " + model.aString() + " and " + model.bString());
        System.out.println("dist: " + model.dist(s1, s2));
        System.out.println("e content at row 1: ");
        System.out.println("Contents of d: ");
        for (int i = 0; i < model.getD().length; i++){
            for (int n : model.dLine(i)){
                System.out.print(n);
            }
            System.out.println();
        }

        System.out.println("Contents of e: ");
        for (int i = 0; i < model.getE().length; i++){
            for(char c : model.eLine(i)){
                System.out.print(c);
            }
            System.out.println();
        }
    }*/
}