import Card.Card;
import Card.CardType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CardTest {

    private Card aceOfSpades;
    private Card sixOfClubs;
    private Card queenOfDiamonds;

    @Before
    public void before(){
        aceOfSpades = new Card(CardType.ACE, "Spades");
        sixOfClubs = new Card(CardType.SIX, "Clubs");
        queenOfDiamonds = new Card(CardType.QUEEN, "Diamonds");
    }

    @Test
    public void cardHasType(){
        assertEquals(CardType.ACE, aceOfSpades.getCardType());
    }

    @Test
    public void cardHasNumberValue(){
        assertEquals(6, sixOfClubs.getNumberValue());
    }

    @Test
    public void cardHasSuit(){
        assertEquals("Diamonds", queenOfDiamonds.getSuit());
    }


}
