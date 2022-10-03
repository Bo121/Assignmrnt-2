
@SuppressWarnings("serial")
public class StackOverflowException extends Exception {
	//Default constructor
	public StackOverflowException(){
	}
	//Constructor with parameter
	public StackOverflowException(String message){
	    super(message);
	}
}
