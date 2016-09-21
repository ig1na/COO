package Dungeon;

import Actions.*;
import Characters.Player;

public class Game {

	private Player p;
	private Dungeon d;
	
	public void play(){
		
		d = new Dungeon(5, 5, 100, 500, 70);
		p = new Player(100, 0, 90);
		
		while(!this.isFinished()){
			System.out.println("Choose an action :");
			for(Action a : p.getActionsList()){
				System.out.println(p.getActionsList().indexOf(a)+". "+a);
			}
		}
		
		
			
			
	}
	
	public boolean isFinished(){
		if(p.isDead()){
			return true;
		}
		return false;
		
	}
}
