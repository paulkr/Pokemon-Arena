/**
 * Pokemon.java
 * Pokemon contructor that stores data and current state
 *
 *  @author Paul Krishnamurthy
 */

import java.util.*;

public class Pokemon extends Tools {

	int hp, energy;

	final String name;
	final int maxHP;
	final String type;
	final String resistance;
	final String weakness;
	final ArrayList<Attack> attacks;

	boolean isStunned = false;  // Boolean if Pokemon's state is stunned
	boolean isDisabled = false; // Boolean if Pokemon's state is disabled

	// Constructs new Pokemon object
	public Pokemon (String name, int hp, String type, String resistance, String weakness, ArrayList<Attack> attacks) {
		this.name       = name;

		this.hp         = hp;
		this.maxHP      = hp;
		this.energy     = 50;
		
		this.type       = type;
		this.resistance = resistance;
		this.weakness   = weakness;
		
		this.attacks    = attacks;
	}

	/**
	 * Checks if Pokemon is alive
	 * 
	 * @return     Returns true if Pokemon has more than 0 hp
	 */
	public boolean isAlive () {
		return hp > 0;
	}

	/**
	 * Resets Pokemon stats at the end of a battle
	 */
	public void reset () {

	}

	/**
	 * Prints statistics about Pokemon in a nice table
	 *
	 * @param fancy     Boolean if table should be printed
	 * @return          String with hp and energy
	 */
	public void stats (boolean fancy) {
		if (fancy) {
			delayedLinePrint(new String[] {
				"\n+----------------------------------------------+",
				"|                    STATS                     |",
				"+==============================================+",
				String.format("| HP: %5d | ENERGY: %5d | TYPE: %10s |", hp, energy, type.toUpperCase()),
				"+----------------------------------------------+\n"
			}, 20);
		} else {
			delayedCharPrint(String.format("\nHP: %d\nENERGY: %d\nTYPE: %s", hp, energy, type.toUpperCase()), 30);
		}
	}

	/**
	 * @return     Name of Pokemon
	 */
	public String toString () {
		return name;
	}

}
