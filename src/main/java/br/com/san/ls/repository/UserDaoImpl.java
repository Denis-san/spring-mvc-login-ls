package br.com.san.ls.repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.san.ls.entity.User;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void saveNewUser(User user) {
		entityManager.persist(user);
	}

	@Override
	public boolean emailAlreadyExists(String email) {
		Query query = entityManager.createQuery("SELECT u.email FROM UserLogin u WHERE u.email=:email");
		query.setParameter("email", email);
		try {
			Object objt = query.getSingleResult();

			if (objt == null) {
				return false;
			}

			return true;
		} catch (NoResultException e) {
			return false;
		}
	}
}
