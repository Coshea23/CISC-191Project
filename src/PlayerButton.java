/**
 * PlayerButton.java
 * 
 * This class represents a button in the Word Guessing Game that displays a 
 * specific letter. Each button allows the player to select a letter as their guess. 
 * The button holds its assigned letter as an attribute and includes a method to 
 * add an ActionListener for handling player input.
 * 
 * Inherits: JButton from javax.swing package.
 * 
 * Attributes:
 * - letter: Stores the character displayed on the button, representing the player's guess.
 * 
 * Methods:
 * - getLetter(): Returns the character associated with this button.
 * - addWordListener(ActionListener listener): Adds an ActionListener to handle the button click event.
 * 
 * Author: Javier & Chris
 * Date: 29 Oct 24
 * 
 */
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class PlayerButton extends JButton
{
	private char letter;
	
	public PlayerButton(char letter)
	{
		super(String.valueOf(letter));
		this.letter = letter;
	}
	
	public char getLetter()
	{
		return letter;
	}
	
	public void addWordListener(ActionListener listener)
	{
		this.addActionListener(listener);
	}
}
