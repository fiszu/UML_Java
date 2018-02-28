package helpers;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

@SuppressWarnings("deprecation")
public class HibernateHelper {
    private static final SessionFactory sessionFactory;
    private static ServiceRegistry serviceRegistry;
 
    static {
        try {
            // Utwórz SessionFactory z pliku hibernate.cfg.xml
        	//Configuration configuration = new Configuration();
            //configuration.configure("hibernate.cfg.xml");

            
            sessionFactory = new Configuration().configure().buildSessionFactory();
            
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
 
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
