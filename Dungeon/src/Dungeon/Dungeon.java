package Dungeon;

import java.io.*;
import java.util.*;

import Characters.Monster;
import Characters.Player;
import Items.*;
import Rooms.*;

public class Dungeon {

	static int nbRooms;
	private int nbItems, nbMonsters;
	private int currentRoomNumber;
	private ArrayList<Room> rooms;
	private ArrayList<Item> items;
	private Random rand;
	Player p;
	
	
	
	public Dungeon(int maxMonstersPerRoom, int maxItemsPerRoom, int maxMonsterLife, int maxMonsterGold, int maxMonsterStrength){
		
		File file = new File("map");

	    try {
	    
	        Scanner sc = new Scanner(file);

	        while (sc.hasNextLine()) {
	            int i = sc.nextInt();
	            System.out.println(i);
	        }
	        sc.close();
	    } 
	    catch (FileNotFoundException e) {
	        e.printStackTrace();
	    }
	 }
	
	public Room getRoom(int i){
		return rooms.get(i);
	}
					
}
