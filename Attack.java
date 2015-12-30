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

		// Stores attack damage factoring in all conditions
		int attackPower = damage;

		// Display attack name
		delayedCharPrint(String.format("%s uses %s against %s", predator.name, name, prey.name), 40);

		predator.energy -= cost; // Lower attacker's energy

		// If attacker is disabled
		if (predator.isDisabled) {
			// Inform the player of this tragedy
			delayedCharPrint(String.format("%s is disabled!", predator.name), 40);
			delayedCharPrint("The attack has been weakened!", 40);

			// Try to lower 10 from the attack power
			attackPower = Math.max(0, attackPower - 10);
		}

		// If the attacker has a weakness
		if (predator.type.equals(prey.resistance)) {
			delayedCharPrint(String.format("Oh no! %s is resistant to %s! You're attack was not that effective!", prey.name, name), 40);
			attackPower /= 2; // Cut attack power in half
		} else if (predator.type.equals(prey.weakness)) {
			delayedCharPrint(String.format("Lucky you! %s has a weakness to %s! You're attack was very effective!", prey.name, name), 40);
			attackPower *= 2; // Double the attack power
		}
		
		// Check for special attacks
		switch (special) {

		}

	}

}
