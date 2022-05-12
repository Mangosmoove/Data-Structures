import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

/**
 * Arinah Karim     ankarim
 * CSCI-C 343 / Fall 2020
 * 9/6/2020
 */
public class MyDeckOfCards implements DeckADT {
    private ArrayList<String> deck;

    public MyDeckOfCards(){
        deck = new ArrayList<String>(52);
    }

    @Override
    public void intialize() {
        String suite = "";
        String value = "";
        for (int i = 0; i < 52; i++) {
            //assign suites
            if (i < 13) {
                suite = "S";    //spades
            } else if (i < 26) {
                suite = "H";    //hearts
            } else if (i < 39) {
                suite = "D";    //diamonds
            } else {
                suite = "C"; //clubs
            }

            //assign values
            if (i % 13 == 0) {
                value = "Ace";
            } else if (i % 13 == 1) {
                value = "King";
            } else if (i % 13 == 12) {
                value = "Queen";
            } else if (i % 13 == 11) {
                value = "Jack";
            } else {
                //if not a royal card
                value = "" + (i % 13);
            }
            deck.add(value + suite);
        }
    }

    public String drawRandomCard() {
        Random rand = new Random();
        int cardInd = rand.nextInt(52);
        String card = deck.get(cardInd);
        deck.remove(card);
        deck.add(card);
        return card;
    }

    public String drawTopCardFromDeck() {
        String card = deck.get(0);
        deck.remove(card);
        deck.add(card);
        return card;
    }

    public void placeCardOnBottomOfDeck(String card) {
        boolean found = false;

        for (int i = 0; i < deck.size(); i++){
            if (found == true){
                break; //to stop going through the deck
            }
            else if (deck.get(i).equals(card)){
                deck.remove(i);
                System.out.println("..." + card + " card found...");
                found = true;
                deck.add(card);
                //tests to see if the card got moved to the bottom of the deck
                //System.out.println(deck.get(deck.size()-1));
            }
            else if (i == deck.size()-1 && found != true){
                System.out.println(card + " card not found");
            }
        }
    }

    @Override
    public String toString(){
        String result = "";

        for (int i = 0; i < deck.size(); i++){
            result = result + " " + deck.get(i);
            if (i != 0 && i % 13 == 0){
                result = result + "\n";
            }
        }
        return result;
    }

    public static void main(String[] args){
        MyDeckOfCards deck1 = new MyDeckOfCards();
        deck1.intialize();
        System.out.print(deck1.toString() + "\n\n");

        System.out.println("Random card drawn: " + deck1.drawRandomCard());
        System.out.println("moving card to bottom of deck...");
        System.out.print(deck1.toString() + "\n\n");

        System.out.println("Card on top of deck: " + deck1.drawTopCardFromDeck());
        System.out.println("moving card to bottom of deck...");
        System.out.print(deck1.toString() + "\n\n");

        System.out.println("Placing card 2S to bottom of deck...");
        deck1.placeCardOnBottomOfDeck("2S");
        System.out.print(deck1.toString() + "\n\n");

        System.out.println("Placing card 4F to bottom of deck...");
        deck1.placeCardOnBottomOfDeck("4F");
        System.out.print(deck1.toString() + "\n\n");

        System.out.println("Random card drawn: " + deck1.drawRandomCard());
        System.out.println("moving card to bottom of deck...");
        System.out.println(deck1.toString() + "\n\n");

        System.out.println("new deck...");
        MyDeckOfCards deck2 = new MyDeckOfCards();
        deck2.intialize();
        System.out.print(deck2.toString() + "\n\n");

        for (int i = 0; i < 4; i++){
            System.out.println("Random card drawn: " + deck2.drawRandomCard());
            System.out.println("moving card to bottom of deck...");
            System.out.print(deck2.toString() + "\n\n");
        }

        System.out.println("Placing card 5S to bottom of deck...");
        deck1.placeCardOnBottomOfDeck("5S");
        System.out.print(deck2.toString() + "\n\n");

        System.out.println("Placing card 10H to bottom of deck...");
        deck1.placeCardOnBottomOfDeck("10H");
        System.out.print(deck2.toString() + "\n\n");

        System.out.println("Placing card JackC to bottom of deck...");
        deck1.placeCardOnBottomOfDeck("JackC");
        System.out.print(deck2.toString() + "\n\n");

        for (int i = 0; i < 14; i++){
            System.out.println("Random card drawn: " + deck1.drawRandomCard());
            System.out.println("moving card to bottom of deck...");
            System.out.print(deck2.toString() + "\n\n");
        }

        System.out.println("Card on top of deck: " + deck2.drawTopCardFromDeck());
        System.out.println("moving card to bottom of deck...");
        System.out.print(deck2.toString() + "\n\n");
    }
}
