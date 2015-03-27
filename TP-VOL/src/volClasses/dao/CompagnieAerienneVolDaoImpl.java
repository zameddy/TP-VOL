package volClasses.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import vol.EntityManagerFactorySingleton;
import volClasses.CompagnieAerienneVol;
import volClasses.CompagnieAerienneVolId;

public class CompagnieAerienneVolDaoImpl implements CompagnieAerienneVolDao{

	private EntityManagerFactory emf = null;
	private EntityManager man = null;
	private EntityTransaction tra = null;

	@Override
	public void create(CompagnieAerienneVol entity) {
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
	public CompagnieAerienneVol find(CompagnieAerienneVolId id) {
		CompagnieAerienneVol compagnieaeriennevol = null;
		try{
			emf = EntityManagerFactorySingleton.getInstance().getEntitymanagerfactory();
			man = emf.createEntityManager();
			tra = man.getTransaction();
			tra.begin();
			
			compagnieaeriennevol = man.find(CompagnieAerienneVol.class, id);
			
			tra.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tra.rollback();
		} finally {
			if (tra.isActive())
				tra.rollback();
			man.close();
		}
		return compagnieaeriennevol;
	}

	@Override
	public List<CompagnieAerienneVol> findAll() {
		List<CompagnieAerienneVol> liste = null;
		try{
			emf = EntityManagerFactorySingleton.getInstance().getEntitymanagerfactory();
			man = emf.createEntityManager();
			tra = man.getTransaction();
			tra.begin();
			
			Query query = man.createQuery("select cav from CompagnieAerienneVol as cav");
			liste = (List<CompagnieAerienneVol>)query.getResultList();
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
	public CompagnieAerienneVol update(CompagnieAerienneVol entity) {
		CompagnieAerienneVol compagnieaeriennevol = null;
		try{
			emf = EntityManagerFactorySingleton.getInstance().getEntitymanagerfactory();
			man = emf.createEntityManager();
			tra = man.getTransaction();
			tra.begin();
			
			compagnieaeriennevol = man.merge(entity);
			
			tra.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tra.rollback();
		} finally {
			if (tra.isActive())
				tra.rollback();
			man.close();
		}
		return compagnieaeriennevol;
	}

	@Override
	public void delete(CompagnieAerienneVol entity) {
		try{
			emf = EntityManagerFactorySingleton.getInstance().getEntitymanagerfactory();
			man = emf.createEntityManager();
			tra = man.getTransaction();
			tra.begin();
			
			CompagnieAerienneVol compagnieaeriennevol = man.merge(entity);
			man.remove(compagnieaeriennevol);
			
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
