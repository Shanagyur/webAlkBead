package hu.iit.uni.miskolc.RequestRegistry.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import hu.iit.uni.miskolc.RequestRegistry.Model.Template;
import hu.iit.uni.miskolc.RequestRegistry.Persist.exception.InvalidTemplateException;
import hu.iit.uni.miskolc.RequestRegistry.Persist.exception.InvalidUserException;
import hu.iit.uni.miskolc.RequestRegistry.Service.TemplateService;
import hu.iit.uni.miskolc.RequestRegistry.Service.UserService;
import hu.iit.uni.miskolc.RequestRegistry.controller.model.UserDetails;

@RestController
public class AdminController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private TemplateService templateService;

	public AdminController() {
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
	
	public void createTemplate(@RequestBody Template template) throws InvalidTemplateException {
		String name = template.getName();
		String description = template.getDescription();
		this.templateService.createTemplate(name, description);
	}
}
