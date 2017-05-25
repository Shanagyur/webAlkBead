package hu.iit.uni.miskolc.RequestRegistry.PersistImpl.daoImpl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import hu.iit.uni.miskolc.RequestRegistry.Model.Details;
import hu.iit.uni.miskolc.RequestRegistry.Model.User;
import hu.iit.uni.miskolc.RequestRegistry.Persist.dao.UserDao;
import hu.iit.uni.miskolc.RequestRegistry.Persist.exception.InvalidUserException;
import hu.iit.uni.miskolc.RequestRegistry.PersistImpl.daoImpl.converter.DetailsEntityConverter;
import hu.iit.uni.miskolc.RequestRegistry.PersistImpl.daoImpl.converter.UserEntityConverter;
import hu.iit.uni.miskolc.RequestRegistry.PersistImpl.daoImpl.entity.UserEntity;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	public UserDaoImpl() {
	}

	@Override
	public User getUserById(String username) throws InvalidUserException {
		if(entityManager.find(UserEntity.class, username) == null) {
			throw new InvalidUserException();
		} else {
			String select = "SELECT u FROM User u WHERE u.username = :username";
			TypedQuery<UserEntity> query = this.entityManager.createQuery(select, UserEntity.class);
			query.setParameter("username", username);
			
			UserEntity userEntity = query.getSingleResult();
			
			return UserEntityConverter.convertUserEntityToModel(userEntity);
		}
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