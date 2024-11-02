/**
 * WordPuzzleGame.java
 * 
 * This class represents the main frame for the Word Guessing Game, providing a 
 * graphical user interface (GUI) where players can input their guesses to reveal 
 * letters in a hidden word. The game uses Swing components to display the game 
 * status, manage player input, and update the game view.
 * 
 * Dependencies: 
 * - javax.swing and java.awt packages for creating the GUI.
 * - Requires GuessButtonListener for handling the guess button action.
 * 
 * Attributes:
 * - displayLabel: Displays the current state of the guessed word.
 * - guessedWord: Holds the player's current progress in guessing the word.
 * - messageLabel: Displays feedback messages for each guess.
 * - selectedWord: Stores the current word to be guessed.
 * - input: A text field for player input.
 * - wordList: A list of words for the game.
 * 
 * Methods:
 * - initializeWordList(): Initializes the word list with predefined words.
 * - getDisplayWord(): Returns the current guessed word as a string.
 * - selectNewWord(): Selects a random word from the word list and initializes the display.
 * - checkGuess(char guessedChar): Checks if the guessed character is in the word and updates the game view.
 * - main(String[] args): Entry point to launch the game.
 * 
 * Author: Javier & Christopher
 * Date: 29 Oct 24
 * 
 */
import java.awt.BorderLayout;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;

public class WordPuzzleGame extends JFrame
{
	private JLabel displayLabel;
	private char[] guessedWord;
	private JLabel messageLabel;
	private String selectedWord;
	JTextField input;
	private List<String> wordList;

	public WordPuzzleGame()
	{
		setTitle("Word Puzzle Game");
		setSize(600, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

		initializeWordList();
		selectNewWord();

		displayLabel = new JLabel(getDisplayWord(), SwingConstants.CENTER);
		displayLabel.setFont(new Font("Arial", Font.BOLD, 20));
		messageLabel = new JLabel("", SwingConstants.CENTER);

		input = new JTextField(1);
		JButton guessButton = new JButton("Guess");
		guessButton.addActionListener(new GuessButtonListener(this));

		JPanel inputPanel = new JPanel();
		inputPanel.add(input);
		inputPanel.add(guessButton);

		add(displayLabel, BorderLayout.CENTER);
		add(messageLabel, BorderLayout.NORTH);
		add(inputPanel, BorderLayout.SOUTH);

		setVisible(true);

	}

	private void initializeWordList()
	{
		wordList = new ArrayList<>();
		wordList.add("programming");
		wordList.add("java");
		wordList.add("cybersecurity");
		wordList.add("phone");
		wordList.add("internet");

	}

	private String getDisplayWord()
	{
		return String.valueOf(guessedWord);
	}

	private void selectNewWord()
	{
		Random random = new Random();
		selectedWord = wordList.get(random.nextInt(wordList.size())); // Select
																		// a
																		// random
																		// word
		guessedWord = new char[selectedWord.length()];
		for (int i = 0; i < guessedWord.length; i++)
		{
			guessedWord[i] = '_'; // Initialize with underscores
		}
	}

	public void checkGuess(char guessedChar)
	{
		boolean correctGuess = false;

		// Check if guessed character is in the selected word
		for (int i = 0; i < selectedWord.length(); i++)
		{
			if (selectedWord.charAt(i) == guessedChar)
			{
				guessedWord[i] = guessedChar; // Update guessed word
				correctGuess = true;
			}
		}

		if (correctGuess)
		{
			messageLabel.setText("Good guess!");
		}
		else
		{
			messageLabel.setText("Try again!");
		}

		displayLabel.setText(getDisplayWord());
	}

	public static void main(String[] args)
	{
		new WordPuzzleGame();
	}
}
