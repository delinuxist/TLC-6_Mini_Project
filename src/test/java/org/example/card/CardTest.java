package org.example.card;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CardTest {

    @Test
    void getRandTest() {
        // given
        Card card = mock(Card.class);

        // when
        int result = card.getRank();
        System.out.println(result);

        // then
        assertInstanceOf(Integer.class,result);
    }
}