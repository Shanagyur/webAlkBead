package hu.iit.uni.miskolc.RequestRegistry.Persist.dao;

import hu.iit.uni.miskolc.RequestRegistry.Model.Details;
import hu.iit.uni.miskolc.RequestRegistry.Persist.exception.InvalidUserException;

public interface UserDao {

	void modifyUserDetails(String username, Details newDetails) throws InvalidUserException;
}
