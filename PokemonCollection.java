// PokemonCollection.java
// Paul Krishnamurthy
// Pokemon Arena Assignment

import java.util.*;
import java.io.*;

public class PokemonCollection {

	public ArrayList<Pokemon> pokemons = new ArrayList<Pokemon>();

	public PokemonCollection() throws IOException {
		Scanner inFile = new Scanner(new BufferedReader(new FileReader("resources/pokemon.txt")));

		int pokeNum = inFile.nextInt();
		Pokemon[] pokemon = new Pokemon[pokeNum];

		inFile.nextLine(); // Skip first line

		for (int i = 0; i < pokeNum; i++) {
			// Pass string to processLine method
			processLine(inFile.nextLine());
		}

		inFile.close();
	}

	public void processLine(String data) {

		String[] content = data.split(",");

		String name       = content[0];
		int hp            = Integer.parseInt(content[1]);
		String type       = content[2];
		String resistance = content[3];
		String weakness   = content[4];

		int attackNums             = Integer.parseInt(content[5]);
		ArrayList<Attack> attacks  = new ArrayList<Attack>();

		int add = 0;

		for (int i = 0; i < attackNums; i++) {
			// Contruct a new attack and add it to attacks list
			attacks.add(new Attack(content[6 + add], 
							Integer.parseInt(content[6 + add + 1]),
							Integer.parseInt(content[6 + add + 2]),
							content[6 + add + 3]));
			add += 4;
		}

		pokemons.add(new Pokemon(name, hp, type, resistance, weakness, attacks));
	}

	public String toString() {
		String output = "";
		
		for (int i = 1; i < pokemons.size() + 1; i++) {
			output += String.format("%d: %s\n", i, pokemons.get(i - 1).name);
			// System.out.println(pokemons.get(i).name);
		}

		return output;
	}


}
