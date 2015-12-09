// RenderText.java
// Paul Krishnamurthy
// Pokemon Arena Assignment

import java.util.*;

public class RenderText {

	/**
	 * Pauses the program for a given duration
	 * 
	 * @param milliseconds The duration, in milliseconds, to pause the program
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
	 * @param contents The contents to be printed
	 */
	public static void delayedPrint(String content) {
		for (int i = 0; i < content.length(); i++) {
			System.out.print(content.charAt(i));
			sleep(40);
		}
	}

}

