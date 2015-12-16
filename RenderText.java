// RenderText.java
// Paul Krishnamurthy
// Pokemon Arena Assignment

import java.util.*;

public class RenderText extends Tools {

	/**
	 * Prints a string to the console with a typing effect
	 * 
	 * @param contents     The contents to be printed
	 */
	public static void delayedCharPrint(String content, long milliseconds) {
		for (int i = 0; i < content.length(); i++) {
			System.out.print(content.charAt(i));
			sleep(milliseconds);
		}
		System.out.println();
	}

	/**
	 * Prints lines of multiline text with a delay
	 * 
	 * @param multiline     String array of lines to print 
	 */
	public static void delayedLinePrint(String[] multiline, long milliseconds) {
		for (int i = 0; i < multiline.length; i++) {
			System.out.println(multiline[i]);
			sleep(milliseconds);
		}
	}

	/**
	 * Displays pokemon in a table with row numbers dependent on number of pokemons
	 * 
	 * @param size     Number of pokemon
	 */
	public static void listPokemon(int size) {
		if (size == 20) {
			
		}
	}

	/**
	 * Clears console
	 */
	public static void clearConsole() {
		// Clear differently based on operating system
		if (System.getProperty("os.name").toLowerCase().contains("windows")) {
			for (int i = 0; i < 40; i++) {
				System.out.println("\n");
			}
		// Proper method to clear for unix
		// Thanks to stackoverflow
		} else {
			System.out.print("\u001b[2J" + "\u001b[H");
			System.out.flush();
		}
	}

}

