package vol;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

	public class EntityManagerFactorySingleton {

		private static EntityManagerFactorySingleton instance = null;
		private final EntityManagerFactory entitymanagerfactory;
		
		private EntityManagerFactorySingleton(){
			super();
			this.entitymanagerfactory = Persistence.createEntityManagerFactory("tpVol");
		}
		
		public static EntityManagerFactorySingleton getInstance(){
			if(instance == null){
				instance = new EntityManagerFactorySingleton();
			}
			return instance;
		}

		public EntityManagerFactory getEntitymanagerfactory() {
			return entitymanagerfactory;
		}
		
		public static void close(){
			if(instance != null){
				instance.terminate();
				instance = null;
			}
		}
		
		
		public void terminate(){
			entitymanagerfactory.close();
		}
		
		
	}

