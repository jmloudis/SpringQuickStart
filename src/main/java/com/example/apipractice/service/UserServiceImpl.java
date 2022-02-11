package com.example.apipractice.service;

import com.example.apipractice.model.User;
import com.example.apipractice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

//    @Override
    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }
}
