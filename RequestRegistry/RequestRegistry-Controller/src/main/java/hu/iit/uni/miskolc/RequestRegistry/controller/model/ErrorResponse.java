package hu.iit.uni.miskolc.RequestRegistry.controller.model;

public class ErrorResponse {

	private String message;
	private String reason;

	public ErrorResponse() {
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
}
