package Helper;
//this class creates a new exception when there is an input error
public class InputException extends Exception{
private static final long serialVersionUID =1L;
	public InputException() {
	super("The data you entered is not correct. Please check the input");
	}
public InputException(String message) {
	super(message);
}
}
