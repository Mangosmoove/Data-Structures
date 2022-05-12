import java.util.ArrayList;

/**
 * Arinah Karim     ankarim
 * CSCI-C 343 / Fall 2020
 * 9/7/2020
 */

public class TheTweeter {
    //empty arraylist to hold all TweetClass objects
    ArrayList<TweetClass> tweet = new ArrayList<>();

    public void add(TweetClass t){
        tweet.add(t);
    }

    public void remove(String author){
        for (int i = 0; i < tweet.size(); i++){
            if (tweet.get(i).getAuthor().equals(author)){
                tweet.remove(i);
            }
        }
    }

    public TweetClass get(String author){
        for (int i = 0; i < tweet.size(); i++){
            if (tweet.get(i).getAuthor().equals(author)){
                return tweet.get(i);
            }
        }
        return null;
    }

    public static void main(String[] args){
        TheTweeter t = new TheTweeter();
        TweetClass tw1 = new TweetClass("Jared", "Whaddup I'm Jared, I'm 19, and I never learned how to read");
        t.add(tw1);
        TweetClass tw2 = new TweetClass("Glasses and yellow shirt gang", "You know what, I'm about to say it. I don't care you broke your elbow");
        t.add(tw2);
        TweetClass tw3 = new TweetClass("Sad Frat Boi", "I thought you were bae... turns out you were just fam");
        t.add(tw3);
        TweetClass tw4 = new TweetClass("Some random kid", "Wait a minute. Who ARE you?");
        t.add(tw4);
        TweetClass tw5 = new TweetClass("Michael B.", "Hi, my name is Michael with a B");
        t.add(tw5);
        TweetClass tw6 = new TweetClass("Garbage man take me by the hand", "Oh hi, thanks for checking in. I'm still a piece of garbage~~~");
        t.add(tw6);

        t.remove("Michael B.");
        System.out.println(t.get("Michael B.")); //should be null
        System.out.println(t.get("Some random kid").getContent());
        System.out.println(t.get("Jared").getContent());
    }
}