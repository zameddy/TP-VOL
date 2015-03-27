package volClasses;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Vol {

	// Attributs
	private Long id;
	private Date heureDepart;
	private Date heureArrivee;
	private Aeroport aeroportDepart;
	private Aeroport aeroportArrivee;
	private Collection<Escale> escales;
	private Set<Reservation> reservations = new HashSet<Reservation>();
	private Set<CompagnieAerienneVol> compagniesAeriennesVols = new HashSet<CompagnieAerienneVol>();
	private int version;

	// Getters et Setters
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getHeureDepart() {
		return heureDepart;
	}

	public void setHeureDepart(Date heureDepart) {
		this.heureDepart = heureDepart;
	}

	public Date getHeureArrivee() {
		return heureArrivee;
	}

	public void setHeureArrivee(Date heureArrivee) {
		this.heureArrivee = heureArrivee;
	}

	@OneToOne
	@JoinColumn(name="aeroportDepart_id")
	public Aeroport getAeroportDepart() {
		return aeroportDepart;
	}

	public void setAeroportDepart(Aeroport aeroportDepart) {
		this.aeroportDepart = aeroportDepart;
	}

	@OneToOne
	@JoinColumn(name="aeroportArrivee_id")
	public Aeroport getAeroportArrivee() {
		return aeroportArrivee;
	}

	public void setAeroportArrivee(Aeroport aeroportArrivee) {
		this.aeroportArrivee = aeroportArrivee;
	}

	@OneToMany(mappedBy="vol", fetch=FetchType.LAZY)
	public Collection<Escale> getEscales() {
		return escales;
	}

	public void setEscales(Collection<Escale> escales) {
		this.escales = escales;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@OneToMany(mappedBy="vol")
	public Set<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(Set<Reservation> reservations) {
		this.reservations = reservations;
	}

	@OneToMany(mappedBy="compagnieAerienneVolId.vol")
	public Set<CompagnieAerienneVol> getCompagniesAeriennesVols() {
		return compagniesAeriennesVols;
	}

	public void setCompagniesAeriennesVols(
			Set<CompagnieAerienneVol> compagniesAeriennesVols) {
		this.compagniesAeriennesVols = compagniesAeriennesVols;
	}
	
	

}
