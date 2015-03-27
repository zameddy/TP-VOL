package vol.metier.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vol.metier.dao.ClientDao;
import vol.metier.dao.ReservationDao;
import vol.metier.model.Reservation;

@Transactional
@Repository
public class ReservationDaoJpa implements ReservationDao {

	@PersistenceContext //annotation jpa qui injecte automatiquement l'entity manager
	private EntityManager em;

	@Override
	public Reservation find(Long id) {
		return em.find(Reservation.class, id);
	}
	
	@Override
	public Reservation find(int numero) {
		Query query = em.createQuery("from Reservation r where r.numero = :numero");
		query.setParameter("numero", numero);
		List<Reservation> res = query.getResultList();
		return res.size()>0?res.get(0):null ;
	}

	@Override
	public List<Reservation> findAll() {
		Query query = em.createQuery("from Reservation r");		
		return query.getResultList();
	}

	@Override
	public void create(Reservation reservation) {
		em.persist(reservation);
	}

	//un objet r�cup�r� de la base est d�j� manag� donc les modif se font automatiquement pas besoin d'update
	//on utilise update pour merger objet
	@Override
	public Reservation update(Reservation reservation) {

		return em.merge(reservation);
		
	}

	@Override
	public void delete(Reservation reservation) {
		reservation.setClient(null);
		reservation.setPassager(null);
		em.remove(reservation);
		
	}

	@Override
	public void delete(Long id) {
		Reservation reservation = find(id);
		reservation.setClient(null);
		reservation.setPassager(null);
		em.remove(reservation);
		
	}

}
