package cs410.aipictionary.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GuesserTest {

    @Test
    @DisplayName("Guesser: getGuesser")
    void getGuesser() {
        Guesser guesser = new Guesser("Alberto");
        assertEquals("Alberto", guesser.getGuesser());
    }

    @Test
    @DisplayName("Guesser: addGuess")
    void addGuess() {
        Guesser guesser = new Guesser("Alberto");
        guesser.addGuess("Tree Green Tall");
        assertTrue(guesser.getGuesses().contains("Tree Green Tall"));
    }

    @Test
    @DisplayName("Guesser: getScore")
    void getScore() {
        Guesser guesser = new Guesser("Alberto");
        assertEquals(0, guesser.getScore());
        guesser.incrementScore();
        assertEquals(1, guesser.getScore());
    }

    @Test
    @DisplayName("Guesser: clearGuesses")
    void clearGuesses() {
        Guesser guesser = new Guesser("Alberto");
        guesser.addGuess("Tree Green Tall");
        guesser.addGuess("Yellow Tall Pencil");
        guesser.addGuess("Blue Sky Clouds");
        assertEquals(3, guesser.getGuesses().size());
        guesser.clearGuesses();
        assertEquals(0, guesser.getGuesses().size());
    }

    @Test
    @DisplayName("Guesser: toString")
    void toStringTest() {
        Guesser guesser = new Guesser("Alberto");
        assertEquals("Alberto: 0", guesser.toString());
        guesser.incrementScore();
        assertEquals("Alberto: 1", guesser.toString());
    }
}