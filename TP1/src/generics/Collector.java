package generics;
import java.util.*;

/** define collectors able to collect (and carry) one specific type T of objects
 * only one T object can be carried at a time
 */

public class Collector<T> {

	private T carriedObject;
	
    public Collector(String name) {
    	this.carriedObject = null;
    	this.name = name;
    }

    private String name;
	

    public String toString() {
	return this.name;
    }
    public String description() {
	return this.name + " carries " + this.carriedObject;
    }
    // METHODES a DEFINIR
    // take : pour prendre un objet de type T (si aucun de "tenu")
    // getCarriedObject : pour connaitre l'objet "porte" (null si saucun)
    // giveTo : donne l'objet porte a un autre ramasseur compatible 
    // drop : depose l'objet "tenu"

    public void collect(T object) throws AlreadyCarryingException{
    	if(this.carriedObject != null){
    		throw new AlreadyCarryingException("Already carrying an object");
    	} else {
    		this.carriedObject = object;
    	}
    }
    
    public void giveTo(Collector<? super T> col){
    	try{
    		col.collect(this.drop());
    	} catch(AlreadyCarryingException e){
    		System.err.println(e.getMessage());
    	}
    }
    
    public T drop(){
    	T drop = this.carriedObject;
    	this.carriedObject = null;
    	
    	return drop;
    }
    
    public static void main(String[] args){
	
		Carrot c1 = new Carrot(1);
		Carrot c2 = new Carrot(2);
		Carrot c3 = new Carrot(3);
		Apple p1 = new Apple(1);
		Apple p2 = new Apple(2);

		Collector<Carrot> carrotCollector1 = new Collector<Carrot>("carrot-collector-1");
		Collector<Carrot> carrotCollector2 = new Collector<Carrot>("carrot-collector-2");
		Collector<Apple> appleCollector1 = new Collector<Apple>("apple-collector-1");
		
		// attention ici le type d'objets ramasses est Legume :
		Collector<Vegetable> vegetableCollector = new Collector<Vegetable>("vegetable-collector");

		try {
			carrotCollector1.collect(c3);
		} catch (AlreadyCarryingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println(carrotCollector1.description());
		// NE COMPILE PAS
		// carrotCollector2.collect(p1);

		// NE COMPILE PAS
		//carrotCollector1.giveTo(appleCollector1);

		// COMPILE :
			carrotCollector1.giveTo(vegetableCollector);
		// NE COMPILE PAS
		//vegetableCollector.giveTo(carrotCollector1);
		// NE COMPILE PAS
		//appleCollector1.giveTo(vegetableCollector);

		try {
			carrotCollector1.collect(c1);
		} catch (AlreadyCarryingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		carrotCollector1.giveTo(carrotCollector2);
		System.out.println(carrotCollector1.description());
		System.out.println(carrotCollector2.description());
		try {
			carrotCollector1.collect(c2);
		} catch (AlreadyCarryingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		carrotCollector1.giveTo(carrotCollector2);

		try {
			appleCollector1.collect(p2);
		} catch (AlreadyCarryingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		System.out.println(appleCollector1.description());
		
		try {
			appleCollector1.collect(p1);
		} catch (AlreadyCarryingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		appleCollector1.drop();
		System.out.println(appleCollector1.description());
		
		try {
			appleCollector1.collect(p1);
		} catch (AlreadyCarryingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
     }
}
