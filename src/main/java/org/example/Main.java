package org.example;

import org.example.card.Card;
import org.example.deck.Deck;
import org.example.game.Game;
import org.example.player.Player;

public class Main {
    public static void main(String[] args) {
        Game game =  new Game();
        game.startGame(3);

        for(Player i: game.getPlayers()){
            System.out.println(i);
        }

    }
}