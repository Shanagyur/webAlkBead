package hu.iit.uni.miskolc.RequestRegistry.PersistImpl.daoImpl.converter;

import hu.iit.uni.miskolc.RequestRegistry.Model.User;
import hu.iit.uni.miskolc.RequestRegistry.PersistImpl.daoImpl.entity.UserEntity;

public class UserEntityConverter {

	private UserEntityConverter() {
	}

	public static User convertUserEntityToModel(UserEntity userEntity) {
		User user = new User();
		
		user.setUsername(userEntity.getUsername());
		user.setPassword(userEntity.getPassword());
		user.setEnabled(userEntity.isEnabled());
		user.setDetails(DetailsEntityConverter.convertDetailsEntityToModel(userEntity.getDetails()));
		
		return user;
	}
}
