package util;


import entity.Customer;
import entity.Item;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class SessionFactoryConfiguration {

    private static SessionFactoryConfiguration factoryConfiguration;
    private SessionFactory sessionFactory;

    private SessionFactoryConfiguration(){

        sessionFactory = new Configuration().configure().addAnnotatedClass(Customer.class)
                .addAnnotatedClass(Item.class).buildSessionFactory();
    }

    public static SessionFactoryConfiguration getInstance() {
        return (null == factoryConfiguration) ?
                factoryConfiguration = new SessionFactoryConfiguration() : factoryConfiguration;
    }

    public Session getSession() throws HibernateException {

        Session session = sessionFactory.openSession();

        return session;
    }
}

