package br.com.san.ls.repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.san.ls.entity.UserLogin;

@Repository
@Transactional
public class UserLoginDaoImpl implements UserLoginDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public UserLogin findByLoginName(String loginName) throws NoResultException{
		TypedQuery<UserLogin> query = entityManager.createQuery("SELECT u FROM UserLogin u WHERE u.loginName =:loginName", UserLogin.class);
		query.setParameter("loginName", loginName);
		
		UserLogin userLogin = query.getSingleResult();

		return userLogin;
	}

	 
	
}
