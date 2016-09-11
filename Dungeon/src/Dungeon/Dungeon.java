package Dungeon;

import java.util.ArrayList;
import java.util.Random;

import Characters.Monster;
import Characters.Player;
import Items.*;
import Rooms.*;

public class Dungeon {

	static int nbRooms;
	static int w, h;
	private int nbItems, nbMonsters;
	private int currentRoomNumber;
	private ArrayList<Room> rooms;
	private ArrayList<Item> items;
	private Random rand;
	Player p;
	
	
	
	public Dungeon(int nbRooms, int maxMonstersPerRoom, int maxItemsPerRoom, int maxMonsterLife, int maxMonsterGold, int maxMonsterStrength){
		currentRoomNumber = 0;
		p = new Player(100, 0, 25);
		
		items.add(new GoldPurse(rand.nextInt(100)));
		items.add(new HealthPotion(rand.nextInt(100)));
		items.add(new StrengthPotion(rand.nextInt(25)));
		
		while(currentRoomNumber < nbRooms){
			rooms.add(new Room());
			
			nbItems = rand.nextInt(maxItemsPerRoom);
			nbMonsters = rand.nextInt(maxMonstersPerRoom);
			
			
			//add monsters to the room that is being created
			for(int i=0; i<nbMonsters; i++){
				rooms.get(currentRoomNumber).addMonster(new Monster(rand.nextInt(maxMonsterLife), rand.nextInt(maxMonsterGold), rand.nextInt(maxMonsterStrength)));
				
			}
			
			//add items to the room that is being created
			for(int i=0; i<nbItems; i++){
				//add an item by randomly choosing its type in items list
				rooms.get(currentRoomNumber).addItem(items.get(rand.nextInt(items.size())));
			}
			
			
		}
		
		
	}
	
	
}
