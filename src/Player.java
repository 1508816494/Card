import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Player {
    private int id;
    private String name;
    private List<Card> cards;
    private Queue<Card> cardQueue;

    public Player(int id,String name) {
        this.id = id;
        this.name = name;
        this.cards = new ArrayList<Card>();
        this.cardQueue = new ConcurrentLinkedQueue<>();
    }

    public Queue<Card> getCardQueue() {
        return cardQueue;
}

    public void setCardQueue(Queue<Card> cardQueue) {
        this.cardQueue = cardQueue;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Card> getCards() {
        return cards;
    }


    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public void setCardsv2(List<Card> cards) {
        this.cardQueue.addAll(cards);
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cards=" + cards +
                '}';
    }
}
