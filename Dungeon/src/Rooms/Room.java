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
	
	public void addNeighbour(Room r){
		
	}
}

