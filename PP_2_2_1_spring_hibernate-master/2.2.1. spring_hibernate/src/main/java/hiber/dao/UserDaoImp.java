package hiber.dao;

import hiber.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        return sessionFactory.getCurrentSession().createQuery("from User").getResultList();
    }

    public User getUserByCarModelAndSeries(String model, int series) {
        return  sessionFactory.getCurrentSession()
                .createQuery("FROM User u JOIN u.car c WHERE c.model = " + ":model AND c.series = :series", User.class)
                .setParameter("model", model)
                .setParameter("series", series)
                .getResultList();
    }
}
