package tests;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import vol.metier.model.Client;
import vol.metier.model.Vol;


public class TestQuery {

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public static void main(String[] args) {
		
		Calendar cal = Calendar.getInstance();
		
		cal.set(2014, 04, 20);
		
		Date maDate = cal.getTime();
		
		try {
			Date maDateFromSDF = sdf.parse("20/04/2014");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
				
	
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TP-Vols");
				
		
		EntityManager em = emf.createEntityManager();
				
		
		EntityTransaction tx = em.getTransaction();

		try {

			tx.begin();

			Query query = em.createQuery("select c from Client c order by c.nom asc");
			
			List<Client> clients = query.getResultList();
			
			for(Client client : clients) {
				System.out.println("client="+client.getNom());
			}
			
			query = em.createQuery("select c.nom, c.login.login from Client c");
			
			List<Object[]> results = query.getResultList();
			
			for(Object[] result : results) {
				System.out.println("nom="+result[0]+" - login="+result[1]);
			}
			
			query = em.createQuery("select c, r from Client c join c.reservations r");
			
			results = query.getResultList();
			
			for(Object[] result : results) {
				System.out.println("c="+result[0]+" - r="+result[1]);
			}
			
			query = em.createQuery("select c, r, p.nom from Client c join c.reservations r join r.passager p");
			
			results = query.getResultList();
			
			for(Object[] result : results) {
				System.out.println("c="+result[0]+" - r="+result[1]);
			}
			
			query = em.createQuery("select c.nom, count(r) as cpt from Client c join c.reservations r group by c.nom");
			
			results = query.getResultList();
			
			for(Object[] result : results) {
				System.out.println("c="+result[0]+" - r="+result[1]);
			}
			
			query = em.createQuery("select v from Vol v join v.reservations r join r.passager p where p.adresse.pays = :monPays");
			query.setParameter("monPays", "France");
			
			List<Vol> vols = query.getResultList();
			
			for(Vol vol : vols) {
				System.out.println("vol="+vol.getDateDepart());
			}
			
			query = em.createQuery("select cav.id.compagnieAerienne.nom, cav.numero from CompagnieAerienneVol cav "
					+ "				where :date between cav.id.vol.dateDepart and cav.id.vol.dateArrivee");
			query.setParameter("date", sdf.parse("20/04/2014"));
			results = query.getResultList();
			
			for(Object[] result : results) {
				System.out.println("nom="+result[0]+" - numéro="+result[1]);
			}
//			
			tx.commit();

		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}finally{
			if (tx.isActive()) {
				tx.rollback();
			}

			em.close();
			emf.close();
		}
		


	}

}
