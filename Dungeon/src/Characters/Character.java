package Characters;

public abstract class Character {

	protected int life;
	protected int gold;
	protected int strength;
	
	public Character(int life, int gold, int strength){
		this.life = life;
		this.gold = gold;
		this.strength = strength;
	}
	
	public void attack(Character c){
		c.setLife(c.getLife() - this.getStrength());
		System.out.println("Vie restante : " + c.getLife());
	}
	
	public int getLife(){
		return this.life;
	}
	
	public void setLife(int life){
		this.life = life;
	}

	public int getGold() {
		return gold;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}
	
	abstract boolean isDead();
	
}

