package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.UserDao;
import web.model.User;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private final UserDao userDao;
    @Autowired
    public UserServiceImpl(UserDao userDao){
        this.userDao=userDao;
    }
    @Override
    public List<User> getAllUsers() {
        return UserDao.getAllUsers();
    }
    @Override
    public Object getUserById(long id) {
        return UserDao.getUserById(id);
    }
    @Override
    public void addUser(User user) {
        return UserDao.addUser(user);
    }
    @Override
    public void removeUser(long id) {
        return UserDao.removeUser(id);
    }
    @Override
    public void updateUser(User user) {
         return UserDao.updateUser(user);
    }

}
