package Items;

import Characters.Player;

public class GoldPurse extends Item{

	int gain;
	
	public GoldPurse(int gain){
		this.gain = gain;
	}
	
	public void use(Player p) {
		p.setGold(p.getGold() + this.gain);
	}

}
