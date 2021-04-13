import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args){
        // Establish the two players
        Player white = new Player("White");
        Player black = new Player("Black");
        // Arrays of suits and symbols for the random hands to be generated from
        List<String> symbols = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A");
        List<String> suits = Arrays.asList("C", "D", "H", "S");
        // Generate the random hands, one for each player and bind them to the player
        for(int j = 0; j < 2; j++) {
            Card[] cards = new Card[5];
            for (int i = 0; i < 5; i++) {
                Random rand = new Random();
                int randSym = rand.nextInt(symbols.size());
                int randSuit = rand.nextInt(suits.size());
                Card c = new Card(symbols.get(randSym), suits.get(randSuit));
                for(int k = 0; k < 5; k++){
                    if(cards[k]!=null) {
                        if (cards[k].symbol == c.symbol && cards[k].suit == c.suit) {
                            i--;
                        }
                    }
                }
                cards[i] = c;
            }
            if(j == 0){
                white.hand = new Hand(cards);
            }else{
                black.hand = new Hand(cards);
            }
        }
        // Show the two players' hands
        System.out.print("White hand: ");
        System.out.print(white.hand);
        System.out.println();
        System.out.print("Black hand: ");
        System.out.print(black.hand);
        System.out.println();

        // Determine winner and show result
        System.out.println(Hand.determineWinner(white, black));
    }
}
