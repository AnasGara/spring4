package com.oauth.demo.controllers;

import com.oauth.demo.entities.User;
import com.oauth.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping(value="/all")
    public List<User> getAllUsers() {
        return this.userService.getAllUsers();
    }

    @PostMapping(value="/add")
    public User addUser(@RequestBody User user) {
        return this.userService.addUser(user.getFirstName(),user.getLastName());
    }

    @DeleteMapping(value="/delete/{id}")
    public boolean deleteUser(@PathVariable Long id) {
        this.userService.deleteUser(id);
        return true;
    }
}
