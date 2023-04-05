package org.example.game;

import org.example.custom_exceptions.PlayersExceedLimit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    Game game;
    @BeforeEach
    void setUp() {
        game = new Game();
    }

    @Test
    void shouldCheckIfDeckCardsAreShuffled() {

        // when
        var clone =  game.getDeck().getDeck().clone();

        // then
        game.shuffleDeck();

        assertNotEquals(clone,game.getDeck().getDeck());

    }
 @ParameterizedTest
 @ValueSource(ints = {7,8,9,10})
    void shouldThrowPlayersExceedLimitException(int number) {
       assertThrows(PlayersExceedLimit.class,()-> game.createPlayers(number));
    }

}