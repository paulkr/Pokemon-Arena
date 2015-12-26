/**
 * ASCII.java
 * Stores and displays ASCII art
 *
 *  @author Paul Krishnamurthy
 */

public class ASCII extends RenderText {

	// Main pokemon title
	private String[] pokeTitle = { 
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

	// Author subtitle text
	private String[] pokeSubtitle = {
		"                     ____             _   _  _      ",
		"                    |  _ \\ __ _ _   _| | | |/ /    ",
		"                    | |_) / _` | | | | | | ' /      ",
		"                    |  __/ (_| | |_| | | | . \\ _   ", 
		"                    |_|   \\__,_|\\__,_|_| |_|\\_(_)\n"
	};

	// Congratulations (winner) text
	private String[] congrats = {
		" _____                             _         _       _   _                 _           ",
		"/  __ \\                           | |       | |     | | (_)               | |         ",
		"| /  \\/ ___  _ __   __ _ _ __ __ _| |_ _   _| | __ _| |_ _  ___  _ __  ___| |         ",
		"| |    / _ \\| '_ \\ / _` | '__/ _` | __| | | | |/ _` | __| |/ _ \\| '_ \\/ __| |      ",
		"| \\__/\\ (_) | | | | (_| | | | (_| | |_| |_| | | (_| | |_| | (_) | | | \\__ \\_|      ",
		" \\____/\\___/|_| |_|\\__, |_|  \\__,_|\\__|\\__,_|_|\\__,_|\\__|_|\\___/|_| |_|___(_) ",
		"                    __/ |                                                              ",
		"                   |___/                                                              \n"
	};

	// You lose (loser) text
	private String[] loser = {
		"__   __            _                    _         ",
		"\\ \\ / /           | |                  | |      ",
		" \\ V /___  _   _  | |     ___  ___  ___| |       ",
		"  \\ // _ \\| | | | | |    / _ \\/ __|/ _ \\ |    ",
		"  | | (_) | |_| | | |___| (_) \\__ \\  __/_|      ",
		"  \\_/\\___/ \\__,_| \\_____/\\___/|___/\\___(_) \n"
	};

	/**
	 * Introduction title
	 */
	public void introTitle() {
		delayedLinePrint(pokeTitle, 40);
		sleep(700);
		delayedLinePrint(pokeSubtitle, 40);
		sleep(500);
		System.out.printf("%27s", " ");
		delayedCharPrint("January 2015", 40);
		sleep(1000);
	}

	/**
	 * ASCII Art for winning or losing
	 * 
	 * @param won     Boolean to see if user won or not
	 */
	public void gameOver(boolean won) {
		if (won) {
			delayedLinePrint(congrats, 40);
			sleep(700);
		} else {
			delayedLinePrint(loser, 40);
			sleep(700);
		}
	}

}

