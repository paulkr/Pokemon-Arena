/**
 * Pokemon.java
 * Pokemon contructor that stores data and current state
 *
 *  @author Paul Krishnamurthy
 */

import java.util.*;

public class Pokemon {

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
	 * Returns statistics about Pokemon
	 * 
	 * @return     String with hp and energy
	 */
	public String stats () {
		return String.format("HP: %d\nENERGY: %d", hp, energy);
	}

	/**
	 * @return     Name of Pokemon
	 */
	public String toString () {
		return name;
	}

}
