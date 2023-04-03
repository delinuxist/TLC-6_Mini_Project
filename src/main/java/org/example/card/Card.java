package org.example.card;

public class Card {
    private Rank rank;
    private Suit suit;

    public Card(Rank rank,Suit suit){
        this.rank = rank;
        this.suit = suit;
    }

    public Rank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }

    @Override
    public String toString() {
        return "Card{" +
                "rank=" + rank.getRank() +
                ", suit=" + suit +
                '}';
    }
}
