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
	public static void delayedCharPrint(String content) {
		for (int i = 0; i < content.length(); i++) {
			System.out.print(content.charAt(i));
			sleep(40);
		}
		System.out.println();
	}

	/**
	 * Prints lines of multiline text with a delay
	 * 
	 * @param multiline     String array of lines to print 
	 */
	public static void delayedLinePrint(String[] multiline) {
		for (int i = 0; i < multiline.length; i++) {
			System.out.println(multiline[i]);
			sleep(40);
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

