import Card.Ace;
import Card.CardType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AceTest {

    private Ace aceOfSpades;

    @Before
    public void before(){
        aceOfSpades = new Ace(CardType.ACE, "Spades");
    }

    @Test
    public void aceHasCorrectCardType(){
        assertEquals(CardType.ACE, aceOfSpades.getCardType());
    }

    @Test
    public void aceHasNumberValueOfEleven(){
        assertEquals(11, aceOfSpades.getNumberValue());
    }

    @Test
    public void aceHasSuit(){
        assertEquals("Spades", aceOfSpades.getSuit());
    }

    @Test
    public void aceCanChangeValueToOne(){
        aceOfSpades.changeValueToOne();
        assertEquals(1, aceOfSpades.getNumberValue());
    }
}
