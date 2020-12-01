package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * 
 * @author Cleiton
  *
 */

public class JpaUtil {

	private static EntityManagerFactory factory;

    static {
        factory = Persistence.createEntityManagerFactory("HOMECARE");
    }

    public static EntityManager getEntityManager() {
        return factory.createEntityManager();
    }

    public static void close() {
        factory.close();
    }
}
