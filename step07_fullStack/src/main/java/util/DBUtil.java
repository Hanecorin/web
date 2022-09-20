package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DBUtil {

	private static EntityManagerFactory emf = null;
	
	static {
		emf = Persistence.createEntityManagerFactory("dbinfo");
	}
	
	//EntityManager or EntityManagerFactory
	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
	
	public static void close() {
		emf.close();
	}
	
}
