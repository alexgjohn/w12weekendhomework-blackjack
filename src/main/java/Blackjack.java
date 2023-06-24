import Card.*;
import Players.*;

import java.util.ArrayList;

public class Blackjack {

    private Deck deck;

    private Dealer dealer;
    private ArrayList<Player> players;
    private Person winner;

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

    public Person getWinner() {
        return this.winner;
    }

    public void setWinner(Player player) {
        this.winner = player;
    }

    public void playerTwistOrStick(Player player){
        while (player.getHandTotal() <= 16){
            this.dealer.dealToPlayer(player, this.deck.returnTopCard());
        }
    }

    public void dealerTwistOrStick(){
        while (this.dealer.getHandTotal() <= 16){
            this.dealer.dealToSelf(this.deck.returnTopCard());
        }
    }


    public void determineWinner() {
        ArrayList<Person> remainingPlayersInGame = new ArrayList<>();
        if (!this.dealer.isBust()){
            remainingPlayersInGame.add(dealer);
        }
        for (Player player:this.players){
            if (!player.isBust()){
                remainingPlayersInGame.add(player);
            }
        }
        if (remainingPlayersInGame.size() != 0){
            this.winner = remainingPlayersInGame.get(0);
        }
        for (Person remainingPlayer:remainingPlayersInGame){
            if (remainingPlayer.getHandTotal() > this.winner.getHandTotal()){
                this.winner = remainingPlayer;
            }
        }
    }

    public String declareWinner() {
        String declaration = null;
        if (this.winner == this.dealer){
            declaration = String.format("Dealer wins with a score of %d!", this.getDealer().getHandTotal());
        } else if (this.winner != null){
            for (Player player:this.players){
                if (player == this.winner){
                    declaration = String.format("%s wins with a score of %d!", player.getName(), player.getHandTotal());
                }
            }
        } else {
            declaration = "Everyone went bust. Nobody wins!";
        }
        return declaration;
    }

    public void playGame(){
        this.shuffle();
        this.dealFirstHand();
        for (Player player:this.players){
            this.playerTwistOrStick(player);
        }
        this.dealerTwistOrStick();
        this.determineWinner();
        System.out.println(this.declareWinner());
    }
}
