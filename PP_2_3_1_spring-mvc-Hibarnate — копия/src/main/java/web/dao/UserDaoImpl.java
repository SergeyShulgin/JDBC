package web.dao;

import web.model.User;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    public List<User> getAllUsers() {
        return entityManager.createQuery("select u from User u",User.class).getResultList();
    }

    public Object getUserById(long id) {
        return entityManager.find(User.class,id);
    }

    public void addUser(User user) {
        entityManager.persist(user);
    }

    public void removeUser(long id) {
        entityManager.remove(getUserById(id));
    }

    public void updateUser(User user) {
        entityManager.refresh(user);
    }
}
