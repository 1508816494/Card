package com.yyt.card.model;

import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author yyt
 */
public class Player {
    private int id;
    private String name;
    private Queue<Card> cardQueue;

    public Player(int id, String name) {
        this.id = id;
        this.name = name;
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

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCardsv2(List<Card> cards) {
        this.cardQueue.addAll(cards);
    }

    @Override
    public String toString() {
        return "com.yyt.card.model.Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cards=" + cardQueue +
                '}';
    }
}
