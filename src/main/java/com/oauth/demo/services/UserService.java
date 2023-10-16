package com.oauth.demo.services;

import com.oauth.demo.entities.User;
import com.oauth.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User addUser(String firstname,String lastname){
       return  this.userRepository.save(new User(firstname,lastname));
    }

    public void deleteUser(Long id){
        this.userRepository.deleteById(id);
    }

    public List<User> getAllUsers(){
        return this.userRepository.findAll();
    }
}
