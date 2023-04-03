package org.example;

import org.example.card.Card;
import org.example.deck.Deck;
import org.example.game.Game;
import org.example.player.Player;

public class Main {
    public static void main(String[] args) {
    Game game =  new Game(10);

    for(Player i: game.getPlayers()){
        System.out.println(i);
    }

//    for(Card i : game.getDeck().getDeck()) {
//        System.out.println(i.getRank().getRank() +" " +" "+i.getSuit());
//    }

//        System.out.println("<<<<Shuffled>>>>>");
//        for(Card i : game.getDeck().getDeck()) {
//            System.out.println(i);
//        }
//
//        for(int i = 0; i<3;i++) {
//            System.out.println(game.getDeck().getDeck().remove(0));
//
//        }
//        System.out.println(game.getDeck().getDeck().size());
    }
}