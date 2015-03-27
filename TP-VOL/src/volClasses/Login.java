package volClasses;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Login {
	
	private long id;
	private String login;
	private String motDePasse;
	private boolean admin;
	private Client client;
	
	public Login() {
		super();
	}

	//Getters and Setters
	
	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	@OneToOne(mappedBy="login")
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}	

}
