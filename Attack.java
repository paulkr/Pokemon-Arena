/**
 * Attack.java
 * Constructs each attack and changes Pokemon stats when attacking
 *
 *  @author Paul Krishnamurthy
 */

import java.util.*;

public class Attack {

	// Information about each attack -> Constants
	final String name;
	final int cost;
	final int damage;
	final String special;

	public Attack(String name, int cost, int damage, String special) {
		this.name    = name;
		this.cost    = cost;
		this.damage  = damage;
		this.special = special;
	}

	/**
	 * Changes Pokemon statistics for both Pokemon after an attack
	 * 
	 * @param predator     Pokemon object of attacking pokemon
	 * @param prey         Pokemon object of defending pokemon
	 */
	public void attack(Pokemon predator, Pokemon prey) {
		
	}

}
