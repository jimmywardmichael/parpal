package com.codeup.parpal.services;

import com.codeup.parpal.models.Event;
import com.codeup.parpal.models.User;
import com.codeup.parpal.repositories.UserRepository;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDaoService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public UserDaoService(UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }
    //CREATE USER
    public void registerUser(User user) {
        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        userRepository.save(user);
    }
    //READ USER
    public User getUserById(long id) {
        if (userRepository.findById(id).isPresent()) {
            return userRepository.findById(id).get();
        } else{
            throw new RuntimeException("User was not found.");
        }
    }


    //DELETE USER
    public void deleteUserById(long id){
        userRepository.deleteById(id);
    }

    //EDIT USER
    public void saveUser(User user) {
        userRepository.save(user);
    }

    public List<User> findAllUsers(){
        return userRepository.findAll();
    }

}