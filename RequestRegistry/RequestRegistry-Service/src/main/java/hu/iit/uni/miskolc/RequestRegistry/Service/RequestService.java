package hu.iit.uni.miskolc.RequestRegistry.Service;

import java.util.List;

import hu.iit.uni.miskolc.RequestRegistry.Model.Request;
import hu.iit.uni.miskolc.RequestRegistry.Persist.exception.InvalidRequestException;
import hu.iit.uni.miskolc.RequestRegistry.Persist.exception.InvalidTemplateException;
import hu.iit.uni.miskolc.RequestRegistry.Persist.exception.InvalidUserException;

public interface RequestService {

	void submitRequest(String username, String templateName) throws InvalidRequestException, InvalidUserException, InvalidTemplateException;
	
	List<Request> listRequestByUser(String username) throws InvalidUserException;
	
	void makeRemarks(int requestId, String newComment) throws InvalidRequestException;
	
	List<Request> listRequestByComment(String comment) throws InvalidRequestException;
	
	void makeVerdict(int requestId, String newStatus) throws InvalidRequestException;
	
	List<Request> listRequestByStatus(String status) throws InvalidRequestException;
	
	void forwardRequest(String username, int requestId) throws InvalidUserException, InvalidRequestException;
}
