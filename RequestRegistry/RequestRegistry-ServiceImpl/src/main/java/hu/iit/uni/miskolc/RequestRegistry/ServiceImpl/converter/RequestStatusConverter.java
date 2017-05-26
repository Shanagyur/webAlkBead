package hu.iit.uni.miskolc.RequestRegistry.ServiceImpl.converter;

import hu.iit.uni.miskolc.RequestRegistry.Model.RequestStatus;

public class RequestStatusConverter {

	private RequestStatusConverter(){
	}
	
	public static RequestStatus convertStringToRequestStatus(String requestStatus) {
		RequestStatus status = null;
		
		if(RequestStatus.REQUEST_ACCEPT.toString().equals(requestStatus)) {
			status = RequestStatus.REQUEST_ACCEPT;
		} else if(RequestStatus.REQUEST_DENIED.toString().equals(requestStatus)) {
			status = RequestStatus.REQUEST_DENIED;
		} else if(RequestStatus.REQUEST_PENDING.toString().equals(requestStatus)) {
			status = RequestStatus.REQUEST_PENDING;
		}
		
		return status;
	}
}
