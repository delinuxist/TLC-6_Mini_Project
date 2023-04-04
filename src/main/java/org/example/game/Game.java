package org.example.game;

import org.example.card.Card;
import org.example.deck.Deck;
import org.example.player.Player;
import org.example.player.Strategy;

import java.util.*;
public class Game {
      private List<Player> players = new ArrayList<>();
      private Deck deck;

     public Game(int numberOfPlayers){
          deck = new Deck();
          createPlayers(numberOfPlayers);
          startGame();
      }

    void startGame() {
        shuffleDeck();
        initialCardShare();
    }

    void initialCardShare() {
        for (int i = 0;i< 2;i++) {
            for (Player player : players) {
                player.addCard(deck.getDeck().remove(0));
            }
        }
    }

    public void cardShare() {
        for (Player player : players) {
            if (player.getStrategy() == Strategy.HIT)
            player.addCard(deck.getDeck().remove(0));
        }
    }

      public void  shuffleDeck() {
          Collections.shuffle(deck.getDeck());
      }

    public Deck getDeck() {
        return deck;
    }

    private void createPlayers(int numberOfPlayers) {
         for (int i=0; i< numberOfPlayers; i++){
             players.add(new Player("Player-"+(i+1)));
         }
    }

    void checkPlayerStrategy() {

    }



    public List<Player> getPlayers() {
        return players;
    }
}
