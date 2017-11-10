import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Card {
    private String suit;
    private String point;

    public Card(String suit,String point) {
        this.suit = suit;
        this.point = point;
    }

    public String getSuit() {
        return suit;
    }

    public String getPoint() {
        return point;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public void setPoint(String point) {
        this.point = point;
    }

    @Override
    public String toString() {
        return "Card{" +
                "suit='" + suit + '\'' +
                ", point=" + point +
                '}';
    }

    /**
     *      洗牌方法
     *
     */


}
