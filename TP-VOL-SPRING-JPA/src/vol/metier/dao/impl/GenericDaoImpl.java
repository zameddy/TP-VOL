package vol.metier.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import vol.metier.dao.Dao;


public class GenericDaoImpl<T,PK extends Serializable> implements Dao<T, PK>{

	protected Class<T> entityClass;
	
	@PersistenceContext //annotation jpa qui injecte automatiquement l'entity manager
	private EntityManager em;
	
	public GenericDaoImpl() {
		ParameterizedType genericSuperclass = (ParameterizedType)getClass().
				getGenericSuperclass();
		this.entityClass = (Class<T>) genericSuperclass.getActualTypeArguments()[0];
	}

	@Override
	public T find(PK id) {
		// TODO Auto-generated method stub
		 return em.find(entityClass, id);
	}

	@Override
	public List<T> findAll() {
		// TODO Auto-generated method stub
		Query query = em.createQuery("from " + entityClass + " t" );
		return query.getResultList();
	}

	@Override
	public void create(T obj) {
		// TODO Auto-generated method stub
		em.persist(obj);
		
	}

	@Override
	public void delete(PK id) {
		// TODO Auto-generated method stub
		em.remove(em.find(entityClass, id));
	}

	@Override
	public T update(T obj) {
		// TODO Auto-generated method stub
		return em.merge(obj);
	}

	@Override
	public void delete(T obj) {
		// TODO Auto-generated method stub
		em.remove(obj);
	}

}
