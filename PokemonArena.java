// PokemonArena.java
// Paul Krishnamurthy
// Pokemon Arena Assignment

import java.util.*;

public class PokemonArena extends RenderText {

	public static void main(String[] args) {

		// Intro
		printTitle();



	}

	public static void printTitle() {

		String pokeTitle = "                               .::.                             \n" +
		"                              .;:**'                            \n" +
		"                              `                                 \n" +
		"  .:XHHHHk.              db.   .;;.     dH  MX                  \n" +
		"oMMMMMMMMMMM       ~MM  dMMP :MMMMMR   MMM  MR      ~MRMN       \n" +
		"QMMMMMb  'MMX       MMMMMMP !MX' :M~   MMM MMM  .oo. XMMM 'MMM  \n" +
		"  `MMMM.  )M> :X!Hk. MMMM   XMM.o'  .  MMMMMMM X?XMMM MMM>!MMP  \n" +
		"   'MMMb.dM! XM M'?M MMMMMX.`MMMMMMMM~ MM MMM XM `' MX MMXXMM   \n" +
		"    ~MMMMM~ XMM. .XM XM`'MMMb.~*?**~ .MMX M t MMbooMM XMMMMMP   \n" +
		"     ?MMM>  YMMMMMM! MM   `?MMRb.    `MM   !L'MMMMM XM IMMM     \n" +
		"      MMMX   'MMMM'  MM       ~%:           !Mh.''' dMI IMMP    \n" +
		"      'MMM.                                             IMX     \n" +
		"       ~M!M                                             IM        ";

		String[] pokeSubtitle = {
			" ____             _   _  _       \n",
			"|  _ \\ __ _ _   _| | | |/ /     \n",
			"| |_) / _` | | | | | | ' /       \n",
			"|  __/ (_| | |_| | | | . \\ _    \n", 
			"|_|   \\__,_|\\__,_|_| |_|\\_(_) \n\n"
		};

		System.out.println(pokeTitle);

		// Pause then print formatted text

		sleep(700);

		for (String s : pokeSubtitle) {
			System.out.printf("                 %s", s);
		}

		sleep(500);

		System.out.printf("%38s", "January 2015\n");

	}

}
