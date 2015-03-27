package vol.metier.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vol.metier.dao.CompagnieAerienneVolDao;
import vol.metier.dao.EscaleDao;
import vol.metier.dao.ReservationDao;
import vol.metier.dao.VolDao;
import vol.metier.model.CompagnieAerienneVol;
import vol.metier.model.Escale;
import vol.metier.model.Reservation;
import vol.metier.model.Vol;

@Transactional
@Repository
public class VolDaoJpa implements VolDao {

	@PersistenceContext //annotation jpa qui injecte automatiquement l'entity manager
	private EntityManager em;

	@Autowired
	private ReservationDao reservationDao;
	@Autowired
	private CompagnieAerienneVolDao compagnieAerienneVolDao;
	@Autowired
	private EscaleDao escaleDao;

	@Override
	public Vol find(Long id) {
		return em.find(Vol.class, id);
	}

	@Override
	public List<Vol> findAll() {
		Query query = em.createQuery("from Vol v");		
		return query.getResultList();
	}

	@Override
	public void create(Vol vol) {
		em.persist(vol);
	}

	//un objet r�cup�r� de la base est d�j� manag� donc les modif se font automatiquement pas besoin d'update
	//on utilise update pour merger objet
	@Override
	public Vol update(Vol vol) {
		return em.merge(vol);
		
	}

	@Override
	public void delete(Vol vol) {
		for(Reservation resa : vol.getReservations()){
			reservationDao.delete(resa);
		}
		for(Escale escale : vol.getEscales()){
			escaleDao.delete(escale);
		}
		for(CompagnieAerienneVol compagnieAerienneVol : vol.getCompagniesAerienneVol()){
			compagnieAerienneVolDao.delete(compagnieAerienneVol);
		}
		em.remove(vol);
		
	}

	@Override
	public void delete(Long id) {
		Vol vol = find(id);
		for(Reservation resa : vol.getReservations()){
			reservationDao.delete(resa);
		}
		for(Escale escale : vol.getEscales()){
			escaleDao.delete(escale);
		}
		for(CompagnieAerienneVol compagnieAerienneVol : vol.getCompagniesAerienneVol()){
			compagnieAerienneVolDao.delete(compagnieAerienneVol);
		}
		em.remove(vol);
		
	}

}
