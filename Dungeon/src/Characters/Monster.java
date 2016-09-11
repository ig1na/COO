package Characters;

public class Monster extends Character{
	
	public Monster(int life, int gold, int strength){
		super(life, gold, strength);
	}
	
	public void die(){
		System.out.println("You killed a monster! It dropped "+ this.getGold() + " gold!");
	}

}
