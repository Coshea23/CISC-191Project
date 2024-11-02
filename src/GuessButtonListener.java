/**
 * GuessButtonListener.java
 * 
 * This class is an ActionListener for the Guess button in the Word Puzzle Game. 
 * It captures the player's input, validates it as a single character guess, 
 * and then invokes the game's checkGuess method to process the guess.
 * 
 * Dependencies: Requires the WordPuzzleGame class with access to its input 
 * field and checkGuess method.
 * 
 * Methods:
 * - actionPerformed(ActionEvent e): Handles the action event triggered 
 *   by the Guess button and processes the player's input.
 * 
 * Author: Javier & Christopher
 * Date: 29Oct24
 * 
 */
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

public class GuessButtonListener implements ActionListener
{
	private WordPuzzleGame game;
	
	public GuessButtonListener(WordPuzzleGame game)
	{
		this.game = game;
	}	
	@Override
    public void actionPerformed(ActionEvent e) {
        String guess = game.input.getText(); // Access the input field from the game
        if (guess.length() == 1) {
            char guessedChar = guess.charAt(0);
            game.checkGuess(guessedChar); // Check the guess using the game method
            game.input.setText(""); // Clear the input field
        }
    }
}
	
