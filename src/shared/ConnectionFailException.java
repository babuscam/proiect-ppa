package shared;

public class ConnectionFailException extends RuntimeException{
	public ConnectionFailException(String message) {
		super(message);
	}
}
