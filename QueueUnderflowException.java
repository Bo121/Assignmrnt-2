
@SuppressWarnings("serial")
public class QueueUnderflowException extends Exception {
	//Default constructor
	public QueueUnderflowException(){
	}
	//Constructor with parameter
	public QueueUnderflowException(String message){
	    super(message);
	}
}
