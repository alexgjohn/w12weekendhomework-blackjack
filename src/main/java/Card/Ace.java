package Card;
public class Ace extends Card{

    private int numberValue;

    public Ace(CardType cardType, String suit){
       super(cardType, suit);
       this.numberValue = cardType.getNumberValue();
    }

    @Override
    public int getNumberValue(){
        return this.numberValue;
    }


    public void changeValueToOne() {
        this.numberValue = 1;
    }

}
