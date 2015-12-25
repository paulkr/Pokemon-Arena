// Tools.java
// Paul Krishnamurthy
// Pokemon Arena Assignment

import java.util.*;
import java.io.Console;

public class Tools {

	private Scanner stdin = new Scanner(System.in);
	private Console console = System.console();

	public String getString(String toFind) {
		String output = "";
		
		if (toFind.equals("enter")) {
			// Mask input to appear as only enter was pressed
			char[] hidden = console.readPassword("");
			output = "enter";
		} else {
			output = stdin.nextLine();
		}

		return output;
	}

	public int getInt(int min, int max, String message) {
		int n;

		while (true) {
			System.out.print(message);
			String input = stdin.nextLine();
			// Try to parse input as integer
			try {
				n = Integer.parseInt(input);
			} catch (NumberFormatException e) {
				System.out.println("Please enter a number!");
				continue; // Skip to next iteration
			}

			// If the number is not an acceptable range
			if (n < min || n > max) {
				System.out.printf("That's not an option! Enter a number in the range of %d and %d!\n", min, max);
			} else {
				break; // Valid input 
			}
		}
		return n;
	}

}

