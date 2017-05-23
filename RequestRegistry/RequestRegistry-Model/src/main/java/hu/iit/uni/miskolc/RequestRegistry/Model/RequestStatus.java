package hu.iit.uni.miskolc.RequestRegistry.Model;

public enum RequestStatus {
	
	REQUEST_ACCEPT("Accepted"),
	REQUEST_DENIED("Denieded"),
	REQUEST_PENDING("Pending");
	
	private String value;
	
	private RequestStatus(String status) {
		this.value = status;
	}

	@Override
	public String toString() {
		return value;
	}
}
