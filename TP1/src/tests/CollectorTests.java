package tests;

import static org.junit.Assert.*;
import generics.*;

import org.junit.*;

public class CollectorTests {

	private Collector<Carrot> lapin, ane;
	private Carrot carrot, c2;
	
	@Before
	public void setupBefore(){
		lapin = new Collector<Carrot>("Lapin");
		ane = new Collector<Carrot>("Ane");
		carrot = new Carrot(1);
		c2 = new Carrot(2);
	}
	
	//collect function test
	@Test
	public void testCollect() throws AlreadyCarryingException{
		assertNull(lapin.getCarriedObject());
		
		lapin.collect(carrot);
		assertSame(carrot, lapin.getCarriedObject());
	}
	
	//tests the exception thrown by collect function 
	@Test(expected=AlreadyCarryingException.class)
	public void testCollectAlreadyCarryingException() throws AlreadyCarryingException{
		lapin.collect(carrot);
		
		//Checks if lapin carries the carrot
		assertNotNull(lapin.getCarriedObject());
	
		//Throws the exception
		lapin.collect(c2);
		
	}
	
	//giveTo function tests
	@Test
	public void testGiveTo() throws AlreadyCarryingException{

		
		//Checks if collector2 carries no object
		assertNull(ane.getCarriedObject());
		
		//lapin collects a carrot
		lapin.collect(carrot);
		assertNotNull(lapin.getCarriedObject());
		//collector gives a carrot to collector2
		lapin.giveTo(ane);
		
		//Checks if ane has the carrot
		assertSame(carrot, ane.getCarriedObject());
		
		//Checks if lapin still has the carrot
		assertNull(lapin.getCarriedObject());
	}
	

	//tests the exception thrown by giveTo function 
	@Test(expected=AlreadyCarryingException.class)
	public void testGiveToAlreadyCarryingException() throws AlreadyCarryingException{
		lapin.collect(carrot);

		//Checks if lapin carries the carrot
		assertNotNull(lapin.getCarriedObject());
		
		ane.collect(c2);
		
		//Checks if ane carries the second carrot
		assertNotNull(ane.getCarriedObject());
		
		//Throws the exception
		lapin.giveTo(ane);
	}
	
	//tests drop function
	@Test
	public void testDrop() throws AlreadyCarryingException{
		lapin.collect(carrot);
		
		//Checks if lapin carries the carrot
		assertSame(carrot, lapin.getCarriedObject());
		
		lapin.drop();
		
		//Checks if lapin dropped the carrot
		assertNull(lapin.getCarriedObject());
	}
}
