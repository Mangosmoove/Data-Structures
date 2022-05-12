import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;

/**
 * Arinah Karim     ankarim
 * CSCI-C 343 / Fall 2020
 * 9/11/2020
 */
public class TweetCollection {
    ArrayList<TweetClass> tweet = new ArrayList<>();

    public void add(TweetClass t){
        tweet.add(t);
    }

    public ArrayList<String> getTweets(String author){
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < tweet.size(); i++){
            if (tweet.get(i).getAuthor().equals(author)){
                result.add(tweet.get(i).getContent());
            }
        }
        return result;
    }

    public boolean tweetedAbout(String author, String content){
        for (int i = 0; i < tweet.size(); i++){
            if (tweet.get(i).getAuthor().equals(author)){
                if (tweet.get(i).getContent().contains(content)){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) throws Exception{
        try {
            URL url = new URL("http://homes.soic.indiana.edu/classes/fall2020/csci/c343-mitja/test2020/tweet-data-September10.txt");
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            TweetCollection tc = new TweetCollection();
            String inputLine;
            while ((inputLine = in.readLine()) != null){
                int index = inputLine.indexOf(' ');
                String author = inputLine.substring(0, index);
                String content = inputLine.substring(index, inputLine.length()-1);
                TweetClass t = new TweetClass(author, content);
                tc.add(t);
            }
            System.out.println("Tweets made by: NoSQLDigest");
            System.out.println(tc.getTweets("NoSQLDigest"));
            System.out.println("Testing if word 'vi' is in any of NoSQLDigest's content..." + tc.tweetedAbout("NoSQLDigest", "vi"));
            System.out.println("Testing if word 'hulu' is in any of NoSQLDigest's content..." + tc.tweetedAbout("NoSQLDigest", "hulu"));

            System.out.println("\nTweets made by: ShallowAddict");
            System.out.println(tc.getTweets("ShallowAddict"));
            System.out.println("Testing if word 'ake' is any of ShallowAddict's content..." + tc.tweetedAbout("ShallowAddict", "ake"));
            System.out.println("Testing if word 'ba' is any of ShallowAddict's content..." + tc.tweetedAbout("ShallowAddict", "ba"));

            in.close();
        } catch (Throwable e){
            System.out.println("exception is " + e);
            e.printStackTrace();
        }
    }
}