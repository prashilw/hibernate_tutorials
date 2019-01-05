package com.prashil;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import com.prashil.bo.User;
/**
 * Hello world!
 */
public class App {
     /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        Configuration configuration = new Configuration().configure();
        ServiceRegistryBuilder registry = new ServiceRegistryBuilder();
        registry.applySettings(configuration.getProperties());
        ServiceRegistry serviceRegistry = registry.buildServiceRegistry();
        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        Session session = null;
        try{
		session = sessionFactory.openSession();
		 session.beginTransaction();
        User newUser = new User();
        newUser.setFirstName("Prashil");
        newUser.setLastName("Wasnik");
        newUser.setAge(12);
		// AppUser user = new AppUser("firstuser");
		 session.save(newUser);
		 session.getTransaction().commit();
        session.close();
        }catch(Exception e){
            e.printStackTrace();
           
        }finally{
            if(session != null && session.isOpen()){
                session.close(); 
           }
        }
    }
}
