package Actions;

import Characters.Player;
import Rooms.Room;

public abstract class Action {

	protected Player p;
	protected Room r;
	
	public Action(Player p, Room r){
		this.p = p;
	}
	
	public abstract void act();
	public abstract boolean isDoable();
	public abstract String toString();
}
