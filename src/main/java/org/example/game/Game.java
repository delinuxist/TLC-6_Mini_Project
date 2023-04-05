package org.example.game;

import org.example.custom_exceptions.PlayersExceedLimit;
import org.example.deck.Deck;
import org.example.player.Player;
import org.example.player.Strategy;

import java.util.*;
public class Game {
      private List<Player> players = new ArrayList<>();
      private Deck deck;
      private List<Player> winners = new ArrayList<>();

    public List<Player> getWinners() {
        return winners;
    }

    public Game(){
          deck = new Deck();
    }

    public Deck getDeck() {
        return deck;
    }

    public void startGame(int numberOfPlayers) {
         try {

             createPlayers(numberOfPlayers);
             shuffleDeck();
             System.out.println("Round 1");
             initialCardShare();
             removeGoBustPlayers();
             assignStrategy();
             viewPlayers();
             checkForPlayersWithCompleteHandValue();
             if (winners.size() > 0) {
                 return;
             }

             if (allPlayersStick()){
                 int maxValue = 0;
                 for (Player player : players) {
                     if (player.getHandValue() > maxValue) {
                         maxValue = player.getHandValue();
                         getWinners().clear();
                         getWinners().add(player);
                     } else if (player.getHandValue() == maxValue) {
                         getWinners().add(player);
                     }
                 }
             }
            boolean endOfGame = false;
             int round = 2;
             while (!endOfGame) {
                 System.out.println("Round " + round++);
                 checkForPlayersWithCompleteHandValue();
                 if (winners.size() > 0) {
                     return;
                 }
                 cardShare();
                 removeGoBustPlayers();
                 assignStrategy();
                 viewPlayers();

                 if (allPlayersStick()){
                    int maxValue = 0;
                     for (Player player : players) {
                         if (player.getHandValue() > maxValue) {
                             maxValue = player.getHandValue();
                             getWinners().clear();
                             getWinners().add(player);
                         } else if (player.getHandValue() == maxValue) {
                             getWinners().add(player);
                         }
                     }
                     endOfGame = true;
                 }
             }




//             loop
//             for(int i=0; i < players.size(); i++ ){
//                    if (players.get(i).getStrategy() == null && players.get(i).hasWon()) {
//                        System.out.println(players.get(i));
//                        break;
//                    } else if (players.size() == 1 ) {
//                        System.out.println(players.get(0));
//                        break;
//                    }else if(checkAllStick()){
//
//                    }
//                    cardShare();
//                    removeGoBustPlayers();
//                }




         } catch (PlayersExceedLimit e){
             System.out.println(e.getMessage());
         }

    }

    private void viewPlayers() {
        for (Player player : players) {
            System.out.println(player);
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
        int counter = players.size();
         for(int i=0; i < counter; i++ ){
             int value = players.get(i).getHandValue();
             if (value > 21){
                 players.remove(players.get(i));
             }
             counter = players.size();
         }
    }

    void initialCardShare() {
        for (int i = 0;i< 2;i++) {
            for (Player player : players) {
                player.addCard(deck.getDeck().remove(0));
            }
        }
    }

    public void checkForPlayersWithCompleteHandValue() {
        for (Player player : players) {
            if (player.getStrategy() == null && player.hasWon()) {
                winners.add(player);
            }
        }
    }

    public boolean allPlayersStick() {
        for (Player player :
                players) {
            if (player.getStrategy() != Strategy.STICK) {
                return false;
            }
        }
        return true;
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


    public void createPlayers(int numberOfPlayers) throws PlayersExceedLimit {
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
