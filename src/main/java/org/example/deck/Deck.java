package org.example.deck;

import org.example.card.Card;
import org.example.card.Rank;
import org.example.card.Suit;

import java.util.ArrayList;

public class Deck {
    private ArrayList<Card> deck = new ArrayList<>();

    public Deck() {
        for (Rank rank: Rank.values()){
            for(Suit suit: Suit.values()){
                deck.add(new Card(rank,suit));
            }
        }
    }

    public ArrayList<Card> getDeck() {
        return deck;
    }
}
