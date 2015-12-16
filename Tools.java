
import java.util.*;

public class Tools {

	private Scanner stdin = new Scanner(System.in);

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
				System.out.printf("Enter a number in the range of %d and %d!\n", min, max);
			} else {
				break;
			}
		}
		
		return n;
	}

}

