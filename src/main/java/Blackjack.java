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
}
