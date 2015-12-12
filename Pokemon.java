// Pokemon.java
// Paul Krishnamurthy
// Pokemon Arena Assignment

import java.util.*;

public class Pokemon {

	final String name;

	int hp, energy;

	final int maxHP;
	final String type;
	final String resistance;
	final String weakness;
	final ArrayList<Attack> attacks;

	boolean isStunned = false;
	boolean isDisabled = false;


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
