// Testing java code

import java.io.Console;

public class Test {
	public static Console console = System.console();
	public static void main(String[] args) {
		
		char[] pwd = console.readPassword();
	}
}
