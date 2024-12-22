package com.example.demo.service;


import com.example.demo.model.User;
import com.example.demo.repository.UserJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserJpaRepository userJpaRepository;

    @Autowired
    public UserServiceImpl(UserJpaRepository userJpaRepository) {
        this.userJpaRepository = userJpaRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userJpaRepository.findAll();
    }

    @Override
    public User getUserById(long id) {
        Optional<User> optionalUser = userJpaRepository.findById(id);
        return optionalUser.orElse(null);
    }

    @Override
    public void addUser(User user) {
        userJpaRepository.save(user);
    }

    @Override
    public void removeUser(long id) {
        userJpaRepository.deleteById(id);
    }

    @Override
    public void updateUser(User user) {
        userJpaRepository.save(user);
}
}