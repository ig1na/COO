package Actions;

import Characters.Player;

public abstract class Action {

	protected Player p;
	
	public Action(Player p){
		this.p = p;
	}
	
	public abstract void act();
	public abstract boolean isDoable();
}
