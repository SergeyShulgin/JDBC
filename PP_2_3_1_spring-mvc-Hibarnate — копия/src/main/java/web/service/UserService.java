package web.service;

import org.springframework.stereotype.Service;
import web.model.User;

import java.util.List;

@Service
public interface UserService {

    List<User> getAllUsers();

    Object getUserById(long id);

    void addUser(User user);

    void removeUser(long id);

    void updateUser(User user);

}
