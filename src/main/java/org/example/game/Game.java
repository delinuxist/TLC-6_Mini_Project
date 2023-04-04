package org.example.game;

import org.example.card.Card;
import org.example.custom_exceptions.PlayersExceedLimit;
import org.example.deck.Deck;
import org.example.player.Player;
import org.example.player.Strategy;

import java.util.*;
public class Game {
      private List<Player> players = new ArrayList<>();
      private Deck deck;

     public Game(){
          deck = new Deck();
      }

    public void startGame(int numberOfPlayers) {
         boolean flag = true;
         try {
             createPlayers(numberOfPlayers);
             shuffleDeck();
             initialCardShare();
             removeGoBustPlayers();
             assignStrategy();
//             loop
             for(int i=0; i < players.size(); i++ ){
                    if (players.get(i).getStrategy() == null && players.get(i).hasWon()) {
                        System.out.println(players.get(i));
                        break;
                    } else if (players.size() == 1 ) {
                        System.out.println(players.get(0));
                        break;
                    }else if(checkAllStick()){

                    }
                    cardShare();
                    removeGoBustPlayers();
                }


         } catch (PlayersExceedLimit e){
             System.out.println(e.getMessage());
         }

    }

    // check if someone hit 21 -- done
    // go bust and if one player is left, the player wins
    // assign strategy
    // if all stick, choose player with the closest to 21
    // share card
    // Loop begins

    boolean checkAllStick() {
         for(Player player: players){
             if(player.getStrategy() != Strategy.STICK){
                 return false;
             }
         }
         return true;
    }

    void removeGoBustPlayers() {
         for(int i=0; i < players.size(); i++ ){
             int value = players.get(i).getHandValue();
             if (value > 21){
                 players.remove(players.get(i));
             }
         }
    }

    void initialCardShare() {
        for (int i = 0;i< 2;i++) {
            for (Player player : players) {
                player.addCard(deck.getDeck().remove(0));
            }
        }
    }

    void assignStrategy() {
         for(Player player : players){
             player.updatePlayerStatus();
         }
    }

    public void cardShare() {
        for (Player player : players) {
            if (player.getStrategy() == Strategy.HIT) {
                player.addCard(deck.getDeck().remove(0));
                player.updatePlayerStatus();
            }
        }
    }

      public void  shuffleDeck() {
          Collections.shuffle(deck.getDeck());
      }


    private void createPlayers(int numberOfPlayers) throws PlayersExceedLimit {
         if(numberOfPlayers >= 6 || numberOfPlayers < 1) {
             throw new PlayersExceedLimit("Players must be greater than one or less than or equal to six");
         }
         for (int i=0; i< numberOfPlayers; i++){
             players.add(new Player("Player-"+(i+1)));
         }
    }

    public List<Player> getPlayers() {
        return players;
    }
}
