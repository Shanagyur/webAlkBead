package hu.iit.uni.miskolc.RequestRegistry.PersistImpl.daoImpl.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import hu.iit.uni.miskolc.RequestRegistry.Model.RequestStatus;

@Converter
public class RequestStatusConverter implements AttributeConverter<RequestStatus, String> {

	public RequestStatusConverter() {
	}

	@Override
	public String convertToDatabaseColumn(RequestStatus attribute) {
		return null;
	}

	@Override
	public RequestStatus convertToEntityAttribute(String dbData) {
		return null;
	}
}
