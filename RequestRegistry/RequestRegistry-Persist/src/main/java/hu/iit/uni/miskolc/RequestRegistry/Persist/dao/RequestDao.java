package hu.iit.uni.miskolc.RequestRegistry.Persist.dao;

import java.util.List;

import hu.iit.uni.miskolc.RequestRegistry.Model.Request;
import hu.iit.uni.miskolc.RequestRegistry.Model.RequestStatus;
import hu.iit.uni.miskolc.RequestRegistry.Model.User;
import hu.iit.uni.miskolc.RequestRegistry.Persist.exception.InvalidRequestException;
import hu.iit.uni.miskolc.RequestRegistry.Persist.exception.InvalidUserException;

public interface RequestDao {

	void submitRequest(Request request) throws InvalidRequestException;
	
	List<Request> listRequestByUser(User user) throws InvalidRequestException, InvalidUserException;
	
	void makeRemarks(Request request, String newComment) throws InvalidRequestException;
	
	List<Request> listRequestByComment(String comment) throws InvalidRequestException;
	
	void makeVerdict(Request request, RequestStatus newStatus) throws InvalidRequestException;
	
	List<Request> listRequestByStatus(RequestStatus status) throws InvalidRequestException;
	
	void forwardRequest(User destinationUser, Request request) throws InvalidRequestException, InvalidUserException;
	
	Request requestById(int requestId);
}
