package hu.iit.uni.miskolc.RequestRegistry.Persist.exception;

public class InvalidStudentException extends InvalidUserException {

	private static final long serialVersionUID = -8065167876014683721L;

	public InvalidStudentException() {
	}

	public InvalidStudentException(String message) {
		super(message);
	}
}
