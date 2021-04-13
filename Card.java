public class Card {
    String symbol;
    String suit;

    public Card(String symbol, String suit){
        this.symbol = symbol;
        this.suit = suit;
    }

    public String toString(){
        return symbol + suit;
    }
}
