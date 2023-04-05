package org.example.player;

import org.example.card.Card;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Player {
    private String name;

    private Strategy strategy;

    private boolean won;

    private List<Card> hand = new ArrayList<>();

    public Player(String name) {
        this.name = name;
    }

    public List<Card> getHand() {
        return hand;
    }

    public void setName(String name) {
        this.name = name;
    }

   public void addCard(Card card) {
        hand.add(card);
    }

    public int getHandValue() {
        int totalHandValue = 0;
        for(Card card: hand){
            totalHandValue +=card.getRank();
        }
        return totalHandValue;
    }

    public void updatePlayerStatus() {
        int value = getHandValue();
        if(value < 17){
            setStrategy(Strategy.HIT);
        } else if(value < 21) {
            setStrategy(Strategy.STICK);
        } else if( value == 21){
            setWon(true);
            setStrategy(null);
        }
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public Strategy getStrategy() {
        return strategy;
    }

    public void setWon(boolean won) {
        this.won = won;
    }

    public boolean hasWon() {
        return won;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", strategy=" + strategy +
                ", hand=" + hand +
                ", won=" + won +
                ", handValue=" + getHandValue() +
                '}';
    }
}
