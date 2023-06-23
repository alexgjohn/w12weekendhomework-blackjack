package Card;

public class Card {

    private CardType cardType;
    private String suit;

    public Card(CardType cardType, String suit){
        this.cardType = cardType;
        this.suit = suit;
    }

    public int getNumberValue(){
        return this.cardType.getNumberValue();
    }

    public CardType getCardType() {
        return this.cardType;
    }

    public String getSuit() {
        return this.suit;
    }
}
