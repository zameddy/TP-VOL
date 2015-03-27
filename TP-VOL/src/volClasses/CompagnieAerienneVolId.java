package volClasses;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class CompagnieAerienneVolId implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private CompagnieAerienne compagnieAerienne;
	private Vol vol;
	
	public CompagnieAerienneVolId(){
		
	}
	
	public CompagnieAerienneVolId(CompagnieAerienne compagnieAerienne, Vol vol){
		this.vol=vol;
		this.compagnieAerienne=compagnieAerienne;
	}
	

	@ManyToOne
	@JoinColumn(name="compagnieAerienne_id")
	public CompagnieAerienne getCompagnieAerienne() {
		return compagnieAerienne;
	}
	public void setCompagnieAerienne(CompagnieAerienne compagnieAerienne) {
		this.compagnieAerienne = compagnieAerienne;
	}
	

	@ManyToOne
	@JoinColumn(name="vol_id")
	public Vol getVol() {
		return vol;
	}
	public void setVol(Vol vol) {
		this.vol = vol;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((compagnieAerienne == null) ? 0 : compagnieAerienne
						.hashCode());
		result = prime * result + ((vol == null) ? 0 : vol.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CompagnieAerienneVolId other = (CompagnieAerienneVolId) obj;
		if (compagnieAerienne == null) {
			if (other.compagnieAerienne != null)
				return false;
		} else if (!compagnieAerienne.equals(other.compagnieAerienne))
			return false;
		if (vol == null) {
			if (other.vol != null)
				return false;
		} else if (!vol.equals(other.vol))
			return false;
		return true;
	}
	
	

}
