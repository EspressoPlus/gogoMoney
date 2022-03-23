package zcom.gogo.exception;

public class NotFoundException extends RuntimeException {


	// only need a constructor in this class
	
	public NotFoundException(String msg) {
		// just passes message up to the super class bc this class extends RuntimeException
		super(msg); 
	}
	
	/* 
	// IDE-generated approach made this
	// right-click > Source > Generate constructors from superclass
	// select RuntimeException(String) only
	public NotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	*/
	
	
}
