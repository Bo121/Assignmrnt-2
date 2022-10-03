
@SuppressWarnings("serial")
public class StackUnderflowException extends Exception {
	//Default constructor
	public StackUnderflowException(){
	}
	//Constructor with parameter
	public StackUnderflowException(String message){
	    super(message);
	}

}
