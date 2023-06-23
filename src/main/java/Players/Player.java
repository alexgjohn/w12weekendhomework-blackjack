package Players;
import Card.*;

import java.util.ArrayList;
import java.util.Collection;

public class Player {

    private String name;

    private ArrayList<Card> hand;
    private boolean bust;

    public Player(String name){
        this.name = name;
        this.hand = new ArrayList<>();
        this.bust = false;
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<Card> getHand() {
        return this.hand;
    }

    public void addCardToHand(Card cardToAdd) {
        this.hand.add(cardToAdd);
    }

    public boolean isBust() {
        return this.bust;
    }

    public void goBust() {
        this.bust = true;
    }

    public int getHandTotal() {
        int total = 0;
        for (Card card:this.hand){
            total += card.getNumberValue();
        }
        return total;
    }
}
