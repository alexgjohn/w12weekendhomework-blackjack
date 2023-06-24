package Players;

import Card.Card;

import java.util.ArrayList;

public abstract class Person {

    private ArrayList<Card> hand;
    private boolean bust;

    public Person(){
        this.hand = new ArrayList<>();
        this.bust = false;
    }

    public ArrayList<Card> getHand() {
        return this.hand;
    }

    public void addCardToHand(Card cardToAdd) {
        this.getHand().add(cardToAdd);
    }

    public boolean isBust() {
        return this.bust;
    }

    public void goBust() {
        this.bust = true;
    }

    public int getHandTotal() {
        int total = 0;
        boolean handContainsAce = false;
        for (Card card:this.hand){
            total += card.getNumberValue();
        }
        for (Card card:this.hand){
            if (card.getCardType() == card.getCardType().ACE) {
                handContainsAce = true;
            }
        }
        if (total > 21 && handContainsAce != true){
            this.goBust();
        } else if (total > 21 && handContainsAce) {
            total -= 10;
        }
        return total;
    }
}
