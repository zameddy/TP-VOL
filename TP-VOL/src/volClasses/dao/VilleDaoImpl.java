package volClasses.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import vol.EntityManagerFactorySingleton;
import volClasses.Ville;

public class VilleDaoImpl implements VilleDao{

	private EntityManagerFactory emf = null;
	private EntityManager man = null;
	private EntityTransaction tra = null;

	@Override
	public void create(Ville entity) {
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
	public Ville find(Long id) {
		Ville ville = null;
		try{
			emf = EntityManagerFactorySingleton.getInstance().getEntitymanagerfactory();
			man = emf.createEntityManager();
			tra = man.getTransaction();
			tra.begin();
			
			ville = man.find(Ville.class, id);
			
			tra.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tra.rollback();
		} finally {
			if (tra.isActive())
				tra.rollback();
			man.close();
		}
		return ville;
	}

	@Override
	public List<Ville> findAll() {
		List<Ville> liste = null;
		try{
			emf = EntityManagerFactorySingleton.getInstance().getEntitymanagerfactory();
			man = emf.createEntityManager();
			tra = man.getTransaction();
			tra.begin();
			
			Query query = man.createQuery("select v from Ville as v");
			liste = (List<Ville>)query.getResultList();
			for (Ville ville : liste) {
				System.out.println(ville.getNom());
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
	public Ville update(Ville entity) {
		Ville ville = null;
		try{
			emf = EntityManagerFactorySingleton.getInstance().getEntitymanagerfactory();
			man = emf.createEntityManager();
			tra = man.getTransaction();
			tra.begin();
			
			ville = man.merge(entity);
			
			tra.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tra.rollback();
		} finally {
			if (tra.isActive())
				tra.rollback();
			man.close();
		}
		return ville;
	}

	@Override
	public void delete(Ville entity) {
		try{
			emf = EntityManagerFactorySingleton.getInstance().getEntitymanagerfactory();
			man = emf.createEntityManager();
			tra = man.getTransaction();
			tra.begin();
			
			Ville ville = man.merge(entity);
			man.remove(ville);
			
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
}
