// PokemonArena.java
// Paul Krishnamurthy
// Pokemon Arena Assignment

import java.util.*;

public class PokemonArena extends RenderText {

	private static PokemonCollection pokeLot      = new PokemonCollection();
	private static ArrayList<Pokemon> pokemonTeam = new ArrayList<Pokemon>();
	private static ASCII displayArt               = new ASCII(); 
	private static Tools tools                    = new Tools();
	private static Scanner stdin                  = new Scanner(System.in);

	public static void main(String[] args) {

		gameIntro();
		selectPokemon();



	}

	public static void gameIntro() {
		displayArt.introTitle();
		clearConsole();

		System.out.println("Press [enter] to start...");
		tools.getString("enter");
		clearConsole();

		delayedLinePrint(new String[] {
			"Welcome to the Pokemon Arena!",
			"Be prepared for what lies ahead!",
			"Start off by picking your team...", "\n"
		}, 20);

		sleep(1000);
	}

	public static void selectPokemon() {
		int chosen = 0;

		while (chosen != 4) {
			delayedCharPrint("Pick " + (4 - chosen) + " pokemon for your collection!", 40);

			delayedCharPrint("Here are your options: ", 40);
			listPokemon(pokeLot.pokemons);

			// Get the user selection
			int selectedPokemonIndex = tools.getInt(1, pokeLot.pokemons.size(), "Enter number: ");
			Pokemon selectedPokemon = pokeLot.pokemons.get(selectedPokemonIndex - 1);

			// Add to the pokemon team and remove from the options
			pokemonTeam.add(selectedPokemon);
			pokeLot.removePokemon(selectedPokemon.name);

			delayedCharPrint("You selected: " + selectedPokemon.name, 40);

			chosen ++;
		}

		System.out.println("Awesome job! Here is your team");	

		for (int i = 0; i < pokemonTeam.size(); i++) {
			System.out.println(pokemonTeam.get(i).name);
		}

		sleep(500);
		clear();
	}

	public static boolean battleSequence(Pokemon enemy) {

		boolean isWinnning = true;


		return isWinnning;
	}

}
