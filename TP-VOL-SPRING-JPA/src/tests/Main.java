package tests;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;









import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import vol.metier.model.Adresse;
import vol.metier.model.Aeroport;
import vol.metier.model.ClientPhysique;
import vol.metier.model.CompagnieAerienne;
import vol.metier.model.CompagnieAerienneVol;
import vol.metier.model.CompagnieAerienneVolId;
import vol.metier.model.Escale;
import vol.metier.model.Login;
import vol.metier.model.Passager;
import vol.metier.model.Reservation;
import vol.metier.model.TitrePhysique;
import vol.metier.model.Ville;
import vol.metier.model.VilleAeroport;
import vol.metier.model.Vol;


public class Main {


	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");		
	
		
		EntityManagerFactory emf = (EntityManagerFactory) context.getBean("entityManagerFactory");
				
		
		EntityManager em = emf.createEntityManager();
				
		
		EntityTransaction tx = em.getTransaction();

		try {

			tx.begin();

			Adresse adrRaph = new Adresse();
			adrRaph.setAdresse("rue des palmiers");
			adrRaph.setCodePostal("45000");
			adrRaph.setPays("France");
			adrRaph.setVille("Orleans");
			
			Passager passager = new Passager();
			passager.setNom("DESTREZ");
			passager.setPrenom("Raphael");
			passager.setAdresse(adrRaph);
			em.persist(passager);
			
			
			Ville villeDep = new Ville();
			Ville villeArr = new Ville();
			Ville villeEscale = new Ville();
			villeDep.setNom("Paris");
			villeArr.setNom("Lima");
			villeEscale.setNom("Geneve");
			em.persist(villeDep);
			em.persist(villeArr);
			em.persist(villeEscale);

			Aeroport aeroportDep = new Aeroport();
			aeroportDep.setNom("Lima airport");
			em.persist(aeroportDep);
			
			
			Aeroport aeroportArr = new Aeroport();
			aeroportArr.setNom("Charles de Gaulle");
			em.persist(aeroportArr);
			
			Aeroport aeroportEscale = new Aeroport();
			aeroportEscale.setNom("Geneve airport");
			em.persist(aeroportEscale);
			
//			aeroportDep.getVilles().add(villeDep);
//			aeroportArr.getVilles().add(villeArr);
//			aeroportEscale.getVilles().add(villeEscale);
//			
//			VilleAeroport vaParis = new VilleAeroport();
//			VilleAeroport vaLima = new VilleAeroport();
//			VilleAeroport vaGeneve = new VilleAeroport();
//			vaParis.setAeroport(aeroportDep);
//			vaParis.setVille(villeDep);
//			vaLima.setAeroport(aeroportArr);
//			vaLima.setVille(villeArr);
//			vaGeneve.setAeroport(aeroportEscale);
//			vaGeneve.setVille(villeEscale);
//			
//			em.persist(vaParis);
//			em.persist(vaLima);
//			em.persist(vaGeneve);
			
			SimpleDateFormat dateformat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			
			Vol vol = new Vol();
			Calendar cal = GregorianCalendar.getInstance();
			cal.set(2014, Calendar.APRIL, 15,15,20);
			Date dateDepart = cal.getTime();
			
			Date heureDepart = cal.getTime();
			cal.set(2014, Calendar.APRIL, 25,16,35);
			Date dateArrivee = cal.getTime();
			Date heureArrivee = cal.getTime();
			
			
			
			vol.setDateDepart(dateDepart);
			vol.setDateArrivee(dateArrivee);
			vol.setHeureArrivee(heureArrivee);
			vol.setHeureDepart(heureDepart);
			vol.setDepart(aeroportDep);
			vol.setArrivee(aeroportArr);
			em.persist(vol);
			
			
			List<Escale> escales = new ArrayList<Escale>();
			Escale escale = new Escale();
			escale.setAeroport(aeroportEscale);
			escale.setVol(vol);
			escales.add(escale);
			em.persist(escale);
			
			CompagnieAerienne ca = new CompagnieAerienne();
			ca.setNom("AirFrance");
			em.persist(ca);
			
			CompagnieAerienneVol cav = new CompagnieAerienneVol();
			CompagnieAerienneVolId cavId = new CompagnieAerienneVolId();
			cavId.setCompagnieAerienne(ca);
			cavId.setVol(vol);
			cav.setId(cavId);
			cav.setNumero("654");
			em.persist(cav);
			
			

			Reservation res = new Reservation();
			res.setNumero(123);
			res.setPassager(passager);
			res.setVol(vol);
			em.persist(res);
			
			ClientPhysique cp = new ClientPhysique();
			
			Login logRaph = new Login();
			logRaph.setAdmin(false);
			logRaph.setLogin("raph");
			logRaph.setMotDePasse("rd");
			em.persist(logRaph);
			
			cp.setNom("DESTREZ");
			cp.setPrenom("Raphael");
			cp.setTitre(TitrePhysique.MR);
			cp.setEmail("rapahel.destrez@sopra.com");
			cp.setAdresse(adrRaph);
			em.persist(cp);

			
//			
//			Aeroport aeroport = em.find(Aeroport.class, 158L);
//			List<VilleAeroport> va = aeroport.getVilleAeroport();
//			System.out.println(va.get(0).getVille().getNom());
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
		}



	}

}
