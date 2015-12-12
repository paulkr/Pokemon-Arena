// PokemonArena.java
// Paul Krishnamurthy
// Pokemon Arena Assignment

import java.util.*;

public class PokemonArena extends RenderText {

	private static PokemonCollection pokemons = new PokemonCollection(); 

	public static void main(String[] args) {

		// Intro
		// printTitle();

		delayedCharPrint(pokemons.toString());
	}

	public static void printTitle() {

		String[] pokeTitle = { 
			"                               .::.                           ",
			"                              .;:**'                          ",
			"                              `                               ",
			"  .:XHHHHk.              db.   .;;.     dH  MX                ",
			"oMMMMMMMMMMM       ~MM  dMMP :MMMMMR   MMM  MR      ~MRMN     ",
			"QMMMMMb  'MMX       MMMMMMP !MX' :M~   MMM MMM  .oo. XMMM 'MMM",
			"  `MMMM.  )M> :X!Hk. MMMM   XMM.o'  .  MMMMMMM X?XMMM MMM>!MMP",
			"   'MMMb.dM! XM M'?M MMMMMX.`MMMMMMMM~ MM MMM XM `' MX MMXXMM ",
			"    ~MMMMM~ XMM. .XM XM`'MMMb.~*?**~ .MMX M t MMbooMM XMMMMMP ",
			"     ?MMM>  YMMMMMM! MM   `?MMRb.    `MM   !L'MMMMM XM IMMM   ",
			"      MMMX   'MMMM'  MM       ~%:           !Mh.''' dMI IMMP  ",
			"      'MMM.                                             IMX   ",
			"       ~M!M                                             IM    " 
		};

		String[] pokeSubtitle = {
			" ____             _   _  _      ",
			"|  _ \\ __ _ _   _| | | |/ /    ",
			"| |_) / _` | | | | | | ' /      ",
			"|  __/ (_| | |_| | | | . \\ _   ", 
			"|_|   \\__,_|\\__,_|_| |_|\\_(_)\n"
		};

		delayedLinePrint(pokeTitle);

		// Pause then print formatted text

		sleep(700);

		delayedLinePrint(pokeSubtitle);

		sleep(500);

		System.out.printf("%27s", " ");
		delayedCharPrint("January 2015");

	}

}
