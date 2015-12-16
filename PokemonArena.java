// PokemonArena.java
// Paul Krishnamurthy
// Pokemon Arena Assignment

import java.util.*;

public class PokemonArena {

	private static PokemonCollection pokeLot = new PokemonCollection();
	private static ArrayList<Pokemon> pokemonTeam = new ArrayList<Pokemon>();
	private static ASCII displayArt = new ASCII(); 
	private static RenderText styledText = new RenderText();
	private static Tools tools = new Tools();

	public static void main(String[] args) {

		// Intro
		// displayArt.introTitle();

		// styledText.delayedCharPrint(pokemons.toString(), 20);
		
		selectPokemon();

	}

	public static void selectPokemon() {
		int chosen = 0;
		Scanner stdin = new Scanner(System.in);

		while (chosen != 4) {
			String message = "Pick " + (4 - chosen) + " pokemon for your collection!";
			styledText.delayedCharPrint(message, 40);

			message = "Here are your options: ";
			styledText.delayedCharPrint(message, 40);
			styledText.delayedCharPrint(pokeLot.toString(), 5);

			int selectedPokemonIndex = tools.getInt(1, pokeLot.pokemons.size());

			chosen ++;
		}
	}

}
