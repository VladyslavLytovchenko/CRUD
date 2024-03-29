package nure.lytovchenko.DAO;

import nure.lytovchenko.Models.Role;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class RoleDAOImpl implements RoleDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    public Role getRole(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Role.class,id);
    }

    @Override
    public Role getRole(String role) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Role.class,role);
    }

    @Override
    public List<Role> listRoles() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Role").list();
    }
}
