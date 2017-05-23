package hu.iit.uni.miskolc.RequestRegistry.Persist.exception;

public class InvalidRequestException extends Exception {

	private static final long serialVersionUID = 9020062484017514092L;

	public InvalidRequestException() {
	}

	public InvalidRequestException(String message) {
		super(message);
	}
}
