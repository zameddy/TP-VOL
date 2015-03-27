package volClasses;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name = "Aeroport")
public class Aeroport {
	
	// Attributs
	private Long id;
	private String nom;
	private Set <Ville> villes = new HashSet<Ville>();
	private Collection <Vol> volsArrivant;
	private Collection <Vol> volsPartant;
	private Collection <Escale> escales;
	private int version;

	// Getters et Setters
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "aeroport_id")
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
	
	@ManyToMany(mappedBy="aeroports")
	public Set<Ville> getVilles() {
		return villes;
	}

	public void setVilles(Set<Ville> villes) {
		this.villes = villes;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
	@OneToMany(mappedBy="aeroportArrivee")
	public Collection<Vol> getVolsArrivant() {
		return volsArrivant;
	}

	
	public void setVolsArrivant(Collection<Vol> volsArrivant) {
		this.volsArrivant = volsArrivant;
	}

	@OneToMany(mappedBy="aeroportDepart")
	public Collection<Vol> getVolsPartant() {
		return volsPartant;
	}

	public void setVolsPartant(Collection<Vol> volsPartant) {
		this.volsPartant = volsPartant;
	}

	@OneToMany(mappedBy="aeroport", fetch=FetchType.LAZY)
	public Collection<Escale> getEscales() {
		return escales;
	}

	public void setEscales(Collection<Escale> escales) {
		this.escales = escales;
	}
	
	
	
	
	

}
