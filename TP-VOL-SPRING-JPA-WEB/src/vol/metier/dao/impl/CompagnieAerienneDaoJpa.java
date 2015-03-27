package vol.metier.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vol.metier.dao.CompagnieAerienneDao;
import vol.metier.model.CompagnieAerienne;

@Transactional
@Repository
public class CompagnieAerienneDaoJpa implements CompagnieAerienneDao {

	@PersistenceContext //annotation jpa qui injecte automatiquement l'entity manager
	private EntityManager em;


	@Override
	public CompagnieAerienne find(Long id) {
		return em.find(CompagnieAerienne.class, id);
	}

	@Override
	public List<CompagnieAerienne> findAll() {
		Query query = em.createQuery("from CompagnieAerienne ca");		
		return query.getResultList();
	}

	@Override
	public void create(CompagnieAerienne compagnieAerienne) {
		em.persist(compagnieAerienne);
	}

	//un objet r�cup�r� de la base est d�j� manag� donc les modif se font automatiquement pas besoin d'update
	//on utilise update pour merger objet
	@Override
	public CompagnieAerienne update(CompagnieAerienne compagnieAerienne) {
		return em.merge(compagnieAerienne);
		
	}

	@Override
	public void delete(CompagnieAerienne compagnieAerienne) {
		em.remove(compagnieAerienne);
		
	}

	@Override
	public void delete(Long id) {
		CompagnieAerienne compagnieAerienne = find(id);
		em.remove(compagnieAerienne);
		
	}

}
