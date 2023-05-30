package com.jalian.hw9.projectUtil;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
public class ProjectUtil {
    private static final String PERSISTENCE_UNIT_NAME = "PERSISTENCE";
    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);;
    public static EntityManager getEntityManager() {
        return factory.createEntityManager();
    }
    public static void shutdown() {
        if (factory != null) {
            factory.close();
        }
    }
}
