package vol;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import volClasses.Adresse;
import volClasses.Aeroport;
import volClasses.ClientEI;
import volClasses.ClientMoral;
import volClasses.ClientPhysique;
import volClasses.CompagnieAerienne;
import volClasses.CompagnieAerienneVol;
import volClasses.Escale;
import volClasses.Login;
import volClasses.Passager;
import volClasses.Reservation;
import volClasses.TitreClient;
import volClasses.Ville;
import volClasses.Vol;
import volClasses.dao.AeroportDao;
import volClasses.dao.AeroportDaoImpl;
import volClasses.dao.ClientDao;
import volClasses.dao.ClientDaoImpl;
import volClasses.dao.CompagnieAerienneDao;
import volClasses.dao.CompagnieAerienneDaoImpl;
import volClasses.dao.CompagnieAerienneVolDao;
import volClasses.dao.CompagnieAerienneVolDaoImpl;
import volClasses.dao.EscaleDao;
import volClasses.dao.EscaleDaoImpl;
import volClasses.dao.LoginDao;
import volClasses.dao.LoginDaoImpl;
import volClasses.dao.PassagerDao;
import volClasses.dao.PassagerDaoImpl;
import volClasses.dao.ReservationDao;
import volClasses.dao.ReservationDaoImpl;
import volClasses.dao.VilleDao;
import volClasses.dao.VilleDaoImpl;
import volClasses.dao.VolDao;
import volClasses.dao.VolDaoImpl;



public class Main {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		
		
		
		PassagerDao passagerdao=new PassagerDaoImpl();
		LoginDao logindao=new LoginDaoImpl();
		ClientDao clientdao=new ClientDaoImpl();
		ReservationDao reservationdao=new ReservationDaoImpl();
		CompagnieAerienneDao cadao=new CompagnieAerienneDaoImpl();
		CompagnieAerienneVolDao cavdao=new CompagnieAerienneVolDaoImpl();
		VolDao voldao=new VolDaoImpl();
		AeroportDao aeroportdao=new AeroportDaoImpl();
		EscaleDao escaledao=new EscaleDaoImpl();
		VilleDao villedao=new VilleDaoImpl();

		SimpleDateFormat date =new SimpleDateFormat("dd/MM/yyyy HH:mm:ss") ;

		
		// Init adresses
		
		Adresse ad1 = new Adresse();
		Adresse ad2 = new Adresse();
		
		ad1.setAdresse("18 Boulevard Riquet");
		ad1.setCodePostal("31000");
		ad1.setVille("Toulouse");
		ad1.setPays("FRANCE");
			
		ad2.setAdresse("26 Place du Chameau");
		ad2.setCodePostal("32290");
		ad2.setVille("Tombouctou");
		ad2.setPays("MALI");
		
		// Init Passager
		
		Passager pass1 = new Passager();
		Passager pass2 = new Passager();
		Passager pass3 = new Passager();
		Passager pass4 = new Passager();
		Passager pass5 = new Passager();
		Passager pass6 = new Passager();
		Passager pass7 = new Passager();
		Passager pass8 = new Passager();
		Passager pass9 = new Passager();
		Passager pass10 = new Passager();
		Passager pass11 = new Passager();
		Passager pass12 = new Passager();
		Passager pass13 = new Passager();
		Passager pass14 = new Passager();
		Passager pass15 = new Passager();
		
		
		pass1.setNom("LATEIGNE");
		pass1.setPrenom("Rene");
		
		pass2.setNom("BONNAUD");
		pass2.setPrenom("Jean");
		
		pass3.setNom("MAROLEX");
		pass3.setPrenom("Eleonore");
		
		pass4.setNom("LALALALA");
		pass4.setPrenom("Starsky");
		
		pass5.setNom("LALALALA");
		pass5.setPrenom("Hutch");
		
		pass6.setNom("VITMONSLIP");
		pass6.setPrenom("Jean-Philippe");
		
		pass7.setNom("FLAYE");
		pass7.setPrenom("Abdel");
		
		pass8.setNom("FLAYE");
		pass8.setPrenom("Yves");
		
		pass9.setNom("FLAYE");
		pass9.setPrenom("Ikam");
		
		pass10.setNom("AUCHON");
		pass10.setPrenom("Paul");
		
		pass11.setNom("HATOIS");
		pass11.setPrenom("Edgar");
		
		pass12.setNom("MURRAY");
		pass12.setPrenom("BILL");
		
		pass13.setNom("CASSEL");
		pass13.setPrenom("Vincent");
		
		pass14.setNom("LATAUPE");
		pass14.setPrenom("Rene");
		
		pass15.setNom("DION");
		pass15.setPrenom("Celine");
		
		
		// Init login
		
		Login log1 = new Login();
		Login log2 = new Login();
		Login log3 = new Login();
		Login log4 = new Login();
		Login log5 = new Login();
		Login log6 = new Login();
		
		log1.setLogin("scott");
		log1.setMotDePasse("tiger");
		log1.setAdmin(false);
		
		log2.setLogin("admin");
		log2.setMotDePasse("bigboss");
		log2.setAdmin(true);
		
		
		log3.setLogin("toto");
		log3.setMotDePasse("tutu");
		log3.setAdmin(true);
		
		
		log4.setLogin("jacky");
		log4.setMotDePasse("azerty");
		log4.setAdmin(true);
		
		
		log5.setLogin("admin");
		log5.setMotDePasse("bigboss");
		log5.setAdmin(true);
		
		
		log6.setLogin("admin");
		log6.setMotDePasse("bigboss");
		log6.setAdmin(true);
		
		
		 
		
		
		
		//Init Client
		ClientPhysique cli1 = new ClientPhysique();
		ClientPhysique cli2 = new ClientPhysique();
		ClientPhysique cli3 = new ClientPhysique();
		ClientPhysique cli4 = new ClientPhysique();
		ClientPhysique cli5 = new ClientPhysique();
		ClientPhysique cli6 = new ClientPhysique();
		ClientMoral cli7 = new ClientMoral();
		ClientEI cli8 = new ClientEI();
		ClientEI cli9 = new ClientEI();
		ClientEI cli10 = new ClientEI();
		
		
		cli1.setNom("FRAISSE");
		cli1.setPrenom("Tristan");
		cli1.setNumeroTel("0648958779");
		cli1.setNumeroFax("0148956875");
		cli1.setEmail("tristan.fraisse@gmail.com");
		cli1.setTitre(TitreClient.M);
				
		cli2.setNom("AFTERKHARI");
		cli2.setPrenom("Anahita");
		cli2.setNumeroTel("0621242898");
		cli2.setNumeroFax("");
		cli2.setEmail("anahita.afterkhari@hotmail.com");
		cli2.setTitre(TitreClient.MLLE);
				
		cli3.setNom("LEBOURGEOIS");
		cli3.setPrenom("Nicolas");
		cli3.setNumeroTel("0688888888");
		cli3.setNumeroFax("0144444444");
		cli3.setEmail("nicolas.lebourgeois@yahoo.com");
		cli3.setTitre(TitreClient.M);
				
		cli4.setNom("TUDURI");
		cli4.setPrenom("Adrien");
		cli4.setNumeroTel("0612345879");
		cli4.setNumeroFax("");
		cli4.setEmail("adrien.tuduri@msn.com");
		cli4.setTitre(TitreClient.M);
				
		cli5.setNom("RINFRAY");
		cli5.setPrenom("Corentin");
		cli5.setNumeroTel("0622334455");
		cli5.setNumeroFax("0177889966");
		cli5.setEmail("corentin.rinfray@soprasteria.com");
		cli5.setTitre(TitreClient.M);
				
		cli6.setNom("PUJOL");
		cli6.setPrenom("Jean-Philippe");
		cli6.setNumeroTel("0664848311");
		cli6.setNumeroFax("");
		cli6.setEmail("jeanphilippe.pujol@topito.com");
		cli6.setTitre(TitreClient.M);
				
		cli7.setNom("AJC");
		cli7.setNumeroTel("143454648");
		cli7.setNumeroFax("0148464543");
		cli7.setEmail("ajc.rougemont@formation.com");
		cli7.setSiret("5454er84449zze");
				
		cli8.setNom("LAVAL");
		cli8.setPrenom("Audrey");
		cli8.setNumeroTel("0658478759");
		cli8.setNumeroFax("");
		cli8.setEmail("audrey.laval@toto.com");
		cli8.setTitre(TitreClient.MME);
				
		cli9.setNom("TORCHAIRE");
		cli9.setPrenom("Nicolas");
		cli9.setNumeroTel("0689898989");
		cli9.setNumeroFax("0189898989");
		cli9.setEmail("nicolas.torchaire@bx.com");
		cli9.setTitre(TitreClient.M);
				
		cli10.setNom("SULTAN");
		cli10.setPrenom("Eric");
		cli10.setNumeroTel("0668686868");
		cli10.setNumeroFax("");
		cli10.setEmail("eric.sultan@gmail.com");
		cli10.setTitre(TitreClient.M);
				
		
		
		//Init Reservation
		Reservation res1 = new Reservation();
		Reservation res2 = new Reservation();
		Reservation res3 = new Reservation();
		Reservation res4 = new Reservation();
		Reservation res5 = new Reservation();
		Reservation res6 = new Reservation();
		Reservation res7 = new Reservation();
		Reservation res8 = new Reservation();
		Reservation res9 = new Reservation();
		Reservation res10 = new Reservation();
		
		res1.setDate(date.parse("03/01/2015 12:05:26"));
		res1.setNumero(238);
		res2.setDate(date.parse("14/12/2014 15:05:26"));
		res2.setNumero(239);
		res3.setDate(date.parse("10/12/2014 18:05:26"));
		res3.setNumero(240);
		res4.setDate(date.parse("03/01/2015 10:05:26"));
		res4.setNumero(241);
		res5.setDate(date.parse("26/09/2014 16:05:26"));
		res5.setNumero(242);
		res6.setDate(date.parse("13/11/2014 02:05:26"));
		res6.setNumero(243);
		res7.setDate(date.parse("18/11/2014 04:05:26"));
		res7.setNumero(244);
		res8.setDate(date.parse("16/01/2015 23:05:26"));
		res8.setNumero(245);
		res9.setDate(date.parse("03/10/2014 21:05:26"));
		res9.setNumero(246);
		res10.setDate(date.parse("26/01/2014 13:05:26"));
		res10.setNumero(247);
		
		
		//Init CompagnieAerienne
		CompagnieAerienne ca1 = new CompagnieAerienne();
		CompagnieAerienne ca2 = new CompagnieAerienne();
		CompagnieAerienne ca3 = new CompagnieAerienne();
		CompagnieAerienne ca4 = new CompagnieAerienne();
		
		ca1.setNom("Air France");
		ca2.setNom("Emirates");
		ca3.setNom("Lufthansa");
		ca4.setNom("Daesh Airlines");
		
		
		//Init CompagnieAerienneVol
		CompagnieAerienneVol cav1 = new CompagnieAerienneVol();
		CompagnieAerienneVol cav2 = new CompagnieAerienneVol();
		CompagnieAerienneVol cav3 = new CompagnieAerienneVol();
		CompagnieAerienneVol cav4 = new CompagnieAerienneVol();
		CompagnieAerienneVol cav5 = new CompagnieAerienneVol();
		CompagnieAerienneVol cav6 = new CompagnieAerienneVol();
		CompagnieAerienneVol cav7 = new CompagnieAerienneVol();
		CompagnieAerienneVol cav8 = new CompagnieAerienneVol();
		CompagnieAerienneVol cav9 = new CompagnieAerienneVol();
		CompagnieAerienneVol cav10 = new CompagnieAerienneVol();
		CompagnieAerienneVol cav11 = new CompagnieAerienneVol();
		CompagnieAerienneVol cav12 = new CompagnieAerienneVol();
		
		cav1.setNumero("78GT85");
		cav2.setNumero("458G78");
		cav3.setNumero("123AV4");
		cav4.setNumero("AF7979");
		cav5.setNumero("O9999O");
		cav6.setNumero("B3F4R3");
		cav7.setNumero("4FT3RS");
		cav8.setNumero("8OOO8S");
		cav9.setNumero("5OL3IL");
		cav10.setNumero("123456");
		cav12.setNumero("987YH6");
		cav12.setNumero("EM3456");
		
		
		
		//Init vol
		
		Vol vol1 = new Vol();
		Vol vol2 = new Vol();
		Vol vol3 = new Vol();
		Vol vol4 = new Vol();
		Vol vol5 = new Vol();
		Vol vol6 = new Vol();
		Vol vol7 = new Vol();
		Vol vol8 = new Vol();
		Vol vol9 = new Vol();
		
		vol1.setHeureArrivee(date.parse("08/02/2015 12:05:26"));
		vol1.setHeureDepart(date.parse("08/02/2015 18:05:26"));
		
		vol2.setHeureArrivee(date.parse("10/02/2015 10:35:26"));
		vol2.setHeureDepart(date.parse("10/02/2015 19:05:26"));
		
		vol3.setHeureArrivee(date.parse("08/03/2015 23:25:26"));
		vol3.setHeureDepart(date.parse("09/03/2015 08:05:26"));
		
		vol4.setHeureArrivee(date.parse("25/02/2015 23:05:26"));
		vol4.setHeureDepart(date.parse("26/02/2015 02:38:26"));
		
		vol5.setHeureArrivee(date.parse("22/01/2015 16:56:26"));
		vol5.setHeureDepart(date.parse("22/01/2015 17:35:26"));
		
		vol6.setHeureArrivee(date.parse("18/02/2015 12:56:26"));
		vol6.setHeureDepart(date.parse("18/02/2015 18:05:26"));
		
		vol7.setHeureArrivee(date.parse("07/02/2015 12:56:26"));
		vol7.setHeureDepart(date.parse("08/02/2015 01:05:26"));
		
		vol8.setHeureArrivee(date.parse("26/04/2015 08:56:26"));
		vol8.setHeureDepart(date.parse("26/04/2015 10:05:26"));
		
		vol9.setHeureArrivee(date.parse("11/09/2015 12:56:26"));
		vol9.setHeureDepart(date.parse("11/09/2015 18:05:26"));
		
		//Init Aeroport
		
		Aeroport aero1 = new Aeroport();
		Aeroport aero2 = new Aeroport();
		Aeroport aero3 = new Aeroport();
		Aeroport aero4 = new Aeroport();
				
		aero1.setNom("Roissy");
		aero2.setNom("DubaiAirport");
		aero3.setNom("JFK");
		aero4.setNom("KangourouAirport");		
		
		
		
		//Init Escale
		
		Escale esc1 = new Escale();
		Escale esc2 = new Escale();
		Escale esc3 = new Escale();
		Escale esc4 = new Escale();
		Escale esc5 = new Escale();
		Escale esc6 = new Escale();
		
		esc1.setHeureArrivee(date.parse("08/02/2015 16:05:26"));
		esc1.setHeureDepart(date.parse("08/02/2015 17:05:26"));
//		
//		esc2.setHeureArrivee("10/02/2015 10:55:26");
//		esc2.setHeureDepart("10/02/2015 11:05:26");
//		
//		esc3.setHeureArrivee("08/03/2015 07:05:26");
//		esc3.setHeureDepart("08/03/2015 08:05:26");
//		
//		esc4.setHeureArrivee("25/02/2015 23:05:26");
//		esc4.setHeureDepart("25/02/2015 23:35:26");
//		
//		esc5.setHeureArrivee("14/02/2015 22:56:26");
//		esc5.setHeureDepart("14/02/2015 23:05:26");
//		
//		esc6.setHeureArrivee("14/02/2015 12:56:26");
//		esc6.setHeureDepart("14/02/2015 13:05:26");


		
		//Init villes
		
		Ville vil1 = new Ville();
		Ville vil2 = new Ville();
		Ville vil3 = new Ville();
		Ville vil4 = new Ville();
		Ville vil5 = new Ville();
		
		vil1.setNom("PARIS");
		vil2.setNom("DUBAI");
		vil3.setNom("NYC");
		vil4.setNom("SIDNEY");
		vil5.setNom("SANTENY");
		
		
//		Test client login
//		
//		clientdao.create(cli1);
//		clientdao.create(cli2);
//		clientdao.create(cli3);
//		clientdao.create(cli7);
//		clientdao.create(cli9);
//		logindao.create(log1);
//		cli1.setLogin(log1);
		
		
		
//		reservationdao.create(res1);
//		res1.setClient(cli1);
//		reservationdao.update(res1);
//		cli1.setAdresse(ad1);
//		
//		List<Reservation> listeresa1 = new ArrayList<Reservation>();
//		listeresa1.add(res1);
		//cli1.setReservations(listeresa1);
		
//		clientdao.update(cli1);
//		
//		cli3.setLogin(log2);
		
//		List<Reservation> listeresa2 = new ArrayList<Reservation>();
//		listeresa2.add(res3);
//		listeresa2.add(res6);
//		cli3.setReservations(listeresa2);
//		logindao.create(log2);
//		clientdao.update(cli3);
//		
//		System.out.println(clientdao.findByLogin(log2).getNom());
		
		
		
		
//		Test du mapping aeroport_ville 
		
		aeroportdao.create(aero1);
		aeroportdao.create(aero2);
		aeroportdao.create(aero3);
//		aeroportdao.create(aero4);
//		villedao.create(vil1);
//		villedao.create(vil2);
//		villedao.create(vil3);
//		villedao.create(vil4);
//		villedao.create(vil5);
//		
//		Set<Aeroport> liste = new HashSet<Aeroport>();
//		Set<Aeroport> liste2 = new HashSet<Aeroport>();
//		Set<Aeroport> liste3 = new HashSet<Aeroport>();
//		Set<Aeroport> liste4 = new HashSet<Aeroport>();
//		liste.add(aero1);
//		liste.add(aero2);
//		liste2.add(aero1);
//		liste2.add(aero3);
//		liste3.add(aero2);
//		liste3.add(aero4);
//		liste3.add(aero3);
//		liste4.add(aero1);
//		liste4.add(aero2);
//		liste4.add(aero3);
//		liste4.add(aero4);
//		vil1.setAeroports(liste);
//		vil2.setAeroports(liste2);
//		vil3.setAeroports(liste3);
//		vil4.setAeroports(liste4);
//		vil5.setAeroports(liste);
//		
//		villedao.update(vil1);
//		villedao.update(vil2);
//		villedao.update(vil3);
//		villedao.update(vil4);
//		villedao.update(vil5);
		
		
//		Test du mapping adresse client
		
		clientdao.create(cli1);
		clientdao.create(cli2);
		clientdao.create(cli3);
		clientdao.create(cli7);
		clientdao.create(cli9);
//		cli1.setAdresse(ad2);
//		cli2.setAdresse(ad1);
//		cli3.setAdresse(ad2);
//		cli7.setAdresse(ad2);
//		cli9.setAdresse(ad1);
//		
//		clientdao.update(cli1);
//		clientdao.update(cli2);
//		clientdao.update(cli3);
//		clientdao.update(cli7);
//		clientdao.update(cli9);
		
		
//		Test du mapping adresse-passager
		
		passagerdao.create(pass1);
		passagerdao.create(pass2);
		pass1.setAdresse(ad2);
		pass2.setAdresse(ad1);
		passagerdao.update(pass1);
		passagerdao.update(pass2);
		
		
//		Test du mapping reservation-client
		
		reservationdao.create(res1);
		reservationdao.create(res2);
		reservationdao.create(res3);
		reservationdao.create(res4);
		
		res1.setClient(cli1);
		res2.setClient(cli3);
		res3.setClient(cli1);
		res4.setClient(cli7);;
//		
//		reservationdao.update(res1);
//		reservationdao.update(res2);
//		reservationdao.update(res3);
//		reservationdao.update(res4);
		
		
//		Test du mapping reservation-passager
		
		res1.setPassager(pass1);
		res2.setPassager(pass1);
		res3.setPassager(pass2);
		res4.setPassager(pass1);
		
//		reservationdao.update(res1);
//		reservationdao.update(res2);
//		reservationdao.update(res3);
//		reservationdao.update(res4);
		
		
//		Test du mapping reservation_vol
		
		voldao.create(vol1);
		voldao.create(vol2);
		voldao.create(vol3);
		
//		res1.setVol(vol1);
//		res2.setVol(vol2);
//		res3.setVol(vol1);
//		res4.setVol(vol3);
//		
//		
//		reservationdao.update(res1);
//		reservationdao.update(res2);
//		reservationdao.update(res3);
//		reservationdao.update(res4);
		
//		cadao.create(ca1);
//		cadao.create(ca2);
//		CompagnieAerienneVol cav13 = new CompagnieAerienneVol(ca1,vol1);
//		cav13.setNumero("WOLOLOOOO");
//		cavdao.create(cav13);
//		
//		CompagnieAerienneVol cav14 = new CompagnieAerienneVol(ca2,vol2);
//		cav14.setNumero("HAAAAAAAAAAAAAAAAAA");
//		cavdao.create(cav14);
		
//		ca1.setCompagniesAeriennesVols(cav1);
//		vol1.setCompagniesAeriennesVols(cav1);
//		aero1 = aeroportdao.find(154l);
//		vol1 = voldao.find(83l);
		esc1.setAeroport(aero1);
		esc1.setVol(vol1);
		escaledao.update(esc1);
		
		
		
		EntityManagerFactorySingleton.close();
		
		
		
		
	}

}
