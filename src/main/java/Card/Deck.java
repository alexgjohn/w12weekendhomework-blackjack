package Card;

import java.util.ArrayList;

public class Deck {

    private ArrayList<Card> cards;

    public Deck() {
        cards = new ArrayList<>();

        // this iterates through the values of card types and also the suits listed below to generate a full deck of 52 distinct cards
        for (CardType type : CardType.values()) {
            for (String suit : getSuits()) {
                if (type == CardType.ACE) {
                    Ace ace = new Ace(type, suit);
                    cards.add(ace);
                } else {
                    Card card = new Card(type, suit);
                    cards.add(card);
                }
            }
        }
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    private String[] getSuits() {
        String[] suits = {"Spades", "Hearts", "Diamonds", "Clubs"};
        return suits;
    }
}

