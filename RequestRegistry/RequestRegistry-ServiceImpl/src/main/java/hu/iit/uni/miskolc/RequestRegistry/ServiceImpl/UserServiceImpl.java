package hu.iit.uni.miskolc.RequestRegistry.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import hu.iit.uni.miskolc.RequestRegistry.Model.Details;
import hu.iit.uni.miskolc.RequestRegistry.Model.Settlement;
import hu.iit.uni.miskolc.RequestRegistry.Model.User;
import hu.iit.uni.miskolc.RequestRegistry.Persist.dao.UserDao;
import hu.iit.uni.miskolc.RequestRegistry.Persist.exception.InvalidUserException;
import hu.iit.uni.miskolc.RequestRegistry.Service.UserService;

public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	public UserServiceImpl() {
	}
	
	@Override
	public User getUserById(String username) throws InvalidUserException {
		if(this.userDao.getUserById(username) == null) {
			throw new InvalidUserException();
		} else {
			User user = this.userDao.getUserById(username);
			return user;
		}
	}

	@Override
	public void modifyUserDetails(
			String username, String firstname, String lastname, 
			String email, int zip, String city, 
			String street, String streetNumber) throws InvalidUserException {
		
		if(this.userDao.getUserById(username) == null) {
			throw new InvalidUserException();
		} else {
			Settlement newSettlement = new Settlement();
			newSettlement.setZip(zip);
			newSettlement.setCity(city);
			newSettlement.setStreet(street);
			newSettlement.setStreetNumber(streetNumber);
			
			Details newDetails = new Details();
			newDetails.setFirstName(firstname);
			newDetails.setLastName(lastname);
			newDetails.setEmail(email);
			newDetails.setSettlement(newSettlement);
			
			this.userDao.modifyUserDetails(username, newDetails);
		}
	}
}
