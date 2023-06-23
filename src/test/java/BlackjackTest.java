import Card.*;
import Players.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class BlackjackTest {

    private Blackjack blackjack;
    private Deck deck;

    private Dealer dealer;
    private Player player1;
    private Player player2;

    @Before
    public void before(){
        deck = new Deck();
        player1 = new Player("Grant");
        player2 = new Player("Ally");
        dealer = new Dealer();
        blackjack = new Blackjack(deck, dealer);
    }

    @Test
    public void blackjackHasDealer(){
        assertEquals(dealer, blackjack.getDealer());
    }

    @Test
    public void blackjackHasDeck(){
        assertEquals(deck, blackjack.getDeck());
    }

    @Test
    public void blackjackHasEmptyListOfPlayers(){
        assertEquals(0, blackjack.getPlayers().size());
    }

    @Test
    public void blackjackCanAddPlayers(){
        blackjack.addPlayer(player1);
        assertEquals(1, blackjack.getPlayers().size());
    }

    @Test
    public void deckCanBeShuffledAtStartOfGame(){
        blackjack.shuffle();
        int expected = blackjack.getDeck().returnTopCard().getNumberValue();
        assertFalse(expected == 1);
    }

    @Test
    public void cardIsRemovedFromDeckWhenDealt(){
        blackjack.getDeck().returnTopCard();
        int numberOfCardsInDeck = deck.getCards().size();
        assertEquals(51, numberOfCardsInDeck);
    }

    @Test
    public void playersAreDealtTwoCardsAtStartOfGame(){
        blackjack.addPlayer(player1);
        blackjack.addPlayer(player2);
        blackjack.dealAllPlayersTwoCards();
        assertEquals(2, player1.getHand().size());
        assertEquals(2, player2.getHand().size());
    }

    @Test
    public void dealerDealsSelfTwoCardsAtStartOfGame(){
        blackjack.dealerDealsSelfTwoCards();
        assertEquals(2, dealer.getHand().size());
    }

    @Test
    public void blackjackCanDealFirstHand(){
        blackjack.addPlayer(player1);
        blackjack.addPlayer(player2);
        blackjack.dealFirstHand();
        assertEquals(2, player1.getHand().size());
        assertEquals(2, player2.getHand().size());
        assertEquals(2, dealer.getHand().size());
    }



}
