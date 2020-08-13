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

    @Override
    public User getUserByUsername(String username) {
        Session session = sessionFactory.getCurrentSession();
        User user = session.get(User.class,username);
        return user;
    }

    @Override
    public void saveOrUpdateUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(user);
    }


    @Override
    public List<User> listUsers() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from User").list();
    }

    @Override
    public void delete(String username) {
        Session session = sessionFactory.getCurrentSession();
        User user = session.get(User.class,username);
        session.delete(user);
    }
}
