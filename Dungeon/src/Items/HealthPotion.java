package Items;

import Characters.Player;

public class HealthPotion extends Item {

	int health;
	
	public HealthPotion(int health){
		this.health = health;
	}
	
	
	public void use(Player p) {
		p.setLife(p.getLife() + this.health);

	}

}
