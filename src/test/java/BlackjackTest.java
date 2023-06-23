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


}
