package com.andreyb34rus.JM_Task_3_1_3.service;

import com.andreyb34rus.JM_Task_3_1_3.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getAllUsers();
    Optional<User> getUserById(Long id);
    void saveUser(User user);
    void updateUser(User user);
    void deleteUser(Long id);
    User findByUsername(String username);
}
