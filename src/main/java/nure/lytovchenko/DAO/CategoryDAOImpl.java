package nure.lytovchenko.DAO;

import nure.lytovchenko.Models.Category;
import nure.lytovchenko.Models.Item;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CategoryDAOImpl implements CategoryDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Category getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Category category = session.get(Category.class,id);
        return category;
    }

    public List<Category> getAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Category ").list();
    }

    @Override
    public void add(Category category) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(category);
    }

    @Override
    public void update(Category category) {

    }
}
