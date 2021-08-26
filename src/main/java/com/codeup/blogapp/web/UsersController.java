package com.codeup.blogapp.web;


import com.codeup.blogapp.data.UserRepository;
import com.codeup.blogapp.security.data.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/users", headers = "Accept=application/json")
public class UsersController {

    private UserRepository userRepository;

    public UsersController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @GetMapping
    private List<User> getUsers() {
        return userRepository.findAll();
    }

    @PostMapping
    private void createUser(@RequestBody User myUser) {
    userRepository.save(myUser);

    }

    @PutMapping("{id}")
    private void updateUser(@RequestBody User myUser, @PathVariable Long id) {
    userRepository.save(myUser);

    }

    @DeleteMapping("{id}")
    private void deleteUser(@PathVariable Long id){
        userRepository.deleteById(id);
    }
}