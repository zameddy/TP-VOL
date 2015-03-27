package tests;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import vol.metier.dao.LoginDao;
import vol.metier.model.Login;

public class MainSpring {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");

		LoginDao loginDao = (LoginDao) context.getBean("loginDao");

		Login monLogin = new Login();
		monLogin.setLogin("xysddssdsssdz");
		monLogin.setMotDePasse("123");

		loginDao.create(monLogin);

	}

}
