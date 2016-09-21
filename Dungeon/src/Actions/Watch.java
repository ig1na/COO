package Actions;

import Characters.Player;
import Rooms.Room;

public class Watch extends Action {
	
	public Watch(Player p, Room r){
		super(p, r);
	}

	@Override
	public void act() {
		System.out.println(this.r);
	}
	
	@Override
	public boolean isDoable() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String toString() {
		return "Watch";
	}

}
