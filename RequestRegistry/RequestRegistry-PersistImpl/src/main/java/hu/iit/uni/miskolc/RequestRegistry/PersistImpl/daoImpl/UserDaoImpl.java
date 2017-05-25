package hu.iit.uni.miskolc.RequestRegistry.PersistImpl.daoImpl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import hu.iit.uni.miskolc.RequestRegistry.Model.Details;
import hu.iit.uni.miskolc.RequestRegistry.Persist.dao.UserDao;
import hu.iit.uni.miskolc.RequestRegistry.Persist.exception.InvalidUserException;
import hu.iit.uni.miskolc.RequestRegistry.PersistImpl.daoImpl.converter.DetailsEntityConverter;
import hu.iit.uni.miskolc.RequestRegistry.PersistImpl.daoImpl.entity.UserEntity;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	public UserDaoImpl() {
	}

	@Override
	public void modifyUserDetails(String username, Details newDetails) throws InvalidUserException {
		UserEntity userEntity = this.entityManager.find(UserEntity.class, username);
		
		if(userEntity != null) {
			userEntity.setDetails(DetailsEntityConverter.convertDetailsToEntity(newDetails));
			
			this.entityManager.merge(userEntity);
		} else {
			throw new InvalidUserException();
		}
	}
}
