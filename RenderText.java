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

}
