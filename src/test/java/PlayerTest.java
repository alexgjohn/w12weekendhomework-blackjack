import Card.*;
import Players.Player;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class PlayerTest {

    private Player player;
    private Card sixOfClubs;
    private Card queenOfDiamonds;
    private Card queenOfHearts;


    @Before
    public void before(){
        sixOfClubs = new Card(CardType.SIX, "Clubs");
        queenOfDiamonds = new Card(CardType.QUEEN, "Diamonds");
        queenOfHearts = new Card(CardType.QUEEN, "Hearts");
        player = new Player("Grant");
    }

    @Test
    public void playerHasName(){
        assertEquals("Grant", player.getName());
    }

    @Test
    public void playerHasEmptyHand(){
        assertEquals(0, player.getHand().size());
    }

    @Test
    public void playerCanAddCardsToHand(){
        player.addCardToHand(sixOfClubs);
        player.addCardToHand(queenOfDiamonds);
        assertEquals(2, player.getHand().size());
    }

    @Test
    public void playerIsNotBust(){
        assertEquals(false, player.isBust());
    }

    @Test
    public void playerCanGoBust(){
        player.goBust();
        assertEquals(true, player.isBust());
    }

    @Test
    public void playerHasHandTotal(){
        player.addCardToHand(sixOfClubs);
        player.addCardToHand(queenOfDiamonds);
        assertEquals(16, player.getHandTotal());
    }

    @Test
    public void playerGoesBustIfTotalExceedsTwentyOne(){
        player.addCardToHand(sixOfClubs);
        player.addCardToHand(queenOfDiamonds);
        player.addCardToHand(queenOfHearts);
        player.getHandTotal();
        assertEquals(true, player.isBust());
    }
}
