import Card.*;
import Players.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BlackjackTest {

    private Blackjack blackjack;
    private Deck deck;

    private Dealer dealer;
    private Player player1;
    private Player player2;
    private Card sixOfClubs;
    private Card sixOfDiamonds;
    private Card queenOfDiamonds;
    private Card queenOfHearts;
    private Card queenOfSpades;
    private Card queenOfClubs;

    @Before
    public void before(){
        deck = new Deck();
        player1 = new Player("Grant");
        player2 = new Player("Ally");
        dealer = new Dealer();
        blackjack = new Blackjack(deck, dealer);
        sixOfClubs = new Card(CardType.SIX, "Clubs");
        sixOfDiamonds = new Card(CardType.SIX, "Diamonds");
        queenOfDiamonds = new Card(CardType.QUEEN, "Diamonds");
        queenOfHearts = new Card(CardType.QUEEN, "Hearts");
        queenOfSpades = new Card(CardType.QUEEN, "Spades");
        queenOfClubs = new Card(CardType.QUEEN, "Clubs");
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


    @Test
    public void blackjackStartsWithNoWinner(){
        assertEquals(null, blackjack.getWinner());
    }

    @Test
    public void blackjackCanSelectWinner(){
        blackjack.addPlayer(player1);
        blackjack.addPlayer(player2);
        blackjack.setWinner(player1);
        assertEquals(player1, blackjack.getWinner());
    }

    @Test
    public void playerFinalTotalWillAlwaysExceedSixteen(){
        blackjack.addPlayer(player1);
        blackjack.addPlayer(player2);
        blackjack.playGame();
        assertTrue(player1.getHandTotal() > 16);
        assertTrue(player2.getHandTotal() > 16);
    }

    @Test
    public void dealerFinalTotalWillAlwaysExceedSixteen(){
        blackjack.addPlayer(player1);
        blackjack.addPlayer(player2);
        blackjack.playGame();
        assertTrue(dealer.getHandTotal() > 16);
    }

    @Test
    public void winnerIsChosenByHighestScoreUnderTwentyTwo(){
        blackjack.addPlayer(player1);
        blackjack.getDealer().dealToSelf(queenOfDiamonds);
        blackjack.getDealer().dealToSelf(sixOfClubs);
        blackjack.getDealer().dealToPlayer(player1, queenOfHearts);
        blackjack.getDealer().dealToPlayer(player1, queenOfSpades);
        blackjack.determineWinner();
        assertEquals(player1, blackjack.getWinner());
    }

    @Test
    public void winnerRemainsNullIfEveryoneIsBust(){
        blackjack.addPlayer(player1);
        blackjack.getDealer().dealToSelf(queenOfDiamonds);
        blackjack.getDealer().dealToSelf(sixOfClubs);
        blackjack.getDealer().dealToSelf(queenOfClubs);
        blackjack.getDealer().dealToPlayer(player1, queenOfHearts);
        blackjack.getDealer().dealToPlayer(player1, sixOfDiamonds);
        blackjack.getDealer().dealToPlayer(player1, queenOfSpades);
        blackjack.determineWinner();
        assertEquals(null, blackjack.getWinner());
    }


    @Test
    public void blackjackCanDeclareDealerASWinner(){
        blackjack.addPlayer(player1);
        blackjack.getDealer().dealToSelf(queenOfDiamonds);
        blackjack.getDealer().dealToSelf(queenOfClubs);
        blackjack.getDealer().dealToPlayer(player1, queenOfHearts);
        blackjack.getDealer().dealToPlayer(player1, sixOfDiamonds);
        blackjack.getDealer().dealToPlayer(player1, queenOfSpades);
        blackjack.determineWinner();
        String expected = "Dealer wins with a score of 20!";
        assertEquals(expected, blackjack.declareWinner());
    }

    @Test
    public void blackjackCanDeclarePlayerASWinner(){
        blackjack.addPlayer(player1);
        blackjack.getDealer().dealToSelf(queenOfDiamonds);
        blackjack.getDealer().dealToSelf(sixOfDiamonds);
        blackjack.getDealer().dealToSelf(queenOfClubs);
        blackjack.getDealer().dealToPlayer(player1, queenOfHearts);
        blackjack.getDealer().dealToPlayer(player1, queenOfSpades);
        blackjack.determineWinner();
        String expected = "Grant wins with a score of 20!";
        assertEquals(expected, blackjack.declareWinner());
    }

    //this test kind of sucks, because there is a chance that nobody will win and winner will remain null.
    //but, you know, I need to check if the functions all run together, and it seems they do.
    @Test
    public void gameCanBePlayed(){
        blackjack.addPlayer(player1);
        blackjack.addPlayer(player2);
        blackjack.playGame();
        assertTrue(dealer.getHandTotal() > 16);
        assertTrue(player1.getHandTotal() > 16);
        assertTrue(player2.getHandTotal() > 16);
        assertTrue(blackjack.getWinner() != null);
    }


}
