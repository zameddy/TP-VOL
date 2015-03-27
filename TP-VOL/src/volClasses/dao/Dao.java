package volClasses.dao;

import java.io.Serializable;
import java.util.List;

/*
 * Interface g�n�rique afin de diminuer la g�n�ration de code:
 * T = Classe
 * PK = Type de la cl� primaire
 */
public interface Dao <T, PK extends Serializable> {
	
	void create (T entity);
	T find (PK id);
	List <T> findAll();
	T update (T entity);
	void delete (T entity);

}