package vol.metier.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vol.metier.dao.LoginDao;
import vol.metier.model.Login;

@Transactional
@Repository
public class LoginDaoJpa implements LoginDao{
	
	@PersistenceContext //annotation jpa qui injecte automatiquement l'entity manager
	private EntityManager em;


	@Override
	public Login find(Long id) {
		return em.find(Login.class, id);
		
	}
	
	@Override
	public Login find(String login) {
		Query query = em.createQuery("from Login l where l.login = :login");	
		query.setParameter("login", login);
		List<Login> log = query.getResultList();
		return log.size()>0?log.get(0):null ;
	}

	@Override
	public List<Login> findAll() {
		Query query = em.createQuery("from Login l");		
		return query.getResultList();
	}

	@Override
	public void create(Login login) {
		em.persist(login);
	}

	//un objet r�cup�r� de la base est d�j� manag� donc les modif se font 
	//automatiquement pas besoin d'update
	//on utilise update pour merger objet
	@Override
	public Login update(Login login) {
		return em.merge(login);
		
	}

	@Override
	public void delete(Login login) {
		em.remove(login);
		
	}

	@Override
	public void delete(Long id) {
		Login login = find(id);
		em.remove(login);
		
	}

	
	@Override
	public Login checkLogin(String login, String password) {
		TypedQuery<Login> query = em
				.createQuery(
						"select l from Login as l where l.login = :login AND l.motDePasse=:password ",
						Login.class);
		query.setParameter("login", login);
		query.setParameter("password", password);
		// getSingleResult() throws an exception if no entity is found
		// Login loginEntity = query.getSingleResult();
		List<Login> list = query.getResultList();
		if (list.size() == 0) {
			return null;
		} else {
			return list.get(0);
		}
	}
	

}
