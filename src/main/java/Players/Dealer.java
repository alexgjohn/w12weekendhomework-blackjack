package Players;

import Card.*;
import java.util.ArrayList;

public class Dealer extends Person{


    public Dealer(){
        super();
    }


    public void dealToSelf(Card cardDealt) {
        super.getHand().add(cardDealt);
        super.getHandTotal();
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
