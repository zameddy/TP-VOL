package volClasses;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("ClientEI")
public class ClientEI extends Client{
	
	private TitreClient titre;
	private String prenom;
	
	public ClientEI() {
		super();
	}

	
	//Getters and Setters
	public TitreClient getTitre() {
		return titre;
	}

	public void setTitre(TitreClient titre) {
		this.titre = titre;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	
	
	

}
