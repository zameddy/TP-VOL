package vol.metier.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vol.metier.dao.VilleAeroportDao;
import vol.metier.model.VilleAeroport;

@Transactional
@Repository
public class VilleAeroportDaoJpa implements VilleAeroportDao {

	@PersistenceContext //annotation jpa qui injecte automatiquement l'entity manager
	private EntityManager em;

	
	@Override
	public VilleAeroport find(Long id) {
		return em.find(VilleAeroport.class, id);
	}
	

	@Override
	public List<VilleAeroport> findAll() {
		Query query = em.createQuery("from VilleAeroport v");		
		return query.getResultList();
	}

	@Override
	public void create(VilleAeroport villeAeroport) {
		em.persist(villeAeroport);
		
	}

	@Override
	public VilleAeroport update(VilleAeroport villeAeroport) {
		return em.merge(villeAeroport);
	}

	@Override
	public void delete(VilleAeroport villeAeroport) {
		em.remove(villeAeroport);
		
	}

	@Override
	public void delete(Long id) {
		VilleAeroport villeAeroport = find(id);
		em.remove(villeAeroport);
	
	}

}
