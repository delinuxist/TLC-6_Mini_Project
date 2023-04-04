package org.example.deck;

import org.example.card.Card;
import org.example.card.Rank;
import org.example.card.Suit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class DeckTest {

    @Test
    void getDeckTest() {
        // given
        Card card = new Card(Rank.TWO,Suit.CLUBS);
        ArrayList<Card> testList = new ArrayList<>(){
            {add(card);}
        };

        // then
        assertEquals(testList.get(0).getRank(),Rank.TWO.getRank());
    }

}