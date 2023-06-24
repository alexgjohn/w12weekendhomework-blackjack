import Card.*;
import Players.*;

import java.util.ArrayList;
import java.util.Collection;

public class Blackjack {

    private Deck deck;

    private Dealer dealer;
    private ArrayList<Player> players;
    private Player winner;

    public Blackjack(Deck deck, Dealer dealer){
        this.deck = deck;
        this.dealer = dealer;
        this.players = new ArrayList<>();
        this.winner = null;
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

    public Player getWinner() {
        return this.winner;
    }

    public void setWinner(Player player) {
        this.winner = player;
    }

    public void playerTwistOrStick(Player player){
        while (player.getHandTotal() <= 14){
            this.dealer.dealToPlayer(player, this.deck.returnTopCard());
        }
    }

    public void dealerTwistOrStick(){
        while (this.dealer.getHandTotal() <= 11){
            this.dealer.dealToSelf(this.deck.returnTopCard());
        }
    }

    public String playGame(){
        this.shuffle();
        this.dealFirstHand();
        for (Player player:this.players){
            this.playerTwistOrStick(player);
        }
        this.dealerTwistOrStick();
        String endgame = "Game over!";
        return endgame;
    }
}
