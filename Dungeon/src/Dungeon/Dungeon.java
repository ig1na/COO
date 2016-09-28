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
	private ArrayList<ArrayList<Room>> mapLines;
	private ArrayList<Room> mapColumns;
	private ArrayList<Item> items;
	private Random rand;
	Player p;
	File f;
	
	
	
	public Dungeon(int maxMonstersPerRoom, int maxItemsPerRoom, int maxMonsterLife, int maxMonsterGold, int maxMonsterStrength, File f){
		this.f = f;
		
		int cpt = 1;
	    try {
	    
	        Scanner sc = new Scanner(f);

	        while (sc.hasNextInt()) {
	        	mapColumns = new ArrayList<Room>();
	            int i = sc.nextInt();
	            if(i == 1){
	            	mapColumns.add(new Room());
	            } else {
	            	mapColumns.add(null);
	            }
	            if(sc.hasNextLine()){
	            	mapLines.add(mapColumns);
	            }
	            
	            
	        }
	        sc.close();
	    } 
	    catch (FileNotFoundException e) {
	        e.printStackTrace();
	    }
	    
	    this.setNeighbours();
	 }
	
	private void setNeighbours(){
		Room tmpNeigh;
		Room r;
		
		for(int y=0; y<mapLines.size(); y++){
			for(int x=0; x<mapColumns.size(); x++){
				r = mapLines.get(y).get(x);
				if(r != null){
					
					if(x-1 > 0){
						r.addNeighbour(Direction.WEST, mapLines.get(y).get(x-1));
					} else if(x+1 < mapColumns.size()){
						r.addNeighbour(Direction.EAST, mapLines.get(y).get(x+1));
					} else if(y-1 > 0){
						r.addNeighbour(Direction.NORTH, mapLines.get(y-1).get(x));
					} else if(y+1 < mapLines.size()){
						r.addNeighbour(Direction.SOUTH, mapLines.get(y+1).get(x));
					}
					
				}
			}
		}
	}
	
	public Room getRoom(int x, int y){
		return mapLines.get(x).get(y);
	}
	
	
					
}
