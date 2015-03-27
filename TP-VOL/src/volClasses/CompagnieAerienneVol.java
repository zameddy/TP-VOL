package volClasses;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class CompagnieAerienneVol {
	
	// Attributs
	private String numero;
	private CompagnieAerienneVolId compagnieAerienneVolId;
	
	
	public CompagnieAerienneVol(){
		
	}
	
	public CompagnieAerienneVol(CompagnieAerienne compagnieAerienne, Vol vol){
		super();
		this.compagnieAerienneVolId= new CompagnieAerienneVolId(compagnieAerienne, vol);
	}
	
	// Getters et Setters
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	
	@EmbeddedId
	public CompagnieAerienneVolId getCompagnieAerienneVolId() {
		return compagnieAerienneVolId;
	}
	public void setCompagnieAerienneVolId(CompagnieAerienneVolId compagnieAerienneVolId) {
		this.compagnieAerienneVolId = compagnieAerienneVolId;
	}
	

}
