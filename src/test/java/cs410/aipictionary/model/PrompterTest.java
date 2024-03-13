package cs410.aipictionary.model;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class PrompterTest {

    @Test
    @DisplayName("Prompter: getName")
    void getName() {
        Prompter p = new Prompter("Brendan");
        assertEquals("Brendan", p.getName());
    }

    @Test
    @DisplayName("Prompter: getScore")
    void getScore() {
        Prompter p = new Prompter("Brendan");
        assertEquals(0, p.getScore());
        p.incrementScore();
        assertEquals(1, p.getScore());
    }

    @Test
    @DisplayName("Prompter: setPrompt")
    void setPrompt() {
        Prompter p = new Prompter("Brendan");
        p.setPrompt("Hello");
        assertEquals("Hello", p.getPrompt());
    }

    @Test
    @DisplayName("Prompter: getPrompt")
    void getPrompt() {
        Prompter p = new Prompter("Brendan");
        p.setPrompt("Hello");
        assertEquals("Hello", p.getPrompt());
    }

    @Test
    @DisplayName("Prompter: addPrompt")
    void addPrompt() {
        Prompter p = new Prompter("Brendan");
        p.addPrompt("Hello");
        assertTrue(p.getOptions().contains("Hello"));
    }

    @Test
    @DisplayName("Prompter: toString")
    void testToString() {
        Prompter p = new Prompter("Brendan");
        p.setPrompt("Hello");
        p.addPrompt("Hello");
        assertEquals("Brendan: 0\nPrompt: Hello\nOptions: [Hello]", p.toString());
    }
}