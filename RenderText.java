// RenderText.java
// Paul Krishnamurthy
// Pokemon Arena Assignment

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
	 * @param contents     The contents to be printed
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
	public static void listPokemon(ArrayList<Pokemon> pokemons) {
		int limit = pokemons.size();
		String row;
		System.out.println("+---------------------------------+");
		for (int i = 0; i < limit; i++) {
			if (i + 1 < limit) {
				if (i > 9) {
					row = String.format("| %d. %10s | %d. %10s |", (i + 1), pokemons.get(i).name, (i + 2), pokemons.get(i + 1).name);
					delayedCharPrint(row, 4);
				} else {
					if (i == 8) {
						row = String.format("| %d. %11s | %d. %10s |", (i + 1), pokemons.get(i).name, (i + 2), pokemons.get(i + 1).name);
						delayedCharPrint(row, 4);
					} else {
						row = String.format("| %d. %11s | %d. %11s |", (i + 1), pokemons.get(i).name, (i + 2), pokemons.get(i + 1).name);
						delayedCharPrint(row, 4);
					}
				}
				i += 1;
				System.out.println("+---------------------------------+");
			} else {
				if (i > 9) {
					row = String.format("| %d. %10s |", (i + 1), pokemons.get(i).name);
					delayedCharPrint(row, 4);
					System.out.println("+----------------+");
				} else {
					row = String.format("| %d. %11s |", (i + 1), pokemons.get(i).name);
					delayedCharPrint(row, 4);
					System.out.println("+----------------+");
				}
				break;
			}
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

