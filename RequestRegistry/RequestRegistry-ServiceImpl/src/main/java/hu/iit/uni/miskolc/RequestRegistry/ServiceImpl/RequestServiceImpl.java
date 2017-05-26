package hu.iit.uni.miskolc.RequestRegistry.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.iit.uni.miskolc.RequestRegistry.Model.Request;
import hu.iit.uni.miskolc.RequestRegistry.Model.RequestStatus;
import hu.iit.uni.miskolc.RequestRegistry.Model.Template;
import hu.iit.uni.miskolc.RequestRegistry.Model.User;
import hu.iit.uni.miskolc.RequestRegistry.Persist.dao.RequestDao;
import hu.iit.uni.miskolc.RequestRegistry.Persist.exception.InvalidRequestException;
import hu.iit.uni.miskolc.RequestRegistry.Persist.exception.InvalidTemplateException;
import hu.iit.uni.miskolc.RequestRegistry.Persist.exception.InvalidUserException;
import hu.iit.uni.miskolc.RequestRegistry.Service.RequestService;
import hu.iit.uni.miskolc.RequestRegistry.Service.TemplateService;
import hu.iit.uni.miskolc.RequestRegistry.Service.UserService;
import hu.iit.uni.miskolc.RequestRegistry.ServiceImpl.converter.RequestStatusConverter;

@Service
public class RequestServiceImpl implements RequestService {

	@Autowired
	private RequestDao requestDao;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private TemplateService templateService;
	
	public RequestServiceImpl() {
	}

	@Override
	public void submitRequest(String username, String templateName) throws InvalidUserException, InvalidTemplateException, InvalidRequestException {
		User user = this.userService.getUserById(username);
		Template template = this.templateService.getTemplateByName(templateName);
		
		Request request = new Request();
		request.setUser(user);
		request.setTemplate(template);
		request.setStatus(RequestStatus.REQUEST_PENDING);
		
		this.requestDao.submitRequest(request);;
	}

	@Override
	public List<Request> listRequestByUser(String username) throws InvalidUserException {
		User user = this.userService.getUserById(username);
		try {
			return this.requestDao.listRequestByUser(user);
		} catch (InvalidRequestException e) {
			throw new InvalidUserException();
		}
	}

	@Override
	public void makeRemarks(int requestId, String newComment) throws InvalidRequestException {
		Request request = this.requestDao.requestById(requestId);
		this.requestDao.makeRemarks(request, newComment);
	}

	@Override
	public List<Request> listRequestByComment(String comment) throws InvalidRequestException {
		return this.requestDao.listRequestByComment(comment);
	}

	@Override
	public void makeVerdict(int requestId, String newStatus) throws InvalidRequestException {
		Request request = this.requestDao.requestById(requestId);
		RequestStatus status = RequestStatusConverter.convertStringToRequestStatus(newStatus);
		
		this.requestDao.makeVerdict(request, status);
	}

	@Override
	public List<Request> listRequestByStatus(String status) throws InvalidRequestException {
		RequestStatus requestStatus = RequestStatusConverter.convertStringToRequestStatus(status);
		
		return this.requestDao.listRequestByStatus(requestStatus);
	}

	@Override
	public void forwardRequest(String username, int requestId) throws InvalidUserException, InvalidRequestException {
		User destinationUser = this.userService.getUserById(username);
		Request request = this.requestDao.requestById(requestId);
		
		this.requestDao.forwardRequest(destinationUser, request);
	}
}
