package Items;

import Characters.Player;
public abstract class Item {
	
	static int nbItems = 3;
	
	public static int getNbItems(){
		return nbItems;
	}
	public abstract void use(Player p);
	
}
