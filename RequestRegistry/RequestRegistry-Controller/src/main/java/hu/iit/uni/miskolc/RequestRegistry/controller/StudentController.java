package hu.iit.uni.miskolc.RequestRegistry.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import hu.iit.uni.miskolc.RequestRegistry.Model.Request;
import hu.iit.uni.miskolc.RequestRegistry.Persist.exception.InvalidRequestException;
import hu.iit.uni.miskolc.RequestRegistry.Persist.exception.InvalidTemplateException;
import hu.iit.uni.miskolc.RequestRegistry.Persist.exception.InvalidUserException;
import hu.iit.uni.miskolc.RequestRegistry.Service.RequestService;
import hu.iit.uni.miskolc.RequestRegistry.Service.UserService;
import hu.iit.uni.miskolc.RequestRegistry.controller.model.UserDetails;

@RestController
public class StudentController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private RequestService requestService;
	
	public StudentController() {
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public void modifyUser(@RequestBody UserDetails userDetails) throws InvalidUserException {
		String username = getUsername();
		String firstname = userDetails.getFirstName();
		String lastname = userDetails.getLastName();
		String email = userDetails.getEmail();
		int zip = userDetails.getZip();
		String city = userDetails.getCity();
		String street = userDetails.getStreet();
		String streetNumber = userDetails.getStreetNumber();
		
		this.userService.modifyUserDetails(username, firstname, lastname, email, zip, city, street, streetNumber);
	}

	private String getUsername() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName(); 
	}
	
	@RequestMapping(value = "/submit/{templateName}", method = RequestMethod.POST)
	public void submitRequest(@PathVariable("templateName") String templateName) throws InvalidRequestException, InvalidUserException, InvalidTemplateException {
		String username = getUsername();
		this.requestService.submitRequest(username, templateName);
	}
	
	@RequestMapping(value = "/myRequests", method = RequestMethod.GET)
	public List<Request> listMyRequests() throws InvalidUserException {
		String username = getUsername();
		return this.requestService.listRequestByUser(username);
	}
}
