import Card.*;
import Players.*;
import org.junit.Before;

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

    
}
