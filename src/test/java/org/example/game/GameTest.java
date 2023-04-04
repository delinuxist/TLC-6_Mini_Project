package org.example.game;

import org.example.card.Card;
import org.example.custom_exceptions.PlayersExceedLimit;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;

class GameTest {

    @Test
    void testShuffle() {
        // given
        Game game = new Game();

        // when
        var clone =  game.getDeck().getDeck().clone();

        // then
        game.shuffleDeck();

        assertNotEquals(clone,game.getDeck().getDeck());

    }

    @Test
    void testCreatePlayers() throws PlayersExceedLimit {
        // given
        Game mockedGame = mock(Game.class);

        // when

    }

}