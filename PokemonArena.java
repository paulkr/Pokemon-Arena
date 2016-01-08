/**
 * PokemonArena.java
 * Main class with entire game sequence 
 *
 *  @author Paul Krishnamurthy
 */

import java.util.*;

public class PokemonArena extends Tools {

	private static PokemonCollection pokeLot      = new PokemonCollection();
	private static ArrayList<Pokemon> pokemonTeam = new ArrayList<Pokemon>();
	private static ASCII displayArt               = new ASCII();
	private static Scanner stdin                  = new Scanner(System.in);

	public static void main (String[] args) {

		// gameIntro();

		selectPokemon();

		boolean winning = true;

		// While there are Pokemon to fight
		while (pokeLot.pokemons.size() > 0) {

			// Randomly select if user or computer goes first
			String starter = randChoice() ? "user" : "enemy";
			winning = battleSequence(pokeLot.randomPokemon(), starter);

		}

		if (winning) {
			delayedCharPrint("You won!", 30);
		} else {
			delayedCharPrint("You lost!", 30);
		}

	}

	/**
	 * Graphic sequence for game introduction
	 */
	public static void gameIntro () {
		// Display titles
		displayArt.introTitle();
		clearConsole();

		// Prompt for enter to be pressed
		System.out.println("Press [enter] to start...");
		getString("enter");
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
	public static void selectPokemon () {
		int chosen = 0; // Counter for number of selected Pokemon

		while (chosen != 4) {
			delayedCharPrint("Pick " + (4 - chosen) + " pokemon for your collection!", 40);

			delayedCharPrint("Here are your options: ", 40);
			listPokemon(pokeLot.pokemons); // List all available options to chose from

			// Get the user's selection as a Pokemon object
			int selectedPokemonIndex = getInt(1, pokeLot.pokemons.size(), "Enter number: ");
			Pokemon selectedPokemon = pokeLot.pokemons.get(selectedPokemonIndex - 1);

			// Add to the pokemon team and remove from the options
			pokemonTeam.add(selectedPokemon);
			pokeLot.removePokemon(selectedPokemon.toString());

			delayedCharPrint("You selected: " + selectedPokemon.toString(), 40);

			chosen ++;
		}

		// Display user's Pokemon team
		delayedCharPrint("Awesome job! Here is your team", 40);	

		for (int i = 0; i < pokemonTeam.size(); i++) {
			System.out.println(pokemonTeam.get(i).toString());
		}

		sleep(500);
		delayedCharPrint("Get ready to fight!", 35);
		sleep(600);

		clearConsole();
	}

	/**
	 * Choses Pokemon from current team
	 * 
	 * @return     The selected Pokemon
	 */
	public static Pokemon choseFromTeam () {
		delayedLinePrint(new String[] {
			"Select your Pokemon!",
			"Here is your team:"
		}, 30);

		listPokemon(pokemonTeam); // List all the Pokemon

		// Select and return Pokemon

		int pokeIndex = getInt(1, 4, "\nEnter your number: ");
		Pokemon curPokemon = pokemonTeam.get(pokeIndex - 1);

		delayedCharPrint(String.format("%s, I choose you!", curPokemon.toString()), 30);

		return curPokemon;
	}

	/**
	 * Battle sequence with one enemy
	 * 
	 * @param  enemy     Pokemon enemy object
	 * @return           Boolean if user's Pokemon won or lost
	 */
	public static boolean battleSequence (Pokemon enemy, String starter) {

		boolean isWinnning  = true;
		int curAttack;

		delayedCharPrint(String.format("A wild %s appears! Get ready to fight!", enemy.toString()), 40);

		Pokemon userPokemon = choseFromTeam();

		while (userPokemon.isAlive()) {

			// User attack
			if (starter.equals("user")) {
				System.out.println("user attack");

				// List options
				listOptions(new String[] {
					"Attack",
					"Retreat",
					"Pass",
					"Back"
				}, "\nSelect your action!");

				curAttack = getInt(1, 4, "\nEnter number: ");

				switch (curAttack) {

					// Attack
					case 1:
						while (true) {

							delayedCharPrint("Press 0 to go back.", 30);

							int attackCount = userPokemon.attacks.size();
							int selection = getInt(0, attackCount, "\nEnter number: ");

							if (selection == 0) {
								break;
							}

						}

						break;

					// Retreat
					case 2:
						System.out.println("You selected retreat");
						break;

					// Pass
					case 3:
						System.out.println("You selected pass");
						break;

					// Back
					case 4:
						userPokemon = choseFromTeam();
						break;

				}


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
