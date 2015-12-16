
public class ASCII extends RenderText {

	/**
	 * Introduction title
	 */
	public void introTitle() {

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
			"                     ____             _   _  _      ",
			"                    |  _ \\ __ _ _   _| | | |/ /    ",
			"                    | |_) / _` | | | | | | ' /      ",
			"                    |  __/ (_| | |_| | | | . \\ _   ", 
			"                    |_|   \\__,_|\\__,_|_| |_|\\_(_)\n"
		};

		// Print text with effects and pauses
		delayedLinePrint(pokeTitle, 40);
		sleep(700);
		delayedLinePrint(pokeSubtitle, 40);
		sleep(500);
		System.out.printf("%27s", " ");
		delayedCharPrint("January 2015", 40);
	}

}

