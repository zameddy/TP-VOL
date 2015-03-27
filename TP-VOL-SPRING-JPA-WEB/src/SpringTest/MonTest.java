package SpringTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import vol.metier.dao.AeroportDao;
import vol.metier.dao.LoginDao;
import vol.metier.dao.PassagerDao;
import vol.metier.dao.VilleAeroportDao;
import vol.metier.dao.VilleDao;
import vol.metier.model.Aeroport;
import vol.metier.model.Login;
import vol.metier.model.Ville;
import vol.metier.model.VilleAeroport;

@ContextConfiguration(locations="classpath:testApplicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
  
@Transactional
@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=false)
public class MonTest {
	
	@Autowired
	private LoginDao loginDao;
	
	@Autowired
	private PassagerDao passagerDao;
	
	@Autowired
	private AeroportDao aeroportDao;
	
	@Autowired
	private VilleDao villeDao;
	
	@Autowired
	private VilleAeroportDao villeAeroportDao;
	
	@Test
	public void apopulate() {
		Login monLogin = new Login();
		monLogin.setLogin("Eric");
		monLogin.setMotDePasse("123");

		loginDao.create(monLogin);
		
		
		Aeroport cdg = new Aeroport();
		cdg.setNom("CDG");
		
		aeroportDao.create(cdg);
		
		Ville paris = new Ville();
		paris.setNom("PARIS");
		
		villeDao.create(paris);
		
		VilleAeroport parisCdg = new VilleAeroport(paris, cdg);
		
		//villeAeroportDao.create(parisCdg);
	}
	
	/*@Test
	public void bcheck() {
		Login login = loginDao.find("rd");
		
		assertEquals("rd", login.getLogin());
		assertEquals("rd", login.getMotDePasse());
		assertEquals(false, login.isAdmin());
		
		
	}*/
	
}
