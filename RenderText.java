/**
 * RenderText.java
 * Displays text with styled effects
 *
 *  @author Paul Krishnamurthy
 */

import java.util.*;

public class RenderText {

	/**
	 * Pauses the program for a given duration
	 * 
	 * @param milliseconds    The duration, in milliseconds, to pause the program
	 */
	public static void sleep(long milliseconds) {
		try {
			Thread.sleep(milliseconds);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Prints a string to the console with a typing effect
	 * 
	 * @param contents          The contents to be printed
	 * @param  milliseconds     Duration to sleep in milliseconds
	 */
	public static void delayedCharPrint(String content, long milliseconds) {
		for (int i = 0; i < content.length(); i++) {
			// Don't sleep for spaces
			if (content.charAt(i) == ' ') {
				System.out.print(content.charAt(i));
			} else {
				System.out.print(content.charAt(i));
				sleep(milliseconds);
			}
		}
		System.out.println();
	}

	/**
	 * Prints lines of multiline text with a delay
	 * 
	 * @param multiline         String array of lines to print
	 * @param  milliseconds     Duration to sleep in milliseconds 
	 */
	public static void delayedLinePrint(String[] multiline, long milliseconds) {
		for (int i = 0; i < multiline.length; i++) {
			System.out.println(multiline[i]);
			sleep(milliseconds);
		}
	}

	/**
	 * Displays and numbers Pokemon in a styled table
	 * 
	 * @param pokemons     ArrayList of Pokemon objects
	 */
	public static void listPokemon(ArrayList<Pokemon> pokemons) {
		int limit = pokemons.size(); // The number of Pokemon
		// Display data in a formatted table
		// Special formatting for spaces required for row with single and double digit numbers
		System.out.println("+---------------------------------+");
		for (int i = 0; i < limit; i++) {
			// Display two Pokemon names side-by-side
			if (i + 1 < limit) {
				if (i > 9) {
					delayedCharPrint(String.format("| %d. %10s | %d. %10s |", (i + 1), pokemons.get(i).name, (i + 2), pokemons.get(i + 1).name), 4);
				} else {
					if (i == 8) {
						delayedCharPrint(String.format("| %d. %11s | %d. %10s |", (i + 1), pokemons.get(i).name, (i + 2), pokemons.get(i + 1).name), 4);
					} else {
						delayedCharPrint(String.format("| %d. %11s | %d. %11s |", (i + 1), pokemons.get(i).name, (i + 2), pokemons.get(i + 1).name), 4);
					}
				}
				i += 1;
				System.out.println("+---------------------------------+");
			// Display a row with only 1 Pokemon name
			} else {
				if (i > 9) {
					delayedCharPrint(String.format("| %d. %10s |", (i + 1), pokemons.get(i).name), 4);
					System.out.println("+----------------+");
				} else {
					delayedCharPrint(String.format("| %d. %11s |", (i + 1), pokemons.get(i).name), 4);
					System.out.println("+----------------+");
				}
				break;
			}
		}
	}

	/**
	 * Displays a set of options in a nice table
	 * 
	 * @param options     String[] of options
	 * @param message     Message to be displayed
	 */
	public static void listOptions(String[] options, String message) {

		delayedCharPrint(message, 40);

		

	}

	/**
	 * Clears console based on operating system
	 */
	public static void clearConsole() {
		// Clear differently based on operating system using appropriate command
		try {
			// Invoking console clearing properly thanks to StackOverflow
			if (System.getProperty("os.name").toLowerCase().contains("windows")) {
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			} else {
				System.out.print("\033[H\033[2J");  
    			System.out.flush();
			}
		} catch(Exception e) {
			// If all else fails, print some blank lines!
			for (int i = 0; i < 40; i++) {
				System.out.println();
			}
		}
	}

}

