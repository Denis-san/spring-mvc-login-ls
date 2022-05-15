package br.com.san.ls.repository;

import javax.persistence.EntityManager;
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
	public UserLogin findByEmail(String email) {
		TypedQuery<UserLogin> query = entityManager.createQuery("SELECT u FROM UserLogin u WHERE u.email =:email", UserLogin.class);
		query.setParameter("email", email);
		
		UserLogin userLogin = query.getSingleResult();

		return userLogin;
	}

	 
	
}
