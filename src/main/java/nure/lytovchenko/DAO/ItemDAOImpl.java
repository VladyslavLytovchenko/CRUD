package nure.lytovchenko.DAO;


import nure.lytovchenko.Models.Item;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;


@Repository
@Transactional
public class ItemDAOImpl implements ItemDAO {


    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Item getItemBy(int id) {
        Session session = sessionFactory.getCurrentSession();
        Item item = session.get(Item.class,id);
        return item;
    }

    public void add(Item item){
        Session session = sessionFactory.getCurrentSession();
        session.persist(item);
    }

    @Override
    public List<Item> getAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Item").list();
    }

    @Override
    public List<Item> getItemsByCategory(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Item where category.id=:id").setParameter("id",id).list();
    }

    @Override
    public void update(Item item) {
        Session session = sessionFactory.getCurrentSession();
        session.update(item);
    }

    @Override
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        Item item = session.get(Item.class,id);
        session.delete(item);
    }


}
