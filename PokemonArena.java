/**
 * PokemonArena.java
 * Main class with entire game sequence 
 *
 *  @author Paul Krishnamurthy
 */

import java.util.*;

public class PokemonArena extends RenderText {

	private static PokemonCollection pokeLot      = new PokemonCollection();
	private static ArrayList<Pokemon> pokemonTeam = new ArrayList<Pokemon>();
	private static ASCII displayArt               = new ASCII(); 
	private static Tools tools                    = new Tools();
	private static Scanner stdin                  = new Scanner(System.in);

	public static void main(String[] args) {

		

		// gameIntro();
		// selectPokemon();

		boolean winning = true;

		while (true) {

			// Randomly select if user or computer goes first
			String starter = tools.randChoice() ? "user" : "enemy";
			winning = battleSequence(pokeLot.randomPokemon(), starter);

		}

	}

	/**
	 * Graphic sequence for game introduction
	 */
	public static void gameIntro() {
		// Display titles
		displayArt.introTitle();
		clearConsole();

		// Prompt for enter to be pressed
		System.out.println("Press [enter] to start...");
		tools.getString("enter");
		clearConsole();

		// Welcome message
		delayedLinePrint(new String[] {
			"Welcome to the Pokemon Arena!",
			"Be prepared for what lies ahead!",
			"Start off by picking your team...", "\n"
		}, 20);

		sleep(1000);
	}

	/**
	 * Method for user to select 4 Pokemon for their team
	 */
	public static void selectPokemon() {
		int chosen = 0; // Counter for number of selected Pokemon

		while (chosen != 4) {
			delayedCharPrint("Pick " + (4 - chosen) + " pokemon for your collection!", 40);

			delayedCharPrint("Here are your options: ", 40);
			listPokemon(pokeLot.pokemons); // List all available options to chose from

			// Get the user's selection as a Pokemon object
			int selectedPokemonIndex = tools.getInt(1, pokeLot.pokemons.size(), "Enter number: ");
			Pokemon selectedPokemon = pokeLot.pokemons.get(selectedPokemonIndex - 1);

			// Add to the pokemon team and remove from the options
			pokemonTeam.add(selectedPokemon);
			pokeLot.removePokemon(selectedPokemon.name);

			delayedCharPrint("You selected: " + selectedPokemon.name, 40);

			chosen ++;
		}

		// Display user's Pokemon team
		delayedCharPrint("Awesome job! Here is your team", 40);	

		for (int i = 0; i < pokemonTeam.size(); i++) {
			System.out.println(pokemonTeam.get(i).name);
		}

		sleep(500);
		delayedCharPrint("Get ready to fight!", 35);

		// clearConsole();
	}

	/**
	 * Battle sequence with one enemy
	 * 
	 * @param  enemy     Pokemon enemy object
	 * @return           Boolean if user's Pokemon won or lost
	 */
	public static boolean battleSequence(Pokemon enemy, String starter) {

		boolean isWinnning = true;

		while (isWinnning) {

			// User attack
			if (starter.equals("user")) {
				System.out.println("user attack");
			// Enemy attack
			} else {
				System.out.println("enemy attack");
			}

			// Switch turn
			starter = starter.equals("user") ? "enemy" : "user";

		}

		return isWinnning;
	}

}
