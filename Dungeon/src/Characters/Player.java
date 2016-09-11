package Characters;

import java.util.*;

import Actions.Action;

public abstract class Player extends Character {

	List<Action> actions;
	
	public Player(int life, int gold, int strength) {
		super(life, gold, strength);
	}

	@Override
	void die() {
	}

	public void act(){
		System.out.println("Quelle action effectuer?");
		Scanner sc = new Scanner(System.in);
		
		for(int i=0; i < actions.size(); i++){
			if(this.actions.get(i).isDoable()){
				System.out.println(i + " " + this.actions.get(i));
			}
		}
		
	}
	
	public void addAction(Action a){
		this.actions.add(a);
	}
}
