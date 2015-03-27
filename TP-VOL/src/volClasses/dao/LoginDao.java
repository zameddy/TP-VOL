package volClasses.dao;

import volClasses.Client;
import volClasses.Login;

public interface LoginDao extends Dao <Login, Long>{

	public Login findByLogin(Login login);
	public Login findByClient(Client client);
}
