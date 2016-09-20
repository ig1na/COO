package generics;

/** define collectors able to collect (and carry) one specific type T of objects
 * only one T object can be carried at a time
 */

public class Collector<T> {

	private T carriedObject;
	private String name;
	/**
	 * Creates a collector, carries no object
	 * @param  name the name of the collector
	 */
    public Collector(String name) {
    	this.carriedObject = null;
    	this.name = name;
    }

    
	/**
	 * Returns the name of the Collector
	 * @return the name of the collector
	 */
    public String toString() {
	return this.name;
    }
    
    /**
     * Returns a description of the collector in the form : name + carriedObject
     * @return the description of the collector
     */
    public String description() {
	return this.name + " carries " + this.carriedObject;
    }
    
    /**
     * the collector takes an object to carry it, throws an exception if he already carries an object
     * @param object the object that will be carried by the collector
     */
    public void collect(T object) throws AlreadyCarryingException{
    	if(this.carriedObject != null){
    		throw new AlreadyCarryingException("Already carrying an object");
    	} else {
    		this.carriedObject = object;
    	}
    }
    
    /**
     * the collector gives his object to another collector in parameter, throws an exception if the second collector already carries an object
     * @param col The collector who receives the Object
     * @throws AlreadyCarryingException Throws the exception if the receiver already carries an object
     */
    public void giveTo(Collector<? super T> col) throws AlreadyCarryingException{
    	col.collect(this.drop());
    }
    
    //returns the carried object
    public T getCarriedObject(){
    	return this.carriedObject;
    }
    
    //returns the carried object, the collector doesn't have it anymore
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
			try {
				carrotCollector1.giveTo(vegetableCollector);
			} catch (AlreadyCarryingException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
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
		try {
			carrotCollector1.giveTo(carrotCollector2);
		} catch (AlreadyCarryingException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		System.out.println(carrotCollector1.description());
		System.out.println(carrotCollector2.description());
		try {
			carrotCollector1.collect(c2);
		} catch (AlreadyCarryingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			carrotCollector1.giveTo(carrotCollector2);
		} catch (AlreadyCarryingException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

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
