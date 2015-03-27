package volClasses.dao;

import volClasses.Passager;
import volClasses.Reservation;

public interface PassagerDao extends Dao <Passager, Long>{
	
	public Passager findByName(String nom);
	public Passager findByReservation(Reservation reservation);

}
