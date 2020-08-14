package nure.lytovchenko.DAO;

import nure.lytovchenko.Models.Item;
import nure.lytovchenko.Models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class UserDAOImpl implements UserDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    public User findByUsername(String username) {
        Session session = sessionFactory.getCurrentSession();
        User user = (User) session.createQuery("from User where username=:username").setParameter("username",username).list().get(0);
        return user;
    }


    @Override
    public void save(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.save(user);
    }

    @Override
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        User user = session.get(User.class,id);
        session.delete(user);
    }

    @Override
    public void update(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.update(user);
    }


    public List<User> listUsers() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from User").list();
    }


    public void delete(String username) {
        Session session = sessionFactory.getCurrentSession();
        User user = session.get(User.class,username);
        session.delete(user);
    }
}
