package hu.iit.uni.miskolc.RequestRegistry.PersistImpl.daoImpl.converter;

import hu.iit.uni.miskolc.RequestRegistry.Model.Request;
import hu.iit.uni.miskolc.RequestRegistry.PersistImpl.daoImpl.entity.RequestEntity;

public class RequestEntityConverter {

	private RequestEntityConverter() {
	}

	public static Request convertRequestEntityToModel(RequestEntity requestEntity) {
		Request request = new Request();
		
		request.setId(requestEntity.getId());
		request.setUser(UserEntityConverter.convertUserEntityToModel(requestEntity.getUser()));
		request.setTemplate(TemplateEntityConverter.convertTemplateEntityToModel(requestEntity.getTemplate()));
		request.setComment(requestEntity.getComment());
		request.setStatus(requestEntity.getStatus());
		
		return request;
	}
}
