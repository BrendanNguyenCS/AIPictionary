package cs410.aipictionary.model;

import lombok.Getter;
import lombok.Setter;

/**
 * Player is a class that represents a player in the game, 
 * whether it is a prompter or guesser.
 * This class contains the player's name and score.
 */
@Getter
class Player {

    private final String name;

    private int score;

    /**
     * Constructor for Player.
     * @param name the player's name.
     */
    public Player(String name) {
        this.name = name;
        this.score = 0;
    }

    /**
     * Increments the player's score.
     */
    public void incrementScore() {
        this.score++;
    }

    /**
     * Returns a string representation of the player.
     */
    public String toString() {
        return this.name + ": " + this.score;
    }
}
