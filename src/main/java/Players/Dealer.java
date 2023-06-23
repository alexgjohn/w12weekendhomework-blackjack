package Players;

import Card.*;
import java.util.ArrayList;

public class Dealer {

    private ArrayList<Card> hand;

    public Dealer(){
        this.hand = new ArrayList<>();
    }

    public ArrayList<Card> getHand() {
        return this.hand;
    }

    public void dealToSelf(Card cardDealt) {
        this.hand.add(cardDealt);
    }

    public int getHandTotal() {
        int total = 0;
        for (Card card:this.hand){
            total += card.getNumberValue();
        }
        return total;
    }

    public void dealToPlayer(Player player, Card cardDealt) {
        if(!player.isBust()){
            player.addCardToHand(cardDealt);
            player.getHandTotal();
        }
    }

    public void shuffleDeck(Deck deck) {
        deck.shuffle();
    }
}
