package Items;

import Characters.Player;

public class StrengthPotion extends Item {

	int strength;
	
	public StrengthPotion(int strength){
		this.strength = strength;
	}
	
	@Override
	public void use(Player p) {
		p.setStrength(p.getStrength() + this.strength);
	}

}
