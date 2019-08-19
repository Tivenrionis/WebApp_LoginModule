package com.tivenstudio.dao;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.tivenstudio.interfaces.Dao;
import com.tivenstudio.model.User;

public class UserDAO implements Dao<User> {

	private EntityManagerFactory emf;
	private EntityManager em;

	public void init() {
		emf = Persistence.createEntityManagerFactory("hibernateLink");
		em = emf.createEntityManager();

	}

	public void runInsideTransaction(Consumer<EntityManager> action) {
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();
			action.accept(em);
			tx.commit();
		} catch (Exception e) {

			tx.rollback();
			// throw e;

		} finally {
			em.close();
			emf.close();

		}

	}

	@Override
	public Optional<User> get(long id) {
		return Optional.ofNullable(em.find(User.class, (int) id));
	}

	public Optional<User> get(String username) {
		TypedQuery<User> query = em.createQuery("SELECT u FROM User u WHERE u.username = '" + username + "'",
				User.class);
		try {
			User user = query.getSingleResult();
			return Optional.ofNullable(user);
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
		finally {
			em.close();
			emf.close();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAll() {
		Query query = em.createQuery("SELECT u FROM User u");
		try {
			return query.getResultList();
		} catch (Exception e) {
			e.getMessage();
			return null;
		}

	}

	@Override
	public void save(User user) {
		runInsideTransaction(em -> em.persist(user));

	}

	@Override
	public void update(User user) {
		runInsideTransaction(em -> em.merge(user));

	}

	@Override
	public void delete(User user) {
		runInsideTransaction(em -> em.remove(user));

	}

	@SuppressWarnings("unchecked")
	public boolean check(String username) {
		Query query = em.createQuery("SELECT u FROM User u WHERE u.username = '" + username + "'");
		// ResultSet rs = (ResultSet) query.getSingleResult();
		try {
			List<User> list = query.getResultList();
			if (list.isEmpty()) {
				return false;

			}
		} catch (Exception e) {
			e.getMessage();
		} finally {
			emf.close();
			em.close();
		}
		return true;

	}

}
