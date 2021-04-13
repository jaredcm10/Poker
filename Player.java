public class Player {
    String name;
    Hand hand;

    public Player(String name){
        this.name = name;
    }

    public String toString(){
        return name + ": " + hand;
    }
}
