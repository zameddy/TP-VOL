package volClasses;

public class ClientEl extends Client{
	
	private TitreClient titre;
	private String prenom;
	
	public ClientEl() {
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
