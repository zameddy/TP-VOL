package volClasses.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import vol.EntityManagerFactorySingleton;
import volClasses.CompagnieAerienne;
import volClasses.Passager;

public class CompagnieAerienneDaoImpl implements CompagnieAerienneDao{
	private EntityManagerFactory emf = null;
	private EntityManager man = null;
	private EntityTransaction tra = null;

	@Override
	public void create(CompagnieAerienne entity) {
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
	public CompagnieAerienne find(Long id) {
		CompagnieAerienne compagnieaerienne = null;
		try{
			emf = EntityManagerFactorySingleton.getInstance().getEntitymanagerfactory();
			man = emf.createEntityManager();
			tra = man.getTransaction();
			tra.begin();
			
			compagnieaerienne = man.find(CompagnieAerienne.class, id);
			
			tra.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tra.rollback();
		} finally {
			if (tra.isActive())
				tra.rollback();
			man.close();
		}
		return compagnieaerienne;
	}

	@Override
	public List<CompagnieAerienne> findAll() {
		List<CompagnieAerienne> liste = null;
		try{
			emf = EntityManagerFactorySingleton.getInstance().getEntitymanagerfactory();
			man = emf.createEntityManager();
			tra = man.getTransaction();
			tra.begin();
			
			Query query = man.createQuery("select ca from CompagnieAerienne as ca");
			liste = (List<CompagnieAerienne>)query.getResultList();
			for (CompagnieAerienne passager : liste) {
				System.out.println(passager.getNom());
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
	public CompagnieAerienne update(CompagnieAerienne entity) {
		CompagnieAerienne passager = null;
		try{
			emf = EntityManagerFactorySingleton.getInstance().getEntitymanagerfactory();
			man = emf.createEntityManager();
			tra = man.getTransaction();
			tra.begin();
			
			passager = man.merge(entity);
			
			tra.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tra.rollback();
		} finally {
			if (tra.isActive())
				tra.rollback();
			man.close();
		}
		return passager;
	}

	@Override
	public void delete(CompagnieAerienne entity) {
		try{
			emf = EntityManagerFactorySingleton.getInstance().getEntitymanagerfactory();
			man = emf.createEntityManager();
			tra = man.getTransaction();
			tra.begin();
			
			CompagnieAerienne passager = man.merge(entity);
			man.remove(passager);
			
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
