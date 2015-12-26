/**
 * PokemonCollection.java
 * Stores all pokemon from "resources/pokemon.txt" data file
 *
 *  @author Paul Krishnamurthy
 */

import java.util.*;
import java.io.*;

public class PokemonCollection {

	// ArrayList to hold all pokemon
	public ArrayList<Pokemon> pokemons = new ArrayList<Pokemon>();

	// Slice data file in the constructor
	public PokemonCollection() {
		Scanner inFile;

		// Try and catch the IOException
		try {
			inFile = new Scanner(new BufferedReader(new FileReader("resources/pokemon.txt")));
		} catch(IOException e) {
			System.out.println("Could not loadfile 'resources/pokemon.txt'!");
			System.exit(-1); // Exit program if file could not be found
			return;
		}

		// Create a Pokemon[] based on the number of Pokemon
		int pokeNum = inFile.nextInt();
		Pokemon[] pokemon = new Pokemon[pokeNum];

		inFile.nextLine(); // Skip to next line

		for (int i = 0; i < pokeNum; i++) {
			// Pass string to processLine method
			processLine(inFile.nextLine());
		}

		inFile.close();
	}

	/**
	 * Constructs a new pokemon and attack with a line from the data file
	 * 
	 * @param data     String line of data from the "resources/pokemon.txt" data file
	 */
	public void processLine(String data) {

		String[] content          = data.split(",");
		String name               = content[0];
		int hp                    = Integer.parseInt(content[1]);
		String type               = content[2];
		String resistance         = content[3];
		String weakness           = content[4];
		int attackNums            = Integer.parseInt(content[5]);
		ArrayList<Attack> attacks = new ArrayList<Attack>();

		int add = 0; // Number to help with slicing from data string

		for (int i = 0; i < attackNums; i++) {
			// Contruct a new attack and add it to attacks list
			attacks.add(new Attack(content[6 + add], 
							Integer.parseInt(content[6 + add + 1]),
							Integer.parseInt(content[6 + add + 2]),
							content[6 + add + 3]));
			add += 4;
		}

		// Add new pokemon object to ArrayList
		pokemons.add(new Pokemon(name, hp, type, resistance, weakness, attacks));
	}

	/**
	 * Returns a random pokemon from the pokemon ArrayList
	 * Removes the chosen pokemon from the ArrayList
	 * 
	 * @return selected     Randomly selected Pokemon object
	 */
	public Pokemon randomPokemon() {
		Random rand = new Random();
		// Select a random Pokemon and remove it from pokemons ArrayList
		Pokemon selected = pokemons.get(rand.nextInt(pokemons.size()));
		removePokemon(selected.name);
		return selected;
	}

	/**
	 * Removes pokemon from ArrayList based on name
	 * 
	 * @param name     Name of pokemon
	 */
	public void removePokemon(String name) {
		for (int i = 0; i < pokemons.size(); i++) {
			if (pokemons.get(i).name.equals(name)) {
				pokemons.remove(i);
			}
		}
	}
}
