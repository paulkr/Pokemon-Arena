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

	public int getInt(int min, int max) {
		int n;

		while (true) {
			String input = stdin.nextLine();
			try {
				n = Integer.parseInt(input);
			} catch (NumberFormatException e) {
				System.out.println("Please enter a number!");
				continue; // Skip to next iteration
			}

			if (n < min || n > max) {
				System.out.printf("That's not an option! Enter a number in the range of %d and %d!\n", min, max);
			} else {
				break; // Valid input 
			}
		}
		return n;
	}

}

