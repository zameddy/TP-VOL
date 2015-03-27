package volClasses;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class CompagnieAerienne {

	// Attributs
	private Long id;
	private String nom;
	private Set<CompagnieAerienneVol> compagniesAeriennesVols = new HashSet<CompagnieAerienneVol>();
	private int version;

	public CompagnieAerienne() {
	
	}
	
	
	// Getters et Setters
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@OneToMany(mappedBy="compagnieAerienneVolId.compagnieAerienne")
	public Set<CompagnieAerienneVol> getCompagniesAeriennesVols() {
		return compagniesAeriennesVols;
	}

	public void setCompagniesAeriennesVols(
			Set<CompagnieAerienneVol> compagniesAeriennesVols) {
		this.compagniesAeriennesVols = compagniesAeriennesVols;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

}
