package hu.iit.uni.miskolc.RequestRegistry.Persist.exception;

public class InvalidUserException extends Exception {

	private static final long serialVersionUID = 4950691109269082885L;

	public InvalidUserException() {
	}

	public InvalidUserException(String message) {
		super(message);
	}
}
