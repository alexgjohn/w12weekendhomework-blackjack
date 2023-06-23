import Card.*;
import Players.*;

import java.util.ArrayList;
import java.util.Collection;

public class Blackjack {

    private Deck deck;

    private Dealer dealer;
    private ArrayList<Player> players;

    public Blackjack(Deck deck, Dealer dealer){
        this.deck = deck;
        this.dealer = dealer;
        this.players = new ArrayList<>();
    }

    public Dealer getDealer() {
        return this.dealer;
    }

    public Deck getDeck() {
        return this.deck;
    }

    public ArrayList<Player> getPlayers() {
        return this.players;
    }

    public void addPlayer(Player playerToAdd) {
        this.players.add(playerToAdd);
    }

    public void shuffle() {
        this.deck.shuffle();
    }

    public void dealAllPlayersTwoCards() {
        for(Player player:this.players){
            this.dealer.dealToPlayer(player, this.deck.returnTopCard());
            this.dealer.dealToPlayer(player, this.deck.returnTopCard());
        }
    }

    public void dealerDealsSelfTwoCards() {
        this.dealer.dealToSelf(this.deck.returnTopCard());
        this.dealer.dealToSelf(this.deck.returnTopCard());
    }

    public void dealFirstHand() {
        this.dealAllPlayersTwoCards();
        this.dealerDealsSelfTwoCards();
    }
}
