package hu.iit.uni.miskolc.RequestRegistry.PersistImpl.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import hu.iit.uni.miskolc.RequestRegistry.Model.Request;
import hu.iit.uni.miskolc.RequestRegistry.Model.RequestStatus;
import hu.iit.uni.miskolc.RequestRegistry.Model.User;
import hu.iit.uni.miskolc.RequestRegistry.Persist.dao.RequestDao;
import hu.iit.uni.miskolc.RequestRegistry.Persist.exception.InvalidRequestException;
import hu.iit.uni.miskolc.RequestRegistry.Persist.exception.InvalidUserException;
import hu.iit.uni.miskolc.RequestRegistry.PersistImpl.daoImpl.converter.RequestEntityConverter;
import hu.iit.uni.miskolc.RequestRegistry.PersistImpl.daoImpl.converter.TemplateEntityConverter;
import hu.iit.uni.miskolc.RequestRegistry.PersistImpl.daoImpl.converter.UserEntityConverter;
import hu.iit.uni.miskolc.RequestRegistry.PersistImpl.daoImpl.entity.RequestEntity;
import hu.iit.uni.miskolc.RequestRegistry.PersistImpl.daoImpl.entity.TemplateEntity;

@Repository
@Transactional
public class RequestDaoImpl implements RequestDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void submitRequest(Request request) throws InvalidRequestException {
		RequestEntity requestEntity = new RequestEntity();
		
		requestEntity.setUser(UserEntityConverter.convertUserToEntity(request.getUser()));
		requestEntity.setTemplate(TemplateEntityConverter.convertTemplateToEntity(request.getTemplate()));
		requestEntity.setComment(request.getComment());
		requestEntity.setStatus(request.getStatus());
		
		this.entityManager.persist(requestEntity);
	}

	@Override
	public List<Request> listRequestByUser(User user) throws InvalidRequestException, InvalidUserException {
		String select = "SELECT r FROM Request r WHERE r.user.username = :username";
		TypedQuery<RequestEntity> query = this.entityManager.createQuery(select, RequestEntity.class);
		query.setParameter("username", user.getUsername());
		
		List<RequestEntity> requestEntities = query.getResultList();
		
		return RequestEntityConverter.convertRequestEntitiesToModels(requestEntities);
	}
	
	@Override
	public void makeRemarks(Request request, String newComment) throws InvalidRequestException {
		RequestEntity requestEntity = this.entityManager.find(RequestEntity.class, request.getId());
		requestEntity.setComment(newComment);
	}

	@Override
	public List<Request> listRequestByComment(String comment) throws InvalidRequestException {
		String select = "SELECT r FROM Request r WHERE r.comment = :comment";
		TypedQuery<RequestEntity> query = this.entityManager.createQuery(select, RequestEntity.class);
		query.setParameter("comment", comment);
		
		List<RequestEntity> requestEntities = query.getResultList();
		
		return RequestEntityConverter.convertRequestEntitiesToModels(requestEntities);
	}

	@Override
	public void makeVerdict(Request request, RequestStatus newStatus) throws InvalidRequestException {
		RequestEntity requestEntity = this.entityManager.find(RequestEntity.class, request.getId());
		requestEntity.setStatus(newStatus);
	}
	
	@Override
	public List<Request> listRequestByStatus(RequestStatus status) throws InvalidRequestException {
		String select = "SELECT r FROM Request r WHERE r.status = :status";
		TypedQuery<RequestEntity> query = this.entityManager.createQuery(select, RequestEntity.class);
		query.setParameter("status", status);
		
		List<RequestEntity> requestEntities = query.getResultList();
		
		return RequestEntityConverter.convertRequestEntitiesToModels(requestEntities);
	}

	@Override
	public void forwardRequest(User destinationUser, Request request) throws InvalidRequestException, InvalidUserException {
		RequestEntity requestEntity = this.entityManager.find(RequestEntity.class, request.getId());
		requestEntity.setUser(UserEntityConverter.convertUserToEntity(destinationUser));
	}

	@Override
	public Request requestById(int requestId) {
		RequestEntity requestEntity = this.entityManager.find(RequestEntity.class, requestId);
	
		return RequestEntityConverter.convertRequestEntityToModel(requestEntity);
	}
}
