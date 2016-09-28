package Dungeon;

import java.io.File;

import Actions.*;
import Characters.Player;

public class Game {

	private Player p;
	private Dungeon d;
	
	public Game(File map){

	}
	
	public void play(){
		
		
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
	
	public static void main(String[] args){
		Dungeon d = new Dungeon(10, 10, 10, 10, 10, new File("map.txt"));
	}
}
