public interface DeckADT {
    //creates a full set of cards (with 52 cards; no Jokers)
    public void intialize();

    //draw a card, and return the card as a String. for example "2S" (2 of Spades)
    //using single-letter representations for suits:
    // S(spades), C(clubs), H(hearts), and D(diamonds)
    public String drawRandomCard();

    //shuffles deck
    public String drawTopCardFromDeck();

    //given a card, place it to the top of the deck
    public void placeCardOnBottomOfDeck(String card);
}
