package volClasses;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("ClientMoral")
public class ClientMoral extends Client{
	
	private TitreClient titre;
	private String siret;
	
	public ClientMoral() {
		super();
	}

	//Getters and Setters
	public TitreClient getTitre() {
		return titre;
	}

	public void setTitre(TitreClient titre) {
		this.titre = titre;
	}

	public String getSiret() {
		return siret;
	}

	public void setSiret(String siret) {
		this.siret = siret;
	}
	
	
	
	

}
