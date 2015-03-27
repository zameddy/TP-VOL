package volClasses.dao;

import java.util.List;

import volClasses.Passager;
import volClasses.Reservation;
import volClasses.Vol;

public interface ReservationDao extends Dao <Reservation, Long>{

	public Reservation findByNumero(int numero);
	public List<Reservation> findAllByPassager(Passager passager);
	public List<Reservation> findAllByVol(Vol vol);
	public Reservation findByPassager(Passager passager);
	
}
