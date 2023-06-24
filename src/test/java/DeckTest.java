import Card.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class DeckTest {

    private Deck deck;

    @Before
    public void before(){
        deck = new Deck();
    }

    @Test
    public void deckHasFiftyTwoCards(){
        assertEquals(52, deck.getCards().size());
    }

    @Test
    public void deckHasAceAsTopCard(){
        assertTrue(deck.returnTopCard().getNumberValue() == 11);
    }

    @Test
    public void deckCanBeShuffled(){
        deck.shuffle();
        assertFalse(deck.returnTopCard().getNumberValue() == 1);
    }
}
