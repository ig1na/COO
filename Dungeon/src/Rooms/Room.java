package Rooms;

import Characters.*;
import Items.Item;

import java.util.*;

public class Room {

	protected ArrayList<Monster> monsters;
	protected ArrayList<Item> items;
	protected Map<Direction, Room> neighbours;
	
	public Room(){
		monsters = new ArrayList<Monster>();
		items = new ArrayList<Item>();
	}
	
	public boolean isExit(){
		return false;
	}
	
	public void addMonster(Monster m){
		/*this.rand = new Random();
		int nbMonsters = rand.nextInt(5);
		
		for(int i=0; i<nbMonsters; i++){
			this.monsters.add(new Monster(100,rand.nextInt(100),rand.nextInt(100)));
		}*/
		this.monsters.add(m);
	}
	
	
	
	public void addItem(Item i){
		/*this.rand = new Random();
		int nbItems = rand.nextInt(5);
		
		for(int i=0; i<nbItems; i++){
			this.items.add(new(100,rand.nextInt(100),rand.nextInt(100)));
		}*/
		this.items.add(i);
	}

	public boolean hasNeighbour(Direction d){
		return neighbours.get(d) != null;
	}
	
	public boolean hasNeighbours(){
		return !neighbours.isEmpty();
	}
	/**
	 * 
	 * @param r
	 */
	public void addNeighbour(Room r){
		
	}
	
	/**
	 * Returns a description with the content of this Room
	 */
	public String toString(){
		String desc;
		
		desc = "The room has "+monsters.size()+" monsters :\n";
		for(Monster m : monsters){
			desc += "\t"+monsters.indexOf(m)+". "+m+"\n";
		}
		
		desc += "it also contains "+items.size()+" items :\n";
		for(Item i : items){
			desc += "\t"+items.indexOf(i)+". "+i+"\n";
		}
		
		desc += "you may go :\n";
		
		
		return desc;
	}
}

