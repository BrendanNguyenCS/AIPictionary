package cs410.aipictionary.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    @DisplayName("Player: incrementScore")
    void incrementScore() {
        Player p = new Player("Brendan");
        assertEquals(0, p.getScore());
        p.incrementScore();
        assertEquals(1, p.getScore());
    }

    @Test
    @DisplayName("Player: toString")
    void testToString() {
        Player p = new Player("Brendan");
        assertEquals("Brendan: 0", p.toString());
        p.incrementScore();
        assertEquals("Brendan: 1", p.toString());
    }

    @Test
    @DisplayName("Player: getName")
    void getName() {
        Player p = new Player("Brendan");
        assertEquals("Brendan", p.getName());
    }

    @Test
    @DisplayName("Player: getScore")
    void getScore() {
        Player p = new Player("Brendan");
        assertEquals(0, p.getScore());
        p.incrementScore();
        assertEquals(1, p.getScore());
    }
}