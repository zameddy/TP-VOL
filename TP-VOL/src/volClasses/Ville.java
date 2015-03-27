package volClasses;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table (name = "Ville")
public class Ville {

	// Attributs
	private Long id;
	private String nom;
	private Set <Aeroport> aeroports = new HashSet<Aeroport>();

	// Getters et Setters
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "ville_id")
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
	@ManyToMany 
	@JoinTable (name ="ville_aeroport", 
		joinColumns = {@JoinColumn(name="ville_id")},
		inverseJoinColumns ={@JoinColumn(name = "aeroport_id")}
			)
	public Set<Aeroport> getAeroports() {
		return aeroports;
	}

	public void setAeroports(Set<Aeroport> aeroports) {
		this.aeroports = aeroports;
	}
	
}
