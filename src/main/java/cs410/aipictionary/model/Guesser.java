package cs410.aipictionary.model;

import lombok.Getter;

import java.util.Set;
import java.util.HashSet;

/**
 * Guesser is a class that represents a player that attempts to guess all three words within the prompt
 * to maximize the number of points to win. 
 * A prompt consists of a sequence of 3 words (e.g., "Tree" "Green" "Tall"), 
 * and a drawn image is shown to the guessers based on the prompt.
 */
@Getter
public class Guesser extends Player {
    private final Set<String> guesses;

    /**
     * Constructor for Guesser.
     * @param guesser the guesser's name.
     */
    public Guesser(String guesser) {
        super(guesser);
        this.guesses = new HashSet<>();
    }

    /**
     * Returns the guesser's name.
     */
    public String getGuesser() {
        return super.getName();
    }

    /**
     * Adds a guess to the guesses set.
     * @param guess the guess to be added.
     */
    public void addGuess(String guess) {
        this.guesses.add(guess);
    }

    /**
     * Clears the guesses set.
     */
    public void clearGuesses() {
        this.guesses.clear();
    }
}
