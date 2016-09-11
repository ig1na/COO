package faune;

public class Animal {

	int weight;
	String name;
	
	public Animal(int weight, String name){
		this.weight = weight;
		this.name = name;
	}
	
	public void shout(){
		System.out.println(this.name + " shouts");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWeight() {
		return weight;
	}
	
	
}
