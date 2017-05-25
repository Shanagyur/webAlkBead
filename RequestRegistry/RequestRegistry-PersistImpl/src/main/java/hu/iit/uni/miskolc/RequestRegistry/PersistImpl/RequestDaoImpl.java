package hu.iit.uni.miskolc.RequestRegistry.PersistImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import hu.iit.uni.miskolc.RequestRegistry.Model.Request;
import hu.iit.uni.miskolc.RequestRegistry.Model.RequestStatus;
import hu.iit.uni.miskolc.RequestRegistry.Model.User;
import hu.iit.uni.miskolc.RequestRegistry.Persist.dao.RequestDao;
import hu.iit.uni.miskolc.RequestRegistry.Persist.exception.InvalidRequestException;
import hu.iit.uni.miskolc.RequestRegistry.Persist.exception.InvalidUserException;

@Repository
@Transactional
public class RequestDaoImpl implements RequestDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void submitRequest(Request request) throws InvalidRequestException {
	}

	@Override
	public List<Request> listRequestByUser(User user) throws InvalidRequestException, InvalidUserException {
		return null;
	}

	@Override
	public List<Request> listRequestByComment(String comment) throws InvalidRequestException {
		return null;
	}

	@Override
	public List<Request> listRequestByStatus(RequestStatus status) throws InvalidRequestException {
		return null;
	}

	@Override
	public void forwardRequest(User destinationUser, Request request) throws InvalidRequestException, InvalidUserException {
	}
}
