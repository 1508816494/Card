package com.yyt.card.model;

/**
 * @author yyt
 */
public class Card {
    private String suit;
    private String point;

    public Card(String suit, String point) {
        this.suit = suit;
        this.point = point;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }

    @Override
    public String toString() {
        return "com.yyt.card.model.Card{" +
                "suit='" + suit + '\'' +
                ", point=" + point +
                '}';
    }

    /**
     *      洗牌方法
     *
     */


}
