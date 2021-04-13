import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Hand {
    Card[] hand;

    public Hand(Card[] hand){
        this.hand = hand;
    }

    public String toString(){
        for(Card c: hand){
            System.out.print(c + " ");
        }
        return "";
    }

    // Methods to check for type of hand

    public static boolean isRoyalFlush(Hand h){
        if(isFlush(h)) {
            String[] rf = new String[]{"10", "J", "Q", "K", "A"};
            List<String> royal = Arrays.asList(rf);
            int count = 0;
            for (Card c : h.hand) {
                if (royal.contains(c.symbol)) {
                    count++;
                }
            }
            if (count == 5) {
                return true;
            }
        }
        return false;
    }

    public static boolean isStraightFlush(Hand h){
        if(isFlush(h)){
            if(isStraight(h)){
                return true;
            }
        }
        return false;
    }

    public static boolean isFourKind(Hand h){
        List<Integer> list = new ArrayList<>();
        for(Card c : h.hand){
            if(c.symbol == "J"){
                list.add(11);
            }else if(c.symbol == "Q"){
                list.add(12);
            }else if(c.symbol == "K"){
                list.add(13);
            }else if(c.symbol == "A"){
                list.add(14);
            }else{
                list.add(Integer.parseInt(c.symbol));
            }
        }
        Collections.sort(list);
        List<Integer> uniqueNumbers
                = list.stream().distinct().collect(
                Collectors.toList());
        int count = 0;
        for(int i = 0; i < list.size() - 1; i++){
            if(list.get(i) == list.get(i+1)){
                count++;
            }
        }
        if(uniqueNumbers.size() == 2 && count == 3){
            return true;
        }
        return false;
    }

    public static boolean isFullHouse(Hand h) {
        List<Integer> list = new ArrayList<>();
        for (Card c : h.hand) {
            if (c.symbol == "J") {
                list.add(11);
            } else if (c.symbol == "Q") {
                list.add(12);
            } else if (c.symbol == "K") {
                list.add(13);
            } else if (c.symbol == "A") {
                list.add(14);
            } else {
                list.add(Integer.parseInt(c.symbol));
            }
        }
        Collections.sort(list);
        int num1 = list.get(0);
        int num2 = list.get(4);
        int count1 = 0;
        int count2 = 0;
        for(int i = 0; i < list.size() - 1; i++){
            if (list.get(i) == num1){
                count1++;
            }else if(list.get(i) == num2){
                count2++;
            }
        }
        if(count1 == 2){
            if(count2 == 2){
                return true;
            }
        }else if(count1 == 2){
            if(count2 == 1){
                return true;
            }
        }
        return false;
    }

    public static boolean isFlush(Hand h){
        String suit = h.hand[0].suit;
        for(Card c : h.hand){
            if(c.suit != suit){
                return false;
            }
        }
        return true;
    }

    public static boolean isStraight(Hand h){
        List<Integer> list = new ArrayList<>();
        for(Card c : h.hand){
            if(c.symbol == "J"){
                list.add(11);
            }else if(c.symbol == "Q"){
                list.add(12);
            }else if(c.symbol == "K"){
                list.add(13);
            }else if(c.symbol == "A"){
                list.add(14);
            }else{
                list.add(Integer.parseInt(c.symbol));
            }
        }
        Collections.sort(list);
        int count = 0;
        for(int i = 0; i < list.size() - 1; i++){
            if(list.get(i) + 1 == list.get(i+1)){
                count++;
            }
        }
        if(count == 4){
            return true;
        }
        return false;
    }

    public static boolean isThreeKind(Hand h){
        List<Integer> list = new ArrayList<>();
        for(Card c : h.hand){
            if(c.symbol == "J"){
                list.add(11);
            }else if(c.symbol == "Q"){
                list.add(12);
            }else if(c.symbol == "K"){
                list.add(13);
            }else if(c.symbol == "A"){
                list.add(14);
            }else{
                list.add(Integer.parseInt(c.symbol));
            }
        }
        Collections.sort(list);
        List<Integer> uniqueNumbers
                = list.stream().distinct().collect(
                Collectors.toList());
        int count = 0;
        for(int i = 0; i < list.size() - 1; i++){
            if(list.get(i) == list.get(i+1)){
                count++;
            }else{
                count = 0;
            }
        }
        if(count == 2){
            return true;
        }
        return false;
    }

    public static boolean isTwoPair(Hand h){
        List<Integer> list = new ArrayList<>();
        for (Card c : h.hand) {
            if (c.symbol == "J") {
                list.add(11);
            } else if (c.symbol == "Q") {
                list.add(12);
            } else if (c.symbol == "K") {
                list.add(13);
            } else if (c.symbol == "A") {
                list.add(14);
            } else {
                list.add(Integer.parseInt(c.symbol));
            }
        }
        Collections.sort(list);
        int count = 0;
        int num = list.get(0);
        for(int i = 0; i < list.size() - 1; i++){
            if (num == list.get(i+1)){
                count++;
            }else{
                num = list.get(i+1);
            }
        }
        if(count == 2){
                return true;
        }
        return false;
    }

    public static boolean isPair(Hand h){
        List<Integer> list = new ArrayList<>();
        for (Card c : h.hand) {
            if (c.symbol == "J") {
                list.add(11);
            } else if (c.symbol == "Q") {
                list.add(12);
            } else if (c.symbol == "K") {
                list.add(13);
            } else if (c.symbol == "A") {
                list.add(14);
            } else {
                list.add(Integer.parseInt(c.symbol));
            }
        }
        Collections.sort(list);
        int count = 0;
        String num = "";
        for(int i = 0; i < list.size() - 1; i++){
            if (list.get(i) == list.get(i+1)){
                count++;
                num = String.valueOf(list.get(i));
            }
        }
        if(count == 1){
            return true;
        }
        return false;
    }

    public static int highCard(Hand h){
        List<Integer> list = new ArrayList<>();
        for (Card c : h.hand) {
            if (c.symbol == "J") {
                list.add(11);
            } else if (c.symbol == "Q") {
                list.add(12);
            } else if (c.symbol == "K") {
                list.add(13);
            } else if (c.symbol == "A") {
                list.add(14);
            } else {
                list.add(Integer.parseInt(c.symbol));
            }
        }
        Collections.sort(list);
        return list.get(4);
    }

    // Method to determine a winner between the two players
    // Returns winner and what their hand is
    public static String determineWinner(Player a, Player b){
        Hand ha = a.hand;
        Hand hb = b.hand;

        if(isRoyalFlush(ha) && !isRoyalFlush(hb)){
            return a + "wins with Royal Flush";
        }else if(!isRoyalFlush(ha) && isRoyalFlush(hb)){
            return b + "wins with Royal Flush";
        }else if(isRoyalFlush(ha) && isRoyalFlush(hb)){
            return "Tie.";
        }

        if(isStraightFlush(ha) && !isStraightFlush(hb)){
            return a + "wins with Straight Flush";
        }else if(!isStraightFlush(ha) && isStraightFlush(hb)){
            return b + "wins with Straight Flush";
        }else if(isStraightFlush(ha) && isStraightFlush(hb)){
            return "Tie.";
        }

        if(isFourKind(ha) && !isFourKind(hb)){
            return a + "wins with Four of a kind";
        }else if(!isFourKind(ha) && isFourKind(hb)){
            return b + "wins with Four of a kind";
        }else if(isFourKind(ha) && isFourKind(hb)){
            return "Tie.";
        }

        if(isFullHouse(ha) && !isFullHouse(hb)){
            return a + "wins with Full House";
        }else if(!isFullHouse(ha) && isFullHouse(hb)){
            return b + "wins with Full House";
        }else if(isFullHouse(ha) && isFullHouse(hb)){
            return "Tie.";
        }

        if(isFlush(ha) && !isFlush(hb)){
            return a + "wins with Flush";
        }else if(!isFlush(ha) && isFlush(hb)){
            return b + "wins with Flush";
        }else if(isFlush(ha) && isFlush(hb)){
            return "Tie.";
        }

        if(isStraight(ha) && !isStraight(hb)){
            return a + "wins with Straight";
        }else if(!isStraight(ha) && isStraight(hb)){
            return b + "wins with Straight";
        }else if(isStraight(ha) && isStraight(hb)){
            return "Tie.";
        }

        if(isThreeKind(ha) && !isThreeKind(hb)){
            return a + "wins with Three of a kind";
        }else if(!isThreeKind(ha) && isThreeKind(hb)){
            return b + "wins with Three of a kind";
        }else if(isThreeKind(ha) && isThreeKind(hb)){
            return "Tie.";
        }

        if(isTwoPair(ha) && !isTwoPair(hb)){
            return a + "wins with Two Pair";
        }else if(!isTwoPair(ha) && isTwoPair(hb)){
            return b + "wins with Two Pair";
        }else if(isTwoPair(ha) && isTwoPair(hb)){
            return "Tie.";
        }

        if(isPair(ha) && !isPair(hb)){
            return a + "wins with a Pair";
        }else if(!isPair(ha) && isPair(hb)){
            return b + "wins with a Pair";
        }else if(isPair(ha) && isPair(hb)){
            return "Tie";
        }

        int highA = highCard(ha);
        int highB = highCard(hb);

        if(highA > highB){
            if(highA == 14){
                return a + "wins with High Card: Ace";
            }else if(highA == 13){
                return a + "wins with High Card: King";
            }else if(highA == 12){
                return a + "wins with High Card: Queen";
            }else if(highA == 11){
                return a + "wins with High Card: Jack";
            }else{
                return a + "wins with High Card: " + highA;
            }
        }else if(highB > highA){
            if(highB == 14){
                return b + "wins with High Card: Ace";
            }else if(highB == 13){
                return b + "wins with High Card: King";
            }else if(highB == 12){
                return b + "wins with High Card: Queen";
            }else if(highB == 11){
                return b + "wins with High Card: Jack";
            }else{
                return b + "wins with High Card: " + highB;
            }
        }else{
            return "Tie.";
        }
    }
}
