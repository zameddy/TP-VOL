package volClasses.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import vol.EntityManagerFactorySingleton;
import volClasses.Aeroport;

public class AeroportDaoImpl implements AeroportDao{
	private EntityManagerFactory emf = null;
	private EntityManager man = null;
	private EntityTransaction tra = null;

	@Override
	public void create(Aeroport entity) {
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
	public Aeroport find(Long id) {
		Aeroport aeroport = null;
		try{
			emf = EntityManagerFactorySingleton.getInstance().getEntitymanagerfactory();
			man = emf.createEntityManager();
			tra = man.getTransaction();
			tra.begin();
			
			aeroport = man.find(Aeroport.class, id);
			
			tra.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tra.rollback();
		} finally {
			if (tra.isActive())
				tra.rollback();
			man.close();
		}
		return aeroport;
	}

	@Override
	public List<Aeroport> findAll() {
		List<Aeroport> liste = null;
		try{
			emf = EntityManagerFactorySingleton.getInstance().getEntitymanagerfactory();
			man = emf.createEntityManager();
			tra = man.getTransaction();
			tra.begin();
			
			Query query = man.createQuery("select a from Aeroport as a");
			liste = (List<Aeroport>)query.getResultList();
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
	public Aeroport update(Aeroport entity) {
		Aeroport aeroport = null;
		try{
			emf = EntityManagerFactorySingleton.getInstance().getEntitymanagerfactory();
			man = emf.createEntityManager();
			tra = man.getTransaction();
			tra.begin();
			
			aeroport = man.merge(entity);
			
			tra.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tra.rollback();
		} finally {
			if (tra.isActive())
				tra.rollback();
			man.close();
		}
		return aeroport;
	}

	@Override
	public void delete(Aeroport entity) {
		try{
			emf = EntityManagerFactorySingleton.getInstance().getEntitymanagerfactory();
			man = emf.createEntityManager();
			tra = man.getTransaction();
			tra.begin();
			
			Aeroport aeroport = man.merge(entity);
			man.remove(aeroport);
			
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
