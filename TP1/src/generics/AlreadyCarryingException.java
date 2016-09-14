package generics;

public class AlreadyCarryingException extends Exception{

	private static final long serialVersionUID = 1L;

	public AlreadyCarryingException(){}
	
	public AlreadyCarryingException(String s){
		super(s);
	}
}
