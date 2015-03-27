package vol.metier.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vol.metier.dao.PassagerDao;
import vol.metier.dao.ReservationDao;
import vol.metier.model.Passager;
import vol.metier.model.Reservation;

@Transactional
@Repository
public class PassagerDaoJpa implements PassagerDao{

	@PersistenceContext //annotation jpa qui injecte automatiquement l'entity manager
	private EntityManager em;
	
	@Autowired
	private ReservationDao reservationDao;

	
	@Override
	public Passager find(Long id) {
		 return em.find(Passager.class, id);
	
	}
	
	@Override
	public Passager find(String name) {
		Query query = em.createQuery("from Passager p where p.nom = :nom");	
		query.setParameter("nom", name);
		//List<Passager> passager = query.getResultList();
		//return passager.size()>0?passager.get(0):null;
		try {
			return (Passager) query.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}
	

	@Override
	public List<Passager> findAll() {
		Query query = em.createQuery("from Passager p");		
		return query.getResultList();
	}

	@Override
	public void create(Passager passager) {
		em.persist(passager);
		
	}

	@Override
	public Passager update(Passager passager) {
		return em.merge(passager);
	}

	@Override
	public void delete(Passager passager) {
		for(Reservation resa : passager.getReservations()){
			reservationDao.delete(resa);
		}
		em.remove(passager);
		
	}

	@Override
	public void delete(Long id) {
		Passager passager = find(id);
		for(Reservation resa : passager.getReservations()){
			reservationDao.delete(resa);
		}
		em.remove(passager);
		
	}

}
