package volClasses;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity 
@IdClass(EscaleId.class)
public class Escale {

	// Attributs
	private Date heureDepart;
	private Date heureArrivee;
	private Vol vol;
	private Aeroport aeroport;
	private int version;
	
	public Escale(){
		
	}

	// Getters et Setters
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
	@Id
	@ManyToOne 
	@JoinColumn(name="vol_id")
	public Vol getVol() {
		return vol;
	}

	public void setVol(Vol vol) {
		this.vol = vol;
	}
	
	@Id
	@ManyToOne @JoinColumn(name="aeroport_id")
	public Aeroport getAeroport() {
		return aeroport;
	}

	public void setAeroport(Aeroport aeroport) {
		this.aeroport = aeroport;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
	

}
