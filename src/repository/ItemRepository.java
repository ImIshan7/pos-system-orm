package repository;

import entity.Item;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.SessionFactoryConfiguration;

import java.util.ArrayList;

public class ItemRepository {

    private final Session session;

    public ItemRepository() {
        session = SessionFactoryConfiguration.getInstance().getSession();

    }

    public ArrayList allItems() {
        Transaction transaction = session.beginTransaction();
        try {
            ArrayList arrayList = (ArrayList) session.createQuery("from AppInitializer").list();
            transaction.commit();
            return arrayList;
        } catch (Exception ex) {
            transaction.rollback();
            System.out.println(ex);
            ex.printStackTrace();
            return null;
        }

    }
    public boolean deleteItem(int id){
        Transaction transaction = session.beginTransaction();
        try {
            Item item=session.load(Item.class,id);

            session.delete(item);
            transaction.commit();
            return true;
        } catch (Exception ex) {
            transaction.rollback();
            ex.printStackTrace();
            return false;
        }
    }

    public boolean updateItem(Item item){
        Transaction transaction = session.beginTransaction();
        try {
            session.update(item);
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
    public boolean existItem(int id){
        Transaction transaction = session.beginTransaction();
        try {
            session.get(Item.class,id);
            transaction.commit();
            return true;
        } catch (Exception ex) {
            transaction.rollback();
            ex.printStackTrace();
            return false;
        }
    }
}
