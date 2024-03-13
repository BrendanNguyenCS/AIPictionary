package cs410.aipictionary.model;

import lombok.Getter;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/**
 * GameState is a class that represents the state of the AI Pictionary game.
 * This class makes sure the game is played in the correct order and according to the rules.
 * 
 * There are 4-6 players in the game, and each player is either a prompter or guesser.
 * There is one prompter, where it selects a prompt out of three options,
 * and the remaining players are guessers, where they attempt to get as many points 
 * before the round is over. More specifically, the prompt is associated with an image,
 * and the guessers attempt to guess the image based on the prompt. 
 * 
 * A prompt consists of a sequence of 3 words (e.g., "Tree" "Green" "Tall"),
 * and the guesser attempts to guess all three words within the prompt.
 */
@Getter
public class GameState {
    // List of players.
    private final List<Player> players;

    // Number of players (4-6).
    private final int countPlayers;

    // Number of rounds.
    private final int round;

    /**
     * Constructor that initializes the number of players, where the prompter role is given 
     * to a random player and the remaining players are guessers.
     * @param countPlayers the number of players in the game.
     */
    public GameState(int countPlayers) {
        // If the number of players is not between 4 and 6, 
        // throw an IllegalArgumentException error.
        if (countPlayers < 4 || countPlayers > 6) {
            throw new IllegalArgumentException("Number of players must be between 4 and 6.");
        }

        // Initialize players as guessers first.
        this.countPlayers = countPlayers;
        this.players = new ArrayList<>();
        this.round = 1;
        for (int i = 0; i < countPlayers; i++) {
            this.players.add(new Guesser("Player " + i));
        }

        // Shuffle the list of players and set the first player as the prompter.
        Collections.shuffle(players);
    }

    /**
     * Starts the game
     */
    public static GameState startGame(int countPlayers) {
        return new GameState(countPlayers);
    }

    void rotatePlayers() {
        Player front = players.removeFirst();
        players.addLast(front);
    }

    /**
     * TODO: Runs one round of the game.
     */
    public void runOneRound() {

    }

    /**
     * Returns true if the game is over, and false otherwise.
     * A game is over if the round is equal to the number of players times 3.
     */
    public boolean isGameOver() {
        return getRound() == getCountPlayers() * 3;
    }

    public static void main(String[] args) {}
}
