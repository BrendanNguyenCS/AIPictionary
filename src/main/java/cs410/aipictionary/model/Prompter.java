package cs410.aipictionary.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;
import java.util.HashSet;

@Getter
public class Prompter extends Player {
    // Set of prompts.
    private final Set<String> options;

    // Prompt.
    @Setter
    private String prompt;

    /**
     * Constructor for Prompter that initializes 
     * the prompt and the set of prompts.
     */
    public Prompter(String name) {
        super(name);
        this.options = new HashSet<>();
        this.prompt = "";
    }

    /**
     * Adds a prompt to the options set.
     * @param prompt the prompt to be added.
     */
    public void addPrompt(String prompt) {
        this.options.add(prompt);
    }

    /**
     * Returns the String representation of the prompter.
     */
    @Override
    public String toString() {
        return String.format(this.getName() + ": " + super.getScore() + "\n" +
        "Prompt: " + this.prompt + "\n" + "Options: " + this.options);
    }
}
