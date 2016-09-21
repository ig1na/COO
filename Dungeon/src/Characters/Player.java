package Characters;

import java.util.*;

import Actions.Action;

public class Player extends Character {

	private List<Action> actions;
	
	public Player(int life, int gold, int strength) {
		super(life, gold, strength);
	}

	public boolean isDead(){
		return life == 0;
	}
	
	public void act(int i){
		this.actions.get(i).act();
	}
	
	public void addAction(Action a){
		this.actions.add(a);
	}
	
	public String getActionName(int i){
		return this.actions.get(i).toString();
	}
	
	public List<Action> getActionsList(){
		return this.actions;
	}
}
