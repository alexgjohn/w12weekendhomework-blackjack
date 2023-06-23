import Players.*;
import Card.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class DealerTest {

    private Dealer dealer;
    private Player player1;
    private Player player2;
    private Card sixOfClubs;
    private Card queenOfDiamonds;

    @Before
    public void before(){
        sixOfClubs = new Card(CardType.SIX, "Clubs");
        queenOfDiamonds = new Card(CardType.QUEEN, "Diamonds");
        dealer = new Dealer();
        player1 = new Player("Grant");
        player2 = new Player("Ally");
    }

    @Test
    public void dealerHasEmptyHand(){
        assertEquals(0, dealer.getHand().size());
    }

    @Test
    public void dealerCanDealToSelf(){
        dealer.dealToSelf(sixOfClubs);
        assertEquals(1, dealer.getHand().size());
    }

    @Test
    public void dealerHasHandTotal(){
        dealer.dealToSelf(sixOfClubs);
        dealer.dealToSelf(queenOfDiamonds);
        assertEquals(16, dealer.getHandTotal());
    }

    @Test
    public void dealerCanDealToPlayer(){
        dealer.dealToPlayer(player1, sixOfClubs);
        assertEquals(1, player1.getHand().size());
        assertEquals(6, player1.getHandTotal());
    }
}