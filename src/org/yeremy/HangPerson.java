package org.yeremy;

import java.util.*;
import java.io.FileInputStream;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class HangPerson {
	private int ARRAYSIZE = 100;
	private int LETTERS_GUESSED_SIZE = 100;
	char[] lettersGuessed;
	private int lettersGuessedIndex;
	boolean [] isLetterGuessed;
	private int wrongGuesses;
	private int correctGuesses;
	private char[] currentWord;
	private String[] wordsList;
	private int currentWordIndex = -1;
	boolean gameStatus; // false if user lost the game; true if user won the game
	private String input;

	/**
	 * Constructor of HangPerson class
	 * @param wordsFile Scanner file containing all the words read from the file
	 */
	HangPerson(Scanner wordsFile) {
		int index = 0;
		wordsList = new String[ARRAYSIZE];
		while (wordsFile.hasNextLine()) {
			wordsList[index] = wordsFile.nextLine();
			if (index == ARRAYSIZE - 1)
				resizeWordsListArray();
			index++;
		}
		lettersGuessed = new char[LETTERS_GUESSED_SIZE];
	}

	/**
	 *  Resizes the wordsList array, it happens when the list of words exceeds 100
	 */
	private void resizeWordsListArray() {
		ARRAYSIZE *= 2;
		String[] tempWordsList = new String[ARRAYSIZE];

		//Copying the old array
		for (int i = 0; i < ARRAYSIZE / 2 ; i++) {
			tempWordsList[i] = wordsList[i];
		}
		wordsList = tempWordsList;
	}

	/**
	 * Displays the game intro
	 */
	public void displayGameIntro() {
		System.out.println("Welcome to the hangperson game ...");
		System.out.println("To play, guess a letter to try to guess the word.");
		System.out.println("Every time you choose an incorrect letter another");
		System.out.println("body part appears on the gallows. If you guess the");
		System.out.println("word before you're hung, you win :-)");
		System.out.println("If you get hung you lose :-(\n");
		System.out.println("Time to guess ...\n");

	}

	/**
	 * Contains all game logic
	 */
	public void play()
	{
		initialize();
		displayStatus();

		char[] inputChar;
		Scanner keyboard = new Scanner(System.in);
		boolean newLetterFound;
		boolean previouslyFound;

		// Loop until the user wins or loses
		while(true) {
			newLetterFound = false;
			previouslyFound = false;
			System.out.println();
			System.out.print("Choose a letter => ");
			input = keyboard.next();
			if (!validateInput(input)) {
				System.out.println("\nInvalid, don't you know your ABCs?");
				continue;
			}

			inputChar = input.toCharArray();

			// Loop through all letters in the word
			for (int i = 0; i < currentWord.length; i++){
				if (inputChar[0] == currentWord[i]) {
					if (isLetterGuessed[i]) {
						previouslyFound = true;
					}
					isLetterGuessed[i] = true;
					if (!previouslyFound) {
						newLetterFound = true;
						correctGuesses++;
					}
					else newLetterFound = false;
				}
			}

			if (newLetterFound) lettersGuessed[lettersGuessedIndex++] = inputChar[0];
			if (!newLetterFound) {
				if(!previouslyFound) {
					wrongGuesses++;
					displayStatus();
				}
				else {
					System.out.println("\nYou already tried this letter");
				}
			}
			else {
				displayStatus();
			}


			// Check if user lost the game
			if (wrongGuesses == 7) {
				gameStatus = false;
				break;
			}

			// Check if user won the game
			if (correctGuesses == currentWord.length) {
				gameStatus = true;
				break;
			}
		}

		if (gameStatus) {
			System.out.println("\nCongratulations, you win!!!");
			System.out.println();
		}
		else {
			System.out.println("\nToo bad, you lose!");
			System.out.print("The word was ==> ");
			for (int i = 0; i < currentWord.length; i++) {
				System.out.print(currentWord[i]);
			}
			System.out.println("\n");

		}



	}

	/**
	 * Validates input
	 * @param text String entered by the user
	 * @return true if user entered one letter alphabetic character. False otherwise.
	 */
	private boolean validateInput(String text) {
		String pattern = "^[A-z]+$";
		if (text.length() > 1) return false;
		if(Pattern.matches(pattern, text)) return true;
		else return false;
	}

	/**
	 * Initializes the game and game internal variables.
	 */
	private void initialize() {
		currentWordIndex++;
		currentWord = wordsList[currentWordIndex].toCharArray();
		lettersGuessed = new char[currentWord.length];
		isLetterGuessed = new boolean[currentWord.length];
		lettersGuessedIndex = 0;
		wrongGuesses = 0;
		correctGuesses = 0;
		for (int i = 0; i < isLetterGuessed.length; i++) {
			isLetterGuessed[i] = false;
		}
	}

	/**
	 * Displays the status of the game
	 */
	private void displayStatus() {

		displayPerson();
		System.out.print("Letters guessed already => ");
		for (int i = 0; i < lettersGuessed.length; i++) {
			System.out.print(lettersGuessed[i] + " ");
		}
		System.out.println("\nNumber of wrong guesses => " + wrongGuesses);
		System.out.print("The word so far => ");
		for (int i = 0; i < currentWord.length; i++) {
			if (isLetterGuessed[i]) {
				System.out.print(currentWord[i]);
			}
			else {
				System.out.print("-");
			}
		}
		System.out.println();

	}

	/**
	 * Displays the hang person
	 */
	private void displayPerson() {
		switch(wrongGuesses) {
		case 0:
			System.out.println("|-----|-");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|______________\n");
			break;
		case 1:
			System.out.println("|-----|-");
			System.out.println("|     O");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|______________\n");
			break;
		case 2:
			System.out.println("|-----|-");
			System.out.println("|     O");
			System.out.println("|     |");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|______________\n");
			break;
		case 3:
			System.out.println("|-----|-");
			System.out.println("|     O");
			System.out.println("|     |");
			System.out.println("|     |");
			System.out.println("|");
			System.out.println("|______________\n");
			break;
		case 4:
			System.out.println("|-----|-");
			System.out.println("|     O  ");
			System.out.println("|    \\|");
			System.out.println("|     |");
			System.out.println("|");
			System.out.println("|______________\n");
			break;
		case 5:
			System.out.println("|-----|-");
			System.out.println("|     O  ");
			System.out.println("|    \\|/");
			System.out.println("|     |");
			System.out.println("|");
			System.out.println("|______________\n");
			break;
		case 6:
			System.out.println("|-----|-");
			System.out.println("|     O  ");
			System.out.println("|    \\|/");
			System.out.println("|     |");
			System.out.println("|    /");
			System.out.println("|______________\n");
			break;
		case 7:
			System.out.println("|-----|-");
			System.out.println("|     O  ");
			System.out.println("|    \\|/");
			System.out.println("|     |");
			System.out.println("|    / \\");
			System.out.println("|______________\n");
			break;
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
