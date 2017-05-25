package hu.iit.uni.miskolc.RequestRegistry.Service;

import hu.iit.uni.miskolc.RequestRegistry.Model.User;
import hu.iit.uni.miskolc.RequestRegistry.Persist.exception.InvalidUserException;

public interface UserService {

	User getUserById(String username) throws InvalidUserException;
	
	void modifyUserDetails(String username, String firstname, String lastname, String email, int zip, String city, String street, String streetNumber) throws InvalidUserException;
}
