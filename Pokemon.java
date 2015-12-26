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
	public Pokemon(String name, int hp, String type, String resistance, String weakness, ArrayList<Attack> attacks) {
		this.name       = name;

		this.hp         = hp;
		this.maxHP      = hp;
		this.energy     = 50;
		
		this.type       = type;
		this.resistance = resistance;
		this.weakness   = weakness;
		
		this.attacks    = attacks;
	}


}
