
@SuppressWarnings("serial")
public class QueueOverflowException extends Exception {
	//Default constructor
	public QueueOverflowException(){
	}
	//Constructor with parameter
	public QueueOverflowException(String message){
	    super(message);
	}
}
