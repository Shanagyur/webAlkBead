package hu.iit.uni.miskolc.RequestRegistry.PersistImpl.daoImpl.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import hu.iit.uni.miskolc.RequestRegistry.Model.RequestStatus;

@Converter
public class RequestStatusConverter implements AttributeConverter<RequestStatus, String> {

	public RequestStatusConverter() {
	}

	@Override
	public String convertToDatabaseColumn(RequestStatus requestStatus) {
		return requestStatus.toString();
	}

	@Override
	public RequestStatus convertToEntityAttribute(String requestStatusValue) {
		RequestStatus requestStatus = null;
		
		if(RequestStatus.REQUEST_ACCEPT.toString().equals(requestStatusValue)) {
			requestStatus = RequestStatus.REQUEST_ACCEPT;
		} else if(RequestStatus.REQUEST_DENIED.toString().equals(requestStatusValue)) {
			requestStatus = RequestStatus.REQUEST_DENIED;
		} else if(RequestStatus.REQUEST_PENDING.toString().equals(requestStatusValue)) {
			requestStatus = RequestStatus.REQUEST_PENDING;
		}
		
		return requestStatus;
	}
}
