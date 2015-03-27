package volClasses.dao;

import volClasses.Client;
import volClasses.Login;

public interface ClientDao extends Dao <Client, Long>{
	
	public Client findByName(String nom);
	public Client findByLogin(Login login);
	

}
