package volClasses.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import vol.EntityManagerFactorySingleton;
import volClasses.Passager;
import volClasses.Reservation;
import volClasses.Vol;

public class ReservationDaoImpl implements ReservationDao{
	private EntityManagerFactory emf = null;
	private EntityManager man = null;
	private EntityTransaction tra = null;
	
	@Override
	public void create(Reservation entity) {
		try{
			emf = EntityManagerFactorySingleton.getInstance().getEntitymanagerfactory();
			man = emf.createEntityManager();
			tra = man.getTransaction();
			tra.begin();
			
			man.persist(entity);
			
			tra.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tra.rollback();
		} finally {
			if (tra.isActive())
				tra.rollback();
			man.close();
		}
	}
	@Override
	public Reservation find(Long id) {
		Reservation reservation = null;
		try{
			emf = EntityManagerFactorySingleton.getInstance().getEntitymanagerfactory();
			man = emf.createEntityManager();
			tra = man.getTransaction();
			tra.begin();
			
			reservation = man.find(Reservation.class, id);
			
			tra.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tra.rollback();
		} finally {
			if (tra.isActive())
				tra.rollback();
			man.close();
		}
		return reservation;
	}
	@Override
	public List<Reservation> findAll() {
		List<Reservation> liste = null;
		try{
			emf = EntityManagerFactorySingleton.getInstance().getEntitymanagerfactory();
			man = emf.createEntityManager();
			tra = man.getTransaction();
			tra.begin();
			
			Query query = man.createQuery("select r from Reservation as r");
			liste = (List<Reservation>)query.getResultList();
			for (Reservation reservation : liste) {
				System.out.println(reservation.getId());
			}
			
			tra.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tra.rollback();
		} finally {
			if (tra.isActive())
				tra.rollback();
			man.close();
		}
		return liste;
	}
	@Override
	public Reservation update(Reservation entity) {
		Reservation reservation = null;
		try{
			emf = EntityManagerFactorySingleton.getInstance().getEntitymanagerfactory();
			man = emf.createEntityManager();
			tra = man.getTransaction();
			tra.begin();
			
			reservation = man.merge(entity);
			
			tra.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tra.rollback();
		} finally {
			if (tra.isActive())
				tra.rollback();
			man.close();
		}
		return reservation;
	}
	@Override
	public void delete(Reservation entity) {
		try{
			emf = EntityManagerFactorySingleton.getInstance().getEntitymanagerfactory();
			man = emf.createEntityManager();
			tra = man.getTransaction();
			tra.begin();
			
			Reservation reservation = man.merge(entity);
			man.remove(reservation);
			
			tra.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tra.rollback();
		} finally {
			if (tra.isActive())
				tra.rollback();
			man.close();
		}
	}
	@Override
	public Reservation findByNumero(int numero) {
		Reservation reservation = null;
		try{
			emf = EntityManagerFactorySingleton.getInstance().getEntitymanagerfactory();
			man = emf.createEntityManager();
			tra = man.getTransaction();
			tra.begin();
			
			Query query = man.createQuery("SELECT r FROM Reservation as r WHERE r.numero = :num1");
			query.setParameter("num1", numero);
			reservation = (Reservation)query.getSingleResult();
			
			tra.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tra.rollback();
		} finally {
			if (tra.isActive())
				tra.rollback();
			man.close();
		}	
		return reservation;
	}
	@Override
	public List<Reservation> findAllByPassager(Passager passager) {
		List<Reservation> liste = null;
		try{
			emf = EntityManagerFactorySingleton.getInstance().getEntitymanagerfactory();
			man = emf.createEntityManager();
			tra = man.getTransaction();
			tra.begin();
			
			Query query = man.createQuery("SELECT r FROM Reservation as r WHERE r.passager = :pass1");
			query.setParameter("pass1", passager);
			liste = (List<Reservation>)query.getResultList();
			for (Reservation reservation : liste) {
				System.out.println(reservation.getId());
			}
			
			tra.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tra.rollback();
		} finally {
			if (tra.isActive())
				tra.rollback();
			man.close();
		}	
		return liste;
	}
	@Override
	public List<Reservation> findAllByVol(Vol vol) {
		List<Reservation> liste = null;
		try{
			emf = EntityManagerFactorySingleton.getInstance().getEntitymanagerfactory();
			man = emf.createEntityManager();
			tra = man.getTransaction();
			tra.begin();
			
			Query query = man.createQuery("SELECT r FROM Reservation as r WHERE r.vol = :vol1");
			query.setParameter("vol1", vol);
			liste = (List<Reservation>)query.getResultList();
			for (Reservation reservation : liste) {
				System.out.println(reservation.getId());
			}
			
			tra.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tra.rollback();
		} finally {
			if (tra.isActive())
				tra.rollback();
			man.close();
		}	
		return liste;
	}
	@Override
	public Reservation findByPassager(Passager passager) {
		Reservation reservation = null;
		try{
			emf = EntityManagerFactorySingleton.getInstance().getEntitymanagerfactory();
			man = emf.createEntityManager();
			tra = man.getTransaction();
			tra.begin();
			
			Query query = man.createQuery("SELECT r FROM Reservation as r WHERE r.passager = :passager1");
			query.setParameter("passager1", passager);
			reservation = (Reservation)query.getSingleResult();
			
			tra.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tra.rollback();
		} finally {
			if (tra.isActive())
				tra.rollback();
			man.close();
		}	
		return reservation;
	}

}