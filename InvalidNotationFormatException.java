
@SuppressWarnings("serial")
public class InvalidNotationFormatException extends Exception {
	//Default constructor
	public InvalidNotationFormatException(){
	}
	
	//Constructor with parameter
	public InvalidNotationFormatException(String message){
	    super(message);
	}
}
