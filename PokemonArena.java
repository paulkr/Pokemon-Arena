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
	private static Scanner stdin                  = new Scanner(System.in);

	public static void main (String[] args) {

		// gameIntro();

		// selectPokemon();
		

		// Static team for testing
		pokemonTeam.add(pokeLot.pokemons.get(0));
		pokemonTeam.add(pokeLot.pokemons.get(1));
		pokemonTeam.add(pokeLot.pokemons.get(2));
		pokemonTeam.add(pokeLot.pokemons.get(3));


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
		ASCII.introTitle();
		clearConsole();

		// Prompt for enter to be pressed
		getString("enter", "Press [enter] to start...", false);
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

			// Print Pokemon and details
			ASCII.printPokemon(selectedPokemon.toString());
			selectedPokemon.stats(true);

			// Yes/No confirmation to choose Pokemon
			String confirmation = getString("", String.format("Would you like to choose %s [y/n]? ", selectedPokemon.toString()), true);

			if (confirmation.toLowerCase().equals("y")) {
				// Add to the pokemon team and remove from the options
				pokemonTeam.add(selectedPokemon);
				pokeLot.removePokemon(selectedPokemon.toString());

				delayedCharPrint(String.format("\nYou selected: %s!\n",selectedPokemon.toString()), 40);

				chosen ++;
			}

		}

		// Display user's Pokemon team

		listOptions(new String[] {
			pokemonTeam.get(0).toString(),
			pokemonTeam.get(1).toString(),
			pokemonTeam.get(2).toString(),
			pokemonTeam.get(3).toString(),
		}, "Awesome job! Here is your team\n");

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
	 * Select battle action
	 * 
	 * @return     Selected action
	 */
	public static int selectAction () {
		// List options
		listOptions(new String[] {
			"Attack",
			"Retreat",
			"Pass",
			"Back",
			"Help"
		}, "\nSelect your action!");

		// Get and return selection
		int curAction = getInt(1, 5, "\nEnter number: ");
		return curAction;
	}

	/**
	 * Enemy attack sequence
	 * 
	 * @param enemy     Enemy Pokemon object
	 * @param user      User Pokemon object
	 */
	public static void enemyAttack (Pokemon enemy, Pokemon user) {

		delayedCharPrint("ENEMY ATTACKINGGGGG", 30);

	}

	/**
	 * Battle sequence with one enemy
	 * 
	 * @param  enemy     Pokemon enemy object
	 * @return           Boolean if user's Pokemon won or lost
	 */
	public static boolean battleSequence (Pokemon enemy, String starter) {

		boolean isWinnning  = true;
		int curAction;

		delayedCharPrint(String.format("A wild %s appears! Get ready to fight!\n", enemy.toString()), 40);

		Pokemon userPokemon = choseFromTeam();

		while (userPokemon.isAlive()) {

			// User attack
			if (starter.equals("user")) {
				System.out.println("user attack");

				while (true) {
					// List options
					listOptions(new String[] {
						"Attack",
						"Retreat",
						"Pass",
						"Stats",
						"View",
						"Help"
					}, "\nSelect your action!");

					curAction = getInt(1, 6, "\nEnter number: ");

					switch (curAction) {

						// Attack
						case 1:
							while (true) {
								delayedCharPrint("ENTER < 0 > TO GO BACK\n", 30);
								delayedCharPrint("Select an attack! Here are your options:\n", 30);
			
								userPokemon.listAttacks(); // Display attack options

								// Get attack
								int attackCount = userPokemon.attacks.size();
								int selection = getInt(0, attackCount, "\nEnter number: ");

								if (selection == 0) {
									break;
								}

								// Try to attack
								Attack curAttack = userPokemon.attacks.get(selection - 1);
								if (userPokemon.canAfford(curAttack)) {
									curAttack.attack(userPokemon, enemy);

									userPokemon.reset();
									enemyAttack(enemy, userPokemon);
									break;
								} else {
									delayedCharPrint("\nYou cannot affort that attack!", 30);
								}

							}

							break;

						// Retreat (switch pokemon)
						case 2:
							System.out.println("You selected retreat");
							userPokemon = choseFromTeam();
							enemyAttack(enemy, userPokemon);
							break;

						// Pass (nothing happens)
						case 3:
							System.out.println("You selected pass");
							enemyAttack(enemy, userPokemon);
							break;

						// Stats
						case 4:
							System.out.println("You selected stats");
							userPokemon.stats(false);
							break;

						// View
						case 5:
							ASCII.printPokemon(userPokemon.toString());
							break;

						// Help
						case 6:
							System.out.println("You selected help");
							Tools.help();
							break;
					}
				}

			// Enemy attack
			} else {
				enemyAttack(enemy, userPokemon);
			}

		}

		return isWinnning;
	}

}
