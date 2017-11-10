package com.yyt.card.model;

/**
 * @author yyt
 */
public class Card {

    private final Suit suit;

    private final Point point;

    public Card(Suit suit,Point point) {
        this.point = point;
        this.suit = suit;
    }

    /**
     * 制定牌的花色
     * 牌的花色是固定的，所以最好使用{enum}而不是{String}类型
     */
    public enum Suit {

        /**
         * 红桃
         */
        Heart("红桃"),
        /**
         * 梅花
         */
        Plum("梅花"),
        /**
         * 黑桃
         */
        Spade("黑桃"),
        /**
         * 方片
         */
        Block("方片"),

        /**
         * 大小王没有花色，所以制定一个null类型
         */
        Null("");

        Suit(String val) {
            this.val = val;
        }

        private String val;

        /**
         * 获取中文类型的花色
         * @return
         */
        private String getVal (){
            return val;
        }

    }

    /**
     * 制定牌的点数
     */
    public enum Point{

        A("A"),
        Tow("2"),
        Three("3"),
        Four("4"),
        Five("5"),
        Six("6"),
        Seven("7"),
        Eight("8"),
        Nine("9"),
        Ten("10"),
        J("J"),
        Q("Q"),
        K("K");

        String val;
        Point(String val) {
            this.val = val;
        }
    }

    public String getSuit() {
        return suit.getVal();
    }

    public String getPoint() {
        return point.val;
    }



    @Override
    public String toString() {
        return "com.yyt.card.model.Card{" +
                "suit='" + suit + '\'' +
                ", point=" + point +
                '}';
    }

}
