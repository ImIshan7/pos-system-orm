package repository;

import entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.SessionFactoryConfiguration;

public class CustomerRepository {

    private final Session session;

    public CustomerRepository(){
        session = SessionFactoryConfiguration.getInstance().getSession();
    }

    // Transaction Handling part
    public Long saveCustomer(Customer customer){
        Transaction transaction = session.beginTransaction();

        try {
            Long id = (Long) session.save(customer);
            transaction.commit();
            session.close();
            return id;

        } catch (Exception ex) {
            transaction.rollback();
            session.close();
            System.out.println(ex);
            ex.printStackTrace();
            return -1L;
        }

    }

    public boolean updateCustomer(Customer customer){
        Transaction transaction = session.beginTransaction();
        try {
            session.update(customer);
            transaction.commit();
            session.close();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println(ex);
            session.close();
            return false;
        }
    }

    public Customer getCustomer(long id ){
        try {
            return session.get(Customer.class, id);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
    }

    public boolean deleteCustomer(Customer customer){
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(customer);
            transaction.commit();
            return true;
        } catch (Exception ex) {
            transaction.rollback();
            ex.printStackTrace();
            return false;
        }
    }
}

