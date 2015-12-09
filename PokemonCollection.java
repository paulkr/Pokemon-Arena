// PokemonCollection.java
// Paul Krishnamurthy
// Pokemon Arena Assignment

import java.util.*;
import java.io.*;

public class PokemonCollection {

	public ArrayList<Pokemon> pokemons = new ArrayList<Pokemon>();

	public static void main(String[] args) throws IOException {
		Scanner inFile = new Scanner(new BufferedReader(new FileReader("resources/pokemon.txt")));

		int pokeNum = inFile.nextInt();
		Pokemon[] pokemon = new Pokemon[pokeNum];

		for (int i = 0; i < pokeNum; i++) {
			String line = inFile.nextLine();
		
		}

		inFile.close();
	}

}
